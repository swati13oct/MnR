Feature: MedCab Load On P&P Page
  To validate MedCab Load On P&P Page

  @STAGERegression
  Scenario Outline: To verify MedCab Load On P&P Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user view MedCab load successfully on PnP page
    Then user validates the disclaimer Medication appearance subject to change
    And user validates first six of his active prescriptions

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_ChangePaymentMethod |
