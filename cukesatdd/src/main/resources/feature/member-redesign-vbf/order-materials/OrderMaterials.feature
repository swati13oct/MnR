@smokeTest
Feature: 1.10-VBF-MemRedesign-To test order materials functionality

  @smokeTest_OrderPlanMaterial @rallyDashboard @testharness
  Scenario Outline: Verify order materials confirmation page in Redesign site
    Given I am a authenticated member on the member redesign site for Direct Login

      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When the user views order materials in Member Redesign Order Materials page
    And user Validates Page Header and Sub-Header text
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
		 | memberType       | option              | friendname | favcolor | phonenumber |
		# | UhcMapdInd  | Replacement ID card      |name1      | color1   | number1     |
		 | AARPMapdInd | Replacement ID card | name1      | color1   | number1     |
		# | GroupRetireeMapd  | Replacement ID card      |name1      | color1   | number1     |
		# |  UhcIndMA | Member Materials |name1      | color1   | number1     |
		# |  AARPIndPDP | Welcome Guide    |name1      | color1   | number1     |
		# | Ship  | Member ID Card |name1      | color1   | number1     |
