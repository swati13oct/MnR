@dashBoardFormsAndResources
Feature: To validate forms and resources page in dashboard site
#Scenarios written for blue layer - Later will be modified to dashboard once dashboard site is set up
  Scenario Outline: 
    Given registered member lands on forms and resources on member redesign Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID  | <userId>   |
      | PASSWORD | <password> |
    And member click signin button and logs in
    And open blue layer test harnesss page in a new tab
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
      | q3_sep_blayer006 | Password@1 | YES                   | YES                | YES               | YES                  |
      | q3_sep_blayer142 | Password@1 | NO                    | YES                | YES               | YES                  |
      | q3_sep_blayer144 | Password@1 | YES                   | NO                 | YES               | YES                  |
      | q3_sep_grp076    | Password@1 | YES                   | YES                | YES               | YES                  |
      | q3_sep_grp006    | Password@1 | NO                    | YES                | YES               | YES                  |
      | q3_sep_grp162    | Password@1 | YES                   | NO                 | YES               | YES                  |
      | q3_sep_grp157    | Password@1 | NO                    | NO                 | YES               | YES                  |
      | q3_sep_grp425    | Password@1 | NO                    | YES                | YES               | YES                  |
