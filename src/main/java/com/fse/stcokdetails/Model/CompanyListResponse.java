package com.fse.stcokdetails.Model;

import com.fse.stcokdetails.Entity.CompanyDetailEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;
@Builder
@Getter
@ToString
public class CompanyListResponse {
    private List<CompanyDetailEntity> companyDetailModelList;
    private String messageType;
    private HttpStatus messageCode;
    private String message;
}
