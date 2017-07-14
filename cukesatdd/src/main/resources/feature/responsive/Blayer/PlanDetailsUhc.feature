 @planDetailUhc
Feature: To verify mobile responsive for plan details page
 @rightRail		
Scenario Outline: To validate Need a step back from right rail
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |		
Then the user navigates to pan details page
And the user validates Need a step back in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
				

@rightRail
Scenario Outline: To validate chat now widget
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
 | PlanType | <planType> |
 Then the user navigates to pan details page	
And the user validates chat now widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
@rightRail		
Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
And the user validates need more information widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|33012  |Los Angeles County|SNP      |Miami-Dade County    |
		
@rightRail		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site	
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |
Examples:
		|zipCode|county            |planType	|  firstname | lastname | emailaddress |
		|90210  |Los Angeles County|PDP        |	 Eva        | Zhong     |weixin.zhong@optum.com|
 