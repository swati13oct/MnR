@MBlayerProviderSearch
Feature: To test Provider Search Flow  in UMS site
Scenario Outline: Verify Provider Search  in UMS site
Given the user is on the UMS medicare member site login page
When the user logs in with a registered AMP with following details in UMS site
| Plan Type   | <planType>   |
| Member Type | <memberType> |
Then the user click on providers button under my Resource Section 
Then the user navigate to Panel navigation and click on provider search in Blayer
Then the user navigate to Benefits and Coverage page and click on provider search Blayer
Then the user navigate to Benefits and Coverage page and click on provider search in PCP Section Blayer
Then the user navigate to Claims page and click on provider search  EOB Blayer
Then the user navigate to PHR  page and expand my Doctors and my Facility and click on provider search Blayer
Then the user navigate to Forms and Resources page and click on provider search Blayer

Examples:
| planType  | memberType| 
| MAPD-PHR        |Individual| 



