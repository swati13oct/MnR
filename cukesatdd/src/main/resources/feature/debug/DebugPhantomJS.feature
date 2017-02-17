
@jantolak
Feature: To run successful test using PhatonJS in Jenkins

    @successfulTest
    Scenario Outline: Verify Federal Optional Dental on benefits and coverage in AARP site for MAPD Non Lis member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site

    Examples: 
      | planType | copayCategory |
      | MA     | NON LIS       |      
      