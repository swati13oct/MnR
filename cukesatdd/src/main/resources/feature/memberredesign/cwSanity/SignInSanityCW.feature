@hsid
Feature: To test HSID member SignIn for 5 min turnaround testing of MAPD & PDP/Med Supp member

  @regressionMember
  Scenario Outline: Verify HSID login functionality for <planType> <memberType> member sign in
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then I validate that login is successfull
    And I click on logout and validate the login page

    Examples: 
      | planType | memberType | copayCategory |
      | COMBO    | FedShip    | NON LIS       |
      | MAPD     | Individual | NON LIS       |
