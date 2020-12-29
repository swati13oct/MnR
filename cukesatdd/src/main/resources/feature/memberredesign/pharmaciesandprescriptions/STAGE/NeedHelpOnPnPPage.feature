Feature: Need Help Phone Numbers on PnP Page
  To validate Need Help Phone Numbers on PnP Page

  @STAGERegression
  Scenario Outline: To verify Need Help sections on PnP Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates Need Help section phone numbers
    Then user validates Need Help section hours of operations

    Examples: 
      | planType | memberType                 |
      | MAPD     | Rx_Individual_PnP_needhelp |
