@fixedTestCaseTest
@agentAppointment
Feature: To test request an appointment with an agent flow in UHC site
@ebrc-UHC
Scenario Outline: Verify request an appointment with an agent flow in UHC site
Given the user is on the UHCM site landing page
When the user navigates to request more help and information in UHC site
Then the user navigates to request appointment with an agent in UHC site and validates page loaded
	| Place Holder | <placeHolder>|
Examples:
	| placeHolder | 
	| none       | 
