@smokeTest
Feature: 1.05-VBF-MemRedesign-To test EOB functionality

  @smokeTest_EOB @rallyDashboard @testharness
  Scenario Outline: Validate that member can search for eob statement
    Given I am a authenticated member on the member redesign site for Direct Login
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | EOB Type    | <eobType>    |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    Then the user navigates to EOB page
    And the user slects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |
    Then the user validates EOB count
    Then the user validates EOB statments displayed

    #Then the user validates site leaving pop up
    Examples: 
      | planType | memberType        | dateRange   | eobType        | friendname | favcolor | phonenumber |
      | Medsupp | Ship              | 6-12 Months | ShipEOB        |  name1     |  color1  |   number1   |
      | MAPD     | UHCIndividualCosmosEOB  | 18 Months | Medical           | name1      | color1   | number1     |
      | MAPD     | UHCIndividualEOB  | 18 Months | Prescription Drug | name1      | color1   | number1     |
   #   | MAPD     | AARPIndividualCosmosEOB | 18 Months | Medical           | name1      | color1   | number1     |
    | MAPD     | AARPIndividualNiceEOB | 18 Months | Medical           | name1      | color1   | number1     |
	#	| MAPD      | AARPIndividualEOB    |18 Months		  | Prescription Drug | name1      | color1   | number1     | 
		#	| MAPD      | GroupRetireeCosmosEOB      |18 Months		  | Medical           | name1      | color1   | number1     | 
		#	| MAPD      | GroupRetireeEOB      |18 Months		  | Prescription Drug | name1      | color1   | number1     | 
