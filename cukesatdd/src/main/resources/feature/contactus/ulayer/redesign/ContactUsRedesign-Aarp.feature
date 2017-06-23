@contactUsTestredesign
Feature: To test EmailUs Widget and Click to call functionality in contact us redesign pages in AARP site
Scenario Outline: Verify secureEmail Widget page section in contact us redesign page for not opted in aarp member of  AARP site covers scenario 1,2,5,6,7
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure email widget UI in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |
	
Scenario Outline: Verify secureEmail Widget page in contact us redesign page of  AARP site covers scenario 4
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure email widget functionality in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

Scenario Outline: Verify secureEmail Widget page in contact us redesign page of  AARP site covers scenario 3
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure email widget functionality using Email Address on File radio button 

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

#US632918 secureMessaging Model

Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure Messaging Model

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure Messaging Model Cancel link

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

Scenario Outline: Verify secureMessaging Model section upon clicking the send A Message button
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure Messaging Model Prescription link click on SecureEmail Model

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |


	
#US634971
#contactUsTestredesign

Scenario Outline: Verify go To Inbox button on contactUS redesign page for opted in member 
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates go To Inbox button  in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |
	
Scenario Outline: Verify secureEmail widget on contactUS redesign page for not opted in member 
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates secure email widget UI in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

Scenario Outline: Verify secureEmail widget non display on contactUS redesign page for non eligible member 
Given AArp member validation on redesigned site 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates non display secure email widget UI in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

#US633085

Scenario Outline: Verify clickToCallButton Widget and Button display on contactUS redesign page 
Given AArp member validation on redesigned site 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates clickToCallButton display on contactUS redesign page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |
	
#US634553,US634832
Scenario Outline: Verify clickToCall Widget Expansion (Drop-Down, Text Box and Button UI)  on contactUS redesign page 
Given AArp member validation on redesigned site 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates clickToCallButton display on contactUS redesign page
And user clicks on send a Request button on Click to call widget

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |
	
#US634778,US634969
Scenario Outline: Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page 
Given AArp member validation on redesigned site 
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates clickToCallButton display on contactUS redesign page
And user clicks on Request Confirmation Click

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |
#US630418
Scenario Outline: Verify sendUs A Question Widget page section in contact us redesign page 
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates sendUS A question Widget in redesign contact us page

Examples:
	| planType | |  memberType   |
	| MA      | |  Individual   |

Scenario Outline: Verify sendUs A Question Widget page section in contact us redesign page 
Given AArp member validation on redesigned site
	| Plan Type   | <planType>   |
	| Member Type | <memberType> |
When the user validates the contact us redesign  page in AARP site
Then user validates PDP page display in redesign contact us page

Examples:
	| planType | |  memberType   |
	| PDP      | |  Individual   |		
