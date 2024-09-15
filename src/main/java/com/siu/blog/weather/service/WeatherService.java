package com.siu.blog.weather.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siu.blog.weather.domain.WeatherItemDTO;



@Service
public class WeatherService {
    
    public List<WeatherItemDTO> parsingJson(String str){

        ObjectMapper objectMapper = new ObjectMapper();
        List<WeatherItemDTO> list = null;
                
        try{
            JsonNode root = objectMapper.readTree(str);
            JsonNode itemsNode = root.path("response").path("body").path("items").path("item");
            if(itemsNode.isArray()){
                list = Arrays.stream(objectMapper.treeToValue(itemsNode, WeatherItemDTO[].class)).toList();
            }else{
                System.out.println("parsing error ~~~~~");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        }
        
        return list;
    }
}
