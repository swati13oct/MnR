@UATRegression
Feature: 1.07.2 UAT-Provider Search Flows


  @ProviderSearchFromGlobalHeaderUlayer @AcqRegressionProviderSearchUlayer @prodRegression
  Scenario Outline: <Scenario> : Verify Provider Search  in AARP site from Global Header
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the global header
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user selects a provider and saves it

    Examples: 
      |Scenario| zipcode 									 | planname                             | year     |
      |Provider Search - E2E Scenario 4_AMP|   10001 | AARP Medicare Advantage Plan 2 (HMO) | current |

  @ProviderSearchFromVppPlanSummaryPageUlayer @prodRegression @AcqRegressionProviderSearchUlayer
  Scenario Outline: <Scenario> : Verify Provider Search  in AARP site from plan summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
    	|Plan Year	| <planyear>|
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
	Then Verify provider name is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
    Examples: 
      |Scenario													   | zipcode | isMultutiCounty | county          | plantype | planname                             |planyear|
      |Provider Search - E2E Scenario 3_AMP|   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |current|

  @ProviderSearchFromVppPlanDetailsPageUlayer @AcqRegressionProviderSearchUlayer @prodRegression
  Scenario Outline: <Scenario> : Verify Provider Search  in AARP site from Plan Details page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
   And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
    	|Plan Year	| <planyear>|
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer

    Examples: 
      |Scenario 													 | zipcode | isMultutiCounty | county          | plantype | planName                                |planyear|
      |Provider Search - E2E Scenario 2_AMP|   10001 | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) |current|

  @ProviderSearchFromHomePageUlayer @AcqRegressionProviderSearchUlayer @ProviderSearchFromHomePageNextYrUlayerSmoke @prodRegression
  Scenario Outline: <Scenario> : Verify Provider Search  in AARP site from Home Page
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user selects a provider and saves it

    Examples: 
      |Scenario   												 | zipcode | planname                             | year     |
      |Provider Search - E2E Scenario 1_AMP|   10001 | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

 