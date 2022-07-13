package com.fse.stcokdetails.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceModel {
    private Long companyCode;
    private String CompanyName;
    private BigDecimal StockPrice;
    private LocalDateTime dateTime;
}
