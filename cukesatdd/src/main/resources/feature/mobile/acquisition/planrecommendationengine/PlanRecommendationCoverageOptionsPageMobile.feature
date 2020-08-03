@PlanRecommandonationEngineMobile
Feature: Plan Selector Tool flow - Verify coverage options page in plan recommendation engine using mobile

  @PRE @planrecommandonationmobile @coveragepagemobile @coveragepageelements @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> - To validate coverage options page elements in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    Then user validate elements in coverage options page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   |
      |   10001 | NO            | New York |

  @PRE @planrecommandonationmobile @coveragepagemobile @coveragepageoptionselection @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    Then user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt |
      |   90201 | NO            | Los Angeles | MAPD          |
      |   10001 | NO            | New York    | MA            |
      |   12345 | NO            | Schenectady | PDP           |
      |   20007 | NO            | Columbia    | None          |

  @PRE @planrecommandonationmobile @coveragepagemobile @coveragepageprevious @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page Previous button functionality Multi County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    Then user select planType and continous the page back to previous page mobile
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | County       | isCoverageOpt |
      |   78006 | YES           | Bexar County | MAPD          |

  @PRE @planrecommandonationmobile @coveragepagemobile @coverageoptionnegative @F372736
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page with empty option using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    Then user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |

    Examples: 
      | Zipcode | isMultiCounty | County | isCoverageOpt |
      |   45634 | NO            | Vinton |               |
