@RallytoolUHCSAcquisition
Feature:To launch Rally tool from UHC Acquisition Pages
Scenario:Rally Connect Tool should be launched from MA Enrollment Information Tab
Given user navigates to MA Enrollment Information Tab of Blue Layer Acquisition site
And click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up


Scenario:Rally Connect Tool should be launched from MA PLAN INFORMATION AND FORMS
Given user navigates to MA PLAN INFORMATION AND FORMS of Blue Layer Acquisition site
And click on the Look up my provider link on MA PLAN INFORMATION AND FORMS and rally tool opens up

Scenario: To Verify Rally tool from B-Layer Acquisition  
Given the user is on the UHC Medicaresolutions Home page
When user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
Then user clicks on the Search for Provider/Facility link and site opens new provider search tool in a new window

@Q2
Scenario Outline:Verify Rally link from VPP: ALL PLANS IN YOUR AREA – SNP TAB
Given user navigates to the UHC Home Page
And user performs plan search using following information in UHC site
	| Zip Code    | <zipcode>|
	| County Name	  |<county>|
When user views plans of the below plan type in UMS site
| Plan Type | <plantype> |
Then user validates plan count for all plan types on plan summary page in UMS site
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
| Plan Name | <planName> |
And the user clicks on Is my doctors covered link in UHC site and site opens Rally Connect in a new window
Examples:
|zipcode|  county             | plantype  | planName                                               |
|33012  | Miami-Dade County   | SNP       | UnitedHealthcare Nursing Home Plan (PPO SNP)           |             						        
#| 78006 | Comal County        | SNP       |  Care Improvement Plus Gold Rx (Regional PPO SNP)      |
#|33012  | Miami-Dade County   | SNP       | UnitedHealthcare Nursing Home Plan (PPO SNP)           |
#|80002  | Jefferson County    | SNP       | UnitedHealthcare Assisted Living Plan (PPO SNP)        |
#|90210  | Los Angeles County  | MA        | AARP MedicareComplete SecureHorizons Plan 3 (HMO)      |

@Q3
Scenario Outline:Verify Rally link from VPP: MA - Plan Details page
Given user navigates to the UHC Home Page
And user performs plan search using following information in UHC site
	| Zip Code    | <zipcode>|
	| County Name	  |<county>|
When user views plans of the below plan type in UMS site
| Plan Type | <plantype> |
Then user validates plan count for all plan types on plan summary page in UMS site
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
And the user clicks on Is my doctors covered link on Plan Details page in UHC site and site opens Rally Connect in a new window
Examples:
 |zipcode|  county             | plantype  | planName                                               |
 |80002  | Adams County | MA        | AARP MedicareComplete SecureHorizons Plan 2 (HMO)      |
 
@Q4 
Scenario Outline:Verify Rally link from VPP: SNP - Plan Details page
Given user navigates to the UHC Home Page
And user performs plan search using following information in UHC site
| Zip Code    | <zipcode>|
| County Name	  |<county>|
When user views plans of the below plan type in UMS site
| Plan Type | <plantype> |
Then user validates plan count for all plan types on plan summary page in UMS site
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
And the user clicks on IS MY DOCTORS covered link on Plan Details page in UHC site and site opens Rally Connect in a new window
Examples:
|zipcode|  county             | plantype  | planName                                               |
|33012  | Miami-Dade County   | SNP       | UnitedHealthcare Nursing Home Plan (PPO SNP)       |


Scenario: Verify Rally link from MA PrescriptionDrug Transition Process page
Given user navigates to MA PrescriptionDrug Transition Process page of Blue Layer Acquisition site
Then click on the Look up my provider link on MA PrescriptionDrug Transition Process page and rally tool opens up

Scenario: Verify Rally link from MA How To Appoint a Representative page
Given user navigates to MA How To Appoint Representative page of Blue Layer Acquisition site
Then click on the Look up my provider link on MA How To Appoint Representative page and rally tool opens up

Scenario:Verify Rally link from OUR PLANS: MA HOW TO PAY YOUR PREMIUM Page
Given user navigates to the OUR PLANS: MA HOW TO PAY YOUR PREMIUM
And user clicks on Look up provider link on OUR PLANS: MA HOW TO PAY YOUR PREMIUM then site open rally tool in new window

Scenario:Verify Rally link from OUR PLANS: MA REQUEST MORE HELP AND INFORMATION
Given user navigates to the OUR PLANS: MA REQUEST MORE HELP AND INFORMATION
And user clicks on Look up provider link on OUR PLANS: MA REQUEST MORE HELP AND INFORMATION then site open rally tool in new window  

Scenario:Verify Rally link from OUR PLANS: MA RESOURCES AND PLAN MATERIALS TAB
Given user navigates to the OUR PLANS: MA RESOURCES AND PLAN MATERIALS TAB
And user clicks on Look up provider link on OUR PLANS: MA RESOURCES AND PLAN MATERIALS TAB then site open rally tool in new window 

Scenario:Verify Rally link from OUR PLANS: MA MEMBER RIGHTS AND RESPONSIBILITIES
Given user navigates to MA MEMBER RIGHTS AND RESPONSIBILITIES of Blue Layer Acquisition site
And click on the Look up my provider link on MA Rights and responsibilities and rally tool opens up

#Scenario Outline:Verify Rally link of MA/MAPD plan from  VPP page during AEP period
#Given user navigates to PLAN SUMMARY Page
#| Zip Code    | <zipcode>|
#|County Name  | <county> |
#And click on Is my Provider Covered link of MA/MAPD plans for next year plan and switch back
#| Plan Type | <plantype> | 
#Then click on previous year Is my Provider Covered link of MA/MAPD plans
#Examples: 
#| zipcode | county             | plantype |
#| 80002   | Adams County       | MAPD     | 
#| 90210   | Los Angeles County | MAPD     | 
#| 30002   | DeKalb County      | MAPD     | 
#| 60004   | Cook County        | MAPD     |
#| 80002   | Jefferson County   | MA       | 
 
 
