@retiree
Feature: To test the RETIREE drug search flow
  

  @retireedrugsearch
  Scenario Outline: This Scenario is to verify the drug search for different group types from landing page
    Given The user is on Retiree Home page 
    And The user navigates to the Search for a Drug page
    When The User Selects the "<groupname>" Group name
    And The user navigates to the SEARCH FOR A DRUG page and search for a drug
    Then The User validate the Drug Details
    And The user return to the search results page

    Examples: 
      | groupname |
      | ASRS and PSPRS |
      | CalPERS |
      | Georgia State Health Benefit Plan |
      | North Carolina State Health Plan |
      