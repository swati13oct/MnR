Feature: Drug Lookup CTA Tile on P&P page
  To validate Drug lookup CTA Tile on P&P page

  @STAGERegression
  Scenario Outline: To verify MAPD member for Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType     |
      | MAPD     | MAPD_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PDP member for Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType    |
      | PDP      | PDP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify PCP member for Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType    |
      | PCP      | PCP_Pnp_rally |

  @STAGERegression
  Scenario Outline: To verify Medica member for Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | planType | memberType       |
      | Medica   | Medica_Pnp_rally |
