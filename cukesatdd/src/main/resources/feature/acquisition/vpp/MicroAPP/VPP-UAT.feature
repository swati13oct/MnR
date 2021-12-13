@UATRegression 
Feature: 1.01.4 UAT Feature to test VPP scenarios

  Scenario Outline: <Scenario> : Validate that M&R Prospective client has the ability to navigate to Plan summary page and Enroll in a Plan
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode1>         |
      | Is Multi County | <isMultutiCounty1> |
      | County Name     | <county1>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user changes zipcode within VPP page
      | Zip Code        | <zipcode2>         |
      | Is Multi County | <isMultutiCounty2> |
      | County Name     | <county2>          |
    #user has to click on cancel button on popup
    When user clicks on Change Zip code link
    Then user clicks on Select by Address and Enter fileds
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    And the user clicks on Find plans on vpp using following information
      | County Name2     | <county3>        |
      | Is Multi County2 | <isMultiCounty3> |
    And the user validates plan summary for the below plan
      | Plan Name | <MAplanName> |
      | Plan Type | <plantype> |
    Then I validate "<plantype>" plans with names "<planNamesList>" are listed correctly on summary page
    Then the user validates marketing bullets of the plan
    And I validate view more and view less links on plan summary
    Then the user validates and clicks Add to compare checkbox for the above selected plan for MA, MAPD , PDP Plans
    Then the user views plan details of the above selected plan and validates
      | Plan Name | <MAplanName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then the user validates below plan benefit values for the above selected plan
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
      | Annual Deductible          | <annualDeductible>       |
    Then I save "<plantype>" plans and "<SavePlansCount>" plans and verify the count update on shopping cart
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text
    # New steps for DCE Redesign
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype>   |
      | Plan Name | <MAplanName> |
    Then the user validates Get Started Page
    Then the user click on return to plan summary from Get Started Page to return to VPP Plan Summary
    Then the user validates Is my provider covered link
    Then the user clicks on Enroll Now and validates the Welcome to OLE Page
    And the user clicks on browser back button
    And the user validates plan summary for the below plan
      | Plan Name | <MAplanName> |
    Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user validates plan summary for the below plan
      | Plan Name | <PDPplanName> |
    Then the user validates marketing bullets of the plan
    Then the user validates and clicks Add to compare checkbox for the above selected plan for MA, MAPD , PDP Plans
    Then the user validates below plan benefit values for the above selected plan
      | Monthly Premium            | <PDPmonthlyPremium>         |
      | Primary Care Physician     | <PDPprimaryCarePhysician>   |
      | Specialist                 | <PDPspecialist>             |
      | Referral Required          | <PDPreferralRequired>       |
      | Out Of Pocket Maximum      | <PDPoutOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <PDPprescriptionDrugsTier1> |
      | Plan Type                  | <PDPplantype>               |
      | Annual Deductible          | <PDPannualDeductible>       |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text
    And the user validates plan summary for the below plan
      | Plan Name | <PDPplanName> |
    Then I select "<PDPplantype>" plans and "<planIndices>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then remove "<removePlanIndices>" plan from new plan compare page
    Then validate all available plans are shown on click of view all plans
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <PDPplanName> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on View Plan Compare button and validates Plan Compare page, Drug Info Modal
    Then the user closes the Drug Info Modal on Plan Compare page
    Then the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page
    Then the user deletes the following drug from Drug list
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <PDPplanName> |
    Then the user validates planName matches plan Name in VPP
    Then the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal
    Then user click on close button on Drug info Modal popup
    Then verify plan compare page is loaded
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    And the user clicks on browser back button
    Then verify plan compare page is loaded

    @vppPlanCompareCommon_AARP01New @prodRegression_UAT @regressionAARP @MHJ
    Examples: 
      | Scenario                  | site | zipcode1 | isMultutiCounty1 | county1     | zipcode2 | isMultutiCounty2 | county2      | plantype | MAplanName                           | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | PDPplantype | PDPplanName                     | PDPmonthlyPremium | PDPprimaryCarePhysician | PDPspecialist | PDPreferralRequired | PDPoutOfPocketMaximum | PDPprescriptionDrugsTier1 | PDPannualDeductible                                   | address          | city   | state   | county3 | isMultiCounty3 | SavePlansCount | planIndices | drug1  | drug2                | drug3   | removePlanIndices | planNamesList                                                                                                           |
      | VPP - E2E Scenario 1_AARP | AARP |    90210 | No               | Los Angeles |    78006 | Yes              | Bexar County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | $20            | $10  copay           | $45  copay | No               | $6,700.00          | $2  copay              | [blank]          | PDP         | AARP MedicareRx Walgreens (PDP) | $37.90            | [blank]                 | [blank]       | [blank]             | [blank]               | $0  copay                 | $0 for Tier 1, Tier 2 $445 for Tier 3, Tier 4, Tier 5 | 1062 Nbranchroad | ripton | Vermont | Addison | No             |              3 |           3 | Ativan | diclofenac potassium | Lipitor |               2,3 | AARP Medicare Advantage Plan 3 (HMO),AARP Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Plan 2 (HMO) |

    @vppPlanCompareCommon_UHC01New @regressionUHC
    Examples: 
      | Scenario                 | site | zipcode1 | isMultutiCounty1 | county1     | zipcode2 | isMultutiCounty2 | county2      | plantype | MAplanName                           | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | PDPplantype | PDPplanName                     | PDPmonthlyPremium | PDPprimaryCarePhysician | PDPspecialist | PDPreferralRequired | PDPoutOfPocketMaximum | PDPprescriptionDrugsTier1 | PDPannualDeductible                                   | address          | city   | state   | county3 | isMultiCounty3 | SavePlansCount | planIndices | drug1  | drug2                | drug3   | removePlanIndices | planNamesList                                                                                                           |
      | VPP - E2E Scenario 1_UHC | UHC  |    90210 | No               | Los Angeles |    78006 | Yes              | Bexar County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | $20            | $10  copay           | $45  copay | No               | $6,700.00          | $2  copay              | [blank]          | PDP         | AARP MedicareRx Walgreens (PDP) | $37.90            | [blank]                 | [blank]       | [blank]             | [blank]               | $0  copay                 | $0 for Tier 1, Tier 2 $445 for Tier 3, Tier 4, Tier 5 | 1062 Nbranchroad | ripton | Vermont | Addison | No             |              3 |           3 | Ativan | diclofenac potassium | Lipitor |               2,3 | AARP Medicare Advantage Plan 3 (HMO),AARP Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Plan 2 (HMO) |

  Scenario Outline: TID: <Scenario> - Plan Type: <plantype> - Validate that M&R Prospective client has the ability to add drugs through VPP Plan details <site> site.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user hover over Shop for a Plan and validates zipcode component
    Then the user validate ZipCode Components on SubNav using ZipCode "<zipcode>"
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link
    Then verify all links on plan compare page is loaded
    Then validate all available plans are shown on click of view all plans
    Then verify view all plan button is not displayed
    Then remove one plan from new plan compare page
    Then verify all links on plan compare page is loaded
    Then Click on view more plans for right navigaton
    Then Click on view less plans for left navigaton
    Then the user clicks on Plan details link in new Plan Compare page
    Then the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then verify Add doctors is loaded with doctor summary on Plan Compare page
    And click on Add your doctors link and Navigate to Rally page
    And I click on Get Started on and Add PrimaryCare PCP from find care page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    And click on Edit your doctors link and Navigate to Rally page
    When user selects a provider from medical group and retuns to plan compare page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    Then verify Add Hospitals is loaded without summary on Plan Compare page
    And click on Add your Hospitals link and Navigate to Rally page
    And I click on Add Places from Hospitals find care page
    Then verify plan compare page is loaded
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    And click on Edit your Hospitals link and Navigate to Rally page
    When user selects a Hospitals from Clinical and retuns to plan compare page
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    Then validate all available plans are shown on click of view all plans
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on View Plan Compare button and validates Plan Compare page, Drug Info Modal
    Then the user closes the Drug Info Modal on Plan Compare page
    Then the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page
    Then the user deletes the following drug from Drug list
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal
    Then user click on close button on Drug info Modal popup
    Then verify plan compare page is loaded
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    And the user clicks on browser back button
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    And the user validates plan summary for the below plan
      | Plan Name | <planname> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planname> |
    Then validate all subtabs displayed on plan details
    Then User click on provider link on Medical tab and navigates to rally page
    Then user click on Finish Retun button on rally page navigates to plan details page
    Then Verify X out of Y provider covered information is displayed on Plan Details page
    Then the user click on Plan costs tab and validates in site
      | Monthly Premium | <MonthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |
    Then the user click on Prescription Drug Benefits and validates
    When the user clicks on Edit drug on plan details page and navigates to DCE
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user click on Prescription Drug Benefits and validates
    Then the user clicks on Edit drug on plan details page and navigates to DCE
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user click on Optional Services tab and add the rider on site
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user validates following PDF link is displayed with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in site URL
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    @vppPlanCompareCommon_AARP01New @regressionAARP
    Examples: 
      | Scenario                 | site | zipcode | isMultiCounty | county           | plantype | count | planyear | drug1  | drug2                | drug3   | planname                             | pdfType               | docCode                  | planyear | MonthlyPremium | yearlyPremium | optionalRider   | monthlyPremium |
      | VPP -E2E Scenario 2_AARP | AARP |   98012 | NO            | Snohomish County | MAPD     |     2 | future   | Ativan | diclofenac potassium | Lipitor | AARP Medicare Advantage Plan 3 (HMO) | Step Therapy Criteria | Step_Therapy_MCOREE_2021 | current  | $45            | $540          | Dental Platinum | $40            |

    @vppPlanCompareCommon_UHC01New @prodRegression_UAT @regressionUHC
    Examples: 
      | Scenario                | site | zipcode | isMultiCounty | county           | plantype | count | planyear | drug1  | drug2                | drug3   | planname                             | pdfType               | docCode                  | planyear | MonthlyPremium | yearlyPremium | optionalRider   | monthlyPremium |
      | VPP -E2E Scenario 2_UHC | UHC  |   98012 | NO            | Snohomish County | MAPD     |     2 | future   | Ativan | diclofenac potassium | Lipitor | AARP Medicare Advantage Plan 3 (HMO) | Step Therapy Criteria | Step_Therapy_MCOREE_2021 | current  | $45            | $540          | Dental Platinum | $40            |

  Scenario Outline: <Scenario> To test VPP stand alone widget from Shop pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user hovers screen over the shop for a plan
    And the user checks for Shop link under Shop For a Plan
    And the user clicks on the Shop link and lands on the shop page
    And the user clicks on the Shop button for Medicare Advantage Plan and navigates to MA plans page
    And the user validate ZipCode Components on Shop pages using ZipCode "80001"
    And the user clicks on See more benefits link on shop page
    #And the user closes the new browser tab
    And the user clicks on browser back button
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

    @vppPlanCompareCommon_AARP01New @regressionAARP
    Examples: 
      | Scenario           | site | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | https://www.myuhcagent.com/ |

    @vppPlanCompareCommon_UHC01New @regressionUHC
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
    And the user cancels enrollment and navigates to homepage

    @vppPlanCompareCommon_AARP01New @regressionAARP @test001
    Examples: 
      | Scenario              | site | zipcode | zipcode2 | isMultutiCounty | county            | county2     | plantype | plantype1 | drug1   | drug2     | drug3    | planyear | planname                        | planname1                            | firstname | lastname | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | emailConfirmation | goGreen | phoneno    | mobileno   | middlename  |
      | VPP-E2E Scenario5_AMP | AARP |   33111 |    90210 | No              | Miami-Dade County | Los Angeles | PDP      | MAPD      | Lipitor | Ibuprofen | Nicomide | next     | AARP MedicareRx Walgreens (PDP) | AARP Medicare Advantage Choice (PPO) | GOTTFRIED | GARRAND  | 04261944 | Male   | 003 Morris Rd | Miami    | No                     | 123 Test      | Miami       | FL           |      33111 | test@test.com | yes               | yes     | 1234567890 | 2345678901 | Test_Middle |

    @vppPlanCompareCommon_UHC01New @regressionUHC
    Examples: 
      | Scenario              | site | zipcode | zipcode2 | isMultutiCounty | county            | county2     | plantype | plantype1 | drug1   | drug2     | drug3    | planyear | planname                        | planname1                            | firstname | lastname | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | emailConfirmation | goGreen | phoneno    | mobileno   | middlename  |
      | VPP-E2E Scenario5_UMS | UHC  |   33111 |    90210 | No              | Miami-Dade County | Los Angeles | PDP      | MAPD      | Lipitor | Ibuprofen | Nicomide | next     | AARP MedicareRx Walgreens (PDP) | AARP Medicare Advantage Choice (PPO) | GOTTFRIED | GARRAND  | 04261944 | Male   | 003 Morris Rd | Miami    | No                     | 123 Test      | Miami       | FL           |      33111 | test@test.com | yes               | yes     | 1234567890 | 2345678901 | Test_Middle |

       Scenario Outline: <site>  - Validate that M&R Prospective client, user wants to use VPP to view details and enroll for a plan from Connector Model plus landing page into  Medicare Education.
    Given the user is on external acquisition site landing page
      | Site Name | <site> |
    Then user clicks on Learn About Medicare
    Then Validate user Land on MEDED Page and validate links
    Then Navigate back to previous window
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then I validate "<plantype>" plans with names "<planNamesList>" are listed correctly on summary page
    Then user changes zipcode within VPP page
      | Zip Code        | <zipcode2>      |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county2>       |
    Then I validate "<plantype>" plans with names "<planNamesList2>" are listed correctly on summary page
    And I validate view more and view less links on plan summary
    Then I save "<plantype>" plans and "<SavePlansCount>" plans and verify the count update on shopping cart
    Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section

    @vppPlanCompareCommon_UHC01New @regressionUHC
    Examples: 
      | site       | zipcode | isMultiCounty | county     | planNamesList                                                                                                                                                                                                                                                                                                                                                                                                                                              | plantype | planyear | zipcode2 | county2  | planNamesList2                                                                                                                                | SavePlansCount |
      | Myuhcplans |   33111 | NO            | Miami-Dade | Preferred Medicare Assist Plan 2 (HMO D-SNP),Preferred Medicare Assist Plan 1 (HMO D-SNP),Medica HealthCare Plans MedicareMax Plus (HMO D-SNP),UnitedHealthcare Dual Complete Choice (PPO D-SNP),UnitedHealthcare Dual Complete RP - FL (Regional PPO D-SNP),Preferred Special Care Miami-Dade (HMO C-SNP),UnitedHealthcare Nursing Home Plan (PPO I-SNP),UnitedHealthcare Assisted Living Plan (PPO I-SNP),UnitedHealthcare Nursing Home Plan (HMO I-SNP) | SNP      | current  |    37714 | Campbell | UnitedHealthcare Dual Complete (HMO D-SNP),UnitedHealthcare Dual Complete ONE (HMO D-SNP),UnitedHealthcare Dual Complete ONE Plus (HMO D-SNP) |              1 |

      