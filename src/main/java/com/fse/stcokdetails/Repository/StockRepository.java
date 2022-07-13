package com.fse.stcokdetails.Repository;

import com.fse.stcokdetails.Entity.StockPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockPriceEntity, Long> {
    List<StockPriceEntity> findByCompanyCode(Long companyCode);
}
