@agentAppointment
@fixedTestCaseTest
Feature: To test request an appointment with an agent flow in AARP site
@ebrc-AARP
Scenario Outline: Verify request an appointment with an agent flow in AARP site
Given the user is on the AARP acquisition site landing page
When the user navigates to request more help and information in AARP site
Then the user navigates to request appointment with an agent in AARP site and validates page is loaded
	|Place Holder| <placeHolder>|
Examples:
	| placeHolder | 
	| none       |
	