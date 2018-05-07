@smokeTest
Feature: 1.04-VBF-MemRedesign-To test Drug Cost Estimator functionality

  @smokeTest_DceMem @rallyDashboard @testharness
  Scenario Outline: To Verify member is able to add drug, change pharmacy and view costs
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And I access the page containing the DCE tool
    And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
      | Drug | <drug> |
    Then I should be presented the option to switch to the generic option
    And I navigate to step2 page
    Then I should see preferred mail service radio button under pharmacy type
    And I enter a US other territory zip code and click select
      | USOTZipcode | <USOTZipcode> |
    Then I should see preferred mail service radio button under pharmacy type
    And I select first pharmacy from standard network pharmacy type
    And I navigate to step3 page
    Then I should see that total estimated annual drug costs in summary section matches with left rail value

    Examples: 
      | memberType | drug    | USOTZipcode | friendname | favcolor | phonenumber |
      | UhcMapdInd | lipitor |       90002 | name1      | color1   | number1     |
		#| AARPMapdInd |lipitor|90002|name1      | color1   | number1     |
