@PlanRecommendationEngine @SaveResultsPREWidget
Feature: Plan Recommendation Engine flow - Verify Save Results functionality and Verify PRE widget in Visitor page

  @PRE @SaveResultWithoutMS @SaveResult @F543314
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt>  , <Drug Selection>, <UserType>  - To Visitor Profile without MS Plans
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user save recommendation results and validate in VP
    Then user navigate to visitor profile without saving MS plan
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |

    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName          | password |
      | AARP |   10003 | NO            | New York | PDP           | No             | Guest         | [blank]           | [blank]  |
      | AARP |   10003 | NO            | New York | PDP           | No             | Authenticated | DigitalDestroyer1 | DDpwd123 |

    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName          | password |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Guest         | [blank]           | [blank]  |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Authenticated | DigitalDestroyer1 | DDpwd123 |

  @PRE @SaveResultWithMS
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt>  , <Drug Selection> , <UserType>  - To Visitor Profile with MS Plans
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user navigate to visitor profile with saving MS plan
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |

    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName | password |
      | AARP |   10003 | NO            | New York | PDP           | No             | Guest         | [blank]  | [blank]  |
      | AARP |   10003 | NO            | New York | PDP           | No             | Authenticated | DDstage  | Test1234 |

    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName | password |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Guest         | [blank]  | [blank]  |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Authenticated | DDstage  | Test1234 |

  @PRE @MAFlow
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <1stRecommendation> , <2ndRecommendation> , <UserType>  - To Validate PRE Widget Reommendations in visitor profile page
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user save recommendation results and validate in VP
    Then user navigate to visitor profile and open PRE Widget
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |
    Then user validate recommendation section in PRE Widget on VP

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | AARP |   00610 | NO            | Anasco  | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Dental, Doctors              | MS                | [blank]           | Authenticated | DigitalDestroyer1 | DDpwd123 |
      | AARP |   00501 | NO            | Suffolk | MA            | chronic      | UHGNetwork      | [blank]     | [blank]       | No,No,No,No                   | Higher               | 1st            | Doctors, Health Care Premium | MA                | MS                | Authenticated | DigitalDestroyer1 | DDpwd123 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | UHC  |   00610 | NO            | Anasco  | MA            | None         | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Travel, Doctors              | MS                | [blank]           | Authenticated | DigitalDestroyer1 | DDpwd123 |
      | UHC  |   00501 | NO            | Suffolk | MA            | chronic      | UHGNetwork      | [blank]     | [blank]       | No,No,No,No                   | Higher               | 1st            | Doctors, Health Care Premium | MA                | MS                | Authenticated | DigitalDestroyer1 | DDpwd123 |

  @PRE @MAPDFlowScenario6 @F614720
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <doctors> , <DoctorsName> , <isMultiDoctor> ,<Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <UserType>  - To Validate Scenario6 PRE Widget Reommendations in visitor profile page
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user save recommendation results and validate in VP
    Then user navigate to visitor profile and open PRE Widget
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |
    Then user validate recommendation section in PRE Widget on VP

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | AARP |   10001 | NO            | New York | None          | Medicaid     | Lookup  | sue         | NO            | No             | Yes,No,No,Yes                 | Lower                | SNP               | MA                | Authenticated | DigitalDestroyer1 | DDpwd123 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | UHC  |   10001 | NO            | New York | None          | Medicaid     | Lookup  | sue         | NO            | No             | Yes,No,No,Yes                 | Lower                | SNP               | MA                | Authenticated | DigitalDestroyer1 | DDpwd123 |

  @PRE @PDPFlow @F607619
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption>, <UserType>  - To Validate Scenario2 PRE Widget Reommendations in visitor profile page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    When user Sigin visitor profile from PRE
      | User Name | <userName> |
      | Password  | <password> |
    When user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validate elements in loading results page
    Then user save recommendation results and validate in VP
    Then user navigate to visitor profile and open PRE Widget
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |
    Then user validate recommendation section in PRE Widget on VP
    Then user validate a "View ranked list of plans" buttons from PRE

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | AARP |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | PDP               | MA                | Authenticated | DigitalDestroyer1 | DDpwd123 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | 1stRecommendation | 2ndRecommendation | UserType      | userName          | password |
      | UHC  |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | PDP               | MA                | Authenticated | DigitalDestroyer1 | DDpwd123 |

  @PRE @ViewRecommendationEditResponseBtn
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt>  , <Drug Selection> , <UserType>  - To Validate Scenario4 PRE Widget Reommendations in visitor profile page
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    And user validate buttons in SaveResult Model and PRE Widget in VP
      | User Type | <UserType>      |
      | Plan Type | <isCoverageOpt> |
      | User Name | <userName>      |
      | Password  | <password>      |
    Then user validate a "EditMyResponse button" buttons from PRE
    Then user do browser back from current page
    Then user validate a "Enroll In Plan" buttons from PRE
    Then user do browser back from current page
    Then user validate a "View Plan Details" buttons from PRE

    @regressionAARP @sanity
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName          | password |
      | AARP |   10003 | NO            | New York | PDP           | No             | Authenticated | DigitalDestroyer1 | DDpwd123 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | UserType      | userName          | password |
      | UHC  |   10003 | NO            | New York | PDP           | No             | Authenticated | DigitalDestroyer1 | DDpwd123 |
