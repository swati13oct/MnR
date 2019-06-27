@orderPlanMaterials @thePredators
Feature:P1.5 To test order materials in member site

  #----- beginning of VBF scenarios section ------------------   
  @smokeTest @MemberVBF @smokeTest_OrderPlanMaterial @rallyDashboard @testharness @vbfGate
  Scenario Outline: Verify order materials confirmation page on member site
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    When user navigates to order plan materials page
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    And user validates header section of page content on order materials page
    And user validates ability to submit order for item
      | Plan Type | <planType> |
      | Option    | <option>   |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
	  | planType | memberType       | option              | 
	  | MAPD     | UhcMapdInd       | Replacement ID card |
	#  | MAPD     | AARPMapdInd      | Replacement ID card |
	#  | MAPD     | GroupRetireeMapd | Replacement ID card |
	#  | MA       | UhcIndMA         | Member Materials    |
	#  | PDP      | AARPIndPDP       | Welcome Guide       |
	#  | SHIP     | Ship             | Member ID Card      |
 
  @smokeTest @MemberVBF @peformanceTest_OrderPlanMaterial
  Scenario Outline: Verify order materials confirmation page on member site
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    When user navigates to order plan materials page
      | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
    And user validates header section of page content on order materials page
    
    Examples: 
	  | planType | memberType            |
	  | MAPD     | UhcMapdIndPerformance |  
	  
  #----- end of VBF scenarios section ------------------   

#-------------------------
# note: order materials ALM cases
# TID: 15281 - TC_01_E2E_Combo member_ Order Plan Materials
# TID: 15285 - TC_02_E2E_Medica_Order Plan Materials
# TID: 15286 - TC_03_E2E_PCP_Order Plan Materials
# TID: 15284 - TC_04_Terminate member flow_Order Plan Materials
# TID: 15287 - TC_05_E2E_AARP MA COSMOS_Individual_Order Plan Materials
# TID: 15288 - TC_06_E2E_UHC_MAPD NICE_Individual_Order Plan Materials
# TID: 15289 - TC_07_E2E_Group MA NICE_Order Plan Materials
# TID: 15290 - TC_08_E2E_Group PDP_Order Plan Materials
# TID: 15291 - TC_09_E2E_Sr. Supp_Order Plan Materials
# TID: 15292 - TC_10_E2E_AARP PDP_Order Plan Materials
# TID: 15293 - TC_11_E2E_Ship Only_Order Plan Materials
#-------------------------

  #####################################################
  # note: This scenario validate the content and functionality of the order plan material page
  # note: It will attempt to order each available items one by one (via order additional material link)
  # note  It will validate successful response or expected failure
  # note: It applicable, View ID link, Printable Documents, Contact Us links will be validated
  # note: Will also validate different ways to navigate to order plan material 
  # note:   initial will start with Order Material link on dashboard body, after closing view ID card will then use the top menu navigation
  # note: for ship user with EFT payment option setup will get expected error when ordering coupon book
  # note: for ship user without Medicare Select Plan will get expected error when ordering Medicare Select Hospital Directory
  # note: for SSUP user is group only and the group has to be setup in GPS to accept online request for welcome kit
  # note: 
  #####################################################
  @orderPlanMaterials01 @E2EOrderPlantcase @ConfirmationPage @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify order plan material functionality for different type of users
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to order plan materials page
      | Plan Type | <planType> |
      | Member Type | <memberType> |
    Then user validates header section of page content on order materials page
    And user validates selection section of page content on order materials page
    And user validates printable documentations section of page content on order materials page
    And user validates need help section of page content on order materials page
    And user validates error message when submit without any selection
    Then user validates ability to submit order for each item individually for all available items
    
    Examples: 
      | TID   | planType | memberType            | 
      | 15287 | MA	 | AARP_Individual_order |  
      | 15288 | MAPD     | AARP_Individual_order |
      | 15292 | PDP      | AARP_Individual_order |
      | 15288 | MAPD     | UHC_Individual_order  |
      | 15286 | PCP      | Individual_order      |
      | 15285 | MEDICA   | Individual_order      |
      | 15293 | SHIP     | MEDSUPP_order         | 

    @GroupMemberOrderSelectionandConfirmation 
    Examples: 
      | TID   | planType | memberType            | 
      | 15289 | MA       | UHC_Group_order       |
      | 15289 | MAPD     | UHC_Group_order       |
      | 15290 | PDP      | UHC_Group_order       |

   # note: keep SSUP case but skip the run for now, it requires specific data setup that doesn't always exist
   @ValidateHeaderComboTabs
    Examples: 
      | TID   | planType | memberType            | 
      | 15281 | MAPD	 | COMBO_order           |
      | 15281 | MEDSUPP	 | COMBO_order           |
      | 15291 | PDP      | COMBO_order	         |
    # | 15291 | SSUP     | COMBO_order	         |

    @ValidateSHIPCouponBookErrorMessage
    Examples: 
      | TID   | planType | memberType               | 
      | 15293 | SHIP     | EFT_MedSelectPlan_order  | 

  #####################################################
  # note: For terminated user, the Order Materials link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @orderPlanMaterials02 @TerminatedMemberNegativeScenario @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Terminated members cannot access Order Plan materials Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user should not see Order Materials Link for terminated member
    Then user validates header navigation is not available for Terminated member

    Examples: 
      | TID   | planType | memberType                  |
      | 15284 | MAPD     | AARP_Terminatedmember_order |
    
