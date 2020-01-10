@PlanRecommandonationEngine
Feature: Plan Recommendation Engie flow - Verify Care Away from Home - Travel page in plan recommendation engine using mobile

  @PRE @planrecommandonation @travelpagemobile @travelpageelementsmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> - To validate Travel options elements in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user validate elements in Travel page mobile

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds |
      |   10001 | NO              | New York | MA            | Condition    |

  @PRE @planrecommandonation @travelpagemobile @travelpagepageoptionselectionmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel<TravelOption> - To validate Travel page fucntions in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption                  |
      |   10001 | NO              | New York | MA            | Condition    | Travel                        |
      |   10001 | NO              | New York | MA            | Condition    | Care Away                     |
      |   10001 | NO              | New York | MA            | Condition    | Another Part,Travel,Care Away |

  @PRE @planrecommandonation @travelpagemobile @travelpagepageerrorvalidationmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel<TravelOption> - To validate Travel page fucntions in Plan Recommendation Engine Mobile
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |
    And user selects plan type in coverage options page mobile
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page mobile
      | SNP Options | <SpecialNeeds> |
    Then user selects Travel options in Travel Page mobile and validate errors
      | Travel Options | <TravelOption> |

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption   |
      |   10001 | NO              | New York | MA            | Condition    | Care Away,None |
      |   10001 | NO              | New York | MA            | Condition    |                |
