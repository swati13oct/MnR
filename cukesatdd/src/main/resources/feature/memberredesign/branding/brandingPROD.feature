Feature: 1.14 Member Branding functionality

  @regressionMemberPROD1
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo is displayed on the home page or test harness page
    #  | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             | username | password | member                |
      | 15146 | MAPD     | AARPIndividual_Branding | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_01_Branding for AARP Plan member - Federal Member  | jkuma14  | Brock@05 | TELGUY1@HOTMAIL.COM   |
      | 15147 | SHIP     | SHIPOnly_Branding       | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_02_ Branding  for AARP Plan member - SHIP   Member | jkuma14  | Brock@05 | Pramila1946           |
      | 15153 | MEDICA   | Medica_Branding         | NON LIS       | MEDICA                       | dam/UCP/Images/logo/MEDICA.svg   | TC_03_ Branding for Branding for Medica Plan member   | jkuma14  | Brock@05 | TCZUNIGA52 |


  @regressionMemberPROD2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo is displayed on the home page or test harness page
    #  | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             | username | password | member                |
      | 15152 | PCP      | PCP_Branding            | NON LIS       | PCP                          | dam/UCP/Images/logo/PCP.svg      | TC_04_ Branding for Branding for PCP Plan member      | jkuma14  | Brock@05 | marylamb823           |
      | 15148 | MAPD     | Individual_Branding     | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | TC_05_ Branding for Branding for UHC Plan member      | jkuma14  | Brock@05 | mgcirolia@gmail.com   |


  @regressionMemberPROD2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
    And the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo is displayed on the home page or test harness page
    #  | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType        | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage  | Test Case                            | username | password | member     |
      | 15151 | MAPD     | TEXASERS_Branding | NON LIS       | TEXASERS                     | dam/UCP/Images/logo/TX-ERSNew.svg | TC_06_ Branding for Texas ERS member | jkuma14  | Brock@05 | lanecarolb |

  @regressionMemberPROD3
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo and cologo are displayed on the home page or test harness page
    #  | Dashboard Logo        | <logoToBeDisplayedOnDashboard>       |
    #  | Dashboard CoLogo      | <cologoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
    #  | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard | cologoToBeDisplayedOnSecondaryPage                    | Test Case                                                                   | username | password | member                    |
      | 15155 | MAPD     | Villages_Branding       | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | Villages                       | dam/UCP/Images/Images/logos-cobranding/Villages.svg   | TC_07_ Co-branding for The Villages Individual Plan member                  | jkuma14  | Brock@05 | 33Healthyme               |
      | 15157 | MAPD     | SHBP_Branding           | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | SHBP                           | dam/UCP/Images/Images/logos-cobranding/SHBP.svg       | TC_08_ Co-branding for Group Retiree Plans- SHBP_Branding                   | jkuma14  | Brock@05 | Andersonga1@Bellsouth.Net |
      | 15158 | MAPD     | MCHCP_Branding          | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | MCHCP                          | dam/UCP/Images/logo/StofMO_Rally_Logo.svg             | TC_09_ Co-branding for Group Retiree Plans- MCHCP_Branding                  | jkuma14  | Brock@05 | Brooklynn12               |
      
 @regressionMemberPROD4
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo and cologo are displayed on the home page or test harness page
    #  | Dashboard Logo        | <logoToBeDisplayedOnDashboard>       |
    #  | Dashboard CoLogo      | <cologoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
    #  | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard | cologoToBeDisplayedOnSecondaryPage                    | Test Case                                                                   | username | password | member                    |
      | 15158 | MAPD     | universityofkentuckySSO | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | UniversityOfKentucky           | dam/UCP/Images/logo/UofKY_Rally_Logo.svg              | TC_10_ Co-branding for Group Retiree Plans- University of Kentucky_Branding | jkuma14  | Brock@05 | ExDesertrat               |
#     | 15156 | MAPD     | NCSHP_Branding          | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | NCSHP                          | dam/UCP/Images/Images/logos-cobranding/NCSHP_Logo.svg | TC_11_ Co-branding for Group Retiree Plans -NCSHP_Branding                  | jkuma14  | Brock@05 | dianahdavis@bellsouth.net |
#     | 15156 | MAPD     | Calpers_Branding  | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | optum/MR12775/CalPERS.svg      | dam/UCP/Images/Images/logos-cobranding/CalPERS_Logo_Large.svg | TC_12_ Co-branding for Group Retiree Plans         |jkuma14  | Brock@05 | skho@roadrunner.com   |
#     | 15154 | MAPD     | ALPEEHIP_Branding | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | optum/MR15500/alpeehip.svg     | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg   | TC_13_ Co-branding for AL PEEHIP Plan member               |jkuma14  | Brock@05 | skho@roadrunner.com   |


 @regressionMemberPROD4
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo and cologo are displayed on the home page or test harness page
    #  | Dashboard Logo        | <logoToBeDisplayedOnDashboard>       |
    #  | Dashboard CoLogo      | <cologoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
    #  | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And Terminated user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard | cologoToBeDisplayedOnSecondaryPage                    | Test Case                                                                   | username | password | member                    |
      | 15156 | MAPD     | NCSHP_Branding          | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | NCSHP                          | dam/UCP/Images/Images/logos-cobranding/NCSHP_Logo.svg | TC_11_ Co-branding for Group Retiree Plans -NCSHP_Branding                  | jkuma14  | Brock@05 | dianahdavis@bellsouth.net |
#     | 15156 | MAPD     | Calpers_Branding        | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | optum/MR12775/CalPERS.svg      | dam/UCP/Images/Images/logos-cobranding/CalPERS_Logo_Large.svg | TC_12_ Co-branding for Group Retiree Plans                          |jkuma14  | Brock@05  | skho@roadrunner.com   |
#     | 15154 | MAPD     | ALPEEHIP_Branding       | NON LIS       | UHC                          | dam/UCP/Images/logo/UHC.svg      | optum/MR15500/alpeehip.svg     | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg   | TC_13_ Co-branding for AL PEEHIP Plan member                                |jkuma14  | Brock@05  | skho@roadrunner.com   |
      
 @sanityMemberPROD1
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo is displayed on the home page or test harness page
    #  | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             | username | password | member                |
      | 15147 | SHIP     | SHIPOnly_Branding       | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_02_ Branding  for AARP Plan member - SHIP   Member | jkuma14  | Brock@05 | Pramila1946           |

 @sanityMemberPROD2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    #And verify that correct logo is displayed on the home page or test harness page
    #  | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
    #  | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             | username | password | member                |
      | 15152 | PCP      | PCP_Branding            | NON LIS       | PCP                          | dam/UCP/Images/logo/PCP.svg      | TC_04_ Branding for Branding for PCP Plan member      | jkuma14  | Brock@05 | marylamb823           |
