@dce_redesign_DrugDetailsValidation1
Feature: 1.10.5 DCE-REDISIGN AARP DCE Details Page Scenarios - To test DCE Details Page Flows

  @DCE_DrugDetailsValidation
  Scenario Outline: To verify DCE REDESIGN Details Page from <site> home page
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
      | BrandDrugName | <brundDrug> |
    Then the user validates Tell Us About Drug - Brand page for the Drug
      | GenericName | <genericDrug> |
    Then the user clicks on Add Drug to add drug to drug list
      | BrandDrugName | <brundDrug> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Monthly Drug Costs by Stage Info Modals
    Then the user validates Monthly Drug Costs
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brundDrug>   |
      | Generic Drug | <genericDrug> |
    Then the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    Then the user deletes the following drug from Drug list
      | DrugName | <deleteDrug> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <addDrug> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates the Drug list on Drug Details Page
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user validates link to Drug Summary Page

    @DCE_DrugDetailsValidation_AARP
    Examples: 
      | drugnameAutocomplete | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site | brundDrug | genericDrug | deleteDrug | addDrug |
      | ativ                 | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | Ativan    | Lorazepam   | Humalog    | Lipitor |

    @DCE_DrugDetailsValidation_UHC
    Examples: 
      | drugnameAutocomplete | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site | brundDrug | genericDrug | deleteDrug | addDrug |
      | ativ                 | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | UHC  | Ativan    | Lorazepam   | Humalog    | Lipitor |

  @DCE_DrugDetailsDynamicCopay_Preferred
  Scenario Outline: To verify DCE REDESIGN Details Page for Dynamic copay section for Preferred Pharmacy Copay from <site> home page
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

    @DCE_DrugDetailsCopay_Preferred_AARP
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | AARP | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |

    @DCE_DrugDetailsCopay_Preferred_UHC
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | UHC  | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |

  @DCE_DrugDetailsDynamicCopay_Standard
  Scenario Outline: To verify DCE REDESIGN Details Page for Dynamic copay section for Standard Pharmacy Copay from <site> home page
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
    Then the user validates link to Drug Summary Page

    @DCE_DrugDetailsCopay_Standard_AARP
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                                            | site | DefaultSelected | MailPharSelected |
      | vigabatrin | Fanapt |   80001 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | Standard Retail | Standard Mail    |
      | vigabatrin | Fanapt |   78006 | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | AARP | Standard Retail | Standard Mail    |

    @DCE_DrugDetailsCopay_Standard_UHC
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                                            | site | DefaultSelected | MailPharSelected |
      | vigabatrin | Fanapt |   80001 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | UHC  | Standard Retail | Standard Mail    |
      | vigabatrin | Fanapt |   78006 | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | UHC  | Standard Retail | Standard Mail    |

  @DCE_DrugDetailsPremiumValidation
  Scenario Outline: To verify DCE REDESIGN Details Page for Zero or Range Premium from <site> home page
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

    @DCE_DrugDetailsPremiumValidation_AARP
    Examples: 
      | drug1   | zipCode | planType | planName                                                   | site | premium |
      | Orkambi |   90210 | MAPD     | UnitedHealthcare Medicare Advantage Assure (HMO)           | AARP | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)      | AARP | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP | $0      |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)                 | AARP | $0 - $  |
      | Orkambi |   66032 | SNP      | UnitedHealthcare Dual Complete LP1 (HMO-POS D-SNP)         | AARP | $0 - $  |

    @DCE_DrugDetailsPremiumValidation_UHC
    Examples: 
      | drug1   | zipCode | planType | planName                                                   | site | premium |
      | Orkambi |   90210 | MAPD     | UnitedHealthcare Medicare Advantage Assure (HMO)           | UHC  | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)      | UHC  | $0 - $  |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | UHC  | $0      |
      | Orkambi |   75002 | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)                 | UHC  | $0 - $  |
      | Orkambi |   66032 | SNP      | UnitedHealthcare Dual Complete LP1 (HMO-POS D-SNP)         | UHC  | $0 - $  |
