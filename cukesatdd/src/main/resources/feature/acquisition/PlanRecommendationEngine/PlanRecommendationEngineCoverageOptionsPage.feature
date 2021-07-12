@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify coverage options page in plan Recommendation Engine

  @PRE @coveragepage @elementValidation @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> - To validate coverage options page Elements using Single County in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user validate elements in coverage options page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty |
      | AARP |   90201 | NO            |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty |
      | UHC  |   90201 | NO            |

  @PRE @coveragepage @coveragepageoptionselection
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Selecting coverage options using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | AARP |   90201 | NO            | MAPD          |
      | AARP |   10001 | NO            | MA            |
      | AARP |   12345 | NO            | PDP           |
      | AARP |   90210 | NO            | None          |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | UHC  |   90201 | NO            | MAPD          |
      | UHC  |   10001 | NO            | MA            |
      | UHC  |   12345 | NO            | PDP           |
      | UHC  |   90210 | NO            | None          |

  @PRE @coveragepage @coveragepageerrorScenario @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate error Scenario of coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user not selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | AARP |   45634 | NO            | [blank]       |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | isCoverageOpt |
      | UHC  |   45634 | NO            | [blank]       |

  @PRE @coveragepage @previousfunctionafterContinue @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Previous Button functionality after Click continue of coverage options page using multi County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user select planType and continous the page back to previous page
      | Plan Type | <isCoverageOpt> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt |
      | AARP |   78006 | YES           | Bexar County | MAPD          |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt |
      | UHC  |   78006 | YES           | Bexar County | MAPD          |

  @PRE @coveragepage @previousfunctionbeforeContinue @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate Previous Button functionality before Click continue of coverage previous options page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user select planType and Click previous button to check previous page
      | Plan Type | <isCoverageOpt> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt |
      | AARP |   78006 | YES           | Bexar County | MAPD          |
      | AARP |   45634 | NO            | [blank]      | PDP           |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt |
      | UHC  |   78006 | YES           | Bexar County | MAPD          |
      | UHC  |   45634 | NO            | [blank]      | PDP           |
