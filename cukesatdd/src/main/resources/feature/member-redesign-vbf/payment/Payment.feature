@smokeTest
Feature: 1.11-VBF-MemRedesign-To test the payment history
@smokeTest_Payment @rallyDashboard @testharness
Scenario Outline: Validate that member view Payment history table
Given the user is on the Team-H AARP medicare site login page
When the user logs in TeamH with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates Premium Payment from Rally Dashboard Page
And User validates Premium Payment table
And the user navigates to Team H One Time Payments page
#And the user enters details and click on continue button on One Time Payments Page for Dashboard

Examples:
	| planType |
	| GroupRetireePayment      |
#	| AARPMapdInd      |
	| UhcMapdInd      |
