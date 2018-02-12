@VppWidgets
Feature: To test widget on vpp in AARP site

Scenario Outline: Verify need help chat widget in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
| Zip Code    | <zipcode> |
| County Name | <county>  |
And the user selects the plan in AARP site
| Plan Type | <plantype> |
And the user validates need help chat widget in AARP site
 

Examples:
| zipcode | county             | plantype |  
| 90210   | Los Angeles County | MA       |  

Scenario Outline: Verify meet with an agent widget in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
| Zip Code    | <zipcode> |
| County Name | <county>  |
And the user selects the plan in AARP site
| Plan Type | <plantype> |
And the user validates meet with an agent widget in AARP site
 

Examples:
| zipcode | county             | plantype |  
| 90210   | Los Angeles County | MA       |  

Scenario Outline: Verify need more info in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
| Zip Code    | <zipcode> |
| County Name | <county>  |
And the user selects the plan in AARP site
| Plan Type | <plantype> |
And the user validates need more info widget in AARP site
 

Examples:
| zipcode | county             | plantype |  
| 90210   | Los Angeles County | MA       |  

Scenario Outline: Verify step back widget in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
| Zip Code    | <zipcode> |
| County Name | <county>  |
And the user selects the plan in AARP site
| Plan Type | <plantype> |
And the user validates step back widget in AARP site
 

Examples:
| zipcode | county             | plantype |  
| 90210   | Los Angeles County | MA       |  

