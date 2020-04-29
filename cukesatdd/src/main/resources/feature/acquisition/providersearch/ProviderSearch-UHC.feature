@fixedTestCaseTest
Feature: 2.07. ACQ- Provider Search Flow in UMS


  @ProviderSearchBlayerSmoke @ProviderSearchBlayerCurrentSmoke
  Scenario Outline: Verify Provider Search  in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for nextt year
      | Plan Type | <plantype> |
     When user Click on Is my Provider covered link ums
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                          | 
      |   10001 | NO              | New York County | MA       | AARP Medicare Advantage Plan 2 (HMO) |
      
       
  @PlancompareProviderSearch @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: TID: <TID> - TC01_RallyTool_Through_Plan Compare_Page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
 	When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      |aep|<aep>|
    And I select all 3 plans to compare and click on compare plan link in UHC
    And I Click on Look up your doctor link on Plan compare
    And I click on Get Started on and Add Provider from find care page
    Then Verify provider is count is updated on plan compare page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype |aep |
      | 15488 |   10001 | NO              | New York County | MAPD	| no|
      
      
     @ProviderSearchFromGlobalHeaderBlayer  @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: Verify Provider Search in UHC site from Global Header
    Given the user is on the uhcmedicaresolutions site landing page
    When the user clicks on Provider Search on the global header on UHC site
    Then the user enters the zipcode and select a plan on the Rally tool on UHC Site
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
       | 	Year  | <year>	   |
    When user selects a provider and saves it on UHC Site

    Examples: 
      | zipcode | planname                                          | year		  |
      |   10001 | AARP Medicare Advantage Plan 2 (HMO)				 |nextYear  |
      
      @ProviderSearchFromGlobalHeaderBlayer1 @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: Verify Provider Search  in UMS site from Global Header
   Given the user is on the uhcmedicaresolutions site landing page
    When the user clicks on Provider Search on the global header on UHC site
    Then the user enters the zipcode and counts the plan Blayer
      | Zip Code  | <zipcode>  |
      | Plancount | <plancount>  |
    Examples: 
      | zipcode | plancount|
      |   10001 | 12 |
      |   55344 | 7  |
      |   04011 | 6  |
      
@ProviderSearchFromWidgetBlayer @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: Verify Provider Search  in UMS site from Global Header
   Given the user is on the uhcmedicaresolutions site landing page
    When the user clicks on Provider Search on the global header on UHC site
    Then the user enters the zipcode and counts the plan Blayer
      | Zip Code  | <zipcode>  |
      | Plancount | <plancount>  |
    Examples: 
      | zipcode | plancount|
      |   10001 | 12 |
      |   55344 | 7  |
      |   04011 | 6  |

  @ProviderSearchFromVppPlanSummaryPageBlayer @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: Verify Provider Search  in UHC site from plan summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      |aep|<aep>|
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                           |aep |
     |   10001 | NO              | New York County | MAPD       | AARP Medicare Advantage Plan 2 (HMO) | no |


  @ProviderSearchFromVppPlanDetailsPageBlayer @AcqRegressionProviderSearchBlayer @prodRegression
  Scenario Outline: Verify Provider Search  in UHC site from Plan Details page
     Given the user is on the uhcmedicaresolutions site landing page
     When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      |aep|<aep>|
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button in UMS site
    When user selects a provider and retuns to VPP plan details page in blayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page blayer
   

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                           |aep |
      |   10001 | NO              | New York County | MA       |AARP Medicare Advantage Essential (HMO)| no |

      
      @ProviderSearchFromHomePageBlayer @AcqRegressionProviderSearchBlayer @ProviderSearchFromHomePageNextYrBlayerSmoke @prodRegression
  Scenario Outline: Verify Provider Search  in UHC site from Home Page
     Given the user is on the uhcmedicaresolutions site landing page
    When the user clicks on Provider Search on the Home Page on UHC Site
    Then the user enters the zipcode and select a plan on the Rally tool on UHC Site
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | 	Year  | <year>	   |
    When user selects a provider and saves it on UHC Site

    Examples: 
      | zipcode | planname                                          |  year		  |
     |   10001 | AARP Medicare Advantage Plan 2 (HMO) |nextYear	  |
