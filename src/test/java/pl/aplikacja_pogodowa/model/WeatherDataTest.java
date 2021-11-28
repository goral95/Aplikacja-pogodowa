package pl.aplikacja_pogodowa.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

class WeatherDataTest {

    @Test
    void constructObjectWithAllParametersShouldSetAllProperties() {
        //given
        //when
        WeatherData weatherData = new WeatherData("city",
                "country",
                "date",
                "time",
                "sunset",
                "sunrise",
                "weatherIcon",
                "isLike",
                "temperature",
                "maxTemperature",
                "minTemperature",
                "pressure",
                "humidity",
                "windSpeed",
                "clouds");
        //then
        assertThat(weatherData.city(), equalTo("city"));
        assertThat(weatherData.country(), equalTo("country"));
        assertThat(weatherData.date(), equalTo("date"));
        assertThat(weatherData.time(), equalTo("time"));
        assertThat(weatherData.sunset(), equalTo("sunset"));
        assertThat(weatherData.sunrise(), equalTo("sunrise"));
        assertThat(weatherData.weatherIcon(), equalTo("weatherIcon"));
        assertThat(weatherData.isLike(), equalTo("isLike"));
        assertThat(weatherData.temperature(), equalTo("temperature"));
        assertThat(weatherData.maxTemperature(), equalTo("maxTemperature"));
        assertThat(weatherData.minTemperature(), equalTo("minTemperature"));
        assertThat(weatherData.pressure(), equalTo("pressure"));
        assertThat(weatherData.Humidity(), equalTo("humidity"));
        assertThat(weatherData.windSpeed(), equalTo("windSpeed"));
        assertThat(weatherData.clouds(), equalTo("clouds"));
    }

    @Test
    void constructObjectWithNotAllParametersShouldSetChosenPropertiesAndSetNullOnRest() {
        //given
        //when
        WeatherData weatherData = new WeatherData("date",
                "time",
                "weatherIcon",
                "isLike",
                "temperature",
                "pressure",
                "humidity");
        //then
        assertThat(weatherData.date(), equalTo("date"));
        assertThat(weatherData.time(), equalTo("time"));
        assertThat(weatherData.weatherIcon(), equalTo("weatherIcon"));
        assertThat(weatherData.isLike(), equalTo("isLike"));
        assertThat(weatherData.temperature(), equalTo("temperature"));
        assertThat(weatherData.pressure(), equalTo("pressure"));
        assertThat(weatherData.Humidity(), equalTo("humidity"));

        assertNull(weatherData.city());
        assertNull(weatherData.country());
        assertNull(weatherData.sunset());
        assertNull(weatherData.sunrise());
        assertNull(weatherData.maxTemperature());
        assertNull(weatherData.minTemperature());
        assertNull(weatherData.windSpeed());
        assertNull(weatherData.clouds());
    }
}