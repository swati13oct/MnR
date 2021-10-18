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
    Then user validates Sort By drop down UI PRE-Result page
    Then user validates Sort By elements visibility PRE-Result page
      | Visibility Info | <Visibleinfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | Visibleinfo                     |
      | AARP |   10003 | NO            | New York         | PDP           | No             | Medigap,true                    |
      | AARP |   59933 | NO            | Lincoln          | PDP           | No             | MAPD,true:Medigap,true:SNP,true |
      | AARP |   21212 | YES           | Baltimore County | PDP           | No             | MAPD,true:Medigap,true          |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | Drug Selection | Visibleinfo                     |
      | UHC  |   10003 | NO            | New York         | PDP           | No             | Medigap,true                    |
      | UHC  |   59933 | NO            | Lincoln          | PDP           | No             | MAPD,true:Medigap,true:SNP,true |
      | UHC  |   21212 | YES           | Baltimore County | PDP           | No             | MAPD,true:Medigap,true          |

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
    Then user validates Sort By dropdown will not display in UI PRE-Result page

    @regressionAARP @F527970
    Examples: 
      | site | Zipcode | isMultiCounty | county                 | isCoverageOpt | Drug Selection | DrugInfo                                                      |
      | AARP |   99502 | NO            | Anchorage Municipality | PDP           | Yes            | Plus (PDP),add your drugs,N/A:Plan 1 (HMO),add your drugs,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county                 | isCoverageOpt | Drug Selection | DrugInfo                                                      |
      | UHC  |   99502 | NO            | Anchorage Municipality | PDP           | Yes            | Plus (PDP),add your drugs,N/A:Plan 1 (HMO),add your drugs,N/A |

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
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                               |
      | AARP |   10003 | NO            | New York | PDP           | No             | Mosaic Choice (PPO),add your drugs,N/A |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugInfo                               |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Mosaic Choice (PPO),add your drugs,N/A |

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
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                   | DrugInfo                                                                                                                                                                                                                         |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO                                                                                                                                      | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True:Walgreens (PDP),atorvastatin calcium TAB 10MG,True:Walgreens (PDP),azathioprine TAB 50MG,True                                            |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,3,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:fentanyl citrate/bupivacaine hydrochloride/sodium chloride,YES,fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,,,Month,1,NO,NO | Plan 1 (PPO I-SNP),morphine sulfate CAP 10MG ER,False:Plan 2 (HMO I-SNP),Lipotriad TAB,False:Patriot (HMO),does not cover,N/A:Plan 4 (Regional PPO),fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,False |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                   | DrugInfo                                                                                                                                                                                                                         |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO                                                                                                                                      | Plan 1 (HMO),atorvastatin calcium TAB 10MG,True:Plan 1 (HMO),azathioprine TAB 50MG,True:Walgreens (PDP),atorvastatin calcium TAB 10MG,True:Walgreens (PDP),azathioprine TAB 50MG,True                                            |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,3,NO,NO:Lipotriad,NO,Lipotriad TAB,,,Week,1,NO,NO:fentanyl citrate/bupivacaine hydrochloride/sodium chloride,YES,fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,,,Month,1,NO,NO | Plan 1 (PPO I-SNP),morphine sulfate CAP 10MG ER,False:Plan 2 (HMO I-SNP),Lipotriad TAB,False:Patriot (HMO),does not cover,N/A:Plan 4 (Regional PPO),fentanyl citrate/bupivacaine hydrochloride/sodium chloride INJ 0.2/100,False |

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

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | UHC  |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

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
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds     | doctors         | DoctorsName           | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                                                                                  |
      #| AARP |   10001 | NO            | New York | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO),local or National,False:Preferred (PDP),do not include,False:Home Plan 2 (HMO I-SNP),local or National,False             |
      #| AARP |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Home Plan 2 (HMO I-SNP),Access to doctors,True |
      #| AARP |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | Lookup          | Phyllis C Suen MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,False:Plan 1 (HMO),Phyllis C Suen MD,True                                                   |
      | AARP |   19901 | NO            | Kent County | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage (HMO),unitedhealthcare network,False:Preferred (PDP),do not include,False:Plan 2 (PPO I-SNP),Access to in-network,True:Plan G,provider nation,True |
      | AARP |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Patriot (HMO),access to doctors,True:Plan K,any provider,N/A               |
      | AARP |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | Lookup          | Sender, Gregory S, PA | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Gregory S Sender PA,False:Advantage (HMO),Gregory S Sender PA,True:Plus (PDP),do not include,False:Plan L,Gregory S Sender PA,MSCoverage  |

    @regressionAARP @BHDHProviders
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | specialNeeds | doctors | DoctorsName                            | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                                                                             |
      | AARP |   90001 | NO            | Los Angeles County | MAPD          | None         | Lookup  | Cristian Penciu MD:Virginia S Hogan MA | No            | Yes            | Lipitor,NO,Lipitor TAB 40MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Complete (HMO C-SNP),Cristian Penciu MD,True:Plan 1 (HMO),Virginia S Hogan MA,True:Plus (PDP),do not include,False:Plan L,Cristian Penciu MD,MSCoverage |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds     | doctors         | DoctorsName           | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                                                                                  |
      # | UHC  |   10001 | NO            | New York | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO),local or National,False:Preferred (PDP),do not include,False:Home Plan 2 (HMO I-SNP),local or National,False             |
      # | UHC  |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]           | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Home Plan 2 (HMO I-SNP),Access to doctors,True |
      # | UHC  |   10001 | NO            | New York | MAPD          | Chronic,Nursing  | Lookup          | Phyllis C Suen MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,False:Plan 1 (HMO),Phyllis C Suen MD,True                                                   |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Medicaid,Nursing | AcceptsMedicare | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage (HMO),unitedhealthcare network,False:Preferred (PDP),do not include,False:Plan 2 (PPO I-SNP),Access to in-network,True:Plan G,provider nation,True |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | UHGNetwork      | [blank]               | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Walgreens (PDP),do not include,False:Plan 1 (PPO I-SNP),Access to in-network,True:Patriot (HMO),access to doctors,True:Plan K,any provider,N/A               |
      | UHC  |   19901 | NO            | Kent County | MAPD          | Chronic,Nursing  | Lookup          | Sender, Gregory S, PA | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Gregory S Sender PA,False:Advantage (HMO),Gregory S Sender PA,True:Plus (PDP),do not include,False:Plan L,Gregory S Sender PA,MSCoverage  |

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
    Then user navigates to PRE doctorpage to add providers
    #Then user navigate Doctors lookup session in Doctors page
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user validate doctors info in PRE results page
      | DoctorsInfo | <doctorsInfo1> |
    Then user navigates to PRE doctorpage to edit providers
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName2>  |
      | Multi Doctor        | <isMultiDoctor> |
    Then user validate doctors info in PRE results page
      | DoctorsInfo | <doctorsInfo2> |
    Then user return to vpp page using "return" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @PREMSPlanTile @TestRun
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                              | doctorsInfo1                           | DoctorsName2       | doctorsInfo2                       |
      | AARP |   35004 | NO            | St. Clair County | MAPD          | Chronic,Nursing | Lookup  | Simon Harold E MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Home Plan (PPO I-SNP),Add your doctors,N/A:Plan 3 (HMO),Add your doctors,N/A:Plan L,Add your doctors,N/A | Walgreens (HMO),Harold E Simon MD,True | Fuller, Justin, NP | Plan K,Justin Fuller NP,MSCoverage |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                                                                                              | doctorsInfo1                           | DoctorsName2       | doctorsInfo2                       |
      | UHC  |   35004 | NO            | St. Clair County | MAPD          | Chronic,Nursing | Lookup  | Simon Harold E MD | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Home Plan (PPO I-SNP),Add your doctors,N/A:Plan 3 (HMO),Add your doctors,N/A:Plan L,Add your doctors,N/A | Walgreens (HMO),Harold E Simon MD,True | Fuller, Justin, NP | Plan K,Justin Fuller NP,MSCoverage |

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
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | snpInfo                                                                                                                           |
      | AARP |   90210 | NO            | Los Angeles  | MAPD          | Medicaid                 | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | SecureHorizons Focus (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                         |
      | AARP |   90210 | NO            | Los Angeles  | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage Assure (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                             |
      | AARP |   65656 | YES           | Stone County | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO-POS),anyone with Medicare,NoIcon:Choice (PPO D-SNP),Medicare and Medicaid,True:Gold (Regional PPO C-SNP),chronic,True |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | snpInfo                                                                                                                           |
      | UHC  |   90210 | NO            | Los Angeles  | MAPD          | Medicaid                 | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | SecureHorizons Focus (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                         |
      | UHC  |   90210 | NO            | Los Angeles  | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Advantage Assure (HMO),anyone with Medicare,NoIcon:Advantage Assure (HMO),anyone with Medicare,NoIcon                             |
      | UHC  |   65656 | YES           | Stone County | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | Yes            | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (HMO-POS),anyone with Medicare,NoIcon:Choice (PPO D-SNP),Medicare and Medicaid,True:Gold (Regional PPO C-SNP),chronic,True |

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
      | Plan Info | <planInfo> |

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
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors | DoctorsName                                                                | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                              |
      | AARP |   10001 | NO            | New York    | MAPD          | Chronic      | Lookup  | Phyllis C Suen MD:John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD        | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,N/A |
      | AARP |   35035 | YES           | Bibb County | MAPD          | Chronic      | Lookup  | Michael W Luther MD:Watkins Roschanda NP:Preston Loretta NP:Gantt Emily NP | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan K,Roschanda Watkins NP,N/A          |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors | DoctorsName                                                                | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | doctorsInfo                              |
      | UHC  |   10001 | NO            | New York    | MAPD          | Chronic      | Lookup  | Phyllis C Suen MD:John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD        | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan 1 (PPO I-SNP),Phyllis C Suen MD,N/A |
      | UHC  |   35035 | YES           | Bibb County | MAPD          | Chronic      | Lookup  | Michael W Luther MD:Watkins Roschanda NP:Preston Loretta NP:Gantt Emily NP | No            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan K,Michael W Luther MD,N/A           |

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
      | DrugInfo | <DrugInfo2> |

    @regressionAARP @PREMSPlanTile
    Examples: 
      | site | Zipcode | isMultiCounty | county         | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                            | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | DrugInfo                                                                    | DrugInfo1                              | DrugInfo2                               |
      | AARP |   32115 | NO            | Volusia County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:fentanyl citrate,NO,fentanyl citrate LOZ 200MCG,,,Week,1,NO,NO:Nutrilipid,NO,Nutrilipid EMU 20%,,,Week,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan L,atorvastatin calcium TAB 10MG,True:Plan G,azathioprine TAB 50MG,True | Plan N,fentanyl citrate LOZ 200MCG,N/A | Plan N,fentanyl citrate LOZ 200MCG,True |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county         | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                                                                                                                                                                                                                                                                                                                                                            | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | DrugInfo                                                                    | DrugInfo1                              | DrugInfo2                               |
      | UHC  |   32115 | NO            | Volusia County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | atorvastatin calcium,YES,atorvastatin calcium TAB 10MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 20MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 40MG,,,Day,3,NO,NO:atorvastatin calcium,YES,atorvastatin calcium TAB 80MG,,,Day,3,NO,NO:azathioprine,NO,azathioprine TAB 50MG,,,Week,1,NO,NO:fentanyl citrate,NO,fentanyl citrate LOZ 200MCG,,,Week,1,NO,NO:Nutrilipid,NO,Nutrilipid EMU 20%,,,Week,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision | Plan L,atorvastatin calcium TAB 10MG,True:Plan G,azathioprine TAB 50MG,True | Plan N,fentanyl citrate LOZ 200MCG,N/A | Plan N,fentanyl citrate LOZ 200MCG,True |

  @PRE @planrecommendation
  Scenario Outline: - To validate Filter By PlanType in PRE Result page
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
    Then user validate elements in loading results page
    Then user validates Sort By drop down UI PRE-Result page
    Then user validates Sort By using PlanType in PRE-Result page
      | Sort PlanType | <sortInfo> |
    Then user removed filtered planType and Check Breadcrumbs in PRE-Result page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | sortInfo             |
      | AARP |   90002 | NO            | Los Angeles County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Vision | MAPD,MEDIGAP,PDP,SNP |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | sortInfo             |
      | UHC  |   90002 | NO            | Los Angeles County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Vision | MAPD,MEDIGAP,PDP,SNP |

  @PRE @PREMSE2E
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <1stRecommendation> , <2ndRecommendation> , <UserType>  - To Validate PRE Widget Reommendations in visitor profile page
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    And user views plan details from results page
      | Plan Info | <planInfo> |

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county                 | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | planInfo          |
      | AARP |   82071 | NO            | Albany County          | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Dental, Doctors              | Plan K,ViewButton |
      | AARP |   59620 | NO            | Lewis and Clark County | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Higher               | both           | Health Care Premium, Doctors | Plan F,Link       |
      | AARP |   59620 | NO            | Lewis and Clark County | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Higher               | both           | Health Care Premium, Doctors | Plan L,ViewButton |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county                 | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | planInfo          |
      | UHC  |   82071 | NO            | Albany County          | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Dental, Doctors              | Plan G,Link       |
      | UHC  |   59620 | NO            | Lewis and Clark County | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Higher               | both           | Health Care Premium, Doctors | Plan F,ViewButton |
      | UHC  |   59620 | NO            | Lewis and Clark County | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Higher               | both           | Health Care Premium, Doctors | Plan N,Link       |
