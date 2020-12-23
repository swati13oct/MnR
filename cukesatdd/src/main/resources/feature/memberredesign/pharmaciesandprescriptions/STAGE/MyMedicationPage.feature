Feature: My Medication Page
  To validate user navigate to My Medication Page

  @STAGERegression
  Scenario Outline: To verify My Medication Page display active 10 drugs and disclaimer
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user validates the disclaimer Medication appearance subject to change
    Then user validates first ten of his active prescriptions
    And user advance and reverse through the pages

    Examples: 
      | planType | memberType                    |
      | MAPD     | Rx_Refill_ChangePaymentMethod |
