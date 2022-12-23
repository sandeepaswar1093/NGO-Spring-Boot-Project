package com.codewithsandeep.bootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsandeep.bootexample.model.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long>{

}
