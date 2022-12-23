package com.codewithsandeep.bootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsandeep.bootexample.model.Donar;

public interface DonarRepository extends JpaRepository<Donar, Long>{

}
