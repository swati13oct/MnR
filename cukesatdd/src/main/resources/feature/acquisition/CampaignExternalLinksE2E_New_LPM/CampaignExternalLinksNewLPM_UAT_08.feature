@campaignExternalLinksNewLPM
Feature: 1.08 UAT Scripts Campaign External Links scenario 8 related to New take advantage page

  @Scenario8
  Scenario Outline: TID: <Scenario> To verify zipcode,TFN,form,links on Take Advantage Page
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    Then user validates error messages on get more information
    Then user enters the details on get more information
    Then user clicks on privacy policy link
    Then user clicks on accessibility link
    Then user validates Current location and change location
      | zipcodeSingle | <zipcodeSingle> |
      | zipcodeMulti  | <zipcodeMulti>  |

    @CampaignExternal_Scenario8_AARP @teamAvengersLP @featureGate
    Examples:
      | Scenario                                     | zipcodeMulti | zipcodeSingle | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | externallink                                                       |
      | Campaign External Links - E2E Scenario 8_AMP | 65656        | 33111         | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://www.team-avengers-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP @StageLP
    Examples:
      | Scenario                                     | zipcodeMulti | zipcodeSingle | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | externallink                                                       |
      | Campaign External Links - E2E Scenario 8_AMP | 65656        | 33111         | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://www.stage-aarpmedicareplans.uhc.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP  @OfflineLP
    Examples:
      | Scenario                                     | zipcodeMulti | zipcodeSingle | TFNNo          | TFNxpath1                   | workingHrs                              | externallink                                                 |
      | Campaign External Links - E2E Scenario 8_AMP | 65656        | 33111         | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://offline.aarpmedicareplans.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP  @ProdLP
    Examples:
      | Scenario                                     | zipcodeMulti | zipcodeSingle | TFNNo          | TFNxpath1                   | workingHrs                              | externallink                                             |
      | Campaign External Links - E2E Scenario 8_AMP | 65656        | 33111         | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://www.aarpmedicareplans.com/lp/take-advantage.html |

  @Scenario8
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links-VPP
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    Then user validates Current location and change location
      | zipcodeSingle | <zipcodeSingle> |
      | zipcodeMulti  | <zipcodeMulti>  |
    When user clicks on Find Plans and Pricing on take advantage page
    Then user should be navigated on Shop for a plan page
#    Then the user validates whether call icon is visible
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
#    Then the user validates whether call icon is visible
    #MA/MAPD Plans
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <MAplanname> |
      | Plan Type | <MAplantype> |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
#    Then the user validates whether call icon is visible
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
#    Then the user validates whether call icon is visible
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
#    Then the user validates whether call icon is visible
    Then the user navigates to Personal Information Page
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
#    Then the user validates whether call icon is visible
    Then user go backs campaign external Links page
      | External Link | <externallink> |
    #PDP Plan#
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    When user clicks on Find Plans and Pricing to open a new tab
#    Then the user validates whether call icon is visible
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
#    Then the user validates whether call icon is visible
    And the user selects plan year
      | Plan Year | <planyear> |
 #   When verify Call SAM icon is visible
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanname> |
#    Then the user validates whether call icon is visible
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
#    Then the user validates whether call icon is visible
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
#    Then the user validates whether call icon is visible
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    Then the user navigates to Personal Information Page
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
  #    Then the user validates whether call icon is visible
    Then user go backs campaign external Links page
      | External Link | <externallink> |
        #Med Sup Plan#
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    Then user validates Current location and change location
      | zipcodeSingle | <zipcodeSingleMedSup> |
      | zipcodeMulti  | <zipcodeMulti>        |
    When user clicks on Find Plans and Pricing to open a new tab
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpathMS1> |
      | TFNflag  | <tfnFlag>     |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpathMS2> |
      | TFNflag  | <tfnFlag>     |
