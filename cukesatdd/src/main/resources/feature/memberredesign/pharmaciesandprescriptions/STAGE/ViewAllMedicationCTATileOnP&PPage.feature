Feature: View All Medication CTA Tile on P&P page
  To validate View All Medication CTA Tile on P&P page

  @STAGERegression
  Scenario Outline: To verify View All Medication CTA Tile position,Image,Title,Description on P&P page and Redirection to My Medication Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user view MedCab load successfully on PnP page
    Then user view View All Medication Call To Action
    Then user validates an image for View All Medication Call To Action
    Then user validates a title for View All Medication Call To Action
    Then user validates a description for View All Medication Call To Action
    And user clicks on View All Medication call to action displayed Third within that section
    Then user will be directed to My Medications page

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_ChangePaymentMethod |
