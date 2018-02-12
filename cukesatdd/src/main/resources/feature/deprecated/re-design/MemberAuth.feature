@memberAuth
Feature: To Member Auth - CONTACT US – FEDERAL

  Scenario Outline: Verify send us question when accessing through member auth tool and validate message
    Given I am a user of the member auth tool
      | UserName | <userName> |
      | Password | <password> |
    When I search for a member
      | Member | <member> |
    Then click on the member displayed in the search list
    And I will see the disclaimer text at top of the page
      | Disclaimer | <disclaimer> |
    And all SUBMIT buttons display message when clicked on contact us page
      | Message | <message> |

    Examples: 
      | userName  |  | password  | member        | disclaimer                                                                                                       | message                                                         |
      | qavgogine |  | qavgogine | q4_dec_grp140 | You are viewing this site with member authorized read only access. Remember to LOGOUT at the end of the session. | You are not authorized to submit a question on behalf of member |

   #Scenario Outline: Verify request call when accessing through member auth tool and validate message
    #Given I am a user of the member auth tool
      #| UserName | <userName> |
      #| Password | <password> |
    #When I search for a member
      #| Member | <member> |
    #Then click on the member displayed in the search list
    #And I will see the disclaimer text at top of the page
      #| Disclaimer | <disclaimer> |
    #And request a call access should not be done and display message when clicked
      #| Message | <message> |
#
    #Examples: 
      #| userName  |  | password  | member        | disclaimer                                                                                                       | message                                                         |
      #| qavgogine |  | qavgogine | q4_dec_grp140 | You are viewing this site with member authorized read only access. Remember to LOGOUT at the end of the session. | You are not authorized to submit a question on behalf of member |
      