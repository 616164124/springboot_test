package com.example.demo.service;

import com.example.demo.repository.TDept;
import com.example.demo.repository.TDeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//参考网址 https://www.cnblogs.com/dyh-air/articles/9170457.html    https://blog.csdn.net/u012294515/article/details/103155805
@Slf4j
@Service
public class TDpetService {
  @Resource private TDeptRepository tDeptRepository;

  public Page<TDept> findAll(PageRequest pageRequest) {

    return tDeptRepository.findAll(pageRequest.first());
  }

  public List<TDept> findTDept() {

    return tDeptRepository.findAll();
  }

  // 按条件查找
  public List<TDept> findTDeptExample() {

    // 条件
    TDept tDept = new TDept();
    tDept.setDeptName("系统部");
    Pageable pageable =PageRequest.of(1,12);
    // 匹配器
    // sql
    //  SELECT
    //  tdept0_.dept_id AS dept_id1_0_,
    //  tdept0_.create_time AS create_t2_0_,
    //  tdept0_.dept_name AS dept_nam3_0_,
    //  tdept0_.modify_time AS modify_t4_0_,
    //  tdept0_.order_num AS order_nu5_0_,
    //  tdept0_.parent_id AS parent_i6_0_
    // FROM
    //  t_dept tdept0_
    // WHERE tdept0_.dept_name = ?
    //  OR tdept0_.dept_id = 0
    //  OR tdept0_.parent_id = 0
    //  OR tdept0_.order_num = 0
    ExampleMatcher matching = ExampleMatcher.matching();

    Example<TDept> example = Example.of(tDept, matching);

    // 按条件查询
    Page<TDept> all = tDeptRepository.findAll(example, pageable);

    System.out.println(all.getContent().get(0));
    return null;
  }


  public List<TDept> QuickQuery(){


    List<TDept> tDepts = tDeptRepository.findByDeptIdLessThan(5l);

    return tDepts;



  }


}
