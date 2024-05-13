package com.coindcx;


import com.coindcx.utils.BaseTest;
import com.coindcx.dataproviders.DataProviders;
import com.coindcx.factories.CoindcxFactory;
import com.coindcx.validators.CoindcxValidators;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class AssignmentTest extends BaseTest {

    CoindcxFactory coindcxFactory = new CoindcxFactory();
    CoindcxValidators coindcxValidators = new CoindcxValidators();

    private static final Logger logger = Logger.getLogger(AssignmentTest.class.getName());

    @Test(description = "Restaurant is partially unserviceable ",dataProviderClass = DataProviders.class, dataProvider = "createObject")
    public void createAndObjectAndDeleteIt(String name, String capacity, String generation, String price) throws Exception {

        logger.info("Creating an object, validate the created object and return its id");
        String createObjectResponse = coindcxFactory.createObject(name, capacity, generation, price);
        coindcxValidators.validateCreatedObjectResponse(createObjectResponse, name, capacity, generation, price);
        String id = JsonPath.read(createObjectResponse, "$.id");

        logger.info("Get objects and validate the created object");
        String getResponse = coindcxFactory.getAllObjects(id);
        coindcxValidators.validateGetObjectResponse(getResponse,id, name, capacity, generation, price);

        logger.info("Delete the object");
        String deleteResponse = coindcxFactory.deleteObject(id);
        Assert.assertEquals(JsonPath.read(deleteResponse, "$.message"), "Object with id = "+id+" has been deleted.", "Assertion Failed :: message incorrect");

        logger.info("Get the object by id");
        getResponse = coindcxFactory.getAllObjects(id);
        Assert.assertFalse(getResponse.contains(id));

    }

}