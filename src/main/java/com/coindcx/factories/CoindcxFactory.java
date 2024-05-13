package com.coindcx.factories;

import com.coindcx.helpers.CoinDcxHelpers;

public class CoindcxFactory {

    static CoinDcxHelpers coinDcxHelpers = new CoinDcxHelpers();

    /**
     * This method is to create an object
     *
     * @param name       name of the object to create
     * @param capacity   capacity of the object
     * @param generation generation of the object
     * @param price      price of the object
     * @return created object response
     * @throws Exception
     */
    public String createObject(String name, String capacity, String generation, String price) throws Exception {
        return coinDcxHelpers.createObject(name, capacity, generation, price);
    }

    /**
     * This method is to get object
     *
     * @param id created object id to be passed
     * @return the json response of searched id
     * @throws Exception
     */
    public String getAllObjects(String id) throws Exception {
        return coinDcxHelpers.getAllObjects(id);
    }

    /**
     * This method is to delete an object
     *
     * @param id created object id to be passed
     * @return the json response of deleted id
     * @throws Exception
     */
    public String deleteObject(String id) throws Exception {
        return coinDcxHelpers.deleteObject(id);
    }
}
