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
        WeatherDataService weatherDataServiceMock = spy(WeatherDataService.class);
        Weather weatherMock = mock(Weather.class);
        given(weatherDataServiceMock.getWeatherFromApi(anyString())).willReturn(weatherMock);
        given(weatherMock.getLocation().getName()).willReturn("Warszawa");
        //when
        WeatherData result = weatherDataServiceMock.fetchCurrentWeatherData();
        //then
        assertThat(result.city(), equalTo("Warszawa"));
    }
}