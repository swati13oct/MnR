@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Drug page in plan Recommendation Engine

  @PRE @drugpage @drugelementValidation @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> - To validate Drug page Elements using Single County in Plan Recommendation Engine
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
    And user validate elements in drugs page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       |

  @PRE @drugpage @drugpageskip @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> - To validate Skip Drug Selection  in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | No             |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | No             |

  @PRE @drugpage @drugpageNotSelected @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> - To validate Skip Drug Selection  in Plan Recommendation Engine
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
    And user not selects prescription options in drug page
      | Drug Selection | <Drug Selection> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | [blank]        |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | [blank]        |

  @PRE @drugpage @drugpageadddrug @manualSuggestion @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName>, <isMultiDoctor>, <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page function with manual search in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,YES,Imuran TAB 50MG,,25,Month,3,YES,NO                                |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,YES,Imuran TAB 50MG,,25,Month,3,YES,NO                                |

  @PRE @drugpage @autoSuggestion @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName>, <isMultiDoctor>, <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page function with auto search in PRE
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO                                  |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO                                  |

  @PRE @drugpage @multipledrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page function with remove drug in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch             |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch             |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO |

  @PRE @drugpage @removedrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page function with remove drug in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                        |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,Week,1,YES,NO:Actiq,NO,,,,Month,1,YES,NO: |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                        |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,Week,1,YES,NO:Actiq,NO,,,,Month,1,YES,NO: |

  @PRE @drugpage @cancelmodal @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page cancel function in Plan Recommendation Engine
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
    Then user selects add drug option and cancels the modals in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,NO,,,,Day,1,YES,NO                                                    |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Imuran,NO,,,,Day,1,YES,NO                                                    |

  @PRE @drugpage @errorvalidation @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page error function in Plan Recommendation Engine
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
    Then user validates errors in Drug page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Imuran,YES,,,25,Day,1,YES,NO                                                 |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Imuran,YES,,,25,Day,1,YES,NO                                                 |

  @PRE @drugpage @choosedrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> , <SearchText> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>- To validate Drug page choose function in Plan Recommendation Engine
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
    Then user search and choose a drug in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Search Text    | <SearchText>                                                                   |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | SearchText | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor    | Lipitor,NO,,,25,Month,1,YES,NO                                               |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | SearchText | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | Lipitor    | Lipitor,NO,,,25,Month,1,YES,NO                                               |

  @PRE @drugpage @chooseNodrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> - To validate Drug page choose no drug function in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            |

  @PRE @drugpage @drugpage @switchdrug @F374225 @F565693
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> - To validate switch drug function in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,YES                                |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,YES                                |

  @PRE @drugpage @drugnotfound @drugpageadddrug @F374225 @F413341
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> , <Search Text> - To validate Drug page choose no drug function in Plan Recommendation Engine
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
    Then user search and not found a drug in Drug Page
      | Drug Selection | <Drug Selection> |
      | Search Text    | <Search Text>    |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Search Text |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | fedp        |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Search Text |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing | UHGNetwork | [blank]     | [blank]       | Yes            | fedp        |

  @PRE @drugpage @editDrug @F562627 @F572450
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection> - To validate switch drug function in PRE
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page without continue next page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user selects edit drug options in Drug Page
      | Edit Details | <Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1> |
    Then user added drug Quantity number prefix with zeros in Drug page
      | Edit Quantity | <EditQty> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | EditQty |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO               | morphine sulfate CAP 30MG ER,,007,Week,3,NO,NO            |     007 |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch1 | EditQty |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO               | morphine sulfate CAP 30MG ER,,007,Week,3,NO,NO            |     007 |
