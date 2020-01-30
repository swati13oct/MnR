@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify travel page in plan Recommendation Engine

  @PRE @planrecommendation @travelpage @elementValidation @F372739
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> - To validate travel page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user validate elements in Travel page

    Examples: 
      | Zipcode | isMultiCounty | isCoverageOpt | specialNeeds                |
      |   90201 | NO            | MAPD          | Medicaid,condition,facility |

  @PRE @planrecommendation @travelpage @travelpageoptionselection @F372739 @regression
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> - To validate travel page positive scenarios in Plan Recommendation Engine
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

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds                | travel                 |
      |   90201 | NO            |              | MAPD          | Medicaid,condition,facility | within,another,primary |
      |   78006 | YES           | Bexar County | MA            | Medicaid,condition,facility | within,another,primary |
      |   45634 | NO            |              | PDP           | condition,facility          | within,another         |
      |   10001 | NO            |              | NA            | facility                    | within                 |
      |   12345 | NO            |              | MAPD          | None                        | None                   |

  @PRE @planrecommendation @travelpage @travelpageerrorScenario @F372739 @regression
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> - To validate travel page error scenarios in Plan Recommendation Engine
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
    And user validating error scenario in Care Away From Home Page
      | Travel Options | <travel> |

    Examples: 
      | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds                | travel              |
      |   90201 | NO            |                  | MAPD          | Medicaid,condition,facility | within,another,None |
      |   21212 | YES           | Baltimore County | MA            | facility                    |                     |
