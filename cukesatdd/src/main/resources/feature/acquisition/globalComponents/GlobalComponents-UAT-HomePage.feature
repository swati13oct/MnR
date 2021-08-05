@F625004 @UATRegression @GlobalcomponentshomePage
Feature: 1.12 homePage flows

  @homePage
  Scenario Outline: <Scenario> : To verify hero component displayed on home page and navigate to VPP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    And user validates TFN within feature box of hero component
      |TFN|<TFN>|
    When user enters zipcode and navigates to VPP
    When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information from HomePage
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi County Pop-up lands on enter Zip code HomePage
    Then user enters the zipcode and validates the URL
      | ZipCodeOnPlan | <ZipCodeOnPlan> |
      | SiteOnPlan    | <SiteOnPlan>    |
    When the user clicks on Find plans on vpp using following information from Homepage
      | County Name2     | <county2>        |
      | Is Multi County2 | <isMultiCounty2> |
      When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information from HomePage
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi County Pop-up lands on enter Zip code HomePage
    Then user clicks on Select by Address and Enter fileds
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    Then the user clicks on browser back button
           
    @homePage_AARP
    Examples: 
      | E2E_Scenario_1                                | site | pageName | path                                        | MultiCOuntyzipcode | ZipCodeOnPlan | SiteOnPlan                                                                 | isMultiCounty2| county2           | address              | city      | state       |TFN|
      | UAT_Home Page E2E Regression 1_Hero Component | AARP | Homepage | dolphin-authoring/redesigned-home-page.html |              78006 |         33410 | https://www.stage-aarpmedicareplans.uhc.com/health-plans.html/plan-summary |         NO | Palm Beach County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT |1-877-699-5710|

    @homePage_UHC
    Examples: 
      | E2E_Scenario_1                                | site | pageName | path                                        | MultiCOuntyzipcode | ZipCodeOnPlan | SiteOnPlan                                                                     | isMultiCounty | county            | address              | city      | state       |TFN|
      | UAT_Home Page E2E Regression 1_Hero Component | UHC  | Homepage | dolphin-authoring/redesigned-home-page.html |              78006 |         33410 | https://www.stage-uhcmedicaresolutions.uhc.com/health-plans.html/plan-summary |         NO | Palm Beach County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT |1-877-596-3258|

  @homePage
  Scenario Outline: <Scenario> : To check E2E flows of Shop plans from Homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    And user clicks on shop for Part C plans
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates TFN on need help section of Shop pages
    | TFNxpath | <tfnXpath> |
    | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    When the user clicks on Agent link and validates the correct URL is loaded from article page
    | UHC Agent URL | <UHCUrl> |
    Then the user clicks on browser back button
    And user clicks on shop for Medigap plans
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates TFN on need help section of Shop pages
    | TFNxpath | <tfnXpath> |
    | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    When the user clicks on Agent link and validates the correct URL is loaded from article page
    | UHC Agent URL | <UHCUrl> |
    Then the user clicks on browser back button
    And user clicks on shop for Part D plans
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates TFN on need help section of Shop pages
    | TFNxpath | <tfnXpath> |
    | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    When the user clicks on Agent link and validates the correct URL is loaded from article page
    | UHC Agent URL | <UHCUrl> |
    Then the user clicks on browser back button
    And user clicks on shop for D-SNPs plans
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates TFN on need help section of Shop pages
    | TFNxpath | <tfnXpath> |
    | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    When the user clicks on Agent link and validates the correct URL is loaded from article page
    | UHC Agent URL | <UHCUrl> |
    Then the user clicks on browser back button
    And user clicks on shop all plans
    Then user clicks on Select by Address and Enter fileds
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    Then user clicks on cancel link on shop for a plan
    Then user enters the zipcode and validates the URL
      | ZipCodeOnPlan | <ZipCodeOnPlan1> |
      | SiteOnPlan    | <SiteOnPlan1>    |
    Then the user validates the Need Help Section in the right rail
    Then the user clicks on browser back button
    And user clicks on learn more button link and navigates to Medicare Education Home page
    And user validates TFN on page
      | tfn | <TFN> |

   @homePage_AARP
    Examples: 
      | E2E_Scenario_2                                  | site | geoState | path                                        | pageName  | tfnXpath                                                           | tfnFlag | UHCUrl                      | address              | city      | state       | ZipCodeOnPlan1 | SiteOnPlan1                                                                                                         | TFN            |                
      | UAT_Home Page E2E Regression 2_Layout Container | AARP | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/#plan-summary | 1-877-699-5710 |
      | UAT_Home Page E2E Regression 2_Layout Container | AARP | Alabama  | dolphin-authoring/redesigne-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/#plan-summary | 1-877-699-5710 |                
      | UAT_Home Page E2E Regression 2_Layout Container | AARP | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/#plan-summary | 1-877-699-5710 |               
      | UAT_Home Page E2E Regression 2_Layout Container | AARP | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/#plan-summary | 1-877-699-5710 |

  @homePage_UHC
    Examples: 
      | E2E_Scenario_2                                  | site | geoState | path                                        | pageName  | tfnXpath                                                           | tfnFlag | UHCUrl                      | address              | city      | state       | ZipCodeOnPlan1 | SiteOnPlan1                                                                                                         | TFN            |                
      | UAT_Home Page E2E Regression 2_Layout Container | UHC  | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/plan-summary | 1-877-699-5710 |
      | UAT_Home Page E2E Regression 2_Layout Container | UHC  | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/plan-summary | 1-877-699-5710 |                
      | UAT_Home Page E2E Regression 2_Layout Container | UHC  | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/plan-summary | 1-877-699-5710 |               
      | UAT_Home Page E2E Regression 2_Layout Container | UHC  | Alabama  | dolphin-authoring/redesigned-home-page.html | Home page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | 33410          |https://www.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html/plan-summary | 1-877-699-5710 |


  @homePage
  Scenario Outline: <Scenario> : To verify Email capture component on homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    And user validates Email capture component

    @homePage_AARP
    Examples: 
      | Scenario                                      | geoState | site | path                                        | pageName  |
      | UAT_Home Page E2E Regression 3_Medicare Guide | Alabama  | AARP | dolphin-authoring/redesigned-home-page.html | Home page |

    @homePage_UHC
    Examples: 
      | Scenario                                      | geoState | site | path                                        | pageName  |
      | UAT_Home Page E2E Regression 3_Medicare Guide | Alabama  | UHC  | dolphin-authoring/redesigned-home-page.html | Home page |

  @homePage
  Scenario Outline: <Scenario> : To verify DCE flow from homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    And user clicks on Estimate drug costs and navigates to DCE
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
     Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    Then the user Captures Drug costs on Drug Details Page
    And user clicks on find a provider link
    And user clicks on get started link and navigates to PRE
    And user clicks on learn more link

    @homePage_AARP
    Examples: 
      | Scenario                                      | geoState | site | path                                        | pageName  |drug1   | drug2     | drug3    | drug4  | drug5 | drug6     | zipCode | county |
      | UAT_Home Page E2E Regression 3_Medicare Guide | Alabama  | AARP | dolphin-authoring/redesigned-home-page.html | Home page |Lipitor | Ibuprofen | Nicomide | Fanapt | Xanax | Alprazolam| 78006   | Bexar County|
      
    @homePage_UHC
    Examples: 
      | Scenario                                      | geoState | site | path                                        | pageName  |drug1   | drug2     | drug3    | drug4  | drug5 | drug6     | zipCode | county |
      | UAT_Home Page E2E Regression 3_Medicare Guide | Alabama  | UHC | dolphin-authoring/redesigned-home-page.html | Home page |Lipitor | Ibuprofen | Nicomide | Fanapt | Xanax | Alprazolam| 78006   | Bexar County|