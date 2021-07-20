@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify special needs page in plan Recommendation Engine

  @PRE @specialneedspage @elementValidation @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user validate elements in Special Needs page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | AARP |   90201 | NO            | MAPD          |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | UHC  |   90201 | NO            | MAPD          |

  @PRE @specialneedspage @specialneedspageoptionselection @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page positive scenarios in Plan Recommendation Engine
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

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             |
      | AARP |   90201 | NO            | [blank]      | MAPD          | Medicaid,chronic,nursing |
      | AARP |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing |
      | AARP |   45634 | NO            | [blank]      | MAPD          | chronic,nursing          |
      | AARP |   10001 | NO            | [blank]      | None          | nursing                  |
      | AARP |   12345 | NO            | [blank]      | MAPD          | None                     |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             |
      | UHC  |   90201 | NO            | [blank]      | MAPD          | Medicaid,chronic,nursing |
      | UHC  |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing |
      | UHC  |   45634 | NO            | [blank]      | MAPD          | chronic,nursing          |
      | UHC  |   10001 | NO            | [blank]      | None          | nursing                  |
      | UHC  |   12345 | NO            | [blank]      | MAPD          | None                     |

  @PRE @specialneedspage @specialneedspageerrorScenario @F372729
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate special needs page error scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user validating error scenario in Special Needs Page
      | SNP Options | <specialNeeds> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds                  |
      | AARP |   90201 | NO            | [blank]          | MAPD          | Medicaid,chronic,nursing,None |
      | AARP |   21212 | YES           | Baltimore County | None          | [blank]                       |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds                  |
      | UHC  |   90201 | NO            | [blank]          | MAPD          | Medicaid,chronic,nursing,None |
      | UHC  |   21212 | YES           | Baltimore County | None          | [blank]                       |
