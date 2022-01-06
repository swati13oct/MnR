@campaignExternalLinks
Feature: 1.05.5. UAT Scripts Campaign External Links for Scenario7 related to prescription-drug-plans-52

  Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------------PDP plantype---------------------------------------
    And User able to land on Shop for a plan page in new tab
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
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user should be able to see "Medicare Prescription Drug (Part D) Plans" expanded by default
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
    And the user closes the new browser tab
    #-------------------------MAPD plantype---------------------------------------
    And User able to land on Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
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
    And the user closes the new browser tab
    #-----------------------------------SNP plantype-------------------------------
    And User able to land on Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
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
    And the user closes the new browser tab
    #---------------------------------Medsupp Plantype-------------------------
    And User able to land on Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    #------------------------------DCE from External Link----------------------------------#
    And the user clicks on Estimate your drug costs to land on Drug cost page from External link
    #And the user validates Get Started Page
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
    #And the user verify the default Retail chain pharmacy on drug summary page
    #|DefaultPharmacy| <defaultPharmacy>|
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    And user should be able to toggle between plan types
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user click on PDP plan to view drug pricing
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    #--------------------------DCE from Look Up your Drugs---------------------##
    When user click on Estimate your Drug Cost button under Look up your drugs title
    #And the user validates Get Started Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- pharmacyflow from External Link------------------------##
    When user clicks on Start Now to get start the Pharmacy flow from external page
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
    And the user closes the new browser tab
    ##--------------------------------- Vpp flow from External Link Page------------------------##
    And the user clicks on View Plans and Pricing button on PDP external page
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- Vpp flow from Vpp link on External Page------------------------##
    And the user clicks on View Plans and Pricing link on PDP external page
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- Privacy Policy from External Page------------------------##
    Then the user navigate back to aarp medicare plans11 page privacy link
    And the user validates SAM icons on the page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    #And the user closes the new browser tab
    Then user closes current tab and navigate to previous tab

    @Scenario7_AARP
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                 | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy                                                                            | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//a[contains(@class, 'tel')])[3] |         1 |          2 | (//a[contains(@class, 'tel')])[1] | MAPD       | AARP Medicare Advantage Plan 1 (HMO) | SNP         | UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS             | 1-844-895-7228 | Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.) | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | E-Prescribing | True                  | True             | True                 | current  |

  Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------------PDP plantype---------------------------------------
    And User able to land on Shop for a plan page in new tab in lower env
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
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views the plans of the below plan type
      | Plan Type | <PDPplanname> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user should be able to see "Medicare Prescription Drug (Part D) Plans" expanded by default
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
    And the user closes the new browser tab
    @Scenario7_AARP_Stage1 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_1 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------------MAPD plantype---------------------------------------
    And User able to land on Shop for a plan page in new tab in lower env
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
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
    And the user closes the new browser tab
    @Scenario7_AARP_Stage2 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_2 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-----------------------------------SNP plantype-------------------------------
    And User able to land on Shop for a plan page in new tab in lower env
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
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
    And the user closes the new browser tab
    @Scenario7_AARP_Stage3 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_3 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #---------------------------------Medsupp Plantype-------------------------
    And User able to land on Shop for a plan page in new tab in lower env
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    #And the user views the plans of the below plan type
     # | Plan Type | <Medsupplantype> |
     Then the user navigates to plan tab for any plan
      | Plan Type | <Medsupplantype> |
    And the user validates SAM icons on Medsupp page from External page
      | TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    @Scenario7_AARP_Stage4 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_4 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #------------------------------DCE from External Link----------------------------------#
    And the user clicks on Estimate your drug costs to land on Drug cost page from External link in lower env
    #And the user validates Get Started Page
    And the user validates SAM icons on the DCE page
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
    And the user validates SAM icons on the DCE page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see "Medicare Advantage Plans" by default
    And the user validates SAM icons on the DCE page
      | TFN Xpath | <TFNxpath2> |
    #And the user verify the default Retail chain pharmacy on drug summary page
    #|DefaultPharmacy| <defaultPharmacy>|
    Then the user verify the default Retail chain pharmacy on drug summary page
      | DefaultPharmacy | <defaultPharmacy> |
    And user should be able to toggle between plan types
    And the user validates SAM icons on the DCE page
      | TFN Xpath | <TFNxpath2> |
    And user click on PDP plan to view drug pricing
    And the user validates SAM icons on the DCE page
      | TFN Xpath | <TFNxpath2> |
    And user closes current tab and navigate to previous tab
    #--------------------------DCE from Look Up your Drugs---------------------##
    When user click on Estimate your Drug Cost button under Look up your drugs title in lower env
    #And the user validates Get Started Page
    And the user validates SAM icons on the DCE page
      | TFN Xpath | <TFNxpath2> |
    And user closes current tab and navigate to previous tab
    @Scenario7_AARP_Stage5 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_5 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    ##--------------------------------- pharmacyflow from External Link------------------------##
    When user clicks on Start Now to start the Pharmacy flow from external page in lower env
    #And the user enters following details on Pharmacy search page
      #| Zip Code    | <zipcode>  |
      #| Distance    | <distance> |
      #| County Name | <county>   |
    #And the user selects plan year
     # | Plan Year | <planyear> |
    #And the user validates SAM icons on the page
    #  | TFN Xpath | <TFNxpath2> |
    #And the user chooses a plan from dropdown
     # | Current Year Plan Name | <cy_planName> |
      #| Current Year Plan Year | <cy_planYear> |
      #| Next Year Plan Name    | <ny_planName> |
      #| Next Year Plan Year    | <ny_planYear> |
    Then the user navigate to Pharmacy page
      | Zip Code    | <zipcode>     |
      | Distance    | <distance>    |
      | County Name | <county>  |
      | Plan Name   | <ny_planName> |
    Then the user validates the pharmacies available
      | Language | English |
    #And the user validates tooltips on filters
     # | Language                                   | English                 |
     # | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    #And the user validates map section content
    #And the user validates show on map link
    #And the user validates get direction link
    #And the user validates more information content based on plan type
    #And the user validates view search PDF link
    #And the user validates pharmacy widgets
     # | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      #| Has Walgreens plan                         | <hasWalgreensPlan>      |
      #| Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    #And the user selects Pharmacy Types to Filter
     # | Pharmacy Type | <pharmacyType> |
     # | Language      | English        |
    #Then the user validates the question widget
    And the user validates SAM icons on the Pharmacy page
      | TFN Xpath | <TFNxpath2> |
    #And the user closes the new browser tab
    
    @Scenario7_AARP_Stage6 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_6 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
    
    Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    ##--------------------------------- Vpp flow from External Link Page------------------------##
    And the user clicks on View Plans and Pricing button on PDP external page in lower env
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- Vpp flow from Vpp link on External Page------------------------##
    And the user clicks on View Plans and Pricing button on PDP external page in lower env
       | Zip Code        | <zipcode>         |
       | Is Multi County | <isMultutiCounty> |
       | County Name     | <county>          |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- Privacy Policy from External Page------------------------##
    Then the user navigate back to aarp medicare plans11 page privacy link in lower env
    And the user validates SAM icons on the page
      #| TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    #And the user closes the new browser tab
    Then user closes current tab and navigate to previous tab

    @Scenario7_AARP_Stage7 @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                            | pscCode | zipcode | isMultutiCounty | county            | PDPplantype | PDPplanname                     | TFNxpath3                                                                  | planIndex | planIndex1 | TFNxpath4                         | MAplantype | MAplanname                           | SNPPlanType | SNPPlanName                                       | drug1 | drug2   | drug3   | drug4   | zipCode | Medsupplantype | TFNNo1         | defaultPharmacy       | testPlans                                | zipcode1 | distance | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planyear |
      | E2E Scenario 7 _medicare-prescription-drug-plans-52_7 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'invoca_swap')] | 8001024 |   33111 | No              | Miami-Dade County | PDP         | AARP MedicareRx Walgreens (PDP) | (//*[contains(@class,'paragraph')]//a[contains(@class,'tel tfn desktop')]) |         1 |          2 | (//a[contains(@class, 'tel')])[3] | MAPD       | AARP Medicare Advantage Choice (PPO) | SNP         | Preferred Medicare Assist Plan 2 (HMO D-SNP) | Emsam | Lipitor | Orfadin | Humalog |   27053 | MS4.0             | 1-844-895-7228 | Retail Chain Pharmacy | AARP Medicare Advantage Plan 2 (HMO-POS) |    90210 |       15 |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | True             | True                 | current  |
