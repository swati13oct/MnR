Feature: Drug Lookup CTA Tile on P&P page
  To validate Drug lookup CTA Tile on P&P page

  @STAGERegression
  Scenario Outline: To verify Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup a Medication Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window using memAuth

    Examples:
      | planType | memberType             |
      | PDP     | Rx_OrderStatus_Shipped|
