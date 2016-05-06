@enrollInPlanAARP
Feature: To test enroll in plan on AARP site 
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
	| Zip Code    | <zipcode> |
	| County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
	| Plan Type | <planType> |
And the user click on enroll link  for the below plan in AARP site 
	| <planName> |

	
	Examples:
  	|zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender	| medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city	  | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  	|80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | First   |  m          |  last  |01/01/1940 |  Male		| 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234	    | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |	
    |80002   |Adams County | PDP        |AARP MedicareRx Preferred (PDP)                     |No    | miller  |  j          |desh    |11/12/1989 |  Male		| 222-22-2222-C      |07/01/1989                   |07/01/1989                  |Ggn City   | Bang  | a-12    |  No                |B3             | DEL           | C3             |TEXAS               |73301          |8800340917      |9414710604      |c@uhg.com   |c@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1213       | 123458       |       Yes                        | I     |J       | K     | L               | TEXAS        |73301    | 8800340917   | 11/12/1999    |     Yes                   |3333          |   Yes                    |   ZEX                      |456    | 3333   |  Yes              | Yes                     |1114    |  yes                          |Abc          |kumar           |saini        | brother                   | b-12      | agra     | banglow2    | TEXAS        |73301   |9414710604     |  Agree          |
  	
  	 
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
	| Zip Code    | <zipcode> |
	| County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
	| Plan Type | <planType> |
And the user validates the plan summary for the below plan in AARP site
	| Plan Name | <planName> |
And the user view plan details of the above selected plan in AARP site
And the user click on enroll link on plan details for the below plan in AARP site

	
	Examples:
  	|zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender	| medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city	  | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  	|80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | First   |  m          |  last  |01/01/1940 |  Male		| 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234	    | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
  	|80002   |Adams County | PDP        |AARP MedicareRx Preferred (PDP)                     |No    | miller  |  j          |desh    |11/12/1989 |  Male		| 222-22-2222-C      |07/01/1989                   |07/01/1989                  |Ggn City   | Bang  | a-12    |  No                |B3             | DEL           | C3             |TEXAS               |73301          |8800340917      |9414710604      |c@uhg.com   |c@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1213       | 123458       |       Yes                        | I     |J       | K     | L               | TEXAS        |73301    | 8800340917   | 11/12/1999    |     Yes                   |3333          |   Yes                    |   ZEX                      |456    | 3333   |  Yes              | Yes                     |1114    |  yes                          |Abc          |kumar           |saini        | brother                   | b-12      | agra     | banglow2    | TEXAS        |73301   |9414710604     |  Agree          |