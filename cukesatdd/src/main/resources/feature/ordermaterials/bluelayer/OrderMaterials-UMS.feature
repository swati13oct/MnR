@ordermaterials
Feature: To test order plan materials flow in UHC site

  Scenario Outline: Verify order plan materials in UHC site for federal members
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the order list in UHC site
      | Option | <option> |
    Then the user validates the plan materials under plan document section in UHC site

    Examples: 
      | planType | memberType | option              |
      | MA       | Individual | Member Materials    |
      | MAPD     | Individual | Replacement ID card |
      | MA       | Group      | Replacement ID card |
      | MAPD     | Group      | Member Materials    |
      # | SSUP       | Group          | Replacement ID card |
      | PDP      | Group      | Member Materials    |

  Scenario Outline: Verify order plan materials in UHC site for combo type member
    Given registered UHC member with following attributes
      | Plan Type1  | <planType1>  |
      | Plan Type2  | <planType2>  |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects member plan from the list in UHC site
      | Plan | <plan> |
    And the user selects an option from the order list in UHC site
      | Option | <option> |  |
    Then the user validate confirmation message for selected order in order plan materials

    Examples: 
      | planType1 | planType2 | memberType | option |

  #   | PDP         | SSUP          |            | Member Materials |
  Scenario Outline: Verify order plan materials in UHC site for federal members
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site

    Examples: 
      | planType | memberType | option              |
      # | MA         |  Individual    | Member Materials    |
      | MAPD     | Individual | Replacement ID card |

  # | MA         | Group          | Replacement ID card |
  # | MAPD       | Group          | Member Materials    |
  # | SSUP       | Group          | Replacement ID card |
  # | PDP        | Group          | Member Materials    |
  @radiobuttonmassup
  Scenario Outline: Verify order plan materials in UHC site for ma and ssup member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option           |
      | MA       | Group      | Member Materials |

  @radiobuttonpdpgroup
  Scenario Outline: Verify order plan materials in UHC site for PDP member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option        |
      | PDP      | Group      | Welcome Guide |

  @radiobuttonmaindiv
  Scenario Outline: Verify order plan materials in UHC site for MA member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option           |
      | MA       | Individual | Member Materials |

  @radiobuttonmapdssrdgroup
  Scenario Outline: Verify order plan materials in UHC site for MAPD member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option      |
      | MAPD     | Group      | Welcome kit |

  @US627227
  Scenario Outline: Verify Submit Order Button and Radio Dial Validations in order plan materials in UHC site
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option           |
      | MA       | Individual | Member Materials |

  @radiobuttonmapdindi
  Scenario Outline: Verify order plan materials in UHC site for MAPD member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option      |
      | MAPD     | Individual | Welcome kit |

  @radiobuttonvalidationmaandssup
  Scenario Outline: Verify order plan materials in UHC site for radio button validation for ma and ssup member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option           |
      | MA       | Group      | Member Materials |

  @radiobuttonvalidationpdpgrp
  Scenario Outline: Verify order plan materials in UHC site for radio button validation for pdp member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option        |
      | PDP      | Group      | Welcome Guide |

  @radiobuttonvalidationmapdandmaindi
  Scenario Outline: Verify order plan materials in UHC site for radio button validation for mapd and ma member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option      |
      | MAPD     | Group      | Welcome kit |

  @radiobuttonvalidationmapdandssrdgrp
  Scenario Outline: Verify order plan materials in UHC site for radio button validation for mapd and ssrd member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option      |
      | MAPD     | Group      | Welcome kit |

  @PDPgroupComboValidateHeaderandTabs
  Scenario Outline: Verify UHC Aarp Order Materials Page Header - All  Plan Types for Group Members
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
    And user Validates Page Header and Sub-Header text

    Examples: 
      | planType | memberType | comboPlans |
      | PDP      | Group      | PDP,SSUP   |
