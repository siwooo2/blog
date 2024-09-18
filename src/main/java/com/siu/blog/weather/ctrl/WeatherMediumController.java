package com.siu.blog.weather.ctrl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siu.blog.weather.domain.WeatherMdItemDTO;
import com.siu.blog.weather.service.WeatherMdService;


@RestController
@RequestMapping("/api")
public class WeatherMediumController {
    
    @Autowired
    private WeatherMdService weatherMdService;

    @Value("${openApi.callBackUrl.medium}")
    private String callBackUrl;

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.dataType}")
    private String dataType;

    String regId = "11F10000";

    @GetMapping("/weathermd")
    public ResponseEntity<WeatherMdItemDTO> getWeatherMd(@RequestParam(value = "tmFc") String tmFc) {
        
        String requestURL = callBackUrl +
                "?serviceKey=" + serviceKey +
                "&numOfRows=10&dataType=" + dataType +
                "&regId=" + regId +
                "&tmFc=" + tmFc;

        WeatherMdItemDTO obj = null;

        try {
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int code = conn.getResponseCode();

            if (code == 200) {
                InputStream stream = conn.getInputStream();
                String result = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

                // Json 문자열을 java 객체를 담은 리스트로
                obj = weatherMdService.parsingJson(result);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
}
