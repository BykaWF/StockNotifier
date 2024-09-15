package com.yaroslavcode.util;

import com.yaroslavcode.model.Stock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockScrapper {
    private static final String URL = "https://www.saudiexchange.sa/wps/portal/saudiexchange/ourmarkets/main-market-watch?locale=en";
    private static final Logger logger = Logger.getLogger(StockScrapper.class.getName());
    private final List<Stock> stockList;

    public StockScrapper(){
        this.stockList = new ArrayList<>();
    }

    public List<Stock> scrapStockList() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        long start = LocalTime.now().getSecond();
        try {
            logger.info("Opening the target URL...");
            driver.get(URL);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased wait time
            WebElement tableView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tableViewParameter")));
            Select select = new Select(tableView);
            select.selectByValue("2");

            logger.info("Waiting for the table to load with data...");
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("marketWatchTable2")));

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#marketWatchTable2 tr"), 5));

            List<WebElement> rows = table.findElements(By.tagName("tr"));
            logger.info("Number of rows found: " + rows.size());

            if (rows.isEmpty()) {
                logger.warning("No rows found in the table.");
            }

            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));

                if (columns.isEmpty()) continue;

                int index = 0;
                Stock stock = new Stock();

                for (WebElement column : columns) {
                    StockMapper.fillStockByIndex(index, column.getText(),stock);
                    index++;
                }

                stockList.add(stock);
                index = 0;
            }

        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
        } finally {
            logger.info("Quitting from browser...");
            driver.quit();
        }

        long end = LocalTime.now().getSecond();
        long totalTime = end - start;

        logger.info("Total time taken to scrap the date : " + totalTime + " seconds");

        return stockList;
    }

}
