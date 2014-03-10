package verif;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.simple.parser.*;
import org.json.simple.*;
 
public class ReturnAddress implements Serializable {
 
  private boolean passed;
  private String deliveryLine1;
  private String lastLine;

  public boolean getPassed() {
    return this.passed;
  }

  public String getDeliveryLine1() {
    return this.deliveryLine1;
  }

  public String getLastLine() {
    return this.lastLine;
  }

  public ReturnAddress(){
  	passed = true;
  	deliveryLine1 = "Test Line 1";
	lastLine = "Test Line 2";
  }

  public ReturnAddress(SubmitAddress sAddress){
    String authId = "31eb227b-15f2-4610-96b7-a257e132458e"; 
    String authToken = "iRsfuoamsn7MhveXQ5fGddgh9%2Be6b%2B0L%2FRILaJC7vEab9dYTCyELA7XpKynJkrNu4HEvyxXOfBprps%2F4bgMRLg%3D%3D";

    String url = "https://api.smartystreets.com/street-address/?auth-id=" + authId + "&auth-token=" + authToken;

    String response = "";

    JSONObject addr = new JSONObject();
    addr.put("addressee", sAddress.getAddressee());
	addr.put("street", sAddress.getStreet());
	addr.put("city", sAddress.getCity());
	addr.put("state", sAddress.getState());
	addr.put("zip", sAddress.getZipcode());

	JSONArray list = new JSONArray();
    list.add(addr);

    String req = list.toString();
    int len = req.length();

    try
	{
	  URL u = new URL(url);

	  try
	  {
		// Establish connection, stream our JSON string, and close the connection.
		URLConnection urlConn = u.openConnection();
		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		urlConn.setUseCaches(false);
		urlConn.setRequestProperty("Content-Length", Integer.toString(len));

		DataOutputStream outgoing = new DataOutputStream(urlConn.getOutputStream());
		String content = req;
		outgoing.writeBytes(content);
		outgoing.flush();
		outgoing.close();

		// Save the response (a JSON string)
		DataInputStream incoming = new DataInputStream(urlConn.getInputStream());
		String str;
		while ((str = incoming.readLine()) != null){
		  response += str;
		}
		incoming.close();
	  }
	  catch(IOException e)
	  {
	  	System.out.println("IO Exception Error: " + e.toString());
	  }
	}
	catch (MalformedURLException m)
	{
	  System.out.println("Malformed URL Exception Error: " + m.toString());
	}

	Object obj = JSONValue.parse(response);
	JSONArray json = (JSONArray)obj;

	if (json.size() > 0)
	{ 
	  passed = true;

      JSONObject addr1 = (JSONObject)json.get(0);
	  deliveryLine1 = addr1.get("delivery_line_1").toString();
	  lastLine = addr1.get("last_line").toString();
    }
    else
    {
      passed = false;
    }
  }

}