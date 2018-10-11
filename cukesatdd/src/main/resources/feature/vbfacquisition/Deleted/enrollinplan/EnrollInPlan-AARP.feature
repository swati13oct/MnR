@fixedTestCaseTest
@enrollInPlanulayer
Feature:1.12-VBF-Acq-To test enroll in plan on AARP site
@OLE_MA
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  for MA or MAPD plan
Given the user is on AARP medicare site landing page OLE
When user performs plan search using following information in AARP site OLE
	| Zip Code    | <zipcode> |
	| County Name | <countyName>  |
And the user views plans of the below plan type in AARP site OLE
	| Plan Type | <planType> |
And the user enrolls for the below plan in AARP site OLE
	| <planName> |
And the user navigates to introduction information step in AARP site OLE
And the user fill following information in introduction information step in AARP site OLE
    | First Name                        | <firstName>		    |
    | Middle Initial                    | <middleInitial>	    |
    | Last Name                         | <lastName>		    |
    | Medicare Claim Number             | <medicareClaimNumber>    |  
    | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
    | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
And the user navigates to beneficiary information step in AARP site OLE
And the user fill following information in beneficiary information step in AARP site OLE
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
And the user navigates to sep step in AARP site OLE
#And the user select no for Special Election Period   
#	| Plan Type | <planType> |
And the user select yes for Special Election Period OLE
     | Plan Type        | <planType> |
     | SEP1 			| <sep1> 			|
	 | SEP2 			| <sep2> 			|
	 | SEP3 			| <sep3>			|
	 | SEP4 			| <sep4> 			|
	 | SEP5 			| <sep5> 			|
	 | SEP6 			| <sep6> 			|
#	 | SEP8 			| <sep8> 			|
#	 | SEP9 			| <sep9> 			|
	 | SEPOther 		| <sepOther> 		|
	 | SEPDate1 		| <sepDate1> 		|
	 | SEPDate2 		| <sepDate2> 		|
	 | SEPDate4			| <sepDate4>        |
	 | SEPDate5 		| <sepDate5> 		|
	 | SEPDate6 		| <sepDate6> 		|
	 | SEPOtherReason	| <sepOtherReason>  |
And the user navigates to esrd step in AARP site OLE
And the user fill following information in esrd information step in AARP site OLE
    | esrdradiooption                                       | <esrdradiooption>             |
And the user navigates to prescription drug coverage step in AARP site OLE
And the user fill following information in prescription drug coverage step in AARP site OLE
    | pdcradiooption                                        | <pdcradiooption>               |
    | pdchealthinsurname | <pdchealthinsurname>                 |  
    | pdcgroupidnumber     | <pdcgroupidnumber>      |
    | pdcmemberidnumber    | <pdcmemberidnumber>           |
And the user navigates to long term care step in AARP site OLE
And the user fill following information in long term care step in AARP site OLE
               | Plan Type | <planType> |
    | ltcradiooption                                          | <ltcradiooption>               |
    | ltcname                   | <ltcname>                                                                        |  
    | ltcstreetaddr                | <ltcstreetaddr>               |
    | ltcapt                                                                                         | <ltcstreetaddr>                 |
    | ltccity                       | <ltccity>                                                |  
    | ltcphonenum                                                            | <ltcphonenum>                                             |
    | ltcdatemoved                             | <ltcdatemoved>                                         |
And the user navigates to medicaid step in AARP site OLE
And the user fill following information in medicaid step in AARP site OLE
               | Plan Type | <planType> |
               | medicaidradiooption                                  | <medicaidradiooption>                |
    | medicaidnum                         | <medicaidnum>                                                              |  
And the user navigates to other health insurance step in AARP site OLE
And the user fill following information in other health insurance step in AARP site OLE
               | othradiooption                                            | <othradiooption>                                                                       |
    | othnameofhealthinsur | <othnameofhealthinsur>                                      |  
                              | othgroupid                | <othgroupid>                                                                          |  
    | othmemberid                | <othmemberid>                        |
And the user navigates to primary care provider step in AARP site OLE
And the user navigates to plan payment options step in AARP site OLE
#And the user fill following information in plan payment options step in AARP site
#  | Plan Type | <planType> |
#  | planpaymentoption |<planpaymentoption>|
And the user navigates to optional Riders step in AARP site OLE
And the user fill following information in optional Riders step in AARP site OLE
               | optradiooption                                            | <optradiooption>                                                                       |
