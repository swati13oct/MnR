@UATRegression @F448210
Feature: 1.13 UAT - Shop Blog Pages flows
    
     
  @GlobalComponentsAARPShopPages 
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
     And the user clicks on browser back button
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates proactive chat popup
    Then the user validates whether chat icon is visible
    Then the user validates whether call icon is visible
    
            
   @ShopPages_Shop5_GlobalCompsAARP
   Examples: 
   |Scenario             |site  |path                                  | pageName                     | UHCUrl|tfnXpath                                     | tfnFlag |
   |E2E Scenario 2_AMP   |AARP	| shop/medicare-advantage-plans.html   | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 3_AMP   |AARP  | shop/estimate/pdp-costs.html         | Estimate PDP                 | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/medicare-supplement-plans.html  | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/prescription-drug-plans.html    | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/dual-special-needs-plans.html   | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| enroll.html                          | ShopPlan: Enroll             | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop.html                            | ShopPlan: Shop Hub           | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/compare/compare-ms.html         | ShopPlan: Compare            | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/compare/compare-ma-ms.html      | ShopPlan: Compare MA MS      | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| safe-shopping.html                   | ShopPlan: Shop               | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
  
   @ShopPages_Shop5_GlobalCompsUHC
   Examples: 
   |Scenario             |site  |path                                              | pageName                     | UHCUrl|tfnXpath                                     | tfnFlag |
   |E2E Scenario 2_UMS	 | UHC  | shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 3_UMS   | UHC  | shop/estimate/pdp-costs.html                     | Estimate PDP                 |  https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| enroll.html                                      | ShopPlan: Enroll             |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| shop.html                                        | ShopPlan: Shop Hub           |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS	 | UHC	| shop/compare/compare-ms.html                     | ShopPlan: Compare            |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS   | UHC	| shop/compare/compare-ma-ms.html                  | ShopPlan: Compare MA MS      |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS   | UHC  | safe-shopping.html                               | ShopPlan: Shop               |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
  
   @ShopPages_Shop6_GlobalCompsAARP
   Examples: 
   |Scenario            |site   |path                                                   | pageName            |UHCUrl|tfnXpath                                     | tfnFlag |
   |E2E Scenario 5_AMP  |AARP   | contact-us.html                                       | Request more help   | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/estimate/ma-costs.html                           | Estimate  MA        | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/renew-active.html                                | Renew Active        |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/medicare-advantage-plans/ma-plan-benefits.html   | MA Plan benefits    | https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   | 
   |E2E Scenario 5_AMP  |AARP   | shop/compare/compare-ma.html                       | Compare MA             | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/compare/compare-pdp.html                      | Compare PDP            | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/medicare-advantage-veteran-plan.html          | MA Veteran Plan       | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | enroll/ma-enrollment.html                          | MA Enrollment         | https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   | 
   |E2E Scenario 5_AMP  |AARP   | enroll/pdp-enrollment.html                         | PDP Enrollment         | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP	  | shop/compare.html                                  | ShopPlan: Compare      | https://www.myuhcagent.com/|  (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP	  | enroll/ms-apply.html                               | ShopPlan: MS Enrollment  | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
  
   
   
   @ShopPages_Shop6_GlobalCompsUHC 
   Examples: 
   |Scenario            |site  |path                                                  | pageName            |UHCUrl|tfnXpath                                     | tfnFlag |
   |E2E Scenario 5_UMS  |UHC   | contact-us.html                                      | Request more help   |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/estimate/ma-costs.html                          | Estimate  MA        | https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/renew-active.html                               | Renew Active        |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/medicare-advantage-plans/ma-plan-benefits.html  | MA Plan benefits    |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/compare/compare-ma.html                       | Compare MA            |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/compare/compare-pdp.html                     | Compare PDP            |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | shop/medicare-advantage-veteran-plan.html         | MA Veteran Plan        |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | enroll/ma-enrollment.html                         | MA Enrollment          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | enroll/pdp-enrollment.html                        | PDP Enrollment         |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC	 | shop/compare.html                                 | ShopPlan: Compare      | https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS  |UHC   | enroll/ms-apply.html                              | ShopPlan: MS Enrollment    | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
  
  @ShopPages_Shop7_GlobalCompsAARP # with need help section
   Examples: 
   |Scenario            |site   |path                                                   | pageName            |UHCUrl|tfnXpath                                     | tfnFlag | 
   |E2E Scenario 2_AMP	|AARP  | shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP	|AARP  | shop/compare.html                                 | ShopPlan: Compare      | https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP	|AARP 	| enroll.html                                      | ShopPlan: Enroll             |  https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop.html                            | ShopPlan: Shop Hub           | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/medicare-supplement-plans.html  | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/prescription-drug-plans.html    | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_AMP   |AARP	| shop/dual-special-needs-plans.html   | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_AMP  |AARP   | shop/estimate.html                   | Estimate   | https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
    
    
    
  @GlobalComponentsAARPBlogPages  
  Scenario Outline: <Scenario>- To verify Global Components for the page mentioned of AARP site <pageName> : <path>: <tfnXpath>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Then the user validates Medicare Education Navigation link
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55424"
    And the user clicks on browser back button
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user enters and validate the fields and clicks on submit 
    Then the user validates proactive chat popup
    Then the user validates whether chat icon is visible
    Then the user validates whether call icon is visible
    
  
  @BlogPages_GlobalCompsAARP  
   Examples: 
    |Scenario          |site  |path                                                    | pageName               |UHCUrl| tfnXpath                                     | tfnFlag |
    |E2E Scenario 1_AMP|AARP  |medicare-articles.html                                  | Medicare Articles Home |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
    |E2E Scenario 5_AMP|AARP  |medicare-articles/medicare-made-clear.html              | MMC page               |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
    
 @BlogPages_GlobalCompsUHC 
   Examples: 
   |Scenario          |site  |path                                                    | pageName               |UHCUrl| tfnXpath                                     | tfnFlag |
   |E2E Scenario 1_UMS|UHC   |medicare-articles.html                                  | Medicare Articles Home |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 5_UMS|UHC   |medicare-articles/medicare-made-clear.html              | MMC page               |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   
  
  @GlobalComponentsAARPBlogPages1 
  Scenario Outline: <Scenario>- To verify Global Components for the page mentioned of AARP site <pageName> : <path>: <tfnXpath>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Then the user validates Medicare Education Navigation link
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates whether call icon is visible
    Then the user validate ZipCode Components on page using ZipCode "10001"
    And the user clicks on browser back button
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user enters and validate the fields and clicks on submit
    Then the user validates proactive chat popup
    Then the user validates whether chat icon is visible
    
    
    
  @BlogPages1_GlobalCompsAARP  
   Examples: 
    |Scenario          |site  |path                                                    | pageName               |UHCUrl|  tfnXpath                                     | tfnFlag |
    |E2E Scenario 3_AMP|AARP  |medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html  | Article page 1 |https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
    |E2E Scenario 4_AMP|AARP  |medicare-articles/what-is-retiree-health-coverage.html  | Article page 2         |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
    
   @BlogPages1_GlobalCompsUHC 
   Examples: 
   |Scenario          |site  |path                                                    | pageName               |UHCUrl|  tfnXpath                                     | tfnFlag |
   |E2E Scenario 3_UMS|UHC   |medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html  | Article page 1    |https://www.myuhcagent.com/| (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 4_UMS|UHC   |medicare-articles/what-is-retiree-health-coverage.html  | Article page 2        |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
  
    
    
  @GlobalComponentsAARPBlogPages2
  Scenario Outline: <Scenario>- To verify Global Components for the page mentioned of AARP site <pageName> : <path>: <tfnXpath>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Then the user validates Medicare Education Navigation link
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    And the user clicks on browser back button
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    Then the user validates proactive chat popup
    
   
   @BlogPages2_GlobalCompsAARP  
   Examples: 
   |Scenario          |site  |path                                                    | pageName               |UHCUrl                     |                      tfnXpath                                     | tfnFlag |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/eligibility-and-enrollment.html       | Sample Category Page   |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/medicare-benefits-and-coverage.html   | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/medicare-costs.html                   | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/shopping-for-medicare.html            | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/medicare-when-working-past-65.html    | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_AMP|AARP  |medicare-articles/medicare-tips-and-faqs.html           | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   

   @BlogPages2_GlobalCompsUHC 
   Examples: 
   |Scenario          |site  |path                                                    | pageName               |UHCUrl| tfnXpath                                     | tfnFlag |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/eligibility-and-enrollment.html       | Sample Category Page   |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/medicare-benefits-and-coverage.html   | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/medicare-costs.html                   | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/shopping-for-medicare.html            | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/medicare-when-working-past-65.html    | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   |E2E Scenario 2_UMS|UHC   |medicare-articles/medicare-tips-and-faqs.html           | Category page          |https://www.myuhcagent.com/|(//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
   
  