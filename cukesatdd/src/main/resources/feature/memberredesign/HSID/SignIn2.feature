@hsid
Feature: To test HSID member SignIn

  @hsid6 @Login @US968315 @regressionMember
  Scenario Outline: Verify HSID login functionality for <planType> <memberType> member sign in
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then I validate that login is successfull

    Examples: 
      | planType        | memberType          | copayCategory |
      | MA              | Individual          | NON LIS       |
      | PDP             | Individual          | NON LIS       |
      | PDPGroup        | Group               | NON LIS       |
      | SHIP            | ShipOnly            | NON LIS       |
      | COMBO           | FedShip             | NON LIS       |
      | SSUPGroup       | Group               | NON LIS       |
      | MAPre-effective | Individual          | NON LIS       |
      | GovtTermless    | Individual          | NON LIS       |
      | PDP             | PREFFECTIVE         | NON-LIS       |
      | SSUP            | Terminated          | NON-LIS       |
      | MA-Medsup       | FEDSHIPPREEFFECTIVE | NON-LIS       |

 