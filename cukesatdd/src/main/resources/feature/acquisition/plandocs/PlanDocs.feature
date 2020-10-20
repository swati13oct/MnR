@acq_plandocs
Feature: 2.13 ACQ AARP- To test plandocs in AARP and UHC Site 
Scenario Outline: TID: <TID> - To test the plandocs on AARP site
Given the user is on the AARP medicare site landing page
When I access the acquisition Plan docs tool from home page
When the user validates the header and the subcontent section  
And the user validates the label for zipcode and county and plan
And the user enters zipcode and county and plan
|zipcode| <zipcode>|
|county| <county>|
|plan|<plan>|
|currentplandrodown|<currentplandrodown>|
Then the user should be able to see the pdf
|plan|<plan>|
Examples:
| TID | zipcode |county| plan| currentplandrodown |
|1 | 90002 |Los Angeles County |AARP Medicare Advantage SecureHorizons Essential (HMO) |yes |
|2 | 55344 |Hennepin County    |UnitedHealthcare Nursing Home Plan (PPO I-SNP)|yes |

Scenario Outline: TID: <TID> - To test the plandocs on uhc site
Given the user is on the uhcmedicaresolutions site landing page
When I access the acquisition Plan docs tool from home page on uhc
When the user validates the header and the subcontent section  
And the user validates the label for zipcode and county and plan
And the user enters zipcode and county and plan
|zipcode| <zipcode>|
|county| <county>|
|plan|<plan>|
|currentplandrodown|<currentplandrodown>|
Then the user should be able to see the pdf
|plan|<plan>|
Examples:
| TID | zipcode |county| plan|currentplandrodown |
|1 | 90002 |Los Angeles County |AARP Medicare Advantage SecureHorizons Essential (HMO) |yes |
|2 | 55344 |Hennepin County    |UnitedHealthcare Nursing Home Plan (PPO I-SNP)|yes |