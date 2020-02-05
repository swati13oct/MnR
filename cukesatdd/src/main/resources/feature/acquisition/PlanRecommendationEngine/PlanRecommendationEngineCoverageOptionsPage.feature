@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify coverage options page in plan Recommendation Engine

  @PRE @planrecommendation @coveragepage @elementValidation @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> - To validate coverage options page Elements using Single County in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user validate elements in coverage options page

    Examples: 
      | Zipcode | isMultiCounty |
      |   90201 | NO            |

  @PRE @planrecommendation @coveragepage @coveragepageoptionselection @regression @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Selecting coverage options using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | isCoverageOpt |
      |   90201 | NO            | MAPD          |
      |   10001 | NO            | MA            |
      |   12345 | NO            | PDP           |
      |   90210 | NO            | NA            |

  @PRE @planrecommendation @coveragepage @coveragepageerrorScenario @regression @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate error Scenario of coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user not selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | isCoverageOpt |
      |   45634 | NO            |               |

  @PRE @planrecommendation @coveragepage @previousfunctionafterContinue @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Previous Button functionality after Click continue of coverage options page using multi County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user select planType and continous the page back to previous page
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt |
      |   78006 | YES           | Bexar County | MAPD          |

  @PRE @planrecommendation @coveragepage @previousfunctionbeforeContinue @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Previous Button functionality before Click continue of coverage previous options page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user select planType and Click previous button to check previous page
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt |
      |   78006 | YES           | Bexar County | MAPD          |
      |   45634 | NO            |              | PDP           |
