package com.example.demo.service;

import com.example.demo.generator.TUser;
import com.example.demo.generator.TUserDao;
import com.example.demo.generator.TUserDept;
import com.example.demo.generator.TUserExample;
import com.example.demo.generator.TUserExample.Criteria;
import com.example.demo.repository.TDept;
import com.example.demo.repository.TDeptRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class TUserService {
  @Resource TUserDao tUserDao;
  TUserExample tUserExample = new TUserExample();
  Criteria criteria = tUserExample.createCriteria();
  @Resource private TDeptRepository tDeptRepository;

  // 关联查询
  public List<TUserDept> selectDept() {

    return null;
  }

  public List<TUser> getUserId() {
    TUserExample tUserExample = new TUserExample();
    Criteria criteria = tUserExample.createCriteria();
    criteria.andDeptIdEqualTo(4l);
    List<TUser> list = tUserDao.selectByExample(tUserExample);
    return list;
  }

  public List<TUser> getUser() {
    criteria.andAvatarIsNotNull();
    List<TUser> tUserList = tUserDao.selectByExample(tUserExample);
    PageHelper.startPage(3, 1);
    /*PageHelper.startPage(Integer.valueOf(pageNum).intValue(),Integer.valueOf(pageSize).intValue());*/
    PageInfo<TUser> pageInfo = new PageInfo<TUser>(tUserList);
    List<TUser> listm = null;
    listm = pageInfo.getList();
    return listm;
  }

  public List<TDept> getDeptIdForJpa() {
    return tDeptRepository.findAll();
  }

  public void insert(TUser tUser) {
    tUserDao.insert(tUser);
  }

  public TUser selectByPrimaryKey(long id) {
    return tUserDao.selectByPrimaryKey(id);
  }

  public List<TUser> findAllTUser() {
    return tUserDao.selectAll();
  }

  // 分页查询  （xml中的limit与offset两个值与example中的limit与offset对应）
  public List<TUser> findTUserLimit() {
    tUserExample.setLimit(Integer.valueOf(2));
    tUserExample.setOffset(4l);
    return tUserDao.selectByExample(tUserExample);
  }

  //mybatis

  public List<TUser> findTUserDept(){


    return tUserDao.selectForDept();
  }



}
