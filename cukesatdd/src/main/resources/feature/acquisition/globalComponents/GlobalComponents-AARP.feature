@GlobalComponentsAARP
Feature: 1.12 ACQ - Global Components Validation


  @globalfooterULayer
  Scenario Outline: To verify links displayed in the global footer of AARP site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user accesses global footer of the Medicare Plans All page
    And user vaidates the state drop down link on the home page
    And user clicks on View all disclaimer information link on the home page
    And user verifies visit aarp.org link on home page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And user clicks on contactus link on aboutus page
    And user clicks on sitemap link on contactus page
    And user clicks on privacypolicy link on sitemap page
    And user clicks on termsOfuse link on privacypolicy page
    And user clicks on disclaimers link on terms&conditions page
    And user clicks on agents&brokers link on disclaimers page
    And user verifies home link of agents&brokers page
    Then user clicks on back to top link of home page

    @globalfooter1
    Examples: 
      | site |
      | AARP |

    @globalfooter
    Examples: 
      | site |
      | UHC  |

  @globalheaderULayer
  Scenario Outline: To verify links displayed in the global header of AARP site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo on home page
    And user clicks on Sign in link in the header
    And user clicks on register link in the header
    Then user clicks on the heart icon in the header

    @globalheader
    Examples: 
      | site |
      | AARP |

    @globalheader
    Examples: 
      | site |
      | UHC  |

  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of <site> site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible

    # Then the user validates SAM re-active Chat
    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | site | path                                                     | pageName                              | tfnXpath                                                             | tfnFlag |
      | AARP | medicare-education.html                                  | Understanding Medicare                | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | AARP | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  | //*[@class='amp']//a[contains(@class, 'tel')]                        | true    |
      | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | AARP | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @MedEdPages_1_GlobalCompsUHC
    Examples: 
      | site | path                                                     | pageName                                     | tfnXpath                                                             | tfnFlag |
      | UHC  | medicare-education.html                                  | Understanding Medicare                       | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | UHC  | medicare-education/medicare-eligibility.html             | Medicare Eligibility                         | //*[@class='ums']//a[contains(@class, 'tel')]                        | true    |
      | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Choices        | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | UHC  | medicare-education/medicare-benefits.html                | Medicare Prescriptions, Providers & Benefits | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      | site | path                                              | pageName                              | tfnXpath                                                             | tfnFlag |
      | AARP | medicare-education/medicare-advantage-plans.html  | Learn about Medicare Advantage Plans  | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | AARP | medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans | //div[contains(@class,'amp')]//a[contains(@class,'tel')]             | true    |
      | AARP | medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @MedEdPages_2_GlobalCompsUHC
    Examples: 
      | site | path                                              | pageName                            | tfnXpath                                                             | tfnFlag |
      | UHC  | medicare-education/medicare-advantage-plans.html  | Medicare Advantage (Part C) Plans   | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | UHC  | medicare-education/medicare-supplement-plans.html | Medicare Supplement Insurance Plans | //div[contains(@class,'ums')]//a[contains(@class,'tel')]             | true    |
      | UHC  | medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans    | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      | site | path                                                  | pageName                   | tfnXpath                                                             | tfnFlag |
      | AARP | medicare-education/medicare-costs.html                | Medicare Cost Basics       | //div[contains(@class,'amp')]//a[contains(@class,'tel')]             | true    |
      | AARP | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | AARP | medicare-education/medicare-faq.html                  | Medicare FAQ               | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @MedEdPages_3_GlobalCompsUHC
    Examples: 
      | site | path                                                  | pageName                   | tfnXpath                                                             | tfnFlag |
      | UHC  | medicare-education/medicare-costs.html                | Medicare Cost Basics       | //div[contains(@class,'ums')]//a[contains(@class,'tel')]             | true    |
      | UHC  | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |
      | UHC  | medicare-education/medicare-faq.html                  | Medicare FAQ               | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] | true    |

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      | site | path                            | pageName                    | tfnXpath                                                                                  | tfnFlag |
      | AARP | shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]                       | true    |
      | AARP | shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3]                       | true    |
      | AARP | shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |
      | AARP | shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | AARP | shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | AARP | shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | AARP | shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |
      | AARP | safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |

    @ShopPlan_Shop1_GlobalCompsUHC
    Examples: 
      | site | path                            | pageName                    | tfnXpath                                                                                  | tfnFlag |
      | UHC  | shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]                       | true    |
      | UHC  | shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3]                       | true    |
      | UHC  | shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |
      | UHC  | shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | UHC  | shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | UHC  | shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |
      | UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |
      | UHC  | safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |

    @ShopPlan_Shop2_GlobalCompsAARP
    Examples: 
      | site | path                                | pageName                     | tfnXpath                                                            | tfnFlag |
      | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  | true    |
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[2] | true    |
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])              | true    |
      | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true    |
      | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |
      | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true    |
      | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |

    @ShopPlan_Shop2_GlobalCompsUHC
    Examples: 
      | site | path                                | pageName                     | tfnXpath                                                            | tfnFlag |
      | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  | true    |
      | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[2] | true    |
      | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])              | true    |
      | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true    |
      | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |
      | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true    |
      | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |

    @ShopPlan_Shop3_GlobalCompsAARP
    Examples: 
      | site | path                          | pageName                    | tfnXpath                                                       | tfnFlag |
      | AARP | shop/compare/compare-pdp.html | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/compare/compare-ma.html  | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/estimate/ma-costs.html   | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/estimate/pdp-costs.html  | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop3_GlobalCompsUHC
    Examples: 
      | site | path                          | pageName                    | tfnXpath                                                       | tfnFlag |
      | UHC  | shop/compare/compare-pdp.html | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/compare/compare-ma.html  | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/estimate/ma-costs.html   | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/estimate/pdp-costs.html  | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop4_GlobalCompsAARP
    Examples: 
      | site | path                                                      | pageName                        | tfnXpath                                                       | tfnFlag |
      | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop4_GlobalCompsUHC
    Examples: 
      | site | path                                                      | pageName                        | tfnXpath                                                       | tfnFlag |
      | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Enroll1_GlobalCompsAARP
    Examples: 
      | site | path                       | pageName                   | tfnXpath                                                       | tfnFlag |
      | AARP | enroll.html                | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |

    @ShopPlan_Enroll1_GlobalCompsUHC
    Examples: 
      | site | path                       | pageName                   | tfnXpath                                                       | tfnFlag |
      | UHC  | enroll.html                | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      | site | path                                                         | pageName                                | tfnXpath                                                       | tfnFlag |
      | AARP | resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | resources/mail-order-pharmacy.html                           | ShopPlan: Resources Mail Order Pharmacy | (//*[contains(@class,'tel')])[2]                               | false   |

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      | site | path                                                         | pageName                                | tfnXpath                                                       | tfnFlag |
      | UHC  | resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | resources/mail-order-pharmacy.html                           | ShopPlan: Resources Mail Order Pharmacy | (//*[contains(@class,'tel')])[2]                               | false   |

    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      | site | path                                                       | pageName                          | tfnXpath                                                       | tfnFlag |
      | AARP | resources/ma-resources-materials.html                      | ShopPlan: Resources MA Plans      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | resources/ma-resources-materials/ma-information-forms.html | ShopPlan: Resources MA Plans Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |

    @ShopPlan_Resources3_GlobalCompsUHC
    Examples: 
      | site | path                                                       | pageName                          | tfnXpath                                                       | tfnFlag |
      | UHC  | resources/ma-resources-materials.html                      | ShopPlan: Resources MA Plans      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | resources/ma-resources-materials/ma-information-forms.html | ShopPlan: Resources MA Plans Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |

    # Replace any "#" chars in the deeplink with "!"
    @VPP_Deeplinks_GlobalCompsAARP
    Examples: 
      | site | path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                               | tfnFlag |
      | AARP | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                           | true    |
      | AARP | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                           | true    |
      | AARP | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                           | true    |
      | AARP | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                           | true    |
      | AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                           | false   |
      | AARP | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | (//a[contains(@href ,'tel') and contains(@class,'tel')])[2] | true    |

    # Replace any "#" chars in the deeplink with "!"
    @VPP_Deeplinks_GlobalCompsUHC
    Examples: 
      | site | path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                               | tfnFlag |
      | UHC  | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                           | true    |
      | UHC  | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                           | true    |
      | UHC  | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                           | true    |
      | UHC  | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                           | true    |
      | UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                           | false   |
      | UHC  | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | (//a[contains(@href ,'tel') and contains(@class,'tel')])[2] | true    |

    @MiscellaneousLinks_GlobalCompsAARP @prod_regression
    Examples: 
      | site | path                                                       | pageName                | tfnXpath                                                       | tfnFlag |
      | AARP | health-plans/estimate-drug-costs.html!/drug-cost-estimator | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      | AARP | health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      | AARP | medicare-plans.html                                        | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | profile/guest                                              | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                    | true    |

    @MiscellaneousLinks_GlobalCompsUHC @prod_regression
    Examples: 
      | site | path                                                       | pageName                | tfnXpath                                                       | tfnFlag |
      | UHC  | health-plans/estimate-drug-costs.html!/drug-cost-estimator | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      | UHC  | health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      | UHC  | medicare-plans.html                                        | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | profile/guest                                              | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                    | true    |

    @FooterLinks_GlobalCompsAARP
    Examples: 
      | site | path                          | pageName                   | tfnXpath                     | tfnFlag |
      | AARP | about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      | AARP | sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      | AARP | terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      | AARP | disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      | AARP | health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      | AARP | contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      | AARP | privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |

    @FooterLinks_GlobalCompsUHC
    Examples: 
      | site | path                          | pageName                   | tfnXpath                     | tfnFlag |
      | UHC  | about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      | UHC  | sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      | UHC  | terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      | UHC  | disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      | UHC  | health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      | UHC  | contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      | UHC  | privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |

  @GlobalComponentsAARP_ISonlyPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "90210"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @MedSuppOnlyPages_GlobalCompsAARP
    Examples: 
      | site | path                                                         | pageName          | tfnXpath       | tfnFlag |
      | AARP | medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide    | //*[@id='tfn'] | true    |
      | AARP | medicare-supplement-plans/agent-appointment.html             | Agent Appointment | //*[@id='tfn'] | true    |

    @MedSuppOnlyPages_GlobalCompsUHC
    Examples: 
      | site | path                                                         | pageName          | tfnXpath       | tfnFlag |
      | UHC  | medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide    | //*[@id='tfn'] | true    |
      | UHC  | medicare-supplement-plans/agent-appointment.html             | Agent Appointment | //*[@id='tfn'] | true    |

  @GlobalComponentsAARPNewShopPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "90210"
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @GlobalComponentsAARPNewShopPages1
    Examples: 
      | path                               | pageName               | tfnXpath                                                           | tfnFlag |
      | shop/medicare-advantage-plans.html | ShopPlan: Shop MA Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

  @GlobalComponentsAARPShopPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"

    @ShopPages_Shop_GlobalCompsAARP
    Examples: 
      | site | path                                                | pageName             |
      | AARP | contact-us.html                                     | Contact us           |
      | AARP | shop/estimate/ma-costs.html                         | Estimate  MA         |
      | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP         |
      | AARP | shop/switch.html                                    | Switch               |
      | AARP | shop/renew-active.html                              | Renew Active         |
      | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits     |
      | AARP | shop/compare/compare-ma.html                        | Compare MA           |
      | AARP | shop/compare/compare-pdp.html                       | Compare PDP          |
      | AARP | shop/medicare-advantage-veteran-plan.html           | MA Veteran Plan      |
      | AARP | enroll/ma-enrollment.html                           | MA Enrollment        |
      | AARP | enroll/pdp-enrollment.html                          | PDP Enrollment       |
      | AARP | medicare-articles/eligibility-and-enrollment.html   | Sample Category Page |

    @ShopPages_Shop_GlobalCompsUHC
    Examples: 
      | site | path                                                | pageName             |
      | UHC  | contact-us.html                                     | Contact us           |
      | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA         |
      | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP         |
      | UHC  | shop/switch.html                                    | Switch               |
      | UHC  | shop/renew-active.html                              | Renew Active         |
      | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits     |
      | UHC  | shop/compare/compare-ma.html                        | Compare MA           |
      | UHC  | shop/compare/compare-pdp.html                       | Compare PDP          |
      | UHC  | shop/medicare-advantage-veteran-plan.html           | MA Veteran Plan      |
      | UHC  | enroll/ma-enrollment.html                           | MA Enrollment        |
      | UHC  | enroll/pdp-enrollment.html                          | PDP Enrollment       |
      | UHC  | medicare-articles/eligibility-and-enrollment.html   | Sample Category Page |

  @GlobalComponentsAARPBlogPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user hover over Shop for a Plan and validates zipcode component
    Then the user validate ZipCode Components on SubNav using ZipCode "10001"

    @Global_Comps_ZipSubNav_AARP2
    Examples: 
      | site | path      | pageName           |
      | AARP | shop.html | ShopPlan: Homepage |

    @Global_Comps_ZipSubNav_AARP
    Examples: 
      | site | path                                                                                    | pageName                        |
      | AARP | shop.html                                                                               | ShopPlan: Homepage              |
      | AARP | shop/medicare-advantage-plans.html                                                      | ShopPlan: Shop MA Plan          |
      | AARP | shop/medicare-supplement-plans.html                                                     | ShopPlan: Shop MS Plan          |
      | AARP | shop/prescription-drug-plans.html                                                       | ShopPlan: Shop PDP Plan         |
      | AARP | shop/dual-special-needs-plans.html                                                      | ShopPlan: Shop SNP Plan         |
      | AARP | safe-shopping.html                                                                      | ShopPlan: Safe Shopping         |
      | AARP | shop/compare/compare-ma-ms.html                                                         | ShopPlan: Compare MA-MS         |
      | AARP | shop/compare/compare-ms.html                                                            | ShopPlan: Compare MS            |
      | AARP | enroll.html                                                                             | ShopPlan: Enrollment Homepage   |
      | AARP | enroll/ms-apply.html                                                                    | ShopPlan: MS Enrollment         |
      | AARP | enroll/ma-enrollment.html                                                               | ShopPlan: MA Enrollment         |
      | AARP | enroll/pdp-enrollment.html                                                              | ShopPlan: PDP Enrollment        |
      | AARP | shop/compare.html                                                                       | ShopPlan: Compare Homepage      |
      | AARP | shop/compare/compare-ma.html                                                            | ShopPlan: Compare MA            |
      | AARP | shop/compare/compare-pdp.html                                                           | ShopPlan: Compare PDP           |
      | AARP | shop/estimate.html                                                                      | ShopPlan: Estimate Homepage     |
      | AARP | shop/estimate/ms-costs.html                                                             | ShopPlan: Estimate MS           |
      | AARP | shop/estimate/ma-costs.html                                                             | ShopPlan: Estimate  MA          |
      | AARP | shop/estimate/pdp-costs.html                                                            | ShopPlan: Estimate  PDP         |
      | AARP | shop/switch.html                                                                        | ShopPlan: Switch                |
      | AARP | resources/mail-order-pharmacy.html                                                      | ShopPlan: Mail ORDER-PHARMACY   |
      | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html                                     | ShopPlan: MA Plan benefits      |
      | AARP | contact-us.html                                                                         | Contact us                      |
      | AARP | shop/renew-active.html                                                                  | ShopPlan: Renew Active          |
      | AARP | shop/medicare-advantage-veteran-plan.html                                               | ShopPlan: MA Veteran Plan       |
      | AARP | medicare-articles.html                                                                  | ShopPlan: Articles              |
      | AARP | medicare-articles/eligibility-and-enrollment.html                                       | ShopPlan: Sample Category Page  |
      | AARP | medicare-articles/medicare-made-clear.html                                              | ShopPlan: About MMC             |
      | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | ShopPlan: Sample Article Page 1 |
      | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | ShopPlan: Retiree Health        |
      | AARP | about-us.html                                                                           | About Us Page                   |

    #| AARP | sitemap.html                                                                                                 | Site Map Page                   |
    #| AARP | privacy-policy.html                                                                                          | Privacy Policy Page             |
    #| AARP | terms-of-use.html                                                                                            | Terms of Use Page               |
    #| AARP | site-search.html                                                                                             | Site Search Page                |
    #| AARP | profile                                                                                                      | Visitor Profile Page            |
    #| AARP | health-plans/estimate-drug-costs.html/drug-cost-estimator                                                    | DCE Page                        |
    #| AARP | health-plans/aarp-pharmacy.html/Pharmacy-Search-English                                                      | Pharmacy Search Page            |
    #| AARP | health-plans/medicare-supplement-plans/agent-appointment.html                                                | MS Agent Appointment Page       |
    #| AARP | https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-supplement-plans/medicare-information.html | Agent Appointment Page          |
    @Global_Comps_ZipSubNav_UHC
    Examples: 
      | site | path                                                                                    | pageName                        |
      | UHC  | shop.html                                                                               | ShopPlan: Homepage              |
      | UHC  | shop/medicare-advantage-plans.html                                                      | ShopPlan: Shop MA Plan          |
      | UHC  | shop/medicare-supplement-plans.html                                                     | ShopPlan: Shop MS Plan          |
      | UHC  | shop/prescription-drug-plans.html                                                       | ShopPlan: Shop PDP Plan         |
      | UHC  | shop/dual-special-needs-plans.html                                                      | ShopPlan: Shop SNP Plan         |
      | UHC  | safe-shopping.html                                                                      | ShopPlan: Safe Shopping         |
      | UHC  | shop/compare/compare-ma-ms.html                                                         | ShopPlan: Compare MA-MS         |
      | UHC  | shop/compare/compare-ms.html                                                            | ShopPlan: Compare MS            |
      | UHC  | enroll.html                                                                             | ShopPlan: Enrollment Homepage   |
      | UHC  | enroll/ms-apply.html                                                                    | ShopPlan: MS Enrollment         |
      | UHC  | enroll/ma-enrollment.html                                                               | ShopPlan: MA Enrollment         |
      | UHC  | enroll/pdp-enrollment.html                                                              | ShopPlan: PDP Enrollment        |
      | UHC  | shop/compare.html                                                                       | ShopPlan: Compare Homepage      |
      | UHC  | shop/compare/compare-ma.html                                                            | ShopPlan: Compare MA            |
      | UHC  | shop/compare/compare-pdp.html                                                           | ShopPlan: Compare PDP           |
      | UHC  | shop/estimate.html                                                                      | ShopPlan: Estimate Homepage     |
      | UHC  | shop/estimate/ms-costs.html                                                             | ShopPlan: Estimate MS           |
      | UHC  | shop/estimate/ma-costs.html                                                             | ShopPlan: Estimate  MA          |
      | UHC  | shop/estimate/pdp-costs.html                                                            | ShopPlan: Estimate  PDP         |
      | UHC  | shop/switch.html                                                                        | ShopPlan: Switch                |
      | UHC  | resources/mail-order-pharmacy.html                                                      | ShopPlan: Mail ORDER-PHARMACY   |
      | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html                                     | ShopPlan: MA Plan benefits      |
      | UHC  | contact-us.html                                                                         | Contact us                      |
      | UHC  | shop/renew-active.html                                                                  | ShopPlan: Renew Active          |
      | UHC  | shop/medicare-advantage-veteran-plan.html                                               | ShopPlan: MA Veteran Plan       |
      | UHC  | medicare-articles.html                                                                  | ShopPlan: Articles              |
      | UHC  | medicare-articles/eligibility-and-enrollment.html                                       | ShopPlan: Sample Category Page  |
      | UHC  | medicare-articles/medicare-made-clear.html                                              | ShopPlan: About MMC             |
      | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | ShopPlan: Sample Article Page 1 |
      | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | ShopPlan: Retiree Health        |
      | UHC  | about-us.html                                                                           | About Us Page                   |

  #| UHC  | sitemap.html                                                                                                 | Site Map Page                   |
  #| UHC  | privacy-policy.html                                                                                          | Privacy Policy Page             |
  #| UHC  | terms-of-use.html                                                                                            | Terms of Use Page               |
  #| UHC  | site-search.html                                                                                             | Site Search Page                |
  #| UHC  | profile                                                                                                      | Visitor Profile Page            |
  #| UHC  | health-plans/estimate-drug-costs.html/drug-cost-estimator                                                    | DCE Page                        |
  #| UHC  | health-plans/aarp-pharmacy.html/Pharmacy-Search-English                                                      | Pharmacy Search Page            |
  #| UHC  | health-plans/medicare-supplement-plans/agent-appointment.html                                                | MS Agent Appointment Page       |
  #| UHC  | https://www.stage-aarpmedicareplans.uhc.com/health-plans/medicare-supplement-plans/medicare-information.html | Agent Appointment Page          |
  @GlobalComponentsAARPPages
  Scenario Outline: To verify the components present on the Shop page on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user hovers screen over the shop for a plan
    Then the user clicks on the Shop link and lands on the shop page
    Then the user clicks on the Shop button for Medicare Advantage Plan and navigates to MA plans page
    Then the user clicks on browser back button
    Then the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page
    Then the user clicks on browser back button
    Then the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page
    Then the user clicks on browser back button
    Then the user clicks on Compare Plans button and navigate to Shop Plan Compare Page
    Then the user clicks on browser back button
    Then the user clicks on Learn button and navigate to Shop Plan Estimate Costs Page
    Then the user clicks on browser back button
    Then the user clicks on How To button and navigate to Shop Plan Switch Page
    Then the user clicks on browser back button
    Then the user clicks on Learn More button and navigate to Safe Shopping Page
    Then the user clicks on browser back button
    Then the user clicks on Get Resources button and navigate to Member Resources Page
    Then the user clicks on browser back button
    Then the user validates Personalize Your Results section in Shop page
    Then the user clicks on Check Drug Costs button and navigate to DCE Page
    Then the user clicks on browser back button
    Then the user clicks on Locate a Pharmacy button and navigate to Pharmacy Page
    Then the user clicks on browser back button
    Then the user clicks on Find a Provider button and navigate to Werally Page
    Then the user validate ZipCode Components on Shop pages using ZipCode "10001"
    Then the user clicks on Agent link and validates the correct URL is loaded from shop page
      | UHC Agent URL | <UHCUrl> |
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      | site | tfnXpath            | tfnFlag                                       |      | UHCUrl                      |
      | AARP | AARP Medicare Plans | //*[@class='amp']//a[contains(@class, 'tel')] | true | https://www.myuhcagent.com/ |

    @ShopPlan_Shop1_GlobalCompsUHC
    Examples: 
      | site | tfnXpath            | tfnFlag                                       |      | UHCUrl                      |
      | UHC  | AARP Medicare Plans | //*[@class='amp']//a[contains(@class, 'tel')] | true | https://www.myuhcagent.com/ |


  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    # Then the user validates TFN on the page
    #   | TFNxpath | <tfnXpath> |
    #   | TFNflag  | <tfnFlag>  |
    # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible

    @ShopPlan_Resources1_GlobalCompsAARP
    Examples: 
      | site | path                                                 | pageName                             | tfnXpath                                                       | tfnFlag |
      | AARP | resources.html                                       | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | AARP | resources/medication-therapy-management-program.html | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/how-to-appoint-a-representative.html       | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/prescription-drug-costs-help.html          | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/healthcare-fraud.html                      | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/how-to-pay-your-premium.html               | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Resources1_GlobalCompsUHC
    Examples: 
      | site | path                                                 | pageName                             | tfnXpath                                                       | tfnFlag |
      | UHC  | resources.html                                       | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | UHC  | resources/medication-therapy-management-program.html | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/how-to-appoint-a-representative.html       | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/prescription-drug-costs-help.html          | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/healthcare-fraud.html                      | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/how-to-pay-your-premium.html               | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      | site | path                                                                              | pageName                                         | tfnXpath                    | tfnFlag |
      | AARP | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')] | true    |
      | AARP | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')] | true    |
      | AARP | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')] | true    |

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      | site | path                                                                              | pageName                                         | tfnXpath                    | tfnFlag |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')] | true    |
      | UHC  | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')] | true    |
      | UHC  | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')] | true    |

    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      | site | path                                                                       | pageName                               | tfnXpath                                                       | tfnFlag |
      | AARP | resources/ma-resources-materials/ma-information-forms/member-rights.html   | ShopPlan: Resources MA Member Rights   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html | ShopPlan: Resources MA Appeals         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/disenrollment-information.html                                   | ShopPlan: Resources PDP Disenrollment  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | AARP | resources/disenrollment-information.html                                   | ShopPlan: Resources Disenrollment Page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Resources3_GlobalCompsUHC
    Examples: 
      | site | path                                                                       | pageName                               | tfnXpath                                                       | tfnFlag |
      | UHC  | resources/ma-resources-materials/ma-information-forms/member-rights.html   | ShopPlan: Resources MA Member Rights   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html | ShopPlan: Resources MA Appeals         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/disenrollment-information.html                                   | ShopPlan: Resources PDP Disenrollment  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | UHC  | resources/disenrollment-information.html                                   | ShopPlan: Resources Disenrollment Page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |


  @GlobalComponentsAARPPages
  Scenario Outline: To verify the components present on the Enroll page on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user hovers screen over the shop for a plan
    Then the user click on Enroll link and lands on Enroll Page
    Then the user click on MA Enroll Start button on Enroll Page
    Then the user clicks on browser back button
    Then the user click on PDP Enroll Start button on Enroll Page
    Then the user clicks on browser back button
    Then the user click on MedSupp Enroll Start button on Enroll Page
    Then the user clicks on browser back button
    Then the user clicks on Learn About Eligibility link on Enroll Page
    Then the user clicks on browser back button
    Then the user clicks on Learn About Enrollment link on Enroll Page

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      | site |
      | AARP |

    @ShopPlan_Shop1_GlobalCompsUHC @TestEnroll
    Examples: 
      | site |
      | UHC  |

  @GlobalComponentsAARPPages
  Scenario Outline: To verify the components present on the Resources page on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user hovers screen over the shop for a plan
    Then the user clicks on Member Resources link and lands on Resource Page
    Then the user clicks on Search Now button to land on Plan Doc search Page
    Then the user clicks on browser back button
    Then user click on Find Information button and Plan Info page
    Then the user clicks on browser back button
    Then user click on Plan Benefit link
    Then the user clicks on browser back button
    Then user click on Wellness Resources link
    Then the user clicks on browser back button
    Then user click on Clinical Program link
    Then the user clicks on browser back button
    Then user click on Learn more link for mail order pharmacy
    Then the user clicks on browser back button
    Then user click on Get Informed button for Preventing Medical Fraud link
    Then the user clicks on browser back button

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      | site |
      | AARP |

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      | site |
      | UHC  |

