package pages.regression.explanationofbenefits;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EobApiResponse {

	protected boolean success;
	protected String errorCode;

	protected List<Eob> listOfEob;

	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

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
	
	public void addEob(String eobDateStr, String esp, String compoundDoc) {
		try {
			Date eobDate= sdf.parse(eobDateStr);
			Eob e=new Eob(eobDate, esp, compoundDoc);
			listOfEob.add(e);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
	}

	public void addEob(Date eobDate, String esp, String compoundDoc) {
			Eob e=new Eob(eobDate, esp, compoundDoc);
			listOfEob.add(e);
	}
	
	public void addEob(String eobDateStr, String esp, String eobType, String compoundDoc) {
		try {
			Date eobDate=sdf.parse(eobDateStr);
			Eob e=new Eob(eobDate, esp, eobType, compoundDoc);
			listOfEob.add(e);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
	}
	
	public void addEob(Date eobDate, String esp, String eobType, String compoundDoc) {
		Eob e=new Eob(eobDate, esp, eobType, compoundDoc);
		listOfEob.add(e);
	}
	
	public void addListofEob(List<Eob> eobList) {
		listOfEob.addAll(eobList);
	}
	
	public void sortListOfEobLatestFirst() {
		System.out.println("TEST - before sort: ");
		printApiResponse();
		Collections.sort(listOfEob);
		System.out.println("TEST - after sort: ");
		printApiResponse();
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
			String eobDateStr= sdf.format(listOfEob.get(i).getEobDate());
			System.out.print("    EOB # '"+(i+1)+"' detail");
			System.out.print(":  eobDate="+eobDateStr);
			System.out.print(" |  compoundDoc="+listOfEob.get(i).getCompoundDoc());
			if (!listOfEob.get(i).getEobType().equals(""))
				System.out.print(" |  eobType="+listOfEob.get(i).getEobType());
			System.out.print(" |  esp="+listOfEob.get(i).getEsp());
			System.out.println("\n");
		}
	}
}
