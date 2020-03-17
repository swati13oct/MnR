@globalHeader
Feature: 2.04--Acq-To test global footer links in AARP site

  @globalfooterULayer
  Scenario: To verify links displayed in the global footer of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When user accesses global footer of the AARP Medicare Plans home page
    And user vaidates the state drop down link on home page
    And user clicks on View all disclaimer information link on home page
    And user verifies visit aarp.org link on home page ulayer
    And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
    And user clicks on contactus link of aboutus page
    And user clicks on sitemap link of contactus page
    And user clicks on privacypolicy link of sitemap page
    And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms&conditions page
    And user clicks on agents&brokers link of disclaimers page
    And user verifies and clicks on home link of agents&brokers page ulayer
    Then user clicks on back to top link on home page

  @globalheaderULayer
  Scenario: To verify links displayed in the global header of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When user accesses global header of the AARP Medicare Plans home page
    And user verifies the AARP logo on home page
    And user clicks on Sign in link on home page in aarp
    And user clicks on register link on home page in aarp
    Then user validates visitor profile on home page in aarp

  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the AARP Medicare Plans home page
    When user accesses global footer of the AARP Medicare Plans All page
    Then the USer validates Shop for a Plan Navigation links
    Then the user validates Medicare Education Navigation links
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates Pro-active Chat
    Then the user validates SAM Call Icon
    Then the user validates SAM re-active Chat

    @MedEdPages_GlobalCompsAARP
    Examples: 
      | path                                                     | pageName                                   | tfnXpath                                        | tfnFlag |
      | medicare-education.html                                  | MedEd: Landing                             | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-costs.html                   | MedEd: Medicare Cost Basics                | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-advantage-plans.html         | MedEd: MA Plans                            | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-supplement-plans.html        | MedEd: Med Supp plans                      | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-part-d.html                  | MedEd: PDP Plans                           | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/enrollment-and-changing-plans.html    | MedEd: Enrollment                          | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-faq.html                     | MedEd: FAQ                                 | //*[@class='amp']//a[contains(@href, 'callto')] | true    |

    @ShopPlan_GlobalCompsAARP
    Examples: 
      | path                                                                      | pageName                           | tfnXpath                                                       | tfnFlag |
      | health-plans/shop/connect                                                 | ShopPlan: Request more Info        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop.html                                                    | ShopPlan: Shop                     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/enroll.html                                                  | ShopPlan: Enroll                   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/resources.html                                               | ShopPlan: Resources                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/shop/medicare-advantage-plans.html                           | ShopPlan: Shop MA Plan             | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/medicare-supplement-plans.html                          | ShopPlan: Shop Med Supp Plan       | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/prescription-drug-plans.html                            | ShopPlan: Shop PDP Plan            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | medicare-plans.html                                                       | ShopPlan: Plan Selector            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/shop/compare.html                                            | ShopPlan: Compare                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/estimate.html                                           | ShopPlan: Estimate                 | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/switch.html                                             | ShopPlan: Switch                   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/enroll/ma-enrollment.html                                    | ShopPlan: Enroll MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/enroll/pdp-enrollment.html                                   | ShopPlan: Enroll PDP Plans         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/ma-resources-materials.html                        | ShopPlan: Resources MA Plans       | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/ma-resources-materials/ma-information-forms.html   | ShopPlan: Resources MA Plans Info  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
