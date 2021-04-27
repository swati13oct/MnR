@PlanRecommendationEngineUAT
Feature: PRE_UAT - Verify UAT Scenarios in PRE

  @PRE @planrecommendation @PRE_UAT_VP_DOC_DRUG
  Scenario Outline: <Zipcode> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> , <PlanYear>  - To validate drug and doctors in Visitor profile
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
    Then user save 2 MA plans in vpp summary and Validate in Visitor profile page
      | Plan Year | <PlanYear> |
    Then user Validate Drug and Provider details in Visitor profile page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                     | PlanYear |
      |   10001 | NO            | New York | None          | None         | None   | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,No,No,Yes                 | Lower                | both           | Drug Cost, Health Care Premium | current  |

  @PRE @planrecommendation @PRE_UAT_DCE_VPP @F550383
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <DoctorsName> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Drugs in VPP page when MA flow complete in PRE and Add drugs in DCE
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
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to VPP and PRE page

    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities    | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   15537 | NO            | Bedford | MA            | Medicaid     | withinUS | UHGNetwork | [blank]     | [blank]       | Yes,No,No,No                  | Lower                | 1st            | Doctors, None | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO                              |

  @PRE @planrecommendation @PRE_UAT_ExternalLink
  Scenario Outline: <site>  - To validate drug and doctors in Visitor profile
    Given the user is on external acquisition site landing page
      | Site Name | <site> |
    When user navigate to Plan Recommendation Engine Tool
      | Site Name | <site> |
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate PDP Plan Names in VPP Details and Click Enroll Button in Plan Details page

    Examples: 
      | site                   | Zipcode | isMultiCounty | county       | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                              |
      | Myuhcplans             |   10002 | NO            | New York     | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                                                            |
      | uhcandwellmedsa        |   10003 | NO            | New York     | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO                                        |
      | mauhcmedicaresolutions |   35034 | YES           | Bibb County  | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                                                            |
      | maaarpmedicareplans    |   35034 | YES           | Perry County | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO |
      | uhcmedicaresolutions   |   10001 | NO            | New County   | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                                                            |
      | aarpmedicareplans      |   10001 | NO            | New York     | PDP           | Yes            | morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO                                        |

  @PRE @planrecommendation @PRE_UAT_VP_PLANS_PDP
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <PlanYear> - To validate Plan Names VP VS VPP Details Page
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user save plans in vpp summary and Validate in Visitor profile page
      | Plan Year | <PlanYear> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch                              | PlanYear |
      |   10001 | NO            | New York | PDP           | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,1,NO,NO | current  |
