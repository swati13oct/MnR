@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Additional Services page in plan Recommendation Engine

  @PRE @planrecommendation @additionalservicespage @additionalserviceselements @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Elements in Additional services using Single County in Plan Recommendation Engine
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
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    Then user validate elements in additional services page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds      | travel          | doctors    | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption |
      |   10001 | NO            |        | MA            | Medicaid,facility | another,primary | outnetwork |             |               | No             | Retail         |

  @PRE @planrecommendation @additionalservicespage @additionalservicespageselection @regression @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Function in Additional services using Single County in Plan Recommendation Engine
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
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    Then user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds      | travel          | doctors    | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption | Dental-Hearing-Vision-Fitness |
      |   10001 | NO            |        | MA            | Medicaid,facility | another,primary | outnetwork |             |               | No             | Retail         | Yes,No,Yes,Yes                |

  @PRE @planrecommendation @additionalservicespage @additionalserviceserror @regression @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Error Function in Additional services using Single County in Plan Recommendation Engine
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
    And user selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |
    Then user validates additional services error function in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds      | travel          | doctors    | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption | Dental-Hearing-Vision-Fitness |
      |   10001 | NO            |        | MA            | Medicaid,facility | another,primary | outnetwork |             |               | No             | Retail         | Yes,No,No,No                  |
