/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexiontest2;

import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;
import com.flexionmobile.codingchallenge.integration.Purchase;
import java.util.List;

/**
 *
 * @author SRI
 */
public class FlexionTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegrationImpl iimpl=new IntegrationImpl();
    
      
      //Buy test
//       Purchase p=iimpl.buy("item22");
       
       //Consume test
//       iimpl.consume(p);
       
       //All purchases test
      /*
        List<Purchase> allpurchases=iimpl.getPurchases();
        
        for (Purchase ipurchase : allpurchases) {
            System.out.println("Purchase ID: "+ipurchase.getId());
            System.out.println("Consumed: "+ipurchase.getConsumed());
            System.out.println("Item: "+ipurchase.getItemId());
            System.out.println("--------------------------------------------");
        }
        */
        //Integration test
        IntegrationTestRunner testrunner=new IntegrationTestRunner();
        testrunner.runTests(iimpl);
    }
    
}

