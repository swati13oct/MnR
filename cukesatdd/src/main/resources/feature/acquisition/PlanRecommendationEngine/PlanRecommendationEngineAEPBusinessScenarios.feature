@PlanRecommendationEngine @PREAEPRegression
Feature: Plan Recommendation Engine Ranking - Verify Future PRE flows functionalities with recommendation and Ranking with API results

  @PRE @FutureAPIRanking @MAPDFlowRankingFuture
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate API Ranking for MA plans in PRE future year
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         |
      | AARP | OCT-01   |   13673 | NO            | Jefferson | MAPD          | Nursing      | Lookup  | Jennifer    | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Yes,Yes,Yes,Yes               | Lower                | both           | Drug Cost, Doctors |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county    | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         |
      | UHC  | OCT-15   |   13673 | NO            | Jefferson | MAPD          | Nursing      | Lookup  | Jennifer    | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Yes,Yes,Yes,Yes               | Lower                | both           | Drug Cost, Doctors |

  @PRE @APIRanking @MAPDFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>,  <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption> - To validate SNP API ranking plans in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities   |
      | AARP | OCT-15   |   55419 | No            | Hennepin | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Lower                | 1st            | Dental, None |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities   |
      | UHC  | OCT-15   |   55419 | No            | Hennepin | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Lower                | 1st            | Dental, None |

  @PRE @APIRanking @MAFutureFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MA flow functions for MA and MS plans in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds | doctors    | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      | AARP | OCT-15   |   10001 | NO            | New York         | MA            | None         | UHGNetwork | [blank]           | [blank]       | Yes,No,No,No                  | Lower                | both           | Doctors, Health Care Premium |
      | AARP | DEC-01   |   35004 | NO            | St. Clair County | MA            | Medicaid     | Lookup     | Simon Harold E MD | NO            | Yes,Yes,Yes,Yes               | Higher               | None           | Dental, Doctors              |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds     | doctors    | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      | UHC  | OCT-15   |   10001 | NO            | New York         | MA            | None             | UHGNetwork | [blank]           | [blank]       | Yes,No,No,No                  | Lower                | both           | Doctors, Health Care Premium |
      | UHC  | DEC-01   |   35004 | NO            | St. Clair County | MA            | Medicaid,Nursing | Lookup     | Simon Harold E MD | NO            | Yes,Yes,Yes,Yes               | Higher               | None           | Dental, Doctors              |

  @PRE @APIRanking @PDPFlowRanking @PDPFuture
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | AARP | OCT-15   |   10001 | NO            | New York | PDP           | No             |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | UHC  | DEC-01   |   10001 | NO            | New York | PDP           | No             |

  @PRE @APIRanking @PDPFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> - To validate PDP API ranking plans in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate elements in loading results page
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                |
      | AARP | OCT-15   |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                |
      | UHC  | OCT-15   |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO |

  @PRE @MAflowTieFuture @F432670
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <1stRecommendation> , <2ndRecommendation> - To validate MA flow functions in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate future vs current UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds | doctors | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | AARP | OCT-15   |   35004 | NO            | St. Clair County | MA            | nursing      | Lookup  | Simon Harold E MD | NO            | Yes,Yes,Yes,Yes               | Higher               |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds     | doctors | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | UHC  | OCT-15   |   35004 | NO            | St. Clair County | MA            | Medicaid,nursing | Lookup  | Simon Harold E MD | NO            | Yes,Yes,Yes,Yes               | Higher               |

  @PRE @APIRanking @MAPDFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate API Ranking for MA plans in PRE
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validate UI and API recommendation rankings in results page

    @regressionAARPAEP @regressionAARP @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | AARP | JAN-01   |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | Lookup  | David B. Auerbach | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

    @regressionUHCAEP @regressionUHC @nextYear
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | UHC  | JAN-01   |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | Lookup  | David B. Auerbach | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

  @PRE @planrecommendation @FilterByPlanType
  Scenario Outline: - To validate Filter By PlanType in PRE Result page
    Given the user is on flagsmith UHC medicare acquisition site PRE landing page
      | Site      | <site>     |
      | User Name | <Username> |
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
    Then user validates Sort By breadcrumb after Plan Year Toggle in PRE-Result page
      | Sort PlanYear | <PlanYear> |

    @regressionAARP 
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | sortInfo | PlanYear |
      | AARP | DEC-01   |   90002 | NO            | Los Angeles County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Vision | MAPD,PDP | current  |

    @regressionUHC
    Examples: 
      | site | Username | Zipcode | isMultiCounty | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | sortInfo | PlanYear |
      | UHC  | DEC-01   |   90002 | NO            | Los Angeles County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | Yes            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Vision | MAPD,PDP | current  |