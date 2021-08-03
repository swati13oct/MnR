@PlanRecommendationEngine
Feature: 1.18.5 Plan Recommendation Engine flow - Verify PRE flows with Edit response functionalities

  @PRE @EditResponsePage @EditResponsePageValidation
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate responses in edit preference page in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate saved values in edit response page
      | Zip Code            | <Zipcode>                                                                      |
      | CountyDropDown      | <county>                                                                       |
      | Plan Type           | <isCoverageOpt>                                                                |
      | SNP Options         | <specialNeeds>                                                                 |
      | Doctors             | <doctors>                                                                      |
      | Doctors Search Text | <DoctorsName>                                                                  |
      | Drug Selection      | <Drug Selection>                                                               |
      | Drug Details        | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
      | Additional Option   | <Dental-Hearing-Vision-Fitness>                                                |
      | Preference Option   | <costPreferenceOption>                                                         |
      | Priorities          | <priorities>                                                                   |
    Then user return to vpp page using "return" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | 1stRecommendation | 2ndRecommendation |
      | AARP |   10001 | NO            | New York | None          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                 | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Doctors | SNP               | MA                |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | 1stRecommendation | 2ndRecommendation |
      | UHC  |   10001 | NO            | New York | None          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                 | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Doctors | SNP               | MA                |

  @PRE @EditResponsePage @EditValuePDP
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for pdp in PRE
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
    Then user edits values in edit response page
      | Plan Type       | <isCoverageOpt>                                                                  |
      | Zip Code        | <E_Zipcode>                                                                      |
      | Is Multi County | <E_isMultiCounty>                                                                |
      | CountyDropDown  | <E_county>                                                                       |
      | Drug Selection  | <E_Drug Selection>                                                               |
      | Drug Details    | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user return to vpp page using "update" from edit response page

    #Then user validate UI and API recommendation rankings in results page
    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | E_Zipcode | E_isMultiCounty | E_county | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   10003 | NO            | New York | PDP           | No             |     33143 | NO              | Miami    | Yes              | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                     |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | E_Zipcode | E_isMultiCounty | E_county | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   10003 | NO            | New York | PDP           | No             |     33143 | NO              | Miami    | Yes              | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                     |

  @PRE @EditResponsePage @EditvalueMAPDIDK
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MAPDIDK in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user edits values in edit response page
      | Plan Type           | <isCoverageOpt>                                                                  |
      | Zip Code            | <E_Zipcode>                                                                      |
      | Is Multi County     | <E_isMultiCounty>                                                                |
      | CountyDropDown      | <E_county>                                                                       |
      | SNP Options         | <E_specialNeeds>                                                                 |
      | Doctors             | <E_doctors>                                                                      |
      | Doctors Search Text | <E_DoctorsName>                                                                  |
      | Multi Doctor        | <E_isMultiDoctor>                                                                |
      | Drug Selection      | <E_Drug Selection>                                                               |
      | Drug Details        | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
      | Additional Option   | <E_Dental-Hearing-Vision-Fitness>                                                |
      | Preference Option   | <E_costPreferenceOption>                                                         |
      | Priority Option     | <E_priorityOption>                                                               |
      | Priorities          | <E_priorities>                                                                   |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @sanity
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_Zipcode | E_isMultiCounty | E_county    | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection                              | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption   | E_priorities |
      | AARP |   10002 | NO            | New York | MAPD          | Medicaid     | Lookup     | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Lower                |     35035 | YES             | Bibb County | MAPD            | nursing        | Lookup   | julie     | NO            | Yes             | Imuran,YES,Imuran TAB 50MG,,25,Month,1,YES,NO | No,No,No,No                                                                    | Higher                          | both                   | Drug Cost, Doctors | Higher       |
      | AARP |   33143 | NO            | Miami    | None          | chronic      | UHGNetwork | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                 | No,No,No,No                   | Lower                |     10003 | NO              | New York    | MAPD            | Medicaid       | Lookup   | julie     | NO            | Yes             | Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO   | Yes,Yes,Yes,Yes                                                                | Lower                           | 1st                    | Travel, None       | Higher       |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_Zipcode | E_isMultiCounty | E_county    | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection                              | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption   | E_priorities |
      | UHC  |   10002 | NO            | New York | MAPD          | Medicaid     | Lookup     | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Lower                |     35035 | YES             | Bibb County | MAPD            | nursing        | Lookup   | julie     | NO            | Yes             | Imuran,YES,Imuran TAB 50MG,,25,Month,1,YES,NO | No,No,No,No                                                                    | Higher                          | both                   | Drug Cost, Doctors | Higher       |
      | UHC  |   33143 | NO            | Miami    | None          | chronic      | UHGNetwork | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO                                 | No,No,No,No                   | Lower                |     10003 | NO              | New York    | MAPD            | Medicaid       | Lookup   | julie     | NO            | Yes             | Imuran,YES,Imuran TAB 50MG,,25,Day,1,YES,NO   | Yes,Yes,Yes,Yes                                                                | Lower                           | 1st                    | Travel, None       | Higher       |

  @PRE @EditResponsePage @EditvalueMA
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MA in PRE
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
    Then user edits values in edit response page
      | Plan Type           | <isCoverageOpt>                   |
      | Zip Code            | <E_Zipcode>                       |
      | Is Multi County     | <E_isMultiCounty>                 |
      | CountyDropDown      | <E_county>                        |
      | SNP Options         | <E_specialNeeds>                  |
      | Doctors             | <E_doctors>                       |
      | Doctors Search Text | <E_DoctorsName>                   |
      | Multi Doctor        | <E_isMultiDoctor>                 |
      | Additional Option   | <E_Dental-Hearing-Vision-Fitness> |
      | Preference Option   | <E_costPreferenceOption>          |
      | Priority Option     | <E_priorityOption>                |
      | Priorities          | <E_priorities>                    |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP @prodRegression
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     | E_Zipcode | E_isMultiCounty | E_county | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption | E_priorities                |
      | AARP |   35035 | Yes           | Bibb County | MA            | nursing      | UHGNetwork | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Lower                | both           | Vision,Doctors |     10002 | NO              | New York | MA              | chronic        | Lookup    | john          | NO              | No,No,No,No                     | Higher                 | both             | Doctors,Health Care Premium |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     | E_Zipcode | E_isMultiCounty | E_county | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption | E_priorities                |
      | UHC  |   35035 | Yes           | Bibb County | MA            | nursing      | UHGNetwork | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Lower                | both           | Vision,Doctors |     10002 | NO              | New York | MA              | chronic        | Lookup    | john          | NO              | No,No,No,No                     | Higher                 | both             | Doctors,Health Care Premium |

  @PRE @EditResponsePage @EditResponseAddProvider
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions with add provider in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user adds doctor in edit response page
      | Plan Type           | <isCoverageOpt> |
      | Doctors             | <E_doctors>     |
      | Doctors Search Text | <E_DoctorsName> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_doctors | E_DoctorsName |
      | AARP |   10001 | NO            | New York | MAPD          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Lower                | Lookup    | julie         |

    @regressionUHC @prodRegression
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_doctors | E_DoctorsName |
      | UHC  |   10001 | NO            | New York | MAPD          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO                                   | Yes,Yes,Yes,Yes               | Lower                | Lookup    | julie         |

  @PRE @EditResponsePage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MAPD to MA in PRE
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
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                               |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user validates coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @EditResponsePage_MAPDtoMA @regressionAARP @EditResponsePage_IDKtoPDP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_isCoverageOpt |
      | AARP |   33143 | NO            | Miami-Dade | MAPD          | Medicaid     | Lookup  | john        | NO            | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO             | Yes,Yes,Yes,Yes               | Lower                | MA              |
      | AARP |   10005 | NO            | New York   | None          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 40MG,,,Week,1,YES,NO                                  | Yes,Yes,Yes,Yes               | Lower                | PDP             |

    @EditResponsePage_MAPDtoMA @regressionUHC @EditResponsePage_IDKtoPDP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_isCoverageOpt |
      | UHC  |   33143 | NO            | Miami-Dade | MAPD          | Medicaid     | Lookup  | john        | NO            | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO             | Yes,Yes,Yes,Yes               | Lower                | MA              |
      | UHC  |   10005 | NO            | New York   | None          | Medicaid     | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 40MG,,,Week,1,YES,NO                                  | Yes,Yes,Yes,Yes               | Lower                | PDP             |

  @PRE @EditResponsePage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch>  , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>, <E_isCoverageOpt> - To validate Edit preference functions for MA to PDP in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user selects add drug option in drug page from edit response page
      | Drug Selection | <E_Drug Selection>                                                               |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    Then user validates coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @EditResponsePage_MAtoPDP @EditResponsePage_MAtoIDK @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | AARP |   32115 | NO            | Volusia  | MA            | Medicaid     | Lookup  | David B. Auerbach | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Health Care Premium | PDP             | Yes              | Lipitor,NO,Lipitor TAB 80MG,,,Week,1,YES,NO                                    |
      | AARP |   10004 | NO            | New York | MA            | Medicaid     | Lookup  | sue               | NO            | Yes,Yes,Yes,Yes               | Lower                | None           | Doctors, Health Care Premium | None            | Yes              | Lipitor,NO,Lipitor TAB 10MG,,,Day,1,YES,NO                                     |

    @EditResponsePage_MAtoPDP @EditResponsePage_MAtoIDK @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch |
      | UHC  |   32115 | NO            | Volusia  | MA            | Medicaid     | Lookup  | David B. Auerbach | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Health Care Premium | PDP             | Yes              | Lipitor,NO,Lipitor TAB 80MG,,,Week,1,YES,NO                                    |
      | UHC  |   10004 | NO            | New York | MA            | Medicaid     | Lookup  | sue               | NO            | Yes,Yes,Yes,Yes               | Lower                | None           | Doctors, Health Care Premium | None            | Yes              | Lipitor,NO,Lipitor TAB 10MG,,,Day,1,YES,NO                                     |

  @PRE @EditResponsePage @PDPtoMAPD
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for PDP to MAPD in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <E_specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <E_doctors>       |
      | Doctors Search Text | <E_DoctorsName>   |
      | Multi Doctor        | <E_isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <E_Drug Selection>                                                               |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <E_Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <E_costPreferenceOption> |
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      | AARP |   33143 | NO            | Miami-Dade | PDP           | No             | PDPTOMAPD       | nursing        | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,Week,1,YES,NO                                   | No,No,No,No                     | Higher                 |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      | UHC  |   33143 | NO            | Miami-Dade | PDP           | No             | PDPTOMAPD       | nursing        | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,Week,1,YES,NO                                   | No,No,No,No                     | Higher                 |

  @PRE @EditResponsePage @PDPtoMA
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for PDP to MA in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <E_specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <E_doctors>       |
      | Doctors Search Text | <E_DoctorsName>   |
      | Multi Doctor        | <E_isMultiDoctor> |
    And user selects additional services option in additional services page
      | Additional Option | <E_Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <E_costPreferenceOption> |
    Then user validate UI and API recommendation rankings in results page

    @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      | AARP |   33143 | NO            | Miami-Dade | PDP           | No             | MA              | nursing        | Lookup    | john          | NO              | No,No,No,No                     | Lower                  |

    @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      | UHC  |   33143 | NO            | Miami-Dade | PDP           | No             | MA              | nursing        | Lookup    | john          | NO              | No,No,No,No                     | Lower                  |
