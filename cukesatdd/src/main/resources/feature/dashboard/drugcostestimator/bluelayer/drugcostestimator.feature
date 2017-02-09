@drugcostestimator
Feature:Drug Cost Estimator (DCE)  (Secondary/Tertiary Page) - HTML/CSS - Drug List - Edit/Delete Functionality
Scenario Outline: To be able to select a pharmacy after building a drug list within the newly designed Drug Cost Estimator tool through either a desktop or mobile device so I can accurately estimate the cost of my drugs.
GIVEN I am a registered member using the M&R portal on either a desktop
	| Member Type	  | <memberType> |
WHEN i access the drugcostestimator tool 
AND I access the Pharmacy search tab as a clickable element within the DCE tool
AND I should be able to change the radius
	| radius | <radius> |
AND I should be able to change the zipcode
	| zipcode | <zipcode> |
AND I should be able to slect different pharmacy types
AND I should be able to move forward or backward in the tool flow 
THEN i should be able to validate the radius zipcode and pharmacy type
Examples:	
	| Member Type	  |radius   |  zipcode|
	| MAPD | 10 | 90210 |
