@planCompareTest
Feature: To test plan compare flow in AARP site
Scenario Outline: Verify Plan Benefit Comparison in AARP site
Given registered member for plan compare in AARP Site
	| <planType> |
When the user navigates to plan compare page in AARP site
And the user selects a plan from next year plan choice in AARP site
Then the user validates preferred network for next year in AARP site
 

 Examples:
	 | planType |
	 | PDP      |

Scenario Outline: Verify Plan Benefit Comparison in AARP site
Given registered member for plan compare in AARP Site
	| <planType> |
When the user navigates to plan compare page in AARP site
And the user selects a plan from next year plan choice in AARP site
Then the user validates preferred network for next year MAPD in AARP site


 Examples:
	 | planType |
	 | MAPD     |
	 
Scenario Outline: Verify Plan Benefit Comparison in AARP site
Given registered member for plan compare in AARP Site
	| <planType> |
When the user navigates to plan compare page in AARP site
And the user selects a plan from next year plan choice in AARP site
Then the user validates pharmacy saver for next year MAPD in AARP site


 Examples:
	 | planType |
	 | MAPD     |

##-Note : the PDP memeber used here is a AARP MedicareRx Preferred (PDP) plan member