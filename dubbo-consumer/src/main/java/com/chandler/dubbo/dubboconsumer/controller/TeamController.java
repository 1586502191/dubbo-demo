package com.chandler.dubbo.dubboconsumer.controller;

import com.chandler.dubbo.dubboconsumer.service.TeamService;
import com.chandler.dubbo.entity.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class TeamController {
    /**
     * 相当于Autowired,有部分差别；
     * @Autowired注解是按类型装配依赖对象，默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它required属性为false。
     * @Resource注解和@Autowired一样，也可以标注在字段或属性的setter方法上，但它默认按名称装配。名称可以通过@Resource的name
     *   属性指定，如果没有指定name属性，当注解标注在字段上，即默认取字段的名称作为bean名称寻找依赖对象，当注解标注在属性的setter方法上，
     *   即默认取属性名作为bean名称寻找依赖对象。 @Resources按名字，是ＪＤＫ的，@Autowired按类型，是Ｓｐｒｉｎｇ的。
     * 实际开发中的区别不大
     */
    @Resource
    private TeamService teamService;
    @GetMapping("/getTeam")
    public Team getTeam(@RequestParam("cityName") String cityName){
        return teamService.getTeam(cityName);
    }
}
