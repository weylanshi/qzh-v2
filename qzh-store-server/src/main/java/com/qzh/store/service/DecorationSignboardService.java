package com.qzh.store.service;

import com.qzh.store.entity.DecorationSignboard;

public interface DecorationSignboardService {

    /**
     * 根据 店铺 memberId  获得店铺招牌信息
     * */
    DecorationSignboard getDecorationSign(Integer memberId);

    /**
     * 保存店铺招牌信息
     * */
    Integer doSaveSignboardInfo(DecorationSignboard decorationSignboard);
}
