
@exampleAllTest
Feature: To run successful test using PhatonJS in Jenkins

  @Example1 @jantolakTest
    Scenario Outline: A Successful Test
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    Examples: 
      | testName | planType | copayCategory |
      | jantolakTest | MA     | NON LIS       |      
      
 @Example2 @availableRiders
  Scenario Outline: Verify Federal Available Riders Dental Platinum on benefits and coverage in AARP site for MAPD Lis 2 member
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Add rider popup appears and clicks Add Rider button

    Examples: 
      | testName | planType | copayCategory |
      | availableRiders | MAPD     | LIS 2         |
      
      
 @Example3 @replaceRider
  Scenario Outline: Verify Replace Rider Pop Up for Federal Available Dental Platinum Riders
    Given registered AMP with following details for plan benefits and coverage flow in AARP site
      | Plan Type      | <planType>      |
      | Copay Category | <copayCategory> |
    When the user view forms and resources in AARP site
    Then the user view benefits and coverage in AARP site
    And the user validates the content on benefits and coverage page
    When user clicks on Add Rider button
    Then Replace rider popup appears and clicks Replace Rider button

    Examples: 
      | testName | planType | copayCategory |
      | replaceRider | MAPD     | NON LIS       |