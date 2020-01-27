@PlanRecommandonationEngine
Feature: Plan Recommendation Engine flow - Verify doctors page in plan Recommendation Engine

    @doctorspage @doctorelementValidation @F372731
    Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> - To validate doctors page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty>   |
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt> |
    And user selects SNP options in Special Needs Page 
           | SNP Options    |<specialNeeds>            |
         And user selects Travel options in Care Away From Home Page
         |Travel Options    |<travel>     |
         Then user validate elements in doctors page

         Examples: 
      | Zipcode | isMultiCounty | county |isCoverageOpt | specialNeeds                |travel                |
      |   90201 | NO            |        |MAPD          | Medicaid,condition,facility |within,another,primary|

  @doctorspage @doctorpositive @F372731
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate doctors page positive scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty>       |
      | CountyDropDown     | <county>                 |
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt> |
       And user selects SNP options in Special Needs Page 
         | SNP Options      |<specialNeeds>            |
       And user selects Travel options in Care Away From Home Page
         |Travel Options    |<travel>     |
         And user selects doctors in doctors page
         |Doctors    |<doctors>    |      

    Examples: 
      | Zipcode | isMultiCounty | county      |isCoverageOpt| specialNeeds               |travel                |doctors    |
      |   90201 | NO            |             |MAPD         | Medicaid,condition,facility|within,another,primary|innetwork  |
      |   12345 | NO            |             |MAPD         | None                       |None                  |outnetwork |

    @doctorspage @errorscenariodoctors @F372731
    Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <specialNeeds> -Status:<status> - To validate error scenarioss on doctors page
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty>       |
      | CountyDropDown     | <county>                 |
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt> |
    And user selects SNP options in Special Needs Page 
           | SNP Options    |<specialNeeds>            |
         And user selects Travel options in Care Away From Home Page
           |Travel Options  |<travel> |
              And user validating error scenario in doctors Page 
           |Doctors  |<doctors>    |

    Examples: 
      | Zipcode | isMultiCounty | county      |isCoverageOpt| specialNeeds               |travel|doctors|
      |   90201 | NO            |             |MAPD         | Medicaid                   |within|       |
      |   78006 | YES           | Bexar County|MA           | Medicaid,condition,facility|within|       | 
      
      @doctorspage @doctormodel @F123456
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , <travel> , <doctor> - To validate doctors page positive scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty>       |
      | CountyDropDown     | <county>                 |
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt> |
    And user selects SNP options in Special Needs Page 
      | SNP Options      |<specialNeeds>            |
    And user selects Travel options in Care Away From Home Page
      |Travel Options    |<travel>     |
    And user selects doctors in doctors page
      |Doctors    |<doctors>    |      
         
    Examples: 
      | Zipcode | isMultiCounty | county      |isCoverageOpt| specialNeeds               |travel                |doctors    |
      |   78006 | YES           | Bexar County|MA           | Medicaid,condition,facility|within,another,primary|mydoctors  |				