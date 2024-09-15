package com.yaroslavcode;

import com.yaroslavcode.bot.StockBot;
import com.yaroslavcode.model.Stock;
import com.yaroslavcode.util.ConverterUtil;
import com.yaroslavcode.util.StockScrapper;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.util.List;
import java.util.logging.Logger;

import static com.yaroslavcode.config.Config.TOKEN;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) {
        try(TelegramBotsLongPollingApplication bot = new TelegramBotsLongPollingApplication()){
            StockScrapper stockScrapper = new StockScrapper();
            bot.registerBot(TOKEN, new StockBot(TOKEN,stockScrapper));

            List<Stock> stocks = stockScrapper.scrapStockList();
            ConverterUtil.convertIntoCSV(stocks);
            List<String> strings = ConverterUtil.convertIntoJSON(stocks);
            logger.info("Bot successfully started and ready to listen");
        }catch (Exception e){
            logger.info("We got exception: " + e);
        }
    }

}