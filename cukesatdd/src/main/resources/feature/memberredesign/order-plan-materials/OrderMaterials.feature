@thePredators
@ordermaterials
@redesignOrderMaterials
@regression_06_06_18
Feature:P1.5 To test order materials in Redesign site
  @ConfirmationPage
  Scenario Outline: Verify order materials confirmation page in Redesign site
    Given Redesign login for following redesign member in the member portal
      | Member Type  | <memberType> |
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
#      | MA      |  MA_AARPIndividual | Replacement ID card |
      | MAPD     | MAPD_AARPIndividual  | Replacement ID card      |
      | MAPD     | PCP_OrderMaterials  | Replacement ID card      |
      | MAPD     | Medica_OrderMaterials  | Replacement ID card      |
      | PDP      |  PDP_AARPIndividual | Welcome Guide    |
      | SHIP     | SHIP_AARPIndividual  | Claims Envelope |

  @ValidateSHIPErrorMessage
  Scenario Outline: Verify SHIP Invalid selection Order Materials Page Error Message
    Given Redesign login for following redesign member in the member portal
      | Member Type  | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user click Submit without any selection
    Then the user validates error message in Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    Then the user validates error message for SHIP invalid selection in Order Materials page

    Examples: 
      | planType | option      | memberType |
      | SHIP     | Coupon Book | SHIP_AARPIndividual |


  @GroupMemberOrderSelectionandConfirmation
  Scenario Outline: Verify order plan materials in Redesign site for radio button validation and Order Confirmation for UHC plan Members
    Given Redesign login for following redesign member in the member portal
      | Member Type | <memberType> |
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option   |
      | MA       | MA_UHCGroup      | Replacement ID card |
      | PDP      | PDP_UHCGroup      | Welcome Guide |
      | MAPD     | MAPD_UHCGroup      | Replacement ID card |

#  @ValidateHeaderComboTabs
#  Scenario Outline: Verify Aarp Order Materials Page Header - All Combo Plan Types
#    Given Redesign login for following redesign member in the member portal
#      | Member Type | <memberType> |
#    When the user views order materials in Member Redesign Order Materials page
#    Then user navigates to Order Materials page for all Plans
#      | Combo Plans | <comboPlans> |
#    And user Validates Page Header and Sub-Header text
#    Examples: 
#            | planType  | memberType | comboPlans |
#            | 	MAPD		| MAPDwithMedSupp | MAPD,MedSupp |
           
@TerminatedMemberNegativeScenario
  Scenario Outline: Verify Terminated members cannot access Order Plan materials Page
    Given Redesign login for following redesign member in the member portal
      | Member Type | <memberType> |
    Then the user should not see Order Materials Link for terminated member
    Then user validates header navigation is not available for Terminated member
    Examples: 
            | memberType |
            | TerminatedMember |

            
@MemberAuth_OrderMaterialsErrorMessage
Scenario Outline: To validate the oneTime Payment flow for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username      | <username>     |
      | Password      | <password>     |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |   
    And User Clicks on the Pop up displayed
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    
   Examples: 
      | username  | password  |MemUserName    | planType |  option           |
#      | qavgogine | qavgogine | q2_jun_aarp0017 | MAPD     | Replacement ID card      |
 