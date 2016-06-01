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
And the user select no for Special Election Period   
	| Plan Type | <planType> |
#And the user select yes for Special Election Period
And the user navigates to esrd step in AARP site
And the user fill following information in esrd information step in AARP site
    | esrdradiooption                                       | <esrdradiooption>             |
And the user navigates to prescription drug coverage step in AARP site
And the user fill following information in prescription drug coverage step in AARP site
    | pdcradiooption                                        | <pdcradiooption>               |
    | pdchealthinsurname | <pdchealthinsurname>                 |  
    | pdcgroupidnumber     | <pdcgroupidnumber>      |
    | pdcmemberidnumber    | <pdcmemberidnumber>           |
And the user navigates to long term care step in AARP site
And the user fill following information in long term care step in AARP site
               | Plan Type | <planType> |
    | ltcradiooption                                          | <ltcradiooption>               |
    | ltcname                   | <ltcname>                                                                        |  
    | ltcstreetaddr                | <ltcstreetaddr>               |
    | ltcapt                                                                                         | <ltcstreetaddr>                 |
    | ltccity                       | <ltccity>                                                |  
    | ltcphonenum                                                            | <ltcphonenum>                                             |
    | ltcdatemoved                             | <ltcdatemoved>                                         |
And the user navigates to medicaid step in AARP site
And the user fill following information in medicaid step in AARP site
               | Plan Type | <planType> |
               | medicaidradiooption                                  | <medicaidradiooption>                |
    | medicaidnum                         | <medicaidnum>                                                              |  
And the user navigates to other health insurance step in AARP site
And the user fill following information in other health insurance step in AARP site
               | othradiooption                                            | <othradiooption>                                                                       |
    | othnameofhealthinsur | <othnameofhealthinsur>                                      |  
                              | othgroupid                | <othgroupid>                                                                          |  
    | othmemberid                | <othmemberid>                        |
And the user navigates to primary care provider step in AARP site
And the user navigates to plan payment options step in AARP site
And the user fill following information in plan payment options step in AARP site
And the user navigates to optional Riders step in AARP site
And the user fill following information in optional Riders step in AARP site
               | optradiooption                                            | <optradiooption>                                                                       |
Examples:
#|zipcode |countyName          | planType  | planName                       |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate 	  |selectedGender |languagePreference |address    |  city	  | apartment |sep1|sep2|sep4|sep5|sep6|sep7|sep8|sep9|sepOther| sepDate1 | sepDate2   | sepDate5   | sepDate6    |sepOtherReason|
|zipcode |countyName          | planType  | planName                       |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate         |selectedGender |languagePreference |address    |  city                 | apartment |esrdradiooption |pdcradiooption |pdchealthinsurname|pdcgroupidnumber|pdcmemberidnumber|ltcradiooption |ltcname|ltcstreetaddr|ltcapt|ltccity|ltcphonenum|ltcdatemoved|medicaidradiooption|medicaidnum|othradiooption |othnameofhealthinsur|othgroupid|othmemberid|optradiooption|
#|80002   |Adams County        | MAPD       |AARP MedicareComplete SecureHorizons Plan 2 (HMO) | First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male                |Spanish                         |1234                              | Colorado  | UHG                           |No | Yes |abc|abc|123|
|90210   |Los Angeles County  | MA       |AARP MedicareComplete SecureHorizons Plan 2 (HMO) | First   |  m          |  last  | 111-11-1111-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male                        |Spanish                         |1234                              | Colorado  | UHG                           |No|Yes| abc|abc|123|Yes|first|123|1|abc|666-666-6666|12-20-1982|Yes|12|Yes|insurname|12|13246|No|
	 