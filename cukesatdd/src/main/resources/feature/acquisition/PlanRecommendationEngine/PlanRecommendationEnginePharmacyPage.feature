@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Pharmacy page in plan Recommendation Engine

  @PRE @planrecommendation @pharmacypage @pharmacyelementValidation @F374226
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> - To validate Pharmacy page Elements using Single County in Plan Recommendation Engine
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
    And user validate elements in pharmacy page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds                | travel                 | doctors   | DoctorsName | isMultiDoctor | Drug Selection |
      |   90201 | NO            |        | MAPD          | Medicaid,condition,facility | within,another,primary | innetwork |             |               | No            |

  @PRE @planrecommendation @pharmacypage @pharmacypageselection @regression @F374226
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Selecting pharmacy options using Single County in Plan Recommendation Engine
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

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds                | travel                 | doctors    | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption |
      |   90201 | NO            |        | MAPD          | Medicaid,condition,facility | within,another,primary | innetwork  |             |               | No            | Online         |
      |   10001 | NO            |        | MA            | Medicaid,facility           | another,primary        | outnetwork |             |               | No            | Retail         |

  @PRE @planrecommendation @pharmacypage @pharmacypageerrorScenario @regression @F374226
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Not Selecting pharmacy options using Single County in Plan Recommendation Engine
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
    And user not selects pharmacy option in pharmacy page
      | Pharmacy Type | <pharmacyoption> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds                | travel                 | doctors   | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption |
      |   90201 | NO            |        | MAPD          | Medicaid,condition,facility | within,another,primary | innetwork |             |               | No            |                |

  @PRE @planrecommendation @pharmacypage @previousfunctionbeforeContinuepharmacy @F374226
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> - To validate Previous Button functionality before Click continue of pharmacy previous options page in Plan Recommendation Engine
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
    And user select pharmacy option and Click previous button to check previous page
      | Pharmacy Type | <pharmacyoption> |

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds                | travel                 | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | pharmacyoption |
      |   12345 | NO            |        | MAPD          | Medicaid,condition,facility | within,another,primary | outnetwork |             |               |  Yes            | Imuran,YES,Imuran TAB 50MG,,25,1,YES,YES                             | Online         |
