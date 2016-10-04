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
#	| PDP      |
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

Scenario Outline: verify menu details after login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
	| Menu Link   | <menuLink>  |
Then the user validates the preferred Mail service link in menu details

Examples:
	| planType |  menuLink                   |
	| PDP      |  Preferred Mail Service Link|
	
	
Scenario Outline: verify Quick links from footer after login in AARP site 
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
	| Menu Link   | <menuLink>  |
Then the user validates the order drugs from your preferred Mail Service pharmacy link in AARP site

Examples:
	| planType |  menuLink                   |
	| PDP      |  Preferred Mail Service Link|
