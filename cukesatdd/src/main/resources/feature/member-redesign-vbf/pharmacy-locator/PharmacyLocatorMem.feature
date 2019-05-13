@smokeTest @MemberVBF
Feature: 1.12-VBF-MemRedesign-To test Locate a Pharmacy tool (GATED)

  @smokeTest_PharmacyLocatorMem @rallyDashboard @testharness
  Scenario Outline: Verify all available pharmacies for default zipcode in Redesign site
    Given I am a authenticated member on the member redesign site for Direct Login
   #   | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When the user navigates to pharmacy search page in Redesign site
    And the user enters distance details in Redesign site
      | Distance | <distance> |
    Then the user validates the pharmacies available in Redesign site
    	|Zipcode | <zipcode> |
    Then the user Validates show on map link in Redesign Site
    Then the user validate more information content based on plan type in Redesign Site

    Examples: 
		| memberType       | distance | friendname | favcolor | phonenumber | zipcode |
		| UhcMapdInd  |   25      |name1      | color1   | number1     | 90210 |
		# | AARPMapdInd |       25 | name1      | color1   | number1     | 90210 |
		#| GroupRetireeMapd  |   25      |  name1      | color1   | number1     |90210 |
		
	@pharmacyLocator_Performance
  Scenario Outline: Verify all available pharmacies for default zipcode in Redesign site for performance
    Given I am a authenticated member on the member redesign site for Direct Login
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    When the user navigates to pharmacy search page in Redesign site
    And the user enters distance details in Redesign site
      | Distance | <distance> |
    Then the user validates the pharmacies available in Redesign site
    	|Zipcode | <zipcode> |

    	Examples: 
		| memberType | planType | distance | friendname | favcolor | phonenumber | zipcode |
		| grpPerf    | PDP        |  25      |name1      | color1   | number1     | 90210 |