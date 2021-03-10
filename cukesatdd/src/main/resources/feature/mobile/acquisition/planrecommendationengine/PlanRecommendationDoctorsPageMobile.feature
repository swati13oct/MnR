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
      |   10001 | NO            | New York | None          | Chronic      | Regular      |

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
      |   10001 | NO            | New York | MAPD          | None         | WithinUS     | UHCNetwork       |             |               |
      |   10003 | NO            | New York | None          | None         | Regular      | AcceptsMedicare  |             |               |

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
      |   10001 | NO            | New York | MAPD          | None         | OutsideUS    | lookup           | sue         | NO            |
      |   10002 | NO            | New York | MAPD          | None         | WithinUS     | lookup           | sue         | YES           |

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
    Then user selects Doctors in Doctors page and validate errors mobile
      | Doctors Selection   | <DoctorsSelection> |
      | Doctors Search Text | <DoctorsName>      |
      | Multi Doctor        | <isMultiDoctor>    |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsSelection | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York | None          | None         | Regular      |                  |             |               |

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
    Then user selects Doctors in Doctors page and cancels the selection mobile
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | County      | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York    | None          | None         | OutsideUS    |             |               |
      |   35034 | YES           | Bibb County | None          | None         | Regular      | patil       | NO            |

  @PRE @planrecommandonationmobile @doctorspagemobile @editprovider @F427538
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
    Then user edits Doctors in Doctors page mobile
      | Doctors Search Text1 | <DoctorsName1>   |
      | Multi Doctor1        | <isMultiDoctor1> |
      | Doctors Search Text2 | <DoctorsName2>   |
      | Multi Doctor2        | <isMultiDoctor2> |

    Examples: 
      | Zipcode | isMultiCounty | County   | isCoverageOpt | SpecialNeeds | TravelOption | DoctorsName1 | isMultiDoctor1 | DoctorsName2 | isMultiDoctor2 |
      |   10001 | NO            | New York | MAPD          | None         | WithinUS     | sue          | NO             | robert       | NO             |
