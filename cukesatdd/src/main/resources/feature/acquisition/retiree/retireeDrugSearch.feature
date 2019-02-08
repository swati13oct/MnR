#Author: ckoppura
#Feature: To test the RETIREE drug search flow
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
@retiree
Feature: Title of your feature
  I want to use this template for my feature file

  @retireedrugsearch
  Scenario Outline: This Scenario is to verify the drug search for different goup typs from landing page
    Given The user is on Retiree Home page 
    And The user navigates to the Search for a Drug page
    When The User Selects the "<groupname>" Group name
    And The user navigates to the SEARCH FOR A DRUG page and searchfor a drug
    Then The User validate the Drug Details
    And The user return to the search results page

    Examples: 
      | groupname |
      | ASRS and PSPRS |
      | CalPERS |