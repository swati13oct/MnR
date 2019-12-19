@PlanSelector
Feature: Plan Selector Tool flow - Verify zipcode page in plan recommendation engine mobile page

  @PRE @planrecommandonation @zipcodepagemobile @siglecountymobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Single County in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    Then user validates zipcode page elements mobile
    And runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |

    Examples: 
      | Zipcode | isMultutiCounty | County   |
      |   10001 | NO              | New York |

  @PRE @planrecommandonation @zipcodepagemobile @multicountymobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Multi county in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    Then runs questionnaire at zipcode page mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <County>          |

    Examples: 
      | Zipcode | isMultutiCounty | County      |
      |   35034 | YES             | Bibb County |

  @PRE @planrecommandonation @zipcodepagemobile @invalidZipcodemobile
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Invalid Zipcode in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to Zip Code page mobile
    Then runs questionnaire at zipcode page with invalid data mobile
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | Zipcode | isMultutiCounty |
      |   21310 | NO              |
      |   78006 | YES             |
      |         | NO              |
      |    1234 | NO              |
