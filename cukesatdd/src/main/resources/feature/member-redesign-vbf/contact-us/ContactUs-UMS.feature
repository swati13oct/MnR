@smokeTest
Feature: 1.03-VBF-MemRedesign-To test contact us page

  @smokeTest_contactusInd @rallyDashboard @testharness
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Federal member
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When the user navigates to contact us page in UHC site
    Then user validates secure email widget UI in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click

    Examples: 
      | memberType | friendname | favcolor | phonenumber |
      | UhcMapdInd | name1      | color1   | number1     |

  @smokeTest_contactusGrp @rallyDashboard @testharness
  Scenario Outline: Verify Click to Call and email Widget section on contact us page for Group member
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When the user navigates to contact us page in UHC site
    # Then user validates Group secure email widget  in redesign contact us page
    Then user validates secure email widget UI in redesign contact us page
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click

    Examples: 
      | memberType       | friendname | favcolor | phonenumber |
      | GroupRetireeMapd | name1      | color1   | number1     |
