@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify zipcode page in Plan Recommendation Engine

  @PRE @zipcodepage @siglecounty @F372735 @F511315
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Single County in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |

    @FunctionalAARP @F552923 @vbfgate
    Examples: 
      | site | Zipcode | isMultutiCounty |
      | AARP |   90210 | NO              |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultutiCounty |
      | UHC  |   90210 | NO              |

  @PRE @zipcodepage @multicounty @F372735
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Multi county in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown  | <county>          |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultutiCounty | county           |
      | AARP |   78006 | YES             | Bexar County     |
      | AARP |   77485 | YES             | Fort Bend County |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultutiCounty | county           |
      | UHC  |   78006 | YES             | Bexar County     |
      | UHC  |   77485 | YES             | Fort Bend County |

  @PRE @zipcodepage @invalidZipcode @regression @F372735
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> - To validate Invalid Zipcode in ZipCode Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site PRE landing page
      | Site | <site> |
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and check error scenarios
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown  | <county>          |

    @FunctionalAARP
    Examples: 
      | site | Zipcode | isMultutiCounty | county       |
      | AARP |   78006 | YES             | Bexar County |
      | AARP |   22222 | NO              | [blank]      |
      | AARP |    1234 | NO              | [blank]      |
      | AARP |     123 | NO              | [blank]      |
      | AARP |      12 | NO              | [blank]      |
      | AARP |       1 | NO              | [blank]      |
      | AARP | [blank] | NO              | [blank]      |

    @FunctionalUHC
    Examples: 
      | site | Zipcode | isMultutiCounty | county       |
      | UHC  |   78006 | YES             | Bexar County |
      | UHC  |   22222 | NO              | [blank]      |
      | UHC  |    1234 | NO              | [blank]      |
      | UHC  |     123 | NO              | [blank]      |
      | UHC  |      12 | NO              | [blank]      |
      | UHC  |       1 | NO              | [blank]      |
      | UHC  | [blank] | NO              | [blank]      |
