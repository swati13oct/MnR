Feature: OTC CTA Tile on P&P page
  To validate PDP and MAPD-Individual users for OTC CTA Tile on P&P page

  @STAGERegression
  Scenario Outline: To verify PDP member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user will not be able to view OTC Call To Action

    Examples: 
      | planType | memberType |
      | PDP      | PDP_Pnp    |

  @STAGERegression
  Scenario Outline: To verify MAPD Group member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user will not be able to view OTC Call To Action

    Examples: 
      | planType | memberType     |
      | MAPD     | MAPD_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify MAPD Cosmos Individual member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Solutran's healthybenefits Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view OTC Call To Action
    Then user validates an image for OTC Call To Action
    Then user validates a title for OTC Call To Action
    Then user validates a description for OTC Call To Action
    When user clicks on OTC CTA
    Then user will see the authenticated healthybenefits web page open in a new tab

    Examples: 
      | planType | memberType      |
      | MAPD     | MAPD_OTC_Cosmos |

  @STAGERegression
  Scenario Outline: To verify MAPD Nice Individual member - OTC CTA Tile Image,Title,Description on P&P page and Redirection to Solutran's healthybenefits Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view OTC Call To Action
    Then user validates an image for OTC Call To Action
    Then user validates a title for OTC Call To Action
    Then user validates a description for OTC Call To Action
    When user clicks on OTC CTA
    Then user will see the authenticated healthybenefits web page open in a new tab

    Examples: 
      | planType | memberType    |
      | MAPD     | MAPD_OTC_Nice |
