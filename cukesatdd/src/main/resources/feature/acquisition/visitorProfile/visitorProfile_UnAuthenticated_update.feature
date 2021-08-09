@UATRegression @visitorProfile @visitorProfileUpdated
Feature: 1.08. UAT- Visitor profile

  Scenario Outline: Validate that M&R Prospective client has the ability to Compare plans in Guest profile.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And check one plan and add it to plancompare
    Then Verify newly added plan displayed on new plan compare page
    And click on Add your Hospitals link and Navigate to Rally page
    And I click on Get Started on and Add PrimaryCare PCP from find care page
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <DrugName> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
      | DrugName | <DrugName> |
    And click on Edit your doctors link and Navigate to Rally page
    And I click on Add Places from Hospitals find care page
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    Then agent saves a plans as favorite for user on plan compare page
      | PlanName | <planName> |
    Then remove "<removePlanIndices>" plan from new plan compare page
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And check one plan and add it to plancompare
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype2> |
    And user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans2> |
    Then user selects keepshopping on the pop-up
    And user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans3> |
    And the user clicks on the shopping cart icon
    And user selects plans to compare from visitor Profile
      | Plantype | <plantype> |
    Then user verify failure message after plan compare clicked
      | Plantype | <plantype> |
    And user selects plans to compare from visitor Profile
      | Plantype | <plantype2> |
    Then verify plan compare page is loaded when navigating from profile
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare

    @visitorProfileAARP @visitorProfileUpdatedUnAuthTest
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear | DrugName             | planName                             | removePlanIndices | plantype2 | testPlans2                      | testPlans3                      |
      | 00010 | AARP |   33111 | NO            | Los Angeles County | MAPD     |     2 | future   | atorvastatin calcium | AARP Medicare Advantage Choice (PPO) |                 3 | PDP       | AARP MedicareRx Walgreens (PDP) | AARP MedicareRx Preferred (PDP) |

    @visitorProfileUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear | DrugName             | planName                             | removePlanIndices | plantype2 | testPlans2                      | testPlans3                      |
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     2 | future   | atorvastatin calcium | AARP Medicare Advantage Choice (PPO) |                 3 | PDP       | AARP MedicareRx Walgreens (PDP) | AARP MedicareRx Preferred (PDP) |

  Scenario Outline: 
    Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile - zip -<zipcode>

    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And the user navigates to clicks on Enroll Now from visitor profile to start OLE flow
      | Plan Name       | <planName>       |
      | Plan Type       | <plantype>       |
      | Zip Code        | <zipcode>        |
      | County Name     | <county>         |
      | Monthly Premium | <monthlyPremium> |
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
    #Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.
   # Then the user validates the OLE Submission Details in GPS
     # | Plan Type                | <plantype>               |
    #  | Auth Flag                | <authflag>               |
     # | Mailing Address Question | <mailingaddressquestion> |
    @visitorProfileAARP @visitorProfileUpdatedUnAuthTest
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                                                                                  | plantype | planName                                  | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber |rxBinnumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | AARP | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO) | MAPD     | Medica HealthCare Plans MedicareMax (HMO) | future   |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 567890     |Valid          | MK         | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

    @visitorProfileUHC
    Examples: 
      | site | state   | zipcode | isMultiCounty | testPlans                                                                                                  | plantype | planName                                  | planYear | zipcode | county            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                     | optiondata | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | rxBinnumber |inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | UHC  | Florida |   33143 | Yes           | AARP Medicare Advantage Choice (PPO),Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO) | MAPD     | Medica HealthCare Plans MedicareMax (HMO) | future   |   33143 | Miami-Dade County | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | moved outside of the service area |   01012018 | yes     | yes          | false     | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | 567890      |Valid         | MK         | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

  Scenario Outline: 
    Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile - zip -<zipcode>

    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add plans button in the profile
    When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    #And the user selects plan year
      #| Plan Year | <planyear> |
      #| Plan Type | <plantype> |
    #Then the site user fills all the details in MedsuppPage
      #| DOB | <dob> |
    Then user saves two ms plans as favorite
      | MS Test Plans | <MS Test Plans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS Test Plans> |
    Then the site user clicks on MS Start Application Button and proceed Next
      | DOB        | <dob>       |
      | First Name | <firstname> |
      | Last Name  | <lastname>  |
      | PlanName   | <PlanName>  |
    Then the site user clicks on continue application until confirmaion page
      | MedicareNumber | <medicarenumber> |

    @visitorProfileAARP @visitorProfileUpdatedUnAuthTest
    Examples: 
      | site | state   | planyear | zipcode | isMultiCounty | county          | plantype | testPlans     | PlanName | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob        | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear | MS Test Plans |
      | AARP | Alabama | future   |   44114 | NO            | Cuyahoga County | MS       | Plan F,Plan N | Plan N   | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01/01/1946 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            | Plan F,Plan N |

    @visitorProfileUHC
    Examples: 
      | site | state   | planyear | zipcode | isMultiCounty | county          | plantype | testPlans     | PlanName | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob        | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear | MS Test Plans |
      | AARP | Alabama | future   |   44114 | NO            | Cuyahoga County | MS       | Plan F,Plan N | Plan N   | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01/01/1946 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            | Plan F,Plan N |
