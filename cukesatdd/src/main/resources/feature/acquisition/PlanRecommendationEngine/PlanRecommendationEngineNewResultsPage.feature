@planRecommendationEngine @PREVPPRegression
Feature: Plan Recommendation Engine flow - Verify PRE New Results page in plan Recommendation Engine

  @PRE @planrecommandonation @PREVPPPage @F527967
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption>  - To validate Email Plan List PDP plans in PRE
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

    #    Then user validate elements in new PRE results page
    #      | Zip Code       | <Zipcode> |
    #      | CountyDropDown | <county>  |
    Examples: 
      | Zipcode | isMultiCounty | county   | isCoverageOpt | Drug Selection |
      |   10003 | NO            | New York | PDP           | No             |

  @PRE @planrecommendation @MAPDTile
  Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <DoctorsName> , <isMultiDoctor> , <Drug Selection> , <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-IsNotgeneric-Switch> , <pharmacyoption> , <Dental-Hearing-Vision-Fitness> , <costPreferenceOption> - To validate MAPD Tile in PRE Result page
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
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page

    Examples: 
      | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds    | travel   | doctors         | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                                | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities     |
      |   32115 | NO            | Volusia | MAPD          | Chronic,Nursing | withinUS | AcceptsMedicare | [blank]     | [blank]       | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Day,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | No,No,Yes,No                  | Lower                | both           | Travel, Vision |
#      |   15537 | NO            | Bedford | MAPD          | None            | None     | UHGNetwork      |  [blank]              |  [blank]                | NO             |  [blank]                                                                                                   | No,No,No,No                   | Lower                | 2nd            | Doctors, Health Care Premium |
