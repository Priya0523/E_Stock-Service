package com.fse.stcokdetails.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Builder
@Getter
@ToString
public class UpdateStockPrice {
    private String messageType;
    private HttpStatus messageCode;
    private String message;
}
