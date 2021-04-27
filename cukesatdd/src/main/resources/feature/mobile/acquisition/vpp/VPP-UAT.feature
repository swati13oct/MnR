@UATRegression @regressionAARP
Feature: 1.01.4 UAT Feature to test VPP scenarios

  Scenario Outline: <Scenario> To test VPP stand alone widget from Shop pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user hovers screen over the shop for a plan
    And the user checks for Shop link under Shop For a Plan
    And the user clicks on the Shop link and lands on the shop page
    And the user clicks on the Shop button for Medicare Advantage Plan and navigates to MA plans page
    And the user validate ZipCode Components on Shop pages using ZipCode "80001"
    And the user clicks on See more benefits link on shop page
    And the user closes the new browser tab
    And the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |
    And the user closes the new browser tab
    And the user clicks on browser back button
    And the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page
    And the user validate ZipCode Components on Shop pages using ZipCode "10001"
    And the user clicks on DCE link to land on DCE Redesign from PDP Shop page
    And the user clicks on browser back button
    And the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |
    And the user closes the new browser tab
    And the user clicks on browser back button
    And the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page
    And the user validate ZipCode Components on Shop pages using ZipCode "90210"
    And the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |
    And the user closes the new browser tab
    And the user clicks on browser back button
    And the user validates Find your Plan section in Shop page
    And the user clicks on Compare Plans button and navigate to Shop Plan Compare Page
    And the user clicks on browser back button
    And the user clicks on Learn button and navigate to Shop Plan Estimate Costs Page
    And the user clicks on browser back button
    And the user clicks on How To button and navigate to Shop Plan Switch Page
    And the user clicks on browser back button
    And the user clicks on Learn More button and navigate to Safe Shopping Page
    And the user clicks on browser back button
    And the user clicks on Get Resources button and navigate to Member Resources Page
    And the user clicks on browser back button
    And the user validate ZipCode Components on Shop pages using ZipCode "10001"
    And the user validates Personalize Your Results section in Shop page
    And the user clicks on Check Drug Costs button and navigate to DCE Page
    And the user clicks on browser back button
    And the user clicks on Find a Provider button and navigate to Werally Page
    And the user closes the new browser tab
    And the user clicks on Locate a Pharmacy button and navigate to Pharmacy Page
    And the user clicks on browser back button
    And the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |
    And the user closes the new browser tab
    And the user hovers screen over the shop for a plan
    And the user clicks on Submit button using email address ""
    And the user clicks on Submit button using email address "namita_meher@optum.com"

    @vppPlanSummaryCommonAARP01
    Examples: 
      | Scenario           | site | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | https://www.myuhcagent.com/ |

    @vppPlanSummaryCommonUHC01
    Examples: 
      | Scenario           | site | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | https://www.myuhcagent.com/ |

  Scenario Outline: <Scenario> To test VPP NBA scenario for MA/PDP plans
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype1>" plans to compare
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user validates all added drugs in DrugList
    And clicks on Review drug cost button to land on drug summary page
    And the user clicks view plan details button for first plan from Drug Summary Page
    And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    When the user Click on Is my Provider covered link
      | PlanName | <planname1> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname1> |
    Then Verify provider name is displayed on Plan Summary page
      | PlanName | <planname1> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    #    Then user should be able to see the Select Plan for Enroll Modal with saved plans
    #      | Test Plans | <testplans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
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
    # | Perm_Aptno               | <permaptno>              |
    # | Mailing_Aptno            | <mailingaptno>           |
    Then the user enters following information in Personal Information Page
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
      | Home Number        | <phoneno>           |
      | Mobile Number      | <mobileno>          |
      | Middle Name        | <middlename>        |
    Then the user navigates to Medicare Information Page
    And the user cancels enrollment and navigates to homepage
    And the user quits the session
    When the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode2>        |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county2>         |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user validates all added drugs in DrugList
    And clicks on Review drug cost button to land on drug summary page
    And the user clicks view plan details button for first plan from Drug Summary Page
    And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    #    Then user should be able to see the Select Plan for Enroll Modal with saved plans
    #      | Test Plans | <testplans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
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
    # | Perm_Aptno               | <permaptno>              |
    # | Mailing_Aptno            | <mailingaptno>           |
    Then the user enters following information in Personal Information Page
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
      | Home Number        | <phoneno>           |
      | Mobile Number      | <mobileno>          |
      | Middle Name        | <middlename>        |
    Then the user navigates to Medicare Information Page
    And the user cancels enrollment and navigates to homepage

    @vppE2EScenario5 @vppPlanSummaryCommonAARP01
    Examples: 
      | Scenario              | site | zipcode | zipcode2 | isMultutiCounty | county            | county2     | plantype | plantype1 | drug1   | drug2     | drug3    | planyear | planname                        | planname1                            | firstname | lastname | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | emailConfirmation | goGreen | phoneno    | mobileno   | middlename  |
      | VPP-E2E Scenario5_AMP | AARP |   33111 |    90210 | No              | Miami-Dade County | Los Angeles | PDP      | MAPD      | Lipitor | Ibuprofen | Nicomide | next     | AARP MedicareRx Walgreens (PDP) | AARP Medicare Advantage Choice (PPO) | GOTTFRIED | GARRAND  | 04261944 | Male   | 003 Morris Rd | Miami    | No                     | 123 Test      | Miami       | FL           |      33111 | test@test.com | yes               | yes     | 1234567890 | 2345678901 | Test_Middle |

    @vppPlanSummaryCommonUHC01
    Examples: 
      | Scenario              | site | zipcode | zipcode2 | isMultutiCounty | county            | county2     | plantype | plantype1 | drug1   | drug2     | drug3    | planyear | planname                        | planname1                            | firstname | lastname | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | emailConfirmation | goGreen | phoneno    | mobileno   | middlename  |
      | VPP-E2E Scenario5_UMS | UHC  |   33111 |    90210 | No              | Miami-Dade County | Los Angeles | PDP      | MAPD      | Lipitor | Ibuprofen | Nicomide | next     | AARP MedicareRx Walgreens (PDP) | AARP Medicare Advantage Choice (PPO) | GOTTFRIED | GARRAND  | 04261944 | Male   | 003 Morris Rd | Miami    | No                     | 123 Test      | Miami       | FL           |      33111 | test@test.com | yes               | yes     | 1234567890 | 2345678901 | Test_Middle |
