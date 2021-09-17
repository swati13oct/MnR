@regressionDeployentFiles
Feature: 2.1 ACQ- To test robot txt file is loading correctly

  @robotTxtFileAARP1
  Scenario Outline: To test the robot txt file is loading on AARP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user opens the page to validate on AARP
      | pagename | <pagename> |
    Then the user validates whether page load is loading on AARP
    Then the user validates whether correct content is visible on AARP
      | pagename | <pagename> |

    Examples: 
      | pagename   | site |
      | robots.txt |AARP |
      | robots.txt	|UHC |

  
