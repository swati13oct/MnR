@regressionDeployentFiles
Feature: 2.1 ACQ- To test sitemap txt file is loading correctly

  @siteMapXMlFileAARP1
  Scenario Outline: To test the sitemap txt file is loading on AARP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user opens the page to validate on AARP
      | pagename | <pagename> |
    Then the user validates whether page load is loading on AARP
    Then the user validates whether correct content is visible on AARP
      | pagename | <pagename> |

    Examples: 
      | pagename    |site|
      | sitemap.xml |AARP |
      | sitemap.xml |UHC |

