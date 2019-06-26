@accountPreferences @thePredators @regressionMember 
Feature: C1.2To test Profile and Preferences page 

	@accountPreferences1 @CommunicationPreferences
    Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
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
      |  TID    | planType                       |
      | 15311   | MAPD_AARP_GOGreen_Profilepref  |
      | 15312   | MA_AARP_GOGreen_Profilepref    |
      | 15313   | PDP_AARP_GOGreen_Profilepref   |
	 
	@accountPreferences2 @goGreen @regressionMember
    Scenario Outline: TID: <TID> -Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link and validates the page
    Then the user changes the online preference and saves the change

    Examples: 
      | TID     | planType                       |
      | 15311   | MAPD_AARP_GOGreen_Profilepref  |
      | 15312   | MA_AARP_GOGreen_Profilepref    |
      | 15313   | PDP_AARP_GOGreen_Profilepref   |
      | 15314   | MAPD_UHC_GOGreen_Profilepref   |
      | 15315   | MA_UHC_GOGreen_Profilepref     |
      | 15316   | MAPD_GROUP_GOGreen_Profilepref |
	

    #-----------------------  SHIP Preferences tests ---------------------------------------------------
    @accountPreferences3 @F220921 @CommunicationPreferences
    Scenario Outline: FID: <FID> -Plan Type: <planType> - To verify Communication Preferences section for a SHIP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    Then the user validates the headers and labels of the communication preferences section for SHIP

    Examples: 
      | FID    | planType         |
      | 220921 | SHIP_ProfilePref |
      
  @F276629
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Verify Plan documents and Welcome kit for SHIP
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    Then the user navigates to Communication Preferences page
    Then the user validates that Communication Preferences section for Ship
      | Plan Name | <planName> |
    And the user select "electronic delivery" for "Plan Documents"

    #And the user click Terms and Conditions check box
    #And the user click on the Save Preferences button
    #Then a popup is displayed and validate the popup
    #And select Yes and Validate the success message
    Examples: 
      | FID    | planType | memberType          | planName                  |
      | 276629 | Medsupp  | SHIPAccountSettings | AARP MEDICARE SELECT PLAN |     
      
     @vbfGate
    Scenario Outline:Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And the user validates preferences page for non epmp

    Examples: 
     | memberType          |
     | AARPMapdNonEPMP  | 
     
      @vbfGate
    Scenario Outline:Plan Type: <planType> -To verify Plan Name, Member name, Member ID and account section
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section in UMS site
    And I validate the healthsafe ID links
    And I should see the communication prefernces section
    
      Examples: 
     | memberType          |
     | AARPMapdNonEPMP  | 