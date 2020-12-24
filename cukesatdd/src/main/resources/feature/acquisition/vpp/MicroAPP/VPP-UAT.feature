@UATRegression
Feature: 1.01.4 UAT Feature to test VPP scenarios


	Scenario Outline: <Scenario> To test VPP stand alone widget from Shop pages 
	Given the user is on medicare acquisition site landing page
      | Site | <site> | 
  When the user hovers screen over the shop for a plan
  And the user clicks on the Shop link and lands on the shop page
  And the user clicks on the Shop button for Medicare Advantage Plan and navigates to MA plans page
  And the user validate ZipCode Components on the page using ZipCode "80001"
  And the user clicks on browser back button
  And the user clicks on the Shop button for Prescription Drugs Plan and navigates to PDP plans page
  And the user validate ZipCode Components on the page using ZipCode "10001"
  And the user clicks on browser back button 
  And the user clicks on the Shop button for Medicare DSNP Plan and navigates to DSNP plans page
  And the user validate ZipCode Components on the page using ZipCode "90210"
  And the user clicks on browser back button
  
  @vppPlanSummaryCommonAARP01
  Examples:
  |Scenario|site|
  |E2E Scenario 3_AMP|AARP|
  
  @vppPlanSummaryCommonUHC01
  Examples:
  |Scenario|site|
  |E2E Scenario 3_UMS|UHC|

  