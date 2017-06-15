@planSummaryPage
Feature: To verify mobile responsive 
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
#Then user validates county name on plan summary page
Examples:
|zipCode|county          |planType |
|33012 |Miami-Dade County| SNP     |

@planhighlights
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates plan highlights
Examples:
|zipCode|county          |planType |
|33012 |Miami-Dade County| SNP     |

@enrollPlan
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And User click on Enroll in plan link on plan detail page
|PlanName|planName|
Examples:
|zipCode|county          |planType |planName|
|33012 |Miami-Dade County| MA     |Preferred Choice Dade (HMO) |

	

		
