#Author: Naveen BK
#created Date:2/12/2019
@visitorProfileAuthenticated @visitorProfile @nonProd
Feature: 1.09. UAT - Visitor profile Authenticated

#  @vpMSSavePlanAuthenticated @authenticated
  Scenario Outline: <UID> : Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode> on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user fills out medsup form and proceeds to next pages
      | Zip Code | <zipcode> |
      | DOB      | <DOB>     |
    Then user saves two ms plans as favorite
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |
    And user delets the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |


#    @visitorProfile_AARP @regressionAARP @authenticatedAARP

    Examples:
      | UID                                   | site | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  | userName    | password     |
      | Visitor Profile - E2E Scenario 7 _AMP | AARP | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A | vdmsatdd_01 | Password@123 |

#    @visitorProfile_UHC @regressionUHC @authenticatedUHC @featureGate
    Examples:
      | UID                                   | site | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  | userName        | password     |
      | Visitor Profile - E2E Scenario 7 _UHC | UHC  | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A | vdmsatdd_01_uhc | Password@123 |

  @addDrugAuthenticated @authenticated
  Scenario Outline: <UID> : Verify user is able to add drug information to the authenticated visitor profile on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then the user deletes all the added drugs from profile page
      | DrugName | <drug1> |
    And the user clicks on the add drugs button in the profile
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    Then the user deletes all the added drugs from profile page
      | DrugName | <drug1> |

    @visitorProfile_AARP @regressionAARP @sanity @authenticatedAARP
    Examples:
      | UID                                   | site | state   | userName  | password     | drug1   | zipCode |
      | Visitor Profile - E2E Scenario 6 _AMP | AARP | Alabama | vdatdd_02 | Password@123 | Lipitor | 90210   |

    @visitorProfile_UHC @regressionUHC @featureGate
    Examples:
      | UID                                   | site | state   | userName      | password     | drug1   | zipCode |
      | Visitor Profile - E2E Scenario 6 _UHC | UHC  | Alabama | vdatdd_02_uhc | Password@123 | Lipitor | 90210   |

  @providerFlowAuthenticated @authenticated
  Scenario Outline: Verify Provider Search functional flow for authenticated Visitor Profile page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    @visitorProfile_AARP @regressionAARP @vbfGate1 @authenticatedAARP
    Examples:
      | site | state    | zipcode | isMultutiCounty | county          | userName  | password     | plantype | planname                             |
      | AARP | New York | 10010   | NO              | New York County | vdatdd_13 | Password@123 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

    @visitorProfile_UHC @regressionUHC @featureGate
    Examples:
      | site | state    | zipcode | isMultutiCounty | county          | userName      | password     | plantype | planname                             |
      | UHC  | New York | 10010   | NO              | New York County | vdatdd_13_uhc | Password@123 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

  @oleAuthenticatedValidations @authenticatedd
  Scenario Outline: Verify OLE validations for authenticated Visitor Profile page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then validate OLE details
      | Plan Name       | <planname>       |
      | Zip Code        | <zipcode>        |
      | Status          | <status>         |
      | Monthly Premium | <monthlyPremium> |

    @visitorProfile_AARP @regressionAARP @authenticatedAARP
    Examples:
      | site | state    | zipcode | isMultutiCounty | county          | userName  | password     | plantype | planname                             | status      | monthlyPremium |
      | AARP | New York | 10010   | NO              | New York County | vdatdd_14 | Password@123 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34            |

    @visitorProfile_UHC @regressionUHC @featureGate
    Examples:
      | site | state    | zipcode | isMultutiCounty | county          | userName  | password     | plantype | planname                             | status      | monthlyPremium |
      | UHC  | New York | 10010   | NO              | New York County | vdatdd_14 | Password@123 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34            |

  @vppartialOLEAndRemove @authenticated
  Scenario Outline: <UID>: Verify Partial enrollment and cancel or remove the enrollment from profile page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user cancel the enrollment
      | Plan Name | <planName> |
    And the user navigates to clicks on Enroll Now from visitor profile to start OLE flow
      | Plan Name       | <planName>       |
      | Plan Type       | <plantype>       |
      | Zip Code        | <zipcode>        |
      | County Name     | <county>         |
      | Monthly Premium | <monthlyPremium> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
      | Middle Name              | <middlename>             |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Perm_AptNo               | <mailingaptno>           |
      | Mailing_AptNo            | <mailingaptno>           |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | Email Confirmation       | <emailConfirmation>      |
      | Go Green                 | <goGreen>                |
      | MedicaidNumber           | <medicaidnumber>         |
      | Home Number              | <homeNumber>             |
      | Mobile Number            | <homeNumber>             |
    Then the user clicks on save and return later to profile page
    And validate OLE details
      | Plan Name       | <planName>       |
      | Zip Code        | <zipcode>        |
      | Status          | <status>         |
      | Monthly Premium | <monthlyPremium> |
    And the user cancel the enrollment
      | Plan Name | <planName> |

    @visitorProfile_AARP @regressionAARP @vbfGate1 @authenticatedAARP @featureGate
    Examples:
      | UID                                   | site | state    | userName  | password     | zipcode | isMultiCounty | county          | planyear | PlanType | plantype | planName                              | cardtype | firstname | lastname | middlename | dob      | gender | permstreet    | permcity | mailingaptno | mailingstate | mailingzip | email         | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | status      | monthlyPremium | homeNumber | emailConfirmation | goGreen |
      | Visitor Profile - E2E Scenario 4 _AMP | AARP | New York | vdatdd_15 | Password@123 | 10010   | NO            | New York County | Next     | MA-MBI   | MA       | AARP Medicare Advantage Patriot (HMO) | MBI      | John      | Doe      | test       | 01011903 | Male   | 003 Morris Rd | NY       | test         | NY           | 10001      | test@test.com | 2n22C33YK33    | false   | 09011997  | 11012002  | 431665465      | In Progress | $0             | 1111111111 | No                | No      |

  @prePopulateEmailFieldPlanSummaryAuthenticated @authenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan summary page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    And the user click the Email Plan List envelope icon or text on Plan summary page
    Then user want the email address associated to my profile prepopulated in the text box on plan summary page
      | User Name | <userName> |

    @visitorProfile_AARP @regressionAARP @authenticatedAARP @featureGate
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | AARP | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

    @visitorProfile_UHC @regressionUHC @vbfGate1
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | UHC  | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

  @prePopulateEmailFieldPlanDetailAuthenticated @authenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan detail page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clicks on plan name
      | Test Plans | <planname> |
    And the user click the Email Plan List envelope icon or text on Plan details page
    Then user want the email address associated to my profile prepopulated in the text box on plan detail page
      | User Name | <userName> |

    @visitorProfile_AARP @regressionAARP @authenticatedAARP
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | AARP | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

    @visitorProfile_UHC @regressionUHC @featureGate
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | UHC  | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

  @prePopulateEmailFieldPlanCompareAuthenticated @authenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan compare page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And the user click the Email Plan List envelope icon or text on Plan compare page
    Then user want the email address associated to my profile prepopulated in the text box on plan compare page
      | User Name | <userName> |

    @visitorProfile_AARP @regressionAARP @authenticatedAARP
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | AARP | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

    @visitorProfile_UHC @regressionUHC @featureGate
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | userName              | password       | plantype | planname                            |
      | UHC  | Alabama | 10010   | NO              | New York County | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) |

  @validateHeaderWidget @authenticated
  Scenario Outline: Verify Visitor Profile page Header on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And validate the new profile header
      | Name | <name> |

    @visitorProfile_AARP
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | name | userName              | password       | plantype | planname                            | drugList           | providerList          |
      | AARP | Alabama | 10010   | NO              | New York County | VD   | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) | Microlipid EMU 50% | Michael M Raffinan MD |

    @visitorProfile_UHC
    Examples:
      | site | state   | zipcode | isMultutiCounty | county          | name | userName              | password       | plantype | planname                            | drugList           | providerList          |
      | UHC  | Alabama | 10010   | NO              | New York County | VD   | vdatdd_16@getnada.com | Password@12345 | MAPD     | AARP Medicare Advantage Prime (HMO) | Microlipid EMU 50% | Michael M Raffinan MD |

  @validateVPFlyoutName @authenticated
  Scenario Outline: Verify name is appearing for the signed in user on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then the user validate the name on visitor profile flyout
      | Name | <name> |

    @visitorProfile_AARP
    Examples:
      | site | name | userName              | password     |
      | AARP | VD   | vdatdd_17@getnada.com | Password@123 |

    @visitorProfile_UHC
    Examples:
      | site | name | userName              | password     |
      | UHC  | VD   | vdatdd_17@getnada.com | Password@123 |

  @authenticated @DCEImportSignIn
  Scenario Outline: Verify DCE Redirect  on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button in the profile
    Then the user validates Get Started Page
    Then the user clicks on import drugs link
    Then the user starts the import of the drugs
      | FirstName | <firstName> |
      | LastName  | <lastName>  |
      | DOB       | <dob>       |
      | ZipCode   | <zipcode>   |
      | MBI       | <mbi>       |
      | Member    | <member>    |
    Then the user signs in with optum Id credentials on DCE import
      | User Name | <userName> |
      | Password  | <password> |

    @visitorProfile_AARP
    Examples:
      | site | member | firstName | lastName | dob        | zipcode | mbi         | userName               | password     |
      | AARP | UHC    | JONETTE   | ESCUTIA  | 03/27/1936 | 06902   | 3PW3A88CU71 | jonette@getairmail.com | Password@123 |

    @visitorProfile_UHC
    Examples:
      | site | member | firstName | lastName | dob        | zipcode | mbi         | userName               | password     |
      | UHC  | UHC    | JONETTE   | ESCUTIA  | 03/27/1936 | 06902   | 3PW3A88CU71 | jonette@getairmail.com | Password@123 |


  Scenario Outline: User validate PRE flow for MS from Visitor Profile on <site> site for zipcode -<zipcode> for plan <testPlan>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user click on Get Started to land on Plan Recommendation Page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    #And verify continue function on "Priorities" page
    #Then user validate elements in loading results page
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user click on save result option for PRE and signs in to VP
      | User Name | <userName> |
      | Password  | <password> |
    Then user validate plan recommendation plan card on visitor profile
      | PlanName | <testPlan> |
      | Premium  | <Premium>  |
      | PlanType | <plantype> |
    Then user validate view Plan details on PRE plan card and check enroll or start application button
      | PlanType | <plantype> |

    @SavePlanPRE_AARP
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | testPlan                             | userName              | password     | Premium | plantype |
      | AARP | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Lower                | [blank]        | [blank]                      | AARP Medicare Advantage Choice (PPO) | vdatdd_18@getnada.com | Password@123 | $0      | MAPD     |
      | AARP | 19901   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | 1st            | Health Care Premium, Doctors | Plan F                               | vdatdd_19@getnada.com | Password@123 | [blank] | MS       |

    @SavePlanPRE_UHC
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | testPlan                             | userName                  | password     | Premium | plantype |
      | UHC  | 07303   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Lower                | [blank]        | [blank]                      | AARP Medicare Advantage Choice (PPO) | vdatdd_18_uhc@getnada.com | Password@123 | $0      | MAPD     |
      | UHC  | 19901   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | 1st            | Health Care Premium, Doctors | Plan F                               | vdatdd_19_uhc@getnada.com | Password@123 | [blank] | MS       |