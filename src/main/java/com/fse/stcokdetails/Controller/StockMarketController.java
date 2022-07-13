package com.fse.stcokdetails.Controller;

import com.fse.stcokdetails.Model.*;
import com.fse.stcokdetails.Service.StockMarketServiceImpl;
import com.fse.stcokdetails.util.ServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@Slf4j
@EnableSwagger2
@RequestMapping(ServiceConstants.STOCK_MARKET_API)
public class StockMarketController {
    @Autowired
    StockMarketServiceImpl stockMarketService;

    /**
     * Fetch company details
     *
     * @return List<CompanyDetails>
     */
    @GetMapping("/company/getall")
    public List<CompanyDetailModel> getCompanyDetails() {
        return stockMarketService.getCompanyDetails();
    }

    @PostMapping("/company/register")
    public CompanyUpdateResponse addRegistration(CompanyDetailModel registration) {
        return stockMarketService.addRegistration(registration);
    }

    @GetMapping("/company/info")
    public ResponseEntity<CompanyListResponse> getCompanyList(@RequestBody Long companyCode) {
        CompanyListResponse companyListResponse = stockMarketService.getCompanyList(companyCode);
        return new ResponseEntity<>(companyListResponse, companyListResponse.getMessageCode());
    }

    @DeleteMapping("/company/delete")
    public ResponseEntity<CompanyUpdateResponse> deleteCompanyDetails(@RequestBody Long companyCode) {
        CompanyUpdateResponse companyUpdateResponse = stockMarketService.deleteCompanyDetails(companyCode);
        return new ResponseEntity<>(companyUpdateResponse, companyUpdateResponse.getMessageCode());
    }
    @GetMapping("/company/allCompanies")
    public List<CompanyDetailModel> getAllCompanies() {
        return stockMarketService.getAllCompanies();
    }

    @PostMapping("/company/addStockPrice")
    public UpdateStockPriceResponse addStockPrice(AddStockPriceRequest request) {
        return stockMarketService.addStockPrice(request);
    }
    @PostMapping("/company/update")
    public UpdateStockPrice updateStockPrice(AddStockPriceRequest request){
        return stockMarketService.updateStockPrice(request);
    }
}
