Feature: To test branding functionality

  @regression @regression_branding @regression_06_06_18
  Scenario Outline: Verify that correct brand logos are displayed on Dashboard and Secondary Pages for members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that correct logo is displayed on the home page
      | Dashboard Logo | <logoToBeDisplayedOnDashboard> |
    And user clicks on benefits and coverage tab on home page
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
       | planType | memberType | copayCategory | logoToBeDisplayedOnDashboard     | logoToBeDisplayedOnSecondaryPage              | Test Case                                                                    |
       | SHIP     | SHIPOnlyBranding | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_02_ Branding for AARP Plan member - SHIP   Member                         |
      | MAPD     | PCP              | NON LIS       | images/branding/preferredcare.svg    | dam/UCP/Images/logo/PCP.svg         | TC_07_ Branding for Branding for PCP Plan member                             |
      | MAPD     | TEXASERS         | NON LIS       | images/branding/ers.svg              | dam/UCP/Images/logo/TEXAS%20ERS.svg | TC_06_ Branding for Texas ERS member                                         |
      | MAPD     | ACTIVETERM       | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg         | TC_03_ Branding for member with both active and termed plan with diff brands |
       | MA       | PPO              | NON LIS       | images/branding/aarp.svg             | dam/UCP/Images/logo/AARP.svg        | TC_04_ Branding for Members with multiple active plans                       |

  @regression @regression_branding @regression_06_06_18
  Scenario Outline: Verify that correct brand logos and cologos are displayed on Dashboard and Secondary Pages for Group members.
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that correct logo and cologo are displayed on the home page
      | Dashboard Logo   | <logoToBeDisplayedOnDashboard>   |
      | Dashboard CoLogo | <cologoToBeDisplayedOnDashboard> |
    And user clicks on benefits and coverage tab on home page
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | planType | memberType | copayCategory | logoToBeDisplayedOnDashboard     | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard      | cologoToBeDisplayedOnSecondaryPage                            | Test Case                                                  |
      | MAPD     | ALPEEHIP   | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR15500/alpeehip.svg          | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg           | TC_09_ Co-branding for AL PEEHIP Plan member               |
     | MAPD     | Villages   | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MRH1045025/TheVillages-01.svg | dam/UCP/Images/Images/logos-cobranding/Villages.svg           | TC_10_ Co-branding for The Villages Individual Plan member |
     | MAPD     | NCSHP      | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12309/NCSHP_Logo.svg        | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg           | TC_11_ Co-branding for Group Retiree Plans                 |
     | MAPD     | Calpers    | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12775/CalPERS.svg           | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg           | TC_11_ Co-branding for Group Retiree Plans                 |
      | MAPD     | SHBP       | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | optum/MR12472/gadch.svg             | dam/UCP/Images/Images/logos-cobranding/SHBP.svg               | TC_11_ Co-branding for Group Retiree Plans                 |
