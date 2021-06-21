@campaignExternalLinksNewLPM
Feature: 1.10 ACQ - UAT Scripts Campaign External Links scenario 10 related to New Medicare Advantage Plans page

  @Scenario10 
  Scenario Outline: TID: <Scenario> To verify zipcode,TFN,form,links on Medicare Advantage Plans Landing Page
   Given user is on campaign external Links page
      | External Link | <externallink> |
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    Then user validates error messages on request an appointment
    Then user enters the details on request an appointment
    Then user clicks on find a doctor and validates the page
    Then user clicks on privacy policy link
    Then user clicks on accessibility link
     Then user validates Current location and change location
      | zipcodeSingle  | <zipcodeSingle>  |
      | zipcodeMulti   | <zipcodeMulti>  |
   #And the user navigates to new Campaign External links
      #| PageName | <pageName> |
      #| PagePath | <path>     |
    #Then user verify TFN on AARP external links page
      #| TFN No      | <TFNNo2>      |
      #| TFN Xpath   | <TFNxpath1>  |
      #| Working hrs | <workingHrs> |
      
    @CampaignExternal_Scenario10_AARP @StageLP
    Examples:
      | Scenario                                      | externallink                                                                   |zipcodeSingle |zipcodeMulti| isMultiCounty | county       | TFNNo         | TFNxpath1                   | workingHrs                              | TFNNo2         |path                                                                                            |pageName       | 
      | Campaign External Links - E2E Scenario 10_AMP | https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-advantage-plans.html   | 33111        |65656       |Yes            | Stone County |1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | 1-877-255-0782 |https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-advantage-plans.html?wt.mc_id=8014272   |MA Core AMP EN | 
   
    @CampaignExternal_Scenario10_UHC  @StageLP
    Examples:
      | Scenario                                      | externallink                                                                   |zipcodeSingle |zipcodeMulti| isMultiCounty | county       | TFNNo         | TFNxpath1                   | workingHrs                              | TFNNo2         |path                                                                                              |pageName       | 
      | Campaign External Links - E2E Scenario 10_UMS | https://www.stage-uhcmedicaresolutions.uhc.com/lp/medicare-advantage-plans.html| 33111        |65656       |Yes            | Stone County |1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | 1-877-255-0782 |https://www.stage-uhcmedicaresolutions.uhc.com/lp/medicare-advantage-plans.html?wt.mc_id=8014272  |MA Core UMS EN |
      
        
    @CampaignExternal_Scenario10_AARP @OfflineLP
    Examples:
      | Scenario                                      | externallink                                                             |zipcodeSingle |zipcodeMulti| isMultiCounty | county       | TFNNo         | TFNxpath1                   | workingHrs                              | TFNNo2         |path                                                                                      |pageName       | 
      | Campaign External Links - E2E Scenario 10_AMP | https://offline.aarpmedicareplans.com/lp/medicare-advantage-plans.html   | 33111        |65656       |Yes            | Stone County |1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | 1-877-255-0782 |https://offline.aarpmedicareplans.com/lp/medicare-advantage-plans.html?wt.mc_id=8014272   |MA Core AMP EN | 
   
    @CampaignExternal_Scenario10_UHC  @OfflineLP
    Examples:
      | Scenario                                      | externallink                                                                   |zipcodeSingle |zipcodeMulti| isMultiCounty | county       | TFNNo         | TFNxpath1                   | workingHrs                              | TFNNo2         |path                                                                                 |pageName       | 
      | Campaign External Links - E2E Scenario 10_UMS | https://offline.uhcmedicaresolutions.com/lp/medicare-advantage-plans.html| 33111        |65656       |Yes            | Stone County |1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | 1-877-255-0782 |https://offline.uhcmedicaresolutions.com/lp/medicare-advantage-plans.html?wt.mc_id=8014272  |MA Core UMS EN |
      
      
  @Scenario10
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
   Given user is on campaign external Links page
      | External Link | <externallink> |   
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    #VPP
    When user clicks on Find Plans and Pricing to open in same tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When verify Call SAM icon is visible
  And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Right Rail Plan Details page
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "2" plans to compare
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
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #PDP Plan#
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
      | Zip Code        | <zipcodeMulti>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
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
    #Med Sup Plan#
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
      | Zip Code        | <zipcodeMulti>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
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
    #Find Plans in your Area and SNP plantype*****#
    Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans in your area to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcodeMulti>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
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
	
	@CampaignExternal_Scenario10_AARP @StageLP
    Examples:
      | Scenario                                       | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP |   33111 |No           | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-advantage-plans.html   |

  @CampaignExternal_Scenario10_UHC  @StageLP
    Examples:
      | Scenario                                       |zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS    |33111 |No     | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-uhcmedicaresolutions.uhc.com/lp/medicare-advantage-plans.html   |

