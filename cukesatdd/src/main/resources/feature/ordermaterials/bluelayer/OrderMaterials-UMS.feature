@TeamPredators
@ordermaterials
Feature: To test order plan materials flow in UHC site

# Not needed as covered in next scenario for Option Selection and Confirmation
  #@radiobuttonOptionsFederal
  #Scenario Outline: Verify order plan materials in UHC site for Federal member
  #  Given registered UHC member for order plan materials with following attributes
  #    | Plan Type   | <planType>   |
  #    | Member Type | <memberType> |
  #  When the user views order materials in UHC site
  #  And the user selects an option from the orderp list in Redesign site
  #    | Option    | <option>   |
  #    | Plan Type | <planType> |

  #  Examples: 
  #    | planType | memberType | option           |
  #    | MA       | Individual | Member Materials |
  #    | MAPD     | Individual | Member Materials |
  #    | MA       | Group      | Member Materials |
  #    | PDP      | Group      | Welcome Guide |
  #    | MAPD     | Group      | Member Materials |


  @ValidateOrderSelectionandConfirmation
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
      | MA       | Individual | Replacement ID card |
      | MAPD     | Individual | Replacement ID card |
      | MA       | Group      | Replacement ID card |
      | PDP      | Group      | Welcome Guide |
      | MAPD     | Group      | Replacement ID card |

#  @PDPgroupComboValidateHeaderandTabs
 # Scenario Outline: Verify UHC Aarp Order Materials Page Header - All  Plan Types for Group Members
 #   Given registered UHC member for order plan materials with following attributes
 #     | Plan Type   | <planType>   |
 #     | Member Type | <memberType> |
 #   When the user views order materials in UHC site
 #   Then user navigates to Order Materials page for all Plans
 #     | Combo Plans | <comboPlans> |
 #   And user Validates Page Header and Sub-Header text

#    Examples: 
#      | planType | memberType | comboPlans |
#      | PDPwithSSUP      | Group      | PDP,SSUP   |
