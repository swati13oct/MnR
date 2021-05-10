@planRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with recommendation

  @PRE @planrecommendation @PDPFlow @PDPskipdrug @PDPTie @F358830 @F432670 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> , <1stRecommendation> ,  <Rankingplan> , <2ndRecommendation> - To validate Loading page functions using skip drug option for PDP Tie plans in PRE
    Given the user is on UHC medicare acquisition site landing page
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
    Then user validate tie recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | No             | PDP               | [blank]           |

  @PRE @planrecommendation @PDPFlow @PDPskipdrug @F358830 @F458224 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> , <1stRecommendation> ,  <Rankingplan> , <2ndRecommendation> - To validate Loading page functions using skip drug option for PDP plans in PRE
    Given the user is on UHC medicare acquisition site landing page
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
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | No             | PDP               | [blank]           |

  @PRE @planrecommendation @PDPFlow @PDPnodrug @F358830 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> - To validate Loading page functions using add drug option without adding drug for PDP plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | Drug Selection | 1stRecommendation | 2ndRecommendation |
      |   35034 | YES           | Bibb County | PDP           | Yes            | PDP               | MA                |

  @PRE @planrecommendation @PDPFlow @PDPdrug @F358830 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption> - To validate Loading page functions using add drug option with adding drug for PDP plans in PRE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    #    And user selects pharmacy option in pharmacy page
    #      | Pharmacy Type | <pharmacyoption> |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | pharmacyoption | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Retail         | PDP               | MA                |

  @PRE @planrecommendation @MAFlow @F358830 @F458224 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MA flow functions for MA and MS plans in PRE
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county         | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York       | MA            | None         | withinUS | Lookup          | sue         | YES           | Yes,No,No,Yes                 | Lower                | both           | Doctors, Dental | MA                | MS                |
      |   25813 | NO            | Raleigh County | MA            | Medicaid     | regular  | AcceptsMedicare | [blank]     | [blank]       | No,No,No,No                   | Higher               | None           | Doctors, Dental | MS                | [blank]           |

  @PRE @planrecommendation @MAPDFlow @F358830 @F458224
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>, <priorityOption>,  <priorities> - To validate MAPD flow functions with drug functions for MA plans in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    #    And user selects pharmacy option in pharmacy page
    #      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    @PRERegression2
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | MAPD          | None         | regular | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Retail         | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Doctors | MA                | MS                |

    @PRERegression7 @PriorityAlgo
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel   | doctors | DoctorsName                                       | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | 1stRecommendation | 2ndRecommendation |
      |   10001 | NO            | New York | MAPD          | None         | withinUS | Lookup  | John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Week,1,NO,NO  | Retail         | No,Yes,Yes,No                 | Higher               | None           | Drug Cost, Doctors | MS                | MA                |
      |   10001 | NO            | New York | MAPD          | None         | withinUS | Lookup  | John N Chuey MD:Ghulam A Choudhry PA:Su S Aung MD | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,3,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Day,1,NO,NO | Retail         | No,Yes,Yes,No                 | Higher               | 1st            | Drug Cost, None    | MA                | MS                |

  @PRE @planrecommendation @MAPDFlow @MAPDskipdrug @F358830 @PRERegression2
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD flow functions with skip drug for MS plans in PRE
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | travel    | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation |
      |   35034 | YES           | Bibb County | MAPD          | None         | outsideUS | Lookup  | Julie       | No            | No             | No,No,No,Yes                  | Higher               | MS                | MA                |

  @PRE @planrecommendation @MAPDFlow @MAPDzerodrug @F358830 @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> ,<Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD flow functions with zero drug in PRE
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
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel  | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     | 1stRecommendation | 2ndRecommendation |
      |   55001 | NO            | Washington | MAPD          | nursing      | regular | AcceptsMedicare | [blank]     | [blank]       | Yes            | Yes,No,No,Yes                 | Higher               | 1st            | Drug Cost,None | SNP               | MA                |

  @PRE @planrecommendation @DKFlow @DKdrug @F358830 @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate DK flow functions with drug and DSNP in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    #    And user selects pharmacy option in pharmacy page
    #      | Pharmacy Type | <pharmacyoption> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities      | 1stRecommendation | 2ndRecommendation |
      |   10001 | NO            | New York | None          | Medicaid     | regular | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Retail         | Yes,No,No,Yes                 | Lower                | 1st            | Drug Cost, None | SNP               | MA                |

  @PRE @planrecommendation @DKFlow @DKskipdrug @F358830 @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD flow functions with skip drug with CSNP in PRE
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation |
      |   10001 | NO            | New York | None          | None         | None   | Lookup  | sue         | No            | No             | No,No,No,No                   | Higher               | MA                | MS                |

  @PRE @planrecommendation @DKFlow @DKzerodrug @F358830 @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> ,<Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <1stRecommendation> , <2ndRecommendation> - To validate MAPD flow functions with zero drug Tie Scenarios in PRE
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
    Then user selects add drug option without drugs in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county       | isCoverageOpt | specialNeeds | travel  | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | 1stRecommendation | 2ndRecommendation |
      |   84315 | YES           | Davis County | None          | chronic      | regular | UHGNetwork | [blank]     | [blank]       | Yes            | Yes,Yes,Yes,Yes               | Lower                | None           | Drug Cost, Health Care Premium | SNP               | MA                |

  @PRE @planrecommendation @MAflowTie @F432670 @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <1stRecommendation> , <2ndRecommendation> - To validate MA flow functions in PRE
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate tie recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | 1stRecommendation | 2ndRecommendation |
      |   10003 | NO            | New York | MA            | None         | withinUS | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Travel, Health Care Premium  | MA                | MS                |
      |   10001 | NO            | New York | MA            | Medicaid     | regular  | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Doctors, Dental              | SNP               | [blank]           |
      |   10002 | NO            | New York | MA            | None         | None     | UHGNetwork      | [blank]     | [blank]       | No,No,No,No                   | Lower                | None           | Doctors, Dental              | MA                | [blank]           |
      |   25813 | NO            | Raleigh  | MA            | Medicaid     | regular  | AcceptsMedicare | [blank]     | [blank]       | No,No,No,No                   | Higher               | 1st            | Doctors, None                | MS                | [blank]           |
      |   00501 | NO            | Suffolk  | MA            | chronic      | withinUS | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 2nd            | Doctors, Health Care Premium | MA                | MS                |
      |   00610 | NO            | Anasco   | MA            | None         | withinUS | AcceptsMedicare | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | both           | Travel, Doctors              | MS                | [blank]           |
      |   00610 | NO            | Anasco   | MA            | None         | None     | UHGNetwork      | [blank]     | [blank]       | No,No,No,No                   | Lower                | 1st            | Doctors, None                | [blank]           | [blank]           |

  @PRE @planrecommendation @MAPDFlowTie @PRERegression5
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> ,<Drug Selection> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD flow functions with zero drug in PRE
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user validate tie recommendations in results page
      | Zip Code           | <Zipcode>           |
      | County Name        | <county>            |
      | 1st Recommendation | <1stRecommendation> |
      | 2nd Recommendation | <2ndRecommendation> |

    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel   | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation |
      |   15537 | NO            | Bedford | MAPD          | None         | withinUS | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Lower                | MA                | MS                |
      |   59933 | NO            | Lincoln | MAPD          | None         | None     | UHGNetwork      | [blank      | [blank]       | No             | No,No,No,No                   | Lower                | [blank]           | [blank]           |
