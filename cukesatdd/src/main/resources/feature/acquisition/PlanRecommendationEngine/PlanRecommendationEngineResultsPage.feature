@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Results page in plan Recommendation Engine

  @PRE @planrecommendation @resultspage @resultspageselection @regression @F384284
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate Elements of Results Page in Plan Recommendation Engine
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in loading results page

    Examples: 
      | Zipcode | isMultiCounty | county | isCoverageOpt | specialNeeds      | travel          | doctors    | DoctorsName | isMultiDoctor | Drug Selection | pharmacyoption | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |   10001 | NO            |        | MAPD          | Medicaid,facility | another,primary | outnetwork |             |               | No             | Retail         | Yes,No,No,No                  | Higher               |
