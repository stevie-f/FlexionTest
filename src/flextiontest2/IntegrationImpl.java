/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexiontest2;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SRI
 */
public class IntegrationImpl implements Integration {
    private final String developer="SRI";
    private final String baseURL="http://sandbox.flexionmobile.com/javachallenge/rest/developer/​";
    
    @Override
    public Purchase buy(String aitemID) {
        SimpleRest sr=new SimpleRest();
        String response=sr.doRequestResponse(baseURL+developer+"/buy/"+aitemID, "POST",false);
        if (response!=null) {
            
        
        JSONObject jo=new JSONObject(response);
        //Debug output
        /*
        System.out.println("ID: "+jo.getString("id"));
        System.out.println("Consumed: "+jo.getBoolean("consumed"));
        System.out.println("ItemID: "+jo.getString("itemId"));
        */
        Purchase resultpurchase=new PurchaseImpl(jo.getString("id"), jo.getBoolean("consumed"), jo.getString("itemId"));
        return resultpurchase;
        }
        
        return null;
    }

    @Override
    public List<Purchase> getPurchases() {
        
        List<Purchase> resultpurchases=new ArrayList<>();
        
        SimpleRest sr=new SimpleRest();
        
        String response=sr.doRequestResponse(baseURL+developer+"/all", "GET",false);
        if (response!=null) {
        JSONObject jo=new JSONObject(response);
        JSONArray purchasearray=jo.getJSONArray("purchases");
        
        for (int i = 0; i < purchasearray.length(); ++i) {
            JSONObject jsonpurchase=purchasearray.getJSONObject(i);
            Purchase resultpurchase=new PurchaseImpl(jsonpurchase.getString("id"), jsonpurchase.getBoolean("consumed"), jsonpurchase.getString("itemId"));
            resultpurchases.add(resultpurchase);
            /*
            System.out.println(jsonpurchase.getBoolean("consumed"));
            System.out.println(jsonpurchase.getString("id"));
            System.out.println(jsonpurchase.getString("itemId"));
            */
        }//end for
        
        }
        return resultpurchases;
        
    }

    @Override
    public void consume(Purchase apurchase) {
        if (apurchase!=null) {
        SimpleRest sr=new SimpleRest();
        String response=sr.doRequestResponse(baseURL+developer+"/consume/"+apurchase.getId(), "POST",true);
       
       
        if (!response.equals("200")) {
            throw new RuntimeException("Consume error. Code: "+response); 
        }
        }
        
        if (apurchase==null) {
            throw new RuntimeException("Error. No Purchase was specified");
        }
    }
    
    //Convenience method to gracefully obtain information about consume success or failure
    public boolean consumeWithStatus(Purchase apurchase) {
        SimpleRest sr=new SimpleRest();
        String response=sr.doRequestResponse(baseURL+developer+"/consume/"+apurchase.getId(), "POST",true);       
            
        if (!response.equals("200")) {
            return false;
        }
        return true;
    }
    
}
