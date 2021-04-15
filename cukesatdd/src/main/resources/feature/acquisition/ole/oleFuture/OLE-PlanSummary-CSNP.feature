Feature: 1.05.4 OLE common tool flow E2E CSNP

 Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition <site> VPP Plan Summary
       Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
		And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
		And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
   Then the user validates the Plan details on OLE
   Then the user validates TFN in Welcome OLE Right Rail
   Then the user validates Footer links on Welcome OLE Page
  Then the user validates Learn more modal for Welcome OLE
   Then the user validates Leave OLE modal for Welcome OLE
   Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    	Then the user enters following information in Personal Information Page DSNP
      # | Email Confirmation | <emailConfirmation> |
     #| Go Green           | <goGreen>           |
      | Email              | <email>             |
      |Home Number             | <phoneno>       |
      | Mobile Number          | <mobileno>      |   
      | Middle Name         | <middlename>       |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information    
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
    #  | PartA Date         | <partadate>         |
    #  | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
    #  | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
#    Then the user navigates to Preliminary Questions Page
	#Then the user validates Medicare Number and not required ESRD question on Medicare Info Page
	 Then the user validates Medicaid Number in confirm Eligibility Page
      | MedicaidNumber | <medicaidnumber> |
     	|Plan Year | <planYear> |  
    Then the user validates the required fields for CSNP plans on Medicare Information Page
      	|diabetesQuestion1|<diabetesQ1>|
      	|diabetesQuestion2|<diabetesQ2>|
       	|chronicHeartFailure1|<chronicQ1>|
       	|chronicHeartFailure2|<chronicQ2>|
        |chronicHeartFailure3|<chronicQ3>|
        |cardioVasculardisorder1|<cardioQ1>|
        |cardioVasculardisorder2|<cardioQ2>|
        |cardioVasculardisorder3| <cardioQ3>|
        |cardioVasculardisorder4|<cardioQ4>|
        |cardioVasculardisorder5  |<cardioQ5>|
 				|cardioVasculardisorder6  |<cardioQ6>|
#		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
    | Health Insurance Name| <healthinsurancename>  |
    |   Group Number			 | <groupnumber>          |
    | Member Number        | <membernumber>         | 
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
    | Prescription Name			| <prescriptioncoveragename>  |
    |  PD Group Number			 | <pdgroupnumber>  |
    | PD Member Number        | <pdmembernumber>   | 
    Then the user navigates to Disclosure Authorization Page for Medicaid and Effective date CSNP Plans
      |	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
   Then the user enters provider details in Use and Disclosure Authorization page for CSNP and navidates to Personal information page
      |	Provider Name			           | <providername>       |
    	| Provider Street Address      | <provideraddress>   |
   		| City        								 | <providercity>       |
   		| Zip                          | <providerzipcode>   |
   		| Provider Phone Number        | <providernumber>     |
   		| Mailing_State            | <mailingstate>           |
   #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
     Then the user selects payment type
    | Payment Type | <paymentType> |
    | Card No | <cardno> |
    | Card Expiration Month | <cardexpirationmonth> |
    | Card Expiration Year | <cardexpirationyear> |
    | Card Holder First Name               | <firstname>              |
    | Card Holder Last Name                | <lastname>               |    
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
     Then the user validates required fields for Authorization Page Representative
      	|authorizationFirstname|<authorizefirstN>|
      	|authorizationLastname|<authorizelastN>|
       	|authorizationAddress|<authorizeaddress>|
       	|authorizationApartmentSuite|<authorizeapartment>|
        |authorizationCity|<authorizecity>|
        |authorizationZip|<authorizezip>|
        |authorizationPhoneNo|<authorizephonenumber>|
        |authorizationRelationship| <authorizeRelationship>|
        |authorizationStateDisplay|<authorizestate>|
        |authorizationAgree  |<authorizationagree>|
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		Then the user validates the OLE Submission Details in GPS
    	| Plan Type | <plantype> |
	    | Auth Flag | <authflag> |
		 | Mailing Address Question | <mailingaddressquestion> |
	@CSNP_OLE_AARP_Future
    Examples: 
      | TID   | PlanType |site| planyear|planYear|zipcode | isMultutiCounty | county       | plantype | planName                                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen |phoneno   | mobileno |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|diabetesQ1|diabetesQ2|chronicQ1|chronicQ2|chronicQ3|cardioQ1|cardioQ2|cardioQ3|cardioQ4|cardioQ5|cardioQ6|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
     # | 15586 | CSNP-MBI |AARP| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)           | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|
    	| 15587 | CSNP-MBI |AARP| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET32    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Pay By Mail||||
    	#| 15588 | CSNP-MBI |AARP| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)      | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET33    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |yes          | true    | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              		|Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Credit Card|5411111111111115|04|24|
    	| 15588 | CSNP-MBI |AARP| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)      | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET33    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |yes          | true    | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              		|Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Social Security or Railroad Retirement Benefit||||
    
    @CSNP_OLE_UHC_Future
    Examples: 
      | TID   | PlanType |site| planyear|planYear|zipcode | isMultutiCounty | county       | plantype | planName                                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen |phoneno   | mobileno |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|diabetesQ1|diabetesQ2|chronicQ1|chronicQ2|chronicQ3|cardioQ1|cardioQ2|cardioQ3|cardioQ4|cardioQ5|cardioQ6|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
    #  | 15586 | CSNP-MBI |UHC	| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)           | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|
    	| 15587 | CSNP-MBI |UHC	| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET32    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Pay By Mail||||
    #	| 15588 | CSNP-MBI |UHC	| future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)      | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET33    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |yes          | true    | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|                 |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Credit Card|5411111111111115|04|24|
    	| 15588 | CSNP-MBI |UHC | future  |future |  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)      | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET33    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                    |     123 Mcgee st          |   IRVING          | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |yes          | true    | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|              		|Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|yes|No|No|No|No|No|No|No|No|No|No|true|Social Security or Railroad Retirement Benefit||||
    

  