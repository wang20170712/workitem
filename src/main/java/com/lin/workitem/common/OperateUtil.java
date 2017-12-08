package com.lin.workitem.common;


import org.apache.commons.lang3.StringUtils;

public class OperateUtil {

    /**
     * 封装接口返回数据
     * @param result
     * @return
     */
    public static AjaxResult returnObj(String result) {
      if (StringUtils.isBlank(result)) {
            return new AjaxResult();
        }
        return new AjaxResult(result);
    }
}
