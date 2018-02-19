@planCompareTest
Feature: To test plan compare flow in AARP site
Scenario Outline: Verify Plan Benefit Comparison in AARP site
Given registered member for plan compare in AARP Site
	| <planType> |
When the user navigates to plan compare page in AARP site
Then the user validates plan benefits for the same plan in current year and next year in AARP site
And the user selects a plan from next year plan choices dropdown in AARP site
	| <planChoice> |
Then the user validates plan benefits for the plans in current year and next year in AARP site
 

 Examples:
	 | planType | planChoice			|
	 | MA       | AARP MedicareComplete Choice Essential (PPO)	|

##-Note : the PDP memeber used here is a AARP MedicareRx Preferred (PDP) plan member