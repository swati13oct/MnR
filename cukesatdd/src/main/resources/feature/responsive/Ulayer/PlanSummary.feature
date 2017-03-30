@planSummaryPage
Feature: To vefify mobile responsive 
@fixed 
Scenario Outline: To validate plan highlights and provider searh link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
And the user validates plan highlight and provider search	
Examples:
		|zipCode|county            |planType|
		|90210  |Los Angeles County|MA      |	
		
Scenario Outline: To validate plan details link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |	
		
@portfolio
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then user validates county name on plan summary page
Examples:
|zipCode|county     |
|78006 |Bexar County|			

Scenario Outline: To validate need step back widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates Need a step back in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |	

Scenario Outline: To validate chat now widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates chat now widget in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |		 

Scenario Outline: To validate need more info widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates need more information widget in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |
		
Scenario Outline: To validate send email widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |  
	  
Examples:
		|zipCode|county            |planType	|  firstname | lastname | emailaddress |
		|90210  |Los Angeles County|PDP        |	 Eva        | Zhong     |weixin.zhong@optum.com|
		

@medsupp @aprilReleaseSprint4 @US501729
Scenario Outline: To view medsupp plan in VPP		
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MS        |
 

@aprilReleaseSprint4 @US501724 
Scenario Outline: To validate Integration with DST
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
 And the user validates navigates plan selector page and validates the contents	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |	
	#	|90210  |Los Angeles County|MS        |		
	
	@US501728	@aprilReleaseSprint4
	Scenario Outline: To validate provider search
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |	
And user navigates to provider search page
    | Plan Name |<planName>  |

Examples:
		|zipCode|county						 |planType|planName																						|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |	
		
@US557073
Scenario Outline: To validate remove plan in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user verify disclaimer text for MA/MAPD plan for plan compare page in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |



@US519614		
Scenario Outline: To validate plan view details in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user click plan view details link on compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		
		

@US519611
Scenario Outline: To validate remove plan in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user remove plan link on compare page in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
		
@US540565		
Scenario Outline: To validate footnote section in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user verify footnote section on compare page

Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |	


@US519614
Scenario Outline: To validate plan view details in vpp compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site
And the user click compare plans in AARP site
And the user click plan view details link on compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
    |90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |

@planSummaryPage1		
Scenario Outline: To validate Add to Compare Checboxes
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user select plan to compare in AARP site

Examples:
		|zipCode|county            |planType|planName 																					|
		|85001  |Maricopa County   |MA      |AARP MedicareComplete Plan 1 (HMO)  								|


@medicalbenefits
Scenario Outline: To validate medical benefits in compare page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user selects desired plan to compare
      |Plan 1|<planName1>|
      |Plan 2|<planName2>|
Then the user validates medical benefits
      |MP Plan1|<mpPlan1>|
      |MP Plan2|<mpPlan2>|
      |Oop Plan1|<oopPlan1>|
      |Oop Plan2|<oopPlan2>|      
Examples:
		|zipCode|county            |planType|planName1 											|planName2                                             |mpPlan1|mpPlan2|oopPlan1|oopPlan2|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |AARP MedicareComplete SecureHorizons Plan 2 (HMO)     |$0.00  |$0.00  |$4,600.00|$2,000.00|	

@planSummaryDce		
Scenario Outline: To validate Launch of DCE from MAPD
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    | Plan Name |<planName>  | 		    
 Examples:
		|zipCode|county						 |planType|planName																						  |
		|90210  |Los Angeles County|MAPD      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |

@planSummaryDce
Scenario Outline: To validate Launch of DCE from PDP
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    | Plan Name |<planName>  | 		
  
 Examples:
		|zipCode|county						 |planType|planName													 |
		|92010  |Los Angeles County|PDP      |AARP MedicareRx Walgreens (PDP)  | 
		
@US511662
Scenario Outline: To validate launch of enrollment page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And User click on Enroll in plan link on plan detail page
Examples:
		|zipCode|county            |planType|planName 																					|
    |90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
    |90210  |Los Angeles County|PDP      |AARP MedicareRx Preferred (PDP)  | 
    
   		
Scenario Outline: To validate enroll in plan onplan summary page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
Then the user clicks on Enroll in Plan link on Plan summary page
 |Plan Name|<planName>|
Examples:
		|zipCode|county            |planType|planName|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)|

@aprilReleaseSprint4 @US501732
Scenario Outline: To validate the Campaign Landing Page 
Given the user directly routes to Campaign page
		| Campaign Page |<campaignPage>|
		
Examples:

	|campaignPage|	
	|campaignPage1|
	|campaignPage2|
    


Scenario Outline: To validate plan details
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user validates the medical benefits tab,Prescription Drug Benefits tab,Optional Services tab on Plan details page    
Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		
		|33713  |Pinellas County		|MA      |AARP MedicareComplete (HMO)  |	

