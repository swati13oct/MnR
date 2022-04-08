#Author: namita_meher@optum.com
Feature: OLE Enrol Pages

 @uhccp
 Scenario Outline: OLE Without County Selection - <zipcode> - Language: <lang>
    Given User is on the UHCCP landing page
    And the user selects language
    	|	Language	|	<lang> |
    When the user performs plan search in UHCCP homepage 
    	| Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
      | Plan Type 			| <plantype> 			|
      | Plan Name				| <planname>			|
      | Plan Year 			| <planyear> |
    And User views Plan Details of the below Plan
    	| Plan Name	| <planname>	|
    And the user clicks on Enroll in Plan and validates Welcome to OLE Page
   	Then the user navigates to OLE Personal Information Page
   	Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Middle Name              | <middlename>             |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Perm_AptNo               | <permaptno>              |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_AptNo            | <mailingaptno>           |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | Email Confirmation | <emailConfirmation>            |
      | Go Green           | <goGreen>                      |
      | Home Number        | <phoneno>                      |
      | Mobile Number      | <mobileno>                     |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | Card Type          | <cardtype>          |
   	Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Confirm your Eligibility Page
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the long term questions in Medicare Information Page
      | LongTerm Question 		| <longTermFlag> |
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
      |RX BIN Number      |	<rxBinnumber>              |
    Then the user navigates to SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user selects payment type
      | Payment Type           | <paymentType>         |
      | Card No                | <cardno>              |
      | Card Expiration Month  | <cardexpirationmonth> |
      | Card Expiration Year   | <cardexpirationyear>  |
      | Card Holder First Name | <firstname>           |
      | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Authorization Page
    Then the user validates required fields for Authorization Page Representative
      | authorizationFirstname      | <authorizefirstN>       |
      | authorizationLastname       | <authorizelastN>        |
      | authorizationAddress        | <authorizeaddress>      |
      | authorizationApartmentSuite | <authorizeapartment>    |
      | authorizationCity           | <authorizecity>         |
      | authorizationZip            | <authorizezip>          |
      | authorizationPhoneNo        | <authorizephonenumber>  |
      | authorizationRelationship   | <authorizeRelationship> |
      | authorizationStateDisplay   | <authorizestate>        |
    Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    #Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type
    
    
    Examples: 
      | zipcode | isMultiCounty	|	county					|	lang		|	plantype	|	planname																						|	firstname       | middlename      | lastname        | dob      | gender		| permstreet    				| permcity    |	permaptno	| mailingaddressquestion| mailingstreet | mailingaptno	|	mailingcity 	| mailingstate	| mailingzip	| email         |	emailConfirmation | goGreen | phoneno			| mobileno   		|	medicarenumber| ssnflag	|	cardtype	|	medicaidnumber	| partadate	|	partbdate	|	longTermFlag	|	healthinsurancename | groupnumber | membernumber	|	pdpFlag	|	prescriptioncoveragename | pdgroupnumber | pdmembernumber |	rxBinnumber	|	selectoptions           																																																																																									|	optiondata							|	paymentType | cardno  | cardexpirationmonth | cardexpirationyear	|	authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate |
      | 35057   | No						|	Cullman County	|	Es			|	DSNP			|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)		|	Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11111993 | Femenino	|	12529 State Road 535 	| Ste   			| 566				|	No										|	802 MailingSt	|	566						|	Montgomery    | AL						| 35057				|	test@test.com	|	<blank>						|	<blank>	|	9529314701	| 837-625-4803	| 1EG4TE5MK99		| false		|	MBI				|	1234567892 			| 05012015 	|	05012015	|	Sí						|	HealthInsurance     | HI1562759   | ABC12345DEF		|	Sí			|	PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|	Medicare Advantage (MA OEP en/Medicare (o mi estado)/(o mi estado me ayuda a pagar mis primas de Medicare)/lo declarado por la Agencia Federal para el Manejo de Emergencias [FEMA en											|	/12202018/ /12202018/ 	|	Pay By Mail | [blank] | [blank]             | [blank]							|	Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             |
      | 35057   | No						|	Cullman County	|	En			|	DSNP			|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)		|	Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11111993 | Femenino	|	12529 State Road 535 	| Ste   			| 566				|	No										|	802 MailingSt	|	566						|	Montgomery    | AL						| 35057				|	test@test.com	|	<blank>						|	<blank>	|	9529314701	| 837-625-4803	| 1EG4TE5MK99		| false		|	MBI				|	1234567892 			| 05012015 	|	05012015	|	yes						|	HealthInsurance     | HI1562759   | ABC12345DEF		|	yes			|	PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|	Medicare Advantage Open Enrollment Period (MA OEP)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA)	|	/12202018/ /12202018/ 	|	Pay By Mail | [blank] | [blank]             | [blank]							|	Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             |
      #| 85925   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Phoenix       | ARIZONA        | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 94501   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | San Francisco | CALIFORNIA     | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 14215   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Yonkers       | NEW YORK       | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 45693   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Akron         | OHIO           | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 45011   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Columbus      | OHIO           | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 17325   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Pittsburgh    | PENNSYLVANIA   | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 02809   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | War Wick      | RHODE ISLAND   | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 78520   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Houston       | TEXAS          | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      
 
 
 
 
 
 
 
 
 
 
 
 
 
    
   
