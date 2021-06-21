@campaignExternalLinksNewLPM
Feature: 1.10 ACQ - UAT Scripts Campaign External Links scenario 12 related to New Medicare Prescription Drug Plans page

  @Scenario12 
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
   Given user is on campaign external Links page
      | External Link | <externallink> |
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    Then user clicks on privacy policy link
    Then user clicks on accessibility link
    Then user validates Current location and change location
      | zipcodeSingle  | <zipcodeSingle> |
      | zipcodeMulti   | <zipcodeMulti>  |
     
    @CampaignExternal_Scenario12_AARP  @StageLP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | TFNNo          | TFNxpath1                   | workingHrs                              | externallink|
      | Campaign External Links - E2E Scenario 12_AMP |   65656      |33111        |Yes            | Stone County | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-prescription-drug-plans.html   |

   
    @CampaignExternal_Scenario12_AARP  @OfflineLP
    Examples:
      | Scenario                                       | zipcodeMulti |zipcodeSingle| isMultiCounty | county       | TFNNo          | TFNxpath1                   | workingHrs                              | externallink|
      | Campaign External Links - E2E Scenario 12_AMP |   65656      |33111        |Yes            | Stone County | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | https://offline.aarpmedicareplans.com/lp/medicare-prescription-drug-plans.html   |
    
  @Scenario12 
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via New Landing pages
   Given user is on campaign external Links page
      | External Link | <externallink> |
   Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> | 
   #-------------------------PDP plantype---------------------------------------
    Then user clicks on view plans and pricing and navigates to VPP
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    And the user validates PSC code
      | PSC Code | <pscCode> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user should be able to see "Medicare Prescription Drug Plans" expanded by default
    And the user view plan details of the above selected plan in site vpp
      | Plan Name | <PDPplanname> |
      | Plan Type | <PDPplantype> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    And verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    And verify plan compare page is loaded
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    And the user navigates to Personal Information Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    #Then user navigate back to external url for prescription drug plan
    
    #-------------------------MAPD plantype---------------------------------------
     Then user clicks on view plans and pricing and navigates to VPP
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail
      | TFN Xpath | <TFNxpath4> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <MAplanname> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    And verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    And verify plan compare page is loaded
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    And the user navigates to Personal Information Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
   Then user navigate back to external url for prescription drug plan
    #-----------------------------------SNP plantype-------------------------------
    Then user clicks on view plans and pricing and navigates to VPP
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanType> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail
      | TFN Xpath | <TFNxpath4> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <SNPPlanName> |
    And the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    And the user navigates to Personal Information Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
    #---------------------------------Medsupp Plantype-------------------------
    Then user clicks on view plans and pricing and navigates to VPP
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
    #------------------------------DCE from External Link----------------------------------#
    Then user clicks on estimate your prescription drug costs and navigates to DCE
    And the user validates Get Started Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see "Medicare Advantage Plans" by default
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user verify the default Retail chain pharmacy on drug summary page
    |DefaultPharmacy| <defaultPharmacy>|
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    And user should be able to toggle between plan types
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user click on PDP plan to view drug pricing
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
    #--------------------------DCE from Look Up your Drugs---------------------##
    Then user clicks on estimate drug costs button and navigates to DCE
    And the user validates Get Started Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
      ##--------------------------------- pharmacyflow from External Link------------------------##
      Then user clicks on start now and navigates to pharmacy page
    And the user enters following details on Pharmacy search page
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available
      | Language | English |
    And the user validates tooltips on filters
      | Language                                   | English                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section content
    And the user validates show on map link
    And the user validates get direction link
    And the user validates more information content based on plan type
    And the user validates view search PDF link
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | English        |
    Then the user validates the question widget
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
  
    ##--------------------------------- Vpp flow from Vpp link on External Page------------------------##
    Then user clicks on view plans and pricing button and navigates to VPP
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then user navigate back to external url for prescription drug plan
  
    
   @CampaignExternal_Scenario12_AARP   @StageLP
    Examples:
      | Scenario                                       | zipcode| isMultutiCounty  | county|pscCode|MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                                      | externallink |
      | Campaign External Links - E2E Scenario 12_AMP |   36016    |Yes            | Barbour County | 8012869|MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://www.stage-aarpmedicareplans.uhc.com/lp/medicare-prescription-drug-plans.html   |

  @CampaignExternal_Scenario12_AARP    @OfflineLP
    Examples:
      | Scenario                                       | zipcode| isMultutiCounty  | county|pscCode|MAplantype | TFNNo          | TFNxpath1                   | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode | TFNNo1         | pscCode | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                         | specialNeeds | isCoverageOpt | TFNxpath4             | TFNxpath5                           | defaultPharmacy                                                                                      | externallink |
      | Campaign External Links - E2E Scenario 12_AMP |   36016    |Yes            | Barbour County | 8012869|MAPD       | 1-855-264-3792 | //a[@data-asset-name='TFN'] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 | 1-866-408-5545 | 8012871 | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO | None         | PDP           | //*[@id='tty-number'] | (//span[contains(@class, 'tel')])[1]| Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | https://offline.aarpmedicareplans.com/lp/medicare-prescription-drug-plans.html   |
    

