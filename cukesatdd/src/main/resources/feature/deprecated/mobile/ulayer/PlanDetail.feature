@plandetail
Feature:To test plan drug details page on AARP site in mobile
#Scenario Outline:Verify Plan Drug Details in AARP site for members in mobile
#Given the user is on the AARP medicare site login page
#When the user logs in with a registered AMP with following details in AARP site
#	| Plan Type   | <planType>  |
#And the user navigates to benefits and coverage details page on annual deductible stage
#And the user navigates to benefits and coverage details page with the initial coverage stage
#And the user navigates to benefits and coverage details page with the coverage gap stage
#And the user navigates to benefits and coverage details page with the catastrophic coverage stage
#Then the user validates plan and member details on benefits details page in AARP site 

#Examples:
#	| planType |
#	| MAPD     |

Scenario Outline:Verify Plan Drug Details in AARP site for members in mobile
Given the user is on the AARP medicare site login page
When the user logs in with a registered AMP with following details in AARP site
	| Plan Type   | <planType>  |
And the user navigates to preferred drug details page on annual deductible stage
And the user navigates to preferred drug details page with the initial coverage stage
And the user navigates to preferred drug details page with the coverage gap stage
And the user navigates to preferred drug details page with the catastrophic coverage stage
Then the user validates plan and member details on benefits details page in AARP site 

Examples:
| planType |
| PDP		|


@Ship
Scenario Outline: Verify Ship benefit details under Hospital stay benefit
Given the user is on the AARP medicare site login page
When the user logs in with a registered Ship member with following details in AARP site
| Plan Type   | <planType>  |	
And user clicks on view detials button Benefit Page and clicks on hospital link
And the user view hospital benefit
Examples:
| planType |
| SHIP     |

@Shipmedicalcare
Scenario Outline: Verify Ship benefit details under medical care benefit
Given the user is on the AARP medicare site login page
When the user logs in with a registered Ship member with following details in AARP site
| Plan Type   | <planType>  |	
And user clicks on view detials button Benefit Page for medical care and clicks on medical care link
And the user view medical care benefit
Examples:
| planType |
| SHIP     |

@Shipskilled
Scenario Outline: Verify Ship benefit details under Skilled nursing facility stays benefit
Given the user is on the AARP medicare site login page
When the user logs in with a registered Ship member with following details in AARP site
| Plan Type   | <planType>  |	
And user clicks on view detials button and click on skilled nursing benefit
And the user view skilled facility benefit
Examples:
| planType |
| SHIP     |
