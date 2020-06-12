@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Drug page in plan Recommendation Engine

  @PRE @planrecommendation @drugpage @drugelementValidation @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> - To validate Drug page Elements using Single County in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user validate elements in drugs page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               |

  @PRE @planrecommendation @drugpage @drugpageskip @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> - To validate Skip Drug Selection  in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | No             |

  @PRE @planrecommendation @drugpage @drugpageNotSelected @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> - To validate Skip Drug Selection  in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user not selects prescription options in drug page
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               |                |

  @PRE @planrecommendation @drugpage @drugpageadddrug @manualSuggestion @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName>, <isMultiDoctor>, <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page function with manual search in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                              |

  @PRE @planrecommendation @drugpage @autoSuggestion @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName>, <isMultiDoctor>, <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page function with auto search in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                              |

  @PRE @planrecommendation @drugpage @multipledrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page function with remove drug in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch           |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO |

  @PRE @planrecommendation @drugpage @removedrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page function with remove drug in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                                 |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO:Actiq,NO,,,,1,YES,NO: |

  @PRE @planrecommendation @drugpage @cancelmodal @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page cancel function in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option and cancels the modals in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Imuran,NO,,,,1,YES,NO                                                |

  @PRE @planrecommendation @drugpage @errorvalidation @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page error function in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user validates errors in Drug page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Imuran,YES,,,25,1,YES,NO                                             |

  @PRE @planrecommendation @drugpage @choosedrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <SearchText> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch>- To validate Drug page choose function in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user search and choose a drug in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Search Text    | <SearchText>                                                           |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | SearchText | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | Lipi       | Lipitor,NO,,,25,1,YES,NO                                             |

  @PRE @planrecommendation @drugpage @chooseNodrug @drugpageadddrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> - To validate Drug page choose no drug function in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            |

  @PRE @planrecommendation @drugpage @drugpage @switchdrug @F374225
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> - To validate switch drug function in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,YES                              |

  @PRE @planrecommendation @drugpage @drugnotfound @drugpageadddrug @F374225 @F413341
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <Search Text> - To validate Drug page choose no drug function in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user search and not found a drug in Drug Page
      | Drug Selection | <Drug Selection> |
      | Search Text    | <Search Text>    |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Search Text |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork |             |               | Yes            | fedp        |
