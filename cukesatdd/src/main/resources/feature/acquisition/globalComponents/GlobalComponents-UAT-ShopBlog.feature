 @UATRegression @F448210
Feature: 1.13 UAT - Shop Blog Pages flows
    
     
    @GlobalComponentsAARPShopPages @UATRegression 
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates whether call icon is displayed on the page
    Then the user validates proactive chat popup
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    
    
    
   @ShopPages_Shop5_GlobalCompsAARP
   Examples: 
   |Scenario             |site    |path                                              | pageName            | 
   |E2E Scenario 1_AMP   |	AARP	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | 
   |E2E Scenario 1_AMP   |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
   |E2E Scenario 1_AMP   |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
   |E2E Scenario 1_AMP   |	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | 
   |E2E Scenario 1_AMP   |  AARP	| enroll.html                                      | ShopPlan: Enroll             |
   |E2E Scenario 1_AMP   |	AARP	| shop.html                                        | ShopPlan: Shop Hub           |
   |E2E Scenario 1_AMP   |	AARP	| shop/compare/compare-ms.html                     | ShopPlan: Compare            |
   |E2E Scenario 1_AMP   |	AARP	| shop/compare/compare-ma-ms.html                  | ShopPlan: Compare MA MS      |
   |E2E Scenario 1_AMP   |  AARP	| enroll/ms-apply.html                             | ShopPlan: MS Enrollment      | 
   |E2E Scenario 1_AMP   |	AARP	| safe-shopping.html                               | ShopPlan: Shop               |
   
   @ShopPages_Shop5_GlobalCompsUHC
   Examples: 
   |Scenario             |site  |path                                              | pageName            | 
   |E2E Scenario 1_UMS	 | UHC  | shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | 
   |E2E Scenario 1_UMS	 | UHC	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
   |E2E Scenario 1_UMS	 | UHC	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
   |E2E Scenario 1_UMS	 | UHC	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | 
   |E2E Scenario 1_UMS	 | UHC	| enroll.html                                      | ShopPlan: Enroll             |
   |E2E Scenario 1_UMS	 | UHC	| shop.html                                        | ShopPlan: Shop Hub           |
   |E2E Scenario 1_UMS	 | UHC	| shop/compare/compare-ms.html                     | ShopPlan: Compare            |
   |E2E Scenario 1_UMS	 | UHC	| shop/compare/compare-ma-ms.html                  | ShopPlan: Compare MA MS      |
   |E2E Scenario 1_UMS	 | UHC	| enroll/ms-apply.html                             | ShopPlan: MS Enrollment      |   
   |E2E Scenario 1_UMS	 | UHC	| safe-shopping.html                               | ShopPlan: Shop               | 
    
   @ShopPages_Shop6_GlobalCompsAARP
   Examples: 
   |Scenario            |site   |path                                                                     | pageName            |
   |E2E Scenario 1_AMP  |AARP   | contact-us.html                                                         | Request more help   |
   |E2E Scenario 1_AMP  |AARP   | shop/estimate/ma-costs.html                                             | Estimate  MA  | 
   |E2E Scenario 1_AMP  |AARP   | shop/estimate/pdp-costs.html                                            | Estimate PDP  |
   |E2E Scenario 1_AMP  |AARP   | shop/medicare-advantage-plans/ma-plan-benefits.html                       | MA Plan benefits|
   |E2E Scenario 1_AMP  |AARP   | shop/compare/compare-ma.html                                              | Compare MA    |
   |E2E Scenario 1_AMP  |AARP   | shop/compare/compare-pdp.html                                             | Compare PDP   |
   |E2E Scenario 1_AMP  |AARP   | shop/medicare-advantage-veteran-plan.html                                 | MA Veteran Plan|
   |E2E Scenario 1_AMP  |AARP   | enroll/ma-enrollment.html                                                 | MA Enrollment |
   |E2E Scenario 1_AMP  |AARP   | enroll/pdp-enrollment.html                                                | PDP Enrollment|
   |E2E Scenario 1_AMP  |AARP	  | shop/compare.html                                                         | ShopPlan: Compare| 
   |E2E Scenario 1_AMP  |AARP	  | shop/estimate.html                                                        | ShopPlan: Estimate |

   
   @ShopPages_Shop6_GlobalCompsUHC 
   Examples: 
   |Scenario            |site  |path                                                                       | pageName            |
   |E2E Scenario 1_UMS  |UHC   | contact-us.html                                                           | Request more help   |
   |E2E Scenario 1_UMS  |UHC   | shop/estimate/ma-costs.html                                               | Estimate  MA  | 
   |E2E Scenario 1_UMS  |UHC   | shop/estimate/pdp-costs.html                                              | Estimate PDP  |
   |E2E Scenario 1_UMS  |UHC   | shop/renew-active.html                                                    | Renew Active  |
   |E2E Scenario 1_UMS  |UHC   | shop/medicare-advantage-plans/ma-plan-benefits.html                       | MA Plan benefits|
   |E2E Scenario 1_UMS  |UHC   | shop/compare/compare-ma.html                                              | Compare MA    |
   |E2E Scenario 1_UMS  |UHC   | shop/compare/compare-pdp.html                                             | Compare PDP   |
   |E2E Scenario 1_UMS  |UHC   | shop/medicare-advantage-veteran-plan.html                                 | MA Veteran Plan|
   |E2E Scenario 1_UMS  |UHC   | enroll/ma-enrollment.html                                                 | MA Enrollment |
   |E2E Scenario 1_UMS  |UHC   | enroll/pdp-enrollment.html                                                | PDP Enrollment|
   |E2E Scenario 1_UMS  |UHC	 | shop/compare.html                                                         | ShopPlan: Compare| 
   |E2E Scenario 1_UMS  |UHC	 | shop/estimate.html                                                        | ShopPlan: Estimate |
 
   
  
   @GlobalComponentsAARPBlogPages   @UATRegression 
  Scenario Outline: <Scenario>- To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Then the user validates Medicare Education Navigation link
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    Then the user validates whether call icon is displayed
    When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
    Then the user validates proactive chat popup
    Then the user enters and validate the fields and clicks on submit 
    
    

  @BlogPages_GlobalCompsAARP  
   Examples: 
   |Scenario          |site   |path                                                    | pageName               |
   |E2E Scenario 1_AMP|AARP   |medicare-articles.html                                  | Medicare Articles Home |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/eligibility-and-enrollment.html       | Sample Category Page   |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/medicare-benefits-and-coverage.html   | Category page          |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/medicare-costs.html                   | Category page          |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/shopping-for-medicare.html            | Category page          |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/medicare-when-working-past-65.html    | Category page          |
   |E2E Scenario 1_AMP|AARP   |medicare-articles/medicare-tips-and-faqs.html           | Category page          |
  
   @BlogPages_GlobalCompsUHC 
   Examples: 
   |Scenario          |site  |path                                                    | pageName               |
   |E2E Scenario 1_UMS|UHC   |medicare-articles.html                                  | Medicare Articles Home |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/eligibility-and-enrollment.html       | Sample Category Page   |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/medicare-benefits-and-coverage.html   | Category page          |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/medicare-costs.html                   | Category page          |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/shopping-for-medicare.html            | Category page          |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/medicare-when-working-past-65.html    | Category page          |
   |E2E Scenario 1_UMS|UHC   |medicare-articles/medicare-tips-and-faqs.html           | Category page          |
   


  