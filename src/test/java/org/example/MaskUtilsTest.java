package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class MaskUtilsTest {

    Map<String, String> testMap = new HashMap<>();
    MaskUtils maskUtils = null;
    final String maskString = MaskConstant.maskedString;

    @Before
    public void setUp(){
        testMap.put("password", MaskSensitiveData.PASSWORD.name());
        testMap.put("secondUser","Nikith");
        maskUtils = new MaskUtils();
    }

    @Test
    public void test_Masked_Sensitive_Data(){

        Map<String, String> actualMap = maskUtils.maskData(testMap);
        String actualValue = actualMap.get("password");
        assertEquals(actualValue,maskString);
    }

    @Test
    public void test_Not_Masked_NON_Sensitive_Data(){

        Map<String, String> actualMap = maskUtils.maskData(testMap);
        String expectedValue = "Nikith";
        String actualValue = actualMap.get("secondUser");

        assertEquals(actualValue,expectedValue);

    }

    @After
    public void CleanUp(){
        testMap.clear();
        maskUtils = null;
    }
}
