@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify doctors page in plan Recommendation Engine

  @PRE @planrecommendation @doctorspage @doctorelementValidation @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  - To validate doctors page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user validate elements in doctors page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             |
      | AARP |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds             |
      | UHC  |   90201 | NO            | [blank] | MAPD          | Medicaid,chronic,nursing |

  @PRE @planrecommendation @doctorspage @doctorpageoptionselection @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate Doctors page positive scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor |
      | AARP |   90201 | NO            | [blank]          | MAPD          | Medicaid,chronic,nursing | UHGNetwork      | [blank]     | [blank]       |
      | AARP |   12345 | NO            | [blank]          | MAPD          | None                     | AcceptsMedicare | [blank]     | [blank]       |
      | AARP |   36035 | YES           | Pike County      | None          | Medicaid,chronic         | UHGNetwork      | [blank]     | [blank]       |
      | AARP |   21212 | YES           | Baltimore County | None          | nursing                  | AcceptsMedicare | [blank]     | [blank]       |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county           | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor |
      | UHC  |   90201 | NO            | [blank]          | MAPD          | Medicaid,chronic,nursing | UHGNetwork      | [blank]     | [blank]       |
      | UHC  |   12345 | NO            | [blank]          | MAPD          | None                     | AcceptsMedicare | [blank]     | [blank]       |
      | UHC  |   36035 | YES           | Pike County      | None          | Medicaid,chronic         | UHGNetwork      | [blank]     | [blank]       |
      | UHC  |   21212 | YES           | Baltimore County | None          | nursing                  | AcceptsMedicare | [blank]     | [blank]       |

  @PRE @planrecommendation @doctorspage @doctorspageerrorScenario @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate Doctors page error scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user validating error scenario in doctors Page
      | Doctors | <doctors> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors |
      | AARP |   90201 | NO            | [blank]      | MAPD          | Medicaid                 | [blank] |
      | AARP |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing | [blank] |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors |
      | UHC  |   90201 | NO            | [blank]      | MAPD          | Medicaid                 | [blank] |
      | UHC  |   78006 | YES           | Bexar County | None          | Medicaid,chronic,nursing | [blank] |

  @PRE @planrecommendation @doctorspage @previousfunctionbeforeContinue @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate Previous Button functionality before Click continue of doctors page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user select doctors and Click previous button from Doctors to check previous page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor |
      | AARP |   78006 | YES           | Bexar County | MAPD          | Medicaid,chronic,nursing | UHGNetwork      | [blank]     | [blank]       |
      | AARP |   45634 | NO            | [blank]      | None          | None                     | AcceptsMedicare | [blank]     | [blank]       |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds             | doctors         | DoctorsName | isMultiDoctor |
      | UHC  |   78006 | YES           | Bexar County | MAPD          | Medicaid,chronic,nursing | UHGNetwork      | [blank]     | [blank]       |
      | UHC  |   45634 | NO            | [blank]      | None          | None                     | AcceptsMedicare | [blank]     | [blank]       |

  @doctorspage @doctorspage @doctorspageConfirmationmodel @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate doctors page Confirmation Model scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds             | doctors | DoctorsName  | isMultiDoctor |
      | AARP |   90201 | NO            | [blank]  | None          | Medicaid,chronic,nursing | Lookup  | Lillian, MD  | YES           |
      | AARP |   10002 | NO            | New York | MAPD          | nursing                  | Lookup  | Teresa T, MD | YES           |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds             | doctors | DoctorsName  | isMultiDoctor |
      | UHC  |   90201 | NO            | [blank]  | None          | Medicaid,chronic,nursing | Lookup  | Lillian, MD  | YES           |
      | UHC  |   10002 | NO            | New York | MAPD          | nursing                  | Lookup  | Teresa T, MD | YES           |

  @PRE @planrecommandonation @doctorspage @doctorspagepagecancel @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate Doctors page modal cancel functions in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user selects Doctors in Doctors page and cancels the selection
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | DoctorsName | isMultiDoctor |
      | AARP |   10001 | NO            | New York    | None          | None         | [blank]     | [blank]       |
      | AARP |   35035 | YES           | Bibb County | None          | None         | robert      | NO            |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | DoctorsName | isMultiDoctor |
      | UHC  |   10001 | NO            | New York    | None          | None         | [blank]     | [blank]       |
      | UHC  |   35035 | YES           | Bibb County | None          | None         | robert      | NO            |

  @PRE @planrecommandonation @doctorspage @editprovider @F427538
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctor> - To validate Doctors page fucntions with lookup in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    Then user edits Doctors in Doctors page
      | Doctors Search Text1 | <DoctorsName1>   |
      | Multi Doctor1        | <isMultiDoctor1> |
      | Doctors Search Text2 | <DoctorsName2>   |
      | Multi Doctor2        | <isMultiDoctor2> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | DoctorsName1   | isMultiDoctor1 | DoctorsName2       | isMultiDoctor2 |
      | AARP |   10001 | NO            | New York | MAPD          | None         | Ricky K Hsu MD | NO             | Robert W Fields MD | NO             |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | DoctorsName1   | isMultiDoctor1 | DoctorsName2       | isMultiDoctor2 |
      | UHC  |   10001 | NO            | New York | MAPD          | None         | Ricky K Hsu MD | NO             | Robert W Fields MD | NO             |
