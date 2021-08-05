@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Cost Preferences page in plan Recommendation Engine

  @PRE @costpreferencespage @costpreferenceselements @F374228
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <doctors> , <Drug Selection>  - To validate elements in Cost Preferences using Single County in Plan Recommendation Engine
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user validate elements in cost preferences page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
      | AARP |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
      | UHC  |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  |

  @PRE @prioritypage @costpreferencespageselection @F374228
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <doctors> , <Drug Selection>  - To validate Function in Cost Preferences using Single County in Plan Recommendation Engine
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements in priorities page

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | AARP |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               |
      
    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | UHC  |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               |

  @PRE @costpreferencespage @costpreferenceserror @F374228
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds>  , <doctors> , <Drug Selection>  - To validate Error Function in Cost Preferences using Single County in Plan Recommendation Engine
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
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user validates cost preferences error function in cost preferences page
      | Preference Option | <costPreferenceOption> |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | AARP |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               |
      
    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      | UHC  |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               |
