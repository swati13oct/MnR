@TeamPredators
@ordermaterials

Feature: To test order materials in Redesign site

  @MAPSOrdermaterials
  Scenario Outline: Verify order materials in Redesign site for federal type plan members
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType |option           |
      | MA       | Individual  |Member Materials |
      | MAPD     | Individual  |Welcome kit      |
      | PDP      | Individual  |Welcome Guide    |

  @SHIPOrderMaterials
  Scenario Outline: Verify order materials in Redesign site for ship type plan members
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | option      |
      | SHIP     | Individual  | Coupon Book |

  @ConfirmationPage
  Scenario Outline: Verify order materials confirmation page in Redesign site
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option           |
      | MA       |  Individual | Member Materials |
      | MAPD     | Individual  | Welcome kit      |
      | PDP      |  Individual | Welcome Guide    |

  @needhelpcomponent
  Scenario Outline: Verify need help component in Redesign site
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
    Then the user verify need help component in Redesign site

    Examples: 
      | planType | memberType |
      | MA       | Individual |

  @ValidateHeaderTabs
  Scenario Outline: Verify Aarp Order Materials Page Header - All Combo Plan Types
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
    And user Validates Page Header and Sub-Header text

    Examples: 
            | planType  | memberType | comboPlans |
            | MA        | MAwithMedSupp | MA,MedSupp |
            | MAPD			| MAPDwithHIP | MAPD,HIP |
            | PDP			| PDPwithMedSupp | PDP,MedSupp |

  @ValidateOrderMaterialOptions
  Scenario Outline: Verify Order Plan Material Options - All Combo Plan Types
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
    And user validates all Order material Options for the plantype
      | Combo Plans | <comboPlans> |

    Examples: 
            | planType  | memberType | comboPlans |
            | MA        | Individual | MA |
            | MAPD			| Individual | MAPD |
            | PDP			| Individual | PDP |

  @ValidateErrorMessage
  Scenario Outline: Verify Aarp Order Materials Page Error Message
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
            | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
    And the user click Submit without any selection
    Then the user validates error message in Order Materials page

    Examples: 
      | planType | memberType |
      | MA     | Individual |

  @ValidateSHIPErrorMessage
  Scenario Outline: Verify SHIP Invalid selection Order Materials Page Error Message
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    Then the user validates error message for SHIP invalid selection in Order Materials page

    Examples: 
      | planType | option      | memberType |
      | SHIP     | Coupon Book | Individual |
