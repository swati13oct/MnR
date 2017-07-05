@MUlayerProviderSearch
Feature: To test Provider Search Flow  in AARP site in Member
Scenario Outline: Verify Provider Search  in AARP site in Member 
Given the user is on the AARP Member medicare site loginn page
When the user logs in with a registered AMP with following details in AARP sites
|<planType>|
Then the user click on  providers button on the Plan Summary page
Then the user navigate to Panel navigation and click on provider search
Then the user navigate to Plan Summary page  and click on provider search
Then the user navigate to Benefits and Coverage page and click on provider search
Then the user navigate to Benefits and Coverage page and click on provider search in PCP Section 
Then the user navigate to Claims page and click on provider search
Then the user navigate to Forms and Resources page and click on provider search 
Then the user navigate to PHR  page and expand my Doctors and my Facility and click on provider search


Examples:
| planType  |
| MAPD      |