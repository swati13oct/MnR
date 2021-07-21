@globalComponent @samIcons
Feature: ACQ M&R- To test SAM Icons

Scenario Outline: To test the SAM icons on Acq site on <site> <pagename>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user opens the page to validate M&R Sites
      | pagename | <pagename> |
    Then the user validates whether call icon is visible
    And the user validates the chat icon

    @samChatAARP @regressionAARP
    Examples: 
      | pagename                                                   | site |
      | /                                                          | AARP |