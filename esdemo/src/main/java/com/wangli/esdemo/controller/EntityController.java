package com.wangli.esdemo.controller;

import com.wangli.esdemo.entity.Entity;
import com.wangli.esdemo.service.TestService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangli
 */
@RestController
@RequestMapping("/entityController")
public class EntityController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(Long id, String name) {
        System.out.println("save 接口");
        if (id>0 && StringUtils.isNotEmpty(name)) {
            Entity entity = new Entity(id, name);
            List<Entity> list = new ArrayList<>();
            list.add(entity);
            testService.saveEntity(list);
            return "OK!";
        } else {
            return "Bad Input Value";
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Entity> save(String name) {
        List<Entity> entityList = null;
        if (StringUtils.isNotEmpty(name)) {
            entityList = testService.searchEntity(name);
        }
        return entityList;
    }
}
