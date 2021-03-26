@PlanRecommendationEngineVPPDCE
Feature: PRE_VPP_DCERedesign - Verify end-to-end PRE flows functionalities with VPP validation and DCE Redesign

  @PRE_VPP_DCE_E2E
  Scenario Outline: <Zipcode> - To validate e2e flow in PRE-VPP-DCE
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Plan Type      | <isCoverageOpt>  |
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page
    #And the user views the plans of the below plan type and select Next year
    # | Plan Type | <plantype> |
    #And the user views the plans of the below plan type
    #| Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user validates link to Drug Summary Page

    @PRE_VPP_DCE_E2E_AARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | drug1   | planname                                             | planyear |	priorityOption	|	priorities			|
      | AARP |   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup  | John        |               | No             | Yes,No,No,No                  | Higher               | MAPD     | Orkambi | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | future   |	None           	| Travel, Vision	|

    #|	AARP	|   55419 | No            | Hennepin   | MAPD          | None         | None   | AcceptsMedicare |                  |               | No             | Yes,No,No,No                  | Higher               |
    @PRE_VPP_DCE_E2E_UHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | drug1   | planname                                             | planyear |	priorityOption	|	priorities		|
      | UHC  |   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup  | John        |               | No             | Yes,No,No,No                  | Higher               | MAPD     | Orkambi | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | future   |	None           	| Travel, Vision	|

  @PRE_VppPlanSummaryCard_DCE
  Scenario Outline: <plantype> - <Zipcode> - <isMultiCounty> - <county> - <isCoverageOpt> - <specialNeeds> - <travel> - <doctors> - <DoctorsName> - <isMultiDoctor> - <Drug Selection> - <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> - <pharmacyoption> - <Dental-Hearing-Vision-Fitness> - <costPreferenceOption> - <priorityOption> - <priorities> - To validate integration of DCE with PRE in Vpp Plan Summary
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    Then user selects add drug option in Drug page
      | Drug Selection | <Drug Selection>                                                       |
      | Drug Details   | <DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    And user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    Then user validate UI and API recommendation rankings in results page
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates the added drug name on plan summary page for a selected plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
      | DrugName  | <drugname> |
    And the user clicks on drug dropdown on plan summary page and navigates to DCE
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And the user Captures Drug costs on Drug Details Page
    And the user clicks on Edit your drug list link on drug details page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    Then user saves plan as favorite on drug details page
      | Test Plans | <planname> |
    #Then the user clicks on the heart icon on Drug Details page
    Then the user navigates to Visitor profile page
    And user validates the added plans on visitor profile page
      | Test Plans | <planname> |
      #And user validates the plans on new visitor profile page of AARP site
      #| Test Plans | <planname> |
    Then the user should be able to see all the added Drugs information in the guest profile page
      | Drugs Added | <drugsadded> |

    @PRE_VppPlanSummaryCard_DCE_AARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                              		| Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | planname                                             | planyear	| drugname                 | drug1   | drugsadded                       | planyear |	priorityOption	|	priorities			|
      | AARP |   33143 | No            | Miami-Dade | MAPD          | None         | None   | UHGNetwork |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | Yes,No,No,No                  | Higher               | MAPD     | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | future  	| Lipitor:morphine sulfate | Orkambi | Lipitor:morphine sulfate:Orkambi | future   |	both						|	Travel, Vision	|

    @PRE_VppPlanSummaryCard_DCE_UHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors    | DoctorsName | isMultiDoctor | Drug Selection | DrugName-AutoSearch-Dosage-Package-Qty-Frequency-SLength-IsNotgeneric-Switch                              		| Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | planname                                             | planyear | drugname                 | drug1   | drugsadded                       | planyear |	priorityOption	|	priorities			|
      | UHC  |   33143 | No            | Miami-Dade | MAPD          | None         | None   | UHGNetwork |             |               | Yes            | Lipitor,NO,Lipitor TAB 20MG,,,Month,1,YES,NO:morphine sulfate,NO,morphine sulfate CAP 10MG ER,,,Month,1,NO,NO | Yes,No,No,No                  | Higher               | MAPD     | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | future  | Lipitor:morphine sulfate | Orkambi | Lipitor:morphine sulfate:Orkambi | future   |	both						|	Travel, Vision	|
