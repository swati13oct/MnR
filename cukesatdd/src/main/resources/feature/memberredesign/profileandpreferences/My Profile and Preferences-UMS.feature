@accountProfile  @thePredators @regressionMember 
Feature: C1.2To test Profile and Preferences page 

  
    @accountProfile1 @ShipEndtoEnd  
	Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for Ship Members
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
	Then the user validates the Plan Name, Member name, Member ID and account section in UMS site                      
    And the ship user validates the need help section  														
	Then the user validates permanent address section   												
	Then the user validates the Phone section 
	 | Plan Type | <planType> |                                                         
    Then the user Clicks on the the Edit phone Link and validates the elements
    | Plan Type | <planType> | 							    
    Then the Ship user checks the Edit Button changes to Cancel Button                                     
    Then the user checks the functionality of save Button in Phoneeditsection                          
    Then the user validate the functionality of Cancel Button In phoneeditSection                      
    Then the user validate the temporary address section for ship member                                
	Then the user validates that  Communication Preferences section comes up for Ship Member          
    Then the user validates the Go Green page for a ship member                                         
	And the user validates see more ways to contact us section                                         
    And the user validates on clicking contact us link it should route to contact us page             
	
	Examples: 
     |  TID    | planType           |
     |  15103  | SHIP_ProfilePref   |
	  
	
  @accountProfile2 @MAPDandMAEndToEnd	
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for MAPD and MA Members
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
	Then the user validates the Plan Name, Member name, Member ID and account section in UMS site                   
    And the user validates the need help section  														
	Then the user validates permanent address section   												
	 Then the user validates the Phone section 
	  | Plan Type | <planType> |                                                         
    Then the user Clicks on the the Edit phone Link and validates the elements
     	| Plan Type | <planType> | 						    
    Then the user checks the Edit Button changes to Cancel Button                                       
    Then the user checks the functionality of save Button in Phoneeditsection                           
    Then the user validate the functionality of Cancel Button In phoneeditSection                       
    Then the user validate the temporary address section for  member                                
	And the user validates see more ways to contact us section                                          
    And the user validates on clicking contact us link it should route to contact us page               
	Examples: 
     |  TID   | planType  | memberType      			   |
     | 15083  | MAPD      | MAPD_GROUP_GOGreen_Profilepref |
	 | 15083  | MA        | MA_AARP_GOGreen_Profilepref    |
     | 15083  | PDP       | PDP_AARP_GOGreen_Profilepref   |
	  

     @accountProfile3 @NegativeTestonHSIDpage
     Scenario Outline:  TID: <TID> -Plan Type: <planType> - To verify all Negative tests on Password Edit on HSID PASSWORD Link Page
     Given login with following details logins in the member portal and validate elements
     | Member Type | <memberType> |
     When the user navigates to Profile and Preferences page
     And I click the HEALTHSAFE ID PASSWORD link and validate username and password
     Then the user clicks on save button without filling current and new password and the red mandatory message should come     
     #Then the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again 
	 Examples:  
		|  TID   | planType | memberType      			     |
		| 00000  | MAPD	    | MAPD_GROUP_GOGreen_Profilepref |
	    | 00000  | MA       | MA_AARP_GOGreen_Profilepref    |
        | 00000  | PDP      | PDP_AARP_GOGreen_Profilepref   |
	  
	
       @accountProfile4 @CommunicationPreferences
  Scenario Outline:  TID: <TID> -User Type: <userType> - To verify Communication Preferences section
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
	
	
	
	
	@accountProfile5 @US957739 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To verify  the sections on Profile and Preferences page for a NOKIA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Presence of edit button in email section
    Then the user validates the Presence of edit button in Phone section
    Then the user validates the Presence of edit button in Temporary Address section
    Then the user validates the Presence of edit button in Mailing Address section

    Examples: 
      |  TID    | planType | memberType |
     # | 00000   | MA       | NOKIA      |
     # | 00000   | MAPD     | NOKIA      |
	
	
	
	  @accountProfile6 @regressionPCPMedica @regressionMember 
    Scenario Outline:  TID: <TID> -User Type: <userType> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link    
    Then I should see the breadcrumb  in the upper left side of the page											
    And clicking the link should lead me back to the Account Settings page of the member site						
	And I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link												
	And the user validate the Email section in UMS site
    And the user fill new email address and click save then user should see new updated email on page
    And the user validates the Phone section
      | Member Type | <memberType> |
    And the user Clicks on the the Edit phone Link and validates the elements
      | Member Type | <memberType> |
    Then the user checks the functionality of save Button in Phoneeditsection
    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member
    And the user validates the address section
      | Member Type | <memberType> |

    Examples: 
     |  TID    | userType | memberType |
     | 15105   | PCP      | PCP_SouthFlorida_ProfilePref     |
     | 15107   | Medica   | Medica_SouthFlorida_ProfilePref  |
	
	
	 
	  @accountProfile7  @regressionAccountProf&Pref  @regressionMember 
  Scenario Outline:  TID: <TID> -User Type: <userType> -Member Type: <memberType> - To test end to end regression scenario for account profile page aarp member
    Given login with following details logins in the member portal and validate elements
      | User Type   | <userType>   |
      | member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And the user validates the Email section in UMS site
    | User Type   | <userType>   |
    | member Type | <memberType> |
    And the user validates the Phone section
    | User Type   | <userType>   |
    | member Type | <memberType> |
    And the user Clicks on the the Edit phone Link and validates the elements
    | User Type   | <userType>   |
    | member Type | <memberType> |
    Then the user validates Communication Preferences section
    And the user clicks on edit preferences link and validates the page
    And the user clicks on profile & preferences link to go back to Account settings page
    And the user validates the address section
    | User Type   | <userType>   |
    | member Type | <memberType> |

    Examples: 
     |  TID    | userType            | memberType |
     | 15083   | MAPD_AARPIndividual | AARP_ProfilePref      |
	
	
	 
	 @accountProfile8 @goGreen @regressionMember
  Scenario Outline:  TID: <TID> -User Type: <userType> -To verify Edit preferences section for Go Green
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
	
	
#-----------------------  Below All tests are EPMP ( Non regression) tests ---------------------------------------------------	
	
	@accountProfile10 @EPMPProfilePage
  Scenario Outline: To test end to end regression scenario for EPMP profile page
   #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should see the communicationpreferncessection

    Examples: 
      | planType | memberType  |
     # | MAPD     | EPMPEnabled |

  @accountProfile11 @EPMPProfilePageContactusInformation @regressionMember
  Scenario Outline: To test end to end regression scenario for EPMP profile page
  #Removed from Regression as EPMP is still in the pipeline for development
 	Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #|data type    | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page   
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers

    Examples: 
      | planType | memberType  | dataType   |
      #| MAPD     | EPMPEnabled | Individual |

  @accountProfile12 @EMPMprofilePageForShip  @regressionMember
  Scenario Outline: To test end to end regression scenario for EPMP profile page for ship
   #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validate the email section on profile page for ship member
    And the user validate the Phone section on profile page for ship member
    And the user validate the Permanent Address section on profile page for ship member
    And the user validate the temporary section on profile page for ship member
	
    Examples: 
      | planType |
      #| SHIP    |

  @accountProfile13 @EPMPProfilePageContactusGroup  @regressionMember
  Scenario Outline: To test end to end regression scenario for EPMP profile page for group members
   #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | data type   | <dataType>   |
    #|data type    | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should not be able to edit the Phone numbers section for specific group members
      | Group Plan Name | <GroupPlanName> |

    Examples: 
      | planType | memberType  | dataType | GroupPlanName  |
      #| MAPD     | EPMPEnabled | group    | HealthSelectRx |
	  
	
	 @accountProfile14 @profilePageForTerminated @regressionMember
  Scenario Outline: To test end to end regression scenario for account profile  page for a terminated member
 #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | data type   | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers
    Then the user validates that  Communication Preferences section doesn't come for terminated members

    Examples: 
      | planType | memberType  | dataType   |
    #  | MAPD     | EPMPEnabled | Terminated |

  @accountProfile15 @EPMPpreferencesForComboOnProfile  @regressionMember
  Scenario Outline: To test end to end regression scenario for account profile and preferences for a combo member
  #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Account Profile page and user validates the elements on individual tabs
    And I should see the combo tabs on Preferences page and user validates the elements on individual tabs

    Examples: 
      | planType | memberType  |
     # | Combo    | EPMPEnabled |
       #-----------------------  SHIP Preferences tests ---------------------------------------------------
  @F220921 @CommunicationPreferences
  Scenario Outline: TID: <TID> -User Type: <userType> - To verify Communication Preferences section for a SHIP member
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    Then the user validates the headers and labels of the communication preferences section for SHIP

    Examples: 
      | TID     | userType 				 |
      | F220921 | SHIP_ProfilePref |