@dashBoardFormsAndResources @gladiators
Feature:G1.1 To validate forms and resources page in dashboard site

@formsAndResourcesPageValidation
  Scenario Outline: 
        Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page
    Then validate EOB section
      | EOB_MEDICAL_LINK | <EOBMedicalLinkVisible> |
      | EOB_DRUG_LINK    | <EOBDrugLinkVisible>    |
    And validate my document section
      | MY_DOCUMENT_SECTION | <MyDocumentVisible> |
    And validate renew magazine section
      | RENEW_MAGAZINE_SECTION | <RenewMagazineVisible> |

    #Blue Layer Members
    Examples: 
      | userId           | password   | EOBMedicalLinkVisible | EOBDrugLinkVisible | MyDocumentVisible | RenewMagazineVisible |
        # uhc
      | q1_feb_uhc005 | Password@1 |  YES   | YES       | YES     | YES       |         
   # aarp
      | q1_feb_aarp001 | Password@1 |   YES  | YES       | YES     | YES        |               
   