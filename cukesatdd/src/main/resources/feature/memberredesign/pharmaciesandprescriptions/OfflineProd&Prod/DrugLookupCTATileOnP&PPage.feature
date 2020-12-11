Feature: Drug Lookup CTA Tile on P&P page
  To validate Drug lookup CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
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
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup a Medication Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window using memAuth

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | Berniewb    | PDP      | Individual |
