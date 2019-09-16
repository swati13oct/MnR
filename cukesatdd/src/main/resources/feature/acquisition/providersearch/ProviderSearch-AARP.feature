@fixedTestCaseTest
Feature: 1.7 .ACQ- Provider Search Flow in AARP

  @ProviderSearchUlayerSmoke @ProviderSearchUlayerCurrentSmoke
  Scenario Outline: Verify Provider Search  in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type in AARP site
    And the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
      
      @ProviderSearchUlayerNextYrSmoke
  Scenario Outline: Verify Provider Search  in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
   # And the user views the plans of the below plan type in AARP site
   Then the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |
      

  @ProviderSearchFromGlobalHeaderUlayer @AcqRegressionProviderSearchUlayer
  Scenario Outline: Verify Provider Search  in AARP site from Global Header
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the global header
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
        | 	Year  | <year>	   |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                                          |year		  |
      |   90002 | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |currentYear  |

  @ProviderSearchFromVppPlanSummaryPageUlayer @AcqRegressionProviderSearchUlayer
  Scenario Outline: Verify Provider Search  in AARP site from plan summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |

  @ProviderSearchFromVppPlanDetailsPageUlayer @AcqRegressionProviderSearchUlayer
  Scenario Outline: Verify Provider Search  in AARP site from Plan Details page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
   

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       |AARP MedicareComplete SecureHorizons Essential (HMO)|

  @ProviderSearchFromHomePageUlayer @AcqRegressionProviderSearchUlayer @ProviderSearchFromHomePageUlayerSmoke
  Scenario Outline: Verify Provider Search  in AARP site from Home Page
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
       | 	Year  | <year>	   |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                                          | year		  |
      |   90002 | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |currentYear  |
      
 @ProviderSearchFromHomePageUlayer @AcqRegressionProviderSearchUlayer @ProviderSearchFromHomePageNextYrUlayerSmoke
  Scenario Outline: Verify Provider Search  in AARP site from Home Page
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
       | 	Year  | <year>	   |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                                          | year		  |
      |   90002 | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |nextYear	  |
      
  @PlancompareProviderSearchAARP @AcqRegressionProviderSearchUlayer
  Scenario Outline: TID: <TID> - TC01_RallyTool_Through_Plan Compare_Page
     Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select all 3 plans to compare and click on compare plan link in AARP
    And I Click on Look up your doctor link on Plan compare in AARP
    And I click on Get Started on and Add Provider from find care page in AARP
    Then Verify provider is count is updated on plan compare page in AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             |
      | 15489 |   90210 | NO              | Los Angeles County |
