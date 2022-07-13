package com.fse.stcokdetails.Repository;

import com.fse.stcokdetails.Entity.CompanyDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDetailEntity, Long> {

    @Query(value = "select * from Company  where companyCode = ?1", nativeQuery = true)
    List<CompanyDetailEntity> getCompanyDetailsByCompanyCode(Long companyCode);

    List<CompanyDetailEntity> findByCompanyNameNotNull();

}
