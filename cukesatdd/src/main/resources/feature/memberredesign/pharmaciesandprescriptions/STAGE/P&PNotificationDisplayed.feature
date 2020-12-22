Feature: P&P Notification is deactivated
  To validate P&P Notification is deactivated.

  @STAGERegression
  Scenario Outline: To verify P&P Notification is deactivated
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is deactivated

    Examples: 
      | planType | memberType                    |
      | PDP      | Rx_Refill_ChangePaymentMethod |