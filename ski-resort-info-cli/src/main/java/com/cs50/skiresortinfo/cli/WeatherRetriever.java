package com.cs50.skiresortinfo.cli;

import com.cs50.skiresortinfo.cli.service.ApiCurrentWeather;
import com.cs50.skiresortinfo.cli.service.WeatherRetrievalService;
import com.cs50.skiresortinfo.domain.Resort;
import com.cs50.skiresortinfo.repository.ResortsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;

import org.jline.reader.*;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.*;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.Terminal;

import javax.json.JsonObject;
import java.io.IOException;
import java.util.*;

public class WeatherRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(ResortRetriever.class);
    private static LineReader reader;
    private static List<String> resortNames;

    private static String convertMillimetersToInches(float millimeters) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(millimeters * 0.0393701f);
    }


    private enum MenuState {
        MAIN_MENU, RESORTS_MENU, WEATHER_MENU
    }

    private static MenuState currentMenu = MenuState.MAIN_MENU;

    public static void main(String[] args) {
        LOG.info("WeatherRetriever starting!");

        resortNames = new ArrayList<>();
        List<Resort> resorts = ResortsRepository.openResortsRepository().getAllResorts();
        for (Resort resort : resorts) {
            resortNames.add(resort.name());
        }

        try {
            terminalInterface();
        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }
    }

    private static void terminalInterface() throws IOException {

        Terminal terminal = TerminalBuilder.terminal();

        List<String> mainMenuOptions = Arrays.asList("list", "weather", "exit");
        List<String> resortsMenuOptions = Arrays.asList("weather", "back", "exit");
        List<String> weatherMenuOptions = Arrays.asList("current", "5day", "back", "exit");

        reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new StringsCompleter(mainMenuOptions))
                .build();

        while (true) {
            switch (currentMenu) {
                case MAIN_MENU:
                    System.out.println("Main Menu: " + mainMenuOptions);
                    break;
                case RESORTS_MENU:
                    System.out.println("Choose an option: " + resortsMenuOptions);
                    break;
                case WEATHER_MENU:
                    System.out.println("Choose an option: " + weatherMenuOptions);
                    break;
            }

            String line = reader.readLine("> ");
            if (line == null || line.equalsIgnoreCase("exit")) {
                break;
            }

            switch (currentMenu) {
                case MAIN_MENU:
                    handleMainMenu(line, mainMenuOptions);
                    break;
                case RESORTS_MENU:
                    handleResortsMenu(line, resortsMenuOptions);
                    break;
                case WEATHER_MENU:
                    handleWeatherMenu(line, weatherMenuOptions);
                    break;
            }



        }
    }

    private static void handleWeatherMenu(String line, List<String> weatherMenuOptions) {
        switch (line) {
            case "current":
                getCurrentWeather();
                break;
            case "5day":
//                System.out.println("Getting 5 day weather forecast");
                get5dayWeather();
                break;
            case "back":
                currentMenu = MenuState.RESORTS_MENU;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void handleMainMenu(String line, List<String> mainMenuOptions) {
        switch (line) {
            case "list":
                currentMenu = MenuState.RESORTS_MENU;
                listResorts();
                break;
            case "weather":
                currentMenu = MenuState.WEATHER_MENU;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void handleResortsMenu(String line, List<String> resortsMenuOptions) {
//        System.out.println("Choose an option: " + resortsMenuOptions);
        switch (line) {
            case "weather":
                currentMenu = MenuState.WEATHER_MENU;
                break;
            case "back":
                currentMenu = MenuState.MAIN_MENU;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void getCurrentWeather() {
        System.out.println(("Please type in the name of resort or type back to return to the main menu: "));
        String resortName;
        while (true) {
            resortName = reader.readLine("> ");
            if (resortName.equalsIgnoreCase("back")) {
                currentMenu = MenuState.MAIN_MENU;
                return;
            }
            if (resortNames.contains(resortName)) {
                System.out.println("Getting current weather for " + resortName);
                ResortsRepository resortsRepository = ResortsRepository.openResortsRepository();
                Resort resort = resortsRepository.getResort(resortName);
                WeatherRetrievalService weatherRetrievalService = new WeatherRetrievalService();
                JsonObject result = weatherRetrievalService.getCurrentWeather(resort.latitude(), resort.longitude());
                displayWeather(result);
                break;
            } else {
                System.out.println("Invalid resort name. Please try again or type back to return to the main menu: ");
            }
        }
    }



    private static void get5dayWeather() {
        System.out.println(("Please type in the name of resort or type back to return to the main menu: "));
        String resortName;
        while (true) {
            resortName = reader.readLine("> ");
            if (resortName.equalsIgnoreCase("back")) {
                currentMenu = MenuState.MAIN_MENU;
                return;
            }
            if (resortNames.contains(resortName)) {
                System.out.println("Getting 5day forecast for " + resortName);
                ResortsRepository resortsRepository = ResortsRepository.openResortsRepository();
                Resort resort = resortsRepository.getResort(resortName);
                WeatherRetrievalService weatherRetrievalService = new WeatherRetrievalService();
                JsonObject results = weatherRetrievalService.get5dayWeather(resort.latitude(), resort.longitude());
                for (JsonObject result : results.getJsonArray("list").getValuesAs(JsonObject.class)) {
//                    System.out.println(result);
                    displayWeather(result);
                }
                break;
            } else {
                System.out.println("Invalid resort name. Please try again or type back to return to the main menu: ");
            }
        }
    }

    private static void listResorts() {
        System.out.println("Listing resorts");

        System.out.println(String.join("\n", resortNames));
    }

    private static void displayWeather(JsonObject result) {
        if (result.containsKey("dt")) {
            long dt = result.getJsonNumber("dt").longValue();
            Date date = new Date(dt * 1000);
            System.out.printf("Date: %s%n", date);
        }
        System.out.printf("Description: %s%n", result.getJsonArray("weather").getJsonObject(0).getString("description"));
        System.out.printf("Temperature: %s°F%n", result.getJsonObject("main").getJsonNumber("temp"));
        System.out.printf("Wind Speed: %smph%n", result.getJsonObject("wind").getJsonNumber("speed"));
        if (result.containsKey("rain")) {
            if (result.getJsonObject("rain").containsKey("1h")) {
                float rain = result.getJsonObject("rain").getJsonNumber("1h").bigDecimalValue().floatValue();
                System.out.printf("Rain accumulation from last hour: %sin%n", convertMillimetersToInches(rain));
            }
        } else if (result.containsKey("snow")) {
            if (result.getJsonObject("snow").containsKey("1h")) {
                float snow = result.getJsonObject("snow").getJsonNumber("1h").bigDecimalValue().floatValue();
                System.out.printf("Snow accumulation from last hour: %sin%n", convertMillimetersToInches(snow));
            }
        }
        System.out.println();
    }
    
}

