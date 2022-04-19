@visitorProfileUnAuthenticated @visitorProfile
Feature: 1.09. UAT - Visitor profile MedSup UnAuthenticated

  @vpMSSavePlan
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile in <site> site - zip -<zipcode>
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
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |

    #No pdf link is avialable now
    #And user validate pdf link
    #| MS Test Plans | <MS_testPlans> |
    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @featureGate
    Examples:
      | site | state    | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  |
      | AARP | Virginia | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | state    | zipcode | isMultiCounty | plantype | planyear | DOB        | county        | MS_testPlans  |
      | UHC  | Virginia | 23223   | YES           | MS       | future   | 11/11/1949 | Richmond City | Plan G,Plan A |


  @vppMSSP4.0
  Scenario Outline: Verify user save Medsupp plans 4.0 with plan details,start application, learn more,add your information on unauthenticated visitor profile-Medsup4.0 in <site> site- zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user views the med supp plans
      | Plan Type | <plantype> |
    Then user saves two msvpp4 plans as favorite
      | MS Test Plans | <MS_testPlans> |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <MS_testPlans> |
    And user clicks on ms plan details button
      | MS Plan | <MS_Plan> |
    And user validates MS plan details
    And user clicks on Back to Profile link
    And user clicks on ms start application button
      | MS Plan | <MS_Plan> |
    And user validates MS Start application page
    And user close MS application page
    And user clicks on ms Learn More link
      | MS Plan | <MS_Plan> |
    And user validates MS Learn More page
    And user clicks on Back to Profile link
    And user clicks on MS Add your Information link
      | MS Plan | <MS_Plan> |
    And user validates MS Add your Information page
    And user close MS application page
    And user validates MS SP Profile page with Import, PRE and ComponentCode
      | Component Code | <component_code> |
    And user delets the added Ms plans on visitor profile page
      | MS_testPlans | <MS_testPlans> |

    @visitorProfile_AARP @VP_ProdRegression_AARP @prodRegression_AARP_02 @regressionAARP @vpMS4Start  @featureGate
    Examples:
      | site | zipcode | isMultiCounty | plantype | county                 | MS_testPlans                                      | MS_Plan                  | component_code |
      | AARP | 07303   | NO            | MS       | Hudson County          | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 20906   | NO            | MS       | Montgomery County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 30002   | NO            | MS       | DeKalb County          | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 66113   | NO            | MS       | Wyandotte County       | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | AARP | 06011   | NO            | MS       | Hartford County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 63113   | NO            | MS       | St. Louis City         | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 19706   | NO            | MS       | New Castle County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 39206   | NO            | MS       | Hinds County           | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 70726   | NO            | MS       | Livingston Parish      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 40475   | NO            | MS       | Madison County         | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 73008   | NO            | MS       | Oklahoma County        | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | AARP | 77070   | NO            | MS       | Harris County          | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |
      | AARP | 10001   | NO            | MS       | New York County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 05401   | NO            | MS       | Chittenden County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 71613   | NO            | MS       | Jefferson County       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 96701   | NO            | MS       | Honolulu County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 02860   | NO            | MS       | Providence County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 99501   | NO            | MS       | Anchorage Municipality | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 57103   | NO            | MS       | Minnehaha County       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 00982   | NO            | MS       | Carolina Municipio     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 00840   | NO            | MS       | St. Croix Island       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 96910   | NO            | MS       | Guam                   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | AARP | 55343   | NO            | MS       | Hennepin County        | Basic Plan,Extended Basic 2020 Plan               | Basic Plan               | WB27375S1      |
      | AARP | 01003   | NO            | MS       | Hampshire County       | Core Plan,Supplement 1A Plan                      | Core Plan                | WB27375ST      |
      | AARP | 53006   | Yes           | MS       | Dodge County           | Basic Plan,Basic Plan with Co-Payments            | Basic Plan               | WB27375S1      |
      | AARP | 58102   | NO            | MS       | Cass County            | Plan G,Plan A                                     | Plan G                   | WB27375ST      |

    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county                 | MS_testPlans                                      | MS_Plan                  | component_code |
      | UHC  | 07303   | NO            | MS       | Hudson County          | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 20906   | NO            | MS       | Montgomery County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 30002   | NO            | MS       | DeKalb County          | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 66113   | NO            | MS       | Wyandotte County       | Plan G,Plan A                                     | Plan G                   | WB27375KS      |
      | UHC  | 06011   | NO            | MS       | Hartford County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 63113   | NO            | MS       | St. Louis City         | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 19706   | NO            | MS       | New Castle County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 39206   | NO            | MS       | Hinds County           | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 70726   | NO            | MS       | Livingston Parish      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 40475   | NO            | MS       | Madison County         | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 73008   | NO            | MS       | Oklahoma County        | Plan G,Plan A                                     | Plan G                   | WB27375OK      |
      | UHC  | 77070   | NO            | MS       | Harris County          | Plan G + wellness extras,Plan F + wellness extras | Plan F + wellness extras | WB27375TX      |
      | UHC  | 10001   | NO            | MS       | New York County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 05401   | NO            | MS       | Chittenden County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 71613   | NO            | MS       | Jefferson County       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 96701   | NO            | MS       | Honolulu County        | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 02860   | NO            | MS       | Providence County      | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 99501   | NO            | MS       | Anchorage Municipality | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 57103   | NO            | MS       | Minnehaha County       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 00982   | NO            | MS       | Carolina Municipio     | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 00840   | NO            | MS       | St. Croix Island       | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 96910   | NO            | MS       | Guam                   | Plan G,Plan A                                     | Plan G                   | WB27375ST      |
      | UHC  | 55343   | NO            | MS       | Hennepin County        | Basic Plan,Extended Basic 2020 Plan               | Basic Plan               | WB27375S1      |
      | UHC  | 01003   | NO            | MS       | Hampshire County       | Core Plan,Supplement 1A Plan                      | Core Plan                | WB27375ST      |
      | UHC  | 53006   | Yes           | MS       | Dodge County           | Basic Plan,Basic Plan with Co-Payments            | Basic Plan               | WB27375S1      |
      | UHC  | 58102   | NO            | MS       | Cass County            | Plan G,Plan A                                     | Plan G                   | WB27375ST      |


    @visitorProfile_UHC @VP_ProdRegression_UHC @prodRegression_UHC_02 @prodRegression @regressionUHC
    Examples:
      | site | zipcode | isMultiCounty | plantype | county                 | MS_testPlans  | MS_Plan | component_code |
      | AARP | 05401   | NO            | MS       | Chittenden County      | Plan G,Plan A | Plan G  | WB27375ST      |
      | AARP | 99501   | NO            | MS       | Anchorage Municipality | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 00982   | NO            | MS       | Carolina Municipio     | Plan G,Plan A | Plan G  | WB27375ST      |
      | UHC  | 58102   | NO            | MS       | Cass County            | Plan G,Plan A | Plan G  | WB27375ST      |

  @SavePlanPRE @prodRegression
  Scenario Outline: User validate PRE flow for MS from Visitor Profile on <site> site for zipcode -<Zipcode>
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
    And verify continue function on "Priorities" page
    Then user validate elements in loading results page
    Then user save plan on PRE and then go to profile page
      | PlanName | <testPlans> |
    And user validates the added Ms plans on visitor profile page
      | MS Test Plans | <testPlans> |

    @SavePlanPRE_AARP @regressionAARP
    Examples:
      | site | Zipcode | isMultiCounty | state         | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans                              | 1stRecommendation | 2ndRecommendation | UserType      | userName  | password    |
      | AARP | 07303   | NO            | New Jersey    | Hudson County      | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Plan F,Plan G                          | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | AARP | 55416   | NO            | Minnesota     | Hennepin County    | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Extended Basic Plan,Basic Plan         | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | AARP | 53006   | YES           | Wisconsin     | Fond du Lac County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Basic Plan,Basic Plan with Co-Payments | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | AARP | 02532   | YES           | Massachusetts | Plymouth County    | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Supplement 1 Plan,Supplement 1A Plan   | SNP               | MA                | Authenticated | DDProfile | Test@123456 |

    @SavePlanPRE_UHC @regressionUHC
    Examples:
      | site | Zipcode | isMultiCounty | state         | county             | isCoverageOpt | specialNeeds | doctors         | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | testPlans                              | 1stRecommendation | 2ndRecommendation | UserType      | userName  | password    |
      | UHC  | 07303   | NO            | New Jersey    | Hudson County      | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Plan F,Plan G                          | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | UHC  | 55416   | NO            | Minnesota     | Hennepin County    | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Extended Basic Plan,Basic Plan         | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | UHC  | 53006   | YES           | Wisconsin     | Fond du Lac County | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Basic Plan,Basic Plan with Co-Payments | SNP               | MA                | Authenticated | DDProfile | Test@123456 |
      | UHC  | 02532   | YES           | Massachusetts | Plymouth County    | MAPD          | None         | AcceptsMedicare | [blank]     | [blank]       | No             | No,No,No,No                   | Higher               | Supplement 1 Plan,Supplement 1A Plan   | SNP               | MA                | Authenticated | DDProfile | Test@123456 |

