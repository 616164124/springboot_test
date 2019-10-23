package com.example.demo.controle;


import com.example.demo.generator.TUser;
import com.example.demo.generator.TUserExample;
import com.example.demo.repository.TDept;
import com.example.demo.service.TUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TUserController {


    @Resource
    TUserExample tUserExample;
    @Resource
    private TUserService tUserService;

    @RequestMapping("/tuser")
    public List<TUser> getTUerid() {
        return tUserService.getUserId();
    }

    @RequestMapping("/DeptIdJpa/{id}")
    public List<TDept> getTUserForJpa(){
        return tUserService.getDeptIdForJpa();
    }

    @RequestMapping("/insertUser")
    public void insert(TUser tUser) {
        tUserService.insert(tUser);
    }

    @RequestMapping("/user")
    public TUser getUser() {
        return tUserService.selectByPrimaryKey(1l);
    }


}
