@thePredators
@ordermaterials
Feature: To test order plan materials flow in Redesign site for Blue Layer PLan members

  @ValidateOrderSelectionandConfirmation
  Scenario Outline: Verify order plan materials in Redesign site for radio button validation and Order Confirmation for UHC plan Members
    Given registered Redesign member for Order Plan Materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option   |
      | MA       | UHCIndividual | Replacement ID card |
      | MAPD     | UHCIndividual | Replacement ID card |
      | MA       | UHCGroup      | Replacement ID card |
      | PDP      | UHCGroup      | Welcome Guide |
      | MAPD     | UHCGroup      | Replacement ID card |

#  @PDPgroupComboValidateHeaderandTabs
 # Scenario Outline: Verify UHC Aarp Order Materials Page Header - All  Plan Types for Group Members
 #   Given registered Redesign member for Order Plan Materials with following attributes
 #     | Plan Type   | <planType>   |
 #     | Member Type | <memberType> |
 #   When the user views order materials in Member Redesign Order Materials page
 #   Then user navigates to Order Materials page for all Plans
 #     | Combo Plans | <comboPlans> |
 #   And user Validates Page Header and Sub-Header text

#    Examples: 
#      | planType | memberType | comboPlans |
#      | PDPwithSSUP      | UHCGroup      | PDP,SSUP   |
