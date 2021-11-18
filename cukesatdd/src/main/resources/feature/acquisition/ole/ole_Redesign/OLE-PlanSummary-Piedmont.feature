  

Feature: 1.05.1 OLE common tool flow E2E Piedmont

  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary for Piedmont plans
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Middle Name              | <middlename>             |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Perm_AptNo               | <permaptno>              |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_AptNo            | <mailingaptno>           |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | Email Confirmation | <emailConfirmation>            |
      | Go Green           | <goGreen>                      |
      | Home Number        | <phoneno>                      |
      | Mobile Number      | <mobileno>                     |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | Card Type          | <cardtype>          |
    Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
     Then the user navigates to Confirm your Eligibility Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
   Then the user validates the long term questions in Medicare Information Page
      | LongTerm Question | <longTermFlag> |
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
       | PDP Question      | <pdpFlag>      |
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
      |RX BIN Number      |	<rxBinnumber>              |
    Then the user navigates to SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user selects payment type
      | Payment Type           | <paymentType>         |
      | Card No                | <cardno>              |
      | Card Expiration Month  | <cardexpirationmonth> |
      | Card Expiration Year   | <cardexpirationyear>  |
      | Card Holder First Name | <firstname>           |
      | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Authorization Page
    Then the user validates required fields for Authorization Page Representative
      | authorizationFirstname      | <authorizefirstN>       |
      | authorizationLastname       | <authorizelastN>        |
      | authorizationAddress        | <authorizeaddress>      |
      | authorizationApartmentSuite | <authorizeapartment>    |
      | authorizationCity           | <authorizecity>         |
      | authorizationZip            | <authorizezip>          |
      | authorizationPhoneNo        | <authorizephonenumber>  |
      | authorizationRelationship   | <authorizeRelationship> |
      | authorizationStateDisplay   | <authorizestate>        |
    Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |

     @Piedmont_OLE_Ulayer_Future @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples: 
      | TID   | site | PlanType    | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear	 |phoneno		|mobileno	 |
      | 11127 | AARP | MA-MBI      | current   | current   |   24122 | NO              | Bedford County  | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993 | Male   | 003 Morris Rd | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | false      | true       | true        | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail                                    | [blank] | [blank]             | [blank]            |1234567890|0123456788|
      | 11129 | AARP | MA-PFFS-MBI | current   | current   |   24501 | YES             | Campbell County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | TEST_PORTALS_GARRAND  | 5N69QY6ET34    | false   |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24526 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | yes           | false     | false      | true       | false       | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |1234567890|0123456788|

  	@Piedmont_OLE_UHC_Future @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples: 
      | TID   | site | PlanType    | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |phoneno	 |mobileno	|
      | 11127 | UHC  | MA-MBI      | current   | current   |   24122 | NO              | Bedford County  | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED |KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993 | Male   | 003 Morris Rd | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | false      | true       | true        | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456			| Valid         | TEST_PORTALS_M           | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail                                    | [blank] | [blank]             | [blank]            |1234567890|0123456788|
      | 11129 | UHC  | MA-PFFS-MBI | current   | current   |   24501 | YES             | Campbell County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993  | Female | 123 Perm Rd   | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24526 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | yes           | false     | false      | true       | false       | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]           |1234567890|0123456788|



  @nextYear @nonProd @regressionAARP
    Examples:
      | TID   | site | PlanType    | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear	 |phoneno		|mobileno	 |
      | 11127 | AARP | MA-MBI      | next     | next   |   24122 | NO              | Bedford County  | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993  | Male   | 003 Morris Rd | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | false      | true       | true        | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail                                    | [blank] | [blank]             | [blank]            |1234567890|0123456788|
      | 11129 | AARP | MA-PFFS-MBI | next     | next   |   24501 | YES             | Campbell County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993 | Female | 123 Perm Rd   | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24526 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | yes           | false     | false      | true       | false       | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |1234567890|0123456788|

  @nextYear @nonProd @regressionUHC
    Examples:
      | TID   | site | PlanType    | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |phoneno	 |mobileno	|
      | 11127 | UHC  | MA-MBI      | next     | next   |   24122 | NO              | Bedford County  | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993  | Male   | 003 Morris Rd | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24095 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes           | false     | false      | true       | true        | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456			| Valid         | M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail                                    | [blank] | [blank]             | [blank]            |1234567890|0123456788|
      | 11129 | UHC  | MA-PFFS-MBI | next     | next   |   24501 | YES             | Campbell County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | KRAMER  | 5U52YC1QR17   | false   |  11012018 |  11012018 |     0123456789 | true     | 09191993  | Female | 123 Perm Rd   | Los Angeles | No                    | 166 2nd ave     | Fremont    | VA           |      24526 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text       | yes     | yes           | false     | false      | true       | false       | true        | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456			|Valid         | M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]           |1234567890|0123456788|