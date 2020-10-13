 Feature: 2.05.5. ACQ-OLE Campaign URL

  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from UHC Acquisition site VPP Plan Summary
  #Given the user is on VPP Plan Summary page after hits Campaign URL
  Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
     # | PageName | <pageName> |
      | PagePath | <path>     |
  	And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
		And the user validates the available plans for selected plan types
    #Then the user clicks on Enroll Now for AARP site to start the OLE flow
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
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
    #Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information    
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
    #  | PartA Date         | <partadate>         |
    #  | PartB Date         | <partbdate>         |
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
    Then the user navigates to SEP Page
        	|	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   		| PartB Date         | <partbdate>         |
   			 | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in SEP Page OLE Right Rail
   # Then the user validates SEP options and Required Fields for PlanType in SEP Page
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
    #Then the user navigates to Optional Benefits Page for following plans with available Riders
     # | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
	 
	 @Campaign_OLE_Ulayer @prodRegression 
    Examples: 
      #| TID   | site|zipcode |isMultutiCounty | county          |plantype |path                                                                                                                                                                                                        |PlanType  |planyear|planYear| planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType| 
     	#| 15564 | AARP|63043 |NO              |St. Louis County   |MA       |health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731| MAPD     | current|current |AARP Medicare Advantage (HMO-POS) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET34    | false   |   09011997|  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | St. Louis   | Yes                    |               |             | MO           |    63043   | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |HealthInsurance    |HI1562759  | ABC12345DEF |PrescriptionCoverage    |PD5646136    | BCD12345EFG  |Valid        |
    #  | 15565 | PDP      | current|AARP MedicareRx Saver Plus (PDP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002  |                | false    | 04261944 | Female | 002 Morris Rd | St. Louis | Yes                    | 802 MailingSt | Mailing LA  | MO          |      63043 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Valid|
		#	| 15564 | MAPD     |current| AARP Medicare Advantage (HMO-POS)| MBI     | John      | Doe      | 1EG4TE5MK72    | false   |  01012010 |  01012010 |      431665465 | true     | 01011983 | Male   | 003 Morris Rd | St. Louis | Yes                    |               |             | MO           |    63043 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |Invalid|
      | TID   | site|PlanType |path                                                                                                                                                                                                        |planyear|planYear|zipcode | isMultutiCounty | county          | plantype |planyear| planName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |  healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15558 | AARP|MAPD-MBI   |health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731|current |current|			63043 | NO              | St. Louis County | MAPD       |current|AARP Medicare Advantage (HMO-POS)  | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | MO           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false      |                   | NO      | NO |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		
			@Campaign_OLE_UHC @prodRegression 
    Examples: 
       | TID   | site|PlanType   |path                                                                                                                                                                                                        |planyear|planYear|zipcode | isMultutiCounty | county          | plantype |planyear| planName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |  healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
      | 15564  | UHC |MAPD-MBI   |health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731|current |current|			63043 | NO              | St. Louis County | MAPD       |current|AARP Medicare Advantage (HMO-POS) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | MO           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false      |                   | NO      | NO |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		
#added for current Year Plans CAMPAIGN URL PDP Plan	
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from  Acquisition PDP Campaign URL VPP Plan Summary
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
     # | PageName | <pageName> |
      | PagePath | <path>     |
  	And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
		And the user validates the available plans for selected plan types
    #Then the user clicks on Enroll Now for AARP site to start the OLE flow
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
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
  @Campaign_OLE_Ulayer @prodRegression 
   Examples: 
      | TID   | site|zipcode |isMultutiCounty | county          |plantype |path                                                                                                                                                                                                        |PlanType |planyear|planYear| planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
    	| 15565 | AARP|63043   |NO              |St. Louis County |PDP      |health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731|PDP      | current|current |AARP MedicareRx Saver Plus (PDP)  | MBI      | John      | Doe      | 1EG4TE5MK72    | false   |  11012015 |  11012015 |                | false    | 01011983 | Female | 002 Morris Rd | St. Louis | Yes                    | 802 MailingSt | Mailing LA  | MO          |      63043 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
  	
		
		@Campaign_OLE_UHC @prodRegression 
		Examples: 
      | TID   | site|zipcode |isMultutiCounty | county          |plantype |path                                                                                                                                                                                                        |PlanType |planyear|planYear| planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
    	| 15565 | UHC |63043   |NO              |St. Louis County |PDP      |health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731|PDP      | current|current |AARP MedicareRx Saver Plus (PDP)  | MBI      | John      | Doe      | 1EG4TE5MK72    | false   |  11012015 |  11012015 |                | false    | 01011983 | Female | 002 Morris Rd | St. Louis | Yes                    | 802 MailingSt | Mailing LA  | MO          |      63043 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
  	