@dce_planbenefits @dce
Feature: 1.10.1 DCE-REDISIGN - To test Plan Benefits - Premium, copays and deductible on DCE

  @dce_PlanBenefits_Standard
  Scenario Outline: To verify DCE REDESIGN page <site> site - Plan Benefits for Standard network plans - MAPD and SNP
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following FlagSmith User Navigation site page
    Then the user enters FlagSmith user and navigates to Home Page
      | User | <flagSmithUser> |
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <InsulinDrug> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county for Multi county as follows
      | ZipCode | <zipCode> |
      | County  | <county>  |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    Then the user validates Tier 1 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT1> |
    Then the user validates Tier 2 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT2> |
    Then the user validates Tier 3 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT3> |
    Then the user validates Tier 4 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT4> |
    Then the user validates Tier 5 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT5> |
    Then the user validates the deductible as follows
      | Deductible | <deductible> |
    Then the user validates the deductible stage modal text for plans having deductible as follows
      | DeductibleFlag | <deductibleFlag> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinFlag_Copay> |
      | Insulin Drug | <InsulinDrug>       |
    And user clicks on change pharmacy link from details page
    Then the user selects Mail Pharmacy and returns to DCE Details page
    Then the user validates Tier 1 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT1> |
    Then the user validates Tier 2 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT2> |
    Then the user validates Tier 3 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT3> |
    Then the user validates Tier 4 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT4> |
    Then the user validates Tier 5 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT5> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinFlag_MailCopay> |
      | Insulin Drug | <InsulinDrug>           |
    Then the user validates the text for coverage stages modal popups for Non-LIS Plans

  @dce_PlanBenefits_Standard_NextYear @NextYear
    Examples:
      | flagSmithUser | drug1     | drug2                | drug3      | drug4         | drug5      | InsulinDrug | zipCode | county            | planType | planName                                          | site | premium  | standardT1 | standardT2 | standardT3 | standardT4 | standardT5 | insulinFlag_Copay | deductible                                      | deductibleFlag | mailT1 | mailT2 | mailT3 | mailT4 | mailT5 | insulinFlag_MailCopay |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 80503   | Larimer County    | MAPD     | AARP Medicare Advantage Choice Plan 1 (PPO)       | AARP | $0       | $0         | $10        | $47        | $95        | 33%        | $35               | All Tiers: $0                                   | false          | $0     | $30    | $141   | $285   | N/A    | $105                  |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 66845   | Chase County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)         | UHC  | $74      | $4         | $14        | $47        | $100       | 28%        |                   | All Tiers: $295                                 | true           | $12    | $42    | $141   | $300   | N/A    |                       |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 74441   | Cherokee County   | MAPD     | AARP Medicare Advantage Plan 2 (HMO-POS)          | AARP | $0       | $3         | $10        | $45        | $95        | 33%        | $35               | All Tiers: $0                                   | false          | $9     | $30    | $135   | $285   | N/A    | $105                  |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 33111   | Miami-Dade County | MAPD     | Preferred Choice Dade (HMO)                       | AARP | $0       | $0         | $0         | $0         | $40        | 33%        | $0                | All Tiers: $0                                   | false          | $0     | $0     | $0     | $120   | N/A    | $0                    |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 33111   | Miami-Dade County | SNP      | Preferred Medicare Assist Plan 1 (HMO D-SNP)      | UHC  | $0 - $34 | $0         | $0         | 25%        | 25%        | 25%        |                   | Tier 1, Tier 2: $0;Tier 3, Tier 4, Tier 5: $480 | true           | $0     | $0     | 25%    | 25%    | N/A    |                       |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 80002   | Adams County      | SNP      | UnitedHealthcare Assisted Living Plan (PPO I-SNP) | UHC  | $39.80   | $2         | $12        | $47        | $100       | 29%        | $35               | Tier 1, Tier 2, Tier 3: $0;Tier 4, Tier 5: $200 | true           | $6     | $36    | $141   | $300   | N/A    | $105                  |
      | OCT-15        | meloxicam | diclofenac potassium | febuxostat | buprenorphine | vigabatrin | Humalog     | 33111   | Miami-Dade County | SNP      | Preferred Special Care Miami-Dade (HMO C-SNP)     | UHC  | $0       | $0         | $0         | $15        | $45        | 33%        | $15               | All Tiers: $0                                   | false          | $0     | $0     | $45    | $135   | N/A    | $45                   |


  @dce_PlanBenefits_Preferred
  Scenario Outline: To verify DCE REDESIGN page <site> site -  Plan Benefits for Preferred Newwork plans - PDP and MAPD Walgreen Plans
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <InsulinDrug> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county for Multi county as follows
      | ZipCode | <zipCode> |
      | County  | <county>  |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    Then the user validates the deductible as follows
      | Deductible | <deductible> |
    Then the user validates the deductible stage modal text for plans having deductible as follows
      | DeductibleFlag | <deductibleFlag> |
    Then the user validates the text for coverage stages modal popups for Non-LIS Plans
    Then the user validates Tier 1 Copay in copay section and in Your Drugs section
      | TierCopay | <preferredT1> |
    Then the user validates Tier 2 Copay in copay section and in Your Drugs section
      | TierCopay | <preferredT2> |
    Then the user validates Tier 3 Copay in copay section and in Your Drugs section
      | TierCopay | <preferredT3> |
    Then the user validates Tier 4 Copay in copay section and in Your Drugs section
      | TierCopay | <preferredT4> |
    Then the user validates Tier 5 Copay in copay section and in Your Drugs section
      | TierCopay | <preferredT5> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulin_Preferred> |
      | Insulin Drug | <InsulinDrug>       |
    And user clicks on change pharmacy link from details page
    Then the user selects Mail Pharmacy and returns to DCE Details page
    Then the user validates Tier 1 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT1> |
    Then the user validates Tier 2 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT2> |
    Then the user validates Tier 3 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT3> |
    Then the user validates Tier 4 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT4> |
    Then the user validates Tier 5 Copay in copay section and in Your Drugs section
      | TierCopay | <mailT5> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulin_Mail> |
      | Insulin Drug | <InsulinDrug>  |
    And user clicks on change pharmacy link from details page
    Then the user selects following Standard pharmacy and returns to DCE Details page
      | SelectStandardPharmacy | <SelectStandardPharmacy> |
    Then the user validates Tier 1 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT1> |
    Then the user validates Tier 2 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT2> |
    Then the user validates Tier 3 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT3> |
    Then the user validates Tier 4 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT4> |
    Then the user validates Tier 5 Copay in copay section and in Your Drugs section
      | TierCopay | <standardT5> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulin_Standard> |
      | Insulin Drug | <InsulinDrug>      |

  @dce_PlanBenefits_Preferred_NextYear @NextYear
    Examples:
      | drug1     | drug2    | drug3      | drug4  | drug5      | InsulinDrug | zipCode | county             | planType | planName                                | site | premium | preferredT1 | preferredT2 | preferredT3 | preferredT4 | preferredT5 | insulin_Preferred | deductible | deductibleFlag | mailT1 | mailT2 | mailT3 | mailT4 | mailT5 | insulin_Mail | SelectStandardPharmacy | standardT1 | standardT2 | standardT3 | standardT4 | standardT5 | insulin_Standard |
      | meloxicam | tramadol | febuxostat | Fanapt | vigabatrin | Humalog     | 80503   | Larimer County     | PDP      | AARP MedicareRx Saver Plus (PDP)        | AARP | $44     | $1          | $15         | $46         | 40%         | 25%         |                   | $480       | true           | $3     | $45    | $138   | 40%    | N/A    |              | CVS PHARMACY           | $6         | $20        | $47        | 40%        | 25%        |                  |
      | meloxicam | tramadol | febuxostat | Fanapt | vigabatrin | Humalog     | 80503   | Larimer County     | PDP      | AARP MedicareRx Preferred (PDP)         | UHC  | $103.90 | $5          | $10         | $45         | 40%         | 33%         | $35               | $0         | false          | $0     | $0     | $120   | 40%    | N/A    | $105         | CVS PHARMACY           | $15        | $20        | $47        | 45%        | 33%        | $35              |
      | meloxicam | tramadol | febuxostat | Fanapt | vigabatrin | Humalog     | 90210   | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)         | AARP | $30.50  | $0          | $10         | $40         | 40%         | 27%         |                   | $310       | true           | $0     | $30    | $120   | 40%    | N/A    |              | CVS PHARMACY           | $15        | $20        | $45        | 45%        | 27%        |                  |
      | meloxicam | tramadol | febuxostat | Fanapt | vigabatrin | Humalog     | 80002   | Adams County       | MAPD     | AARP Medicare Advantage Walgreens (PPO) | UHC  | $0      | $0          | $0          | $47         | $100        | 33%         | $35               | $0         | false          | $0     | $0     | $131   | $290   | N/A    | $95          | WALMART PHARMACY       | $10        | $20        | $47        | $100       | 33%        | $35              |


  @dce_PlanBenefits_BuyDown
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
    When user enters valid zipcode and county for Multi county as follows
      | ZipCode | <zipCode> |
      | County  | <county>  |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    Then the user validates correct Copay section view and LIS message Not Displayed and zero deductible for LIS Buydown Plan on DCE details Page
    Then the user validates Monthly Costs are not displayed for LIS Buydown plan on DCE details Page
    Then the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page
      | CoveredDrug | <drug1> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug2> |
    Then the user validates LIS text for coverages stages popups on DCE details page

  @dce_PlanBenefits_BuyDown
    Examples:
      | drug1  | drug2   | zipCode | county          | planType | planName                                   | site | premium |
      | Fanapt | Lipitor | 75002   | Collin County   | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | AARP | $0      |
      | Fanapt | Lipitor | 10001   | New York County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | UHC  | $0      |

  @dce_PlanBenefits_DefinedStandard
  Scenario Outline: To verify DCE Details Page <site> site - for LIS Non Buydown - Defined Standard Plans
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
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county for Multi county as follows
      | ZipCode | <zipCode> |
      | County  | <county>  |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    Then the user validates Copay Section for LIS for defined standard plan for following
      | LIScopay | <lisCopayGeneric> |
    Then the user validates Copay Section for LIS for defined standard plan for following
      | LIScopay | <lisCopayOthar> |
    Then the user validates Copay Section for non-LIS for defined standard plan for following
      | NonLIScopay | <nonLisCopay30days> |
    Then the user validates Copay Section for non-LIS for defined standard plan for following
      | NonLIScopay | <nonLisCopay100days> |
    Then the user validates the text for coverage stages modal popups for Non-LIS Plans
    Then the user validates deductible as follows for Defined Standard plans
      | Deductible | <deductible> |
    Then the user validates the deductible stage modal text for plans having deductible as follows
      | DeductibleFlag | <deductibleFlag> |

  @dce_PlanBenefits_DefinedStandard_NextYear @NextYear
    Examples:
      | drug1  | drug2   | zipCode | county            | planType | planName                                                   | site | premium    | lisCopayGeneric                                  | lisCopayOthar                                    | nonLisCopay30days | nonLisCopay100days | deductible | deductibleFlag |
      | Fanapt | Lipitor | 75002   | Collin County     | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP | $0         | $0, $1.30, $3.70 copay, or 15% of the total cost | $0, $4.00, $9.20 copay, or 15% of the total cost | 25% of the cost   | 25% of the cost    | $445       | true           |
      | Fanapt | Lipitor | 78006   | Bexar County      | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)      | UHC  | $0 - $3.70 | $0, $1.30, $3.70 copay, or 15% of the total cost | $0, $4.00, $9.20 copay, or 15% of the total cost | 25% of the cost   | 25% of the cost    | $445       | true           |
      | Fanapt | Lipitor | 78006   | Bexar County      | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | UHC  | $0         | $0, $1.30, $3.70 copay, or 15% of the total cost | $0, $4.00, $9.20 copay, or 15% of the total cost | 25% of the cost   | 25% of the cost    | $445       | true           |
      | Fanapt | Lipitor | 33111   | Miami-Dade County | SNP      | UnitedHealthcare Nursing Home Plan (PPO I-SNP)             | AARP | $34.30     | $0, $1.30, $3.70 copay, or 15% of the total cost | $0, $4.00, $9.20 copay, or 15% of the total cost | 25% of the cost   | 25% of the cost    | $445       | true           |

