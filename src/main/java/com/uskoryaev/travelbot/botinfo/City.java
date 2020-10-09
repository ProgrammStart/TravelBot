package com.uskoryaev.travelbot.botinfo;

import lombok.Getter;

@Getter
public enum City {
    LONDON("London"),
    MINSK("Minsk"),
    MOSCOW("Moscow"),
    NEW_YORK("New York"),
    LOS_ANGELES("Los Angeles"),
    TOKYO("Tokyo");

    private String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }
}