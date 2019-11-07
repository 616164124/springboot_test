package com.example.demo.generator;

import com.example.demo.generator.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectById(long id);

    List<TUser> selectByExample(TUserExample criteria);

    List<TUser>  selectAll();

}