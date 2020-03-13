@accountProfile @thePredators @Total_Regression_Devided_into_5Parts
Feature: 1.02 Member Profile page

  @accountProfile1 @ShipEndtoEnd @AP_Part1_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for Ship Members
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section
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
      | TID   | planType          |
      | 15103 | SHIP_ProfilePref  |

  @accountProfile2 @MAPDandMAEndToEnd @AP_Part1_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for MAPD and MA Members
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
 #   And the user validates the need help section
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
      | TID     | planType | memberType                     |
      | 15083_1 | MAPD     | MAPD_GROUP_GOGreen_Profilepref |
      | 15083_2 | MA       | MA_AARP_GOGreen_Profilepref    |
      | 15083_3 | PDP      | PDP_AARP_GOGreen_Profilepref   |

  @accountProfile3 @NegativeTestonHSIDpage @AP_Part1_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify all Negative tests on Password Edit on HSID PASSWORD Link Page
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
    Then the user clicks on save button without filling current and new password and the red mandatory message should come

    #Then the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again
    Examples: 
      | TID      | planType | memberType                     |
      | Unknown1 | MAPD     | MAPD_GROUP_GOGreen_Profilepref |
      | Unknown2 | MA       | MA_AARP_GOGreen_Profilepref    |
      | Unknown3 | PDP      | PDP_AARP_GOGreen_Profilepref   |

  @accountProfile4 @US957739 @regressionMember
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
      | TID | planType | memberType |

  # | 00000   | MA       | NOKIA      |
  # | 00000   | MAPD     | NOKIA      |
  @accountProfile5 @regressionPCPMedica @regressionMember @AP_Part2_Regression
  Scenario Outline: TID: <TID> -User Type: <userType> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
    Given login with following details logins in the member portal and validate elements
      | User Type   | <userType>   |
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
      | TID   | userType | memberType                      |
      | 15105 | PCP      | PCP_SouthFlorida_ProfilePref    |
      | 15107 | Medica   | Medica_SouthFlorida_ProfilePref |

  @accountProfile6 @regressionAccountProf&Pref @regressionMember @AP_Part2_Regression
  Scenario Outline: TID: <TID> -User Type: <userType> -Member Type: <memberType> - To test end to end regression scenario for account profile page aarp member
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
    Then the user clicks on edit preferences link page for ship
    And the user clicks on profile & preferences link to go back to Account settings page
    And the user validates the address section
      | User Type   | <userType>   |
      | member Type | <memberType> |

    Examples: 
      | TID   | userType            | memberType       |
      | 15083 | MAPD_AARPIndividual | AARP_ProfilePref |

  #-----------------------  Below All tests are EPMP ( Non regression) tests ---------------------------------------------------
  @accountProfile7 @EPMPProfilePage
  Scenario Outline: To test end to end regression scenario for EPMP profile page
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should see the communicationpreferncessection

    Examples: 
      | planType | memberType |

  # | MAPD     | EPMPEnabled |
  @accountProfile8 @EPMPProfilePageContactusInformation @regressionMember @epmpfixed @AP_Part2_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for EPMP profile page
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | data type   | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers

    Examples: 
     | TID       | planType | memberType  | dataType   |
     | Unknown_4 | MAPD     | EPMPEnabled | Individual |

  @accountProfile9 @EMPMprofilePageForShip @regressionMember
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
  @accountProfile10 @EPMPProfilePageContactusGroup @regressionMember
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
      | planType | memberType | dataType | GroupPlanName |

  #| MAPD     | EPMPEnabled | group    | HealthSelectRx |
  @accountProfile11 @profilePageForTerminated @regressionMember @epmpfixed @AP_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
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
     | TID			 | planType | memberType  | dataType   |
     | Unknown_5 | MAPD     | EPMPEnabled | Terminated |

  @accountProfile12 @ComboAccountSettings @regressionMember @codetransformers @AP_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To test end to end regression scenario for account profile and preferences for a combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Account Profile page and user validates the elements on individual tabs

    Examples: 
      | TID			   | planType       | memberType             |
      | Unknown_6  | Combo_PDP_SSUP | PDP_SSUPcombo          |
  

  @AccountProfile13   @CTRegressionAccountProfile_FederalMembers @regressionMember @codetransformers @AP_Part3_Regression
   Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile and preferences for a Federal member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Copay Category | <copayCategory> |
     Then the user navigates to Profile and Preferences page     
     Then the user validates HEALTHSAFE ID PASSWORD & HEALTHSAFE ID ACCOUNT RECOVERY & SECURITY links
	   Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
	   Then the email address section should be verified
	   Then the Phone Numbers section should be validated & all links clicked
	   Then the user validates permanent address section
	   And the user verifies the Temporary Address Link on the Account settings page
	   Then the user validates Communication Preferences section
	   And the user validates sign up today link
	   Then the user validates the presence of Back to Profile and Preferences links 	    
	   And the user validates see more ways to contact us section                                          
     And the user validates on clicking contact us link it should route to contact us page  
	  
     Examples: 
      | TID			    | planType  | memberType              | copayCategory |
      | Unknown_7   | PDP       | PDP_AARPIndividual      | NON LIS       |
      | Unknown_8   | GrpPDP    | PDP_Group               | NON LIS       |
      | Unknown_9   | MA        | MA_UHCIndividual        | NON LIS       |
      | Unknown_10  | MA        | MA_UHCGroup             | NON LIS       |
      | Unknown_11  | MAPD      | MAPD_Group              | NON LIS       |
      | Unknown_12  | MAPD      | MAPD_Individual         | NON LIS       | 
      
      
    @AccountProfile14  @RegressionAccountProfile_PCP_MEDICA @regressionMember @codetransformers @AP_Part4_Regression
    Scenario Outline: TID: <TID> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
     Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Copay Category | <copayCategory> |
    Then the user navigates to Profile and Preferences page  
	  Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
	  Then the email address section should be verified
    Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
	  And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member 
    And the user validates see more ways to contact us section                                          
    And the user validates on clicking contact us link it should route to contact us page
    Examples: 
       | TID			  | planType    | memberType            | copayCategory  |
       | Unknown_13 | MA          | PCP                   | NON LIS        |
       | Unknown_14 | MA          | MA_UHCIndividual       | NON LIS        |
      
       
     @accountProfile15 @profilePageForTerminated @regressionMember @epmpfixed @AP_Part4_Regression
    Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Copay Category | <copayCategory> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    And I validate the healthsafe ID links    
    Then the email address section should be verified
    Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
	  And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for terminated members
    And the user validates see more ways to contact us section                                          
    And the user validates on clicking contact us link it should route to contact us page
    Examples:      
     | TID			  | planType | memberType        | copayCategory   |
     | Unknown_15 | MAPD     | Terminated_AccPro | NON LIS |
     
      @accountProfile16 @AP_Part5_Regression
    Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Copay Category | <copayCategory> |
    Then the user navigates to Profile and Preferences page
   # Then the user validates permanent address section
	 # And the user verifies the Temporary Address Link on the Account settings page
	  And the user validates the address sectioning
     
	    Examples:      
      | TID			   | planType | memberType        | copayCategory   |
      | Unknown_16 | GOVT     | AP_ADDRESS        | NON LIS         |
      
    @accountProfile17 @HsidLogin @regressionMember @codetransformers  @AP_Part5_Regression
   Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Verify HSID login functionality.
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then I validate that login is successfull  
   Examples:
    | TID			   | planType  |  memberType  | copayCategory | 
    | Unknown_17 | MA        |  Individual  |  NON LIS      |
    | Unknown_18 | PDP       |  Individual  |  NON LIS      |
    | Unknown_19 | MAPD      |  Individual  |  NON LIS      |
    | Unknown_20 | PCP       |  Individual  |  NON LIS      |
    | Unknown_21 | Medica    |  Individual  |  NON LIS      |  
    | Unknown_22 | MAGroup   |  Group       |  NON LIS      |
    | Unknown_23 | MAPDGroup |  Group       |  NON LIS      | 
    | Unknown_24 | PDPGroup  |  Group       |  NON LIS      | 
    | Unknown_25 | SHIP      |  ShipOnly    |  NON LIS      | 
    | Unknown_26 | COMBO     | FedShip      |  NON LIS      |
    | Unknown_27 | SSUPGroup |Group         |  NON LIS      |
   
   @microLogin
  Scenario Outline: Validate that member is successfully getting logged in to Rally Dashboard for memberType <memberType>
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in 
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
   Then member should navigate to Home pag  
   Then User should be able to validate Dashboard elemt    
    Examples: 
       | memberType          | friendname | favcolor | phonenumber |
       | MAIndividualCOSMOS  | name1      | color1   | number1     |
       | MAPDNICE            | name1      | color1   | number1     |
       | MANICE              | name1      | color1   | number1     |
       | MAPDCOSMOS          | name1      | color1   | number1     |
       | AARPPDP             | name1      | color1   | number1     |
       | ACTIVEPCP           | name1      | color1   | number1     |
       | ACTIVEMedica        | name1      | color1   | number1     |
       | GROUPMA             | name1      | color1   | number1     |
       | GROUPMAPD           | name1      | color1   | number1     |
       | GROUPDP             | name1      | color1   | number1     |
       |  GROUPSSUP          | name1      | color1   | number1     |
       |  GROUPDPSSUP        | name1      | color1   | number1     |
       |  PREACTIVEGRP       | name1      | color1   | number1     |
       | ACTIVEGOVTSHIPCOMBO | name1      | color1   | number1     |
       |  MULTIGOVPRETERM    | name1      | color1   | number1     |
       |  ACTIVEPRESHIP      | name1      | color1   | number1     |
       |  ACTIVESHIP         | name1      | color1   | number1     |
       |  PRESHIP            | name1      | color1   | number1     |
       |ACTIVETERMFEDSHIPCOMBO | name1    | color1   | number1     |
       |  MICROMULTIFEDSHIP  | name1      | color1   | number1     |
       | MULTIFEDACTIVE      | name1      | color1   | number1     |         
       | FEDSHIPPREEFFECTIVE | name1      | color1   | number1     |    
       |  MAPREFFECTIVE      | name1      | color1   | number1     |
       |  MAPDPREFFECTIVE    | name1      | color1   | number1     |
       | PDPPREFFECTIVE      | name1      | color1   | number1     |  
       | GRPMAPREFFECTIVE    | name1      | color1   | number1     |  
       | GRPMAPDPREFFECTIVE  | name1      | color1   | number1     |  
       |  SSUPPREFFECTIVE    | name1      | color1   | number1     |  
       |  GRPPDPPREFFECTIVE  | name1      | color1   | number1     |  
       |  GRPDPSSUP          | name1      | color1   | number1     |  
  