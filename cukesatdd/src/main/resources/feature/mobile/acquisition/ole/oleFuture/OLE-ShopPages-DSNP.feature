Feature: 1.05.9 OLE Common tool Mobile Flow E2E Shop Pages

  	Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from E2E Shop Pages-MA,SNP PLans
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
     Then the user validates the long term questions in Medicare Information Page
    | Health Insurance Name| <healthinsurancename>  |
    |   Group Number			 | <groupnumber>          |
    | Member Number        | <membernumber>         | 
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
    | Prescription Name			| <prescriptioncoveragename>  |
    |  PD Group Number			 | <pdgroupnumber>  |
    | PD Member Number        | <pdmembernumber>   | 
    Then the user navigates to SEP Page for Medicaid and Effective date
      |	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
   			 | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in SEP Page OLE Right Rail
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page   
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
   # Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
   Then the user validates the Plan and Member details on Review and Submit Page
   #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
   #@ShopPage_OLE_Future_AARP
    Examples:   
     | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 11111 | AARP|PCP-DSNP-MBI |  future|future | 31062 | NO              | Baldwin County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 		 | 11112 | AARP|MAPD-RRID-MBI|future|future |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011983 | Male   | 001 Morris Rd | New York | Yes                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		
	#@ShopPage_OLE_Future_UHC
    Examples:   
     | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 11113 | UHC|PCP-DSNP-MBI |  future|future | 31062 | NO              | Baldwin County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 		 | 11114 | UHC|MAPD-RRID-MBI|future|future |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011983 | Male   | 001 Morris Rd | New York | Yes                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from E2E Shop Pages-PDP PLANS
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
    #Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    #Then the user validates Leave OLE modal for Welcome OLE
    #Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      #| Perm_Aptno              | <permaptno>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      #| Mailing_Aptno            | <mailingaptno>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
     Then the user enters following information in Personal Information Page
      | Email Confirmation | <emailConfirmation> |
     | Go Green           | <goGreen>           |
      | Email              | <email>             |
      |Home Number             | <phoneno>       |
      | Mobile Number          | <mobileno>      |   
      | Middle Name         | <middlename>         |
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
     # | Email Confirmation | <emailConfirmation> |
      #| Go Green           | <goGreen>           |
      #| Email              | <email>             |
    #Then the user validates TFN in Medicare Info OLE Right Rail
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
    Then the user navigates to SEP Page for Medicaid and Effective date
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
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    #Then the user validates required fields for Authorization Page
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
        |authorizationAgree|<authorizationagree>|
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
    
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type
   # @ShopPage_OLE_Future_AARP 
    Examples: 
      | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber          | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |healthinsurancename|groupnumber  | membernumber    |prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|phoneno   | mobileno |middlename        |authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|
      | 11115 | AARP|PDP-MBI  | future |future  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |431665465                | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |            | false     | NA         | NA         | NA          | NA          | NO                | NO      |                   |             |                 |PrescriptionCoverage            |PD5646136   | BCD12345EFG |InValid |1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|
     
    # @ShopPage_OLE_Future_UHC 
    Examples: 
      | TID   | site|PlanType |planyear|planYear| zipcode | isMultutiCounty | county             | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber          | esrdflag | dob      | gender | permstreet    | permaptno    | permcity    | mailingaddressquestion | mailingstreet |mailingaptno| mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |healthinsurancename|groupnumber  | membernumber    |prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|phoneno   | mobileno |middlename        |authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|
      | 11116 | UHC |PDP-MBI  | future|future   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)  | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |431665465                | false    | 01011988 | Female | 002 Morris Rd | 85           | Los Angeles | no                     | 802 MailingSt | 30         | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     |            | false     | NA         | NA         | NA          | NA          | NO                | NO      |                   |             |                 |PrescriptionCoverage    |PD5646136   | BCD12345EFG |InValid |1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|
     