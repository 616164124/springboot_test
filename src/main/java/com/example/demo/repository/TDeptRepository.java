package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TDeptRepository extends JpaRepository<TDept, Long>, JpaSpecificationExecutor {


   List<TDept> findByDeptIdLessThan(long d);
   //List<TDept> findbyDeptIdAndTUser_DeptId(long id);


}
