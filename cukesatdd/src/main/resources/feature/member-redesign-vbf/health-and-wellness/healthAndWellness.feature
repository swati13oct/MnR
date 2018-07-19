@smokeTest
Feature: 1.07-VBF-MemRedesign-To test Health and Wellness functionality

  @smokeTest_H&W @rallyDashboard @testharness
  Scenario Outline: Validate that member can check health and wellness and its Lifestyle, Learning tabs
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When then click the health and wellness tab
    When I should see the H&W Generic dashboard and lifestyle,learning and rewards
    When then click the Lifestyle tab and I should be directed to Lifestyle Page
    When user then click again on health and wellness tab
    When then click the Learning tab and I should be directed to Learning Page

    Examples: 
		 | memberType        | friendname | favcolor | phonenumber |
		 | UhcMapdInd				 |name1       | color1   | number1     |
		# | AARPMapdInd			 | name1      | color1   | number1     |
		# | GroupRetireeMapd	 |name1       | color1   | number1     |
