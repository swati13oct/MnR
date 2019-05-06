@accountPreferences  @thePredators @regressionMember 
Feature: C1.2To test Profile and Preferences page 

	@accountPreferences1 @CommunicationPreferences
    Scenario Outline: TID: <TID> -User Type: <userType> - To verify Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
	Then the user validates the presence of Communication preferences header                                   
    Then the user validates headers on green page                                                              
    Then the user validates the presence of Plan Name                                                         
    And the user validates Go paperless button and on clicking button go green page should come
	Then the user validates the I have read checkbox and check it                                            
    Then the user validates the Save Preferences Button                                                       
    Then the user validates the presence of Back to Profile and Preferences links          
                        
	Examples: 
      |  TID    | userType                       |
      | 15311   | MAPD_AARP_GOGreen_Profilepref  |
      | 15312   | MA_AARP_GOGreen_Profilepref    |
      | 15313   | PDP_AARP_GOGreen_Profilepref   |
	 
	@accountPreferences2 @goGreen @regressionMember
    Scenario Outline: TID: <TID> -User Type: <userType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link and validates the page
    Then the user changes the online preference and saves the change

    Examples: 
      |  TID    | userType                       |
      | 15311   | MAPD_AARP_GOGreen_Profilepref  |
      | 15312   | MA_AARP_GOGreen_Profilepref    |
      | 15313   | PDP_AARP_GOGreen_Profilepref   |
      | 15314   | MAPD_UHC_GOGreen_Profilepref   |
      | 15315   | MA_UHC_GOGreen_Profilepref     |
      | 15316   | MAPD_GROUP_GOGreen_Profilepref |
	

       #-----------------------  SHIP Preferences tests ---------------------------------------------------
    @accountPreferences3 @F220921 @CommunicationPreferences
    Scenario Outline: FID: <FID> -User Type: <userType> - To verify Communication Preferences section for a SHIP member
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    Then the user validates the headers and labels of the communication preferences section for SHIP

    Examples: 
      | FID    | userType         |
      | 220921 | SHIP_ProfilePref |