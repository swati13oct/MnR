@PlanRecommendationEngine @PRERegression
Feature: 1.18.1 Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking

  @PRE @Ranking @MAPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Ranking for MA plans in PRE
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

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors    | DoctorsName         | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         |
      | AARP |   12345 | NO            | Schenectady | MAPD          | None         | UHGNetwork | [blank]             | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,No,No                   | Lower                | both           | Doctors, Drug Cost |
      | AARP |   12345 | NO            | Schenectady | MAPD          | None         | Lookup     | Sherrie L Murray NP | NO            | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Higher               | None           | Doctors, Drug Cost |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors    | DoctorsName         | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         |
      | UHC  |   12345 | NO            | Schenectady | MAPD          | None         | UHGNetwork | [blank]             | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | No,No,No,No                   | Lower                | both           | Doctors, Drug Cost |
      | UHC  |   12345 | NO            | Schenectady | MAPD          | None         | Lookup     | Sherrie L Murray NP | NO            | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Higher               | None           | Doctors, Drug Cost |

  @PRE @Ranking @MAPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Ranking for MA plans in PRE
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
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                |
      | AARP |   12345 | NO            | Schenectady | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | NO             | No,No,Yes,Yes                 | Lower                | 1st            | Health Care Premium, None |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                |
      | UHC  |   12345 | NO            | Schenectady | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | NO             | No,No,Yes,Yes                 | Lower                | 1st            | Health Care Premium, None |

  @PRE @Ranking @PDPPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
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
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @null
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection |
      | AARP |   35035 | Yes           | Bibb County | PDP           | Yes            |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection |
      | UHC  |   35035 | Yes           | Bibb County | PDP           | Yes            |

  @PRE @Ranking @PDPPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
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
      | site | Zipcode | isMultiCounty | county               | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                  |
      | AARP |   35035 | Yes           | Bibb County          | PDP           | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,Month,1,YES,NO                                                                  |
      | AARP |   20001 | No            | District of Columbia | PDP           | Yes            | Atorvastatin calcium,NO,atorvastatin calcium TAB 10MG,,,Week,1,NO,NO:Aptiom,NO,Aptiom TAB 200MG,,,Day,1,NO,NO |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county               | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                  |
      | UHC  |   35035 | Yes           | Bibb County          | PDP           | Yes            | Lipitor,NO,Lipitor TAB 10MG,,,Month,1,YES,NO                                                                  |
      | AARP |   20001 | No            | District of Columbia | PDP           | Yes            | Atorvastatin calcium,NO,atorvastatin calcium TAB 10MG,,,Week,1,NO,NO:Aptiom,NO,Aptiom TAB 200MG,,,Day,1,NO,NO |

  @PRE @Ranking @SNPPlansRanking @F358846
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption>, <primaryRecommendation> , <RankingplansOrder> - To validate SNP ranking plans in PRE
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
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | AARP |   32111 | No            | Marion | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |
      | AARP |   32111 | No            | Marion | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |
      | AARP |   32111 | No            | Marion | MAPD          | Nursing                  | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | UHC  |   32111 | No            | Marion | MAPD          | Medicaid,Chronic,Nursing | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |
      | UHC  |   32111 | No            | Marion | MAPD          | Chronic,Nursing          | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |
      | UHC  |   32111 | No            | Marion | MAPD          | Nursing                  | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,Yes                  | Higher               |
