Feature: 1.05.4.ACQ-OLE  common tool flow E2E SNP AARP

  @SNP_OLE_AARP_mobile
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
	And the user views the plans of the below plan type in AARP site
		   | Plan Type | <plantype> |
	# And the user selects plan year for the AARP site
      |Plan Year | <planYear> |
  #  And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow mobile
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE mobile
    Then the user validates TFN in Welcome OLE Right Rail mobile
    Then the user validates Learn more modal for Welcome OLE mobile
    Then the user validates Leave OLE modal for Welcome OLE mobile
    Then the user validates cancellation modal for Welcome OLE mobile
     Then the user navigates to Personal Information Page mobile
    Then the user enters following required information in Personal Information Page mobile
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail mobile
    Then the user validates the Member details dynamic display in Personal Information Page mobile
    Then the user navigates to Medicare Information Page mobile
   # Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information mobile
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
    #  | PartA Date         | <partadate>         |
    #  | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates the Plan details in Medicare Info OLE Right Rail mobile
#    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd ESRD on Medicare Info Page mobile
      | MedicaidNumber | <medicaidnumber> |
       |Plan Year | <planYear> |
#    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page mobile
    Then the user answers following questions in Medicare Information Page mobile
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
          Then the user validates the long term questions in Medicare Information Page mobile
    | Health Insurance Name| <healthinsurancename>  |
    |   Group Number			 | <groupnumber>          |
    | Member Number        | <membernumber>         | 
    Then the user validates the Prescription drug coverage questions in Medicare Information Page mobile
    | Prescription Name			| <prescriptioncoveragename>  |
    |  PD Group Number			 | <pdgroupnumber>  |
    | PD Member Number        | <pdmembernumber>   | 
    Then the user navigates to SEP Page mobile
      	|	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page mobile
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page
#    Then the user navigates to Proposed Effective Date Page mobile
 #   Then the user validates Proposed Effective Date is Displayed mobile
  #  Then the user navigates to PCP Page and validates PCP page is not displayed for PDP mobile
   # Then the user validates PCP page for MA and MAPD PFFS plans mobile
   # Then the user validates Look up Provider for MA MAPD and DSNP plans mobile.
   # Then the user navigates to Monthly Plan Premium Page mobile
   # Then the user navigates to Optional Benefits Page for following plans with available Riders mobile
    #  | Rider Flag | <riderflag> |
    #Then the user navigates to Authorization Page for plan as per following rider options mobile
    #  | Rider Flag | <riderflag> |
   # Then the user validates required fields for Authorization Page mobile
   # Then the user navigates to Review and Submit Page mobile
   # Then the user validates the Plan and Member details on Review and Submit Page mobile
   # Then the user clicks on Submit Enrollment to complete enrollment mobile
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type mobile.
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
		
		
    Examples: 
      | TID   | PlanType     | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 15574 | PCP-DSNP-MBI |  current |current | 40046 | YES              | Spencer County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | KY           |      40046 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 	#| 15574 | PCP-DSNP-MBI |  current |current | 40046 | YES              | Spencer County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | KY           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 	