package com.example.demo.service;

import com.example.demo.repository.TDept;
import com.example.demo.repository.TDeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TDpetService {
    @Resource
    private TDeptRepository tDeptRepository;


    public Page<TDept> findAll(PageRequest pageRequest) {

        return (Page<TDept>) tDeptRepository.findAll();
    }


    public List<TDept> findTDept(){

        return tDeptRepository.findAll();

    }


}
