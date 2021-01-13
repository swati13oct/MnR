@UATRegression
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
      |UHC Agent URL|  <UHCUrl>  |
  And the user closes the new browser tab
  And the user clicks on browser back button
  And the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page
  And the user validate ZipCode Components on Shop pages using ZipCode "10001"
  And the user clicks on DCE link to land on DCE Redesign from PDP Shop page
  And the user clicks on browser back button
  And the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  | 
  And the user closes the new browser tab
  And the user clicks on browser back button
  And the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page
  And the user validate ZipCode Components on Shop pages using ZipCode "90210"
  And the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
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
      |UHC Agent URL|  <UHCUrl>  |
  And the user closes the new browser tab
  And the user hovers screen over the shop for a plan
  And the user clicks on Submit button using email address ""
  And the user clicks on Submit button using email address "namita_meher@optum.com"
  
  @vppPlanSummaryCommonAARP01
  Examples:
  |Scenario						|	site	|	UHCUrl											|
  |E2E Scenario 3_AMP	|	AARP	|	https://www.myuhcagent.com/	|
  
  @vppPlanSummaryCommonUHC01
  Examples:
  |Scenario						|	site	|	UHCUrl											|
  |E2E Scenario 3_UMS	|	UHC		|	https://www.myuhcagent.com/	|

  