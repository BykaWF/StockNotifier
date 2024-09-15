# Stock Data Scraper with Telegram Bot Integration

## Project Overview
A Java-based web scraper that extracts stock data. The data is formatted and sent to users via a Telegram bot. The scraper runs headlessly to operate efficiently in a production environment.

## Technical Stack
- **Programming Language:** Java
- **Web Scraping Tool:** Selenium
- **Data Handling:** Java Collections
- **Telegram Bot Integration:** Telegram API
- **Browser Driver:** ChromeDriver (configured with headless mode for efficiency)

## Features
- **Data Scraping:** Automatically scrapes stock information, including price and other metrics.
- **Data Formatting:** Processes and formats data into various file types (e.g., CSV, Excel).
- **Telegram Bot:** Sends formatted stock data files to users via a Telegram bot. Users can request data and receive updates directly on Telegram.

## Demonstration
- **Screenshots:** ![Telegram Bot Interaction](link-to-screenshot)
- **Code Snippets:**
  ```java
  // Example code snippet for scraping
  WebElement tableView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tableViewParameter")));
  Select select = new Select(tableView);
  select.selectByValue("2");
## How to Use

1. **Setup Instructions:**
    - Clone the repository.
    - Configure the Telegram bot by following the instructions [here](link-to-telegram-bot-setup).
    - Update the `chromedriver` path in the code.

2. **Running the Project:**
    - Compile and run the Java application.
    - Interact with the Telegram bot to receive stock data.

## Legal and Ethical Considerations

- **Compliance:** Ensure adherence to the terms of service of the Saudi Exchange website. Responsible scraping practices are implemented to avoid overloading the server.
- **Responsible Use:** This project is intended for personal use. Data is fetched and sent respecting the website's policies and load.

## Future Enhancements

- **Potential Improvements:**
    - Adding more data sources for comprehensive coverage.
    - Enhancing the bot’s functionality with more interactive features.
    - Optimizing the scraper for better performance and reliability.

---

Feel free to contact me if you have any questions or need further information about this project.
