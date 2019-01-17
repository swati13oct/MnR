@fixedTestCaseTest

Feature:1.16-VBF-Acq-To test Provider Search Flow  in AARP site

@ProviderSearchUlayerSmoke
 Scenario Outline: Verify Provider Search  in AARP site
 	Given the user is on AARP medicare acquisition site landing page
 	When the user performs plan search using following information in the AARP site
 	  | Zip Code    | <zipcode> |
 	  | County Name | <county>  |
 	  | Is Multi County|  <isMultutiCounty> |
 	And the user views the plans of the below plan type in AARP site
	  | Plan Type | <plantype> |
	When the user Click on Is my Provider covered link Ulayer
	  |PlanName| <planname>|
	When user selects a provider and retuns to VPP page in ulayer
	Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
	  |PlanName| <planname>|

	Examples:
	| zipcode | isMultutiCounty |  county             | plantype| planname |               
	| 90210   | NO              |Los Angeles County | MA      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)|



	



