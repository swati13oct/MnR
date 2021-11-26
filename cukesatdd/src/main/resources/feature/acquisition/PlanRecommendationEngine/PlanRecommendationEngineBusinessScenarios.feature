@PlanRecommendationEngine
Feature: 1.18.2 Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking with API results

  @PRE @APIRanking @MAPDFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate API Ranking for MA plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @sanity
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | AARP |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | Lookup  | David B. Auerbach | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      |
      | UHC  |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | Lookup  | David B. Auerbach | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Doctors, Vision |

  @PRE @APIRanking @MAPDFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption> - To validate SNP API ranking plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | doctors         | DoctorsName              | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     |
      | AARP |   33143 | No            | Miami-Dade | MAPD          | None         | Lookup          | Perez, Martha Regina, MD | [blank]       | No             | Yes,No,No,No                  | Higher               | None           | Travel, Vision |
      | AARP |   55419 | No            | Hennepin   | MAPD          | None         | AcceptsMedicare | [blank]                  | [blank]       | No             | Yes,No,No,No                  | Higher               | 1st            | Dental, None   |

    @regressionUHC @sanity
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      | UHC  |   15537 | NO            | Bedford | MAPD          | None         | UHGNetwork | [blank]     | [blank]       | NO             | No,No,No,No                   | Lower                | 2nd            | Doctors, Health Care Premium |

  @PRE @APIRanking @MAFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MA flow functions for MA and MS plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @prodRegression
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      | AARP |   15537 | NO            | Bedford | MA            | None         | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | None           | Doctors, Health Care Premium |

    #| AARP |   30012 | YES           | Walton County | MA            | Medicaid,Nursing | Lookup     | Emily Adams, NP | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Vision, Hearing              |
    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county        | isCoverageOpt | specialNeeds     | doctors    | DoctorsName     | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      | UHC  |   15537 | NO            | Bedford       | MA            | None             | UHGNetwork | [blank]         | [blank]       | Yes,No,No,No                  | Lower                | None           | Doctors, Health Care Premium |
      | UHC  |   30012 | YES           | Walton County | MA            | Medicaid,Nursing | Lookup     | Emily Adams, NP | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Vision, Hearing              |

  @PRE @APIRanking @PDPFlowRanking
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> - To validate PDP ranking plans in PRE
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
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | AARP |   10001 | NO            | New York | PDP           | No             |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      | UHC  |   10001 | NO            | New York | PDP           | No             |

  @PRE @APIRanking @PDPFlowRankingNew
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  - To validate PDP API ranking plans in PRE
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
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                              |
      | AARP |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                              |
      | UHC  |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO |
