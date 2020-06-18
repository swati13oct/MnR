@accountProfileProfile @thePredators @F402311
Feature: 1.02.1 Member Profile page - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPProfileAndPreferences |

  @memAuth_accountProfile01 @accountProfileMicroApp01 @ShipEndtoEnd @AP_Part1_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for Ship Members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section
    #note: moved to footer feature
	#And the ship user validates the need help section
    Then the user validates permanent address section
    Then the user validates the Phone section
      | Plan Type | <memberType> |
#    Then the user Clicks on the the Edit phone Link and validates the elements
      | Plan Type | <memberType> |
#    Then the Ship user checks the Edit Button changes to Cancel Button
    Then the user checks the functionality of save Button in Phoneeditsection
      | Member Type | <memberType> |
#    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validate the temporary address section for ship member
    Then the user validates that  Communication Preferences section comes up for Ship Member
    Then the user validates the Go Green page for a ship member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID   | username  | password  | MemUserName        | planType | memberType       |
      | 15103 | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | SHIP_ProfilePref |

  @memAuth_accountProfile02 @MAPDandMAEndToEnd @AP_Part1_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for MAPD and MA Members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      #| Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    Then the user validates permanent address section
    #Then the user validates the Phone section with iframe
     # | Plan Type | <planType> |
    Then the user validate the temporary address section for  member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID     | username  | password  | MemUserName         |  memberType                     |
      | 15083_1 | qavgogine | qavgogine | q2_jun_grp0099      | MAPD_GROUP_GOGreen_Profilepref |
      | 15083_2 | qavgogine | qavgogine | q3_sep_UAT4_AARP203 | MA_AARP_GOGreen_Profilepref    |
      | 15083_3 | qavgogine | qavgogine | q2_jun_aarp0179     | PDP_AARP_GOGreen_Profilepref   |

  @memAuth_accountProfile04 @US957739 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To verify  the sections on Profile and Preferences page for a NOKIA member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Presence of edit button in email section
    Then the user validates the Presence of edit button in Phone section
    Then the user validates the Presence of edit button in Temporary Address section
    Then the user validates the Presence of edit button in Mailing Address section

    Examples:
      | TID   | username  | password  | MemUserName    | planType | memberType |
      | 00000 | qavgogine | qavgogine | q2_jun_grp0099 | MAPD     | NOKIA      |
    # | 00000   | MA       | NOKIA      |
    # | 00000   | MAPD     | NOKIA      |

  @memAuth_accountProfile05 @accountProfileMicroApp05 @regressionPCPMedica @regressionMember @AP_Part2_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
#    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
#    Then I should see the breadcrumb  in the upper left side of the page
#    And clicking the link should lead me back to the Account Settings page of the member site
#    And I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link
    And the user validate the Email section in UMS site
#    And the user fill new email address and click save then user should see new updated email on page
    And the user validates the Phone section
      | Member Type | <memberType> |
    And the user Clicks on the the Edit phone Link and validates the elements
      | Member Type | <memberType> |
    Then the user checks the Edit Button changes to Cancel Button
#    Then the user checks the functionality of save Button in Phoneeditsection
      | Member Type | <memberType> |
#    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member
    And the user validates the address section
      | Member Type | <memberType> |

    @mocked
    Examples:
      | TID   | username  | password  | MemUserName         | planType | memberType                      |
      | 15107 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020 | Medica   | Medica_SouthFlorida_ProfilePref |

    #  | 15105 | PCP-SouthFlorida-q2_jun_sofl0002        | PCP      | PCP_SouthFlorida_ProfilePref    |

  @memAuth_accountProfile06 @regressionAccountProf&Pref @AP_Part2_MemAuth @regressionMember
  Scenario Outline: TID: <TID> -User Type: <userType> -Member Type: <memberType> - To test end to end regression scenario for account profile page aarp member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
#    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
#    Then I should see the breadcrumb  in the upper left side of the page
#    And clicking the link should lead me back to the Account Settings page of the member site
    And the user validates the Email section in UMS site
      | User Type   | <userType>   |
      | member Type | <memberType> |
    And the user validates the Phone section
      | User Type   | <userType>   |
      | member Type | <memberType> |
