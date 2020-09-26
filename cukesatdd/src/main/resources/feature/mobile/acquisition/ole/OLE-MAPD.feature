Feature: 1.05.4.ACQ-OLE common tool flow E2E MAPD AARP Mobile

 @SNP_OLE_Mobile_MAPD
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - OLE MAPD End to end  from Acquisition site 
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for AARP site
      | Plan Year | <planyear> |
    And the user validates the available plans for selected plan types in the AARP site
    Then verify plan compare checkbox is not visible on plan summary on AARP
	 Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
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
    Then the user validates Medicare Information Page required fields
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
    Then the user navigates to Preliminary Questions Page
    #Then the user validates requierd ESRD on Medicare Info Page mobile
      | MedicaidNumber | <medicaidnumber> |
       |Plan Year | <planYear> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
		Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page mobile
    Then the user answers following questions in Medicare Information Page mobile
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
          Then the user validates the long term questions in Medicare Information Page
    | Health Insurance Name| <healthinsurancename>  |
    |   Group Number			 | <groupnumber>          |
    | Member Number        | <membernumber>         | 
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
    
    Examples: 
     # | TID   | zipcode | isMultiCounty | county           | plantype | planyear |
     # | 00001 |   78006 | YES           | Bexar County     | SNP      | current  |
     | TID   | PlanType     | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 15555 | MAPD-RRID-MBI|current |current |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011983 | Male   | 001 Morris Rd | New York | Yes                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
		 		
