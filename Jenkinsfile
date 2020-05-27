#!groovy
//original author: Brian Wyka
//modified for M&R by Olga Mackevica          
// Global Variables    
def pom, fullGitCommit, pipelineVersion
def credentialsId = 'c35e98d4-5b20-4607-854e-ddc6f0fd8ba4'
def gitHubRepoUrl = 'https://github.optum.com/consumer-portals/mratdd.git'
def gitBranch = "${env.BRANCH_NAME}"
def mvnParams = "-Dgit.branch=${gitBranch} -Dbuild.number=${env.BUILD_NUMBER} -Dbuild.time=${env.BUILD_TIMESTAMP} -Dgit.url=${gitHubRepoUrl}"
def pomLocation = "cukesatdd/pom.xml"
/**
 * Run with java and maven version environment setup
 *
 * @param closure - the closure to execute
 */




def withJavaAndMaven(Closure closure) {
    withEnv(['JAVA_VERSION=1.7.0', "JAVA_HOME=${tool 'java'}", "PATH+MAVEN=${tool 'Maven'}/bin:${env.JAVA_HOME}/bin"]) {
        closure()
    }
}


/**
 * Run a closure on the docker-maven-slave with
 * java and maven environment configured
 *
 * @param closure - the closure to execute
 */
def withDockerMavenSlave(Closure closure) {
    withJavaAndMaven {
            unstash 'source'
            closure()
    }
}


/**
 * Run a closure with the given credentials
 *
 * @param credentialsId - the credentials id
 * @param usernameVariable - the username variable
 * @param passwordVariable - the password variable
 * @param closure - the closure to execute
 */
def withUsernamePasswordCredentials(credentialsId, usernameVariable, passwordVariable, Closure closure) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: usernameVariable, passwordVariable: passwordVariable)]) {
        closure()
    }
}

/**
 * Perform a git checkout for the respective branch
 *
 * @param branch - the branch to checkout
 * @param credentialsId - the credentials to authenticate
 * @param codeHubRepUrl - the CodeHub repository URL
 */
def performGitCheckout(branch, credentialsId, codeHubRepUrl) {
	git branch: branch, credentialsId: credentialsId, url: codeHubRepUrl
}
/**
* If this is release or hotfix branch, then replace pipeline version with version from branch name: last 3 digits in yy-majorVersion-hotfixversion format
*
* @param gitBranch - git branch
* return String 
*/
def updatePipelineVersion(String gitBranch, String pipelineVersion){
   def matcher = gitBranch ==~ /(RELEASE|HOTFIX)-\d{1,2}-\d{1,2}-\d{1,2}/
   echo "updatePipelineVersion matcher: ${matcher}"
   if(matcher){
		echo "Branch name matched RELEASE|HOTFIX-yy-d{1,2}-d{1,2}-d{1,2} name pattern pattern."
		def version = gitBranch.replaceAll(/(RELEASE|HOTFIX)-/,'')
		version = version.replaceAll(/\-/,".")
		pipelineVersion = "${version}-${env.BUILD_NUMBER}"
   } else if (gitBranch=="develop"){
	   echo "Branch name is develop. Use global Jenkins variable UCP_DEVELOP_RELEASE_VERSION to set version to ${UCP_DEVELOP_RELEASE_VERSION}"
	   pipelineVersion = "${UCP_DEVELOP_RELEASE_VERSION}-d${env.BUILD_NUMBER}"
   }
	echo "New version: ${pipelineVersion}"
	return pipelineVersion
}

/**
*Write build properties files to be used in subsequent jobs
*
* @param gitBranch
* @gitHubRepoUrl
* @gitBranch
*
*/
def writeBuildPropertiesFile(String gitBranch, String gitHubRepoUrl, String pipelineVersion){
	writeFile file: 'build.properties', text: "GIT_BRANCH=${gitBranch}\nSOURCE_BUILD_NUMBER=${env.BUILD_NUMBER}\nSOURCE_GIT_URL=${gitHubRepoUrl}\nSOURCE_JOB_NAME=${env.JOB_NAME}\nSOURCE_JOB_URL=${env.JOB_URL}\nPIPELINE_VERSION=${pipelineVersion}"
		
	archiveArtifacts artifacts: 'build.properties', fingerprint: true
}
	
// Pipeline
node('docker-maven-slave') {

    stage('GiT Clone') {
		
        // Checkout source code from CodeHub branch
        performGitCheckout(gitBranch, credentialsId, gitHubRepoUrl)
        stash name: 'source'

        // Get POM version and set it as pipeline version
        pom = readMavenPom file: "${pomLocation}"
        fullGitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
        pipelineVersion = "${pom.version}-${env.BUILD_NUMBER}"
		pipelineVersion = updatePipelineVersion(gitBranch, pipelineVersion)
		writeBuildPropertiesFile(gitBranch, gitHubRepoUrl, pipelineVersion)		

        // Set build display name and description
		currentBuild.displayName = "${pipelineVersion}"
        currentBuild.description = "Git commit: ${fullGitCommit.take(6)}"

        echo "Building version: ${env.BUILD_NUMBER} from commit: ${fullGitCommit}"
    }

    stage ('Build') {
        echo "Building source code"
       
		withDockerMavenSlave {
			unstash 'source'
			sh "mvn -f ${pomLocation} -U -B clean compile ${mvnParams}"
		}

		echo "Build complete"
			archiveArtifacts artifacts: '**/target/*.war , **/target/*.ear, **/build/*.zip, **/build_info.txt, **/build.properties, **/target/*pmd.xml', fingerprint: true
   
	}
		
      
    echo "Build complete"
	
	stage('Trigger Downstream TestSuite'){
		//trigger tests
		if("${env.BRANCH_NAME}" == "upgradedATDD"){
            build job: '/atdd/ATDD-DataLoad/', wait: false
		}
	}
}
