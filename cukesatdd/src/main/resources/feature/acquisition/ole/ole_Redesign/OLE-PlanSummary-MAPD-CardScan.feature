Feature: 1.05.2 OLE common tool flow E2E MAPD

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
   # And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
   # Then the user validates TFN in Welcome OLE Right Rail
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
    Then the user clicks on camera icon to scan Medicare Card #New step
    #2/2Then the user enters following required Medicare Information
     #2/2 | Medicare Number    | <medicarenumber>    |
     #2/2 | SSN Flag           | <ssnflag>           |
      #2/2| Card Type          | <cardtype>          |
    Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
     #2/2Then the user navigates to Confirm your Eligibility Page
     #2/2 | Input Data     | <inputdataType>  |
     #2/2 | PartA Date     | <partadate>      |
     #2/2 | PartB Date     | <partbdate>      |
     #2/2 | MedicaidNumber | <medicaidnumber> |
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
   #@MAPD_OLE_Ulayer_Future @regressionAARP @OLE @OLE_Redesign @ole_Redesign_Gating  @OLEGating @nonProd @ole_Redesign_Gating_1 @sanity_OLE
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15501 | AARP | MAPD-RRID-MBI | current   | current  |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO)                | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false     | 05011960 | Male   | 001 Morris Rd | New York    | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_K   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
     # | 15502 | AARP | MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County    | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)           | MBI      | TEST_PORTALS_John      | TEST_PORTALS_Doe      | 3A33C22YK27    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                   | yes     | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | [blank]            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

   #@MAPD_OLE_UHC_Future @regressionUHC @sanity  @regressionUHC @OLE @OLE_Redesign  @OLEGating @nonProd
    Examples:
       | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
     	 | 15504 | UHC | MAPD-RRID-MBI | current   | current   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO)                | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false     | 05011960 | Male   | 001 Morris Rd | New York    | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true_yes      | yes               | yes      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_K   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
     #  | 15505 | AARP | MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County    | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)           | MBI      | TEST_PORTALS_John      | TEST_PORTALS_Doe      | 3A33C22YK27    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                   | yes     | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | [blank]            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |


  @nextYear @MAPD_OLE_Ulayer_Future @regressionAARP @OLE @OLE_Redesign @ole_Redesign_Gating @OLEGating @nonProd @sanity_OLE @gating_OLE
    Examples:
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15501 | AARP | MAPD-RRID-MBI | next     | next   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO)                | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false     | 05011960| Male   | 001 Morris Rd | New York    | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_K   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
     # | 15502 | AARP | MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County    | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)           | MBI      | TEST_PORTALS_John      | TEST_PORTALS_Doe      | 3A33C22YK27    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                   | yes     | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | [blank]            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  @nextYear @nonProd @MAPD_OLE_UHC_Future @regressionUHC @sanity  @regressionUHC @OLE @OLE_Redesign  @OLEGating @nonProd
    Examples:
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15504 | UHC | MAPD-RRID-MBI | next     | next   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO)                | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | false     | 05011960 | Male   | 001 Morris Rd | New York    | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true_yes      | yes               | yes      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_K   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
     #  | 15505 | AARP | MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County    | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)           | MBI      | TEST_PORTALS_John      | TEST_PORTALS_Doe      | 3A33C22YK27    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                   | yes     | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | [blank]            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |


  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from AARP Acquisition site VPP Plan Summary for Multiple Providers
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
    #New Changes
    When the user Click on Is my Provider covered links
      | PlanName | <planName> |
    When user selects a multiple providers and retuns to VPP page
    Then User store the information provided from rally to vpp page
      | PlanName | <planName> |
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
    Then the User navigates to PCP Page and validates PCP Providers listed in the AARP VPP displayed
      | PlanName  | <planName> |
      | Plan Type | <plantype> |
    Then the user select providers from the PCP page and continue to OLE Flow
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
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |
 
  #@MA_OLE_Ulayer_Future  @regressionAARP @OLE @OLE_Redesign_MAPD @nonProd
    Examples: 
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15503 | AARP | MA-MBI        | current   | current  |   33112 | NO              | Miami-Dade County| MA      |  AARP Medicare Advantage Patriot (Regional PPO)     | MBI      | TEST_PORTALS_GOTTFRIED |BRAVO      | 1VP6J60HR63    | false   |  09012007 |  09012007 |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | FL           |      33112 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   |  yes    | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_K       | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |

  #@MA_OLE_UHC_Future  @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
       | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
     	 | 15506 | UHC | MA-MBI        | current   | current  |   33112 | NO              | Miami-Dade County| MA      |  AARP Medicare Advantage Patriot (Regional PPO)     | MBI      | TEST_PORTALS_MA | TEST_PORTALS_MA|4PE7TE5EE10    | false   | 07012000  |  07012000 |     0123456789 | true     | 07021935 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | FL           |      33112 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   |  yes    | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_K          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |


    @nextYear @nonProd @regressionAARP @OLE @OLE_Redesign_MAPD @nonProd
      Examples:
        | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
        | 15503 | AARP | MA-MBI        | next     | next   |   33112 | NO              | Miami-Dade County| MA      |  AARP Medicare Advantage Patriot (Regional PPO)     | MBI      | TEST_PORTALS_MA | TEST_PORTALS_MA|4PE7TE5EE10    | false   | 07012000  |  07012000 |     0123456789 | true     | 07021935 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | FL           |      33112 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   |  yes    | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_K            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |

    @nextYear @nonProd @regressionUHC @OLE @OLE_Redesign @nonProd
      Examples:
        | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
        | 15506 | UHC | MA-MBI        | next     | next   |   33112 | NO              | Miami-Dade County| MA      |  AARP Medicare Advantage Patriot (Regional PPO)     | MBI      | TEST_PORTALS_MA | TEST_PORTALS_MA|4PE7TE5EE10    | false   | 07012000  |  07012000 |     0123456789 | true     | 07021935 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | FL           |      33112 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   |  yes    | yes          | false         | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_K          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |
