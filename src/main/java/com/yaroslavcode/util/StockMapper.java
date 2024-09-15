package com.yaroslavcode.util;

import com.yaroslavcode.model.Stock;

import java.math.BigDecimal;

/**
 * Utility class for mapping column data to {@link Stock} attributes.
 * <p>
 * This class provides a method to populate a {@link Stock} object based on the index of the column and the corresponding data.
 * </p>
 */
public class StockMapper {

    /**
     * Fills a {@link Stock} object with data based on the index of the column.
     * <p>
     * This method updates the attributes of the provided {@link Stock} object based on the given index and column data.
     * The index corresponds to the position of the data in a row, and the data is parsed into the appropriate type for each attribute.
     * </p>
     *
     * @param index        the index of the column in the row (0-based)
     * @param columnData   the data from the column as a {@link String}
     * @param stock        the {@link Stock} object to be populated
     * @throws NumberFormatException if the {@link String} cannot be parsed into a {@link BigDecimal}
     */
    public static void fillStockByIndex(int index, String columnData, Stock stock) {
        switch (index) {
            case 0:
                stock.setCompany(columnData);
                break;
            case 1:
                stock.setPrice(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            case 2:
                stock.setChangedValue(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            case 3:
                stock.setChangeDifference(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            case 4:
                stock.setOpenPrice(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            case 5:
                stock.setHighPrice(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            case 6:
                stock.setLowPrice(BigDecimal.valueOf(Double.parseDouble(columnData)));
                break;
            default:
                System.out.println("Unexpected index: " + index);
                break;
        }
    }
}
