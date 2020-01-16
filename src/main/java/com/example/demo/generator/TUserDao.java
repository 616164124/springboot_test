package com.example.demo.generator;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserDao {
  long countByExample(TUserExample example);

  int deleteByExample(TUserExample example);

  int deleteByPrimaryKey(Long userId);

  int insert(TUser record);

  int insertSelective(TUser record);

  List<TUser> selectByExample(TUserExample example);

  TUser selectByPrimaryKey(Long userId);

  int updateByExampleSelective(
      @Param("record") TUser record, @Param("example") TUserExample example);

  int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

  int updateByPrimaryKeySelective(TUser record);

  int updateByPrimaryKey(TUser record);

  List<TUser> selectAll();

   List<TUser> selectForDept();
}
