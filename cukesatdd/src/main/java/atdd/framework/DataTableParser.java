package atdd.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

public final class DataTableParser {

	public static HashMap<String, String> readDataTableAsMaps(DataTable inputTestData) {
		List<Map<String, String>> inputDataTable = inputTestData.transpose().asMaps(String.class, String.class);
		HashMap<String, String> inputData = new HashMap<String, String>();
		for(Map<String, String> map : inputDataTable) {
			inputData.putAll(map);
		}
		return inputData;
	}
	
	public static HashMap<String, String> readDataTableAsList(DataTable inputTestData) {
		List<List<String>> inputDataTable = inputTestData.asLists();
		HashMap<String, String> inputData = new HashMap<String, String>();
		
		for(int row = 0; row < inputDataTable.size(); row ++) {
			inputData.put(inputDataTable.get(row).get(0), inputDataTable.get(row).get(1));
		}
		return inputData;
	}
	
	/**
	 * With the latest cucumber dependencies we no longer can pass empty value from feature file,
	 * If passed they are considered as null.
	 * 
	 * The below method is converting [blank] received from feature file to a empty string.
	 * 
	 * Convert [blank] to empty.
	 *
	 * @param cell the cell
	 * @return the string
	 */
	@DataTableType(replaceWithEmptyString = "[blank]")
	public String convertToEmpty(String cell) {
		return cell;
	}
}
