@acq_ChatWindow_AARP @F412628
Feature: 1.20 ACQ AARP- To test ChatWindow in AARP site search

@chatwindowonsitesearchUlayer
Scenario Outline:
Given the user is on AARP medicare acquisition site landing page
   Then the user enter the searchValue in the search text box and hits enter
       |search Value|<searchValue>| 
   Then the user should see fifteen results before pagination
    Then the user validates chat Icon
    Examples: 
      | searchValue |
      | Medicare    |
      
   
