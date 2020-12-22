Feature: ANOC CTA Tile not displayed on P&P page
  To validate ANOC CTA Tile not displayed on P&P page

  @STAGERegression
  Scenario Outline: To verify ANOC tile is not displayed on P&P page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user ANOC Call To Action not displayed

    #Then user validates an image for ANOC Call To Action
    #Then user validates a title for ANOC Call To Action
    #Then user validates a description for ANOC Call To Action
    #When user clicks on ANOC Call To Action
    #Then user will be redirected to the prepare for Next Year page in a new tab
    Examples: 
      | planType | memberType             |
      | PDP      | Rx_OrderStatus_Shipped |
