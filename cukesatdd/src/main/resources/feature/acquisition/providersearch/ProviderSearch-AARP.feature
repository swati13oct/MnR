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



	
@ProviderSearchFromGlobalHeaderUlayer
 Scenario Outline: Verify Provider Search  in AARP site from Global Header
 	Given the user is on AARP medicare acquisition site landing page
 	When the user clicks on Provider Search on the global header
 	Then the user enters the zipcode and select a plan on the Rally tool
 	| Zip Code    | <zipcode> |
 	|Plan Name     | <planname>|
	When user selects a provider and saves it
	
	Examples:
	| zipcode | planname |               
	| 90002  | AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
	
	
@ProviderSearchFromVppPlanSummaryPageUlayer
 Scenario Outline: Verify Provider Search  in AARP site from plan summary page
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
	
	@ProviderSearchFromVppPlanDetailsPageUlayer
 Scenario Outline: Verify Provider Search  in AARP site from Plan Details page
 	Given the user is on AARP medicare acquisition site landing page
 	When the user performs plan search using following information in the AARP site
 	  | Zip Code    | <zipcode> |
 	  | County Name | <county>  |
 	  | Is Multi County|  <isMultutiCounty> |
 	And the user views the plans of the below plan type in AARP site
	  | Plan Type | <plantype> |
  Then the user navigates to the plan Details page
      | Plan Name | <planName> |
	Then the user Click on Look up your Provider button
	When user selects a provider and retuns to VPP plan details page in ulayer
	Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
	  |PlanName| <planname>|

	Examples:
	| zipcode | isMultutiCounty |  county           | plantype| planname |               
	| 90210   | NO              |Los Angeles County | MA      | AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
	

	@ProviderSearchFromHomePageUlayer
	 Scenario Outline: Verify Provider Search  in AARP site from Home Page
 	Given the user is on AARP medicare acquisition site landing page
 	When the user clicks on Provider Search on the Home Page
 	Then the user enters the zipcode and select a plan on the Rally tool
 	| Zip Code    | <zipcode> |
 	|Plan Name     | <planname>|
	When user selects a provider and saves it
	
	Examples:
	| zipcode | planname |               
	| 90002  | AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
	




