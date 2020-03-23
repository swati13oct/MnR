@GlobalComponentsAARP
Feature: 1.12 ACQ - Global Components AARP

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
    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      | path                                                     | pageName                                   | tfnXpath                                        | tfnFlag |
      | medicare-education.html                                  | MedEd: Landing                             | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='amp']//a[contains(@href, 'callto')] | true    |

    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      | path                                              | pageName              | tfnXpath                                        | tfnFlag |
      | medicare-education/medicare-advantage-plans.html  | MedEd: MA Plans       | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-supplement-plans.html | MedEd: Med Supp plans | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-part-d.html           | MedEd: PDP Plans      | //*[@class='amp']//a[contains(@href, 'callto')] | true    |

    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      | path                                                  | pageName                    | tfnXpath                                        | tfnFlag |
      | medicare-education/medicare-costs.html                | MedEd: Medicare Cost Basics | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/enrollment-and-changing-plans.html | MedEd: Enrollment           | //*[@class='amp']//a[contains(@href, 'callto')] | true    |
      | medicare-education/medicare-faq.html                  | MedEd: FAQ                  | //*[@class='amp']//a[contains(@href, 'callto')] | true    |

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      | path                            | pageName                    | tfnXpath                                                       | tfnFlag |
      | health-plans/shop.html          | ShopPlan: Shop              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/shop/connect       | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/compare.html  | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/estimate.html | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/switch.html   | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop2_GlobalCompsAARP
    Examples: 
      | path                                             | pageName                     | tfnXpath                                                       | tfnFlag |
      | health-plans/shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop3_GlobalCompsAARP
    Examples: 
      | path                                       | pageName                    | tfnXpath                                                       | tfnFlag |
      | health-plans/shop/compare/compare-pdp.html | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/compare/compare-ma.html  | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/estimate/ma-costs.html   | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/estimate/pdp-costs.html  | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Shop4_GlobalCompsAARP
    Examples: 
      | path                                                                   | pageName                        | tfnXpath                                                       | tfnFlag |
      | health-plans/shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html       | ShopPlan: MA Plan benefits      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Enroll1_GlobalCompsAARP
    Examples: 
      | path                                    | pageName                   | tfnXpath                                                       | tfnFlag |
      | health-plans/enroll.html                | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Resources1_GlobalCompsAARP
    Examples: 
      | path                                                              | pageName                             | tfnXpath                                                       | tfnFlag |
      | health-plans/resources.html                                       | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | health-plans/resources/medication-therapy-management-program.html | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/how-to-appoint-a-representative.html       | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/prescription-drug-costs-help.html          | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/healthcare-fraud.html                      | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      | path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      | health-plans/resources/pdp-resources-materials.html                                            | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/pdp-resources-materials/pdp-information-forms.html                      | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      | health-plans/resources/mail-order-pharmacy.html                                                | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | true    |
      | health-plans/resources/prescription_drug_appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      | health-plans/resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |

    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      | path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      | health-plans/resources/ma-resources-materials.html                                               | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/ma-resources-materials/ma-information-forms.html                          | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/ma-resources-materials/ma-information-forms/member-rights.html            | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      | health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |

    # Replace any "#" chars in the deeplink with "!"
    @VPP_Deeplinks_GlobalCompsAARP
    Examples: 
      | path                                                                                                                                                                                                                                      | pageName               | tfnXpath                                                    | tfnFlag |
      | health-plans.html!/details?planIds=H0543168000&planYear=2020&systemYear=2020&zip=90210&fipsCode=037&yearDisclaimer=undefined&month=1&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR:Federal:EGEM3011:::8016371 | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                                | true    |
      | health-plans.html!/details?planIds=H5253041000&planYear=2020&systemYear=2020&zip=28035&fipsCode=119&yearDisclaimer=undefined&month=1&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR:Federal:EGEM3011:::897749   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                                | true    |
      | health-plans.html!/details?planIds=S5921370000&planYear=2020&systemYear=2020&zip=55344&fipsCode=053&yearDisclaimer=undefined&month=1&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR:Federal:EGEM3011:::8016371 | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                                | true    |
      | health-plans.html!/details?planIds=H3307018000&planYear=2020&systemYear=2020&zip=10011&fipsCode=061&yearDisclaimer=undefined&month=1&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR:Federal:EGEM3011:::897749   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                                | true    |
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                | VPP: Plan Summary      | //a[contains(@class, 'tel')]                                | false   |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                       | Connector Modal        | (//a[contains(@href ,'tel') and contains(@class,'tel')])[2] | true    |

    @MiscellaneousLinks_GlobalCompsAARP
    Examples: 
      | path                                                                      | pageName                | tfnXpath                                                       | tfnFlag |
      | health-plans/estimate-drug-costs.html!/drug-cost-estimator                | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      | health-plans/aarp-pharmacy.html!/Pharmacy-Search-English                  | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide          | //*[@id='tfn']                                                 | true    |
      | health-plans/medicare-supplement-plans/agent-appointment.html             | Agent Appointment       | //*[@id='tfn']                                                 | true    |
      | medicare-plans.html                                                       | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      | profile/guest                                                             | Visitor Profile: Guest  | //*[@class='tel']                                              | true    |

    @FooterLinks_GlobalCompsAARP
    Examples: 
      | path                          | pageName                   | tfnXpath                     | tfnFlag |
      | about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      | sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      | terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      | disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      | health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      | contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      | privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |
