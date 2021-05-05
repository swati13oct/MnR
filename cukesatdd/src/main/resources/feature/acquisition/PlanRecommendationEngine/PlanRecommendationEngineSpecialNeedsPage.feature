@planRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify special needs page in plan Recommendation Engine

  @PRE @planrecommendation @specialneedspage @elementValidation @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user validate elements in Special Needs page

    Examples: 
      | Zipcode | isMultiCounty | isCoverageOpt |
      |   90201 | NO            | MAPD          |

  @PRE @planrecommendation @specialneedspage @specialneedspageoptionselection @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page positive scenarios in Plan Recommendation Engine
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

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             |
      |   90201 | NO            | [blank]      | MAPD          | Medicaid,chronic,nursing |
      |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing |
      |   45634 | NO            | [blank]      | MAPD          | chronic,nursing          |
      |   10001 | NO            | [blank]      | None          | nursing                  |
      |   12345 | NO            | [blank]      | MAPD          | None                     |

  @PRE @planrecommendation @specialneedspage @specialneedspageerrorScenario @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page error scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user validating error scenario in Special Needs Page
      | SNP Options | <specialNeeds> |

    Examples: 
      | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds                  |
      |   90201 | NO            | [blank]          | MAPD          | Medicaid,chronic,nursing,None |
      |   21212 | YES           | Baltimore County | None          | [blank]                       |
