Feature: To test Branding for 5 min turnaround of MAPD & PDP/Med Supp member

  @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify_<Test Case>
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And verify that correct logo is displayed on the home page or test harness page
      | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |

    Examples: 
      | TID   | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             |
      | 15146 | MAPD     | AARPIndividual_Branding | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_01_Branding for AARP Plan member - Federal Member  |
      | 15147 | SHIP     | SHIPOnly_Branding       | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_02_ Branding  for AARP Plan member - SHIP   Member |
