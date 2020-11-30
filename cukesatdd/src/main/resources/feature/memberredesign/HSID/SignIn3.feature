@hsid @regressionMember
Feature: To test HSID member SignIn

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPUserManagement |
###############################Regression Scenarios Begin Here ########################################

  @Login @US968315 @regressionMember
  Scenario Outline: Verify HSID login functionality for <planType> <memberType> member sign in
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then I validate that login is successfull
    And I click on logout and validate the login page

    Examples: 
      | planType        | memberType          | copayCategory |
      | SSUPGroup       | Group               | NON LIS       |
      | MAPre-effective | Individual          | NON LIS       |
      | GovtTermless    | Individual          | NON LIS       |
      | PDP             | PREFFECTIVE         | NON-LIS       |
      | MAPD            | Terminated_PnP      |	NON LIS       |
      | MA-Medsup       | FEDSHIPPREEFFECTIVE | NON-LIS       |
