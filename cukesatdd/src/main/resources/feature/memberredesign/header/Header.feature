@header @thePredators @member_redesign
Feature: 1.08 Member Header/Navigation validation

  # note: if system is in future date, some testcases may fail due to expected tab(s) not showing up on page depending on user's data setup
  @header01 @mapd_header @member_redesign_header @regressionMember @headerRegression
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify HSID login functionality and header
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      |Flow         | <flow>       |
    #When the above plantype user logs in UMS Site Desktop Header
    #And I view the global navigation Header
    #Then I should be able to see and use the Home tab Header
    Then I should be able to see and use the Find Care & Costs tab Header
    Then I should be able to see and use the Claims tab Header
    And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
    And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
    And clicking on the Coverage & Benefits tab should allow me to see links for the Benefits Summary tab, the Forms & Resources tab and Order materials tab on the second level navigation Header
    And then click the Forms & Resources tab and I should be directed to the Forms & Resources Page Header
    And then click the Order Materials tab and I should be directed to the Order Materials Page Header
    Then I should be able to see and use the Premium Payments tab Header
    Then I should be able to see and use the pharmacies tab in the header
    Then I should be able to see and use the health and wellness tab in the header
    Then I should be able to see the help button Header
    Then I should be able to see and use the Account/Profile dropdown and logout

    Examples: 
      | TID   | planType | memberType    | flow  |
      | 15164 | MAPD     | Individual    | header|
      | 15164 | PDP      | Individual    | header|
      | 15164 | PCP      | Individual    | header|
     

  @header02 @premiumpaymentsheader @regressionMember 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check the Premium Payments Tab in the header
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	    Then I should be able to see and use the Premium Payments tab Header
		
			@headerRegression
	    Examples: 
	      | TID   | planType | memberType              |
	      | 15252 | MAPD     | GroupLessSubsidy_header |
	    
	    @F287624 @US2037787 @US2037966
	    Examples: 
	      | TID       | planType    | memberType                    |
	      | US2037787 | PDP_SSP     | comboAllNot100Subsidy_header  |
	      | US2037966 | PDP_SSP     | comboSomeHas100Subsidy_header |

  @header03 @premiumpaymentsheader_100%subisdy @regressionMember 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Premium Payments Tab is not displayed in the header
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	    Then I should not be able to see the Premium Payments tab Header
	 
	 		@headerRegression
	    Examples: 
	      | TID   | planType | memberType | 
	      | 15253 | MAPD     | IndividualGroup_header  | 
	
	    @F287624 @US2037783 @US2037945 
	    Examples: 
	      | TID       | planType    | memberType                |
	      | US2037783 | PDP_SSP     | comboAll100Subsidy_header |

@header05 @no_findcareheader @regressionMember @headerRegression
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	      | Flow	| <flow> |
	    #And I view the global navigation Header
	    Then I should not be able to see the Find Care & Costs tab Header
			
	    Examples: 
	      | TID   | planType | memberType | flow   |
	      | 15251 | SHIP     | Medsupp    | header |

  @header06 @terminated @regressionMember @headerRegression 
  Scenario Outline: TID: <TID> -plan: Any -memberType: <memberType> - To check that the Find Care and Costs Tab is not displayed in the header for terminated user
	    Given login with following details logins in the member portal and validate elements
	      | Member Type | <memberType> |
	    Then I should be able to see and use the Claims tab Header
	     And clicking on the Claims tab should allow me to see links for the Claims Summary tab and Explanation of Benefits tab on the second level navigation Header
       And then click the Explanation of Benefits tab and I should be directed to the Explanation of Benefits Page Header
       And clicking on the Coverage & Benefits tab should allow me to see link of for the Forms & Resources tab on the second level navigation Header
	     Then I should be able to see the help button Header
       Then I should be able to see and use the Account/Profile dropdown and logout
	     
	    Examples: 
	      | TID   | memberType           |
	      | 15162 | Terminated_header    |  
	
	
	############End of regression scenarios###################
	
#############################TO Be deleted###################################################
######################Already covered in   @header01 #######################
	  @header04 @findcarecostsheader 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is displayed in the header
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	    And I view the global navigation Header
	    Then I should be able to see and use the Find Care & Costs tab Header
	
	    Examples: 
	      | TID   | planType | memberType   |
	      | 15171 | MAPD     | GROUP_header |
	      | 15171 | MAPD     | IND_header   |
	      | 15171 | PCP      | IND_header   |
	      | 15171 | MEDICA   | IND_header   |