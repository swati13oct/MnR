@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify PRE flows functionalities with recommendation

  @PRE @planrecommendation @EditResponsePage
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate DK flow functions with drug and DSNP in PRE
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
    Then user validate elements in loading results page
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
    Then user return to vpp page using "return" from edit response page
    Then user validate UI and API recommendation rankings in results page

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | travel  | doctors | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch | Dental-Hearing-Vision-Fitness | costPreferenceOption | 1stRecommendation | 2ndRecommendation |
      |   10001 | NO            | New York | None          | Medicaid     | regular | Lookup  | sue         | NO            | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,1,YES,NO                               | Yes,No,No,Yes                 | Lower                | SNP               | MA                |

  @EditResponsePage1
  Scenario Outline: <Zipcode>, <isMultiCounty> ,<county>, <isCoverageOpt> , <Drug Selection> - To validate Loading page functions using skip drug option for PDP Tie plans in PRE
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
    Then user validate saved values in edit response page
      | Zip Code       | <Zipcode>        |
      | CountyDropDown | <county>         |
      | Plan Type      | <isCoverageOpt>  |
      | Drug Selection | <Drug Selection> |

    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      |   10003 | NO            | New York | PDP           | No             |
