@orderPlanMaterials @thePredators
Feature: 1.10.1 Member  order materials Page - PROD

  @prod_orderPlanMaterials01
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify order plan material functionality for different type of users
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When user navigates to order plan materials page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user validates header section of page content on order materials page
    And user validates selection section of page content on order materials page
    And user validates printable documentations section of page content on order materials page
    #note: moved to footer feature
    # And user validates need help section of page content on order materials page
    # And user validates error message when submit without any selection
    ###note: don't order on prod env
    #Then user validates ability to submit order for each item individually for all available items

    #-------------------
     @prod_orderPlanMaterials1a
    Examples:
      | TID   | username | password | MemUserName         | planType | memberType            |
      | 15288 | ashah120 | Mnrqa003 | skho@roadrunner.com | MAPD     | UHC_Individual_order  |
      | 15288 | ashah120 | Mnrqa003 | TEAKSAMPPALA1       | MAPD     | AARP_Individual_order |

      @prod_orderPlanMaterials1a @ma
    Examples:
      | TID   | username | password | MemUserName  | planType | memberType            |
      | 15287 | ashah120 | Mnrqa003 | TOMIKOARMER2 | MA       | AARP_Individual_order |

      @prod_orderPlanMaterials1b @pdp
    Examples:
      | TID   | username | password | MemUserName | planType | memberType            |
      | 15292 | ashah120 | Mnrqa003 | LSLOMSKI777 | PDP      | AARP_Individual_order |

    #-------------------
       @prod_orderPlanMaterials1b
    Examples:
      | TID   | username | password | MemUserName           | planType | memberType       |
      | 15286 | ashah120 | Mnrqa003 | marylamb823           | PCP      | Individual_order |
      | 15285 | ashah120 | Mnrqa003 | SUSICHAPMAN@GMAIL.COM | MEDICA   | Individual_order |

     @prod_orderPlanMaterials1c @ship
    Examples:
      | TID   | username | password | MemUserName        | planType | memberType    |
      | 15293 | ashah120 | Mnrqa003 | rldf1942 | SHIP     | MEDSUPP_order |

    #-------------------
       @prod_orderPlanMaterials1c
    Examples:
      | TID   | username | password | MemUserName       | planType | memberType      |
      | 15289 | ashah120 | Mnrqa003 | WILLIAMGARRISON48 | MAPD     | UHC_Group_order |

     @prod_orderPlanMaterials1d
    Examples:
      | TID   | username | password | MemUserName  | planType | memberType      |
      | 15289 | ashah120 | Mnrqa003 | TOMIKOARMER2 | MA       | UHC_Group_order |
      | 15290 | ashah120 | Mnrqa003 | Norm749   | PDP      | UHC_Group_order |

    #-------------------
      @prod_orderPlanMaterials1d
    Examples:
      | TID   | username | password | MemUserName        | planType | memberType  |
      #| 15281 | ashah120 | Mnrqa003 | aliceb1105@aol.com | MAPD     | COMBO_order |
      | 15281 | ashah120 | Mnrqa003 | Norm749            | MEDSUPP  | COMBO_order |

    # note: keep SSUP case but skip the run for now, it requires specific data setup that doesn't always exist
      @prod_orderPlanMaterials1e
    Examples:
      | TID   | username | password | MemUserName | planType | memberType  |
      | 15291 | ashah120 | Mnrqa003 | Norm749     | PDP      | COMBO_order |
    # | 15291 | qavgogine | qavgogine | testusername    | SSUP     | COMBO_order	         |


  #####################################################
  # note: For terminated user, the Order Materials link on dashboard body and top menu will not be visible
  # note: This test is applicable to test via rally login only, validation will be skipped if access through testharness
  # note:
  @prod_orderPlanMaterials02
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Terminated members cannot access Order Plan materials Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then user should not see Order Materials Link for terminated member
    Then user validates header navigation is not available for Terminated member

    Examples:
      | TID   | username | password | MemUserName | planType | memberType                  |
      | 15284 | ashah120 | Mnrqa003 | erbenoit56  | MAPD     | AARP_Terminatedmember_order |