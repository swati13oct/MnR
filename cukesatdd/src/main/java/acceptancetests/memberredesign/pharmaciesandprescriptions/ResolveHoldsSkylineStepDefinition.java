package acceptancetests.memberredesign.pharmaciesandprescriptions;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResolveHoldsSkylineStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}



	@And("^user sees an triangle alert icon and text indicating his order is on hold$")
	public void user_sees_an_triangle_alert_icon_and_text_indicating_his_order_is_on_hold() throws Throwable {

     //Write code here

	}


	@When("^user sees messaging about his hold$")
	public void user_sees_messaging_about_his_hold() throws Throwable {

		//Write code here

	}


	@When("^user selects the Contact Us link$")
	public void user_selects_the_Contact_Us_link() throws Throwable {

		//Write code here

	}

	@When("^user will see the contact us page open in a new tab$")
	public void user_will_see_the_contact_us_page_open_in_a_new_tab() throws Throwable {

		//Write code here

	}





}
