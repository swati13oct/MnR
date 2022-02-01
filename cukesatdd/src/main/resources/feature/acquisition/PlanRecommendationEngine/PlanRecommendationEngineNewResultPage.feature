@PlanRecommendationEngine
Feature: 1.18.4 Plan Recommendation Engine flow - Verify PRE flows functionalities with pharmacy session cookies

  @PRE @DrugDCEtoPRE @F727268 @PharmacySessionStorageDCEtoPRE
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate Drugs details are reflecting from VPP to DCE and PRE Page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    And user navigates to vpp summary page
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    When user adds Drugs and Pharmacy in vpp summary page
      | Drug Details  | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
      | Zip Code      | <Zipcode>                                                                      |
      | Pharmacy Name | <pharmacy>                                                                     |
    When user navigates to Zip Code page from vpp plans
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option and comparing DCE and Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate pharmacy coverage and Change Pharmacy Link in Result page
      | Plan Info     | <PlanDetail> |
      | Pharmacy Name | <pharmacy>   |
    Then user update Pharmacy using Change Pharmacy Link in result page
      | New ZipCode      | <Zipcode1>       |
      | New PharmacyName | <UpdatePharmacy> |
    Then user validate pharmacy coverage and Change Pharmacy Link in Result page
      | Plan Info     | <PlanDetail1>     |
      | Pharmacy Name | <UpdatedPharmacy> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | pharmacy        | PlanDetail                              | UpdatePharmacy                                   | Zipcode1 | UpdatedPharmacy                 | PlanDetail1                              |
      | AARP |   80002 | YES           | Jefferson County   | PDP           | Yes            | Lipitor,YES,Lipitor TAB 80MG,,,Week,1,YES,NO                                 | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | COSTCO PHARMACY | Walgreens (PPO),YES:Walgreens (PDP),OON | Walgreens (PDP),OON,US BIOSERVICES               |    28035 | US BIOSERVICES                  | Walgreens (PDP),INN:Walgreens (PPO),INN  |
      | AARP |   28035 | NO            | Mecklenburg County | PDP           | Yes            | Lipitor,YES,Lipitor TAB 40MG,,,Month,1,YES,NO                                | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | NEIL MEDICAL    | Choice (PPO),INN                        | Choice (PPO),INN,ANTHC OUTPATIENT SURGERY CENTER |    99508 | ANTHC OUTPATIENT SURGERY CENTER | Choice (PPO),YES:Walgreens (HMO-POS),OON |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | pharmacy        | PlanDetail                              | UpdatePharmacy                                   | Zipcode1 | UpdatedPharmacy                 | PlanDetail1                              |
      | UHC  |   80002 | YES           | Jefferson County   | PDP           | Yes            | Lipitor,YES,Lipitor TAB 80MG,,,Week,1,YES,NO                                 | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | COSTCO PHARMACY | Walgreens (PPO),YES:Walgreens (PDP),OON | Walgreens (PDP),OON,US BIOSERVICES               |    28035 | US BIOSERVICES                  | Walgreens (PDP),INN:Walgreens (PPO),INN  |
      | UHC  |   28035 | NO            | Mecklenburg County | PDP           | Yes            | Lipitor,YES,Lipitor TAB 40MG,,,Month,1,YES,NO                                | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | NEIL MEDICAL    | Choice (PPO),INN                        | Choice (PPO),INN,ANTHC OUTPATIENT SURGERY CENTER |    99508 | ANTHC OUTPATIENT SURGERY CENTER | Choice (PPO),YES:Walgreens (HMO-POS),OON |
