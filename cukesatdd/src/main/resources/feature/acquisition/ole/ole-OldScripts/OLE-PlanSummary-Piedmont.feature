Feature: 1.05.1.ACQ-OLE common tool flow E2E Piedmont

  #@acquisitionRegression @Piedmont_OLE_AARP @decrelease2019 @OLE_Regression_Ulayer @F365255
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary for Piedmont plans
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
    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		#Then the user validates the OLE Submission Details in GPS
   # | Plan Type | <plantype> |
    @Piedmont_OLE_Ulayer @prodRegression @Piedmont_OLE_AARP
   Examples: 
      | TID     | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county         | plantype | planName                                    | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | F365255 | AARP|MA-MBI      | current|current|  24095 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option One (PPO)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | F365255 | AARP |MA-PFFS-MBI | current|current|  24571 | YES             | Bedford County | MAPD     | Piedmont Select Medicare Option Two (PPO)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002|      231665465 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | VA           |      24571 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | F365255 | AARP |MA-MBI      | current| current| 24526 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option Three (PPO) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24526 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		#	| F365255 | MA-MBI      | current|  24095 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option One (PPO)   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |InValid|
    #  | F365255 | MA-PFFS-MBI |   24571 | YES             | Bedford County | MAPD     | Piedmont Select Medicare Option Two (PPO)   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 04011983 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | VA           |      24571 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | no           | false     | NO                | NO      |InValid|
     # | F365255 | MA-MBI      |   24526 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option Three (PPO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 05011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24526 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |InValid|
		
		
		   @Piedmont_OLE_UHC @prodRegression
    Examples: 
      | TID     | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county         | plantype | planName                                    | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | F365255 | UHC |MA-MBI      | current|current|  24095 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option One (PPO)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | F365255 | UHC |MA-PFFS-MBI | current|current|  24571 | YES             | Bedford County | MAPD     | Piedmont Select Medicare Option Two (PPO)   | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002|      231665465 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | VA           |      24571 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
      | F365255 | UHC |MA-MBI      | current| current| 24526 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option Three (PPO) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24526 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		#	| F365255 | MA-MBI      | current|  24095 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option One (PPO)   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |InValid|
    #  | F365255 | MA-PFFS-MBI |   24571 | YES             | Bedford County | MAPD     | Piedmont Select Medicare Option Two (PPO)   | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 04011983 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | VA           |      24571 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | no           | false     | NO                | NO      |InValid|
     # | F365255 | MA-MBI      |   24526 | NO              | Bedford County | MAPD     | Piedmont Select Medicare Option Three (PPO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 05011983 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | VA           |      24526 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |InValid|
		
		