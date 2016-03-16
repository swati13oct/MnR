@headerFooterTestFeature:To test Brand section of AARP site header

Scenario:To verify links displayed in the global footer of AARP site
Given user is on acquisition home page of AARP Site
When user accesses global footer of the AARP Medicare Plans home page
And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
And user clicks on contactus link of aboutus page
And user clicks on sitemap link of contactus page
And user clicks on privacypolicy link of sitemap page
And user clicks on terms&conditions link of privacypolicy page
And user clicks on disclaimers link of terms&conditions page
And user clicks on agents&brokers link of disclaimers page
And user clicks on home link of agents&brokers page
And user clicks on medicare advantage plan link from footer of the AARP Medicare Plans home page
And user clicks on medicare supplement insurance plans link from footer of the AARP Medicare Plans home page
And user clicks on medicare prescription drug plans from footer of the AARP Medicare Plans home page
And user clicks on learn about medicare link from footer of the AARP Medicare Plans home page
And user clicks on prepare for initial enrollment link from footer of the AARP Medicare Plans home page
And user clicks on explore changing plans link from footer of the AARP Medicare Plans home page
And user clicks on discover more resources link from footer of the AARP Medicare Plans home page
And user clicks on Home link from footer of the discover more resources page
And user clicks on view disclaimer information section links from footer of the AARP Medicare Plans home page
Then the user validates all links in the global footer of AARP site

Scenario:To verify links displayed in the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When user accesses brand section of the AARP Medicare Plans home page
Then user validates all the links in brand section
And user clicks on Important Disclosures link of AARP Medicare Plans home page
And user clicks on AARP logo on Disclaimer page
And user clicks on our plans link in navigation section on AARP Medicareplns Site page
And user clicks text  in global search field in navigation section on AARP Medicareplans Site page
And user clicks on visit AARP org link of Home page

Scenario:To verify links displayed in Our Plans drop down of AARP site
Given user is on acquisition home page of AARP Site
When user hovers on Our Plans section of the AARP Medicare Plans home page
Then user validates all the content and links in the Our Plans dropdown
And user clicks on medicare advantage plans link of our plans drop down from home page of U layer
And user clicks on medicare advantage Request Personal Help & Information link of our plans drop down from medicare advantage plans page of U layer
And user clicks on Medicare Prescription Drug Plans link of our plans dropdown from medicare advantage Request More Information page of U layer
And user clicks on Prescription Drug Request Personal Help & Information link of our plans drop down from Medicare Prescription Drug Plans page U layer
And user clicks on Medicare Supplement Plans link of our plans drop down from Prescription Drug Request more information page Ulayer
And user clicks on Medicare Select Hospital Directory link under Medicare Supplement Plans section of our plans drop down from Medicare Supplement Plans page in AARP site
And user clicks on Resume Your Saved Application link under Medicare Supplement Plans section of our plans drop down from Medicare Select Hospital Directory page in AARP site
And user clicks on Take the quiz button from our plans drop down of U layer

Scenario:To verify menu under drop down of Our Plans link  in AARP site
Given user is on acquisition home page of AARP Site
When I hover over the Our Plans button
Then drop down column 1 should appear with the following in order - Find all plans in your area header, Enter ZIP field, Find Plans button, Need Help content, Need Help Link, Find right plan header, take quiz button
Then user validates all the content and links in the Our Plans drop down on home page of AARP site
And content appears in column 1 per copy deck
When I click find ZIP link
When I DON'T enter a ZIP and I click Find Plans button
Then error message should be appeard
When I click on either user name and/or password fields and enters a character then text in the boxes should disappear
When I DON'T enter 5 numbers in the ZIP and I click Find Plans button
Then error message should appear
When I enter 5 numbers and I click Find Plans button
Then I am navigated to view plans link

Scenario:To verify links displayed in Our Plans Drop Down in AARP site
Given user is on acquisition home page of AARP Site
When user accesses Medicare Education section AARP Medicareplans Site
And user clicks on LearnAboutMedicare link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on ExploreChangingPlans link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on DiscoverMoreResources link by hovering on Medicare Education of the AARP Medicare Plans home page
Then the user validates all links in the medicare education drop down of AARP site

Scenario:To verify Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of AARP site
And user clicks on Already a member button in its inactive state on the Brand section of AARP site
And user clicks on user name, password text field in the Already a plan member drop down of AARP site
And user clicks on forgot your username or password link of AARP site
And user switches back to acquisition home page of AARP Site
And user clicks on register here link of AARP site
Then user validates all the elements in the Already a plan member drop down of AARP site


Scenario:To verify error message of sign in button under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters invalid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on sign in button and validate the error message in Already a plan member drop down of AARP site


Scenario:To verify sign in button functionality under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on sign in button and validates if it is landed on member my account home page of AARP site

Scenario:To verify timer/visitor cookie scenarios under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
And user reloads the AARP site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of AARP site
Then user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in AARP site

Scenario:To verify timer/visitor cookie scenarios under Already a plan member dropdown displayed on the Brand section of AARP site
Given user is on acquisition home page of AARP Site
When the user clicks on Already a member button on the Brand section of AARP site
And user enters valid user name, password text field in the Already a plan member drop down of AARP site
Then user clicks on the page and validates if the timer has stopped in browser of AARP site
