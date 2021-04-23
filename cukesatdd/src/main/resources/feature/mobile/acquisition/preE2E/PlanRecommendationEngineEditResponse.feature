@PlanRecommendationEngine @PRERegression7 @PRERegression
Feature: Plan Recommendation Engine flow - Verify PRE flows with Edit response functionalities

  @PRE @planrecommendation @EditResponsePage @EditResponsePageValidation
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate responses in edit preference page in PRE
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
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate saved values in edit response page
      | Zip Code            | <Zipcode>                                                              |
      | CountyDropDown      | <county>                                                               |
      | Plan Type           | <isCoverageOpt>                                                        |
      | SNP Options         | <specialNeeds>                                                         |
      | Travel Options      | <travel>                                                               |
      | Doctors             | <doctors>                                                              |
      | Doctors Search Text | <DoctorsName>                                                          |
      | Drug Selection      | <Drug Selection>                                                       |
      | Drug Details        | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
      | Additional Option   | <Dental-Hearing-Vision-Fitness>                                        |
      | Preference Option   | <costPreferenceOption>                                                 |
      | Priorities          | <priorities>                                                           |
    Then user return to vpp page using "return" from edit response page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities         | 1stRecommendation | 2ndRecommendation |
      |   10001 | NO            | New York | None          | Medicaid     | regular | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Doctors | SNP               | MA                |

  @PRE @planrecommendation @EditResponsePage @EditValuePDP
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for pdp in PRE
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
    Then user edits values in edit response page
      | Plan Type       | <isCoverageOpt>                                                          |
      | Zip Code        | <E_Zipcode>                                                              |
      | Is Multi County | <E_isMultiCounty>                                                        |
      | CountyDropDown  | <E_county>                                                               |
      | Drug Selection  | <E_Drug Selection>                                                       |
      | Drug Details    | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | E_Zipcode | E_isMultiCounty | E_county | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   10003 | NO            | New York | PDP           | No             |     33143 | NO              | Miami    | Yes              | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                                 |

  @PRE @planrecommendation @EditResponsePage @EditvalueMAPDIDK
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MAPDIDK in PRE
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
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And verify continue function on "Priorities" page
    Then user edits values in edit response page
      | Plan Type           | <isCoverageOpt>                                                          |
      | Zip Code            | <E_Zipcode>                                                              |
      | Is Multi County     | <E_isMultiCounty>                                                        |
      | CountyDropDown      | <E_county>                                                               |
      | SNP Options         | <E_specialNeeds>                                                         |
      | Travel Options      | <E_travel>                                                               |
      | Doctors             | <E_doctors>                                                              |
      | Doctors Search Text | <E_DoctorsName>                                                          |
      | Multi Doctor        | <E_isMultiDoctor>                                                        |
      | Drug Selection      | <E_Drug Selection>                                                       |
      | Drug Details        | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
      | Additional Option   | <E_Dental-Hearing-Vision-Fitness>                                        |
      | Preference Option   | <E_costPreferenceOption>                                                 |
      | Priority Option     | <E_priorityOption>                                                       |
      | Priorities          | <E_priorities>                                                           |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel    | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_Zipcode | E_isMultiCounty | E_county    | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption | E_priorities       |
      |   10002 | NO            | New York | MAPD          | Medicaid     | regular   | Lookup     | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                |     35034 | YES             | Bibb County | MAPD            | nursing        | withinUS | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                                | No,No,No,No                     | Higher                 | both             | Drug Cost, Hearing |
      |   33143 | NO            | Miami    | None          | chronic      | outsideUS | UHGNetwork | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | No,No,No,No                   | Lower                |     10003 | NO              | New York    | MAPD            | Medicaid       | withinUS | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                                | Yes,Yes,Yes,Yes                 | Lower                  | 1st              | Travel, None       |

  @PRE @planrecommendation @EditResponsePage @EditvalueMA
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MA in PRE
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
    Then user edits values in edit response page
      | Plan Type           | <isCoverageOpt>                   |
      | Zip Code            | <E_Zipcode>                       |
      | Is Multi County     | <E_isMultiCounty>                 |
      | CountyDropDown      | <E_county>                        |
      | SNP Options         | <E_specialNeeds>                  |
      | Travel Options      | <E_travel>                        |
      | Doctors             | <E_doctors>                       |
      | Doctors Search Text | <E_DoctorsName>                   |
      | Multi Doctor        | <E_isMultiDoctor>                 |
      | Additional Option   | <E_Dental-Hearing-Vision-Fitness> |
      | Preference Option   | <E_costPreferenceOption>          |
      | Priority Option     | <E_priorityOption>                |
      | Priorities          | <E_priorities>                    |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county      | isCoverageOpt | specialNeeds | travel  | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     | E_Zipcode | E_isMultiCounty | E_county | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption | E_priorityOption | E_priorities                |
      |   35034 | Yes           | Bibb County | MA            | nursing      | regular | UHGNetwork | [blank]     | [blank]       | Yes,Yes,Yes,Yes               | Lower                | both           | Travel,Doctors |     10002 | NO              | New York | MA              | chronic        | withinUS | Lookup    | john          | NO              | No,No,No,No                     | Higher                 | both             | Doctors,Health Care Premium |

  @PRE @planrecommendation @EditResponsePage @EditResponseAddProvider
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions with add provider in PRE
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
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
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

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_doctors | E_DoctorsName |
      |   10001 | NO            | New York | MAPD          | Medicaid     | regular | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                | Lookup    | john          |

  @PRE @planrecommendation @EditResponsePage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Edit preference functions for MAPD to MA in PRE
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
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
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

    @EditResponsePage_MAPDtoMA
    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_isCoverageOpt |
      |   33143 | NO            | Miami-Dade | MAPD          | Medicaid     | regular | Lookup  | john        | NO            | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO           | Yes,Yes,Yes,Yes               | Lower                | MA              |

    @EditResponsePage_IDKtoPDP
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | E_isCoverageOpt |
      |   10005 | NO            | New York | None          | Medicaid     | regular | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 40MG,,,1,YES,NO                               | Yes,Yes,Yes,Yes               | Lower                | PDP             |

  @PRE @planrecommendation @EditResponsePage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>, <E_isCoverageOpt> - To validate Edit preference functions for MA to PDP in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user selects add drug option in drug page from edit response page
      | Drug Selection | <E_Drug Selection>                                                       |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validates coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    Then user return to vpp page using "update" from edit response page
    Then user validate UI and API recommendation rankings in results page

    @EditResponsePage_MAtoPDP
    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName       | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   32115 | NO            | Volusia | MA            | Medicaid     | regular | Lookup  | David B. Auerbach | NO            | Yes,Yes,Yes,Yes               | Lower                | both           | Doctors, Health Care Premium | PDP             | Yes              | Lipitor,NO,Lipitor TAB 80MG,,,1,YES,NO                                 |

    @EditResponsePage_MAtoIDK
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | E_isCoverageOpt | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   10004 | NO            | New York | MA            | Medicaid     | regular | Lookup  | sue         | NO            | Yes,Yes,Yes,Yes               | Lower                | None           | Doctors, Health Care Premium | None            | Yes              | Lipitor,NO,Lipitor TAB 10MG,,,1,YES,NO                                 |

  @PRE @planrecommendation @EditResponsePage @PDPtoMAPD
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for PDP to MAPD in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <E_specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <E_travel> |
    And user selects doctors in doctors page
      | Doctors             | <E_doctors>       |
      | Doctors Search Text | <E_DoctorsName>   |
      | Multi Doctor        | <E_isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <E_Drug Selection>                                                       |
      | Drug Details   | <E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <E_Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <E_costPreferenceOption> |
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Drug Selection | E_DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      |   33143 | NO            | Miami-Dade | PDP           | No             | PDPTOMAPD       | nursing        | withinUS | Lookup    | john          | NO              | Yes              | Imuran,YES,Imuran TAB 50MG,,25,1,YES,NO                                | No,No,No,No                     | Higher                 |

  @PRE @planrecommendation @EditResponsePage @PDPtoMA
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Edit preference functions for PDP to MA in PRE
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
    Then user navigates to edit response page
      | Plan Type | <isCoverageOpt> |
    Then user edits coverage value in edit response page
      | Plan Type | <E_isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <E_specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <E_travel> |
    And user selects doctors in doctors page
      | Doctors             | <E_doctors>       |
      | Doctors Search Text | <E_DoctorsName>   |
      | Multi Doctor        | <E_isMultiDoctor> |
    And user selects additional services option in additional services page
      | Additional Option | <E_Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <E_costPreferenceOption> |
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county     | isCoverageOpt | Drug Selection | E_isCoverageOpt | E_specialNeeds | E_travel | E_doctors | E_DoctorsName | E_isMultiDoctor | E_Dental-Hearing-Vision-Fitness | E_costPreferenceOption |
      |   33143 | NO            | Miami-Dade | PDP           | No             | MA              | nursing        | withinUS | Lookup    | john          | NO              | No,No,No,No                     | Lower                  |
