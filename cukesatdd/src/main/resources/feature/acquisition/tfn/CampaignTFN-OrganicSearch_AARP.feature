@organicSearchTFN_AARP
Feature: To test Organic SearchCampaign TFN on AARP site

  @Scenario6B_GoogleSearch_AARP @Campaign_Precedence_Logic @tfn_aarp
  Scenario Outline: - 6.2 Google and search AARP Medicare Advantage Plan
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      |  810106 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario6G_YahooSearch_AARP @Campaign_Precedence_Logic @campaign
  Scenario Outline: - 6.7 Yahoo and search AARP Medicare Advantage Plan
    Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      |  810105 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario3b_BingSearch_AARP @Organic_Search_Bing
  Scenario Outline: - 3.2 Bing  search AARP Medicare Advantage Plan
    Given user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      |  810104 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_6_Precedence_AARP @tfn_Campaign_Traffic
  Scenario Outline: 1.0 Verify TFN in VPP Tabs and PDP OLE
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | site   | pscCode | campaignUrl                                                                | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     | 
      | ulayer | 8001038 | /health-plans/shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 