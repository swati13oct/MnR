@planRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify Additional Services page in plan Recommendation Engine

  @PRE @additionalservicespage @additionalserviceselements @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Elements in Additional services using Single County in Plan Recommendation Engine
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
    Then user validate elements in additional services page
      | Drug Selection | <Drug Selection> |
		
		@FunctionalAARP @regressionAARPmobile
    Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection |
     	 | AARP |   10001 | NO            | [blank] | None          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             |
         
    @FunctionalUHC 	 
 		Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection |
     	 | UHC  |   10001 | NO            | [blank] | None          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             |  

  @PRE @additionalservicespage @additionalservicespageselection @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Function in Additional services using Single County in Plan Recommendation Engine
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
    Then user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

		@FunctionalAARP
    Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
       | AARP |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,Yes,Yes                |
       
    @FunctionalUHC       
		Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
       | UHC  |   10001 | NO            | [blank] | MAPD          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,Yes,Yes                |       

  @PRE @additionalservicespage @additionalserviceserror @F374227
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctors> , <Drug Selection> , <pharmacyoption> - To validate Error Function in Additional services using Single County in Plan Recommendation Engine
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
    Then user validates additional services error function in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |

		@FunctionalAARP
    Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
       | AARP |   10001 | NO            | [blank] | None          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  |

     @FunctionalUHC  
     Examples: 
       | site | Zipcode | isMultiCounty | county  | isCoverageOpt | specialNeeds     | travel            | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness |
       | UHC  |   10001 | NO            | [blank] | None          | Medicaid,nursing | outsideUS,regular | AcceptsMedicare | [blank]     | [blank]       | No             | Yes,No,No,No                  |