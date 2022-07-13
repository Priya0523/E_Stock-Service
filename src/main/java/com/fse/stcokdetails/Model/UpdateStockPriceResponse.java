package com.fse.stcokdetails.Model;

import com.fse.stcokdetails.Entity.StockPriceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStockPriceResponse {
    private List<StockPriceEntity> stockPriceList;
    private String messageType;
    private HttpStatus messageCode;
    private String message;

}
