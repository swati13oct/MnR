@PlanSelector
Feature: Plan Selector Tool flow - Verify zipcode page in plan selector page

  @PRE @planrecommandonation @zipcodepagemobile @siglecountymobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Single County in ZipCode Page in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to "Zip Code" page mobile
    Then user validates zipcode page elements mobile
    And runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |

    Examples: 
      | Zipcode | isMultutiCounty |County Name|
      |   10001 | NO              |New York|

  @PRE @planrecommandonation @zipcodepagemobile @multicountymobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Multi county in ZipCode Page in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engie
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown  | <county>          |

    Examples: 
      | Zipcode | isMultutiCounty | county           |
      |   78006 | YES             | Bexar County     |
      |   77485 | YES             | Fort Bend County |

  @PRE @planrecommandonation @zipcodepagemobile @invalidZipcodemobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Invalid Zipcode in ZipCode Page in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engie
    And clicks on get started button and check error scenarios
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | Zipcode | isMultutiCounty | county       |
      |   78006 | YES             | Bexar County |
      |   21310 | NO              |              |
      |    1234 | NO              |              |
      |     123 | NO              |              |
      |      12 | NO              |              |
      |       1 | NO              |              |
      |         | NO              |              |
