package com.fse.stcokdetails.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddStockPriceRequest {
    private Long companyCode;
    private BigDecimal stockPrice;

}
