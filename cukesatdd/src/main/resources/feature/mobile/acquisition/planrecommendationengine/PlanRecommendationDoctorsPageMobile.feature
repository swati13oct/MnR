@PlanRecommandonationEngineMobile
Feature: Plan Recommendation Engie flow - Verify Doctors page functionalities in plan recommendation engine using mobile

  @PRE @planrecommandonationmobile @doctorspagemobile @doctorspageelementsmobile @F372731
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel:<TravelOption> - To validate Doctors options elements in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user validate elements in Doctors page mobile

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption |
      |   10001 | NO            | New York | NA            | Condition    | Travel       |

  @PRE @planrecommandonationmobile @doctorspagemobile @doctorspagepageoptionselectionmobile @F372731
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> - To validate Doctors page fucntions in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York | MAPD          | None         | Travel       | willing to use   |             |               |
      |   10003 | NO            | New York | NA            | None         | Travel       | want to use      |             |               |

  @PRE @planrecommandonationmobile @doctorspagemobile @doctorspagepageoptionselectionmobile @doctorslookupmobile @F372731
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> -Doctors: <DoctorsSelection> -DoctorsName: <DoctorsName> -MultipleDoctors: <isMultiDoctor> - To validate Doctors page fucntions with lookup in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York | MAPD          | None         | Travel       | lookup           | sue         | NO            |
      |   10002 | NO            | New York | MAPD          | None         | Travel       | lookup           | sue         | YES           |

  @PRE @planrecommandonationmobile @doctorspagemobile @doctorspagepageerrorvalidationmobile @F372731
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> - To validate Doctors page error functions in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile and validate errors
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York | NA            | None         | Travel       |                  |             |               |

  @PRE @planrecommandonationmobile @doctorspagemobile @doctorspagepagecancelmobile @F372731
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <SpecialNeeds> -Travel: <TravelOption> - To validate Doctors page modal cancel functions in Plan Recommendation Engine Mobile
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
    And user selects Travel options in Travel Page mobile
      | Travel Options | <TravelOption> |
    Then user selects Doctors in Doctors page mobile and cancels the selection
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York    | NA            | None         | Travel       |             |               |
      |   35034 | YES           | Bibb County | NA            | None         | Travel       | robert      | NO            |
