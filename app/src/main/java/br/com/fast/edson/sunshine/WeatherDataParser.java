package br.com.fast.edson.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject weather = new JSONObject(weatherJsonStr);
        JSONArray days = weather.getJSONArray("list"); // Lista de dias
        JSONObject dayInfo = days.getJSONObject(dayIndex); // Pega um item/dia pelo índice
        JSONObject temperatureInfo = dayInfo.getJSONObject("temp"); // lista de temperaturas min max...
        return temperatureInfo.getDouble("max");
    }

}
