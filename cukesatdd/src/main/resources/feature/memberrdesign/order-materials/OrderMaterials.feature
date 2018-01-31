@smokeTest
Feature: 1.10-To test order materials functionality
@smokeTest_OrderPlanMaterial
  Scenario Outline: Verify order materials confirmation page in Redesign site
    Given registered AMP member with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
      
    When the user views order materials in Member Redesign Order Materials page
     And user Validates Page Header and Sub-Header text
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option           |
      | MAPD     | UhcIndOrderPlan  | Replacement ID card      |
      | MAPD     | AARPIndOrderPlan  | Replacement ID card      |
      | MAPD     | GrpRetireeOrderPlan  | Replacement ID card      |
           # | MA       |  UhcInd | Member Materials |
     # | PDP      |  AARPInd | Welcome Guide    |
    #  | SHIP     | Individual  | Member ID Card |
    
# Not needed, covered in Confirmatiob Page Scenario
#  @MAPSOrdermaterials
#  Scenario Outline: Verify order materials in Redesign site for federal type plan members
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
##    When the user views order materials in Member Redesign Order Materials page
#    And the user selects an option from the orderp list in Redesign site
#      | Option    | <option>   |
#      | Plan Type | <planType> |

#    Examples: 
#      | planType | memberType |option           |
#      | MA       | Individual  |Member Materials |
#      | MAPD     | Individual  |Member Materials      |
#      | PDP      | Individual  |Welcome Guide    |

# Covered in Validate All Options and submit and Confirm Order
#  @SHIPOrderMaterials
#  Scenario Outline: Verify order materials in Redesign site for ship type plan members
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
#    When the user views order materials in Member Redesign Order Materials page
#    And the user selects an option from the orderp list in Redesign site
#      | Option    | <option>   |
#      | Plan Type | <planType> |

#    Examples: 
#      | planType | memberType | option      |
#      | SHIP     | Individual  | Coupon Book |

  
      

#  @needhelpcomponent
#  Scenario Outline: Verify need help component in Redesign site
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
#     
#    When the user views order materials in Member Redesign Order Materials page
#    Then the user verify need help component in Redesign site
#
#    Examples: 
#      | planType | memberType |
#      | MA       | Individual |
#
#  @ValidateHeaderTabs
#  Scenario Outline: Verify Aarp Order Materials Page Header - All Combo Plan Types
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
#    When the user views order materials in Member Redesign Order Materials page
#    Then user navigates to Order Materials page for all Plans
#      | Combo Plans | <comboPlans> |
#    And user Validates Page Header and Sub-Header text
#
#    Examples: 
#            | planType  | memberType | comboPlans |
#            | MA        | MAwithMedSupp | MA,MedSupp |
#            | MAPD			| MAPDwithHIP | MAPD,HIP |
#            | 	PDP		| PDPwithMedSupp | PDP,MedSupp |
#
#  @ValidateOrderMaterialOptions
#  Scenario Outline: Verify Order Plan Material Options - All Combo Plan Types
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
#      
#    When the user views order materials in Member Redesign Order Materials page
#    Then user navigates to Order Materials page for all Plans
#      | Combo Plans | <comboPlans> |
#    And user validates all Order material Options for the plantype
#      | Combo Plans | <comboPlans> |
#
#    Examples: 
#            | planType  | memberType | comboPlans |
#            | MA        | Individual | MA |
#            | MAPD			| Individual | MAPD |
#            | PDP			| Individual | PDP |
#            | SHIP     | Individual | SHIP |
#            
#
#  @ValidateErrorMessage
#  Scenario Outline: Verify Aarp Order Materials Page Error Message
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#            | Member Type  | <memberType> |
#      
#    When the user views order materials in Member Redesign Order Materials page
#    And the user click Submit without any selection
#    Then the user validates error message in Order Materials page
#
#    Examples: 
#      | planType | memberType |
#      | MA     | Individual |
#
#  @ValidateSHIPErrorMessage
#  Scenario Outline: Verify SHIP Invalid selection Order Materials Page Error Message
#    Given registered AMP member with following attributes
#      | Plan Type | <planType> |
#      | Member Type  | <memberType> |
#      
#    When the user views order materials in Member Redesign Order Materials page
#    And the user selects an option from the orderp list in Redesign site
#      | Option    | <option>   |
#      | Plan Type | <planType> |
#    Then the user validates error message for SHIP invalid selection in Order Materials page
#
#    Examples: 
#      | planType | option      | memberType |
#      | SHIP     | Coupon Book | Individual |
