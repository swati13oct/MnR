@tfn_blayer @F513647
Feature: To test TFN in all flows on UHC site

  @Scenario1 @tfn_Direct_Traffic_old @tfn_uhc
  Scenario Outline: 1.0 Verify TFN in all VPP Tabs and PDP OLE with Direct Traffic on UHC site
    Given user is on UMS Prod and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then user navigate to Medicare Edu and varify TFN on Righ Rail
      | Med Ed TFN | <medEdTfn> |
    Then user enter zip on bottom of MEd Ed page and click to view MA Plans and varify TFN on Right Rail
      | MA Plan TFN | <maPlanTfn> |
    Then user varifies Med Sup tab TFN
      | Med Sup TFN | <medSupTfn> |
    Then user varifies PDP Tab TFN
      | PDP TFN | <pdpTfn> |
    Then user click the View plan and drug coverage details button for any PDP Plan and Click the Enroll in plan button to varify TFN
      | PDP TFN | <pdpTfn> |
    Then user Verify the Right Rail TFN on PDP OLE
      | PDP TFN | <pdpTfn> |

    Examples: 
      | url                                  | ampTFN         | medEdTfn       | maPlanTfn      | medSupTfn      | pdpTfn         |
      | https://www.uhcmedicaresolutions.com | 1-877-596-3258 | 1-877-596-3258 | 1-877-596-3258 | 1-877-596-3258 | 1-877-596-3258 |

  @Scenario2a @campaign_traffic @tfn_uhc
  Scenario Outline: 2.1 To varify TFN landing in campaing url
    Given user is landing on UHC via campaign url
      | URL | <url> |
    Then user navigates to MA VPP tab to vaify TFN
      | MA TFN | <maTabTfn> |

    Examples: 
      | url                                                   | maTabTfn       |
      | https://ma.uhcmedicaresolutions.com/?wt.mc_id=8003728 | 1-855-448-4586 |

  @Scenario2b @campaign_traffic @tfn_uhc
  Scenario Outline: 2.2 Varify all TAB TFn by landing on campaign specific url 8003728
    Given 
      | URL | <url> |
    Then user navigates to MA VPP tab to vaify TFN from this specific url
      | MA TFN | <maTabTfn> |
    Then user varifies Med Sup tab TFN from this specific url
      | Med Sup TFN | <medSupTfn> |
    Then user varifies PDP Tab TFN
      | PDP TFN | <pdpTfn> |
    Then user click the View plan and drug coverage details button for any PDP Plan and Click the Enroll in plan button to varify TFN
      | PDP TFN | <pdpTfn> |
    Then user Verify the Right Rail TFN on PDP OLE
      | PDP TFN | <pdpTfn> |

    Examples: 
      | url                                                                                                              | maTabTfn       | medSupTfn      | pdpTfn         |
      | https://www.uhcmedicaresolutions.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728 | 1-855-448-4586 | 1-866-271-0607 | 1-855-448-4586 |

  @Scenario3a @Organic_Search_Google @tfn_uhc
  Scenario Outline: - 3.1 Google  search UHC Medicare Advantage Plan
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then user navigate to MedSup from Google to varify TFN
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                     |
      | 1-800-607-2877 | 1-888-378-0849 | https://www.google.com/ |

  @Scenario3b @Organic_Search_Bing @tfn_uhc
  Scenario Outline: - 3.2 Bing  search UHC Medicare Advantage Plan
    Given user is on Bing and search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then user navigate to MedSup from Bing to varify TFN
      | MedSup TFN | <medSupTFN> |
    Then user navigate to PDP to varify  TFN via Bing
      | PDP TFN | <pdpTfn> |

    Examples: 
      | ampTFN         | medSupTFN      | pdpTfn         | url                   |
      | 1-800-811-2341 | 1-888-378-0849 | 1-800-811-2341 | https://www.bing.com/ |

  @Scenario4A @UMS_Via_Direct_url @Campaign_Precedence_Logic @tfn_uhc
  Scenario Outline: - 4.1 Visit AMP using Direct URL after clearing cache
    Given user visits UMS site using Direct URL and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then user navigate to MedSup from Direct url to varify TFN
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                                   |
      | 1-877-596-3258 | 1-877-596-3258 | https://www.uhcmedicaresolutions.com/ |

  @Scenario4B @Campaign_Precedence_Logic @tfn_uhc
  Scenario Outline: -4.2 Visit UMS using  ums url id 800085, 800086, Direct URL,
    Given user visits UMS using  specific URL and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then navigate to MedSup to varify TFN from specific UMS url
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                                                   |
      | 1-888-262-3289 | 1-866-260-5005 | https://www.uhcmedicaresolutions.com/?WT.mc_id=800085 |
      | 1-888-581-8578 | 1-866-260-5005 | https://www.uhcmedicaresolutions.com/?WT.mc_id=800086 |
      | 1-877-596-3258 | 1-877-596-3258 | http://www.uhcmedicaresolutions.com/                  |

  @Scenario4C @Campaign_Precedence_Logic @tfn_uhc
  Scenario Outline: - 4.3 Google  search UHC Medicare Advantage Plan
    Given user is on Google  search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then navigate from Google via uhc site to MedSup to varify TFN
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                    |
      | 1-800-607-2877 | 1-888-378-0849 | https://www.google.com |

  @Scenario4D @Campaign_Precedence_Logic @tfn_uhc
  Scenario Outline: - 4.4 yahoo search supercedes Google  search UHC Medicare Advantage Plan
    Given user is on Yahoo search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN
      | URL    | <url>    |
      | AMPTFN | <ampTFN> |
    Then navigate from yahoo via uhc site to MedSup to varify TFN
      | MedSup TFN | <medSupTFN> |

    Examples: 
      | ampTFN         | medSupTFN      | url                   |
      | 1-800-850-8659 | 1-888-378-0849 | https://www.yahoo.com |

  @Scenario5A @ConnectorModelPlus_UHC
  Scenario Outline: Verify TFN and PSC code from External links to portal landing
    Given user is landing from Externallinks
      | URL | <url> |
    Then user clicks on learn about Medicare"<learnMoreurl>"
    Then user verify TFN
      | TFN | <TFN> |
    Then user clicks on Get Help Finding a Plan"<GetHelpurl>"
    Then user enters zipcode "<zipcode>"	and user navigates to page"<Pageurl>"
    Then user verify VPP TFN
      | VPPTFN | <VPPTFN> |

    Examples: 
      | url                            | TFN            | PSC     | VPPTFN         | VPPPSC | learnMoreurl                                                                                                                                                             | GetHelpurl                                                                         | zipcode | Pageurl                                                                                                                                                                                                                                                                             |
      | https://myuhcplans.com/eaton   | 1-844-462-9435 | 8006890 | 1-888-270-6995 | 897576 | https://eaton.stage-uhcmedicaresolutions.uhc.com/medicare-education.html?WT.mc_id=8006890&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton       | https://eaton.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html   |   37211 | https://eaton.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?zipcode=37211&WT.mc_id=897576&county=180&state=47&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Featon&subdomain=eaton#/plan-summary       |
      | https://myuhcplans.com/options | 1-844-462-9433 | 8006889 | 1-800-425-0721 | 897579 | https://options.stage-uhcmedicaresolutions.uhc.com/medicare-education.html?WT.mc_id=8006889&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Foptions&subdomain=options | https://options.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html |   37211 | https://options.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?zipcode=37211&WT.mc_id=897579&county=180&state=47&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Foptions&subdomain=options#/plan-summary |
      | https://myuhcplans.com/kohler  | 1-844-462-9437 | 8006891 | 1-866-658-9431 | 897577 | https://kohler.stage-uhcmedicaresolutions.uhc.com/medicare-education.html?WT.mc_id=8006891&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fkohler&subdomain=kohler    | https://kohler.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html  |   37211 | https://kohler.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?zipcode=37211&WT.mc_id=897577&county=180&state=47&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fkohler&subdomain=kohler#/plan-summary    |
      | https://myuhcplans.com/retiree | 1-844-462-9434 | 8006895 | 1-877-776-1458 | 897580 | https://retiree.stage-uhcmedicaresolutions.uhc.com/medicare-education.html?WT.mc_id=8006895&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Fretiree&subdomain=retiree | https://retiree.stage-uhcmedicaresolutions.uhc.com/plan-recommendation-engine.html |   37211 | https://retiree.stage-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?zipcode=37211&WT.mc_id=897580&county=180&state=47&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fretiree&subdomain=retiree#/plan-summary |
