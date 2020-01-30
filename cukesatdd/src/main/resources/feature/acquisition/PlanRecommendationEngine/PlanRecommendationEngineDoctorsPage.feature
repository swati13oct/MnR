@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify doctors page in plan Recommendation Engine

  @PRE @planrecommendation @doctorspage @doctorelementValidation @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> - To validate doctors page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user validate elements in doctors page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds                | travel                 |
      |   90201 | NO            |        | MAPD          | Medicaid,condition,facility | within,another,primary |

  @PRE @planrecommendation @doctorspage @doctorpageoptionselection @F372731 @regression
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page positive scenarios in Plan Recommendation Engine
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

    Examples: 
      | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds                | travel                 | doctors    | DoctorsName | isMultiDoctor |
      |   90201 | NO            |                  | MAPD          | Medicaid,condition,facility | within,another,primary | innetwork  |             |               |
      |   12345 | NO            |                  | MAPD          | None                        | None                   | outnetwork |             |               |
      |   36035 | YES           | Pike County      | MA            | Medicaid,condition          | within,another         | innetwork  |             |               |
      |   21212 | YES           | Baltimore County | PDP           | facility                    | primary                | outnetwork |             |               |

  @PRE @planrecommendation @doctorspage @doctorspageerrorScenario @F372731 @regression
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page error scenarios in Plan Recommendation Engine
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
    And user validating error scenario in doctors Page
      | Doctors | <doctors> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds                | travel | doctors |
      |   90201 | NO            |              | MAPD          | Medicaid                    | within |         |
      |   78006 | YES           | Bexar County | MA            | Medicaid,condition,facility | within |         |

  @PRE @planrecommendation @doctorspage @previousfunctionbeforeContinue @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Previous Button functionality before Click continue of doctors page in Plan Recommendation Engine
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
    And user select doctors and Click previous button from Doctors to check previous page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds                | travel                 | doctors    | DoctorsName | isMultiDoctor |
      |   78006 | YES           | Bexar County | MAPD          | Medicaid,condition,facility | within,another,primary | innetwork  |             |               |
      |   45634 | NO            |              | PDP           | None                        | None                   | outnetwork |             |               |

  @doctorspage @doctorspage @doctorspageConfirmationmodel @F372731 @regression
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate doctors page Confirmation Model scenarios in Plan Recommendation Engine
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

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds                | travel                 | doctors   | DoctorsName | isMultiDoctor |
      |   90201 | NO            |          | MA            | Medicaid,condition,facility | within,another,primary | mydoctors | John        | YES           |
      |   10002 | NO            | New York | MAPD          | facility                    | primary                | mydoctors | sue         | YES           |
#      |   35034 | YES           |Bibb County |MAPD         | Medicaid,condition,facility|within,another,primary|mydoctors  |John|NO|
