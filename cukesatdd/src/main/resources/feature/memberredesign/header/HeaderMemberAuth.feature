@header @thePredators @member_redesign
Feature: 1.08.1 Member Header/Navigation validation - Member Auth

  # note: if system is in future date, some testcases may fail due to expected tab(s) not showing up on page depending on user's data setup
  @memAuth_header01 @mapd_header @member_redesign_header @headerRegression @mapd_header_MemAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate via member authorization access for header
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
    #When the above plantype user logs in UMS Site Desktop Header
    #And I view the global navigation Header
    #Then I should be able to see and use the Home tab Header
    Then I should be able to see and use the Find Care & Costs tab Header
    Then the user navigates to EOB page
    #Then I should be able to see and use the Claims tab Header
    #And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
    #And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
    And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header
    And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header
    And then click the Order Materials tab and I should be directed to the Order Materials Page Header
    Then I should be able to see and use the Premium Payments tab Header
    Then I should be able to see and use the pharmacies tab in the header
    Then I should be able to see and use the health and wellness tab in the header
    Then I should be able to see the help button Header
    Then I should be able to see and use the Account/Profile dropdown and logout

    Examples: 
      | TID         | username  | password  | MemUserName     | planType | memberType    | flow  |
      | 15164,15171 | qavgogine | qavgogine | q3_sep_UAT4_UHC017    | MAPD     | Individual    | header|
      | 15164,15171 | qavgogine | qavgogine | q3_sep_UAT4_AARP057    | PDP      | Individual    | header|

    Examples: 
      | TID         | username  | password  | MemUserName     | planType | memberType    | flow  |
      | 15164,15171 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020    | MEDICA   | Individual    | header|
     

  @memAuth_header02 @premiumpaymentsheader @premiumpaymentsheader_MemAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check the Premium Payments Tab in the header
	     Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	    Then I should be able to see and use the Premium Payments tab Header
		
		@headerRegression
	    Examples: 
	      | TID   | username  | password  | MemUserName     | planType | memberType              |
	      | 15252 | qavgogine | qavgogine | LepAndMonthlyPremium01    | MAPD     | GroupLessSubsidy_header |
	    
	    @F287624 @US2037787 @US2037966
	    Examples: 
	      | TID       | username  | password  | MemUserName     | planType    | memberType                    |
	      | US2037787 | qavgogine | qavgogine | q3_sep_Active_combo_005    | PDP_SSP     | comboAllNot100Subsidy_header  |
	    # disable for now without suitable user - covered by comboAll100Subsidy_header case where SHIP payment tab is showing
	    #  | US2037966 | qavgogine | qavgogine | testusername    | PDP_SSP     | comboSomeHas100Subsidy_header |

 
  # note: DO NOT REMOVE - info on how to pick the right user to test comboAll100Subsidy_header case
  # note: for this to work, 100 percent subsidy - not the LIS type - for Employer - or Group plans - applicable to Premium Payment
  # note: Only Group Member would be having subsidies in Premium payment, as the plans are purchased by the Employer for 
  # note: certain group of members he has employed and depending on the subsidy percentage he pays the complete - 
  # note: in case of 100 subsidy or partial premium for the member.
  # note: SHIP plans are like any other plans with some additional benefits and its member irrespective of their LIS status, 
  # note: would have to pay some premium amount
  # note: You need a Combo member which should not see Premium Payment option. That should be the Group and SHIP Plan combo.
  # note: Since SHIP member cannot be given any subsidy on premium, only Group plan will be applicable for 100 subsidy.
  # note: You will still see Payments option in Header for this combo member, because of SHIP plan.
  # note: Under premium payments tab, you will see premium payment option for SHIP member but not Group Member.
  @memAuth_header03 @premiumpaymentsheader_100%subisdy 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Premium Payments Tab is not displayed in the header
	   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	    Then I should not be able to see the Premium Payments tab Header
	 
	 	@headerRegression
	    Examples: 
	      | TID       | username  | password  | MemUserName     | planType    | memberType                | 
	      | 15253     | qavgogine | qavgogine | q2_jun_grp0434    | MAPD        | IndividualGroup_header    | 

        #note: in this case at the time of test, this PDP SHIP combo user has 100 percent subsidy on PDP
        #note: user will see payment tab because of ship plan 
        #note: but when user is on payment tab, only SHIP plan tab should be available
        @F287624 @US2037783 @US2037945 
	    Examples: 
	      | TID       | username  | password  | MemUserName     | planType    | memberType                |
	      | US2037783 | qavgogine | qavgogine | q3_sep_Active_combo_009    | PDP         | comboAll100Subsidy_header |
	    
	    #note: in this case at the time of test, this combo user has both plans with false premiumPayment
	    #note: therefore, no payment tab should be showing  
	    @premiumPaymentFalse
	    Examples: 
	      | TID       | username  | password  | MemUserName     | planType    | memberType                |
	      | US2037783 | qavgogine | qavgogine | q3_combo_pdpssup_001    | PDP_SSP     | comboNoPremiumPayment     |
	      
	      

  @memAuth_header05 @no_findcareheader @headerRegression @no_findcareheader_MemAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header
	     Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	    #And I view the global navigation Header
	    Then I should not be able to see the Find Care & Costs tab Header
			
	    Examples: 
	      | TID   | username  | password  | MemUserName     | planType | memberType | flow   |
	      | 15251 | qavgogine | qavgogine | q1_feb_2020SHIP_019    | SHIP     | Medsupp    | header |

  @memAuth_header06 @terminated @headerRegression @terminated_MemAuth
  Scenario Outline: TID: <TID> -plan: Any -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header for terminated user
	    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	    Then the user navigates to EOB page
	    #Then I should be able to see and use the Claims tab Header
	     #And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
       #And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
       And clicking on the Coverage & Benefits tab should allow me to see link of for the Forms & Resources tab on the second level navigation Header
	     Then I should be able to see the help button Header
       Then I should be able to see and use the Account/Profile dropdown and logout
	     
	    Examples: 
	      | TID   | username  | password  | MemUserName     | memberType           |
	      | 15162 | qavgogine | qavgogine | q2_june_Cosmos_Seg078    | Terminated_header    |
	
############End of non regression scenarios###################
	
