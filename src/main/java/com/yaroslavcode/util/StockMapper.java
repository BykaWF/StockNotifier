package com.yaroslavcode.util;

import com.yaroslavcode.model.Stock;

import java.math.BigDecimal;

public class StockMapper {


    public static void fillStockByIndex(int index , String columnData, Stock stock){
       switch (index){
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
               System.out.println("we got problem man");
               break;
       }
    }
}
