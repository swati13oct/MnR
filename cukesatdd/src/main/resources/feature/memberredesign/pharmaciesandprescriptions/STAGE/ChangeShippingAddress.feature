Feature: Change Shipping Address
  To validate Change Shipping Address

  @STAGERegression
  Scenario Outline: To verify Change Shipping Address
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page

    Examples:
      | planType | memberType             |
      | PDP     | Rx_OrderStatus_Shipped|
