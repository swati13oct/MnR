@UATRegression
Feature: 1.10.4 UAT-DCE-To test UAT DCE E2E Regression Scenarios

  @DCE_ShopForPlanPage_PDPpage
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Shop PDP page on
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    And user click on Switch To Generic
    And user clicks on change pharmacy link from details page
    And the user selects Mail Pharmacy and returns to DCE Details page
    And the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    And the user clicks on Edit button on Drug List page on DCE
      | DrugName | <drug2> |
    And the user changes the supply length
      | Supply Length | <supplyLength> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    And the user validates link to Drug Summary Page
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName> |
    And the user compares drug costs for drug details and drug summary pages
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    And the user verifies the drug information on prescription drug tab
      | DrugName | <drug2> |
    And the user verifies the added pharmacy on prescription drug tab

    @dce_redesign_ShopPDP_AARP
    Examples: 
      | Scenario           | site | drug1   | drug2                | zipCode | planType | planName                        | supplyLength   |
      | E2E Scenario 2_AMP | AARP | Lipitor | atorvastatin calcium |   80002 | PDP      | AARP MedicareRx Walgreens (PDP) | Every 3 Months |

    @dce_redesign_ShopPDP_UHC
    Examples: 
      | Scenario           | site | drug1   | drug2                | zipCode | planType | planName                        | supplyLength   |
      | E2E Scenario 2_UMS | UHC  | Lipitor | atorvastatin calcium |   80002 | PDP      | AARP MedicareRx Walgreens (PDP) | Every 3 Months |

  @DCE_MedEdPage
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Med Ed page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Med Ed - Prescription Drugs Page
    Then the uset clicks on Estimate Drug Costs Link to land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates PLan Toggle on Drug Summary Page
    And user clicks on change pharmacy link from summary page
    Then the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page
      | PharmacyZipCode | <pharmacyZipCode> |
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName> |
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user Captures Drug costs on Drug Details Page
    And the user compares drug costs for drug details and drug summary pages

    @DCE_MedEdPage_AARP
    Examples: 
      | Scenario           | site | drug1   | drug2  | zipCode | pharmacyZipCode | SelectPharmacy | planType | planName                        |
      | E2E Scenario 4_AMP | AARP | Orkambi | Fanapt |   80002 |           10001 | AHF PHARMACY   | PDP      | AARP MedicareRx Walgreens (PDP) |

    @DCE_MedEdPage_UHC
    Examples: 
      | Scenario           | site | drug1   | drug2  | zipCode | pharmacyZipCode | SelectPharmacy | planType | planName                        |
      | E2E Scenario 4_UMS | UHC  | Orkambi | Fanapt |   80002 |           10001 | AHF PHARMACY   | PDP      | AARP MedicareRx Walgreens (PDP) |

       @DCE_E2E_Scenario6_UAT
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from External Link
   Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page     
      | PagePath | <path>     |
     And the user views the plans of the below plan type
      | Plan Type | <plantype> |
      And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug7> |
    Then the user edits supply length to three months for following drug  
      | EditDrug | <drug5> |
    Then the user validates all added drugs in DrugList  
    Then the user clicks on Review Drug Costs to Land on Drug Details Page   
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug1>   |
      | Generic Drug | <genericDrug1> |
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug2>   |
      | Generic Drug | <genericDrug2> |
   Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
   Then the user verify the Retail chain pharmacy on detail page   
   And the user validates link to Drug Summary Page
     
    
    
     Examples: 
      | Scenario           | site  | path                                                                                   | plantype | planname                                         |  drug1   | drug2     | drug3    | drug4  | drug5 | drug6      | drug7           | brandDrug1 |  genericDrug1         |  brandDrug2 |  genericDrug2 | premium |                     
      | E2E Scenario 4_UMS | AARP  | health-plans.html?zipcode=90210&WT.mc_id=8000158&county=200&state=06#/plan-summary     |  MAPD    | UnitedHealthcare Medicare Advantage Assure (HMO) |  Lipitor | Ibuprofen | Nicomide | Fanapt | Xanax | Alprazolam | Methylphenidate | Lipitor    |  atorvastatin calcium |   Xanax     |   alprazolam  | $0 - $  | 
    