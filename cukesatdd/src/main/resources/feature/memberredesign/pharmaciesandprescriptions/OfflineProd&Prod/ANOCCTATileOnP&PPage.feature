Feature: ANOC CTA Tile not displayed on P&P page
  To validate ANOC CTA Tile not displayed on P&P page

  @Sanity @Regression
  Scenario Outline: To verify ANOC tile is not displayed on P&P page
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
    Then user ANOC Call To Action not displayed

    #Then user validates an image for ANOC Call To Action
    #Then user validates a title for ANOC Call To Action
    #Then user validates a description for ANOC Call To Action
    #When user clicks on ANOC Call To Action
    #Then user will be redirected to the prepare for Next Year page in a new tab
    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Free@123 | Berniewb    | PDP      | Individual |
