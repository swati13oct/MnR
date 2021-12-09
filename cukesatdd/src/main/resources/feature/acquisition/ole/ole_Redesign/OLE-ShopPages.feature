Feature: 1.05.9 OLE Common tool flow E2E Shop Pages

  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from E2E Shop Pages-MA Plans
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for plans
    And click on how to enroll shop pages
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
      | Plan Year | <planyear> |
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
    Then the user validates the OLE Submission Details in GPS
      | Plan Type                | <plantype>               |
      | Auth Flag                | <authflag>               |
      | Mailing Address Question | <mailingaddressquestion> |
   # @ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11112 | AARP | MAPD-RRID-MBI | current   | current    |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

    #@ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11114 | UHC  | MAPD-RRID-MBI | current   | current    |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

   @nextYear @ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11112 | AARP | MAPD-RRID-MBI | next     | next   |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

   @nextYear @ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11114 | UHC  | MAPD-RRID-MBI | next     | next   |   10001 | NO              | New York County | MAPD     | future   | AARP Medicare Advantage Plan 1 (HMO) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|Valid         | TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |


  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from E2E Shop Pages-M&R-DSNP PLans
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for plans
    And click on how to enroll shop pages
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
      | Plan Year | <planyear> |
    When the user performs plan search using Shop Pages for DSNP Plans
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type
    #And the user views the plans of the below plan type for shop pages
      #| Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
   # And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #Then the user validates TFN in Welcome OLE Right Rail
Then the user validates Save Return Later modal for OLE Page
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
    Then the user navigates to Personal Information Page
    Then the user enters following information in Personal Information Page SNP Plans
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
   # Then the user validates PCP page for MA and MAPD PFFS plans
   # Then the user validates Look up Provider for MA MAPD and DSNP plans.
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
   # Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
   # Then the user validates the OLE Submission Details in GPS
    #  | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
    #  | Mailing Address Question | <mailingaddressquestion> |

   # @ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples: 
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber    |inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
     #  | 11111 | AARP|PCP-DSNP-MBI |  current   | current | 31062 | NO              | Baldwin County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_PORTALS_GOTTFRIED | TEST_PORTALS_GARRAND     | 5N69QY6ET36    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                  | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |123456|Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|true|Pay By Mail|[blank] | [blank]             | [blank]            |
      | 11111 | AARP | PCP-DSNP-MBI | current   | current    |   72201 | NO              | Pulaski County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| Valid         | 1234567890 | 2345678901 |TEST_PORTALS_M         | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

    #@ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign  @OLE_Redesign_Shop @nonProd
    Examples: 
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
     # | 11113 | UHC|PCP-DSNP-MBI |  current   | current | 31062 | NO              | Baldwin County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_PORTALS_GOTTFRIED | TEST_PORTALS_GARRAND     | 5N69QY6ET36    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                    | 876 MailingSt | Mailing LA  | GA           |      31062 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |456789|Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|true|Pay By Mail|[blank] | [blank]             | [blank]            |
      | 11113 | UHC  | PCP-DSNP-MBI | current   | current    |   72201 | NO              | Pulaski County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M        | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

    @nextYear @ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber    |inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
     # | 11111 | AARP|PCP-DSNP-MBI |  next     | next | 78006 | Yes              | Bexar County | SNP      |  UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_PORTALS_GOTTFRIED | TEST_PORTALS_GARRAND     | 5N69QY6ET36    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                  | 876 MailingSt | Mailing LA  | TX           |      78006 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |123456|Valid|1234567890|2345678901| S                |Test_K         |Test_M        |122 2ND AVE     |655               |MINNEAPOLIS  |55455       |1235678901          |FRIEND               |MN|Agree|566|677|true|Pay By Mail|[blank] | [blank]             | [blank]            |
      | 11111 | AARP | PCP-DSNP-MBI | next     | next    |   72201 | NO              | Pulaski County | SNP      |  UnitedHealthcare Dual Complete Choice (PPO D-SNP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

   @nextYear @ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign  @OLE_Redesign_Shop @nonProd
    Examples:
      | TID   | site | PlanType     | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11111 | UHC | PCP-DSNP-MBI | next     | next    |   72201 | NO              | Pulaski County | SNP      |  UnitedHealthcare Dual Complete Choice (PPO D-SNP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |


  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from E2E Shop Pages-PDP PLANS
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user hovers screen over the shop for a plan
    And click on Enroll Plan on shoppages for plans
    And click on how to enroll shop pages
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
      | Plan Year | <planyear> |
    When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
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
    Then the user validates the Prescription drug coverage questions in Medicare Information Page for PDP Plans
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
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
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
     
    #@ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber    |inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11115 | AARP | PDP-MBI  | current   | current   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | no                     | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | [blank]      | false     | NA         | NA         | NA          | NA          | NO                | NO      | [blank]             | [blank]     | [blank]      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|InValid       | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |

    #@ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permaptno | permcity    | mailingaddressquestion | mailingstreet | mailingaptno | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11116 | UHC  | PDP-MBI  | current   | current  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011988 | Female | 002 Morris Rd |        85 | Los Angeles | no                     | 802 MailingSt |           30 | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | [blank]      | false     | NA         | NA         | NA          | NA          | NO                | NO      | [blank]             | [blank]     | [blank]      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| InValid       | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |

  @nextYear @ShopPage_OLE_Future_AARP @regressionAARP @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber    |inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11115 | AARP | PDP-MBI  | next     | next   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011988 | Female | 002 Morris Rd | Los Angeles | no                     | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | [blank]      | false     | NA         | NA         | NA          | NA          | NO                | NO      | [blank]             | [blank]     | [blank]      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456|InValid       | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |

  @nextYear @ShopPage_OLE_Future_UHC @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permaptno | permcity    | mailingaddressquestion | mailingstreet | mailingaptno | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |
      | 11116 | UHC  | PDP-MBI  | next     | next   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_John      | MILLS     | 9TG0PC4TT18    | false   |  06011992 |  06011992  |     0123456789 | false    | 01011988 | Female | 002 Morris Rd |        85 | Los Angeles | no                     | 802 MailingSt |           30 | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | [blank]      | false     | NA         | NA         | NA          | NA          | NO                | NO      | [blank]             | [blank]     | [blank]      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456| InValid       | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Social Security or Railroad Retirement Benefit | [blank] | [blank]             | [blank]            |
