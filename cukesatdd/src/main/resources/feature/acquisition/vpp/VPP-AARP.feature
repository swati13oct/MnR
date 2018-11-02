@fixedTestCaseTest
@vppUlayer
Feature: 1.10-VBF-Acq-To test plan summary in vpp flow AARP site
@vppUlayerSmoke
Scenario Outline: Verify plan summary in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
And the user validates the available plans for selected plan types in the AARP site
Then the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
Examples:
| zipcode | county             | plantype | planName                                         |
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |

@vppPlanDetailsAarp
Scenario Outline: Verify plan details in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
When the user views plans of the below plan type in AARP site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in AARP site and validates
	| Plan Name | <planName> |

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90002   | Adams County | MAPD     	  |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	
@defect3281
Scenario Outline: To check all 3 MA plans and go to estimate drug costs page and return to vpp to verify they're still selected
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	|Zip Code| <zipcode> |
And I select all 3 plans to compare in MA and click on compare plan link
Then I click back to all plans button and verify that all 3 plans are still selected

Examples:
|zipcode|
|80007 | 


@theSpartans @aprilRelease2018 @vppbacktoallplans @US987466 @US987470
Scenario Outline: To click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	| County Name | <county>  |
#Then user validates plan count for all plan types on plan summary page in the AARP site
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
#And the user validates the available plans for selected plan types in the AARP site
Then the user view plan details of the above selected plan in AARP site vpp
	| Plan Name | <planName> |
	| Plan Type | <plantype> |
Then the user clicks on both top and bottom back to plans link and validates its redirection AARP
Examples:
| zipcode | county             | plantype | planName                                         |
| 90210   | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |

	
@snpplansulayer @september_release_2018 @predators
Scenario Outline: Verify plan summary in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode> |
	#| County Name | <county>  |
Then user validates plan count for all plan types on plan summary page in the AARP site
And the user views the plans of the below plan type in AARP site
	| Plan Type | <plantype> |
And the user validates the available plans for selected plan types in the AARP site
Then the user validates plan summary for the below plan in the AARP site
	| Plan Name | <planName> |
Examples:
| zipcode | county             | plantype | planName                                         |
| 80001   | Los Angeles County | SNP	  | UnitedHealthcare Nursing Home Plan (PPO SNP)     |

@emailandprintplancompare @predators
Scenario Outline: Verify print and email for <plantype> plan compare page in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	|Zip Code| <zipcode> |
And I select all 3 plans to compare in MA and click on compare plan link
   |plan type|<plantype>|
When the user validate the print and email link option in plan compare
Then the user validating email and print option in plan compare
#Then I click back to all plans button and verify that all 3 plans are still selected

Examples:
|zipcode|plantype|
|90210 | MedicareAdvantage|
|90210 | PDP              |

@emailandprintplanDetails @predators @decRelease2018
Scenario Outline: Verify email  plan details in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
    |Zip Code| <zipcode> |
And the user views the plans of the below plan type in AARP site
    | Plan Type | <plantype> |
And the user validates the available plans for selected plan types in the AARP site
Then the user view plan details of the above selected plan in AARP site and validates
    | Plan Name | <planName> |
Then the user validate the print and email links on the plan Details Page
Then the user validates the functionality of email and print buttons on the plan Details Page
    
Examples:
| zipcode |plantype | planName                                         |
| 90210   |MA         | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |