Feature: 1.10 <----UAT Scripts OLE common tool flow E2E- MA,MAPD,DSNP,ExternalLink MA----->

  Scenario Outline: TID: <Scenario> -OLE End to end from VPP Plan Summary for <plantype> Plans
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
     Then the user validates TFN on Welcome OLE Page
   Then the user validate widgets on Welcome OLE Page
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Logo Image on Welcome OLE
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
    Then the user validates Footer links on Welcome OLE Page
     | Plan Type | <plantype> |
    Then the user navigates to Personal Information Page
	Then the user validates logo image on OLE Pages
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
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user validate widgets on OLE Pages
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
    Then the user validate on Review Page and click on Edit information for Medicare Information Page
      | Medicare Number1 | <medicarenumber1> |
      | Card Type        | <cardtype>        |
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |

  #@OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE  @OLE_UATRegression_1 @nonProd
    Examples: 
      | Scenario                    | site | TFNNo          |PlanType      | planyear | planYear | zipcode | isMultutiCounty | county      | plantype | planyear  | planName                                  | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | medicarenumber1 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
    	| MA- E2E Scenario 1_AARP     | AARP | 1-888-510-0371 |MA-MBI        | current   | current  |   76543 | NO              | Bell County | MA       | current    | AARP Medicare Advantage Patriot (HMO-POS) | MBI      | TEST_PORTALS_GOTTFRIED |  COLEMAN      | 7WW9X41NT49    | false   |  03011999 |  03011999 |     0123456789 | true  | 08101960  | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Irving      | TX           |      76543 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
      | MAPD - E2E Scenario 1_AARP  | AARP | 1-888-510-0371 |MAPD-PFFS-MBI | current   | current   |   66843 | Yes             | Chase County | MAPD     | current   | UnitedHealthcare MedicareDirect Rx (PFFS) | MBI      | TEST_PORTALS_John    |  COLEMAN      | 7WW9X41NT49    | false   |  03011999 |  03011999 |     0123456789 | true  | 08101960  | Female | 123 Perm Rd | Los Angeles   | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                 | yes     | yes          | false     | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  #@OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario                    | site | TFNNo          |PlanType      | planyear | planYear | zipcode | isMultutiCounty | county      | plantype | planyear  | planName                                  | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | medicarenumber1 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | MA- E2E Scenario 1_UHC    	| UHC  |1-844-882-7766  | MA-MBI        | current   | current  |   76543 | NO              | Bell County | MA       | current    | AARP Medicare Advantage Patriot (HMO-POS) | MBI      | TEST_PORTALS_GOTTFRIED | COLEMAN      | 7WW9X41NT49    | false   |  03011999 |  03011999 |     0123456789 | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Irving      | TX           |      76543 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
      | MAPD - E2E Scenario 1_UHC  	| UHC  |1-844-882-7766  |MAPD-PFFS-MBI | current   | current  |   66843 | Yes             | Chase County | MAPD     | current   | UnitedHealthcare MedicareDirect Rx (PFFS) | MBI      | TEST_PORTALS_John      | COLEMAN      | 7WW9X41NT49    | false   |  03011999 |  03011999 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd | Los Angeles   | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                 | yes     | yes          | false     | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  @nextYear @OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE  @OLE_UATRegression_1 @nonProd
    Examples:
      | Scenario                    | site | TFNNo          |PlanType      | planyear | planYear | zipcode | isMultutiCounty | county      | plantype | planyear  | planName                                  | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | medicarenumber1 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | MA- E2E Scenario 1_AARP     | AARP | 1-888-510-0371 |MA-MBI        | next     | next   |   76543 | NO              | Bell County | MA       | next    | AARP Medicare Advantage Patriot (HMO-POS) | MBI      | TEST_PORTALS_MA | TEST_PORTALS_MA|4PE7TE5EE10    | false   | 07012000  |  07012000 |     0123456789 | true     | 07021935 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Irving      | TX           |      76543 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
      | MAPD - E2E Scenario 1_AARP  | AARP | 1-888-510-0371 |MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County | MAPD     | next   | UnitedHealthcare MedicareDirect Rx (PFFS) | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | true     | 05011960 | Female | 123 Perm Rd | Los Angeles   | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                 | yes     | yes          | false     | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  @nextYear @OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario                    | site | TFNNo          |PlanType      | planyear | planYear | zipcode | isMultutiCounty | county      | plantype | planyear  | planName                                  | cardtype | firstname              | lastname              | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | medicarenumber1 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | MA- E2E Scenario 1_UHC    	| UHC  |1-844-882-7766  | MA-MBI        | next     | next   |   76543 | NO              | Bell County | MA       | next    | AARP Medicare Advantage Patriot (HMO-POS) | MBI      | TEST_PORTALS_MA | TEST_PORTALS_MA|4PE7TE5EE10    | false   | 07012000  |  07012000 |     0123456789 | true     | 07021935 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Irving      | TX           |      76543 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | true_yes      | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
      | MAPD - E2E Scenario 1_UHC  	| UHC  |1-844-882-7766  |MAPD-PFFS-MBI | next     | next   |   66843 | Yes             | Chase County | MAPD     | next  | UnitedHealthcare MedicareDirect Rx (PFFS) | MBI      |TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | true     | 05011960 | Female | 123 Perm Rd | Los Angeles   | No                     | 123 Test      | Edison      | KS           |      66843 | test@test.com | None apply                                                                                                                                                                                                                                          | [blank]                 | yes     | yes          | false     | yes               | yes     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | 5N69QY6ET32     | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

 
  Scenario Outline: TID: <Scenario> -OLE End to end from VPP Plan Summary for C&S-> <plantype> Plans
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
    Then the user validates TFN on Welcome OLE Page
    Then the user validate widgets on Welcome OLE Page
   Then the user validates Logo Image on Welcome OLE
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
     Then the user validates Footer links on Welcome OLE Page
      | Plan Type | <plantype> |
    Then the user navigates to Personal Information Page
    Then the user validates logo image on OLE Pages
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
    Then the user validates cancellation and Save Return Later modal for OLE Page
    Then the user validate widgets on OLE Pages
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
   Then the user validate on Review Page and click on Edit information for Medicare Information Page
      | Medicare Number1 | <medicarenumber1> |
      | Card Type        | <cardtype>        |
    # Then the user Validates Next Steps in Confirmation Page for the Plan Type.
    Then the user clicks on Submit Enrollment to complete enrollment
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
     # | Auth Flag                | <authflag>               |
    #  | Mailing Address Question | <mailingaddressquestion> |

  #@OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE @nonProd
    Examples:
      | Scenario   | site | PlanType | TFNNo          |planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | DSNP- E2E Scenario 1_AARP | AARP | DSNP-MBI |  1-888-510-0371 |  current    |  current    | 10011   | No           | New York County | SNP      |    UnitedHealthcare Dual Complete (HMO D-SNP) | MBI      |TEST_PORTALS_C&DSNP | TEST_PORTALS_C&SDSNP|6AR6TE8YF10    | true   | 123456789 |  07011993 |  07011993 |    WX14595H | true | 07051928 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | NY           |      10011 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | Yes     | Yes     | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456    |Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |[blank]  | [blank] | [blank]             | [blank]            |5N69QY6ET32     |


  #@OLE_UATRegression @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario   | site | PlanType | TFNNo          |planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | DSNP- E2E Scenario 1_UMS | UHC | DSNP-MBI |  1-888-510-0371 | current    |  current    | 10011   | No           | New York County | SNP      |    UnitedHealthcare Dual Complete (HMO D-SNP) | MBI      |TEST_PORTALS_C&DSNP | TEST_PORTALS_C&SDSNP|6AR6TE8YF10    | true   | 123456789 |  07011993 |  07011993 |    WX14595H | true | 07051928 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | NY           |      10011 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | Yes     | Yes     | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456    |Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |[blank]  | [blank] | [blank]             | [blank]            |5N69QY6ET32     |

  @nextYear @OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE @nonProd
    Examples:
      | Scenario   | site | PlanType | TFNNo          |planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | DSNP- E2E Scenario 1_AARP | AARP | DSNP-MBI |  1-888-510-0371 | next     | next    | 10011   | No           | New York County | SNP      |   UnitedHealthcare Dual Complete Plan 1 - EVC (HMO D-SNP) | MBI      |TEST_PORTALS_C&DSNP | TEST_PORTALS_C&SDSNP|6AR6TE8YF10    | true   | 123456789 |  07011993 |  07011993 |    WX14595H | true | 07051928 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | NY           |      10011 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | Yes     | Yes     | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456    |Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |[blank]  | [blank] | [blank]             | [blank]            |5N69QY6ET32     |

  @nextYear @OLE_UATRegression @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario   | site | PlanType | TFNNo          |planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | DSNP- E2E Scenario 1_UMS | UHC | DSNP-MBI |  1-888-510-0371 | next     | next    | 10011   | No           | New York County | SNP      |   UnitedHealthcare Dual Complete Plan 1 - EVC (HMO D-SNP) | MBI      |TEST_PORTALS_C&DSNP | TEST_PORTALS_C&SDSNP|6AR6TE8YF10    | true   | 123456789 |  07011993 |  07011993 |    WX14595H | true | 07051928 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | NY           |      10011 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | false     | Yes     | Yes     | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456    |Valid         | 1234567890 | 2345678901 | TEST_PORTALS_M          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |[blank]  | [blank] | [blank]             | [blank]            |5N69QY6ET32     |


  Scenario Outline: TID: <Scenario>- OLE End to end from  VPP Plan Summary for Plans External Links <plantype> Plans
    Given the user is on medicare acquisition site landing page fro campaign Traffic
      | Site | <site> |
    Given the user navigates to following Campaign acquisition site page for External Links
      | PagePath        | <path>            |
      | Plan Type       | <plantype>        |
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    #And the user views the plans of the below plan type
    # | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
   # And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
     Then the user validates TFN on Welcome OLE Page
    Then the user validate widgets on Welcome OLE Page
    Then the user validates Logo Image on Welcome OLE
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
     Then the user validates Footer links on Welcome OLE Page
      | Plan Type       | <plantype>        |
    Then the user navigates to Personal Information Page
   Then the user validates logo image on OLE Pages
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
     Then the user validates cancellation and Save Return Later modal for OLE Page
    Then the user validates cancellation and Save Return Later modal for OLE Page
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
      Then the user validate widgets on OLE Pages
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
    Then the user validate on Review Page and click on Edit information for Medicare Information Page
      | Medicare Number1 | <medicarenumber1> |
      | Card Type        | <cardtype>        |
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |

  #@OLE_Redesign @OLE_UATRegression @UATRegression @regressionAARP @OLE @OLE_Redesign_Campaign @nonProd
    Examples: 
      | Scenario                                        |TFNNo          | site | PlanType | path                                                                                                                                                                                                                                   | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 |middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |
      | E2E Scenario_UMS External Link (Deep link ) PST |1-833-988-1569 | UHC  | MA-MBI   | /health-plans/medicare-advantage-plans/available-plans.html?zipcode=55344&WT.mc_id=8002977&county=260&state=27&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | current   | current   |   55344 | NO              | Hennepin County | MAPD       | current   | AARP Medicare Advantage Headwaters (PPO) | MBI      | TEST_PORTALS_GOTTFRIED | MARBLE  |9PU0FN3FY03  | false   |  06012017 |  06012017 |     0123456789 | true     | 07181979 | Male   | 003 Morris Rd | Los Angeles | No                    | 155 2nd ave	       | Minneapolis    | MN           |      55344 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| Valid         | 5N69QY6ET32     |TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]         |1234567890 | 2345678901 |

  @nextYear @OLE_Redesign @OLE_UATRegression @UATRegression @regressionAARP @OLE @OLE_Redesign_Campaign @nonProd
    Examples:
      | Scenario                                        |TFNNo          | site | PlanType | path                                                                                                                                                                                                                                   | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planyear | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 |middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |
      | E2E Scenario_UMS External Link (Deep link ) PST |1-833-988-1569 | UHC  | MA-MBI   | /health-plans/medicare-advantage-plans/available-plans.html?zipcode=55344&WT.mc_id=8002977&county=260&state=27&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | next     | next   |   55344 | NO              | Hennepin County | MAPD       | next   | AARP Medicare Advantage Headwaters (PPO) | MBI      | TEST_PORTALS_MAPD | TEST_PORTALS_MAPD|2W10TE1RH40    | false   |  03012000 |  01012014 |     0123456789 | true     | 05011960 | Male   | 003 Morris Rd | Los Angeles | No                    | 155 2nd ave	       | Minneapolis    | MN           |      55344 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| Valid         | 5N69QY6ET32     |TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]         |1234567890 | 2345678901 |


  Scenario Outline: TID: <Scenario> -OLE End to end from VPP Plan Summary for <plantype> Plans
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
    Then the user validates TFN on Welcome OLE Page
    Then the user validate widgets on Welcome OLE Page
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Logo Image on Welcome OLE
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
     Then the user validates Footer links on Welcome OLE Page
      | Plan Type | <plantype> |
    Then the user navigates to Personal Information Page
    Then the user validates logo image on OLE Pages
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
    Then the user validates cancellation and Save Return Later modal for OLE Page
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
      Then the user validate widgets on OLE Pages
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
    Then the user validate on Review Page and click on Edit information for Medicare Information Page
      | Medicare Number1 | <medicarenumber1> |
      | Card Type        | <cardtype>        |
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |

  #@OLE_UATRegression @UATRegression @regressionAARP @OLE @OLE_Redesign @OLE_Redesign_UAT @nonProd
    Examples: 
      | Scenario                 |TFNNo          | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno |authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |partadate1 |partbdate2 |
      | PDP- E2E Scenario 1_AARP |1-888-510-0371 | AARP | PDP-MBI  | current   | current  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_PDP | TEST_PORTALS_PDP  |2EE4TE2UG10    | false   |  08011996 |  08011996 |     0123456789 | false     | 08161931 | Female | 002 Morris Rd | Los Angeles | No                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| InValid       | 5N69QY6ET32     |TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |1234567890 | 2345678901 |11012020 |  11012020 |

  #@OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples: 
     | Scenario                 | TFNNo          |site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno |authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |partadate1 |partbdate2 |
      | PDP- E2E Scenario 1_UHC | 1-844-882-7766 |UHC  | PDP-MBI  | current   | current  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_PDP | TEST_PORTALS_PDP  |2EE4TE2UG10    | false   |  08011996 |  08011996 |     0123456789 | false     | 08161931 | Female | 002 Morris Rd | Los Angeles | No                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| InValid       | 5N69QY6ET32     |TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |1234567890 | 2345678901 |11012020 |  11012020 |


  @nextYear @OLE_UATRegression @UATRegression @regressionAARP @OLE @OLE_Redesign @OLE_Redesign_UAT @nonProd
    Examples:
      | Scenario                 |TFNNo          | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno |authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |partadate1 |partbdate2 |
      | PDP- E2E Scenario 1_AARP |1-888-510-0371 | AARP | PDP-MBI  | next     | next   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_PDP | TEST_PORTALS_PDP  |2EE4TE2UG10    | false   |  08011996 |  08011996 |     0123456789 | false     | 08161931 | Female | 002 Morris Rd | Los Angeles | No                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| InValid       | 5N69QY6ET32     |TEST_PORTALS_M  | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |1234567890 | 2345678901 |11012020 |  11012020 |

  @nextYear @OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario                 | TFNNo          |site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county             | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | medicarenumber1 | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno |authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |phoneno    | mobileno   |partadate1 |partbdate2 |
      | PDP- E2E Scenario 1_UHC | 1-844-882-7766 |UHC  | PDP-MBI  | next     | next   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | MBI      | TEST_PORTALS_PDP | TEST_PORTALS_PDP  |2EE4TE2UG10    | false   |  08011996 |  08011996 |     0123456789 | false     | 08161931| Female | 002 Morris Rd | Los Angeles | No                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |567890| InValid       | 5N69QY6ET32     |TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |1234567890 | 2345678901 |11012020 |  11012020 |


  Scenario Outline: TID: <Scenario> -OLE End to end from VPP Plan Summary for <plantype> Plans
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
    Then the user validates the Plan details on OLE CSNP Plans
     Then the user validates TFN on Welcome OLE Page
    Then the user validate widgets on Welcome OLE Page
    Then the user validates Save Return Later modal for OLE Page
    Then the user validates Logo Image on Welcome OLE
    Then the user validates Optional Benefits Page for following plans with available Riders in welcome page
     | Rider Flag | <riderflag> |
     Then the user validates Footer links on Welcome OLE Page
      | Plan Type | <plantype> |
    Then the user navigates to Personal Information Page
    Then the user validates logo image on OLE Pages
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
    Then the user validates cancellation and Save Return Later modal for OLE Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | Card Type          | <cardtype>          |
    Then the user validate widgets on OLE Pages
    Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |  
     Then the user navigates to Confirm your Eligibility Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
     Then the user validates the required fields for CSNP plans on Medicare Information Page
      | diabetesQuestion1       | <diabetesQ1> |
      | diabetesQuestion2       | <diabetesQ2> |
      | chronicHeartFailure1    | <chronicQ1>  |
      | chronicHeartFailure2    | <chronicQ2>  |
      | chronicHeartFailure3    | <chronicQ3>  |
      | cardioVasculardisorder1 | <cardioQ1>   |
      | cardioVasculardisorder2 | <cardioQ2>   |
      | cardioVasculardisorder3 | <cardioQ3>   |
      | cardioVasculardisorder4 | <cardioQ4>   |
      | cardioVasculardisorder5 | <cardioQ5>   |
      | cardioVasculardisorder6 | <cardioQ6>   |
     Then the user navigate to Use and Disclosure Authorization page for CSNP Plans
     Then the user enters provider details in Use and Disclosure Authorization page for CSNP and navidates to Personal information page
      | Provider Name           | <providername>    |
      | Provider Street Address | <provideraddress> |
      | City                    | <providercity>    |
      | Zip                     | <providerzipcode> |
      | Provider Phone Number   | <providernumber>  |
      | Mailing_State           | <mailingstate>    | 
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
   Then the user validate on Review Page and click on Edit information for Medicare Information Page
      | Medicare Number1 | <medicarenumber1> |
      | Card Type        | <cardtype>        |
    Then the user clicks on Submit Enrollment to complete enrollment
  

  #@OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE @nonProd
    Examples: 
      | Scenario                  | PlanType | TFNNo          |site | planyear | planYear | zipcode | isMultutiCounty | county       | plantype | planName                                      | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | diabetesQ1 | diabetesQ2 | chronicQ1 | chronicQ2 | chronicQ3 | cardioQ1 | cardioQ2 | cardioQ3 | cardioQ4 | cardioQ5 | cardioQ6 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | CSNP- E2E Scenario 1_AARP | CSNP-MBI |1-888-510-0371  | AARP | current   | current  |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP) | MBI      | TEST_PORTALS_CSNP | TEST_PORTALS_CSNP|4N36TE5EU30    | false   |  03011985 |  03011985 |     0123456789 | true     | 03231920 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Mcgee st  | IRVING      | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |333345 | Valid         | TEST_PORTALS_M  | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | yes        | No         | No        | No        | No        | No       | No       | No       | No       | No       | No       | true     | Pay By Mail | [blank] | [blank]             | [blank]  |5N69QY6ET32          |


  #@OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples: 
      | Scenario                 | PlanType |TFNNo          | site | planyear | planYear | zipcode | isMultutiCounty | county       | plantype | planName                                      | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | diabetesQ1 | diabetesQ2 | chronicQ1 | chronicQ2 | chronicQ3 | cardioQ1 | cardioQ2 | cardioQ3 | cardioQ4 | cardioQ5 | cardioQ6 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1|
      | CSNP- E2E Scenario 1_UHC | CSNP-MBI |1-844-882-7766 |UHC  | current   | current  |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP) | MBI      | TEST_PORTALS_CSNP | TEST_PORTALS_CSNP|4N36TE5EU30    | false   |  03011985 |  03011985 |     0123456789 | true     | 03231920 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Mcgee st  | IRVING      | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 578456|Valid         | TEST_PORTALS_M    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | yes        | No         | No        | No        | No        | No       | No       | No       | No       | No       | No       | true     | Pay By Mail | [blank] | [blank]             | [blank]        |5N69QY6ET32    |


  @nextYear @OLE_Redesign @OLE_UATRegression  @UATRegression @regressionAARP @OLE @nonProd
    Examples:
      | Scenario                  | PlanType | TFNNo          |site | planyear | planYear | zipcode | isMultutiCounty | county       | plantype | planName                                      | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | diabetesQ1 | diabetesQ2 | chronicQ1 | chronicQ2 | chronicQ3 | cardioQ1 | cardioQ2 | cardioQ3 | cardioQ4 | cardioQ5 | cardioQ6 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1 |
      | CSNP- E2E Scenario 1_AARP | CSNP-MBI |1-888-510-0371  | AARP | next     | next   |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP) | MBI      | TEST_PORTALS_CSNP | TEST_PORTALS_CSNP|4N36TE5EU30    | false   |  03011985 |  03011985 |     0123456789 | true     | 03231920 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Mcgee st  | IRVING      | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |333345 | Valid         | TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | yes        | No         | No        | No        | No        | No       | No       | No       | No       | No       | No       | true     | Pay By Mail | [blank] | [blank]             | [blank]  |5N69QY6ET32          |


  @nextYear @OLE_UATRegression  @UATRegression @regressionUHC @OLE @OLE_Redesign @nonProd
    Examples:
      | Scenario                 | PlanType |TFNNo          | site | planyear | planYear | zipcode | isMultutiCounty | county       | plantype | planName                                      | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | diabetesQ1 | diabetesQ2 | chronicQ1 | chronicQ2 | chronicQ3 | cardioQ1 | cardioQ2 | cardioQ3 | cardioQ4 | cardioQ5 | cardioQ6 | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |medicarenumber1|
      | CSNP- E2E Scenario 1_UHC | CSNP-MBI |1-844-882-7766 |UHC  | next     | next   |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP) | MBI      | TEST_PORTALS_CSNP | TEST_PORTALS_CSNP|4N36TE5EU30    | false   |  03011985 |  03011985 |     0123456789 | true     | 03231920 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Mcgee st  | IRVING      | TX           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | yes          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 578456|Valid         | TEST_PORTALS_M   | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | yes        | No         | No        | No        | No        | No       | No       | No       | No       | No       | No       | true     | Pay By Mail | [blank] | [blank]             | [blank]        |5N69QY6ET32    |


