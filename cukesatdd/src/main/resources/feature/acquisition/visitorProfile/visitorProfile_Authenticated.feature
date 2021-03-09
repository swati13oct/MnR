#Author: Naveen BK
#created Date:2/12/2019
@VisitorProfileAuthenticated
Feature: 1.08. UAT - Visitor profile Authenticated

  @vpMSSavePlanAuthenticated
  Scenario Outline: Verify user saves Medsupp plans from VPP to the unauthenticated visitor profile - zipcode - <zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  | userName   | password   |
      | AARP | Alabama |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A | mnrmedsupp | Password@1 |

    @VisitorProfile_UHC
    Examples: 
      | site | state   | zipcode | isMultiCounty | plantype | planyear | DOB        | county           | MS_testPlans  | userName   | password   |
      | UHC  | Alabama |   90210 | NO            | MS       | future   | 11/11/1949 | Jefferson County | Plan G,Plan A | mnrmedsupp | Password@1 |

  @addDrugAuthenticated
  Scenario Outline: Verify user is able to add drug information to the authenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
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

    @VisitorProfile_AARP
    Examples: 
      | site | state   | userName | password   | drug1   | zipCode |
      | AARP | Alabama | mnrqevd4 | Password@1 | Lipitor |   90210 |

    @VisitorProfile_UHC
    Examples: 
      | site | state   | userName | password   | drug1   | zipCode |
      | UHC  | Alabama | mnrqevd4 | Password@1 | Lipitor |   90210 |

  @providerFlowAuthenticated
  Scenario Outline: Verify Provider Search functional flow for authenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             |
      | AARP | New York |   10001 | NO              | New York County | mnrqevd4 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

    @VisitorProfile_UHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             |
      | UHC  | New York |   10001 | NO              | New York County | mnrqevd4 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

  @oleAuthenticatedValidations
  Scenario Outline: Verify OLE validations for authenticated Visitor Profile page
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

    @VisitorProfile_AARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             | status      | monthlyPremium |
      | AARP | New York |   10001 | NO              | New York County | mnrqevd4 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34.00         |

    @VisitorProfile_UHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName | password   | plantype | planname                             | status      | monthlyPremium |
      | UHC  | New York |   10001 | NO              | New York County | mnrqevd4 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | In Progress | $34.00         |

  @vpPartialOLEAndRemove
  Scenario Outline: Verify Partial enrollment and cancel or remove the enrollment from profile page
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
    Then the user clicks on save and return later to profile page
    And validate OLE details
      | Plan Name       | <planName>       |
      | Zip Code        | <zipcode>        |
      | Status          | <status>         |
      | Monthly Premium | <monthlyPremium> |
    And the user cancel the enrollment
      | Plan Name | <planName> |

    @VisitorProfile_AARP
    Examples: 
      | site | state    | userName | password   | zipcode | isMultiCounty | county          | planyear | PlanType | plantype | planName                              | cardtype | firstname | lastname | dob      | gender | permstreet    | permcity | mailingstate | mailingzip | email         | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | status      | monthlyPremium |
      | AARP | New York | mnrvd5   | Password@2 |   10001 | NO            | New York County | Next     | MA-MBI   | MA       | AARP Medicare Advantage Patriot (HMO) | MBI      | John      | Doe      | 01011903 | Male   | 003 Morris Rd | NY       | NY           |      10001 | test@test.com | 2n22C33YK33    | false   |  09011997 |  11012002 |      431665465 | In Progress | $0             |

  @prePopulateEmailFieldPlanSummaryAuthenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | AARP | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |

    @VisitorProfile_UHC
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | UHC  | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |

  @prePopulateEmailFieldPlanDetailAuthenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan detail page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clicks on plan name
      | Test Plans | <planname> |
    And the user click the Email Plan List envelope icon or text on Plan details page
    Then user want the email address associated to my profile prepopulated in the text box on plan detail page
      | User Name | <userName> |

    @VisitorProfile_AARP
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | AARP | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |

    @VisitorProfile_UHC
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | UHC  | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |

  @prePopulateEmailFieldPlanCompareAuthenticated
  Scenario Outline: Verify email prepopulate flow for authenticated profile on plan compare page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
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

    @VisitorProfile_AARP
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | AARP | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |

    @VisitorProfile_UHC
    Examples: 
      | site | state   | zipcode | isMultutiCounty | county             | userName              | password   | plantype | planname                                       |
      | UHC  | Alabama |   90210 | NO              | Los Angeles County | priyaruth@getnada.com | Password@1 | MAPD     | AARP Medicare Advantage Freedom Plus (HMO-POS) |
