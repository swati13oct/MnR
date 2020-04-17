@acq_CALLCHAT_AARP_Tablet
Feature: 1.19.1 ACQ AARP- To test Home Page in AARP site on Tablet

  @samChatCallTablet
  Scenario Outline: 1.19.1.1 To test the SAM icons on AARP site on Tablet
    Given the user is on the AARP medicare site landing page on Tablet
    And user opens the page to validate on AARP Tablet
      | pagename | <pagename> |
    Then the user validates whether call icon is visible on AARP Tablet
    Then the user validates whether chat icon is visible on AARP Tablet

    @header_1
    Examples: 
      | pagename            |
      | /                   |
#      | medicare-plans.html |
