Feature: 2020 and 2021 CTA on Pharmacy Locator page
  To validate 2020 and 2021 CTA on Pharmacy Locator page

  @Regression
  Scenario Outline: To verify 2020 and 2021 CTA on Pharmacy Locator page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will be directed to the Choose a plan year page
    Then user will be see a back button on Choose a plan year page
    Then user will see the page header on Choose a plan year page
    Then user will see descriptive content on Choose a plan year page
    Then user will see a twenty twenty call to action on Choose a plan year page
    Then user will see a twenty twentyone call to action on Choose a plan year page

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |

  @Regression
  Scenario Outline: To verify 2020 CTA redirect to new Pharmacy Locator tool built by Rally
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will see a twenty twenty call to action on Choose a plan year page
    When user click on the twenty twenty call to action on Choose a plan year page
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |

  @Regression
  Scenario Outline: To verify 2021 CTA redirect to the legacy Pharmacy Locator tool
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will see a twenty twentyone call to action on Choose a plan year page
    When user click on the twenty twentyone call to action on Choose a plan year page
    Then user will be directed to the legacy Pharmacy Locator tool in the same browser window

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |
