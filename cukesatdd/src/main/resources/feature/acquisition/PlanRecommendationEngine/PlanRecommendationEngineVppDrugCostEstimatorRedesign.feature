@PlanRecommendationEngineVPPDCE @PRERegression
Feature: PRE_VPP_DCERedesign - Verify end-to-end PRE flows functionalities with VPP validation and DCE Redesign

	@PRE_VPP_DCE_E2E
	Scenario Outline: <Zipcode>, <isMultiCounty> , <county> , <isCoverageOpt> , <specialNeeds>, <travel>, <doctors>, <DoctorsName>, <Drug Selection> , <Dental-Hearing-Vision-Fitness>, <costPreferenceOption> - To validate SNP API ranking plans in PRE
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

    Examples: 
      |	site	| Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors         | DoctorsName      | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption |
      |	AARP	|   33143 | No            | Miami-Dade | MAPD          | None         | None   | Lookup          | John             |               | No             | Yes,No,No,No                  | Higher               |
      |	AARP	|   55419 | No            | Hennepin   | MAPD          | None         | None   | AcceptsMedicare |                  |               | No             | Yes,No,No,No                  | Higher               |
