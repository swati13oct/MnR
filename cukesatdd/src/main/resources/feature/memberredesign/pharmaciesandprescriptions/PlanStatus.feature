Feature: Plan Status
  As a termed or pre-effective member using the M&R member portal, I don't want to be able to access the Pharmacies & Prescriptions page by bookmark or URL, so that I do not see capabilities that are not available to me.  

  @PlanStatus @F480452 @US2627388 @Scenario1 @Scenario2
  Scenario Outline: Verify HSID login functionality for <planType> <memberType> To verify deep link for preefective member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
    Then I validate that login is successfull
    Then I see it as preeffective member and no PP page on the navigation bar
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then I will be sent back to the member site dashboard


    Examples:
      | planType        | memberType          |
      | PDP             | PREFFECTIVE        |
      | MAPD            | PREFFECTIVE         |




  @PlanStatus @F480452 @US2627388 @Scenario3 @Scenario4 @kewl
  Scenario Outline: Verify HSID login functionality for <planType> <memberType> To verify deep link for preefective member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
    Then I validate that login is successfull
    Then I see it as termed member and no PP page on the navigation bar
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then I will be sent back to the member site dashboard


    Examples:
      | planType        | memberType          |
      | PDP             | Terminated          |
      | MAPD            | Terminated          |