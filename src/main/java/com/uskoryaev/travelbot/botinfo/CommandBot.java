package com.uskoryaev.travelbot.botinfo;

import lombok.Getter;

@Getter
public enum CommandBot {
    TOKYO("/tokyo"),
    LOS_ANGELES("/los_angeles"),
    NEW_YORK("/new_york"),
    MOSCOW("/moscow"),
    MINSK("/minsk"),
    LONDON("/london");

    private String commandName;

    CommandBot(String commandName) {
        this.commandName = commandName;
    }
}