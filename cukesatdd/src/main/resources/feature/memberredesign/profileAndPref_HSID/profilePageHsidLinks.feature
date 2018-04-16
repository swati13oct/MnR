@thePredators @aprilRelease2018 @US980034
Feature: To test Profile Page Post Hsid Login

  @ProfilePageHSIDLinks
  Scenario Outline: To test the Profile Page after HSID login
    Given registered member with following details
      | Plan Type   | <planType>    |  
    When  I enter the security questions
     | friendname | <friendname> | 
     | favouritecolor | <favcolor> |
     | PhoneNumber | <phonenumber> |
    When I navigate to the Account Settings page
    And I click the HEALTHSAFE ID PASSWORD link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link
    

    Examples: 
      | planType | friendname | favcolor | phonenumber |
      | MAPD     | name1      | color1   | number1     |
      | PDP     | name1      | color1   | number1     |
      | SHIP    | name1      | color1   | number1     |
      | PCP   | name1      | color1   | number1     |
      | MEDICA    | name1      | color1   | number1     |