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
|Plan Name| <planName>|
And the user validates Need a step back in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
				

@rightRail
Scenario Outline: To validate chat now widget
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
 | PlanType | <planType> |
 Then the user navigates to pan details page	
 |Plan Name| <planName>|
And the user validates chat now widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
@rightRail		
Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates need more information widget in right rail widgets	
Examples:
		|zipCode|county						 |planType |planName					   |
		|90210  |Los Angeles County|MA       |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
@rightRail		
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site	
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |
Examples:
		|zipCode|county            |planType	|planName																						|  firstname  | lastname  | emailaddress |
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |	 Eva        | Zhong     |weixin.zhong@optum.com|
 
 @providerSearch
 Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|
And the user validates provider search page
Examples:
		|zipCode|county						 |planType  |planName					   |
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |
		
		
	@sprint5	
Scenario Outline: To validate need more information
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user navigated back using back to all plans
Examples:
		|zipCode|county						 |planType  |planName					   |
		|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |	
	
@planCost @US674468 @sprint5
Scenario Outline: To validate Plan Costs tab
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates plan details from DCE
Examples:
		|zipCode|county						 |planType  |planName					                                  |
   	|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Essential (HMO)  |
	#	|90201  |Los Angeles County|PDP       |AARP MedicareRx Walgreens (PDP) |
	
	@planCost @US674468	@sprint5
Scenario Outline: To validate Plan Documetns tab
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates plan Documents section
Examples:
		|zipCode|county						 |planType  |planName					                                  |
   	|90210  |Los Angeles County|MA        |AARP MedicareComplete SecureHorizons Essential (HMO)  |
	#	|90201  |Los Angeles County|PDP       |AARP MedicareRx Walgreens (PDP) |
	
@sprint5
	Scenario Outline: To validate Learn more
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates plan Learn more
Examples:
		|zipCode|county						 |planType   |planName					                                  |
   	|90210  |Los Angeles County|SNP        |AARP MedicareComplete SecureHorizons Essential (HMO)  |
	#	|90201  |Los Angeles County|PDP       |AARP MedicareRx Walgreens (PDP) |
	
	@US674467
	Scenario Outline: To validate optional services
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |	
Then the user navigates to pan details page
|Plan Name| <planName>|	
And user validates optional services
|Optional Dental|<optionalDenatl>|
|High Optional Dental|<highOptionalDental>|
Examples:
		|zipCode|county						 |planType   |planName					                                    |optionalDenatl|highOptionalDental|
   	|90210  |Los Angeles County|MA         |AARP MedicareComplete SecureHorizons Plan 1 (HMO)     |true          |true|
   	
@US706784  @msPlans
Scenario Outline: To validate optional services
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
Examples:
		|zipCode|county						     |planType   |planName					                                    |
		|99501  |Anchorage Municipality|MS         |AARP MedicareComplete SecureHorizons Plan 1 (HMO)     |
		   	
@US706736   	@msPlans
Scenario Outline: To validate optional services
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
Then the user navigates to pan details page
|Plan Name| <planName>|	
And the user validates header and footer
Examples:
		|zipCode|county						     |planType   |planName  |
		|99501  |Anchorage Municipality|MS         |Plan F    |
		|99501  |Anchorage Municipality|MS         |Plan G    |
		
@US706738  	@msPlans
Scenario Outline: To validate optional services
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user validates header and footer on plan summary page
Examples:
		|zipCode|county						     |planType   | 
		|99501  |Anchorage Municipality|MS         | 
		|99501  |Anchorage Municipality|MS         |
 