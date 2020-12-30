Feature: Provider Search tile on coverage and benefits page

  @codeWarriors @F526788
  Scenario Outline: Validate Provider search tile suppressed on Coverage and Benefits page for H1360-001-000 group
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then The user navigate to Benefits and Coverage page
    And validates provider search tile not displayed
    Examples: 
	    | planType | memberType                | 
	    | MAPD     | MAPD_NoProviderSearchTile |

  @codeWarriors @F526788
  Scenario Outline: Validate Provider search tile not suppressed on Coverage and Benefits page for other group
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then The user navigate to Benefits and Coverage page
    And validates provider search tile displayed
    Examples: 
	    | planType | memberType              |
	    | MAPD     | MAPD_ProviderSearchTile |