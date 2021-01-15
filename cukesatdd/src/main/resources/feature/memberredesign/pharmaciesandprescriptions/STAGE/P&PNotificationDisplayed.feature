Feature: P&P Notification is activated
  To validate P&P Notification is activated.

  @STAGERegression
  Scenario Outline: To verify P&P Notification is activated
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated

    #When a PnP notification is deactivated
    Examples: 
      | planType | memberType                    |
      | MAPD     | Rx_Refill_ChangePaymentMethod |