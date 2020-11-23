Feature: P&P Page is Loaded
  To validate P&P Page Loaded Successfully.

  @STAGERegression
  Scenario Outline: To verify Pharmacy and Prescription Page load successfully
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user view MedCab load successfully on PnP page


    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_ChangePaymentMethod |
