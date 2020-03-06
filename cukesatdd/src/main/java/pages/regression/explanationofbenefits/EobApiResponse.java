package pages.regression.explanationofbenefits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class EobApiResponse {

	protected boolean success;
	protected String errorCode;

	protected List<Eob> listOfEob;
	
	public EobApiResponse() {
		success=false;
		errorCode="";
		listOfEob=new ArrayList<Eob>();
	}

	public EobApiResponse(EobApiResponse input) {
		success=input.isSuccess();
		errorCode=input.getErrorCode();
		listOfEob=input.getListOfEob();
	}

	public int getNumEobs() {
		return listOfEob.size();
	}
	
	public void addEob(Eob inputEob) {
		listOfEob.add(inputEob);
	}
	
	public void addEob(String eobDate, String esp) {
		Eob e=new Eob(eobDate, esp);
		listOfEob.add(e);
	}
	
	public void addEob(String eobDate, String esp, String eobType) {
		Eob e=new Eob(eobDate, esp, eobType);
		listOfEob.add(e);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<Eob> getListOfEob() {
		return listOfEob;
	}

	public void setListOfEob(List<Eob> listOfEob) {
		this.listOfEob = listOfEob;
	}
	
	public void printApiResponse() {
		System.out.println("EOB API response:");
		System.out.println("  success="+success);
		System.out.println("  errorCode="+errorCode);
		System.out.println("  There are total of '"+getNumEobs()+"' EOB in the response");
		for (int i=0; i<getNumEobs(); i++) {
			System.out.print("    EOB # '"+(i+1)+"' detail");
			System.out.print(":  eobDate="+listOfEob.get(i).getEobDate());
			System.out.print("|  esp="+listOfEob.get(i).getEsp());
			if (!listOfEob.get(i).getEobType().equals(""))
				System.out.print("|  esp="+listOfEob.get(i).getEobType());
			System.out.println("\n");
			
		}
	}

	

}
