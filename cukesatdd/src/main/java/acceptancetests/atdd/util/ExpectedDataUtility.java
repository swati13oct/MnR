/**
 * 
 */
package acceptancetests.atdd.util;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;

/**
 * @author pjaising
 *
 */
public class ExpectedDataUtility {
	
	private static final String DIRECTORY = "/src/main/resources/";
	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static File getExpectedResponse(String fileName, String directory) throws IOException{
		String lookUpDirectory = null;
		String parentDirectory = new java.io.File( "." ).getCanonicalPath();
		
		if (directory!=null){
		
			lookUpDirectory = parentDirectory+DIRECTORY+File.separator+directory;
		
		}
		
		System.out.println("lookUpDirectory--->"+lookUpDirectory);
		File FileToBeread= findFile(fileName,new File(lookUpDirectory));
		
		return FileToBeread;
	}
	
	
	public static File findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                System.out.println(name+ " found in " + fil.getParentFile());
                System.out.println("path--->"+ fil.getPath());
                return fil;
            }
         
           
        }
        return null;
    }

	public static JSONObject getExpectedJson(String fileName, String directory)
	{
		File file = null;
		directory = "jsonresponse/"+directory;
		try {
			file = getExpectedResponse(fileName, directory);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jsonObject = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonObject = mapper.readValue(new File(file.getPath()),
					JSONObject.class);
		} catch (JsonParseException e) {
			System.out.println("Error parsing the json  "
					+ directory + fileName + "  Exception: "
					+ e);
		} catch (JsonMappingException e) {
			System.out.println("Error mapping the json  "
					+ directory + fileName + "  Exception: "
					+ e);
		} catch (IOException e) {
			System.out.println("Exception occurred for  "
					+ directory + fileName + "  Exception: "
					+ e);
		}
		return jsonObject;
	}
}
