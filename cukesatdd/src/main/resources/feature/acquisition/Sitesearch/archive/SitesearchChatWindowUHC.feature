@acq_ChatWindow_UHC @F412628
Feature: 1.20 ACQ UHC- To test ChatWindow in uhc site search

  @chatwindowonsitesearchBlayer
  Scenario Outline: 
    Given the user is on uhcmedicaresolutions site landing page
    Then the user validates chat Icon on UHC site
    Then the user enter the searchValue in the search text box and hits enter on UHC Site
      | search Value | <searchValue> |
    Then the user should see fifteen results before pagination on UHC Site
    Then the user validates whether chat icon is visible on UHC
    Then the user validates chat Icon on UHC site

    Examples: 
      | searchValue |
      | Medicare    |
