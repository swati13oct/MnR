@acq_CALLCHAT_UHC_Tablet
Feature: 1.19.1 ACQ UHC- To test Home Page in UHC site on Tablet

  @samChatCallTablet
  Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on Tablet
    Given the user is on the UHC medicare site landing page on Tablet
    And user opens the page to validate on UHC Tablet
      | pagename | <pagename> |
    Then the user validates whether call icon is visible on UHC Tablet
    Then the user validates whether chat icon is visible on UHC Tablet

    @header_1
    Examples: 
      | pagename            |
      | /                   |
#      | medicare-plans.html |