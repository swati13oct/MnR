Feature: 1.06-To test request an appointment with an agent flow

  Scenario Outline: Verify request an appointment with an agent flow for <pageName> through <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |

    @agentFlowEBRCUlayer @regressionAARP @agentAppointment
    Examples: 
      | site | path                                                                                                                                                                                                | pageName        | UHCUrl                      |
      | AARP | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary | Connector Modal | https://www.myuhcagent.com/ |
      #| AARP | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | https://www.myuhcagent.com/ |
      #| AARP | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | https://www.myuhcagent.com/ |
      #| AARP | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | https://www.myuhcagent.com/ |
      #| AARP | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | https://www.myuhcagent.com/ |
      #| AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | https://www.myuhcagent.com/ |

    @agentFlowEBRCBlayer @regressionUHC @agentAppointment
    Examples: 
      | site | path                                                                                                                                                                                                | pageName        | UHCUrl                      |
      | UHC  | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary | Connector Modal | https://www.myuhcagent.com/ |
      #| UHC  | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | https://www.myuhcagent.com/ |
      #| UHC  | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | https://www.myuhcagent.com/ |
      #| UHC  | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | https://www.myuhcagent.com/ |
      #| UHC  | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | https://www.myuhcagent.com/ |
      #| UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | https://www.myuhcagent.com/ |

    @agentFlowEBRCUlayer @regressionAARP @agentAppointment
    Examples: 
      | site | path                            | pageName                    | UHCUrl                      |
      | AARP | shop.html                       | ShopPlan: Shop              | https://www.myuhcagent.com/ |
      | AARP | shop/connect                    | ShopPlan: Request more Info | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-ms.html    | ShopPlan: Compare-MS        | https://www.myuhcagent.com/ |
      | AARP | shop/estimate/ms-costs.html     | ShopPlan: Estimate          | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-ma-ms.html | ShopPlan: Compare-MA-MS     | https://www.myuhcagent.com/ |
      | AARP | safe-shopping.html              | ShopPlan: Safe-Shopping     | https://www.myuhcagent.com/ |
      #| AARP | shop.html                       | ShopPlan: Shop              | https://www.myuhcagent.com/ |
      #| AARP | shop/compare.html               | ShopPlan: Compare           | https://www.myuhcagent.com/ |
      #| AARP | shop/estimate.html              | ShopPlan: Estimate          | https://www.myuhcagent.com/ |
      #| AARP | shop/switch.html                | ShopPlan: Switch            | https://www.myuhcagent.com/ |

    @agentFlowEBRCBlayer @regressionUHC @agentAppointment
    Examples: 
      | site | path                            | pageName                    | UHCUrl                      |
      | UHC  | shop.html                       | ShopPlan: Shop              | https://www.myuhcagent.com/ |
      | UHC  | shop/connect                    | ShopPlan: Request more Info | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare-MS        | https://www.myuhcagent.com/ |
      | UHC  | shop/estimate/ms-costs.html     | ShopPlan: Estimate          | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-ma-ms.html | ShopPlan: Compare-MA-MS     | https://www.myuhcagent.com/ |
      | UHC  | safe-shopping.html              | ShopPlan: Safe-Shopping     | https://www.myuhcagent.com/ |
      #| UHC  | shop.html                       | ShopPlan: Shop              | https://www.myuhcagent.com/ |
      #| UHC  | shop/compare.html               | ShopPlan: Compare           | https://www.myuhcagent.com/ |
      #| UHC  | shop/estimate.html              | ShopPlan: Estimate          | https://www.myuhcagent.com/ |
      #| UHC  | shop/switch.html                | ShopPlan: Switch            | https://www.myuhcagent.com/ |

    @agentFlowEBRCUlayer @regressionAARP @agentAppointment
    Examples: 
      | site | path                                                  | pageName                                               | UHCUrl                      |
      | AARP | medicare-articles/eligibility-and-enrollment.html     | medicare-articles: eligibility-and-enrollment          | https://www.myuhcagent.com/ |
#      | AARP | medicare-articles/medicare-costs.html                 | medicare-articles: medicare-costs.html                 | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-benefits-and-coverage.html | medicare-articles: medicare-benefits-and-coverage.html | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-costs.html                 | medicare-articles: medicare-costs.html                 | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/shopping-for-medicare.html          | medicare-articles: shopping-for-medicare.html          | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-when-working-past-65.html  | medicare-articles: medicare-when-working-past-65.html  | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-tips-and-faqs.html         | medicare-articles: medicare-tips-and-faqs.html         | https://www.myuhcagent.com/ |

    @agentFlowEBRCBlayer @regressionUHC @agentAppointment
    Examples: 
      | site | path                                                  | pageName                                               | UHCUrl                      |
      | UHC  | medicare-articles/eligibility-and-enrollment.html     | medicare-articles: eligibility-and-enrollment          | https://www.myuhcagent.com/ |
#      | UHC  | medicare-articles/medicare-costs.html                 | medicare-articles: medicare-costs.html                 | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-benefits-and-coverage.html | medicare-articles: medicare-benefits-and-coverage.html | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-costs.html                 | medicare-articles: medicare-costs.html                 | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/shopping-for-medicare.html          | medicare-articles: shopping-for-medicare.html          | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-when-working-past-65.html  | medicare-articles: medicare-when-working-past-65.html  | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-tips-and-faqs.html         | medicare-articles: medicare-tips-and-faqs.html         | https://www.myuhcagent.com/ |

    #@agentFlowEBRCUlayer @regressionAARP
    #Examples: 
      #| site | path                                | pageName                     | UHCUrl                      |
      #| AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      #| AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      #| AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      #| AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |

    #@agentFlowEBRCBlayer @regressionUHC
    #Examples: 
      #| site | path                                | pageName                     | UHCUrl                      |
      #| UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      #| UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      #| UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      #| UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |

  Scenario Outline: Verify request an appointment with an agent flow for <pageName> through <site> site
   Given the user is on medicare acquisition site landing page fro campaign Traffic
      | Site | <site> |
    Given the user navigates to following Campaign acquisition site page
      # | PageName | <pageName> |
      | PagePath | <path> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |

   @agentFlowEBRCUlayer @regressionAARP @agentAppointment
    Examples: 
      | site | path                                                                                                                                                                                                                       | pageName          | UHCUrl                      | plantype | planyear |
      | AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary | https://www.myuhcagent.com/ | MA       | future   |

    @agentFlowEBRCBlayer @regressionUHC @agentAppointment
    Examples: 
      | site | path                                                                                                                                                                                                                       | pageName          | UHCUrl                      | plantype | planyear |
      | UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary | https://www.myuhcagent.com/ | MA       | future   |
