@PlanRecommandonationEngine
Feature: Plan Recommendation Engie flow - Verify special needs page in plan recommendation engine using mobile

  @PRE @planrecommandonation @specialneedspagemobile @specialneedspageelements
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <specialNeeds> - To validate special needs page elements in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user validate elements in Special Needs page mobile

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt |
      |   10001 | NO              | New York | MA            |

  @PRE @planrecommandonation @specialneedspagemobile @specialneedspageoptionselection
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <specialNeeds> -Status:<status> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds |
      |   10001 | NO              | New York | MA            | Condition    |
