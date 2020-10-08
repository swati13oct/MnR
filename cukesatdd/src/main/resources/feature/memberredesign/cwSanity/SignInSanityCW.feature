@hsid
Feature: To test HSID member SignIn for 5 min turnaround testing of MAPD & PDP/Med Supp member

  @regressionMember
  Scenario Outline: Verify HSID login functionality branding and outbound SSO for <planType> <memberType> member sign in
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that correct logo and cologo are displayed on the home page or test harness page
      | Dashboard Logo        | <logoToBeDisplayedOnDashboard>       |
      | Dashboard CoLogo      | <cologoToBeDisplayedOnDashboard>     |
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo and cologo are displayed on the secondary page
      | Secondary Page Logo   | <logoToBeDisplayedOnSecondaryPage>   |
      | Secondary Page CoLogo | <cologoToBeDisplayedOnSecondaryPage> |
    And user scrolls down to OptumRx SSO link to perform outbound OptumRx SSO
      | OptumRx SSO Link | <optumrxssolink> |
    And user clicks on OptumRx SSO link and lands on OptumRx SSO Page in new window
      | OptumRx SSO Link | <optumrxssolink> |

    Examples: 
      | planType | memberType | optumrxssolink           | username | password | member                    | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | cologoToBeDisplayedOnDashboard | cologoToBeDisplayedOnSecondaryPage 			    |
      | MAPD     | optumrx    | viewDetailsAtOptumrxLink | pminhas  | Mnrqa001 | Andersonga1@Bellsouth.Net | UHC                          | dam/UCP/Images/logo/UHC.svg      | SHBP                           | dam/UCP/Images/Images/logos-cobranding/SHBP.svg |

  @regressionMember
  Scenario Outline: Verify HSID login functionality and branding for <planType> <memberType> member sign in      
	Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that correct logo is displayed on the home page or test harness page
      | Dashboard Logo      | <logoToBeDisplayedOnDashboard>     |
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that correct logo is displayed on the secondary page
      | Secondary Page Logo | <logoToBeDisplayedOnSecondaryPage> |
    And I click on logout and validate the login page

    Examples: 
      | planType | memberType              | copayCategory | logoToBeDisplayedOnDashboard | logoToBeDisplayedOnSecondaryPage | Test Case                                             | username | password | member                |
      | SHIP     | SHIPOnly_Branding       | NON LIS       | AARP                         | dam/UCP/Images/logo/AARP.svg     | TC_02_ Branding  for AARP Plan member - SHIP   Member | pminhas  | Mnrqa001 | Pramila1946           |