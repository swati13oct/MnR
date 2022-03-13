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

    @regressionAARP @march_Sprint1
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | pharmacy        | PlanDetail                              | UpdatePharmacy                                   | Zipcode1 | UpdatedPharmacy                 | PlanDetail1                              |
      | AARP |   80002 | YES           | Jefferson County   | PDP           | Yes            | Lipitor,YES,Lipitor TAB 80MG,,,Week,1,YES,NO                                 | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | COSTCO PHARMACY | Walgreens (PPO),YES:Walgreens (PDP),OON | Walgreens (PDP),OON,US BIOSERVICES               |    28035 | US BIOSERVICES                  | Walgreens (PDP),INN:Walgreens (PPO),OON  |
      | AARP |   28035 | NO            | Mecklenburg County | PDP           | Yes            | Lipitor,YES,Lipitor TAB 40MG,,,Month,1,YES,NO                                | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | NEIL MEDICAL    | Choice (PPO),INN                        | Choice (PPO),INN,ANTHC OUTPATIENT SURGERY CENTER |    99508 | ANTHC OUTPATIENT SURGERY CENTER | Choice (PPO),YES:Walgreens (HMO-POS),YES |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | pharmacy        | PlanDetail                              | UpdatePharmacy                                   | Zipcode1 | UpdatedPharmacy                 | PlanDetail1                              |
      | UHC  |   80002 | YES           | Jefferson County   | PDP           | Yes            | Lipitor,YES,Lipitor TAB 80MG,,,Week,1,YES,NO                                 | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | COSTCO PHARMACY | Walgreens (PPO),YES:Walgreens (PDP),OON | Walgreens (PDP),OON,US BIOSERVICES               |    28035 | US BIOSERVICES                  | Walgreens (PDP),INN:Walgreens (PPO),OON  |
      | UHC  |   28035 | NO            | Mecklenburg County | PDP           | Yes            | Lipitor,YES,Lipitor TAB 40MG,,,Month,1,YES,NO                                | Lipitor TAB 80MG,,10,Day,3,YES,NO                         | NEIL MEDICAL    | Choice (PPO),INN                        | Choice (PPO),INN,ANTHC OUTPATIENT SURGERY CENTER |    99508 | ANTHC OUTPATIENT SURGERY CENTER | Choice (PPO),YES:Walgreens (HMO-POS),YES |

  @PRE @F749417
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate compare functionality in PRE Result page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user delete a plan and add some other plan for compare in result page
      | Compare PlanInfo | <comparePlans> |
      | Delete PlanInfo  | <DeletePlans>  |
      | Add PlanInfo     | <AddPlans>     |

    @march_Sprint2 @comparePlansDeleteAndAdd
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | comparePlans                                                                                         | DeletePlans        | AddPlans           |
      | AARP |   19901 | NO            | Kent County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,Yes,Yes,Yes               | Higher               | both           | Doctors, Vision | Plan F,True:Plan G,True:Choice (PPO),True:Patriot (HMO),True:Plus (PDP),True:Select (HMO D-SNP),True | Select (HMO D-SNP) | Plan 2 (PPO I-SNP) |

  @PRE @F749417
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate compare functionality in PRE Result page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user selects Max plans to validate compare functionality in result page
      | Compare PlanInfo | <comparePlans> |

    @MaxPlanCompare
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | comparePlans                                                                                         | 
      | AARP |   19901 | NO            | Kent County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,Yes,Yes,Yes               | Higher               | both           | Doctors, Vision | Plan F,True:Plan G,True:Choice (PPO),True:Patriot (HMO),True:Plus (PDP),True:Select (HMO D-SNP),True | 

  @PRE @F749417
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> -  To validate compare functionality in PRE Result page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user selects plans to validate compare functionality in result page
      | Compare PlanInfo | <comparePlans> |

    @comparePlans
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | comparePlans                                                          |
      | AARP |   19901 | NO            | Kent County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,Yes,Yes,Yes               | Higher               | both           | Doctors, Vision | Plan G,True:Choice (PPO),True:Plus (PDP),True:Select (HMO D-SNP),True |
