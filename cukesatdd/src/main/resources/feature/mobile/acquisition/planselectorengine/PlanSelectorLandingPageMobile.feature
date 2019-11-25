@PlanSelector
Feature: Plan Selector Tool flow - Verify landing page in plan selector page

  @PRE @planrecommandonation @landingpage @siglecounty
  Scenario Outline: TID: 15471 -To validate Plan selector flow in UHC site
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engie
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | zipcode | isMultutiCounty |
      |   90210 | NO              |
      
@PRE @planrecommandonation @landingpage @multicounty
  Scenario Outline: TID: 15471 -To validate Plan selector flow in UHC site
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engie
    And clicks on get started button and runs questionnaire
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown	| <county>			|
    Examples: 
      | zipcode | isMultutiCounty | county       	|
      |   78006 | YES             | Bexar County 	|
      |   77485 | YES             | Fort Bend County|
      
      
@PRE @planrecommandonation @landingpage @invalidzipcode
  Scenario Outline: TID: 15471 -To validate Plan selector flow in UHC site
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engie
    And clicks on get started button and check error scenarios
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | zipcode | isMultutiCounty | county       	|
      |   78006 | YES             | Bexar County 	|
      |   90210 | NO              |					|