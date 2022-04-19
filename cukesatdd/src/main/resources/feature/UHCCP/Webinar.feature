#Author: chandrahasa_sambhangi@optum.com
@tag
Feature: Webinar form validation

  @tagUHCCP-Webinar @tagCP
  Scenario Outline: Webinar form validation - <userno.>
    Given User loads the driver and User opens Community Portal Website for webinar form
    Then User click on Resource Center button for webinar form
    Then User visits the benefits page for webinar form
    Then User visits the surprising benefits of dual health plans article for webinar form
    And Click on Request Guide button for webinar form
    And User enters First Name as "<fname>" for webinar form
    And User enters Last Name as "<lname>" for webinar form
    And User selects State as "<state>" for webinar form
    And User enters Email as "<email>" for webinar form
    Then User clicks on Submit button for webinar form 
    When User clicks on button the confirmation message should be validated for webinar form
    And close browser for webinar form
  
    Examples: 
      |	userno.	| fname           | lname           | state   |email                           |         
      |	user1		| Test_Portals_FN | Test_Portals_LN | Arizona |chandrahasa_sambhangi@optum.com |
      |	user2		| Test_Portals_FN | Test_Portals_LN | Arizona |test@test.com									 |  
     
