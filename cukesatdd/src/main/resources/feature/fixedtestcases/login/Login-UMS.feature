@login
Feature: To test Login on UMS site 
Scenario Outline:To verify login in UHC site
Given the user is on the UHC medicare site login page
When the user logs in with a registered UMP with following details in UHC site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
Then verify that the tabs are displayed
And verify that links are displayed
And click on plan name link and my Plans-Summary page should be displayed
And click on back button in the browser and Home page should be displayed
And validate provider search not displayed for PDP and for other member, click on search for providers button and Provider search modal window should be displayed 
And click on back button in the browser and Home page should be displayed
And click on Drug lookup-estimate costs button and estimate my drug costs page should be displayed
And click on back button in the browser and Home page should be displayed
And click on locate a pharmacy button and Locate a pharmacy page should be displayed
And click on back button in the browser and Home page should be displayed
And click on View Personal Health Record button and My Personal Health Record page should be displayed
And click on back button in the browser and Home page should be displayed
And click on View Health & Wellness button and My Health and Wellness page should be displayed
And click on back button in the browser and Home page should be displayed

Examples:
	| planType | memberType |
	| PDP	   | Group		|
	| MA       | Individual |