@CampaignExternal_Scenario10_AARP @OfflineLP
    Examples:
      | Scenario                                       | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP |   33111 |No           | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.aarpmedicareplans.com/lp/medicare-advantage-plans.html   |

  @CampaignExternal_Scenario10_UHC  @OfflineLP
    Examples:
      | Scenario                                       |zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS    |33111 |No     | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.uhcmedicaresolutions.com/lp/medicare-advantage-plans.html   |

 @Scenario10  
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
  #DCE
  Given user is on campaign external Links page
      | External Link | <externallink> |   
  Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
   When user clicks on Estimate Your Prescription Drug Costs from MA external page
   Then the user validates Get Started Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipcodeMulti> |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user should be able to see "Medicare Advantage Plans" by default
      Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user should be able to toggle between plan types
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    When user toggle to PDP plan type on drug summary page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user toggle to SNP plan type on drug summary page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
	
	@CampaignExternal_Scenario10_AARP @StageLP
    Examples:
      | Scenario                                       | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP  |33111        |No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-advantage-plans.html   |

    @CampaignExternal_Scenario10_UHC @StageLP
    Examples:
      | Scenario                                      | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS |   33111        |No     | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-uhcmedicaresolutions.uhc.com/lp/medicare-advantage-plans.html   |

@CampaignExternal_Scenario10_AARP @OfflineLP
    Examples:
      | Scenario                                       | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP  |33111        |No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.aarpmedicareplans.com/lp/medicare-advantage-plans.html   |

    @CampaignExternal_Scenario10_UHC @OfflineLP
    Examples:
      | Scenario                                      | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS |   33111        |No     | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.uhcmedicaresolutions.com/lp/medicare-advantage-plans.html   |


 @Scenario10 
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
    #PRE
	Given user is on campaign external Links page
      | External Link | <externallink> |   
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
      Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
   When user clicks on Start Now to get start the PRE flow from external page
  And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
   And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
   And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user validate elements in loading results page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    And user closes current tab and navigate to previous tab
    
    @CampaignExternal_Scenario10_AARP  @StageLP
    Examples:
      | Scenario                                       | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP |   33111 |No            | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-advantage-plans.html   |

    @CampaignExternal_Scenario10_UHC  @StageLP
    Examples:
      | Scenario                                      | zipcode| isMultiCounty | county       | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS |  33111 |No            | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://www.stage-uhcmedicaresolutions.uhc.com/lp/medicare-advantage-plans.html   |

  @CampaignExternal_Scenario10_AARP  @OfflineLP
    Examples:
      | Scenario                                      | zipcode| isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_AMP |   33111|No             | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.aarpmedicareplans.com/lp/medicare-advantage-plans.html   |

    @CampaignExternal_Scenario10_UHC  @OfflineLP
    Examples:
      | Scenario                                      | zipcode| isMultiCounty | county            | MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                           | externallink |
      | Campaign External Links - E2E Scenario 10_UMS |  33111 |No            | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)| https://offline.uhcmedicaresolutions.com/lp/medicare-advantage-plans.html   |


