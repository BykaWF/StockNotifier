package com.yaroslavcode.bot;

import com.yaroslavcode.util.StockScrapper;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class StockBot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private final StockScrapper stockScrapper;

    public StockBot(String TOKEN, StockScrapper stockScrapper) {
        this.telegramClient = new OkHttpTelegramClient(TOKEN);
        this.stockScrapper = stockScrapper;
    }

    @Override
    public void consume(Update update) {
        if (update.getMessage().hasText()) {
            handleTextMassage(update);
        }
    }

    private void handleTextMassage(Update update) {
        String text = update.getMessage().getText();

    }
}
