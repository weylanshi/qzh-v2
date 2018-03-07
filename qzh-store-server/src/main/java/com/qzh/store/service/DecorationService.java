package com.qzh.store.service;

public interface DecorationService {
    /**
     *
     * 备份店铺模板
     * @param accountId    装修者ID
     * @param memberId     装修者公司Id
     * @param leftSort     左边装修模块的顺序     例如 'customer,search,category,ranking'
     * @param rightSort    右边装修模块的顺序
     * @return
     */
    String  insertDecoration(Integer accountId,Integer memberId,String leftSort,String rightSort,Integer decorationId);
    /**
     * 发布店铺模板
     * @param isPublish  是否发布
     */
    void updateDecoration(Integer isPublish,Integer decorationId);
}
