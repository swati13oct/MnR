Feature: OTC CTA Tile on P&P page
  To validate PDP and MAPD-Individual users for OTC CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify PDP member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Rally Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    Then user will not be able to view OTC Call To Action

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | JAN06ARY    | PDP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify MAPD Individual member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Solutran's healthybenefits Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    Then user view OTC Call To Action
    Then user validates an image for OTC Call To Action
    Then user validates a title for OTC Call To Action
    Then user validates a description for OTC Call To Action
    When user clicks on OTC Call To Action
    Then user will see the authenticated healthybenefits web page open in a new tab using memAuth

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | elizfein    | MAPD     | Individual |
