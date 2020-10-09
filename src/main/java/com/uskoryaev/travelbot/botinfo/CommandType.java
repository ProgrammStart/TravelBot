package com.uskoryaev.travelbot.botinfo;

import java.util.HashMap;
import java.util.Map;

public class CommandType {
    private static Map<String, String> commands = new HashMap<>();

    private static void loadCommand() {
        commands.put(CommandBot.LONDON.getCommandName(), City.LONDON.getCityName());
        commands.put(CommandBot.MINSK.getCommandName(), City.MINSK.getCityName());
        commands.put(CommandBot.MOSCOW.getCommandName(), City.MOSCOW.getCityName());
        commands.put(CommandBot.NEW_YORK.getCommandName(), City.NEW_YORK.getCityName());
        commands.put(CommandBot.LOS_ANGELES.getCommandName(), City.LOS_ANGELES.getCityName());
        commands.put(CommandBot.TOKYO.getCommandName(), City.TOKYO.getCityName());
    }

    public static String chooseCityByCommand(String nameCommand) {
        String notFoundCommand = "Command not found";
        loadCommand();
        if (!nameCommand.isEmpty()) {
            return commands.get(nameCommand);
        }
        return notFoundCommand;
    }
}