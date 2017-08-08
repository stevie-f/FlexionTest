/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexiontest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author SRI
 */
public class SimpleRest {
    public String doRequestResponse(String aurl, String arequestmethod, Boolean acodeonly) {
         try {

		URL url = new URL(aurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(arequestmethod);
                
                  if (acodeonly) {
                 return String.valueOf(conn.getResponseCode());
             }

		if (conn.getResponseCode() != 200) {

                    return null;
		}
                
              

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
                StringBuilder sb=new StringBuilder();

		while ((output = br.readLine()) != null) {
			//System.out.println(output);
                        sb.append(output);
                        
		}

		conn.disconnect();
            return sb.toString();
	  } catch (MalformedURLException e) {
              System.out.println(e.getMessage());
	  } 
         catch (IOException e) {
             System.out.println(e.getMessage());
	 }
            return null;
	}//end method
    }

