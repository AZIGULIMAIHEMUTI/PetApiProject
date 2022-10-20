package apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtility {

    public static String getPetPayload(String name,int id,String status){
        long timeStamp = System.currentTimeMillis();
        String payload= null;
        PetPayload petPayload = new PetPayload(name+timeStamp,
                0,status+timeStamp);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            payload = objectMapper.writeValueAsString(petPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return payload;
    }
}

