@enrollDTM
Feature: To test DTM id and DTM name on enrollment flow on AARP site 
Scenario Outline: Verify DTM id and DTM name on enrollment flow on AARP site for federal plan type member  
Given the user is on the AARP site landing page
When user performs plan search using following information on AARP site
	| Zip Code    | <zipcode> |
	| County Name | <countyName>  |
And the user views plans of the below plan type on AARP site
	| Plan Type | <planType> |
And the user click on enroll link  for the below plan on AARP site 
	| <planName> |
And the user fill following information in introduction information step on AARP site
     | First Name                        | <firstName>		    |
     | Middle Initial                    | <middleInitial>	    |
     | Last Name                         | <lastName>		    |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   | 	
And the user navigates to beneficiary information step in AARP site	
And the user validate DTM object  on beneficiary information
And the user fill following information in beneficiary information step on AARP site
	 | Email Address			 | <emailAddress>	    |
     | Main Phone Number		 | <mainPhoneNumber>	|  
     | Other Phone Number		 | <otherPhoneNumber>	|
     | Birth Date                | <birthDate>		    |
     | Gender                    | <selectedGender>	    |
     | Language Preference		 | <languagePreference> |
     | Address                   | <address>		    |  
     | Apartment                 | <apartment>		    |
     | City                      | <city>		    	|
     | Same Mailing Address		 | Yes			   		|
And the user is on the special election period page

	Examples:
  	|zipcode |countyName   | planType   | planName                                           |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate 	  |selectedGender |languagePreference |address    |  city	  | apartment | 
	|80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)| First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111  | 12-20-1950|Male	  |Spanish			  |1234		  | Colorado  | UHG		  |
  	