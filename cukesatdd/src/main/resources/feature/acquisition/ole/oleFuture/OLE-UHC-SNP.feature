Feature: 2.05.4.ACQ-OLE SNP UMS

  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
  And the user selects future plan year for the UHC site
    |Plan Year | <planYear> |
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
    #  | PartB Date         | <partbdate>         |
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
    Then the user navigates to SEP Page
        	|	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
    Then the user validates the Plan details in SEP Page OLE Right Rail
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
		#Then the user validates the OLE Submission Details in GPS
   # | Plan Type | <plantype> |
  @SNP_OLE_UHC_Future
   Examples: 
      | TID   | PlanType        | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15575 | Medica-DSNP-MBI | future|future|  33143 | NO              | Miami-Dade County | SNP      | Medica HealthCare Plans MedicareMax Plus (HMO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018       | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|

  #@SNP_OLE_AARP_CSNP @OLE_Regression_Blayer  @SNP_OLE_UHC
  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
         And the user selects plan year for the UMS site
    |Plan Year | <planYear> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
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
    Then the user validates the Plan details in Medicare Info OLE Right Rail
#    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd ESRD on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
		Then the user validates the required fields for CSNP plans on Medicare Information Page
   		 | MedicaidNumber | <medicaidnumber> |
#		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
#    Then the user answers following questions in Medicare Information Page
#      | PDP Question      | <pdpFlag>      |
#      | LongTerm Question | <longTermFlag> |
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
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
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
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
     #@SNP_OLE_UHC
    Examples: 
      | TID   | PlanType |Plan Year|planYear| zipcode | isMultutiCounty | county       | plantype | planName                                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15559 | CSNP-MBI | current|current|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)         | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | 15560 | CSNP-MBI |current| current|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | 15561 | CSNP-MBI | current|current|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
	#		| 15559 | CSNP-MBI | current|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)         | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |InValid|
   #   | 15560 | CSNP-MBI |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 04011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |InValid|
   #   | 15561 | CSNP-MBI |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 05011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |InValid|
	#@SNP_OLE_AARP_Future
    Examples: 
      | TID   | PlanType |Plan Year|planYear| zipcode | isMultutiCounty | county       | plantype | planName                                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15559 | CSNP-MBI | future|future|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)         | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | 15560 | CSNP-MBI |future|future|   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | 15561 | CSNP-MBI | future|future|  78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|

			

@SNP_OLE_UHC_DSNP
  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
         And the user selects plan year for the UMS site
    |Plan Year | <planYear> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    #Then the user validates the Plan details on OLE
    #Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    #Then the user validates Leave OLE modal for Welcome OLE
    #Then the user validates cancellation modal for Welcome OLE
    #Then the user navigates to Personal Information Page
    Then the user navigates to Medicare Information Page for DSNP
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Informations for DSNP   
    	| First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Number         | <SSNnumber>       	 |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd ESRD on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
       |Plan Year | <planYear> |
     Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
     	|	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
    Then the user validates the Plan details in SEP Page OLE Right Rail
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
		#Then the user validates the OLE Submission Details in GPS
    #| Plan Type | <plantype> |
    #    Then the user validates Plan and Member Details on Confirmation Page
    #   Then the user Validates Next Steps in Confirmation Page for the Plan Type.
    @SNP_OLE_UHC_DSNP
   		Examples: 
      | TID   | PlanType        | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag |SSNnumber| partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |inputdataType|
      | 15576 | DSNP-MBI        | current|current|  10001 | NO              | New York County   | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)           | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET34    | false   |   11012002 |  01012006 |     0523456789 | true     | 04261944 | Female | 004 Morris Rd | New York    | Yes                    | 803 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid|
 		#	| 15576 | DSNP-MBI        |   10001 | NO              | New York County   | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)           | MBI      | John      | Doe      | 2n22C33YK33    | true    | 123456789 |01012010 |  01012010 |     0523456789 | true     | 01011983 | Female | 004 Morris Rd | New York    | Yes                    | 803 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |InValid|
      @SNP_OLE_UHC_DSNP_Future
      Examples: 
      | TID   | PlanType        | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag |SSNnumber| partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |inputdataType|
      | 15576 | DSNP-MBI        | future|future|  10001 | NO              | New York County   | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)           | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET34    | false   |   11012002 |  01012006 |     0523456789 | true     | 04261944 | Female | 004 Morris Rd | New York    | Yes                    | 803 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid|
 		#	|