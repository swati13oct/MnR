#!groovy
import groovy.json.JsonSlurper
import groovy.io.FileType
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths; 


String nodeSlave= 'docker-maven-slave';


node(nodeSlave) {
	currentBuild.result="SUCCESS"
	def GIT_BRANCH="${env.BRANCH_NAME}"
	def MAVEN_VERSION="${env.MAVEN_VERSION}"
	def MAVEN_PATH="/tools/maven/apache-maven-${MAVEN_VERSION}/bin/mvn"
	def GIT_URL="https://github.optum.com/gov-prog-digital/mratdd.git"
	String BUILD_URL= "${env.BUILD_URL}"
	def PIPELINE_VERSION="1.0.${BUILD_NUMBER}-${GIT_BRANCH}-${ENVIRONMENT}"
	currentBuild.displayName = "${PIPELINE_VERSION}"
	String BUILD_CAUSE_JSON = sh (script: "curl --silent ${BUILD_URL}/api/json | tr '{}' '\n' | grep 'Started by'",       returnStdout: true   ).trim()
	echo "BUILD_CAUSE_JSON: ${BUILD_CAUSE_JSON}"
	String BUILD_USER_ID=new groovy.json.JsonSlurper().parseText("{${BUILD_CAUSE_JSON}}").userId
	echo "BUILD_USER_ID: ${BUILD_USER_ID}"
	String teamDL =  "";

	teamDL = "GPDigital_E2E_Automation_QE@ds.uhc.com"

														 

	int totalCount = 0;
	int totalPassCount = 0;
	int totalfailedCount = 0;
	int totalSkippedCount = 0;
	int totalPendingCount = 0;
	int totalUndefinedCount = 0;
	String errorMsg = "";
	String jobStatus = "FAILED"

	int scenarioPassed = 0;
	int scenarioFailed = 0;
	int totalScenarioCount = 0;
							 
								
										  
	String oldScenarioName ="";
	//String xmlSuite = "${SUITE_NAME}";
	String apps  = "${MICRO_APP}";
	String tags = "${TAGS}";
	//String[] appArray = apps.split(",");

	// if the job kicks off with timer, micro apps variable will be empty and by default it will pick up all microapp runners
	if(BUILD_USER_ID==null){
		apps = ""; 
	}


	try {
		stage('Checkout') {
			git branch: "${GIT_BRANCH}", credentialsId: '603efe34-7b74-4e26-8ef8-5273f07139ae', url:"${GIT_URL}"
		}

		stage('Build') {
			// Run the maven build

			sauce('52019e98-8af1-474b-a681-2464d449d86a') {
				
				sh "${MAVEN_PATH} -f cukesatdd/pom.xml -Dbuild.time=${BUILD_TIMESTAMP} -Dbuild.number=${PIPELINE_VERSION} -Dgit.url=${GIT_URL} -Dgit.branch=${GIT_BRANCH} -U clean install verify -Dfailsafe.suiteXmlFiles=testng.xml -Dtestnames=Desktop -Dmicroapp=${apps} -Dcucumber.filter.tags=\"${tags}\" -DfailIfNoTests=false -Denvironment=${ENVIRONMENT} -Dwebdriverhost=${WEBDRIVER_HOST} -Dbrowsername=${BROWSER_NAME} -Dsaucelabstunnel=${SAUCELABS_TUNNEL} -DDEVICE_OS_VERSION=${DEVICE_OS_VERSION} -DDEVICE_OS_NAME=${DEVICE_OS_NAME} -DMOBILE_DEVICE_TYPE=${MOBILE_DEVICE_TYPE} -DAPPIUM_VERSION=${APPIUM_VERSION}"
				
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
				archiveArtifacts artifacts: '**/*cucumber*.json, **/*cucumber*/*.html,**/*cucumber*-merged.pdf,**/version.txt, **/target/*pmd.xml', fingerprint: true
			}
			stage('Cucumber Report Publisher'){
				//step([$class: 'CucumberReportPublisher', buildStatus: 'FAILURE', failedFeaturesNumber: 1, failedScenariosNumber: 1, failedStepsNumber: 1, fileExcludePattern: '', fileIncludePattern: '**/*.json', jenkinsBasePath: '', jsonReportDirectory: '/${BUILD_NUMBER}/artifact/cukesatdd/target/', parallelTesting: true, pendingStepsNumber: 1, skippedStepsNumber: 1, trendsLimit: 0, undefinedStepsNumber: 1])
				cucumber buildStatus: 'FAILURE', failedFeaturesNumber: 1, failedScenariosNumber: 1, failedStepsNumber: 1, fileIncludePattern: '**/cucumber-*.json', jsonReportDirectory: '', pendingStepsNumber: 1, skippedStepsNumber: 1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: 1
				step([$class: 'Publisher', reportFilenamePattern: '**/target/failsafe-reports/testng-results.xml'])
			}
			stage('PMD'){
				step([$class: 'PmdPublisher', canComputeNew: false, canRunOnFailed: false, defaultEncoding: 'UTF-8', healthy: '', pattern: '**/target/*pmd.xml', unHealthy: ''])
			}

			stage('Results'){
				def files = findFiles(glob: 'cukesatdd/target/cucumber-*.json')
				for (file in files) {
					println "File Name " + file.name;
					String runnerName = file.name.split("-")[1].split("\\.")[0];
					println "Runner Name::::"+runnerName;
					println "Processing file at ${file.path}"

												 
												 
													 
					//String jsonPath = ${file.path};
					String jsonPath = BUILD_URL+"artifact/${file.path}";
					URL url = new URL(jsonPath);
					oldScenarioName = "";
					JsonSlurper jsonSlurper = new JsonSlurper();
					Object results = jsonSlurper.parse(url);

					for(result in results)
					{
						if(null !=  result && null != result.elements  &&  null !=result.elements.get(0))
						{
							for(element in result.elements)
							{
								int elementFailed=0;
								int elementPassed=0;


								if(null != element && (null != element.steps))
								{
									for(step in element.steps)
									{
										if(null != element && (null != element.steps))
										{
											def status = step.result.status;
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
										else{
											errorMsg = "Error while generating mail reports.\n"
										}
									}
								}
								else{
									errorMsg = "Error while generating mail reports.\n"
								}

								if (null != element && (null != element.type) && (element.type=="scenario")) {
									if  (null != element.steps)  {
										int stepsPassed=0;
										int stepsFailed=0;
										String currentScenarioName = element.name;
																																																	 
																		   
										println "currentScenarioName::" + currentScenarioName;
										println "oldScenarioName::" + oldScenarioName;
										for (resultScenario in element.steps) {
											def stepStatus = resultScenario.result.status;

											if (stepStatus == "passed") {
												println "stepStatus Passed";
												stepsPassed++;
											} else if (stepStatus == "failed") {
												println "stepStatus Failed";
												stepsFailed++;
												break;
											}
										}
										if (currentScenarioName != oldScenarioName) {
											if (stepsFailed > 0) {
												elementFailed++;
											} else if (stepsPassed > 0 && stepsFailed == 0) {
												elementPassed++;
											}
										} else {
											if (stepsPassed > 0 && stepsFailed == 0) {
												elementFailed--;
												elementPassed++;
											}
										}

										oldScenarioName = currentScenarioName;

		  
										scenarioPassed = scenarioPassed + elementPassed;
										scenarioFailed = scenarioFailed + elementFailed;
									}

								}



							}
						}
						else{
							errorMsg = "Error while generating mail reports.\n"
						}

					}
					totalCount=totalPassCount+totalfailedCount+totalSkippedCount+totalPendingCount+totalUndefinedCount;
					println "totalPassCount::"+totalPassCount;
					println "totalfailedCount::"+totalfailedCount;
					println "totalSkippedCount::"+totalSkippedCount;
					println "totalPendingCount::"+totalPendingCount;
					println "totalUndefinedCount::"+totalUndefinedCount;
					println "totalCount::"+totalCount;

					totalScenarioCount= scenarioPassed + scenarioFailed;
					println "Total Scenario Passed::"+ scenarioPassed;
					println "Total Scenario Failed::"+ scenarioFailed;
					println "Total Scenario Count::"+totalScenarioCount;

					if(scenarioPassed == totalScenarioCount)
					jobStatus = "PASSED"
																		 
																																								 
			
	 
																		 
																		 
																		 
																		 

	 
	 
																					
																				   
	 
									  
					 
					  
											 
											  
																			  
					   
							 
											  
																			   
				}
					 
															   
																			   

					 
																																																						  
																																				 
																																				 
					 
																				  
																			 
																			 
																																																		  
					
																																						
						   
			}

	

			stage('Notify'){
				emailext attachmentsPattern: '**/*-merged.pdf,**/version.txt',
				body: '''<h2>ATDD Test-Suite Run completed with following results:</h2><br><b>Project Name: MRATDD_'''+PIPELINE_VERSION+'''</b>
				'''+errorMsg+'''<p>
				   <b>TotalScenarioCount:</b> ''' +totalScenarioCount+'''<br>
				 <b style="color:green;">Total Scenario Passed:</b> '''+ scenarioPassed + '''<br>
					 <b style="color:red;">TotalScenario Failed:</b> ''' + scenarioFailed + '''<br>

		 
			</p>

			<p><em><a href="'''+BUILD_URL+'''cucumber-html-reports/overview-features.html">Click here for cucumber-reports for further details</a>.</em></p>

				<p><em>Please see attachments for the versions of artifacts deployed and PDF reports for further details.</em></p>

				''', subject: 'ATDD  RUN '+jobStatus+ ' for ${JOB_BASE_NAME}::'+PIPELINE_VERSION,
				to: teamDL

			}

		}
		catch (err) {
			errorMsg = "Error while generating mail reports.\n"
			stage('Notify'){
				emailext attachmentsPattern: '**/*-merged.pdf,**/version.txt',
				body: '''<h2>ATDD Test-Suite Run completed with following results:</h2><br><b>Project Name: MRATDD_'''+PIPELINE_VERSION+'''</b>
						'''+errorMsg+'''<p>
			  <b>TotalScenarioCount:</b> ''' +totalScenarioCount+'''<br>
			 <b style="color:green;">Total Scenario Passed:</b> '''+ scenarioPassed + '''<br>
		 <b style="color:red;">TotalScenario Failed:</b> ''' + scenarioFailed + '''<br>

					</p>
	
					<p><em><a href="'''+BUILD_URL+'''cucumber-html-reports/overview-features.html">Click here for cucumber-reports for further details</a>.</em></p>

				<p><em>Please see attachments for the versions of artifacts deployed and PDF reports for further details.</em></p>

				''', subject: 'ATDD  RUN Failed for ${JOB_BASE_NAME}::'+PIPELINE_VERSION,
				to: teamDL+";"

			}
		}

	}
	String taskStatus = "Failed"
	
	int s = 0
	if (retrytotalScenarioCount > 0)
	{ 
		s =  (retryscenarioPassed/retrytotalScenarioCount) * 100 
		if(s >= 90)
			taskStatus = "Passed"
	}	  
	//String taskDetails = totalPassCount+" of "+totalCount+" Passed"
	 String taskDetails =  "Passed " + s + "%"										  
	String taskReportInfo = BUILD_URL+"cucumber-html-reports/overview-features.html"
	Date stop = new Date()
	TimeDuration td = TimeCategory.minus( stop, start )
	print "Script Execution Duration :::::: "+td
	print "Script Start Time :::::::  "+start
	print "Script End Time ::::::::  "+stop		
	int duration = td.getMinutes()
	td = null		
	print "Script Execution Duration in minutes ::::  "+duration
	
	def testingTaskRequestBody = """
								{
								   "taskName": "Full Regression Test",    
								   "taskStatus": "${taskStatus}",     
								   "taskDetails": "${taskDetails}",
								   "runDuration" :  ${duration},             
								   "taskReportInfo": "${taskReportInfo}",
								   "teamName": "Digital Destroyers",
								   "formatedId": "${jobName}"
								}
								"""
	echo "testingTaskRequestBody  ::::  "+testingTaskRequestBody
	response = null
	Boolean isServiceFailed = false
	try{	
	  echo "Calling Testing Task Duration Service :::::"	  
	  def response = httpRequest acceptType: 'APPLICATION_JSON', consoleLogResponseBody: true, contentType: 'APPLICATION_JSON', httpMode: 'POST', ignoreSslErrors: true, requestBody: testingTaskRequestBody, responseHandle: 'NONE', url: 'http://dashboard-api-acq-devops-core.origin-elr-core-nonprod.optum.com/api/updateTestingTask'
	  echo "Response : "+response.status
	  if(response.status != 200){
			echo "Dashbord Testing Task POST service Failed " +response
			isServiceFailed = true
			emailBody = emailBody + '''<p><span style="color:red;">Dashbord Testing Task Service Failed</span> -'''+response+'''</p>'''
	  }
	}
	catch(err){
		echo "Error while calling Dashbord Testing Task POST service ::: "+err
		isServiceFailed = true	
	}
	if(isServiceFailed == true){
		emailext attachLog: true,
		body: '<h3><span style="color:red;"> DASHBORD POST SERVICE REQUEST FAILED</span></h3><br/>http://dashboard-api-acq-devops-core.origin-elr-core-nonprod.optum.com/api/updateTestingTask - Service Failed <br> in ${JOB_NAME}', 
		subject: 'URGENT ACTION NEEDED - DASHBORD TESTING TASK POST SERVICE REQUEST FAILED',
		recipientProviders: [[$class: 'RequesterRecipientProvider']],
		to: 'nagarjuna.nellutla@optum.com'	
	}

}
