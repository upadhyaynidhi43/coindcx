package com.coindcx.entities;

import com.coindcx.pojos.CoinDcxData;
import com.coindcx.pojos.CoinDcxObject;

public class CoindcxEntities {


    public Object payload(String name, String capacity, String generation, String price) {
        CoinDcxObject request = new CoinDcxObject();
        CoinDcxData data = new CoinDcxData();
        data.setCapacity(capacity);
        data.setGeneration(generation);
        data.setPrice(price);
        request.setName(name);
        request.setData(data);
        return request;

    }
}
