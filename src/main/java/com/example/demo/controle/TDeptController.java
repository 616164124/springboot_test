package com.example.demo.controle;

import com.example.demo.repository.TDept;
import com.example.demo.service.TDpetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TDeptController {

    @Resource
    TDpetService tDpetService;

    @RequestMapping("/dept")
    @ResponseBody
    public List<TDept> findDept(){
        return tDpetService.findAll();
    }
}