And the user navigates to proposed effective date page OLE
And the user selects proposed effective date OLE
| Plan Type | <planType> |
And the user navigates to review and submit application step in AARP site OLE
| Plan Type | <planType> |
And the user reviews the information on review and submit application step in AARP site OLE
| Plan Type | <planType> |
|agreeStmtUnderstanding|<agreeStmtUnderstanding>|
|authRepresent| <authRepresent>|
Then the user navigates to Confirmation Page OLE
#And the user clicks on print this page button
Examples:
|zipcode |countyName          | planType | planName                                                     |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate         |selectedGender |languagePreference |address |  city    | apartment |sep1|sep2|sep3|sep4|sep5|sep6|sepOther| sepDate1 | sepDate2    |  sepDate4 | sepDate5  | sepDate6    |sepOtherReason|esrdradiooption |pdcradiooption |pdchealthinsurname|pdcgroupidnumber|pdcmemberidnumber|ltcradiooption |ltcname|ltcstreetaddr|ltcapt|ltccity|ltcphonenum |ltcdatemoved|medicaidradiooption|medicaidnum|othradiooption |othnameofhealthinsur|othgroupid|othmemberid|planpaymentoption|optradiooption|agreeStmtUnderstanding|authRepresent|
|90210   |Los Angeles County  | MA       |AARP MedicareComplete SecureHorizons Plan 2 (HMO)             | First   |  m          |  last  | 112111117A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950       |Male           |Spanish            |1234    | Colorado | UHG       |No  |Yes |No  |No  |No  |No  |No      | 02/15/2016| 02/15/2016 |02/15/2016 |02/15/2016 | 02/15/2016  |Test          |No              |Yes            | abc               |abc            |123              |Yes            |first  |123          |1     |abc    |666-666-6666|12-20-1982  |Yes                |12         |Yes            |insurname           |12        |13246      |Yes               |Yes          |Agree                 |Agree|

@OLE_PDP
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  PDP member
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
    | First Name                        | <firstName>                                 |
    | Middle Initial                    | <middleInitial>             |
    | Last Name                         | <lastName>                                 |
    | Medicare Claim Number             | <medicareClaimNumber>    |  
    | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
    | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
And the user navigates to beneficiary information step in AARP site
And the user fill following information in beneficiary information step in AARP site
    | Email Address                                           | <emailAddress>                |
    | Main Phone Number                | <mainPhoneNumber> |  
    | Other Phone Number                             | <otherPhoneNumber>               |
    | Birth Date                | <birthDate>                            |
    | Gender                    | <selectedGender>                  |
    | Language Preference                             | <languagePreference> |
    | Address                   | <address>                                |  
    | Apartment                 | <apartment>                        |
    | City                      | <city>                                        |
    | Same Mailing Address                            | Yes                                                                 |
And the user navigates to sep step in AARP site
And the user select no for Special Election Period   
              | Plan Type | <planType> |
#And the user select yes for Special Election Period
#     | Plan Type        | <planType> |
#     | SEP1 			| <sep1> 			|
#	 | SEP2 			| <sep2> 			|
#	 | SEP4 			| <sep4>			|
#	 | SEP5 			| <sep5> 			|
#	 | SEP6 			| <sep6> 			|
#	 | SEP7 			| <sep7> 			|
#	 | SEP8 			| <sep8> 			|
#	 | SEP9 			| <sep9> 			|
#	 | SEPOther 		| <sepOther> 		|
#	 | SEPDate1 		| <sepDate1> 		|
#	 | SEPDate2 		| <sepDate2> 		|
#	 | SEPDate5 		| <sepDate5> 		|
#	 | SEPDate6 		| <sepDate6> 		|
#	 | SEPOtherReason	| <sepOtherReason>  |
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
#And the user navigates to plan payment options step in AARP site
And the user fill following information in plan payment options step in AARP site
  | Plan Type | <planType> |
  | planpaymentoption |<planpaymentoption>|
And the user navigates to proposed effective date page
And the user selects proposed effective date
| Plan Type | <planType> |
And the user navigates to review and submit application step in AARP site
| Plan Type | <planType> |
And the user reviews the information on review and submit application step in AARP site
| Plan Type | <planType> |
|agreeStmtUnderstanding|<agreeStmtUnderstanding>|
|authRepresent| <authRepresent>|  
Then the user navigates to Confirmation Page
#And the user clicks on print this page button
Examples:
|zipcode |countyName          | planType  | planName                       |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate    |selectedGender |languagePreference |address |  city    | apartment |sep1|sep2|sep4|sep5|sep6|sep7|sep8|sep9|sepOther| sepDate1 | sepDate2    | sepDate5  | sepDate6    |sepOtherReason |esrdradiooption |pdcradiooption |pdchealthinsurname|pdcgroupidnumber|pdcmemberidnumber|ltcradiooption |ltcname|ltcstreetaddr|ltcapt|ltccity|ltcphonenum |ltcdatemoved|planpaymentoption|agreeStmtUnderstanding|authRepresent|
#|90210   |Los Angeles County  | PDP       |AARP MedicareRx Preferred (PDP) | First   |  m          |  last  | 112-11-1117-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male           |Spanish            |1234    | Colorado | UHG       |No  |Yes |No  |No  |No  |No  |No  |No  |No      | 02/15/2016| 02/15/2016 |02/15/2016 | 02/15/2016  |Test           |No              |Yes            | abc              |abc             |123              |Yes            |first  |123          |1     |abc    |666-666-6666|12-20-1982   |  No           |Agree|Agree|
