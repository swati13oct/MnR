@PlanRecommandonationEngine
Feature: Plan Recommendation Engie flow - Verify Doctors page functionalities in plan recommendation engine using mobile

  @PRE @planrecommandonation @doctorspagemobile @doctorspageelementsmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel:<TravelOption> - To validate Doctors options elements in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user validate elements in Doctors page mobile

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption |
      |   10001 | NO              | New York | MA            | Condition    | Travel       |

  @PRE @planrecommandonation @doctorspagemobile @doctorspagepageoptionselectionmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> - To validate Doctors page fucntions in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile
      | Doctors Selection | <DoctorsSelection> |

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection |
      #|   10001 | NO              | New York | MA            | None         | Travel       | want to use      |
      |   10001 | NO              | New York | MA            | None         | Travel       | lookup           |

  @PRE @planrecommandonation @doctorspagemobile @doctorspagepageerrorvalidationmobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> - To validate Doctors page error functions in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile and validate errors
      | Doctors Selection | <DoctorsSelection> |

    Examples: 
      | Zipcode | isMultutiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection |
      |   10001 | NO              | New York | MA            | None         | Travel       |                  |
