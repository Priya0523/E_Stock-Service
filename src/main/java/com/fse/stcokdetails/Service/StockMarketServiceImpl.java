package com.fse.stcokdetails.Service;

import com.fse.stcokdetails.Entity.CompanyDetailEntity;
import com.fse.stcokdetails.Entity.StockPriceEntity;
import com.fse.stcokdetails.Model.*;
import com.fse.stcokdetails.Repository.CompanyRepository;
import com.fse.stcokdetails.Repository.StockRepository;
import com.fse.stcokdetails.util.ServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StockMarketServiceImpl implements StockMarketService {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<CompanyDetailModel> getCompanyDetails() {
        List<CompanyDetailModel> companyDetailModelList = Collections.emptyList();
        try {
            List<CompanyDetailEntity> companyDetailEntityList = companyRepository.findAll();
            if (!companyDetailEntityList.isEmpty()) {
                companyDetailModelList = companyDetailEntityList.stream().map(companyDetails ->
                        CompanyDetailModel.builder()
                                .companyCode(companyDetails.getCompanyCode())
                                .companyCeo(companyDetails.getCompanyCeo())
                                .companyTurnover(companyDetails.getCompanyTurnover())
                                .companyWebSite(companyDetails.getCompanyWebSite())
                                .stockExchange(companyDetails.getStockExchange())
                                .companyName(companyDetails.getCompanyName())
                                .build()
                ).collect(Collectors.toList());
            }

        } catch (Exception e) {
            log.error("Failed to Get company List ");

        }
        return companyDetailModelList;

    }

    @Override
    public CompanyUpdateResponse addRegistration(CompanyDetailModel registration) {
        CompanyDetailEntity newCompanyRegistration = new CompanyDetailEntity();
        newCompanyRegistration.setCompanyCode(registration.getCompanyCode());
        newCompanyRegistration.setCompanyName(registration.getCompanyName());
        newCompanyRegistration.setCompanyCeo(registration.getCompanyCeo());
        newCompanyRegistration.setCompanyTurnover(registration.getCompanyTurnover());
        newCompanyRegistration.setCompanyWebSite(registration.getCompanyWebSite());
        newCompanyRegistration.setStockExchange(registration.getStockExchange());
        companyRepository.save(newCompanyRegistration);
        return CompanyUpdateResponse.builder()
                .message(ServiceConstants.MSG_SUCCESS)
                .messageCode(HttpStatus.OK)
                .messageType(ServiceConstants.MSG_SUCCESS)
                .build();
    }

    @Override
    public CompanyListResponse getCompanyList(Long companyCode) {
        List<CompanyDetailEntity> companyDetailEntityList = Collections.emptyList();
        try {
            companyDetailEntityList = companyRepository.getCompanyDetailsByCompanyCode(companyCode);
            if (!CollectionUtils.isEmpty(companyDetailEntityList)) {
                for (CompanyDetailEntity entity : companyDetailEntityList) {
                    companyDetailEntityList.add(entity);
                }
            } else {
                return CompanyListResponse.builder()
                        .companyDetailModelList(Collections.EMPTY_LIST)
                        .message(ServiceConstants.COMPANY_RECORD_NOT_FOUND)
                        .messageCode(HttpStatus.OK)
                        .messageType(ServiceConstants.MSG_SUCCESS)
                        .build();
            }
        } catch (Exception ex) {
            log.error("Error occurred while getting tax reports: {}", ex.getMessage(), ex);
        }
        return CompanyListResponse.builder()
                .companyDetailModelList(companyDetailEntityList)
                .message(ServiceConstants.MSG_SUCCESS)
                .messageCode(HttpStatus.OK)
                .messageType(ServiceConstants.MSG_SUCCESS)
                .build();
    }

    @Override
    public CompanyUpdateResponse deleteCompanyDetails(Long companyCode) {
        try {
            Optional<CompanyDetailEntity> companyDetailEntityOptional = companyRepository.findById(companyCode);
            if (companyDetailEntityOptional.isPresent()) {
                companyRepository.deleteById(companyCode);
            }
        }catch (Exception ex) {
            log.error("Error occurred while deleting company: {}", ex.getMessage(), ex);
        }
        return CompanyUpdateResponse.builder()
                .message(ServiceConstants.MSG_SUCCESS)
                .messageCode(HttpStatus.OK)
                .messageType(ServiceConstants.MSG_SUCCESS)
                .build();

    }

    @Override
    public List<CompanyDetailModel> getAllCompanies() {
        List<CompanyDetailModel> companyDetailModelList = Collections.emptyList();

        List<CompanyDetailEntity> companyDetailEntityList = companyRepository.findByCompanyNameNotNull();
        if (!companyDetailEntityList.isEmpty()) {
            companyDetailModelList = (List<CompanyDetailModel>) companyDetailEntityList.stream().map(companyDetailEntity ->
                    CompanyDetailModel.builder()
                            .companyCodeAndName(String.valueOf(companyDetailEntity.getCompanyCode()).concat("-") + companyDetailEntity.getCompanyName())
                            .build());

        }
        return companyDetailModelList;
    }

    @Override
    public UpdateStockPriceResponse addStockPrice(AddStockPriceRequest request) {
        List<StockPriceEntity> stockPriceEntity = stockRepository.findByCompanyCode(request.getCompanyCode());
        if (!stockPriceEntity.isEmpty()) {
            StockPriceEntity addStockPrice = StockPriceEntity.builder().build();
            addStockPrice.setStockPrice(request.getStockPrice());
            addStockPrice.setDateTime(LocalDateTime.now());
            stockRepository.save(addStockPrice);
        }
        return UpdateStockPriceResponse.builder()
                .stockPriceList(stockPriceEntity)
                .message(ServiceConstants.MSG_SUCCESS)
                .messageCode(HttpStatus.OK)
                .messageType(ServiceConstants.MSG_SUCCESS)
                .build();
    }

    @Override
    public UpdateStockPrice updateStockPrice(AddStockPriceRequest request) {
        try {

            Optional<StockPriceEntity> stockPriceEntity = stockRepository.findById(request.getCompanyCode());

            //Update amount for Parcel
            if (stockPriceEntity.isPresent()) {
                StockPriceEntity stockPriceEntity1 = stockPriceEntity.get();
                stockPriceEntity1.setStockPrice(request.getStockPrice());
                stockRepository.save(stockPriceEntity1);
            }
        }catch (Exception ex) {
            log.error("Error occurred while updating stock price for company: {}", ex.getMessage(), ex);
        }

        return UpdateStockPrice.builder()
                .message(ServiceConstants.MSG_SUCCESS)
                .messageCode(HttpStatus.OK)
                .messageType(ServiceConstants.MSG_SUCCESS)
                .build();

    }


}