package com.example.imaginarybot.service;

import com.example.imaginarybot.configuration.BotConfig;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
@Service
public class ImaginaryBotService extends TelegramLongPollingBot {
    final BotConfig config;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage.SendMessageBuilder messageBuilder = SendMessage.builder();
            messageBuilder.chatId(chatId).text(messageText);

            execute(messageBuilder.build());
        }
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
