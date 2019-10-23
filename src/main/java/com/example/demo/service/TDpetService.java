package com.example.demo.service;

import com.example.demo.repository.TDept;
import com.example.demo.repository.TDeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TDpetService  {
    @Resource
    TDeptRepository tDeptRepository;

    public List<TDept> findAll() {
        return tDeptRepository.findAll() ;
    }
}
