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
    And the user clicks on the shopping cart icon
    And the user clicks on the add plans button in the profile
    When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user selects keepshopping on the pop-up
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear>  |
      | Plan Type | <plantype1> |
    And user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans1> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype2> |
    And the user selects plan year
      | Plan Year | <planyear>  |
      | Plan Type | <plantype2> |
    And user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans2> |
    And the user clicks on the shopping cart icon
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans1> |
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans2> |
    And the user enrolls the plan from VisitorProfile
      | Plan Name | <PlanName> |
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
    # | Middle Name         		 | <middlename>       |
    Then the user enters following information in Personal Information Page
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
      | Home Number        | <phoneno>           |
      | Mobile Number      | <mobileno>          |
      | Middle Name        | <middlename>        |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    #Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      # | PartA Date         | <partadate>         |
      # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    #Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #    Then the user navigates to Preliminary Questions Page
    Then the user validates Medicaid Number in confirm Eligibility Page
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
    Then the user navigates to SEP Page
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
    Then the user validates the OLE Submission Details in GPS
      | Plan Type                | <plantype>               |
      | Auth Flag                | <authflag>               |
      | Mailing Address Question | <mailingaddressquestion> |
    Then the user validates whether call icon is visible
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    @visitorProfileAARP @visitorProfileUpdatedUnAuthTest
    Examples: 
      | site | state   | planyear | zipcode | isMultiCounty | county        | plantype | testPlans                                                                                         | plantype1 | testPlans1                      | plantype2 | testPlans2                                                 | PlanName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | AARP | Alabama | future   |   30342 | NO            | Fulton County | MAPD     | UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) | PDP       | AARP MedicareRx Walgreens (PDP) | SNP       | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP Medicare Advantage Walgreens (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

    @visitorProfileUHC
    Examples: 
      | site | state   | planyear | zipcode | isMultiCounty | county        | plantype | testPlans                                                                                         | plantype1 | testPlans1                      | plantype2 | testPlans2                                                 | PlanName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
      | UHC  | Alabama | future   |   30342 | NO            | Fulton County | MAPD     | UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) | PDP       | AARP MedicareRx Walgreens (PDP) | SNP       | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | AARP Medicare Advantage Walgreens (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |

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
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then the site user fills all the details in MedsuppPage
      | DOB | <dob> |
    Then user saves two plans as favorite
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
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
