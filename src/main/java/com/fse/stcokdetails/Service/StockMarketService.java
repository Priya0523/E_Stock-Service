package com.fse.stcokdetails.Service;


import com.fse.stcokdetails.Model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface StockMarketService {
    List<CompanyDetailModel> getCompanyDetails();

    CompanyUpdateResponse addRegistration(CompanyDetailModel registration);

    CompanyListResponse getCompanyList(Long companyCode);

    CompanyUpdateResponse deleteCompanyDetails(Long companyCode);

    List<CompanyDetailModel> getAllCompanies();

    UpdateStockPriceResponse addStockPrice(AddStockPriceRequest request);

    UpdateStockPrice updateStockPrice(AddStockPriceRequest request);
}
