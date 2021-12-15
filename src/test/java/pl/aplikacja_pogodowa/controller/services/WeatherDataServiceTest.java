package pl.aplikacja_pogodowa.controller.services;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.WeatherState;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.aplikacja_pogodowa.ApiForecastStub;
import pl.aplikacja_pogodowa.ApiWeatherStub;
import pl.aplikacja_pogodowa.model.WeatherData;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.*;

class WeatherDataServiceTest {

    @Mock
    OpenWeatherMapClient openWeatherMapClientMock;

    @Test
    void allTransformedDataShouldMatch() {
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiWeatherStub apiWeatherStub = new ApiWeatherStub();
        //when
        WeatherData result = weatherDataService.transformCurrentWeatherFromApiToWeatherDataModel(apiWeatherStub.getWeather());
        //then
        assertThat(result.city(), equalTo("Warszawa"));
        assertThat(result.country(), equalTo("Polska"));
        assertThat(result.date(), equalTo("01/01/2021"));
        assertThat(result.time(), equalTo("12:00:00"));
        assertThat(result.sunrise(), equalTo("06:41:22"));
        assertThat(result.sunset(), equalTo("20:30:15"));
        assertThat(result.isLike(), equalTo("bezchmurnie"));
        assertThat(result.weatherIcon(), equalTo("http://openweathermap.org/img/w/01.png"));
        assertThat(result.temperature(), equalTo("20℃"));
        assertThat(result.minTemperature(), equalTo("18℃"));
        assertThat(result.maxTemperature(), equalTo("22℃"));
        assertThat(result.pressure(), equalTo("1000 hPa"));
        assertThat(result.windSpeed(), equalTo("3 m/s"));
        assertThat(result.Humidity(), equalTo("50 %"));
        assertThat(result.clouds(), equalTo("25 %"));
    };

    @Test
    void weatherDataForecastShouldHaveSizeFive(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result, hasSize(5));
    }

    @Test
    void weatherDataForecastShouldHaveFiveNextDays(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).date(), equalTo("01/01/2021"));
        assertThat(result.get(1).date(), equalTo("02/01/2021"));
        assertThat(result.get(2).date(), equalTo("03/01/2021"));
        assertThat(result.get(3).date(), equalTo("04/01/2021"));
        assertThat(result.get(4).date(), equalTo("05/01/2021"));
    }

    @Test
    void weatherDataForecastShouldHaveSameHours(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).time(), equalTo("00:00:00"));
        assertThat(result.get(1).time(), equalTo("00:00:00"));
        assertThat(result.get(2).time(), equalTo("00:00:00"));
        assertThat(result.get(3).time(), equalTo("00:00:00"));
        assertThat(result.get(4).time(), equalTo("00:00:00"));
    }

    @Test
    void weatherDataForecastShouldMatchTemperature(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).temperature(), equalTo("20℃"));
        assertThat(result.get(1).temperature(), equalTo("18℃"));
        assertThat(result.get(2).temperature(), equalTo("25℃"));
        assertThat(result.get(3).temperature(), equalTo("15℃"));
        assertThat(result.get(4).temperature(), equalTo("14℃"));
    }

    @Test
    void weatherDataForecastShouldMatchIcons(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).weatherIcon(), equalTo("http://openweathermap.org/img/w/01.png"));
        assertThat(result.get(1).weatherIcon(), equalTo("http://openweathermap.org/img/w/02.png"));
        assertThat(result.get(2).weatherIcon(), equalTo("http://openweathermap.org/img/w/03.png"));
        assertThat(result.get(3).weatherIcon(), equalTo("http://openweathermap.org/img/w/04.png"));
        assertThat(result.get(4).weatherIcon(), equalTo("http://openweathermap.org/img/w/05.png"));
    }

    @Test
    void weatherDataForecastShouldMatchDescriptions(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).isLike(), equalTo("bezchmurnie"));
        assertThat(result.get(1).isLike(), equalTo("deszczowo"));
        assertThat(result.get(2).isLike(), equalTo("slonecznie"));
        assertThat(result.get(3).isLike(), equalTo("pochmurnie"));
        assertThat(result.get(4).isLike(), equalTo("burze"));
    }

    @Test
    void weatherDataForecastShouldMatchPressure(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).pressure(), equalTo("1000hPa"));
        assertThat(result.get(1).pressure(), equalTo("999hPa"));
        assertThat(result.get(2).pressure(), equalTo("1001hPa"));
        assertThat(result.get(3).pressure(), equalTo("1005hPa"));
        assertThat(result.get(4).pressure(), equalTo("995hPa"));
    }

    @Test
    void weatherDataForecastShouldMatchHumidity(){
        //given
        WeatherDataService weatherDataService = new WeatherDataService(openWeatherMapClientMock);
        ApiForecastStub apiForecastStub = new ApiForecastStub();
        //when
        List<WeatherData> result = weatherDataService.transformForecastFromApiToWeatherDataModel(apiForecastStub.getWeatherForecast());
        //then
        assertThat(result.get(0).Humidity(), equalTo("wilg.50%"));
        assertThat(result.get(1).Humidity(), equalTo("wilg.70%"));
        assertThat(result.get(2).Humidity(), equalTo("wilg.25%"));
        assertThat(result.get(3).Humidity(), equalTo("wilg.10%"));
        assertThat(result.get(4).Humidity(), equalTo("wilg.80%"));
    }
}