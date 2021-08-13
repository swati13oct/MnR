Feature: 1.05.4 OLE common tool flow E2E DSNP

  # @SNP_OLE_AARP @acquisitionRegression @junerelease2018 @september_release_2018 @december_release_2018 @OLE_DNSP_AARP @MACRAvalidation @OEP_CHANGES @OLE_Regression_Ulayer
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from <site> Acquisition site on VPP Plan Summary
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
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
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
    Then the user enters following information in Personal Information Page DSNP
      # | Email Confirmation | <emailConfirmation> |
      #| Go Green           | <goGreen>           |
      | Email         | <email>      |
      | Home Number   | <phoneno>    |
      | Mobile Number | <mobileno>   |
      | Middle Name   | <middlename> |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    # Then the user validates Medicare Information Page required fields
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
    Then the user validates Medicare Number and not required ESRD question on Medicare Info Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
    Then the user navigates to SEP Page for Medicaid and Effective date
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
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
    Then the user selects payment type
      | Payment Type           | <paymentType>         |
      | Card No                | <cardno>              |
      | Card Expiration Month  | <cardexpirationmonth> |
      | Card Expiration Year   | <cardexpirationyear>  |
      | Card Holder First Name | <firstname>           |
      | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    #Then the user validates required fields for Authorization Page
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
      | authorizationAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
    Then the user validates the OLE Submission Details in GPS
      | Plan Type                | <plantype>               |
      | Auth Flag                | <authflag>               |
      | Mailing Address Question | <mailingaddressquestion> |

    #@SNP_OLE_AARP_Future
    @prodRegression_AARP1
    Examples: 
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno | cardexpirationmonth | cardexpirationyear |
      | 15574 | AARP | PCP-DSNP-MBI | future   | future   |   31062 | NO              | Baldwin County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET36    | false   |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | Yes     | Yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit |        |                     |                    |

    # | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
    # | 15574 | AARP|PCP-DSNP-MBI |  future|future | 33143 | NO              | Miami-Dade County | SNP      |  UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
    #| TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty   | county         | plantype | planName                                                    | cardtype | firstname | lastname | medicarenumber    | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                    | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename         |groupnumber  | membernumber    |prescriptioncoveragename      |pdgroupnumber |pdmembernumber|inputdataType|phoneno   | mobileno |middlename        |authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|
    # |15574 | AARP|PCP-DSNP-MBI |  future|future | 31062 | NO              | Baldwin County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 1EG1TE1MK11    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                 | 01012018/01012018         | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |         Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|
    #@SNP_OLE_UHC_Future
    @prodRegression_UHC1 @prodRegression1 @sanity1
    Examples: 
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno | cardexpirationmonth | cardexpirationyear |
      | 15574 | UHC  | PCP-DSNP-MBI | future   | future   |   31062 | NO              | Baldwin County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND  | 5N69QY6ET36    | false   |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | Yes     | Yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail |        |                     |                    |

  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from Acquisition <site> VPP Plan Summary
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
    And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Footer links on Welcome OLE Page
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
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
    Then the user enters following information in Personal Information Page DSNP
      # | Email Confirmation | <emailConfirmation> |
      #| Go Green           | <goGreen>           |
      | Email         | <email>      |
      | Home Number   | <phoneno>    |
      | Mobile Number | <mobileno>   |
      | Middle Name   | <middlename> |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    # Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | SSN Number         | <SSNnumber>         |
      #  | PartA Date         | <partadate>         |
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
      | Plan Year      | <planYear>       |
    #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
    Then the user navigates to SEP Page for Medicaid and Effective date
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
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
    Then the user selects payment type
      | Payment Type           | <paymentType>         |
      | Card No                | <cardno>              |
      | Card Expiration Month  | <cardexpirationmonth> |
      | Card Expiration Year   | <cardexpirationyear>  |
      | Card Holder First Name | <firstname>           |
      | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
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
      | authorizationAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
    #  | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |

    @SNP_OLE_AARP_Future1 @OLE1 @regressionAARP1 @OLE1 @sanity1
    Examples: 
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15576 | AARP | DSNP-MBI | future   | future   |   72201 | Yes             | Pulaski County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND  | 1EG1TE1MK12    | false   | 123456789 |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |

    # | 15576 | AARP|DSNP-MBI | future |future  |  78006 | Yes              | Bexar County   | SNP      |  UnitedHealthcare Dual Complete (HMO D-SNP)             | MBI      | GOTTFRIED | GARRAND     | 1EG1TE1MK12    | false    | 123456789  |    09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | No                    | 876 MailingSt | Mailing LA  | TX           |      78006 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018       | yes     | yes           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|true|Credit Card|5411111111111115|04|24|
    @SNP_OLE_UHC_Future1 @OLE1 @regressionUHC1 @OLE1
    Examples: 
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15576 | UHC  | DSNP-MBI | future   | future   |   72201 | Yes             | Pulaski County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | GOTTFRIED | GARRAND  | 1EG1TE1MK12    | false   | 123456789 |  09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |
      # | 15576 | UHC|DSNP-MBI | future|future|  78006 | Yes              | Bexar County | SNP      |  UnitedHealthcare Dual Complete (HMO D-SNP)             | MBI      | GOTTFRIED | GARRAND     | 1EG1TE1MK12   | false| 123456789|    09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd   | Los Angeles | No                    | 876 MailingSt | Mailing LA  | TX           |      78006 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018       | yes     | yes           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|true|Credit Card|5411111111111115|04|24|