package com.example.demo.controle;

import com.example.demo.Article;
import com.example.demo.ArticleJson;
import com.example.demo.ArticleJson;
import com.example.demo.response.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Slf4j
@RestController
@RequestMapping("/rest")
class ArticleJsoneRestController {


    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article article) {

        log.info("saveArticle：++{}",article);
        return  AjaxResponse.success(article);
    }

    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}",id);
        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }


    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public  AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }


}
