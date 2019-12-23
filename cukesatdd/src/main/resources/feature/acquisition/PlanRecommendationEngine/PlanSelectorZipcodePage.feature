@PlanRecommandonationEngine
Feature: Plan Recommendation Engine flow - Verify zipcode page in Plan Recommendation Engine

  @PRE @planrecommandonation @zipcodepage @siglecounty
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Single County in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | Zipcode | isMultutiCounty |
      |   90210 | NO              |
      
@PRE @planrecommandonation @zipcodepage @multicounty
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Multi county in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown	| <county>			|
    Examples: 
      | Zipcode | isMultutiCounty | county       	|
      |   78006 | YES             | Bexar County 	|
      |   77485 | YES             | Fort Bend County|
      
      
@PRE @planrecommandonation @zipcodepage @invalidZipcode @regression
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Invalid Zipcode in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and check error scenarios
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown	| <county>			|

    Examples: 
      | Zipcode | isMultutiCounty | county       	|
      |   78006 | YES             | Bexar County 	|
      |   22222 | NO              |					|
      |   1234  | NO              |					|
      |   123   | NO              |					|
      |   12    | NO              |					|
      |   1     | NO              |					|
      |         | NO              |					|