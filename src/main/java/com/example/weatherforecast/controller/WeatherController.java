package com.example.weatherforecast.controller;

import com.example.weatherforecast.resource.CityNotFoundException;
import com.example.weatherforecast.resource.WeatherForecast;
import com.example.weatherforecast.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// 演習3-1 コントローラのBean定義をしよう
@Controller
public class WeatherController {

    // 演習6-1 WeatherServiceをコンストラクタインジェクションしよう
    private final WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherController(WeatherForecastService weatherService) {
        this.weatherForecastService = weatherService;
    }

    // 演習3-2 リクエストマッピングの設定をしよう
    @RequestMapping(value = "/weather", method = GET)
    public String getWeather(Model model, @RequestParam(name = "city", defaultValue = "tokyo") String city) throws Exception {
        WeatherForecast weatherForecast = weatherForecastService.getWeather(city);
        model.addAttribute("title", weatherForecast.getTitle());
        model.addAttribute("forecasts", weatherForecast.getForecasts());
        return "weather";
    }

    // 演習8-2 コントローラ層で例外をハンドリングしてみよう
    @ExceptionHandler({CityNotFoundException.class})
    public String handleError() {
        return "error";
    }
}
