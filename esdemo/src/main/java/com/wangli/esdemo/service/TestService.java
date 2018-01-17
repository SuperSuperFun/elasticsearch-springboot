package com.wangli.esdemo.service;

import com.wangli.esdemo.entity.Entity;

import java.util.List;

/**
 * @author wangli
 */
public interface TestService {
    void saveEntity(Entity entity);

    void saveEntity(List<Entity> entityList);

    List<Entity> searchEntity(String searchContent);
}
