package com.fse.stcokdetails.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailModel {
    private Long companyCode;
    private String companyName;
    private String companyCeo;
    private BigDecimal companyTurnover;
    private String companyWebSite;
    private String stockExchange;
    private String companyCodeAndName;


}
