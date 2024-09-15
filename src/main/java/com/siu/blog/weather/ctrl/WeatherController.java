package com.siu.blog.weather.ctrl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siu.blog.weather.domain.WeatherItemDTO;
import com.siu.blog.weather.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl;

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.dataType}")
    private String dataType;

    private int nx = 56;
    private int ny = 92;

    @GetMapping("/weather")
    public ResponseEntity<List<WeatherItemDTO>> getWeather(
            @RequestParam(value = "base_date") String baseDate,
            @RequestParam(value = "base_time") String baseTime) {

        String requestURL = callBackUrl +
                "?serviceKey=" + serviceKey +
                "&numOfRows=1000&dataType=" + dataType +
                "&base_date=" + baseDate +
                "&base_time=" + baseTime +
                "&nx=" + nx +
                "&ny=" + ny;

        List<WeatherItemDTO> list = null;

        try {
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int code = conn.getResponseCode();

            if (code == 200) {
                InputStream stream = conn.getInputStream();
                String result = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

                // Json 문자열을 java 객체를 담은 리스트로
                list = weatherService.parsingJson(result);

                // 최종적으로 리스트를 필터링
                list = list.stream()
                        .filter(item -> item.getCategory().equals("SKY") || item.getCategory().equals("PTY"))
                        .collect(Collectors.toList());
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
