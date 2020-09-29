@PlanRecommendationEngineVPPDCE @PRERegression
Feature: PRE_VPP_DCERedesign - Verify end-to-end PRE flows functionalities with VPP validation and DCE Redesign

	@PRE_VPP_DCE_E2E
	Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption>, <plantype>, <planname>, <drug1> - To validate SNP API ranking plans in PRE
    Given the user is on medicare acquisition site landing page for PRE
    	|Site| <site>|
    When user navigate to Plan Recommendation Engine and Check Breadcrumbs
    And clicks on get started button and runs a questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects a plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options on Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options on Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors on doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option on Drug page
    	| Plan Type | <isCoverageOpt> |
      | Drug Selection | <Drug Selection> |
    And user selects additional services option on additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option on cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user validate elements on loading results page
    Then user validate UI and API recommendation rankings on results page
    #And the user views the plans of the below plan type and select Next year
     # | Plan Type | <plantype> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug DetailsP Page
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
      |	site	| Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors         | DoctorsName      | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |	plantype | drug1   | planname                                           	|
      |	AARP	|   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup          | John             |               | No             | Yes,No,No,No                  | Higher               |	MAPD     | Orkambi | AARP Medicare Advantage Choice Plan 2 (Regional PPO) |
      #|	AARP	|   55419 | No            | Hennepin   | MAPD          | None         | None   | AcceptsMedicare |                  |               | No             | Yes,No,No,No                  | Higher               |

    @PRE_VPP_DCE_E2E_UHC
    Examples: 
      |	site	| Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors         | DoctorsName      | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |	plantype | drug1   | planname                                           	|
      |	UHC	|   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup          | John             |               | No             | Yes,No,No,No                  | Higher               |	MAPD     | Orkambi | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | 