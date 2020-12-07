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
    Then user save plans in vpp summary and Validate in Visitor profile page
      | Plan Year | <PlanYear> |
    Then user Validate Drug and Provider details in Visitor profile page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | PlanYear |
      |   10001 | NO            | New York | None          | None         | None   | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,No,No,Yes                 | Lower                | current  |

  @PRE @planrecommendation @PRE_UAT_DCE_VPP
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
    Then user validate elements in loading results page
    When user adds Drugs in vpp summary page
      | Drug Details | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> |
    Then user validate drugs details from DCE to VPP and PRE page

    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds | travel   | doctors    | DoctorsName | isMultiDoctor | Dental-Hearing-Vision-Fitness | costPreferenceOption | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch |
      |   15537 | NO            | Bedford | MA            | Medicaid     | withinUS | UHGNetwork |             |               | Yes,No,No,No                  | Lower                | Lipitor,YES,Lipitor TAB 10MG,,,1,YES,NO                              |

  @PRE @planrecommendation @PRE_UAT_ExternalLink
  Scenario Outline: <site>  - To validate drug and doctors in Visitor profile
    Given the user is on external acquisition site landing page
      | Site Name | <site> |
    When user navigate to Plan Recommendation Engine Tool
      | Site Name | <site> |

    Examples: 
      | site                   |
      | Myuhcplans             |
      | uhcandwellmedsa        |
      | mauhcmedicaresolutions |
      | maaarpmedicareplans    |
      | uhcmedicaresolutions   |
      | aarpmedicareplans      |
