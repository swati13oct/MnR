#!groovy
import groovy.json.JsonSlurper
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;
node('docker-atdd-slave') {
	currentBuild.result="SUCCESS"
	def GIT_BRANCH="${env.BRANCH_NAME}"
	def MAVEN_VERSION="${env.MAVEN_VERSION}"
	def MAVEN_PATH="/tools/maven/apache-maven-${MAVEN_VERSION}/bin/mvn"
	def GIT_URL="https://codehub.optum.com/consumer-portals/mratdd.git"
	String BUILD_URL= "${env.BUILD_URL}"
	def PIPELINE_VERSION="1.0.${BUILD_NUMBER}-${GIT_BRANCH}"
	currentBuild.displayName = "${PIPELINE_VERSION}"
	String teamDL =  "";
	if(GIT_BRANCH=="upgradedATDD" || GIT_BRANCH=="theATeam")
	{
		teamDL = "UCP_TheATeam_DL@ds.uhc.com"
	}
	int totalCount = 0;
	int totalPassCount = 0;
	int totalfailedCount = 0;
	int totalSkippedCount = 0;
	int totalPendingCount = 0;
	int totalUndefinedCount = 0;
	String errorMsg = "";

	try {
		stage('Checkout') {
			git branch: "${GIT_BRANCH}", credentialsId: 'c35e98d4-5b20-4607-854e-ddc6f0fd8ba4', url:"${GIT_URL}"
		}

		stage('Build') {
			// Run the maven build
			sauce('bbbc3afb-4712-4005-8d1e-8392783ec4dc') {
				sh "${MAVEN_PATH} -f cukesatdd/pom.xml -Dbuild.time=${BUILD_TIMESTAMP} -Dbuild.number=${PIPELINE_VERSION} -Dgit.url=${GIT_URL} -Dgit.branch=${GIT_BRANCH} -U clean install test -Dtest=${RUNNER_NAME} -DfailIfNoTests=false -Denvironment=${ENVIRONMENT} -Dwebdriverhost=${WEBDRIVER_HOST} -Dphantomjs=${NODEJS_HOME}/bin/phantomjs -Dcucumber.options='--tags ${ATDD_TAGS} --plugin json:target/cucumber.json --plugin html:target/cucumber-${GIT_BRANCH}'"
			}
		}

	}
	catch (err) {
		currentBuild.result = "FAILURE"
				println "BUILD FAILED"
	}
	finally {
		try{
			stage('Archive Artifacts'){
				archiveArtifacts artifacts: '**/*cucumber*.json, **/*cucumber*/*.html,**/*cucumber*.pdf,', fingerprint: true
			}
			stage('Cucumber Report Publisher'){
				step([$class: 'CucumberReportPublisher', buildStatus: 'FAILURE', failedFeaturesNumber: 1, failedScenariosNumber: 1, failedStepsNumber: 1, fileExcludePattern: '', fileIncludePattern: '**/*.json', jenkinsBasePath: '', jsonReportDirectory: '/atdd/ATDD-test-project/${BUILD_NUMBER}/artifact/cukesatdd/target/', parallelTesting: false, pendingStepsNumber: 1, skippedStepsNumber: 1, trendsLimit: 0, undefinedStepsNumber: 1])
			}
			if( currentBuild.result == "FAILURE"){

				stage('Results'){
					String connectionURL = BUILD_URL+"artifact/cukesatdd/target/cucumber.json";
					URL url = new URL(connectionURL);
					InputStream urlStream = null;
					urlStream = url.openStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream));
					JsonSlurper jsonSlurper = new JsonSlurper();
					Object result = jsonSlurper.parse(reader);
					
					List<List<List<String>>> elementList =  null;
					
					if( null == result || null == result.elements)
					{
						println "results are not found" 
					}
					else
					{
						elementList = result.elements;
					}					

					if(null == elementList  || null == elementList.get(0))
					{
						errorMsg = "Error while generating reports.\n"  
					}
					else
					{				
						for(i=0;i<=elementList.size()-1;i++)
						{
							List<String> stepElementList =  result.elements[i].steps;
							for(j=0;j<=stepElementList.size()-1;j++)
							{
								List<String> statusList =  result.elements[i].steps[j].result.status;
								for(status in statusList){
									if(status=="passed"){
										totalPassCount++;
									}
									if(status=="failed"){
										totalfailedCount++;
									}
									if(status=="skipped"){
										totalSkippedCount++;
									}
									if(status=="pending"){
										totalPendingCount++;
									}
									if(status=="undefined"){
										totalUndefinedCount++;
									}
								}
							}
						}
					}
					totalCount=totalPassCount+totalfailedCount+totalSkippedCount+totalPendingCount+totalUndefinedCount;
				}

				stage('Notify'){
					emailext attachmentsPattern: '**/*cucumber*.pdf', 
					body: '''<h2>ATDD Test-Suite Run completed with following results:</h2><br><b>Project Name: MRATDD_'''+PIPELINE_VERSION+'''</b>
					'''+errorMsg+'''<p>
				<b>Total Steps:</b> '''+totalCount+'''<br>
				<b>Total Steps Passed:</b> '''+totalPassCount+'''<br>
				<b>Total Steps Failed:</b> '''+totalfailedCount+'''<br>
				<b>Total Steps Skipped:</b> '''+totalSkippedCount+'''<br>
				<b>Total Steps Pending:</b> '''+totalPendingCount+'''<br>
				<b>Total Steps undefined:</b> '''+totalUndefinedCount+'''<br>
				</p>

				<p><em><a href="'''+BUILD_URL+'''cucumber-html-reports/overview-features.html">Click here for the report for  further details</a>.</em></p>

				<p><em>Please see attached reports for further details.</em></p>

				''', subject: 'ATDD RUN Failed::'+PIPELINE_VERSION,
					to: emailextrecipients([[$class: 'CulpritsRecipientProvider'], [$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider'], [$class: 'UpstreamComitterRecipientProvider']])+";"+teamDL

				}
			}
		}
		catch (err) {
			throw err
		}

	}

}