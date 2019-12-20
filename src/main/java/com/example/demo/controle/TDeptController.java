package com.example.demo.controle;

import com.example.demo.repository.TDept;
import com.example.demo.service.TDpetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<TDept> findDept() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "deptId");
        //PageRequest request = PageRequest.of(2, 5, Sort.by(order));
        PageRequest request = PageRequest.of(2,3);
        Page<TDept> all = tDpetService.findAll(request);

        return all;
    }


    //采用jap的分页方式
    @RequestMapping("/findDept")
    @ResponseBody
    public Page<TDept> finaDept(){
        //jpa方式实现
        //    return tDpetService.findTDept();
        PageRequest pageRequest;
        pageRequest = PageRequest.of(1,4);
        Page<TDept> all = tDpetService.findAll(pageRequest);
        return all;
    }


/*

    @RequestMapping("/dept/10")
    public List<TDept> find10Dept() {

    return  tDpetService.find10All();
    }
*/
}
