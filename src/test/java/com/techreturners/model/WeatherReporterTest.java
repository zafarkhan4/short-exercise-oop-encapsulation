package com.techreturners.model;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.techreturners.encapsulation.bankaccount.model.WeatherReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherReporterTest {

  private static WeatherReporter wr1;
  private static WeatherReporter wr2;
  private static WeatherReporter wr3;
  private static WeatherReporter wr4;

  @BeforeAll
  public void setup() {
    wr1 = new WeatherReporter("london", 5);
    wr2 = new WeatherReporter("California", 14);
    wr3 = new WeatherReporter("Cape Town", 31);
    wr4 = new WeatherReporter("Birmingham", 4);
  }

  private static Stream<Arguments> provideLocationWeatherInputs() {
    return Stream.of(
        Arguments.of(wr1, "🌦"),
        Arguments.of(wr2, "🌅"),
        Arguments.of(wr3, "🌤"),
        Arguments.of(wr4, "🔆"));
  }

  @ParameterizedTest
  @MethodSource("provideLocationWeatherInputs")
  public void checkLocationWeather(WeatherReporter wr, String expectedValue) {
    assertEquals(expectedValue, wr.getLocationWeather());
  }

  private static Stream<Arguments> provideLocationTemperatureInputs() {
    return Stream.of(
        Arguments.of(wr1, "It's too cold 🥶!"),
        Arguments.of(wr2, "Ahhh...it's just right 😊!"),
        Arguments.of(wr3, "It's too hot 🥵!"),
        Arguments.of(wr4, "It's too cold 🥶!"));
  }

  @ParameterizedTest
  @MethodSource("provideLocationTemperatureInputs")
  public void checkTemperatureInfo(WeatherReporter wr, String expectedValue) {
    assertEquals(expectedValue, wr.getTemperaureInfo());
  }

  @AfterAll
  public void tearDown() {
    wr1 = null;
    wr2 = null;
    wr3 = null;
    wr4 = null;
  }

}
