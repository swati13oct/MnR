@branding
Feature: 1.14 Member Branding functionality

  @branding1 @regression @regression_branding @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that correct brand logos are displayed on Dashboard and Secondary Pages for members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that correct logo is displayed on the home page or test harness page
      | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard         | logoToBeDisplayedOnSecondaryPage    | Test Case                                                                    |
      | 15146 | MAPD     | AARPIndividual_Branding | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_01_Branding for AARP Plan member - Federal Member                         |
      | 15147 | SHIP     | SHIPOnly_Branding       | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_02_ Branding  for AARP Plan member - SHIP   Member                        |
      | 15153 | MEDICA   | Medica_Branding         | NON LIS       | images/branding/medicahealthcare.svg | dam/UCP/Images/logo/MEDICA.svg      | TC_08_ Branding for Branding for Medica Plan member                          |
      | 15152 | PCP      | PCP_Branding            | NON LIS       | images/branding/preferredcare.svg    | dam/UCP/Images/logo/PCP.svg         | TC_07_ Branding for Branding for PCP Plan member                             |
      | 15148 | MAPD     | Individual_Branding     | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg         | TC_05_ Branding for Branding for UHC Plan member                             |
      | 15151 | MAPD     | TEXASERS_Branding       | NON LIS       | images/branding/ers.svg              | dam/UCP/Images/logo/TEXAS%20ERS.svg | TC_06_ Branding for Texas ERS member                                         |
      | 15148 | MAPD     | ACTIVETERM_Branding     | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_03_ Branding for member with both active and termed plan with diff brands |
      | 15150 | MAPD     | UHCAARPCOMBO_Branding   | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_04_ Branding for Members with multiple active plans                       |

  @branding2 @regression @regression_branding @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that correct brand logos and cologos are displayed on Dashboard and Secondary Pages for Group members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that correct logo and cologo are displayed on the home page or test harness page
      | Dashboard Logo        | <logoToBeDisplayedOnDashboard>       |
      | Dashboard CoLogo      | <cologoToBeDisplayedOnDashboard>     |
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType        | copayCategory | logoToBeDisplayedOnDashboard     | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard      | cologoToBeDisplayedOnSecondaryPage                            | Test Case                                                  |
    # | 15154 | MAPD     | ALPEEHIP_Branding | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR15500/alpeehip.svg          | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg           | TC_09_ Co-branding for AL PEEHIP Plan member               |
      | 15155 | MAPD     | Villages_Branding | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MRH1045025/TheVillages-01.svg | dam/UCP/Images/Images/logos-cobranding/Villages.svg           | TC_10_ Co-branding for The Villages Individual Plan member |
      | 15156 | MAPD     | NCSHP_Branding    | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12309/NCSHP_Logo.svg        | dam/UCP/Images/Images/logos-cobranding/NCSHP_Logo.svg         | TC_11_ Co-branding for Group Retiree Plans                 |
     #| 15156 | MAPD     | Calpers_Branding  | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12775/CalPERS.svg           | dam/UCP/Images/Images/logos-cobranding/CalPERS_Logo_Large.svg | TC_11_ Co-branding for Group Retiree Plans                 |
      | 15156 | MAPD     | SHBP_Branding     | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12472/gadch.svg             | dam/UCP/Images/Images/logos-cobranding/SHBP.svg               | TC_11_ Co-branding for Group Retiree Plans                 |
