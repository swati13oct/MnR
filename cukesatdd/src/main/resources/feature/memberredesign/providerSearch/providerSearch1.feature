Feature: Provider Search tile on coverage and benefits page

  @codeWarriors @F526788 @regressionMember
  Scenario Outline: Validate Provider search tile suppressed on Coverage and Benefits page for H1360-001-000 group
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then The user navigate to Benefits and Coverage page
    And validates provider search tile not displayed
    Examples: 
	    | planType | memberType                | 
	    | MAPD     | MAPD_NoProviderSearchTile |

  @codeWarriors @F526788 @regressionMember
  Scenario Outline: Validate Provider search tile not suppressed on Coverage and Benefits page for other group
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
    Then The user navigate to Benefits and Coverage page
    And validates provider search tile displayed
    Examples: 
	    | planType | memberType              |
	    | MAPD     | MAPD_ProviderSearchTile |
	    
  @codeWarriorsPROD @F526788 @regressionMemberPROD
  Scenario Outline: Validate Provider search tile suppressed on Coverage and Benefits page for H1360-001-000 group on PROD
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    Then validates provider search tile not displayed
    Examples: 
	    | planType | username | password | member		  |
	    | MAPD     | pminhas  | Mnrqa002 | KMontejano2020 |