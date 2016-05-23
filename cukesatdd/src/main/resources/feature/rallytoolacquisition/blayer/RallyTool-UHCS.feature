@RallytoolUHCSAcquisition
Feature:To launch Rally tool from UHC Acquisition Pages
#Scenario:Rally Connect Tool should be launched from MA Enrollment Information Tab
#Given user navigates to MA Enrollment Information Tab of Blue Layer Acquisition site
#And click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up


#Scenario:Rally Connect Tool should be launched from MA PLAN INFORMATION AND FORMS
#Given user navigates to MA PLAN INFORMATION AND FORMS of Blue Layer Acquisition site
#And click on the Look up my provider link on MA PLAN INFORMATION AND FORMS and rally tool opens up

#Scenario: To Verify Rally tool from B-Layer Acquisition  
#Given the user is on the UHC Medicaresolutions Home page
#When user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
#Then user clicks on the Search for Provider/Facility link and site opens new provider search tool in a new window

#Scenario Outline:Verify Rally link from VPP: ALL PLANS IN YOUR AREA – SNP TAB
#Given user navigates to the UHC Home Page
#And user performs plan search using following information in UHC site
#	| Zip Code    | <zipcode>|
#	| County Name	  |<county>|
#When user views plans of the below plan type in UMS site
#| Plan Type | <plantype> |
#Then user validates plan count for all plan types on plan summary page in UMS site
#Then the user validates the available plans for selected plan types in UMS site
#And the user validates the plan summary for the below plan in UMS site
#| Plan Name | <planName> |
#And the user clicks on Is my doctors covered link in UHC site and site opens Rally Connect in a new window
#Examples:
#|zipcode|  county             | plantype  | planName                                               |
#|33012  | Miami-Dade County   | SNP       | UnitedHealthcare Nursing Home Plan (PPO SNP)           |             						        
#| 78006 | Comal County        | SNP       |  Care Improvement Plus Gold Rx (Regional PPO SNP)      |
#|33012  | Miami-Dade County   | SNP       | UnitedHealthcare Nursing Home Plan (PPO SNP)           |
#|80002  | Jefferson County    | SNP       | UnitedHealthcare Assisted Living Plan (PPO SNP)        |
#|90210  | Los Angeles County  | MA        | AARP MedicareComplete SecureHorizons Plan 3 (HMO)      |

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
 |90210  | Los Angeles County  | MA        | AARP MedicareComplete SecureHorizons Plan 3 (HMO)      |