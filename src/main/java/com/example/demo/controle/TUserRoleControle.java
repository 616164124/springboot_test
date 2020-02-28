package com.example.demo.controle;

import com.example.demo.generator.TUserRole;
import com.example.demo.generator.TUserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TUserRole")
public class TUserRoleControle {
  @Autowired private TUserRoleDao tUserRoleDao;

  @RequestMapping("/S")
  public List<TUserRole> getTUserRole() {

    List<TUserRole> tUserRoles = tUserRoleDao.selectAll();
    return tUserRoles;
  }

  @RequestMapping("/CC") // 请求地址： http://localhost:8081/TUserRole/CC?id=3
  public void inserTUserRole(@RequestParam String id) {
    System.out.println(id);
  }

  // https://www.cnblogs.com/xuwujing/p/11184162.html

  public void sout() {
    int i = 1 / 0;
    System.out.println("进入 Transactional");
  }
}
