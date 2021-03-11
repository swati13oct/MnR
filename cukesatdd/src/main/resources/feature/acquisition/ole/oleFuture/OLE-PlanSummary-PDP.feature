Feature: 1.05.3 OLE common tool flow E2E PDP

  #@acquisitionRegression @PDP_OLE_AARP @junerelease2018 @september_release_2018 @december_release_2018 @OLE_DNSP_AARP @MACRAvalidation @OEP_CHANGES @OLE_Regression_Ulayer
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from <site> Acquisition site VPP Plan Summary
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information    
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
     # | PartA Date         | <partadate>         |
     # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
#    Then the user navigates to Preliminary Questions Page
     Then the user validates Medicare Number and not required ESRD question on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
     |Plan Year | <planYear> |
#    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
    | Prescription Name			| <prescriptioncoveragename>  |
    |  PD Group Number			 | <pdgroupnumber>  |
    | PD Member Number        | <pdmembernumber>   | 
    Then the user navigates to SEP Page
       |	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
   			 | MedicaidNumber | <medicaidnumber> |
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
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
		#Then the user validates the OLE Submission Details in GPS
    	#| Plan Type | <plantype> |
		# | Rider Flag | <riderflag> |
		 #| Mailing Address Question | <mailingaddressquestion> |
		
    
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type
  
  
  @PDP_OLE_Ulayer_Future
    Examples: 
      | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
     # | 15522 | PDP-MBI  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | MARDI     | HOMRIGHAUS | 2E83G82MM17    | false   |  02012003 |           |                | false  |09141951  | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
     # | 15523 | PDP-MBI  |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | ULDIS      | DELMONT      | 5NR9HH8GC33     | false   |       |  07011998 |            | false    | 03131947 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
     # | 15524 | PDP-MBI  |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)  | MBI      | MARDI     | HOMRIGHAUS | 2E83G82MM17    | false   |  02012003 |           |              | false    | 09141951 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
		#	| 15525 | AARP|PDP-MBI  | future|future|  90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK24    | false   |  11012015 |           |  431665465              | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |
      | 15526 | AARP|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK25    | false   |           |  11012015 |   0123456789              | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO			|PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Pay By Mail||||
    #  | 15527 | AARP|PDP-MBI  | future|future|  80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)  | MBI      | John      | Doe      | 3A33C22YK26    | false   |  11012015 |           | 0123456789                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Credit Card|5411111111111115|04|24|
	
	@PDP_OLE_Ulayer_Future @prodRegression
    Examples: 
      | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
      | 15526 | AARP|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK25    | false   |           |  11012015 |   0123456789              | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO			|PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Social Security or Railroad Retirement Benefit||||
	    
  @PDP_OLE_UHC_Future
    Examples: 
      | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
     # | 15522 | PDP-MBI  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | MARDI     | HOMRIGHAUS | 2E83G82MM17    | false   |  02012003 |           |                | false  |09141951  | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
     # | 15523 | PDP-MBI  |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | ULDIS      | DELMONT      | 5NR9HH8GC33     | false   |       |  07011998 |            | false    | 03131947 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
     # | 15524 | PDP-MBI  |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)  | MBI      | MARDI     | HOMRIGHAUS | 2E83G82MM17    | false   |  02012003 |           |              | false    | 09141951 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid |
		#	| 15525 | UHC|PDP-MBI  | future|future|  90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK24    | false   |  11012015 |           |   431665465             | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |
      | 15526 | UHC|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK25    | false   |           |  11012015 | 0123456789                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                  | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO			|PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Pay By Mail||||
    #  | 15527 | UHC|PDP-MBI  | future|future|  80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)  | MBI      | John      | Doe      | 3A33C22YK26    | false   |  11012015 |           |  0123456789             | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Credit Card|5411111111111115|04|24|
     
    @PDP_OLE_UHC_Future @prodRegression
    Examples: 
      | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
      | 15526 | UHC|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK25    | false   |           |  11012015 | 0123456789                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                  | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO			|PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Social Security or Railroad Retirement Benefit||||
    
  #@PDP_OLE_Ulayer_Future
   Examples: 
      | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
      | 15518 | AARP|PDP-MBI  | future|future|   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |0123456789                 | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Social Security or Railroad Retirement Benefit||||
     
     # | 15516 | PDP-MBI  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |                | false    | 04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
     # | 15517 | PDP-MBI  |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |                | false    | 04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
     #| 15519 | AARP|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK21   | false   |  11012015 |  11012015 |431665465                | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |
	
    #@PDP_OLE_Ulayer_Future 
   # Examples: 
     # | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county       | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
    #  | 15520 | PDP-MBI  |   80002 | YES             | Adams County | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002|                | false    |  04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
			#| 15521 | AARP|PDP-MBI  | future|future|   80002 | YES             | Adams County | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | John      | Doe      | 3A33C22YK23    | false   |  11012015 |  11012015 | 431665465               | false    | 01011983 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|

    #@PDP_OLE_UHC_Future 
    Examples: 
      | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|
      | 15518 | UHC|PDP-MBI  | future|future|   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |  0123456789               | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Social Security or Railroad Retirement Benefit||||
     # | 15516 | PDP-MBI  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |                | false    | 04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
     # | 15517 | PDP-MBI  |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |                | false    | 04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
     # | 15519 | UHC|PDP-MBI  | future|future|  80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP) | MBI      | John      | Doe      | 3A33C22YK21   | false   |  11012015 |  11012015 |  431665465              | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |
	
   # @PDP_OLE_UHC_Future 
   # Examples: 
    #  | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county       | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
    #  | 15520 | PDP-MBI  |   80002 | YES             | Adams County | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002|                | false    |  04261944 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |Valid |
		#	| 15521 | UHC|PDP-MBI  | future|future|   80002 | YES             | Adams County | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | John      | Doe      | 3A33C22YK23    | false   |  11012015 |  11012015 |  431665465              | false    | 01011983 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CO           |      80002 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|


    