@F625004 @UATRegression @GlobalcomponentshomePage
Feature: 1.12 homePage flows

  @homePage
  Scenario Outline: <Scenario> : To verify hero component displayed on home page and navigate to VPP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user validates TFN within feature box of hero component
    When user enters zipcode and navigates to VPP
    Then user clicks on Change Zip code link
    Then user clicks on Select by Address and Enter fileds
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
  
    @homePage_AARP
    Examples: 
      | E2E_Scenario_1                                | site                                                                                    |address                    | city      | state       |
      | UAT_Home Page E2E Regression 1_Hero Component | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html |584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT|

    #@homePage_VPPUHC
    #Examples: 
      #| E2E_Scenario_1                                | site                                                                                       |address                    | city      | state       |
      #| UAT_Home Page E2E Regression 1_Hero Component | https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html |584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT|

  @homePage
  Scenario Outline: <Scenario> : To check E2E flows of Shop plans from Homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user clicks on shop for Part C plans
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
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
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
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
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
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
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates TFN on need help section of Shop pages
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible  
    Then the user validates whether chat icon is visible
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on browser back button
    #And user clicks on shop all plans
    And user clicks on learn more button link and navigates to Medicare Education Home page
    And user validates TFN on page
    |tfn|<TFN>|

  @homePage_AARP
    Examples: 
      | E2E_Scenario_2                                  | site                                                                                    | path                                | pageName                     |tfnXpath                                                            | tfnFlag |UHCUrl                      | TFN|
      | UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ | 1-877-699-5710|
      | UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |https://www.myuhcagent.com/ | 1-877-699-5710|
      | UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ | 1-877-699-5710 |
      | UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ | 1-877-699-5710|

  #@homePage_UHC_Shopplans
    #Examples: 
      #| E2E_Scenario_2                                  | site                                                                                       | path                                | pageName                     |tfnXpath                                                            | tfnFlag |UHCUrl                      |                      
      #| UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ |
      #| UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |https://www.myuhcagent.com/ |
      #| UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ |
      #| UAT_Home Page E2E Regression 2_Layout Container | https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |https://www.myuhcagent.com/ |    
 
  @homePage
  Scenario Outline: <Scenario> : To verify Email capture component on homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |   
     And user validates Email capture component
     
     
   @homePage_AARP
    Examples: 
      | Scenario                                     | geoState | site                                                                                    |
      | UAT_Home Page E2E Regression 3_Medicare Guide| Alabama  | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html |
    
    
 @homePage
  Scenario Outline: <Scenario> : To verify DCE flow from homepage
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
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
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user clicks on find a provider link
    And user clicks on get started link and navigates to PRE
    And user clicks on learn more link
   
   

    @homePage_AARP
    Examples: 
      | Scenario                                     | geoState | site                                                                                    |
      | UAT_Home Page E2E Regression 4_2X1 Container | Alabama  | https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html |
    
    #@homePage_DCE
    #Examples: 
       #Examples: 
      #| Scenario                                    | geoState|Site                                                                                   |
      #|UAT_Home Page E2E Regression 4_2X1 Container | Alabama |https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html|
