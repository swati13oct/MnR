@login
Feature: To test Login on AARP site 
Scenario Outline: Verify login in AARP site for MA or MAPD combo member having three plans  
Given registered AMP with following attributes
    | <planType1> |
    | <planType2> |
    | <planType3> |
When the user logs in successfully in AARP site
Then the user validates following plan details
   | Plan Name             |
   | Member Number         | 
   | Plan Status           |
   | Primary Care Provider |
Then the user validates following Federal plan Details of the three plan combo member
   | Plan Name             |
   | Member Number         | 
   | Plan Status           |
   | Primary Care Provider |

And the user validates following Ship plan Details of the three plan combo member
    | Plan Name             |
    | Member Number         | 
    | Plan Status           |

Examples:
    | planType1 | planType2 | planType3 |
  # | MAPD      | HIP       | RIDER     |
  # | MA        | MS        | HIP       |
  #  | MS        | HIP       | RIDER     |




Scenario Outline: Verify login in AARP site for PDP combo member having three plans
Given registered AMP with following attributes
	| PDP         |
    | <planType2> |
    | <planType3> |
When the user logs in successfully in AARP site
Then the user validates following plan details
   | Plan Name             |
   | Member Number         | 
   | Plan Status           |

Examples:
	 | planType2 | planType3 |
	 | MS        | Rider     |
#    | HIP       | Rider     |
#     | MS        | HIP       |


Scenario Outline: Verify login in AARP site for MA or MAPD combo members having two plans
Given registered AMP with following attributes
    | <planType1> |
    | <planType2> |
When the user logs in successfully in AARP site
Then the user validates following plan details
   | Plan Name             |
   | Member Number         | 
   | Plan Status           |
   | Primary Care Provider |

Examples:
    | planType1 | planType2 |
##    | MAPD      | HIP       |
#    |MAPD		| MS		|
##    | MA        | HIP       |
#    | MA        | MS		|
    


    
Scenario Outline: Verify login in AARP site for PDP combo members having two plans
Given registered AMP with following attributes
     | PDP |
     | <planType2> |
When the user logs in successfully in AARP site
Then the user validates following plan details
    | Plan Name            |
    | Member Number        |  
    | Plan Status          |
Examples:
    | planType2 |
  #  | MS        |
  # | HIP       |    
    
    
    
Scenario Outline: Verify login in AARP site for MA or MAPD member
Given registered AMP with following attributes
		|<planType>|	   
When the user logs in successfully in AARP site
Then the user validates following plan details
		| Plan Name             |
		| Member Number         | 
		| Plan Status           |
		| Primary Care Provider |

Examples:
		| planType |
#	    | MA       |
#		| MAPD     |    

		

Scenario: Verify login in AARP site for PDP Member 
Given registered AMP with following attributes
		| PDP |
When the user logs in successfully in AARP site
Then the user validates following plan details
		| Plan Name     |
		| Member Number | 
		| Plan Status   |		



Scenario Outline: Verify login in AARP site for ship plan members
Given registered AMP with following attributes
		| <shipPlanType> |
When the user logs in successfully in AARP site
Then the user validates following plan details
		| Plan Name       |
		| Member Number   | 
		| Plan Status     |
Examples:
		| shipPlanType |
#		| MS           |
#		| HIP          |
#		| Rider        |	



Scenario Outline: Verify login in AARP site for a terminated member greater than 12 months
Given registered AMP with following attributes
   | <planType>                    |
   | Term greater than 12 months   |
When the terminated member logs in successfully in AARP site
Then the user validates following terminated plan details
   

Examples:
   | planType |
#   | MA       |
#   | MS       |
#   | HIP      |
 #  | PDP      |
#   | MAPD     |


Scenario Outline: Verify login in aarp site for a terminated member less than 12 months
Given registered AMP with following attributes
	| <planType>               |
	| term less than 12 months |
When the terminated member logs in successfully in AARP site
Then the user validates following terminated plan details
 
Examples:
   | planType |
#  | MA       |
#   | MS       |
#  | HIP      |
  | PDP      |
#  | MAPD     |
 
 
Scenario Outline: Verify login in aarp site for a terminated combo member less than 12 months
Given registered AMP with following attributes
	| <planType1> |
	| <planType2> |
	|term less than 12 months|
When the user logs in successfully in AARP site
Then the user validates following plan details
  | Plan Name             |
  | Member Number         |
  | Plan Termination Date |
Examples:
   | planType1 | planType2 |
#   | PDP       | HIP       |
#   | MA        | HIP       |