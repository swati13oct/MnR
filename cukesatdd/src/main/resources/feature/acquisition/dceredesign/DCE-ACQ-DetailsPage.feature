@dce_redesign_DrugDetailsValidation
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @DCE_DrugDetailsValidation
  Scenario Outline: To verify DCE REDESIGN Details Page from <site> home page
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
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site | brundDrug | genericDrug                   | deleteDrug | addDrug |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | Adderall  | amphetamine/dextroamphetamine | Humalog    | Lipitor |

    @DCE_DrugDetailsValidation_UHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site | brundDrug | genericDrug                   | deleteDrug | addDrug |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | UHC  | Adderall  | amphetamine/dextroamphetamine | Humalog    | Lipitor |

  @DCE_DrugDetailsDynamicCopay @F506354
  Scenario Outline: To verify DCE REDESIGN Details Page for Dynamic copay section from <site> home page
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
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates the Drug list on Drug Details Page
    Then the user validates Important information section
    # Then the user validates Disclaimers section
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

    @DCE_DrugDetailsCopay_AARP
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | AARP | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |

    @DCE_DrugDetailsCopay_UHC
    Examples: 
      | drug1      | drug2  | zipCode | planType | planName                        | site | DefaultSelected  | MailPharSelected | SelectStandardPharmacy | StandardPharSelected |
      | vigabatrin | Fanapt |   80001 | PDP      | AARP MedicareRx Walgreens (PDP) | UHC  | Preferred Retail | Preferred Mail   | KING SOOPERS PHARMACY  | Standard Retail      |