#    Then the user validates whether call icon is visible
    Then user go backs campaign external Links page
      | External Link | <externallink> |
        #Find Plans in your Area and SNP plantype*****#
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    When user clicks on Find Plans and Pricing to open a new tab
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
#    And the user selects plan year
#      | Plan Year | <planyear> |
#    Then the user validates whether call icon is visible
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    Then the user validates TFN on the page
      | TFNxpath | <TFNxpath3> |
      | TFNflag  | <tfnFlag>   |
    And Navigate to Visitor Profile page
    Then the user retrieves TFNSessionCookie and Federal and MedSupp TFN on LP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates whether call icon is visible

    @CampaignExternal_Scenario8_AARP @StageLP
    Examples:
      | Scenario                                                | externallink                                                       | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | MAplanname                           | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | TFNxpathMS1                      | TFNxpathMS2                      | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | zipcodeMulti | zipcodeSingle | zipcodeSingleMedSup | isMultiCounty | county       |
      | Campaign External Links - E2E Scenario 8_take_advantage | https://www.stage-aarpmedicareplans.uhc.com/lp/take-advantage.html | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | current  | (//a[contains(@class, 'tel')])[3] | (//a[contains(@href, 'tel')])[1] | (//a[contains(@href, 'tel')])[2] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | 65656        | 33111         | 10001               | Yes           | Stone County |

    @CampaignExternal_Scenario8_AARP @OfflineLP
    Examples:
      | Scenario                                                | externallink                                                 | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | MAplanname                           | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | TFNxpathMS1                      | TFNxpathMS2                      | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | zipcodeMulti | zipcodeSingle | zipcodeSingleMedSup | isMultiCounty | county       |
      | Campaign External Links - E2E Scenario 8_take_advantage | https://offline.aarpmedicareplans.com/lp/take-advantage.html | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | (//a[contains(@href, 'tel')])[1] | (//a[contains(@href, 'tel')])[2] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | 65656        | 33111         | 10001               | Yes           | Stone County |

    @CampaignExternal_Scenario8_AARP @ProdLP
    Examples:
      | Scenario                                                | externallink                                                 | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | MAplanname                           | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | TFNxpathMS1                      | TFNxpathMS2                      | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | zipcodeMulti | zipcodeSingle | zipcodeSingleMedSup | isMultiCounty | county       |
      | Campaign External Links - E2E Scenario 8_take_advantage | https://offline.aarpmedicareplans.com/lp/take-advantage.html | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[3] | (//a[contains(@href, 'tel')])[1] | (//a[contains(@href, 'tel')])[2] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012869 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | 65656        | 33111         | 10001               | Yes           | Stone County |

  @Scenario8
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links to check DCE flow
    Given user is on campaign external Links page
      | External Link | <externallink> |
#    Then user verify TFN on AARP external links page
#      | TFN No      | <TFNNo>      |
#      | TFN Xpath   | <TFNxpath1>  |
#      | Working hrs | <workingHrs> |
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
    When user clicks on Drug cost estimator from external page
    Then the user validates Get Started Page
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode         | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |
    And user should be able to see "Medicare Advantage Plans" by default
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |
    And user should be able to toggle between plan types
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    When user toggle to PDP plan type on drug summary page
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |
    When user toggle to SNP plan type on drug summary page
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |

    @CampaignExternal_Scenario8_AARP @StageLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | tfnFlag | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy       | externallink                                                       |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | true    | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy | https://www.stage-aarpmedicareplans.uhc.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP    @OfflineLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy       | externallink                                                 |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy | https://offline.aarpmedicareplans.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP    @ProdLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy       | externallink                                             |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy | https://www.aarpmedicareplans.com/lp/take-advantage.html |

  @Scenario8
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages-PRE
    Given user is on campaign external Links page
      | External Link | <externallink> |
#    Then user verify TFN on AARP external links page
#      | TFN No      | <TFNNo>      |
#      | TFN Xpath   | <TFNxpath1>  |
#      | Working hrs | <workingHrs> |
    Then the user verify TFN on landing pages
      | TFN Xpath | <TFNxpath1> |
      | TFNflag   | <tfnFlag>   |
   #PRE
    When user clicks on Find plans link in Plan Finder section and redirects to PRE page
#    And the user validates SAM icons on the page
#      | TFN Xpath | <TFNxpath2> |
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
#    And the user validates SAM icons on the page
#      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
#    And the user validates SAM icons on the page
#      | TFN Xpath | <TFNxpath2> |
    Then user validate elements in loading results page
#    And the user validates SAM icons on the page
#      | TFN Xpath | <TFNxpath2> |
    And the user validates the available plans for selected plan types PRE
      | Plan Name | <PDPplanname> |
      | Plan Type | <PDPplantype> |
#    Then the user validates SAM icons on the page
#      | TFN No    | <TFNNo>    |
#      | TFN Xpath | <TFNxpath> |


		@CampaignExternal_Scenario8_AARP @featureGate
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | tfnFlag | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | externallink                                                       |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | true    | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://www.team-avengers-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP @StageLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | tfnFlag | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | externallink                                                       |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | true    | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://www.stage-aarpmedicareplans.uhc.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP @OfflineLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | externallink                                                 |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://offline.aarpmedicareplans.com/lp/take-advantage.html |

    @CampaignExternal_Scenario8_AARP @ProdLP
    Examples:
      | Scenario                                     | zipcode | isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                            | defaultPharmacy                                                                            | externallink                                             |
      | Campaign External Links - E2E Scenario 8_AMP | 33111   | No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | 1         | 2          | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog | 27053   | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1] | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://www.aarpmedicareplans.com/lp/take-advantage.html |

