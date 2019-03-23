package com.admn.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyi
 */
public class ConvertUtil {

    /**
     * 对象转换到Map
     * @param obj obj
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

}
