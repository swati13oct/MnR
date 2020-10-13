Feature: 1.5.ACQ-OLE common tool flow E2E Shop Pages

  	Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for plans
    And click on how to enroll shop pages
     	| Plan Type | <plantype> |
      | Plan Name | <planName> |
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
    	Then the user validates requierd ESRD on Medicare Info Page
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
    Then the user navigates to SEP Page
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
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
  
   @ShopPage_OLE
   Examples: 
     | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 15572 | AARP|PCP-DSNP-MBI |  current |current | 33143 | NO              | Miami-Dade County | SNP      |  UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 	
     @ShopPage_OLE
    Examples: 
      | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15573 | UHC|PCP-DSNP-MBI | current|current|  33143 | NO              | Miami-Dade County | SNP      |  UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018       | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
  
    #Examples:   
    # | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     #| 11111 | AARP|PCP-DSNP-MBI |  current |current | 33143 | NO              | Miami-Dade County | SNP      |  UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 		 #| 11112 | UHC|PCP-DSNP-MBI |  current |current | 33143 | NO              | Miami-Dade County | SNP      	|  UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 		
 		
 		