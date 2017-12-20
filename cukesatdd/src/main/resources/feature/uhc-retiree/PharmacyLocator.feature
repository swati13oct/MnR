@pharmacylocator
Feature: To test pharmacy search page functionality in UHCRetiree

  @sanity
  Scenario Outline: To verify pharmacy search functionality for 2017 in UHCRetiree ULayer
    Given user navigates to the UHCRetiree Home Page
    Then the user navigates to pharmacy search page in UHCRetiree Site
    And search pharmacy for the mentioned zipcode and year
      | Zipcode | <zipcode> |
      | Year    | <year>    |
    And validate pharmacy search results
      | Zipcode | <zipcode> |
    And validate pharmacy saver

    Examples: 
      | year | zipcode |
      | 2017 |   90210 |

  Scenario Outline: To verify pharmacy search functionality for 2018 in UHCRetiree ULayer
    Given user navigates to the UHCRetiree Home Page
    Then the user navigates to pharmacy search page in UHCRetiree Site
    And search pharmacy for the mentioned zipcode and year
      | Zipcode | <zipcode> |
      | Year    | <year>    |
    And validate pharmacy search results
      | Zipcode | <zipcode> |
    And validate Standard Network pharmacy

    Examples: 
      | year | zipcode |
      | 2018 |   90210 |
