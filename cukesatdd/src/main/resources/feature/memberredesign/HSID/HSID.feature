@hsid 
Feature: To test HSID member SignIn

   @hsid6 @Login @US968315 @regressionMember
   Scenario Outline:Verify HSID login functionality for <planType> <memberType> member sign in
   Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
   Then I validate that login is successfull     
      
   Examples:
   | planType|  memberType  | copayCategory | 
   | MAPD    |  Individual  |  NON LIS      |
   | PCP     |  Individual  |  NON LIS      |
   | Medica  |  Individual  |  NON LIS      |  
   | MAGroup |  Group       |  NON LIS      |
   | MAPDGroup | Group      |  NON LIS      | 
   | MA      |  Individual  |  NON LIS      |
   | PDP     |  Individual  |  NON LIS      |   
   | PDPGroup|  Group       |  NON LIS      |   
   | SHIP    |  ShipOnly    |  NON LIS      | 
   | COMBO   | FedShip      |  NON LIS      |
   | SSUPGroup |Group         |  NON LIS      |
   | MAPre-effective| Individual  |  NON LIS      |
   | GovtTermless | Individual  |  NON LIS      |
   | PDP			| PREFFECTIVE| NON-LIS	|
   | SSUP			| Terminated| 	NON-LIS|
   | MA-Medsup		| FEDSHIPPREEFFECTIVE| 	NON-LIS|
   
	 
  @hsid4 @codetransformers
  Scenario Outline: To verify that iperception smiley survey is displayed on medicare.uhc.com signin pages
    Given User is on the sign-in page of medicare.uhc.com of the environment mentioned in config file
      | URL | <appendinURL> |
    Then Iperception smiley survey is displayed after waiting for 20 seconds
    And User is able to successfully submit the survey

    Examples: 
      | appendinURL |
      |             |
      | aarp        |
      | retiree     |

  @hsid5 @codetransformers
  Scenario Outline: To verify that iperception smiley survey is displayed on mymedicareaccount.uhc.com signin pages
    Given User is on the sign-in page of mymedicareaccount.uhc.com of the environment mentioned in config file
      | URL | <appendinURL> |
    Then Iperception smiley survey is displayed after waiting for 20 seconds
    And User is able to successfully submit the survey

    Examples: 
      | appendinURL |
      | pcp         |
      | medica      |
      
      
      