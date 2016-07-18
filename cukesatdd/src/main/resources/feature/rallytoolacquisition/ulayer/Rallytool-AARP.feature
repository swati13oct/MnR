@RallytoolAARPAcquisition
Feature:To launch Rally tool from AARP Acquisition Pages
Scenario:Verify Rally link from AARP Site Map Page
Given user navigates to the AARP Site Map Page
Then user clicks on the Search For a Provider link on AARP Site Map Page and site opens Rally Connect in a new window 

Scenario Outline:Verify Rally link from VPP: MA - Plan Details page
Given the user is on the AARP Medicareplans Home page
And user performs plan search using following information in AARP site
	| Zip Code    | <zipcode>|
	| County Name	  |<county>|
Then click on Is my Provider Covered link of MA/MAPD plans for next year plan and switch back and validate Rally Connect Get Started page
| Plan Name | <planName> |
| Plan Type | <plantype> |
Examples:
 |zipcode|  county             | plantype  | planName                                               |
 |90210  | Los Angeles County  | MA        | AARP MedicareComplete SecureHorizons Plan 3 (HMO)      |