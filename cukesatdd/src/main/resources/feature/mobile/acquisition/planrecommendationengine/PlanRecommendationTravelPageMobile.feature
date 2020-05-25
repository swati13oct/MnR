@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engie flow - Verify Care Away from Home - Travel page in plan recommendation engine using mobile

  @PRE @planrecommandonationmobile @travelpagemobile @travelpageelementsmobile @F372739
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> - To validate Travel options elements in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user validate elements in Travel page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds |
      |   10001 | NO            | New York | MA            | Chronic      |

  @PRE @planrecommandonationmobile @travelpagemobile @travelpagepageoptionselectionmobile @F372739
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel<TravelOption> - To validate Travel page fucntions in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption               |
      |   10001 | NO            | New York | MA            | Chronic      | WithinUS                   |
      |   10002 | NO            | New York | MAPD          | Medicaid     | Regular                    |
      |   10003 | NO            | New York | None          | Nursing      | OutsideUS,WithinUS,Regular |

  @PRE @planrecommandonationmobile @travelpagemobile @travelpagepageerrorvalidationmobile @F372739
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel<TravelOption> - To validate Travel page error fucntions in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <County>        |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user selects Travel options in Travel Page mobile and validate errors
      | Travel Options | <TravelOption> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption |
      |   10001 | NO            | New York | MA            | Chronic      | Regular,None |
      |   10002 | NO            | New York | MAPD          | Chronic      |              |
