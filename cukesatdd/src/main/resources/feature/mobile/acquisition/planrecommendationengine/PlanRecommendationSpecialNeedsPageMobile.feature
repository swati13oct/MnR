@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engie flow - Verify special needs page in plan recommendation engine using mobile

  @PRE @planrecommandonationmobile @specialneedspagemobile @specialneedspageelements @F372729
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> - To validate special needs page elements in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user validate elements in Special Needs page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt |
      |   10001 | NO            | New York | MA            |

  @PRE @planrecommandonationmobile @specialneedspagemobile @specialneedspageoptionselection @F372729
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Status:<status> - To validate special needs page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds      |
      |   10001 | NO            | New York | MAPD          | Condition         |
      |   10002 | NO            | New York | NA            | Medicaid,Facility |
      |   10003 | NO            | New York | MA            | None              |

  @PRE @planrecommandonationmobile @specialneedspagemobile @snperrorvalidationmobile @F372729
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Status:<status> - To validate special needs page error validation using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    Then user selects SNP options in Special Needs Page mobile and validate errors
      | SNP Options | <SpecialNeeds> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds   |
      |   10001 | NO            | New York | MA            |                |
      |   10002 | NO            | New York | NA            | Condition,None |
