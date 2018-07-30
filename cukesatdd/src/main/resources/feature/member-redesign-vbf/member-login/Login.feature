@smokeTest
Feature: 1.09-VBF-MemRedesign-To test sign functionality

  @smokeTest_DirectLogin @rallyDashboard @testharness
  Scenario Outline: Validate that member is successfully getting logged in to Rally Dashboard
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    Then User should be able to validate Dashboard elements
    And User should be ale to navigate to secondary page

    Examples: 
      | memberType  | friendname | favcolor | phonenumber |
   #    | ComboMAPDANDSHIP      | name1      | color1   | number1     |
      | TerminatedFedAARP      | name1      | color1   | number1     | 
       | Ship     |name1      | color1   | number1     |     
       | UhcMapdInd     |name1      | color1   | number1     |
     # | AARPMapdInd | name1      | color1   | number1     |
      | GroupRetireeMapd     |name1      | color1   | number1     |
     # | Ship     |name1      | color1   | number1     |
      | PCP     |name1      | color1   | number1     |
      | Medica      | name1      | color1   | number1     |
