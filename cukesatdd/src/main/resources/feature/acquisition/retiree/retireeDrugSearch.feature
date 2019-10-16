@retiree
Feature: 3.02.ACQ- RETIREE drug search flow UMS
  
  @retireedrugsearch
  Scenario Outline: This Scenario is to verify the drug search for different group types <groupname> from landing page
    Given The user is on Retiree Home page 
    And The user navigates to the Search for a Drug page
    When The User Selects the "<groupname>" Group name
    And The user navigates to the SEARCH FOR A DRUG page and search for a drug
    Then The User validate the Drug Details
    And The user return to the search results page

    @retireedrugsearch_Smoke
    Examples: 
      | groupname |
      | ASRS and PSPRS |

    Examples: 
      | groupname |
      | CalPERS |
      | Georgia State Health Benefit Plan |
      | North Carolina State Health Plan |
 

           