#!groovy
//original author: Brian Wyka
//modified for M&R by Olga Mackevica

// Global Variables
def pom, fullGitCommit, pipelineVersion
def credentialsId = 'c35e98d4-5b20-4607-854e-ddc6f0fd8ba4'
def codeHubRepoUrl = 'codehub.optum.com/consumer-portals/mratdd.git'
def gitBranch = "${env.BRANCH_NAME}"
def mvnParams = "-Dgit.branch=${gitBranch} -Dbuild.number=${env.BUILD_NUMBER} -Dbuild.time=${env.BUILD_TIMESTAMP} -Dgit.url=${codeHubRepoUrl}"
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
        node('docker-maven-slave') {
            unstash 'source'
            closure()
        }
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
    checkout([
        $class: 'GitSCM',
        branches: [
            [
                name: branch
            ]
        ],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [
            [
                credentialsId: credentialsId,
                url: "https://${codeHubRepUrl}"
            ]
        ]
    ])
}

/**
*Write build properties files to be used in subsequent jobs
*
* @param gitBranch
* @codeHubRepoUrl
* @gitBranch
*
*/
def writeBuildPropertiesFile(String gitBranch, String codeHubRepoUrl, String pipelineVersion){
        writeFile file: 'build.properties', text: "GIT_BRANCH=${gitBranch}\nSOURCE_BUILD_NUMBER=${env.BUILD_NUMBER}\nSOURCE_GIT_URL=${codeHubRepoUrl}\nSOURCE_JOB_NAME=${env.JOB_NAME}\nPIPELINE_VERSION=${pipelineVersion}"
            
        archiveArtifacts artifacts: 'build.properties', fingerprint: true
        
    }
	
/**
 * Enable retry of the closure with user input
 *
 * @param retryName - what is being retried
 * @param closure - the closure to retry
 */
def enableRetry(retryName, Closure closure) {
    timeout(time: 1, unit: 'DAYS') {
        waitUntil {
            try {
                closure()
                return true
            } catch(e) {
                echo "Error: ${e.getMessage()}"
                try {
                    input "Retry ${retryName}?"
                } catch (userClickedAbort) {
                    // User clicked Abort instead of proceed
                    throw userClickedAbort
                }
                return false
            }
        }
    }
}	

// Pipeline
node {

    stage('GiT Clone') {
        // Checkout source code from CodeHub branch
        performGitCheckout(gitBranch, credentialsId, codeHubRepoUrl)
        stash name: 'source'

        // Get POM version and set it as pipeline version
        pom = readMavenPom file: "${pomLocation}"
        fullGitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
        pipelineVersion = "${pom.version}-${env.BUILD_NUMBER}"

        // Set build display name and description
        currentBuild.displayName = pipelineVersion
        currentBuild.description = "Git commit: ${fullGitCommit.take(6)}"

        echo "Building version: ${pom.version} from commit: ${fullGitCommit}"
    }

    stage ('Build') {
        echo "Building source code"

        withDockerMavenSlave {
            unstash 'source'
            sh "mvn -f ${pomLocation} -U -B clean compile ${mvnParams}"
        }

        echo "Build complete"
    }
	

	stage('Deploy to Artifactory') {
			unstash 'source'

			// Deploy artifacts to Artifactory and archive them
			enableRetry('artifact deployment and archiving') {
				withUsernamePasswordCredentials(credentialsId, 'MAVEN_USER', 'MAVEN_PASS') {
					withDockerMavenSlave {
						sh "mvn -f ${pomLocation} clean deploy -B -Dci.env= -DskipTests -DskipITs ${mvnParams}"
						archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true							
					}
				}
			}
		}
	}