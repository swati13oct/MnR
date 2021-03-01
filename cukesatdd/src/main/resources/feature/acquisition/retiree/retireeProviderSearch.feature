@retiree
Feature: 3.01. ACQ-RETIREE Provider search flow UMS
  

  @retireeProviderSearch @retireeProviderSearch_Smoke
  Scenario Outline: This Scenario is to verify the Provider search on Retiree site from landing page
  Given The user is on Retiree Home page 
  When the user clicks on Provider Search on the Retiree Home Page
 	Then the user enters the zipcode and select a plan on the Rally tool on Retiree site
 	| Zip Code    | <zipcode> |
 	|Plan Name     | <planname>|
	When user selects a provider and save it on Retiree site
	
	Examples:
	| zipcode | planname |               
	| 90002  | UnitedHealthcare Group Medicare Advantage (HMO)|
	