@aprilReleaseSprint5
Scenario Outline: To validate plan details
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And the user validates the medical benefits tab,Prescription Drug Benefits tab,Optional Services tab on Plan details page    
Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |		
		|33713  |Pinellas County		|MA      |AARP MedicareComplete (HMO)  |
@aprilReleaseSprint5
Scenario Outline: To validate DCE tool on plan details page
Given the user is on the vpp portfolio page
When the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
And the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
Then the user validates DCE tool on plan details page    
Examples:
		|zipCode|county            |planType|planName													|
  	|90210  |Los Angeles County|PDP    |AARP MedicareRx Walgreens (PDP)  |	
		|90210  |Los Angeles County|MA     |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |

 @aprilReleaseSprint5
Scenario Outline: To validate enroll in plan onplan summary page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
Then the user clicks on Enroll in Plan link on Plan summary page
 |Plan Name|<planName>|
Examples:
		|zipCode|county            |planType|planName|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)|
	
	@US511662 @aprilReleaseSprint5
Scenario Outline: To validate launch of enrollment page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
And User click on Enroll in plan link on plan detail page
Examples:
		|zipCode|county            |planType|planName 																					|
    |90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
    |90210  |Los Angeles County|PDP      |AARP MedicareRx Preferred (PDP)  | 
   
   @planSummaryDce @aprilReleaseSprint5
Scenario Outline: To validate Launch of DCE from PDP
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    | Plan Name |<planName>  | 		
  
 Examples:
		|zipCode|county						 |planType|planName													 |
		|92010  |Los Angeles County|PDP      |AARP MedicareRx Walgreens (PDP)  |
	
	@planSummaryDce	@aprilReleaseSprint5
Scenario Outline: To validate Launch of DCE from MAPD
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user clicks on Estimate drug link for the respetive plan
    | Plan Name |<planName>  | 		    
 Examples:
		|zipCode|county						 |planType|planName																						  |
		|90210  |Los Angeles County|MAPD      |AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |



@US501386 @aprilReleaseSprint1
Scenario Outline: To validate plan highlights and provider searh link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
And the user validates plan highlight and provider search	
Examples:
		|zipCode|county            |planType|
		|90210  |Los Angeles County|MA      |			
		 			
@aprilReleaseSprint1
Scenario Outline: To validate zip code widget functionality MA/PDP prospect
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
And verifies the zipcode on VPP page 
Examples:
		|zipCode|county     |
		|90210  |Los Angeles County|
@aprilReleaseSprint2
Scenario Outline: To validate plan highlights and provider searh link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |
And the user validates plan highlight and provider search	
Examples:
		|zipCode|county            |planType|
		|90210  |Los Angeles County|MA      |	
		|90210  |Los Angeles County|PDP     |
		|90210  |Los Angeles County|MAPD      |	
	@aprilReleaseSprint2	
Scenario Outline: To validate plan count from portfolio page
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then user validates plan count for all plan types on plan summary page in AARP site
Then user validates county name on plan summary page
Examples:
|zipCode|county     |
|78006 |Bexar County|			

	@aprilReleaseSprint2
Scenario Outline: To validate sticky zipcode functionality
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	| Plan Type | <planType> |	
And the user validates sticky zipcode
Examples:
		|zipCode|county            |planType|
		|90210  |Los Angeles County|MA      |	
@aprilReleaseSprint3
Scenario Outline: To validate plan details link
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user navigates to plan details page
    |Plan Name|<planName>|
Examples:
		|zipCode|county            |planType|planName 																					|
		|90210  |Los Angeles County|MA      |AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
@aprilReleaseSprint3		
Scenario Outline: To validate need step back widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates Need a step back in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |	

@aprilReleaseSprint3 	
Scenario Outline: To validate chat now widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates chat now widget in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |		 

@aprilReleaseSprint3
Scenario Outline: To validate need more info widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
And the user validates need more information widget in right rail widgets	  
	  
Examples:
		|zipCode|county            |planType	|
		|90210  |Los Angeles County|MA        |		 		 		
		
@aprilReleaseSprint3
Scenario Outline: To validate send email widget in right rail
Given the user is on the vpp portfolio page
Then the user performs plan serach using zipcode
		| Zip Code |<zipCode>|
		| County   |<county> |
Then the user navigates to the following plan type
	  | Plan Type | <planType> |
When the user moved to the email update widget in selected plan section in AARP site
And the user enter information to Get Email Update widget and submit in AARP site
| First Name| <firstname> |
| Last Name | <lastname>  |
| Email Address | <emailaddress> |  
	  
Examples:
		|zipCode|county            |planType	|  firstname | lastname | emailaddress |
		|90210  |Los Angeles County|PDP        |	 Eva        | Zhong     |weixin.zhong@optum.com|
			
				
 