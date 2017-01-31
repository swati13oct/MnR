@fixedTestCase
Feature: To test enroll in plan on AARP site 
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  PDP member
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
               | Zip Code    | <zipcode> |
               | County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
               | Plan Type | <planType> |
And the user enrolls for the below plan in AARP site
               | <planName> |
Examples:
|zipcode |countyName          | planType  | planName                       |
|90210   |Los Angeles County  | PDP       |AARP MedicareRx Preferred (PDP) |

Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  PDP member 2
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
               | Zip Code    | <zipcode> |
               | County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
               | Plan Type | <planType> |
And the user enrolls for the below plan in AARP site
               | <planName> |
Examples:
|zipcode |countyName          | planType  | planName                       |
|90210   |Los Angeles County  | PDP       |AARP MedicareRx Preferred (PDP) |