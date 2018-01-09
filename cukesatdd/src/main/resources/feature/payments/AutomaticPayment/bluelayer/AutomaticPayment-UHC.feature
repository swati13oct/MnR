@US458904
Feature: To test the payment flow on UHC site 
Scenario Outline: Verify Set Up New Automatic Payments button
Given registered UMS with a planType member in UMS site
 	| Member Type| <memberType>  |
And the user navigates to TestHarness Page
 
Examples:
| member Type  |
|MA|
