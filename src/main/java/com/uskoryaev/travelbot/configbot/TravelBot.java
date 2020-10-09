package com.uskoryaev.travelbot.configbot;

import com.uskoryaev.travelbot.botinfo.CommandType;
import com.uskoryaev.travelbot.dto.CityDTO;
import com.uskoryaev.travelbot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class TravelBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.name}")
    private String name;

    @Value("${telegram.bot.token}")
    private String token;

    private final CityService cityService;

    @Override
    public void onUpdateReceived(Update update) {
        String commandName = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        if (commandName != null) {
            CityDTO cityDTO = cityService.findByName(CommandType.chooseCityByCommand(commandName));
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText(cityDTO.getDescription());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return this.name;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }
}