@VppRequestSendEmail
Feature: To test request email update for vpp in AARP site
Scenario Outline: Verify request get email updates in AARP site
Given the user is on the AARP medicare site landing page
When the user performs plan search using following information in AARP site
| Zip Code    | <zipcode> |
| County Name | <county>  |
#And the user views plans of the below plan type in AARP site
#| Plan Type | <plantype> |
And the user selects the plan in AARP site
| Plan Type | <plantype> |
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |

Examples:
| zipcode | county             | plantype |  firstname | lastname | emailaddress |		 
| 90210   | Los Angeles County | MA       |  Eva        | Zhong     |weixin.zhong@optum.com|

