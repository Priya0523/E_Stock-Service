package com.fse.stcokdetails.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Company Entity Object
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Company")
public class CompanyDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyCode;
    private String CompanyName;
    private String companyCeo;
    private BigDecimal companyTurnover;
    private String companyWebSite;
    private String companyName;
    private String stockExchange;

}


