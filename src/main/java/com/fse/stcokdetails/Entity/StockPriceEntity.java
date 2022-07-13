package com.fse.stcokdetails.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "Stock_Price")
public class StockPriceEntity {
    private Long companyCode;
    private String CompanyName;
    private BigDecimal StockPrice;
    private LocalDateTime dateTime;
}
