@smokeTest
Feature: 1.14-VBF-MemRedesign-To test provider search (Rally) functionality

  @smokeTest_ProviderSearch @rallyDashboard @testharness
  Scenario Outline: To validate that provider search is opening up correctly
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the member navigates to Provider Search page
    Then the member should be able to access provider page

    Examples: 
      | memberType  | friendname | favcolor | phonenumber |
      #   	  | GroupRetireeMapd|name1      | color1   | number1     |
      #      | UhcMapdInd     |name1      | color1   | number1     |
      | AARPMapdInd | name1      | color1   | number1     |