#    And the user Clicks on the the Edit phone Link and validates the elements
      | User Type   | <userType>   |
      | member Type | <memberType> |
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    And the user clicks on profile & preferences link to go back to Account settings page
    And the user validates the address section
      | User Type   | <userType>   |
      | member Type | <memberType> |

    Examples:
      | TID   | username  | password  | MemUserName         | planType            | memberType       |
      | 15083 | qavgogine | qavgogine | q3_Sep_UAT4_Sofl020 | MAPD_AARPIndividual | AARP_ProfilePref |

  #-----------------------  Below All tests are EPMP ( Non regression) tests ---------------------------------------------------
  @memAuth_accountProfile07 @EPMPProfilePage
  Scenario Outline: TID: <TID> -To test end to end regression scenario for EPMP profile page
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the communication prefernces section
    And I should see the EPMP i frame on profile page

    Examples:
      | TID  | username  | password  | MemUserName | planType | memberType  |
      | xxxx | qavgogine | qavgogine | q4_dec_001  | MAPD     | EPMPEnabled |

  @memAuth_accountProfile08 @EPMPProfilePageContactusInformation @regressionMember @epmpfixed @AP_Part2_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for EPMP profile page
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers

    Examples:
      | TID       | username  | password  | MemUserName | planType | memberType  |
      | Unknown_4 | qavgogine | qavgogine | q4_dec_001  | MAPD     | EPMPEnabled |

  @memAuth_accountProfile09 @accountProfileMicroApp09 @EMPMprofilePageForShip @regressionMember
  Scenario Outline: Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile page for SHIP members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And the user validate the email section on profile page for ship member
    And the user validate the Phone section on profile page for ship member
    And the user validate the Permanent Address section on profile page for ship member
    And the user validate the temporary section on profile page for ship member

    Examples:
      | TID   | username  | password  | MemUserName        | planType | memberType       |
      | xxxxx | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | SHIP_ProfilePref |

  @memAuth_accountProfile10
  Scenario Outline: To test end to end regression scenario for EPMP profile page for group members
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should not be able to edit the Phone numbers section for specific group members
      | Group Plan Name | <GroupPlanName> |

    Examples:
      | TID   | username  | password  | MemUserName     | planType | memberType  |
      | xxxxx | qavgogine | qavgogine | q2_may_rally029 | MAPD     | EPMPEnabled |

  @accountProfile11 @profilePageForTerminated @regressionMember @epmpfixed @AP_Part3_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers
    Then the user validates that  Communication Preferences section doesn't come for terminated members

    Examples:
      | TID       | username  | password  | MemUserName     | planType | memberType  |
      | Unknown_5 | qavgogine | qavgogine | q2_may_rally019 | MAPD     | EPMPEnabled |

  @memAuth_accountProfile12
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To test end to end regression scenario for account profile and preferences for a combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Account Profile page and user validates the elements on individual tabs

    Examples:
      | TID       | username  | password  | MemUserName             | planType       | memberType              |
      | Unknown_6 | qavgogine | qavgogine | q3_sep_Active_combo_005 | Combo_PDP_SSUP | EPMPEnabled_ProfilePref |

  @memAuth_accountProfile13
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile and preferences for a Federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    #Then the user validates HEALTHSAFE ID PASSWORD & HEALTHSAFE ID ACCOUNT RECOVERY & SECURITY links
    #Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates Communication Preferences section
    #And the user validates sign up today link
    #Then the user validates the presence of Back to Profile and Preferences links
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username  | password  | MemUserName            | planType | memberType         |
      | Unknown_7  | qavgogine | qavgogine | indiPDPtestreg         | PDP      | PDP_AARPIndividual |
      | Unknown_8  | qavgogine | qavgogine | indiPDPtestreg   | GrpPDP   | PDP_Group          |
      | Unknown_9  | qavgogine | qavgogine | prema02                | MA       | MA_UHCIndividual   |
      | Unknown_10 | qavgogine | qavgogine | GroupMAPreeffective002 | MA       | MA_UHCGroup        |
      | Unknown_11 | qavgogine | qavgogine | q3_sep_UAT4_Group028   | MAPD     | MAPD_Group         |

  @memAuth_accountProfile14
  Scenario Outline: TID: <TID> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username  | password  | MemUserName     | planType | memberType |
      | Unknown_13 | qavgogine | qavgogine | q2_jun_sofl0002 | MA       | PCP        |

  @memAuth_accountProfile15
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #And I validate the healthsafe ID links
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for terminated members
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username  | password  | MemUserName     | planType | memberType        |
      | Unknown_15 | qavgogine | qavgogine | q2_may_rally029 | MAPD     | Terminated_AccPro |

  @accountProfile16 @AP_Part5_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
   # Then the user validates permanent address section
	 # And the user verifies the Temporary Address Link on the Account settings page
    And the user validates the address sectioning

    Examples:
      | TID        | username  | password  | MemUserName    | planType | memberType |
      | Unknown_16 | qavgogine | qavgogine | q2_jun_uhc0032 | GOVT     | AP_ADDRESS |

  @accountProfile17 @HsidLogin @codetransformers  @AP_Part5_MemAuth
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Verify HSID login functionality.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then I validate that login is successfull

    @accountProfile17a
    Examples:
      | TID        | planType | memberType | copayCategory       |
      | Unknown_17 | MA       | Individual | NON LIS_ProfilePref |
      | Unknown_18 | PDP      | Individual | NON LIS_ProfilePref |
      | Unknown_19 | MAPD     | Individual | NON LIS_ProfilePref |

    @accountProfile17b
    Examples:
      | TID        | planType  | memberType | copayCategory       |
      | Unknown_20 | PCP       | Individual | NON LIS_ProfilePref |
      | Unknown_21 | Medica    | Individual | NON LIS_ProfilePref |
      | Unknown_22 | MAGroup   | Group      | NON LIS_ProfilePref |
      | Unknown_23 | MAPDGroup | Group      | NON LIS_ProfilePref |

    @accountProfile17c
    Examples:
      | TID        | planType  | memberType | copayCategory       |
      | Unknown_24 | PDPGroup  | Group      | NON LIS_ProfilePref |
      | Unknown_25 | SHIP      | ShipOnly   | NON LIS_ProfilePref |
      | Unknown_26 | COMBO     | FedShip    | NON LIS_ProfilePref |
      | Unknown_27 | SSUPGroup | Group      | NON LIS_ProfilePref |

  @accountProfile18
  Scenario Outline: -memberType: <memberType> - Validate that member is successfully getting logged in to Rally Dashboard for memberType <memberType>
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home pag
    Then User should be able to validate Dashboard elemt

    @accountProfile18a
    Examples:
      | memberType                     | friendname | favcolor | phonenumber |
      | MAIndividualCOSMOS_ProfilePref | name1      | color1   | number1     |
      | MAPDNICE_ProfilePref           | name1      | color1   | number1     |
      | MANICE_ProfilePref             | name1      | color1   | number1     |
      | MAPDCOSMOS_ProfilePref         | name1      | color1   | number1     |

    @accountProfile18b
    Examples:
      | memberType               | friendname | favcolor | phonenumber |
      | AARPPDP_ProfilePref      | name1      | color1   | number1     |
      | ACTIVEPCP_ProfilePref    | name1      | color1   | number1     |
      | ACTIVEMedica_ProfilePref | name1      | color1   | number1     |
      | GROUPMA_ProfilePref      | name1      | color1   | number1     |

    @accountProfile18c
    Examples:
      | memberType              | friendname | favcolor | phonenumber |
      | GROUPMAPD_ProfilePref   | name1      | color1   | number1     |
      | GROUPDP_ProfilePref     | name1      | color1   | number1     |
      | GROUPSSUP_ProfilePref   | name1      | color1   | number1     |
      | GROUPDPSSUP_ProfilePref | name1      | color1   | number1     |

    @accountProfile18d
    Examples:
      | memberType                      | friendname | favcolor | phonenumber |
      | PREACTIVEGRP_ProfilePref        | name1      | color1   | number1     |
      | ACTIVEGOVTSHIPCOMBO_ProfilePref | name1      | color1   | number1     |
      | MULTIGOVPRETERM_ProfilePref     | name1      | color1   | number1     |
      | ACTIVEPRESHIP_ProfilePref       | name1      | color1   | number1     |

    @memAuth_accountProfile018e
    Examples:
      | memberType                         | friendname | favcolor | phonenumber |
      | ACTIVESHIP_ProfilePref             | name1      | color1   | number1     |
      | PRESHIP_ProfilePref                | name1      | color1   | number1     |
      | ACTIVETERMFEDSHIPCOMBO_ProfilePref | name1      | color1   | number1     |
      | MICROMULTIFEDSHIP_ProfilePref      | name1      | color1   | number1     |

    @accountProfile18f
    Examples:
      | memberType                      | friendname | favcolor | phonenumber |
      | MULTIFEDACTIVE_ProfilePref      | name1      | color1   | number1     |
      | FEDSHIPPREEFFECTIVE_ProfilePref | name1      | color1   | number1     |
      | MAPREFFECTIVE_ProfilePref       | name1      | color1   | number1     |
      | MAPDPREFFECTIVE_ProfilePref     | name1      | color1   | number1     |

    @accountProfile18g
    Examples:
      | memberType                     | friendname | favcolor | phonenumber |
      | PDPPREFFECTIVE_ProfilePref     | name1      | color1   | number1     |
      | GRPMAPREFFECTIVE_ProfilePref   | name1      | color1   | number1     |
      | GRPMAPDPREFFECTIVE_ProfilePref | name1      | color1   | number1     |
      | SSUPPREFFECTIVE_ProfilePref    | name1      | color1   | number1     |

    @accountProfile18h
    Examples:
      | memberType                    | friendname | favcolor | phonenumber |
      | GRPPDPPREFFECTIVE_ProfilePref | name1      | color1   | number1     |
      | GRPDPSSUP_ProfilePref         | name1      | color1   | number1     |


  @memAuth_accountProfile019
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for Ship Members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section
    #note: moved to footer feature
	#And the ship user validates the need help section
    Then the user validates permanent address section
    Then the user validates the Phone section
      | Plan Type   | <memberType> |
#    Then the user Clicks on the the Edit phone Link and validates the elements
      | Plan Type   | <memberType> |
#    Then the Ship user checks the Edit Button changes to Cancel Button
#    Then the user checks the functionality of save Button in Phoneeditsection
      | Member Type | <memberType> |
#    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validate the temporary address section for ship member
    Then the user validates that  Communication Preferences section comes up for Ship Member
    Then the user validates the Go Green page for a ship member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID   | username  | password  | MemUserName        | planType | memberType       |
      | 15103 | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | SHIP_ProfilePref |
	    
	    