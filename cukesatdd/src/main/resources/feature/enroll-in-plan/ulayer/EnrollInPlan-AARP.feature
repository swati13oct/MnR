@enrollInPlan
Feature: To test enroll in plan on AARP site 
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
	| Zip Code    | <zipcode> |
	| County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
	| Plan Type | <planType> |
And the user enrolls for the below plan in AARP site
	| <planName> |
And the user navigates to introduction information step in AARP site
And the user fill following information in introduction information step in AARP site
     | First Name                        | <firstName>		    |
     | Middle Initial                    | <middleInitial>	    |
     | Last Name                         | <lastName>		    |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
And the user navigates to beneficiary information step in AARP site
And the user fill following information in beneficiary information step in AARP site
     | Email Address			 | <emailAddress>	    |
     | Main Phone Number		 | <mainPhoneNumber>	|  
     | Other Phone Number		 | <otherPhoneNumber>	    |
     | Birth Date                | <birthDate>		    |
     | Gender                    | <selectedGender>	    |
     | Language Preference		 | <languagePreference> |
     | Address                   | <address>		    |  
     | Apartment                 | <apartment>		    |
     | City                      | <city>		    	|
     | Same Mailing Address		 | Yes			   		|
And the user select the answer of this question Do you have End-Stage Renal Disease in AARP site
	|<answer>|
And the user navigates to Additional Information step in AARP site
And the user reviews the personal and plan data by naviagting to Review application step in AARP site
And the user navigates to submit application step in AARP site
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in AARP site
And the user submits application by selecting agree to the Statement of Understanding in AARP site
Then the user validates the enrollment application confimation in AARP site
Examples:
  |zipcode |countyName   | planType   | planName                                           |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate 	  |selectedGender |languagePreference |address    |  city	  | apartment | 
|80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)| First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111  | 12-20-1950|Male	  |Spanish			  |1234		  | Colorado  | UHG		  |
|80002   |Adams County | PDP        |AARP MedicareRx Preferred (PDP)| First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111  | 12-20-1950|Male	  |Spanish			  |1234		  | Colorado  | UHG		  |