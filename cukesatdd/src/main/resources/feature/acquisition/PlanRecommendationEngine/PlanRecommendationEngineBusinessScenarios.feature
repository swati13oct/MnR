@PlanRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine Ranking - Verify PRE flows functionalities with recommendation and Ranking with API results

  @PRE @APIRanking @MAPDFlowRanking @SanityTest @PRERegression3
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate API Ranking for MA plans in PRE
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
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    #    And user selects pharmacy option in pharmacy page
    #      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | travel   | doctors | DoctorsName       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     |
      #      |   90210 | NO            | Los Angeles | MAPD          | Nursing         | withinUS  | Lookup  | George Mordechai Delshad | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Online         | Yes,Yes,Yes,Yes               | Lower                |
      #      |   10001 | NO            | New York | MAPD          | None            | OutsideUS | Lookup  | Venegas-Pizarro, Marcelo F | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Retail         | No,Yes,Yes,No                 | Lower                |
      #      |   10001 | NO            | New York | MAPD          | None            | OutsideUS | Lookup  | Venegas-Pizarro, Marcelo F | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | Retail         | No,Yes,Yes,No                 | Higher               |
      |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | withinUS | Lookup  | David B. Auerbach | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | Online         | No,No,Yes,No                  | Lower                | both           | Travel, Vision |

  @PRE @planrecommandonation @APIRanking @MAPDFlowRanking @SanityTest @PRERegression3 @SanityPRE
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption> - To validate SNP API ranking plans in PRE
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @SanityPRE_01 @prod_regression
    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors         | DoctorsName              | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     |
      |   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup          | Perez, Martha Regina, MD | [blank]       | No             | Yes,No,No,No                  | Higher               | None           | Travel, Vision |
      |   55419 | No            | Hennepin   | MAPD          | None         | None   | AcceptsMedicare | [blank]                  | [blank]       | No             | Yes,No,No,No                  | Higher               | 1st            | Dental, None   |

    @SanityPRE_03 @prod_regression
    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      |   15537 | NO            | Bedford | MAPD          | None         | None   | UHGNetwork | [blank]     | [blank]       | NO             | No,No,No,No                   | Lower                | 2nd            | Doctors, Health Care Premium |

  @PRE @planrecommendation @APIRanking @MAFlowRanking @SanityTest @PRERegression6 @SanityPRE
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MA flow functions for MA and MS plans in PRE
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @SanityPRE_02 @prod_regression
    Examples: 
      | Zipcode | isMultiCounty | county        | isCoverageOpt | specialNeeds     | travel   | doctors    | DoctorsName     | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   |
      |   15537 | NO            | Bedford       | MA            | None             | withinUS | UHGNetwork |                 |               | Yes,No,No,No                  | Lower                | None           | Doctors, Health Care Premium |
      |   30012 | YES           | Walton County | MA            | Medicaid,Nursing | withinUS | Lookup     | Emily Adams, NP | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Vision, Hearing              |

  #      |   94203 | NO            | Sacramento  | MA            | None             | withinUS | AcceptsMedicare |             |               | Yes,Yes,Yes,Yes               | Lower                | -->Tie Scenario
  #      |   94203 | NO            | Sacramento  | MA            | None             | withinUS | AcceptsMedicare |             |               | Yes,Yes,Yes,Yes               | Higher               |--> MS Has #1Recommendation
  #      |   90210 | NO            | Los Angeles   | MA            | Medicaid,Nursing | withinUS | UHGNetwork |             |               | Yes,Yes,Yes,Yes               | Lower                |-->SNP Plans are having 0 plans
  @PRE @planrecommendation @APIRanking @PDPFlowRanking @SanityTest @PRERegression6
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <primaryRecommendation> , <RankingplansOrder> - To validate PDP ranking plans in PRE
    Given the user is on UHC medicare acquisition site landing page
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

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      |   10001 | NO            | New York | PDP           | No             |

  @PRE @planrecommendation @APIRanking @PDPFlowRanking @SanityTest @PRERegression6 @SanityPRE
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption> - To validate PDP API ranking plans in PRE
    Given the user is on UHC medicare acquisition site landing page
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
    #    And user selects pharmacy option in pharmacy page
    #      | Pharmacy Type | <pharmacyoption> |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page

    @SanityPRE_03 @prod_regression
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                              | pharmacyoption |
      |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Retail         |
