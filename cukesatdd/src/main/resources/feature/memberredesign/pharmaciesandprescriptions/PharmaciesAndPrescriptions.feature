Feature: To test Pharamcies And Prescriptions on Member site

  @abc
  Scenario Outline: FID: <TID> -plan: <planType> -memberType: <memberType> -To verify the behavior of the pharmacies and prescriptions page
    Given login with following details logins in the member portal and validate elements
	  | Plan Type   |	<planType>   |
	  | Member Type |	<memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    Examples: 
	  | FID   | planType | memberType          |
	  | xxxxx | MAPD     | AARP_Individual_PnP |
#	  | xxxxx | MAPD     | UHC_Individual_PnP  |
#	  | xxxxx | PDP      | Individual_PnP	   |

