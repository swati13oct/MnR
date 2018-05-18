Feature: To test branding functionality

  @regression @regression_branding
  Scenario Outline: Verify HSID login functionality.
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
          | planType | memberType    | copayCategory | logoToBeDisplayedOnDashboard     | logoToBeDisplayedOnSecondaryPage | Test Case                                           |
      #1  | MAPD     | AARPIndividual | NON LIS       |images/branding/aarp.svg      | dam/UCP/Images/logo/AARP.svg   | TC_01_Branding for AARP Plan member - Federal Member|
      #2  | SHIP     | SHIPOnlyBranding| NON LIS       |images/branding/aarp.svg      | dam/UCP/Images/logo/AARP.svg   |TC_02_ Branding for AARP Plan member - SHIP   Member|
      #8  | MAPD     | Medica   | NON LIS       |images/branding/medicahealthcare.svg      | dam/UCP/Images/logo/MEDICA.svg   |TC_08_ Branding for Branding for Medica Plan member|
      #7  | MAPD     | PCP      | NON LIS       |images/branding/preferredcare.svg      | dam/UCP/Images/logo/PCP.svg   |TC_08_ Branding for Branding for Medica Plan member|
          | MAPD     | UHCIndividual | NON LIS       | images/branding/unitedhealth.svg | dam/UCP/Images/logo/UHC.svg      | TC_08_ Branding for Branding for Medica Plan member |

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
      | planType | memberType     | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard | cologoToBeDisplayedOnSecondaryPage                  |
      | MAPD     | ALPEEHIP       | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg     | optum/MR15500/alpeehip.svg     | dam/UCP/Images/Images/logos-cobranding/ALPEEHIP.svg |
       | MAPD     | Villages  | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg     | optum/MRH1045025/TheVillages-01.svg     | dam/UCP/Images/Images/logos-cobranding/Villages.svg |
       | MAPD     | NCSHP  | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg     | optum/MR12309/NCSHP_Logo.svg     | dam/UCP/Images/Images/logos-cobranding/NCSHP_Logo.svg |
       | MAPD     | Calpers  | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg     | optum/MR12775/CalPERS.svg     | dam/UCP/Images/Images/logos-cobranding/CalPERS_Logo_Large.svg |
       | MAPD     | SHBP  | NON LIS       | images/branding/unitedhealth.svg     | dam/UCP/Images/logo/UHC.svg     | optum/MR12472/gadch.svg     | dam/UCP/Images/Images/logos-cobranding/SHBP.svg |