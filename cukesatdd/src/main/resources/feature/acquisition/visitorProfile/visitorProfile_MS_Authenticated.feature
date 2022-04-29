@visitorProfileAuthenticated @visitorProfile @nonProd
Feature: 1.09. UAT - Visitor profile MedSup Authenticated

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
      | UID                                   | site | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  | userName    | password       |
      | Visitor Profile - E2E Scenario 7 _AMP | AARP | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A | vdmsatdd_01 | Password@12345 |

#    @visitorProfile_UHC @regressionUHC @authenticatedUHC @featureGate
    Examples:
      | UID                                   | site | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  | userName        | password       |
      | Visitor Profile - E2E Scenario 7 _UHC | UHC  | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A | vdmsatdd_01_uhc | Password@12345 |


  @SavePlanPRE
  Scenario Outline: User validate PRE flow for <plantype> from Visitor Profile on <site> site for zipcode -<Zipcode> for plan <testPlan>
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

    @SavePlanPRE_AARP @regressionAARP
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | testPlan | userName              | password     | Premium | plantype |
      | AARP | 19901   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | 1st            | Health Care Premium, Doctors | Plan F   | vdatdd_19@getnada.com | Password@123 | [blank] | MS       |

    @SavePlanPRE_UHC @regressionUHC
    Examples:
      | site | Zipcode | isMultiCounty | county   | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | priorityOption | priorities                   | testPlan | userName                  | password     | Premium | plantype |
      | UHC  | 19901   | NO            | New York | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | 1st            | Health Care Premium, Doctors | Plan F   | vdatdd_19_uhc@getnada.com | Password@123 | [blank] | MS       |