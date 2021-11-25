package pl.aplikacja_pogodowa.controller.services;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.WeatherState;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.aplikacja_pogodowa.model.WeatherData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.*;

class WeatherDataServiceTest {




    @Test
    void fetchCurrentWeatherData() {
        //given
        OpenWeatherMapClient openWeatherMapClientMock = mock(OpenWeatherMapClient.class);
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        Weather weatherMock = mock(Weather.class);
        given(openWeatherMapClientMock
                .currentWeather()
                .single()
                .byCityName(anyString())
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava())
                .willReturn(weatherMock);
        //when

        //then

    }
}