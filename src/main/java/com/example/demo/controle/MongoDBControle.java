package com.example.demo.controle;

import com.example.demo.generator.MongodbTest;
import com.example.demo.generator.MongodbTest2;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@RestController
public class MongoDBControle {

  // 文档名字
  @Resource private MongoTemplate mongoTemplate;

  @RequestMapping("/mongodbInsert")
  @ResponseBody
  public void insert() {
    UUID id = UUID.randomUUID();
    Date date = new Date(System.currentTimeMillis());
    System.out.println(date);
    int i = new Random().nextInt(9);
    System.out.println(i);
    mongoTemplate.insert(new MongodbTest2(id, "冥223" + i, 12322, date, "\t"), "MongodbTest");
    mongoTemplate.insert(new MongodbTest(id, "司法局3" + i, 12332, date, "\t"), "MongodbTest");
    System.out.println("c成功");
  }

  @RequestMapping("/mongodbQuery")
  @ResponseBody
  public void query() {
    // Mongodb update 只能一条一条更新，即满足相同条件是，它只会更新一条
    UUID id = UUID.randomUUID();
    Query query = new Query();
    int i = new Random().nextInt(9);
    System.out.println(i);
    query.addCriteria(Criteria.where("name").is("司法局33"));
    Update update = Update.update("age", 888);
    // 先query 存在则update
    UpdateResult mongodbTest = mongoTemplate.upsert(query, update, "MongodbTest");
    System.out.println("c成功");
  }
}
