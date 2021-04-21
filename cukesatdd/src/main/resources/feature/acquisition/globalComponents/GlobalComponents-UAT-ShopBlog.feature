@UATRegression @F448210 @globalComponent
Feature: 1.13 UAT - Shop Blog Pages flows

  @GlobalComponentsAARPShopPages
  Scenario Outline: To verify Zip code and Agent link for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |

    @ShopPages_Shop5_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @ShopPages_Shop5_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @ShopPages_Shop6_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @ShopPages_Shop6_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPShopPages12
  Scenario Outline: To verify TFN on page for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @ShopPages12_Shop5_GlobalCompsAARP @ShopPages16_Shop16_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @ShopPages12_Shop5_GlobalCompsUHC @ShopPages16_Shop16_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @ShopPages12_Shop6_GlobalCompsAARP @ShopPages17_Shop17_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |

    @ShopPages12_Shop6_GlobalCompsUHC @ShopPages17_Shop17_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |

    @ShopPages12_Shop7_GlobalCompsAARP @ShopPages7_Shop7_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   |

    @ShopPages12_Shop7_GlobalCompsUHC @ShopPages7_Shop7_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   |

  @GlobalComponentsAARPShopPages34
  Scenario Outline: To verify proactive chat popup for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates proactive chat popup

    @ShopPages34_Shop5_GlobalCompsAARP @ShopPages8_Shop8_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @ShopPages34_Shop5_GlobalCompsUHC @ShopPages8_Shop8_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @ShopPages34_Shop6_GlobalCompsAARP @ShopPages9_Shop9_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @ShopPages34_Shop6_GlobalCompsUHC @ShopPages10_Shop10_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @ShopPages34_Shop7_GlobalCompsAARP @ShopPages11_Shop11_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

    @ShopPages34_Shop7_GlobalCompsUHC @ShopPages11_Shop11_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPShopPages56
  Scenario Outline: To verify Global Components chat icon for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates whether chat icon is visible

    @ShopPages56_Shop5_GlobalCompsAARP @ShopPages12_Shop12_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @ShopPages56_Shop5_GlobalCompsUHC @ShopPages12_Shop12_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @ShopPages56_Shop6_GlobalCompsAARP @ShopPages13_Shop13_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @ShopPages56_Shop6_GlobalCompsUHC @ShopPages13_Shop13_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @ShopPages56_Shop7_GlobalCompsAARP @ShopPages14_Shop14_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

    @ShopPages56_Shop7_GlobalCompsUHC @ShopPages14_Shop14_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPShopPages78
  Scenario Outline: To verify Global Components TFN on need help section for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on need help section of Shop pages
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    
    @ShopPages78_Shop7_GlobalCompsAARP @ShopPages15_Shop15_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag | hoursxpath                                                                   | hoursFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    | (//div[contains(@ng-show,'medSupTfn')])[1]//p                                | true      |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |

    @ShopPages78_Shop7_GlobalCompsUHC @ShopPages15_Shop15_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   |

  @GlobalComponentsAARPBlogPages
  Scenario Outline: <Scenario>- To verify Zip code and agent link on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on page using ZipCode "55424"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |

    #@BlogPages_GlobalCompsAARP
    @BlogPages_Blog10_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @BlogPages_Blog10_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsAARP
    @BlogPages_Blog10_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @BlogPages_Blog10_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsAARP
    @BlogPages_Blog9_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @BlogPages_Blog9_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPBlogPages12
  Scenario Outline: <Scenario>- To verify TFN on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @BlogPages12_GlobalCompsAARP @BlogPages_Blog8_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages12_GlobalCompsUHC @BlogPages_Blog8_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages12_GlobalCompsAARP @BlogPages_Blog8_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages12_GlobalCompsUHC @BlogPages_Blog8_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages12_GlobalCompsAARP @BlogPages_Blog7_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages12_GlobalCompsUHC @BlogPages_Blog7_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

  @GlobalComponentsAARPBlogPages34
  Scenario Outline: <Scenario>- To verify proactive chat popup on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates proactive chat popup

    @BlogPages34_GlobalCompsAARP @BlogPages_Blog6_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages34_GlobalCompsUHC @BlogPages_Blog6_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages34_GlobalCompsAARP @BlogPages_Blog6_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages34_GlobalCompsUHC @BlogPages_Blog6_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages34_GlobalCompsAARP @BlogPages_Blog5_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @BlogPages34_GlobalCompsUHC @BlogPages_Blog5_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPBlogPages56
  Scenario Outline: <Scenario>- To verify chat icon on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates whether chat icon is visible

    @BlogPages56_GlobalCompsAARP @BlogPages_Blog4_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages56_GlobalCompsUHC @BlogPages_Blog4_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | UHC  | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages56_GlobalCompsAARP @BlogPages_Blog4_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages56_GlobalCompsUHC @BlogPages_Blog4_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages56_GlobalCompsAARP @BlogPages_Blog3_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @BlogPages56_GlobalCompsUHC @BlogPages_Blog3_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPBlogPages78
  Scenario Outline: <Scenario>- To verify call icon on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates whether call icon is visible

    @BlogPages78_GlobalCompsAARP @BlogPages2_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages78_GlobalCompsUHC @BlogPages2_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                              | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Sample Category Page   | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages78_GlobalCompsAARP @BlogPages2_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages78_GlobalCompsUHC @BlogPages2_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages78_GlobalCompsAARP @BlogPages1_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @BlogPages78_GlobalCompsUHC @BlogPages1_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

  @GlobalComponentsAARPBlogPages99
  Scenario Outline: <Scenario>- To verify TFN on right rail of medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates TFN on right rail Medicare Article
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @BlogPages_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @BlogPages_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

  @GlobalComponentsAARPBlogPages2
  Scenario Outline: <Scenario>- To verify email on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user enters and validate the fields and clicks on submit

    @BlogPages_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                       | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                     | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                       | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                     | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html | MMC page               | https://www.myuhcagent.com/ |

    @BlogPages_GlobalCompsAARP @regressionAARP 
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |

    @BlogPages_GlobalCompsUHC  @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ |
