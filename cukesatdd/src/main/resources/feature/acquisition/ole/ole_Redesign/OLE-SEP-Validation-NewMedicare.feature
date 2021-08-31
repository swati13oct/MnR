Feature: 1.05.3 OLE common tool flow SEP Validation- Selecting-Checkboxes for "I'm new to Medicare and enrolling for the first time"

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
    Then the user selects the following options for new medicare SEP Page
      | Select Options | <selectoptions> |
     | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
  # Then the user validates PCP page for MA and MAPD PFFS plans
  # Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
   # Then the user selects payment type
    #  | Payment Type           | <paymentType>         |
    #  | Card No                | <cardno>              |
    #  | Card Expiration Month  | <cardexpirationmonth> |
    #  | Card Expiration Year   | <cardexpirationyear>  |
   #   | Card Holder First Name | <firstname>           |
   #   | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Authorization Page
    Then the user validates Authorization Page Applicant
    Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment

  @OLE_Redesign_SEP_MAPD @OLE_Redesign_SEP
    Examples:
      | TID   | site | PlanType      | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname            | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                         | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 |UHC	 | MAPD-RRID-MBI | future   | future   |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO)                | MBI      | TEST_SEP2_NM_MAPD      | TEST_SEP2_NM_MAPD   | 3A33C22YK20    | false   |  07012021 |  07012021 |     0123456789 | false    | 03011949 | Male   | 001 Morris Rd | New York    | No                     | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | [blank]                                      | [blank]                   | No     | No          | true_No      | No               | No      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456         | Valid         | Test_MiddleName    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  @OLE_Redesign_SEP_MA @OLE_Redesign_SEP
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county          | plantype | planName                                            | cardtype | firstname              | lastname            | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                    | optiondata                | pdpFlag | longTermFlag | riderflag     | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber    | inputdataType | middlename         | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 | AARP | MA-MBI  | future   | future   |   33112 | NO              | Miami-Dade County| MA   |  AARP Medicare Advantage Patriot (Regional PPO)     | MBI      | TEST_SEP2_NM_MA      | TEST_SEP2_NM_MA  | 5N69QY6ET31    | false   |  07012021 |  07012021 |     0123456789 | true     | 03011948 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Test      | Edison      | FL           |      33112 | test@test.com | [blank]                                  | [blank]                   |  No    | No          | false         | No               | No     | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456        |Valid          | [blank]            | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |

  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from Acquisition <site> VPP Plan Summary for DSNP Plans
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
    Then the user selects the following options for new medicare SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
   # Then the user validates PCP page for MA and MAPD PFFS plans
   # Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
  #  Then the user selects payment type
    #  | Payment Type           | <paymentType>         |
    #  | Card No                | <cardno>              |
     # | Card Expiration Month  | <cardexpirationmonth> |
     # | Card Expiration Year   | <cardexpirationyear>  |
     # | Card Holder First Name | <firstname>           |
     # | Card Holder Last Name  | <lastname>            |
        Then the user navigates to Authorization Page
    Then the user validates Authorization Page Applicant
    Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
   # Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment

  @OLE_Redesign_SEP @OLE_Redesign_SEP_DSNP
    Examples:
      | TID   | site | PlanType			| planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      												| optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber| inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 | AARP  | DSNP-MBI 		| future   | future   | 11355   | No              | Queens County    | SNP      |  UnitedHealthcare Dual Complete (HMO D-SNP)							 | MBI      | TEST_SEP2_NM_DSNP      | TEST_SEP2_NM_DSNP  | 1EG1TE1MK34    | true   | 123456789 |  07012021 |  07012021 |     0123456789 | true     | 03011947 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | NY           |      11355 | test@test.com | [blank]      		| [blank]         | No     | No          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 123456    |Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     |[blank]  | [blank] | [blank]             | [blank]            |

  @OLE_Redesign_SEP @OLE_Redesign_SEP_MR_DSNP
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county         | plantype | planName                                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | SSNnumber | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | phoneno    | mobileno   | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 | AARP | DSNP-MBI | future   | future   |   72201 | No             | Pulaski County | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | MBI      | TEST_SEP2_NM_MRDSNP | TEST_SEP2_NM_MRDSNP  | 1EG1TE1MK12    | false   | 123456789 |  07012021 |  07012021|     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | AR           |      72201 | test@test.com | plan started within the last 3 months | 05012021 | No     | No          | false     | NO                | NO      | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | 1234567890 | 2345678901 | S          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | [blank]     | [blank] | [blank]             | [blank]            |

  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition <site> VPP Plan Summary for CSNP Plans
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
    #Then the user validates the Plan details on OLE
    Then the user validates the Plan details on OLE CSNP Plans
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
    Then the user selects the following options for new medicare SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Authorization Page
    Then the user validates Authorization Page Applicant
	   Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
	  Then the user clicks on Submit Enrollment to complete enrollment

  @OLE_Redesign_SEP  @OLE_Redesign_SEP_CSNP
    Examples:
      | TID   | PlanType | site | planyear | planYear | zipcode | isMultutiCounty | county       | plantype | planName                                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                         | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | diabetesQ1 | diabetesQ2 | chronicQ1 | chronicQ2 | chronicQ3 | cardioQ1 | cardioQ2 | cardioQ3 | cardioQ4 | cardioQ5 | cardioQ6 | authflag | paymentType                                    | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 | CSNP-MBI | AARP  | future   | future   |   78006 | No             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) | MBI      | TEST_SEP2_NM_CSNP      | TEST_SEP2_NM_CSNP | 5N69QY6ET32    | false   |  07012021 |  07012021 |      431665465 | true     | 04011944 | Male   | 003 Morris Rd | Los Angeles | No                     | 123 Mcgee st  | IRVING      | TX           |      78006 | test@test.com | [blank]          | [blank]          | No     | No          | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    |123456        |  Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | No        | No         | No        | No        | No        | No       | No       | No       | No       | No       | No       | true     | Pay By Mail                                    | [blank] | [blank]             | [blank]            |

  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from <site> Acquisition site VPP Plan Details Page
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
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
   Then the user validates the Plan details on OLE
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
    Then the user selects the following options for new medicare SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Proposed Effective Date Page
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Authorization Page
    Then the user validates Authorization Page Applicant
    Then the user validates Statement of Understanding Page
      | soAAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment


  @OLE_Redesign_SEP @OLE_Redesign_SEP_PDP1
    Examples:
      | TID   | site | PlanType | planyear | planYear | zipcode | isMultutiCounty | county        | plantype | planName                         | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                   | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber|inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | 15514 | UHC  | PDP-MBI  | future   | future   |   80210 | NO              | Denver County | PDP      | AARP MedicareRx Preferred (PDP)  | MBI      | TEST_SEP2_NM_PDP     | TEST_SEP2_NM_PDP      | 3A33C22YK21    | false   |  07012021 |  07012021 |     0123456789 | false    | 05011953 | Female | 002 Morris Rd | Los Angeles | No                     | 802 MailingSt | Mailing LA  | CO           |      80210 | test@test.com |[blank]   		| 	[blank]  		| No     | no           | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 789456 |InValid       | K          | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
