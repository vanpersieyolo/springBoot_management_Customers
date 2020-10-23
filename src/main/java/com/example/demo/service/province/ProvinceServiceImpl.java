package com.example.demo.service.province;

import com.example.demo.model.Province;
import com.example.demo.repo.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceServiceImpl implements IProvinceService{
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Province save(Province model) {
        return provinceRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
