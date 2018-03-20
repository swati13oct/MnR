@smokeTest
Feature: 1.10-VBF-MemRedesign-To test order materials functionality
@smokeTest_OrderPlanMaterial @rallyDashboard @testharness
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
   #   | MAPD     | AARPIndOrderPlan  | Replacement ID card      |
   #   | MAPD     | GrpRetireeOrderPlan  | Replacement ID card      |
           # | MA       |  UhcInd | Member Materials |
     # | PDP      |  AARPInd | Welcome Guide    |
    #  | SHIP     | Individual  | Member ID Card |