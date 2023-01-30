package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;

public class WeatherReporter {

    private String city;
    private double temperatureInCelcius;
    private final int HOT_TEMPERATURE_THRESHOLD = 30;
    private final int COLD_TEMPERATUE_THRESHHOLD = 10;

    public WeatherReporter(String city, double temperatureInCelcius) {
        this.city = city;
        this.temperatureInCelcius = temperatureInCelcius;
    }

    public String getCity() {
        return city;
    }

    public double getTemperatureInCelcius() {
        return temperatureInCelcius;
    }

    private double calculateFahrenheitTemperature(double temperatureInCelcius) {
        return (9.0 / 5.0) * temperatureInCelcius + 32;
    }

    public String print() {
        double newTemp = calculateFahrenheitTemperature(temperatureInCelcius);
        return MessageFormat.format("I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", location,
                getLocationWeather(), getTemperaureInfo(), newTemp);

    }

    public String getLocationWeather() {

        String locationWeather;

        switch (city.toLowerCase()) {
            case "london":
                locationWeather = "🌦";
                break;
            case "california":
                locationWeather = "🌅";
                break;
            case "cape town":
                locationWeather = "🌤";
                break;
            default:
                locationWeather = "🔆";
        }

        return locationWeather;
    }

    public String getTemperaureInfo() {

        if (temperatureInCelcius > HOT_TEMPERATURE_THRESHOLD)
            return "It's too hot 🥵!";

        if (temperatureInCelcius < COLD_TEMPERATUE_THRESHHOLD)
            return "It's too cold 🥶!";

        return "Ahhh...it's just right 😊!";
    }

}
