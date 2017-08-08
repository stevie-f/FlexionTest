/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexiontest2;

import com.flexionmobile.codingchallenge.integration.Purchase;

/**
 *
 * @author SRI
 */
public class PurchaseImpl implements Purchase {
    String ID;
    Boolean consumed;
    String itemID;

    /**
     *
     * @param ID: Purchase ID
     * @param consumed: Whether Purchase is consumed
     * @param itemID: Whether this Purchase has been consumed
     */
    public PurchaseImpl(String ID, Boolean consumed, String itemID) {
        this.ID = ID;
        this.consumed = consumed;
        this.itemID = itemID;
    }

    public PurchaseImpl(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

   

    public void setConsumed(Boolean consumed) {
        this.consumed = consumed;
    }


    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String getId() {
        return this.ID;
    }

    @Override
    public String getItemId() {
        return this.itemID;
    }

     @Override
    public boolean getConsumed() {
        return consumed;
    }
    
}
