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
    | Other Phone Number		 | <otherPhoneNumber>	|
    | Birth Date                | <birthDate>		    |
    | Gender                    | <selectedGender>	    |
    | Language Preference		 | <languagePreference> |
    | Address                   | <address>		    |  
    | Apartment                 | <apartment>		    |
    | City                      | <city>		    	|
    | Same Mailing Address		 | Yes			   		|
And the user navigates to sep step in AARP site
#And the user select no for Special Election Period   
And the user select yes for Special Election Period
     | SEP1 			| <sep1> 			|
	 | SEP2 			| <sep2> 			|
	 | SEP4 			| <sep4>			|
	 | SEP5 			| <sep5> 			|
	 | SEP6 			| <sep6> 			|
	 | SEP7 			| <sep7> 			|
	 | SEP8 			| <sep8> 			|
	 | SEP9 			| <sep9> 			|
	 | SEPOther 		| <sepOther> 		|
	 | SEPDate1 		| <sepDate1> 		|
	 | SEPDate2 		| <sepDate2> 		|
	 | SEPDate5 		| <sepDate5> 		|
	 | SEPDate6 		| <sepDate6> 		|
	 | SEPOtherReason	| <sepOtherReason>  |
And the user navigates to proposed effective date page
And the user selects proposed effective date
     |EffectiveDate     | <effectiveDate>   |
Examples:
|zipcode |countyName          | planType  | planName                       |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate 	  |selectedGender |languagePreference |address    |  city	  | apartment |sep1|sep2|sep4|sep5|sep6|sep7|sep8|sep9|sepOther| sepDate1 | sepDate2   | sepDate5   | sepDate6    |sepOtherReason|
#|80002   |Adams County        | PDP       |AARP MedicareRx Preferred (PDP) | First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male	          |Spanish		      |1234		  | Colorado  | UHG		  |yes |no  |yes |no  |no  |no  |no  |no  |no      |12-31-2016| 12-31-2016 |12-31-2016  | 12-31-2016  |12-31-2016    |
|90210   |Los Angeles County  | PDP       |AARP MedicareRx Preferred (PDP) | First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male	          |Spanish		      |1234		  | Colorado  | UHG		  |yes |no  |yes |no  |no  |no  |no  |no  |no      |12-31-2016| 12-31-2016 |12-31-2016  | 12-31-2016  |12-31-2016    |