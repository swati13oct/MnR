@fixedTestCaseTest

Feature:1.15-VBF-Acq-To test Provider Search Flow  in UMS site

@ProviderSearchBlayerSmoke
 Scenario Outline: Verify Provider Search  in UMS site
   Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
      | Is Multi County|  <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      |PlanName| <planname>|
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums 
      |PlanName| <planname>|
      
	 Examples:
	| zipcode |isMultutiCounty | county             | plantype |   planname|                
	| 90210   | NO             | Los Angeles County | MA 		|AARP MedicareComplete SecureHorizons Plan 2 (HMO)|
