@campaignExternalLinks
Feature: 1.05.5. UAT Scripts Campaign External Links scenario 1 related to AMP_UMS_English

  @Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for MAPD
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    # When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_MAPD
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC @prodRegression_UAT @CampaignExternal_Scenario1_UHC_MAPD
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #PDP Plan#
  @Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for PDP
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_PDP
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC @prodRegression_UAT @CampaignExternal_Scenario1_UHC_PDP
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #Med Sup Plan#
  @Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for Medsup
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail for Medsupp page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath5> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_Medsup @campaignExternalTFNProdMS
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county          | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   10001 | No            | New York County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC @prodRegression_UAT @CampaignExternal_Scenario1_UHC_Medsup @campaignExternalTFNProdMS
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county          | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   10001 | No            | New York County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #Find Plans in your Area and SNP plantype*****#
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for SNP
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    #When user clicks on Find Plans in your area to open a new tab
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    And Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_SNP
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC @prodRegression_UAT @CampaignExternal_Scenario1_UHC_SNP
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #DCE###
  @Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for DCE
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Estimate Your Prescription Drug Costs from external page
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
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user should be able to see "Medicare Advantage Plans" by default
    And user should be able to toggle between plan types
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    When user toggle to PDP plan type on drug summary page
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user toggle to SNP plan type on drug summary page
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_DCE
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_UHC_DCE
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #PRE Flow##
  @Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for PRE
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Start Now to get start the PRE flow from external page
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate elements in loading results page
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    #And the user views the plans of the below plan type
    And the user click on view plan in results page
    And User clicks on Back to Plans on detail page
    And the user views the plans for below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #And the user views plan details of the above selected plan and validates
    # | Plan Name | <planname> |
    And the user views plan details for selected plan and validates
      | Plan Name | <planname> |
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    # Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user clicks on Enroll Now in Details Page to start the OLE flow on the site
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |

    #Then the user validates TFN Number on Right Rail OLE page
    #And the user validates TFN Number on Right Rail from external link
    # | TFN No    | <TFNNo>     |
    #| TFN Xpath | <TFNxpath4> |
    #And user closes current tab and navigate to previous tab
    @CampaignExternal_Scenario1_AARP @prodRegression_UAT @CampaignExternal_Scenario1_AARP_PRE
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                           | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //a[contains(@class,'invoca_swap')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC @prodRegression_UAT @CampaignExternal_Scenario1_UHC_PRE
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No            | Miami-Dade County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  @Scenario1_Stage
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for MAPD
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab in lower env
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_MAPD
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | NO            | Christian County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_MAPD
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | NO            | Christian County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #PDP Plan#
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for PDP
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab in lower env
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_PDP
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | NO            | Christian County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_PDP
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | NO            | Christian County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #Med Sup Plan#
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for Medsup
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab in lower env
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail for Medsupp page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath5> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_Medsup @campaignExternalTFNStageMS
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   24010 | NO            | Roanoke City | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_MedSup
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   24010 | NO            | Roanoke City | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #Find Plans in your Area and SNP plantype*****#
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for SNP
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab in lower env
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    #And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    And Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_SNP
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   10001 | NO            | Christian County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_SNP
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county           | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   10001 | NO            | Christian County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #DCE###
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for DCE
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Estimate Your Prescription Drug Costs for lower env
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
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user should be able to see "Medicare Advantage Plans" by default
    And user should be able to toggle between plan types
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    When user toggle to PDP plan type on drug summary page
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user toggle to SNP plan type on drug summary page
    #Then the user validates SAM icons on the page
    Then the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_DCE
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county          | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   10001 | NO            | New York County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_DCE
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county          | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                            | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   10001 | NO            | New York County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Prime (HMO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy |

  #PRE Flow##
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links for PRE
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Start Now to get start the PRE flow external page for lower env
    #And user clicks on get started to start questionnaire
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    Then user select add drug option in the Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate elements in loading results page
    #And the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And the user click on view plan in results page
    And the user validates SAM icons on the page from external link
      | TFN Xpath | <TFNxpath2> |
    And User clicks on Back to Plans on detail page
    And the user views the plans for below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views the plans for below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    And the user views plan details for selected plan and validates
      | Plan Name | <PDPplanName> |
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    # Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user clicks on Enroll Now in Details Page to start the OLE flow on the site
    #Then the user validates SAM icons on the page
    And the user validates SAM icons on the page from external link
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |

    @CampaignExternal_Scenario1_AARP_Stage @regressionAARP @campaignExternalStage @CampaignExternal_Scenario1_AARP_Stage_PRE
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planName                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       | PDPplanName                     |
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | NO            | Miami-Dade County | MAPD       | 1-866-979-3947 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy | AARP MedicareRx Walgreens (PDP) |

    @CampaignExternal_Scenario1_UHC_Stage @regressionUHC @campaignExternalStage @CampaignExternal_Scenario1_UHC_Stage_PRE
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planName                             | TFNxpath                                    | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4                                   | TFNxpath5                            | defaultPharmacy       | PDPplanName |                            |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | NO            | Miami-Dade County | MAPD       | 1-877-589-2553 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //span[contains(@class, 'invoca_swap_sam')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap_sam')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-888-378-0254 | 8012870 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[contains(@class,'invoca_swap tel tfn')] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy | AARP        | MedicareRx Walgreens (PDP) |
