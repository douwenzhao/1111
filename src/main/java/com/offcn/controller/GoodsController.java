package com.offcn.controller;

import com.offcn.pojo.TbGoods;
import com.offcn.properties.CompanyProperties;
import com.offcn.properties.CourseProperties;
import com.offcn.service.TbGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

////开启配置参数类
//@EnableConfigurationProperties({CompanyProperties.class}) 放在这里，只能是当前controller可以使用CompanyProperties中的参数
@RestController
//@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    TbGoodsService goodsService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //    @RequestMapping(value = "/goods" , method = RequestMethod.GET)
    @GetMapping("/goods")
    public List<TbGoods> goodsList(){

        redisTemplate.boundValueOps("count1").set(100);
        stringRedisTemplate.boundListOps("count2").leftPush("abc");
        stringRedisTemplate.boundListOps("count2").leftPushAll("bcd","qqq","6666");

        return goodsService.goodsList();
    }

    @Value("${spring.redis.port}")
    String redisPort;

    @Value("${java0824.stuname1}")
    String stu1;

    @Autowired
    CompanyProperties companyProperties;

    @Autowired
    CourseProperties courseProperties;

    @GetMapping("/demo2")
    public String demo2(){
        return redisPort + stu1 + "," + companyProperties + "," + courseProperties;
    }


}
