package com.example.demo.repo;

import com.example.demo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
