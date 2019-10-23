package com.example.demo.service;

import com.example.demo.generator.TUser;
import com.example.demo.generator.TUserDao;
import com.example.demo.generator.TUserExample;
import com.example.demo.generator.TUserExample.Criteria;
import com.example.demo.generator.TUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TUserService {
    @Resource
    TUserMapper tUserMapper;
    @Resource
    TUserDao tUserDao;


    public List<TUser> getUserId() {
        TUserExample tUserExample = new TUserExample();
        Criteria criteria = tUserExample.createCriteria();
        criteria.andDeptIdEqualTo(4l);
        List<TUser> list = tUserDao.selectByExample(tUserExample);
        return list;
    }





    public void insert(TUser tUser) {
        tUserMapper.insert(tUser);
    }


    public TUser selectByPrimaryKey(long id) {

        return tUserMapper.selectByPrimaryKey(id);

    }

}
