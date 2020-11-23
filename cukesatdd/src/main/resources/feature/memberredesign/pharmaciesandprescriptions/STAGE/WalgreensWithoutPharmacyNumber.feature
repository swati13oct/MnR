Feature: Walgreen without Pharmacy Number (Contact Pharmacy)
  To validate Walgreen without Pharmacy Number

  @STAGERegression
  Scenario Outline: To verify Walgreen without Pharmacy Number has Contact Pharmacy
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    And user clicks View all medications link to view the My Medications page
    When user has a Walgreens drug without store numbers on My Medications page
    Then user sees the contact pharmacy button if it has no store number

    Examples:
      | planType | memberType             |
      | MAPD     | AARP_Individual_PnP_rx_walgreen |
