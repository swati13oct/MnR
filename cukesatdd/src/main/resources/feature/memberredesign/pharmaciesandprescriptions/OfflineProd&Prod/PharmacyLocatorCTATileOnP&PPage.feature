Feature: Pharmacy Locator CTA Tile on P&P page
  To validate PDP, MAPD, PCP, Medica user for Pharmacy Locator CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify PDP user for Pharamcy Locator CTA Tile,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
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
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window memAuth
    #Then user will be directed to the Choose a plan year page

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | Berniewb    | PDP      | Individual |

  @Sanity @Regression
  Scenario Outline: To verify MAPD user for Pharamcy Locator CTA Tile,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
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
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window memAuth
   # Then user will be directed to the Choose a plan year page

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | JAN06ARY    | MAPD     | Individual |

  @Sanity @Regression
  Scenario Outline: To verify PCP user for Pharamcy Locator CTA Tile,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
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
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window memAuth
    #Then user will be directed to the Choose a plan year page

    Examples: 
      | username | password | memUserName         | planType | memberType |
      | kjadha10 | Virus$$1 | sofyabakman@msn.com | PCP      | Group      |

  @Sanity @Regression
  Scenario Outline: To verify Medica user for Pharamcy Locator CTA Tile,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
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
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window memAuth
   # Then user will be directed to the Choose a plan year page

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | TCZUNIGA52  | Medica   | Group      |
