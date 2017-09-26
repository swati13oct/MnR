@login
Feature: To test Login on AARP site 
Scenario Outline: Verify login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
Then the user validates plan and member details after login in AARP site

Examples:
	| planType |
	| MAPD     |
#	| MA       |
	| PDP      |
#	| MS       |
#	| HIP      |
	
	
Scenario Outline: Verify login in AARP site for combo member having three plans  
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
  | Plan Type 1 | <planType1> |
  | Plan Type 2 | <planType2> |
  | Plan Type 3 | <planType3> |
Then the user validates plan and member details after login in AARP site

Examples:
   | planType1 | planType2 | planType3 |
#   | MAPD      | HIP       | RIDER     |
#   | MA        | MS        | HIP       |
#   | MS        | HIP       | RIDER     |
#   | PDP       | HIP       | RIDER     |
#   | PDP       | MS        | HIP       |
  	
Scenario Outline: Verify login in AARP site for combo members having two plans
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
  | Plan Type 1 | <planType1> |
  | Plan Type 2 | <planType2> |
Then the user validates plan and member details after login in AARP site

Examples:
    | planType1 | planType2 |
#    | MAPD      | HIP       |
#    | MAPD		| MS		|
#    | MA        | HIP       |
#    | MA        | MS		|
#    | PDP       | MS        |
#    | PDP       | HIP       |

Scenario Outline: Verify login in AARP site for a terminated member greater than 12 months
Given the user is on the AARP medicare site login page
When the terminated user logs in with a registered AMP with following details in AARP site
 |  Plan Type           | <planType>                    |
 |  Termination Period  | Term greater than 12 months   |
Then the user validates terminated plan details
Examples:
   | planType |
#   | MA       |
#   | MS       |
#   | HIP      |
#   | PDP      |
#   | MAPD     |

Scenario Outline: Verify login in aarp site for a terminated member less than 12 months
Given the user is on the AARP medicare site login page
When the terminated user logs in with a registered AMP with following details in AARP site
   |  Plan Type           | <planType>                    |
   |  Termination Period  | term less than 12 months |
Then the user validates terminated plan details
Examples:
   | planType |
#   | MA       |
#   | MS       |
#   | HIP      |
#   | PDP      |
#   | MAPD     |



Scenario Outline:To verify Print a temporary card IDCard in chunky footer in AARP site
Given the user is on the AARP medicare site login page
#When the user logs in with a registered AMP with following details in AARP site
	|  Plan Type           | <planType>                    |
#Then the user validates temp id card after login in AARP site

Examples:
   | planType |
   | PDP      |


Scenario Outline: Verify login in aarp site for a terminated combo member less than 12 months
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type 1        | <planType1>              |
	| Plan Type 2        | <planType2>              |
	| Termination Period | term less than 12 months |
Then the user validates plan and member details after login in AARP site

Examples:
   | planType1 | planType2 |
#   | PDP       | HIP       |
#   | MA        | HIP       |


Scenario Outline: Verify Error messages in aarp member site for combo members
Given the user is on the AARP Ulayer site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type 1        | <planType1>              |
Then the user validates multiple email address page
Then User selects different mail option and clicks on continue to validate error messages

Examples:
   | planType1 |
   | COMBO |

@US621820
Scenario Outline: Verify confirmation page for different Email option selected button
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type 1        | <planType1>    |
Then the User clicks moves to test harness page and clicks on go to Multiple Email Address Page
Then User selects different mail option and validates the confirmation page

Examples:
   | planType1 |
   | COMBO |


@US621796
Scenario Outline: Verify confirmation page for different Email option selected button
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type 1        | <planType1>    |
Then the User clicks moves to test harness page and clicks on go to Multiple Email Address Page
Then User selects Radio button for available mail address option and validates the confirmation page

Examples:
   | planType1 |
   | COMBO |


@US621839
Scenario: Verify Error messages in aarp member site for multiple Email address page
Given the user is on the multipleEmailAddressPage and clicks on continue

@US621839
Scenario: Verify Error messages in aarp member site for multiple Email address page
Given the user is on the multipleEmailAddressPage and enters invalid email address

@US621839
Scenario: Verify Error messages in aarp member site for multiple Email address page
Given the user is on the multipleEmailAddressPage and enters does not enters same email address

@US620213
Scenario Outline: Verify confirmation page for No email address page
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type 1        | <planType1>    |
Then the User clicks moves to test harness page and clicks on go to No Email Address Page
Then User enters new email address and validates the confirmation page

Examples:
   | planType1 |
   | MAPD |