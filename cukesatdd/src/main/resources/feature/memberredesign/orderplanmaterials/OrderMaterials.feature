@orderPlanMaterials @thePredators @redesignOrderMaterials
Feature:P1.5 To test order materials in Redesign site

  @orderPlanMaterials1 @ConfirmationPage @regressionMember
  Scenario Outline: Verify order materials confirmation page in Redesign site
    Given login with following details logins in the member portal and validate elements
    | Plan Type   | <planType>   |
	| Member Type   | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    Then user validates all Order material Options for the plantype
      | Combo Plans | <planType> |
    And the user verify need help component in Redesign site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page
    Examples: 
      | planType | memberType | option           |
      | MA      |  AARPIndividual | Replacement ID card |
      | MAPD     | AARPIndividual  | Replacement ID card      |
      | MAPD     | PCP  | Replacement ID card      |
      | MAPD     | Medica2  | Replacement ID card      | 
      | PDP      |  AARPIndividual | Welcome Guide    |
      #orig | SHIP     | AARPIndividual  | Claims Envelope |
      | SHIP     | AARPIndividual_order  | Claims Envelope |

  @orderPlanMaterials2 @ValidateSHIPErrorMessage @regressionMember
  Scenario Outline: Verify SHIP Invalid selection Order Materials Page Error Message
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
      | planType | memberType          |option      | 
      #orig | SHIP     | AARPIndividual      |Coupon Book | 
      | SHIP     | AARPIndividual_order      |Coupon Book | 

  @orderPlanMaterials3 @GroupMemberOrderSelectionandConfirmation @regressionMember
  Scenario Outline: Verify order plan materials in Redesign site for radio button validation and Order Confirmation for UHC plan Members
    Given login with following details logins in the member portal and validate elements
    | Plan Type   | <planType>   |
	| Member Type   | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option   |
      | MA       | UHCGroup      | Replacement ID card |
      | PDP      | UHCGroup      | Welcome Guide |
      | MAPD     | UHCGroup2      | Replacement ID card |

 @orderPlanMaterials4 @ValidateHeaderComboTabs @regressionMember 
  Scenario Outline: Verify Aarp Order Materials Page Header - All Combo Plan Types
    Given login with following details logins in the member portal and validate elements
    | Plan Type   | <planType>   |
	| Member Type   | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
  
    And user Validates Page Header and Sub-Header text
    Examples: 
            | planType  | memberType | comboPlans |
            | 	MAPD	| MAPDwithMedSupp | MAPD,MedSupp | 
            | SSUP		| PDPwithSSUP	|	PDP,SSUP	|

 @orderPlanMaterials5 @TerminatedMemberNegativeScenario @regressionMember
  Scenario Outline: Verify Terminated members cannot access Order Plan materials Page
    Given login with following details logins in the member portal and validate elements
    | Plan Type   | <planType>   |
	| Member Type   | <memberType> |
    Then the user should not see Order Materials Link for terminated member
    Then user validates header navigation is not available for Terminated member
    Examples: 
            | planType | memberType |
            | MAPD | AARPTerminatedmember |
           
