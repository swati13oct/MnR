Feature: 1.05.1.ACQ-OLE common tool flow E2E MA AARP

 @MA_OLE_Ulayer_Mobile
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page on Mobile
    When the user performs plan search using following information in the AARP site on Mobile
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year on Mobile
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site on Mobile
    Then the user clicks on Enroll Now for AARP site to start the OLE flow on Mobile
     | Plan Name | <planName> |
    #Then the user validates the Plan details on OLE
    #Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    #Then the user validates Leave OLE modal for Welcome OLE
    #Then the user validates cancellation modal for Welcome OLE
   # Then the user navigates to Personal Information Page
   # Then the user enters following required information in Personal Information Page
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
    #Then the user validates the Plan details in Personal Information Page OLE Right Rail
    #Then the user validates the Member details dynamic display in Personal Information Page
    #Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    #Then the user enters following required Medicare Information    
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
     # | PartA Date         | <partadate>         |
     # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
#Then the user validates TFN in Medicare Info OLE Right Rail
    #Then the user validates the Plan details in Medicare Info OLE Right Rail
#    Then the user navigates to Preliminary Questions Page
    #Then the user validates requierd ESRD on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
#    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
		#Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    #Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    #Then the user navigates to SEP Page
      |	Input Data					 | <inputdataType>   |
    	| PartA Date         | <partadate>         |
   	#	| PartB Date         | <partbdate>         |
    #Then the user validates the Plan details in SEP Page OLE Right Rail
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
#    Then the user navigates to Coverage and Health Information Page   
    #Then the user navigates to Proposed Effective Date Page
    #Then the user validates Proposed Effective Date is Displayed
    #Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user validates PCP page for MA and MAPD PFFS plans
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    #Then the user navigates to Monthly Plan Premium Page
    #Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    #Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    #Then the user validates required fields for Authorization Page
    #Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    #Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType | zipcode | isMultutiCounty | county          | plantype | planName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |    |inputdataType|
      | 15558 | MA-MBI   |   10001 | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      431665465 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      |                   | NO      | NO |Valid|
  		#| 15559 | MA-MBI   |   10001 | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      |                   | NO      | NO |Invalid|

  