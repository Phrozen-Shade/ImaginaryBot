package com.example.imaginarybot.service;

import com.example.imaginarybot.configuration.BotConfig;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class ImaginaryBotService extends TelegramLongPollingBot {
    final BotConfig config;

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage.SendMessageBuilder messageBuilder = SendMessage.builder();
            messageBuilder.chatId(chatId).text(messageText);

            try {
                execute(messageBuilder.build());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public ImaginaryBotService(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotUserName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
}
