@dce @dce_redesign_DrugDetailsValidation1
Feature: 1.10.5 DCE-REDISIGN AARP DCE Details Page Scenarios - To test DCE Details Page Flows

  @dce_DrugDetailsValidation
  Scenario Outline: To verify DCE Details Page  <site> site - All Sections, Switch, Edit Drug, Learm more link from VPP Details and Insulin Savings model info on DCE Details Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user validates error message for blank search
    Then the user validates No Drug found error message for search
    Then user enter the following drug info and validates drug autocomplete
      | DrugNameAutoComplete | <drugnameAutocomplete> |
    Then the user selects the following Brand Name drug from the dropdown
      | BrandDrugName | <brandDrug> |
    Then the user validates Tell Us About Drug - Brand page for the Drug
      | GenericName | <genericDrug> |
    Then the user clicks on Add Drug to add drug to drug list
      | BrandDrugName | <brandDrug> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user validates Drug Recommendation section
    Then the user searches and adds the following Drug for following quantity, frequency and Supplylength to Drug List
      | DrugName  | <drug2>      |
      | Quantity  | <quantity2>  |
      | Frequency | <frequency2> |
      | SupplyLen | <supplyLen2> |
    Then the user validates all added drugs in DrugList
    Then the user validates qty, frequency and Supply Length for following drug in DrugList Page
      | DrugName  | <drug2>      |
      | Quantity  | <quantity2>  |
      | Frequency | <frequency2> |
      | SupplyLen | <supplyLen2> |
    #Then the user validates Drug Recommendation section
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates OptumRx consistently displays on DCE Summary - Pharmacy Page
    Then the user verifies NBA modal for creating profile on drug summary page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates OptumRx consistently displays on DCE Details - Pharmacy Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates qty, frequency and Supply Length for following drug in DCE Details Page
      | DrugName  | <drug2>      |
      | Quantity  | <quantity2>  |
      | Frequency | <frequency2> |
      | SupplyLen | <supplyLen2> |
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Monthly Drug Costs by Stage Info Modals
    Then the user validates Monthly Drug Costs
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug>   |
      | Generic Drug | <genericDrug> |
    Then the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    Then the user deletes the following drug from Drug list
      | DrugName | <deleteDrug> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <addDrug1> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates Drug List in Your Drugs Section on Drug Details Page
    Then the user validates Important information section
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user clicks PrescriptionBenifit Tab on Plan Details Page
    Then the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page
    Then the user validates planName on LearnMore page matches plan Name in VPP

    @dce_DrugDetailsValidation_AARP @regressionAARP
    Examples: 
      | drugnameAutocomplete | drug1   | drug2  | quantity2 | frequency2 | supplyLen2     | zipCode | planType | planName                                            | site | brandDrug | genericDrug | deleteDrug | addDrug1 |
      | ativ                 | Humalog | Fanapt |         2 | Day        | Every 3 Months |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | Ativan    | orazepam    | Humalog    | Lipitor  |

    @dce_DrugDetailsValidation_UHC @regressionUHC
    Examples: 
      | drugnameAutocomplete | drug1   | drug2  | quantity2 | frequency2 | supplyLen2     | zipCode | planType | planName                                      | site | brandDrug | genericDrug | deleteDrug | addDrug1 |
      | ativ                 | Humalog | Fanapt |        20 | Week       | Every 1 Month  |   33111 | MAPD     | Medica HealthCare Plans MedicareMax (HMO)     | UHC  | Ativan    | orazepam    | Humalog    | Lipitor  |
      | ativ                 | Humalog | Fanapt |       200 | Month      | Every 3 Months |   33111 | SNP      | Preferred Special Care Miami-Dade (HMO C-SNP) | UHC  | Ativan    | orazepam    | Humalog    | Lipitor  |

  @dce_DrugDetailsDynamicCopay_Preferred
  Scenario Outline: To verify DCE Details Page  <site> site - for Dynamic copay section for Preferred Pharmacy Copay
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user edits supply length to three months for following drug
      | EditDrug | <drug1> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Dynamic Copay Section for following Pharmacy selection
      | Pharmacy Selection | <DefaultSelected> |
    And user clicks on change pharmacy link from details page
    Then the user selects Mail Pharmacy and returns to DCE Details page
    Then the user validates Dynamic Copay Section for following Pharmacy selection
      | Pharmacy Selection | <MailPharSelected> |
    And user clicks on change pharmacy link from details page
    Then the user selects following Standard pharmacy and returns to DCE Details page
      | SelectStandardPharmacy | <SelectStandardPharmacy> |
    Then the user validates Dynamic Copay Section for following Pharmacy selection
      | Pharmacy Selection | <StandardPharSelected> |
    Then the user validates link to Drug Summary Page

    @dce_DrugDetailsCopay_Preferred_AARP @regressionAARP
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | AARP | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |

    @dce_DrugDetailsCopay_Preferred_UHC @regressionUHC
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | UHC  | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |

  @dce_DrugDetailsDynamicCopay_Standard
  Scenario Outline: To verify DCE Details Page  <site> site - for Dynamic copay section for Standard Pharmacy Copay and Not covered Pharmacy View - <planType>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user edits supply length to three months for following drug
      | EditDrug | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <insulinDrug> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Dynamic Copay Section for following Pharmacy selection
      | Pharmacy Selection | <DefaultSelected> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinCopay> |
      | Insulin Drug | <insulinDrug>  |
    And user clicks on change pharmacy link from details page
    Then the user selects Mail Pharmacy and returns to DCE Details page
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinCopay2> |
      | Insulin Drug | <insulinDrug>   |
    Then the user validates Dynamic Copay Section for following Pharmacy selection
      | Pharmacy Selection | <MailPharSelected> |
    And user clicks on change pharmacy link from details page
    Then the user validates distance dropdown and Zipcode change on DCE Details page - Change Pharmacy Page
      | PharmacyZipCode | <pharmacyZipCode> |
    Then the user selects following pharmacy and returns to DCE Details page
      | SelectPharmacy | <SelectPharmacy> |
    Then the user validates Not Covered Pharmacy view for DCE Details Page
    And the user validates link to Drug Summary Page
    And user clicks on change pharmacy link on alert message from plan card on drug summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal

    @dce_DrugDetailsCopay_Standard_AARP @regressionAARP
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                                            | site | DefaultSelected | MailPharSelected | pharmacyZipCode | SelectPharmacy | insulinDrug    | insulinCopay | insulinCopay2 |
#      | vigabatrin | Fanapt |   80001 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | Standard Retail | Standard Mail    |           78006 | ROCK PHARMACY  | insulin lispro | $35          | $105          |
      | vigabatrin | Fanapt |   33111 | SNP      | Preferred Special Care Miami-Dade (HMO C-SNP)       | AARP | Standard Retail | Standard Mail    |           78006 | ROCK PHARMACY  | insulin lispro | $15          | $45           |

    @dce_DrugDetailsCopay_Standard_UHC @regressionUHC
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                                      | site | DefaultSelected | MailPharSelected | pharmacyZipCode | SelectPharmacy | insulinDrug    | insulinCopay | insulinCopay2 |
      | vigabatrin | Fanapt |   33111 | MAPD     | Medica HealthCare Plans MedicareMax (HMO)     | UHC  | Standard Retail | Standard Mail    |           78006 | ROCK PHARMACY  | insulin lispro | $30          | $90           |
      | vigabatrin | Fanapt |   33111 | SNP      | Preferred Special Care Miami-Dade (HMO C-SNP) | UHC  | Standard Retail | Standard Mail    |           78006 | ROCK PHARMACY  | insulin lispro | $15          | $45           |

  @dce_DrugDetailsPremiumValidation
  Scenario Outline: To verify DCE Details Page  <site> site - for MS dollor Zero or Range Premium for plantype-<plantype> for premium - <premium>
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates following premium for the following plan on DCE Summary Page
      | Plan Type | <planType> |
      | Plan Name | <planName> |
      | Premium   | <premium>  |
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    And verify DCE NBA is displayed on drug details page

    @dce_DrugDetailsPremiumValidation_AARP @regressionAARP
    Examples: 
      | drug1   | zipCode | planType | planName                                                   | site | premium |
      | Orkambi |   90210 | MAPD     | UnitedHealthcare Medicare Advantage Assure (HMO)           | AARP | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)      | AARP | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP | $0      |

    @dce_DrugDetailsPremiumValidation_UHC @regressionUHC
    Examples: 
      | drug1   | zipCode | planType | planName                                                   | site | premium |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | UHC  | $0      |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)                 | UHC  | $0 - $  |
      | Orkambi |   66032 | SNP      | UnitedHealthcare Dual Complete LP1 (HMO-POS D-SNP)         | UHC  | $0 - $  |

  @dce_DrugDetailsLISBuyDown
  Scenario Outline: To verify DCE Details Page  <site> site - for LIS Buydown Plans
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates correct Copay section view and LIS message for LIS Buydown Plan on DCE details Page
    Then the user validates Monthly Costs are not displayed for LIS Buydown plan on DCE details Page
    Then the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page
      | CoveredDrug | <drug1> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug2> |
    Then the user validates LIS text for coverages stages popups on DCE details page

    @dce_DrugDetailsLISBuyDown_AARP @regressionAARP
    Examples: 
      | drug1  | drug2   | zipCode | planType | planName                                   | site |
      | Fanapt | Lipitor |   75002 | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | AARP |

    @dce_DrugDetailsLISBuyDown_UHC @regressionUHC
    Examples: 
      | drug1  | drug2   | zipCode | planType | planName                                   | site |
      | Fanapt | Lipitor |   10001 | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | UHC  |

  @dce_DrugDetailsNonBuyDownLIS
  Scenario Outline: To verify DCE Details Page  <site> site - for LIS Non Buydown Plans
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates correct Copay section view and LIS message for LIS Non Buydown Plan on DCE details Page
    Then the user validates Non-LIS text for coverages stages popups on DCE details page
    And verify DCE NBA is displayed on drug details page

    @dce_DrugDetailsNonBuyDownLIS_AARP @regressionAARP
    Examples: 
      | drug1  | drug2   | zipCode | planType | planName                                                   | site |
      | Fanapt | Lipitor |   75002 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP |

    @dce_DrugDetailsNonBuyDownLIS_UHC @regressionUHC
    Examples: 
      | drug1  | drug2   | zipCode | planType | planName                                                   | site |
      | Fanapt | Lipitor |   78006 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | UHC  |
