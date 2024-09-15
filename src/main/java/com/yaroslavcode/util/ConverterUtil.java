package com.yaroslavcode.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opencsv.CSVWriter;
import com.yaroslavcode.model.Stock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Utility class for converting a list of {@link Stock} objects into a CSV file.
 * <p>
 * This class provides methods to create a CSV file and write stock data to it.
 * It includes functionalities to convert stock data into a string array format,
 * write the data to the file, and handle the creation of the CSV file if it does not exist.
 * </p>
 */
public class ConverterUtil {

    private static final Logger log = Logger.getLogger(String.valueOf(ConverterUtil.class));

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private ConverterUtil() {
    }

    /**
     * Converts a list of {@link Stock} objects into a CSV file.
     * <p>
     * This method creates a new file named "stock.csv" in the "src/main/resources" directory
     * if it does not already exist. It then writes the stock data to the file.
     * </p>
     *
     * @param stockList a list of {@link Stock} objects to be written to the CSV file
     * @throws IOException if an I/O error occurs while creating the file or writing to it
     */
    public static void convertIntoCSV(List<Stock> stockList) throws IOException {
        File file = new File("src/main/resources/stock.csv");

        if (!file.exists()) {
            try {
                log.info("Creating new file...");
                boolean newFile = file.createNewFile();
                log.info("Created new file : " + newFile);
            } catch (IOException e) {
                log.info("Unable to create new file. Cause : " + e.getMessage());
            }
        }
        Path path = Paths.get(file.toURI());
        List<String[]> stockIntoString = convertStockObjectIntoStringArray(stockList);
        writeLineByLineIntoFile(stockIntoString, path);
    }

    public static List<String> convertIntoJSON(List<Stock> stockList) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        List<String > jsonStockList = new ArrayList<>();
        for (Stock stock : stockList) {
            jsonStockList.add(ow.writeValueAsString(stock));
        }

        return jsonStockList;
    }

    /**
     * Writes a list of string arrays to a CSV file, including the column names.
     * <p>
     * This method writes the column names first, followed by the data rows.
     * </p>
     *
     * @param lines a list of string arrays representing the rows of the CSV file
     * @param path  the path of the CSV file
     * @throws IOException if an I/O error occurs while writing to the file
     */
    private static void writeLineByLineIntoFile(List<String[]> lines, Path path) throws IOException {
        log.info("Writing to file is started....");
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            log.info("Column names are set up");
            writer.writeNext(toStringArr(StockColumnName.values()));

            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }
        log.info("List of stocks are successfully converted into .csv format and saved in " + path);
    }

    /**
     * Converts an array of {@link StockColumnName} enum values to a string array.
     *
     * @param values an array of {@link StockColumnName} enum values
     * @return a string array containing the names of the stock columns
     */
    private static String[] toStringArr(StockColumnName[] values) {
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].toString();
        }
        return result;
    }

    /**
     * Writes the column names to the CSV file.
     *
     * @param stockColumnNames an array of column names
     * @param path             the path of the CSV file
     * @throws IOException if an I/O error occurs while writing to the file
     */
    private static void defineColumnNames(String[] stockColumnNames, Path path) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeNext(stockColumnNames);
        }
    }

    /**
     * Converts a list of {@link Stock} objects into a list of string arrays.
     *
     * @param stockList a list of {@link Stock} objects
     * @return a list of string arrays representing the stock data
     */
    private static List<String[]> convertStockObjectIntoStringArray(List<Stock> stockList) {
        List<String[]> result = new ArrayList<>();
        for (Stock stock : stockList) {
            String[] line = fillLineArray(stock);
            result.add(line);
        }
        return result;
    }

    /**
     * Converts a {@link Stock} object into a string array representing a single row of CSV data.
     *
     * @param stock a {@link Stock} object
     * @return a string array representing the stock data
     */
    private static String[] fillLineArray(Stock stock) {
        String[] line = new String[7];
        line[0] = stock.getCompany();
        line[1] = String.valueOf(stock.getPrice());
        line[2] = String.valueOf(stock.getChangedValue());
        line[3] = String.valueOf(stock.getChangeDifference());
        line[4] = String.valueOf(stock.getOpenPrice());
        line[5] = String.valueOf(stock.getHighPrice());
        line[6] = String.valueOf(stock.getLowPrice());
        return line;
    }
}
