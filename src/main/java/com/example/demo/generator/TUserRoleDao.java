package com.example.demo.generator;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;


@Service
public interface TUserRoleDao extends Mapper<TUserRole> {
    int insert(TUserRole record);
    int insertSelective(TUserRole record);
}