@orderPlanMaterials @thePredators @redesignOrderMaterials
Feature:P1.5 To test order materials in Redesign site

  @orderPlanMaterials1 @ConfirmationPage @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -option <option> - Verify order materials confirmation page in Redesign site
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    Then user validates all Order material Options for the plantype
      | Combo Plans | <planType> |
    And the user verify need help component in Redesign site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page
 
    Examples: 
      | TID   | planType | memberType              | option              |
      | 15287 | MA       | AARP_Individual_order   | Replacement ID card |
      | 15288 | MAPD     | AARP_Individual_order   | Replacement ID card |
      | 15286 | PCP      | Individual_order        | Replacement ID card |
      | 15285 | MEDICA   | Individual_order        | Replacement ID card | 
      | 15292 | PDP      | AARP_Individual_order   | Welcome Guide       |
      | 15293 | SHIP     | EFT_MedSelectPlan_order | Claims Envelope     |

  #note: for SHIP user to get this error, user must have signed up for EFT i.e. recurring payments
  @orderPlanMaterials2 @ValidateSHIPErrorMessage @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -option <option> - Verify SHIP Invalid selection Order Materials Page Error Message
     Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type   | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user click Submit without any selection
    Then the user validates error message in Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    Then the user validates error message for SHIP invalid selection in Order Materials page

    Examples: 
      | TID   | planType | memberType              | option      | 
      | 15293 | SHIP     | EFT_MedSelectPlan_order | Coupon Book | 

  @orderPlanMaterials3 @GroupMemberOrderSelectionandConfirmation @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -option <option> - Verify order plan materials in Redesign site for radio button validation and Order Confirmation for UHC plan Members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type   | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | TID   | planType | memberType           | option              |
      | 15289 | MA       | UHC_Group_order      | Replacement ID card |
      | 15290 | PDP      | UHC_Group_order      | Welcome Guide       |
      | 15289 | MAPD     | UHC_Group_order      | Replacement ID card |

 #note: in comboPlans column, the order of the planTypes should follow the same as tabs order in the order plan materials page 	
 @orderPlanMaterials4 @ValidateHeaderComboTabs @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Aarp Order Materials Page Header - All Combo Plan Types
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
  
    And user Validates Page Header and Sub-Header text
    Examples: 
    | TID   | planType | memberType            | comboPlans   |
    | 15281 | MEDSUPP	   | COMBO_order | MedSupp,MAPD | 
    | 15291 | SSUP     | COMBO_order	   | PDP,SSUP	  |

 @orderPlanMaterials5 @TerminatedMemberNegativeScenario @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Terminated members cannot access Order Plan materials Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    Then the user should not see Order Materials Link for terminated member
    Then user validates header navigation is not available for Terminated member

    Examples: 
    | TID   | planType | memberType                 |
    | 15284 | MAPD     | AARP_Terminatedmember_order|
           
