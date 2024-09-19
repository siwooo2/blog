package com.siu.blog.weather.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siu.blog.weather.domain.WeatherMdItemDTO;

@Service
public class WeatherMdService {
    
    public WeatherMdItemDTO parsingJson(String str){

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherMdItemDTO obj = null;
                
        try{
            JsonNode root = objectMapper.readTree(str);
            JsonNode itemsNode = root.path("response").path("body").path("items").path("item");
            
            JsonNode firstItemNode = itemsNode.get(0);
            obj = objectMapper.treeToValue(firstItemNode, WeatherMdItemDTO.class);
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        }
        
        return obj;
    }

}
