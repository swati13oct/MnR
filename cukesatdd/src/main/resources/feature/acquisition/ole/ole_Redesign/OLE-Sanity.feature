
Feature: 1.05.2 OLE common tool flow E2E for Sanity Check

  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from <site> Acquisition site VPP Plan Summary
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
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
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
     
     
    @OLE_Sanity
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |rxBinnumber |
      | 15556 | AARP | MAPD-RRID-MBI | next   | next   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |567123      |

   @OLE_Sanity
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |rxBinnumber |
      | 15556 | UHC  | MAPD-RRID-MBI | next   | next   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |567123      |

   @OLE_Sanity
    Examples: 
      | TID   | site | PlanType        | planyear | planYear | zipcode | isMultutiCounty | county        | plantype | planName                                                  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |rxBinnumber |
      | 15557 | AARP | Medica-MAPD-MBI | next   | next   |   78006 | Yes             | Bexar County  | MAPD     | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false    | 05011960 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | TX           |      78006 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |567123      |
      | 15564 | AARP | Medica-MAPD-MBI | next   | next   |   07002 | NO              | Hudson County | MAPD     | AARP Medicare Advantage Choice (PPO)                      | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false    | 05011960 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |567123      |
   
   @OLE_Sanity
    Examples: 
      | TID   | site | PlanType        | planyear | planYear | zipcode | isMultutiCounty | county        | plantype | planName                                                  | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |rxBinnumber |
      | 15560 | UHC  | Medica-MAPD-MBI | next   | next   |   78006 | Yes             | Bexar County  | MAPD     | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false    | 05011960 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | TX           |      78006 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |567123      |
      | 15563 | UHC  | Medica-MAPD-MBI | next   | next   |   07002 | NO              | Hudson County | MAPD     | AARP Medicare Advantage Choice (PPO)                      | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false    | 05011960 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |567123      |
     