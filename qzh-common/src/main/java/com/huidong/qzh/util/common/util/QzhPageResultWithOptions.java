package com.huidong.qzh.util.common.util;

import java.util.List;

public class QzhPageResultWithOptions extends QzhPageResult {
    /**
     * 可选参数
     */
    private Object options;

    private QzhPageResultWithOptions(long pageSize, long pageNo, long totalPage, List<?> list, Object options) {
        super(pageSize, pageNo, totalPage, list);
        this.options = options;
    }

    public static QzhPageResultWithOptions build(long pageSize, long pageNo, long totalPage, List<?> list, Object options) {
        return new QzhPageResultWithOptions(pageSize, pageNo, totalPage, list, options);
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }
}
