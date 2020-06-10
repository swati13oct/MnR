@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify doctors page in plan Recommendation Engine

  @PRE @planrecommendation @doctorspage @doctorelementValidation @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> - To validate doctors page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user validate elements in doctors page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds             | travel                     |
      |   90201 | NO            |        | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular |

  @PRE @planrecommendation @doctorspage @doctorpageoptionselection @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page positive scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds             | travel                     | doctors         | DoctorsName | isMultiDoctor |
      |   90201 | NO            |                  | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork      |             |               |
      |   12345 | NO            |                  | MAPD          | None                     | None                       | AcceptsMedicare |             |               |
      |   36035 | YES           | Pike County      | None          | Medicaid,chronic         | withinUS,outsideUS         | UHGNetwork      |             |               |
      |   21212 | YES           | Baltimore County | None          | nursing                  | regular                    | AcceptsMedicare |             |               |

  @PRE @planrecommendation @doctorspage @doctorspageerrorScenario @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page error scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user validating error scenario in doctors Page
      | Doctors | <doctors> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | travel   | doctors |
      |   90201 | NO            |              | MAPD          | Medicaid                 | withinUS |         |
      |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing | withinUS |         |

  @PRE @planrecommendation @doctorspage @previousfunctionbeforeContinue @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Previous Button functionality before Click continue of doctors page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user select doctors and Click previous button from Doctors to check previous page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | travel                     | doctors         | DoctorsName | isMultiDoctor |
      |   78006 | YES           | Bexar County | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | UHGNetwork      |             |               |
      |   45634 | NO            |              | None          | None                     | None                       | AcceptsMedicare |             |               |

  @doctorspage @doctorspage @doctorspageConfirmationmodel @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate doctors page Confirmation Model scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds             | travel                     | doctors | DoctorsName | isMultiDoctor |
      |   90201 | NO            |             | None          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | Lookup  | John        | YES           |
      |   10002 | NO            | New York    | MAPD          | nursing                  | regular                    | Lookup  | John        | YES           |
#     |   35034 | YES           | Bibb County | MAPD          | Medicaid,chronic,nursing | withinUS,outsideUS,regular | Lookup  | John        | NO            |

  @PRE @planrecommandonation @doctorspage @doctorspagepagecancel @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page modal cancel functions in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user selects Doctors in Doctors page and cancels the selection
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | travel   | DoctorsName | isMultiDoctor |
      |   10001 | NO            | New York    | None          | None         | withinUS |             |               |
      |   35034 | YES           | Bibb County | None          | None         | withinUS | robert      | NO            |

  @PRE @planrecommandonation @doctorspage @editprovider @F427538
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate Doctors page fucntions with lookup in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    Then user edits Doctors in Doctors page
      | Doctors Search Text1 | <DoctorsName1>   |
      | Multi Doctor1        | <isMultiDoctor1> |
      | Doctors Search Text2 | <DoctorsName2>   |
      | Multi Doctor2        | <isMultiDoctor2> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel   | DoctorsName1 | isMultiDoctor1 | DoctorsName2 | isMultiDoctor2 |
      |   10001 | NO            | New York | MAPD          | None         | withinUS | sue          | NO             | robert       | NO             |
