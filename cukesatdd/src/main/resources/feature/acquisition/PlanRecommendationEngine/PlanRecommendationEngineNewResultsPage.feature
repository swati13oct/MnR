@PlanRecommendationEngine @PREResultsRegression
Feature: Plan Recommendation Engine flow - Verify PRE New Results page in plan Recommendation Engine

  @PRE @planrecommandonation @PREVPPPage @F527967 @PREVPPPageElementsPDP
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user validate elements in PRE results page
      | Zip Code       | <Zipcode> |
      | CountyDropDown | <county>  |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | AARP |   10003 | NO            | New York | PDP           | No             |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | UHC  |   10003 | NO            | New York | PDP           | No             |

  @PRE @planrecommandonation @PREVPPPage @F527967 @PREVPPPPaginationPDP
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate pagination in PRE results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | AARP |   10003 | NO            | New York | PDP           | No             |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | UHC  |   10003 | NO            | New York | PDP           | No             |

  @PRE @planrecommandonation @PREResultsPage @PREPDPEmptyDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                                     |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | Plan 1 (HMO),You haven't added any drugs,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                                     |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | Plan 1 (HMO),You haven't added any drugs,N/A |

  @PRE @planrecommandonation @PREResultsPage @PREPDPNoDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                                            |
      | AARP |   10003 | NO            | New York | PDP           | No             | Mosaic Choice (PPO),You haven't added any drugs,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                                            |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Mosaic Choice (PPO),You haven't added any drugs,N/A |

  @PRE @planrecommandonation @PREResultsPage @PREResultsPDPDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate drugDetails in PRE results page
      | DrugInfo | <DrugInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                              | DrugInfo                                                                                                                                                                              |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True:Walgreens (PDP),atorvastatin calcium TAB 10MG,True:Walgreens (PDP),azathioprine TAB 50MG,True |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,3,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO                  | Complete (HMO D-SNP),morphine sulfate CAP 10MG ER,False:Complete (HMO D-SNP),Lipotriad TAB,False:Patriot (HMO),does not cover,N/A                                                     |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                              | DrugInfo                                                                                                                                                                              |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True:Walgreens (PDP),atorvastatin calcium TAB 10MG,True:Walgreens (PDP),azathioprine TAB 50MG,True |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,3,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO                  | Complete (HMO D-SNP),morphine sulfate CAP 10MG ER,False:Complete (HMO D-SNP),Lipotriad TAB,False:Patriot (HMO),does not cover,N/A                                                     |

  @PRE @planrecommendation @MAPDTile @PREVPPPageElementsMAPD
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate elements in PRE results page
      | Zip Code       | <Zipcode> |
      | CountyDropDown | <county>  |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | AARP |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

    #      | AARP |   15537 | NO            | Bedford | MAPD          | None                 | UHGNetwork      | [blank]     | [blank]       | NO             |     [blank]                                                                                          | No,No,No,No                   | Lower                | 2nd            | Doctors, Health Care Premium |
    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | UHC  |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

  #      | UHC  |   15537 | NO            | Bedford | MAPD          | None                 | UHGNetwork      | [blank]     | [blank]       | NO             |     [blank]                                                                                          | No,No,No,No                   | Lower                | 2nd            | Doctors, Health Care Premium |
  @PRE @planrecommendation @MAPDTile @PREResultsMAPDAcceptDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate doctors info in PRE results page
      | DoctorsInfo | <doctorsInfo> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds     | doctors         | DoctorsName           | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                                                                                 |
      #| AARP |   10001 | NO            | New York | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO),local or National,False:Preferred (PDP),do not include,False:Home Plan 2 (HMO I-SNP),local or National,False             |
      #| AARP |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Home Plan 2 (HMO I-SNP),Access to doctors,True |
      #| AARP |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | Lookup          | Phyllis C Suen MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,False:Plan 1 (HMO),Phyllis C Suen MD,True                                                   |
      | AARP |   19901 | NO            | Kent County | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage (HMO),local or National,False:Preferred (PDP),do not include,False:Plan 2 (PPO I-SNP),Access to in-network,True:Plan G,provider nation,True       |
      | AARP |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Patriot (HMO),access to doctors,True:Plan B,any provider,N/A              |
      | AARP |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | Lookup          | Sender, Gregory S, PA | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Gregory S Sender PA,False:Advantage (HMO),Gregory S Sender PA,True:Plus (PDP),do not include,False:Plan L,Gregory S Sender PA,MSCoverage |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds     | doctors         | DoctorsName           | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                                                                                 |
      # | UHC  |   10001 | NO            | New York | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO),local or National,False:Preferred (PDP),do not include,False:Home Plan 2 (HMO I-SNP),local or National,False             |
      # | UHC  |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Home Plan 2 (HMO I-SNP),Access to doctors,True |
      # | UHC  |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | Lookup          | Phyllis C Suen MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,False:Plan 1 (HMO),Phyllis C Suen MD,True                                                   |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage (HMO),local or National,False:Preferred (PDP),do not include,False:Plan 2 (PPO I-SNP),Access to in-network,True:Plan G,provider nation,True       |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Patriot (HMO),access to doctors,True:Plan B,any provider,N/A              |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | Lookup          | Sender, Gregory S, PA | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Gregory S Sender PA,False:Advantage (HMO),Gregory S Sender PA,True:Plus (PDP),do not include,False:Plan L,Gregory S Sender PA,MSCoverage |

  @PRE @planrecommendation @MAPDTile @PREResultsMAPDZeroDoctor
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    And user selects empty doctors in doctors page
      | Doctors Search Text | <DoctorsName> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate doctors info in PRE results page
      | DoctorsInfo | <doctorsInfo> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                           |
      | AARP |   35004 | NO            | St. Clair County | MAPD          | Chronic,Nursing | Lookup  | Simon Harold E MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Home Plan (PPO I-SNP),any doctors yet,N/A:Plan 3 (HMO),any doctors yet,N/A:Plan A,any doctors yet,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                           |
      | UHC  |   35004 | NO            | St. Clair County | MAPD          | Chronic,Nursing | Lookup  | Simon Harold E MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Home Plan (PPO I-SNP),any doctors yet,N/A:Plan 3 (HMO),any doctors yet,N/A:Plan A,any doctors yet,N/A |

  @PRE @planrecommendation @MAPDTile @PREResultsMAPDSNP
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate snp info in PRE results page
      | SNPInfo | <snpInfo> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | snpInfo                                                                                                                                                                |
      | AARP |   90210 | NO            | Los Angeles  | MAPD          | Medicaid                 | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | SecureHorizons Focus (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                                                              |
      | AARP |   90210 | NO            | Los Angeles  | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage Assure (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                                                                  |
      | AARP |   65656 | YES           | Stone County | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO-POS),anyone with Medicare,NoIcon:Complete (HMO D-SNP),Medicare and Medicaid,True:Home Plan (PPO I-SNP),nursing,True:Gold (Regional PPO C-SNP),chronic,True |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | snpInfo                                                                                                                                                                |
      | UHC  |   90210 | NO            | Los Angeles  | MAPD          | Medicaid                 | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | SecureHorizons Focus (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                                                              |
      | UHC  |   90210 | NO            | Los Angeles  | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage Assure (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                                                                  |
      | UHC  |   65656 | YES           | Stone County | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO-POS),anyone with Medicare,NoIcon:Complete (HMO D-SNP),Medicare and Medicaid,True:Home Plan (PPO I-SNP),nursing,True:Gold (Regional PPO C-SNP),chronic,True |

  @PRE @planrecommandonation @viewPlansPREResultsPage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  - Checks time validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user views plan details from results page
      | planInfo | <planInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | planInfo                |
      | AARP |   10003 | NO            | New York | PDP           | No             | Plan 1 (HMO),Link       |
      | AARP |   10003 | NO            | New York | PDP           | No             | Plan 1 (HMO),ViewButton |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | planInfo                |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Plan 1 (HMO),Link       |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Plan 1 (HMO),ViewButton |

  @PRE @planrecommandonation @learnMorePREResultsPage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  - Checks time validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user views learn more from results page
      | Learn More | <learnMore> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | learnMore  |
      | AARP |   10003 | NO            | New York | PDP           | No             | Advantage  |
      | AARP |   10003 | NO            | New York | PDP           | No             | Supplement |
      | AARP |   10003 | NO            | New York | PDP           | No             | Drug       |
      | AARP |   10003 | NO            | New York | PDP           | No             | Special    |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | learnMore  |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Advantage  |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Supplement |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Drug       |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Special    |

  @PRE @planrecommandonation @PREResultsPage @viewIndividualDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate drugCostModal in PRE results page
      | DrugInfo | <DrugInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                         | DrugInfo                                                                                                  |
      | AARP |   10003 | NO            | New York    | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO            | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True                   |
      | AARP |   35035 | YES           | Bibb County | PDP           | Yes            | fentanyl citrate,YES,FENTANYL CITRATE PREFILLED SYRINGE 20MCG,,,Month,1,NO,NO:Zolgensma,YES,Zolgensma 10.1-10.5 KG INJ,,,Day,1,NO,NO | Plan 1 (HMO),FENTANYL CITRATE PREFILLED SYRINGE 20MCG,False:Plan 1 (HMO),Zolgensma 10.1-10.5 KG INJ,False |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                         | DrugInfo                                                                                                  |
      | UHC  |   10003 | NO            | New York    | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO            | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True                   |
      | UHC  |   35035 | YES           | Bibb County | PDP           | Yes            | fentanyl citrate,YES,FENTANYL CITRATE PREFILLED SYRINGE 20MCG,,,Month,1,NO,NO:Zolgensma,YES,Zolgensma 10.1-10.5 KG INJ,,,Day,1,NO,NO | Plan 1 (HMO),FENTANYL CITRATE PREFILLED SYRINGE 20MCG,False:Plan 1 (HMO),Zolgensma 10.1-10.5 KG INJ,False |

  @PRE @planrecommandonation @PREResultsPage @showMoreDrug
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate showmoreDrug in PRE results page
      | DrugInfo | <DrugInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                                                                                                             | DrugInfo                       |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:fentanyl citrate/bupivacaine hydrochloride/sodium chloride,YES,fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,,,Month,1,NO,NO | Plan 1 (HMO),Lipotriad TAB,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                                                                                                             | DrugInfo                       |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:fentanyl citrate/bupivacaine hydrochloride/sodium chloride,YES,fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,,,Month,1,NO,NO | Plan 1 (HMO),Lipotriad TAB,N/A |

  @PRE @planrecommendation @showMoreDoctor
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate showmoreDoctor in PRE results page
      | DoctorsInfo | <doctorsInfo> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors | DoctorsName                                                                   | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                              |
      | AARP |   10001 | NO            | New York    | MAPD          | Chronic      | Lookup  | Phyllis C Suen MD:John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD           | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,N/A |
      | AARP |   35035 | YES           | Bibb County | MAPD          | Chronic      | Lookup  | Taylor Burnestine P MD:Watkins Roschanda NP:Preston Loretta NP:Gantt Emily NP | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan K,Burnestine P Taylor MD,N/A        |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors | DoctorsName                                                                   | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                              |
      | UHC  |   10001 | NO            | New York    | MAPD          | Chronic      | Lookup  | Phyllis C Suen MD:John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD           | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,N/A |
      | UHC  |   35035 | YES           | Bibb County | MAPD          | Chronic      | Lookup  | Taylor Burnestine P MD:Watkins Roschanda NP:Preston Loretta NP:Gantt Emily NP | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan K,Burnestine P Taylor MD,N/A        |

  @PRE @planrecommendation @MSshowMoreDrug @MSviewIndividualDrug @MSWhySeparateModel
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate drugCostModal in PRE results page
      | DrugInfo | <DrugInfo> |
    Then user validate showmoreDrug in PRE results page
      | DrugInfo | <DrugInfo1> |
    Then user validate WhySeparateModel plan in PRE results page
      | DrugInfo | <DrugInfo1> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                       | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | DrugInfo                                                                          | DrugInfo1                |
      | AARP |   10003 | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:Nutrilipid,NO,Nutrilipid EMU 20%,,,Week,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan L,atorvastatin calcium TAB 10MG,True:Plan G (HMO),azathioprine TAB 50MG,True | Plan B,Lipotriad TAB,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                       | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | DrugInfo                                                                          | DrugInfo1                |
      | UHC  |   10003 | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:Nutrilipid,NO,Nutrilipid EMU 20%,,,Week,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan L,atorvastatin calcium TAB 10MG,True:Plan G (HMO),azathioprine TAB 50MG,True | Plan B,Lipotriad TAB,N/A |
