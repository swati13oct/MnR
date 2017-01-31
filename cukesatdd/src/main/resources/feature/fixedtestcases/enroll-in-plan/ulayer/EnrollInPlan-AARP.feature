@fixedTestCase
Feature: To test enroll in plan on AARP site 
Scenario Outline: Verify enroll in plan in AARP site for federal plan type member  PDP member
Given the user is on AARP medicare site landing page
When user performs plan search using following information in AARP site
               | Zip Code    | <zipcode> |
               | County Name | <countyName>  |
And the user views plans of the below plan type in AARP site
               | Plan Type | <planType> |
And the user enrolls for the below plan in AARP site
               | <planName> |
Examples:
|zipcode |countyName          | planType  | planName                       |firstName|middleInitial|lastName| medicareClaimNumber|hospitalEffectiveDate |  medicalEffectiveDate  | emailAddress |mainPhoneNumber | otherPhoneNumber |birthDate    |selectedGender |languagePreference |address |  city    | apartment |sep1|sep2|sep4|sep5|sep6|sep7|sep8|sep9|sepOther| sepDate1 | sepDate2    | sepDate5  | sepDate6    |sepOtherReason |esrdradiooption |pdcradiooption |pdchealthinsurname|pdcgroupidnumber|pdcmemberidnumber|ltcradiooption |ltcname|ltcstreetaddr|ltcapt|ltccity|ltcphonenum |ltcdatemoved|planpaymentoption|effectiveDate|agreeStmtUnderstanding|authRepresent|
|90210   |Los Angeles County  | PDP       |AARP MedicareRx Preferred (PDP) | First   |  m          |  last  | 112-11-1117-A      |07/01/1988            |      07/01/1988        | test@uhc.com | 999-991-1111   | 999-991-1111     | 12-20-1950  |Male           |Spanish            |1234    | Colorado | UHG       |No  |Yes |No  |No  |No  |No  |No  |No  |No      | 02/15/2016| 02/15/2016 |02/15/2016 | 02/15/2016  |Test           |No              |Yes            | abc              |abc             |123              |Yes            |first  |123          |1     |abc    |666-666-6666|12-20-1982   |  No            |10-01-2016   |Agree|Agree|