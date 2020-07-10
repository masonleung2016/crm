package com.ufostudio.crm.common.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: LCF
 * @Date: 2020/7/5 17:58
 * @Package: com.ufostudio.crm.common.utils
 */

public class CollectionsUtils {
    /**
     * 提取集合中的对象的一个属性(通过Getter函数), 组合成List.
     *
     * @param collection   来源集合.
     * @param propertyName 要提取的属性名.
     */
    @SuppressWarnings ("unchecked")
    public static List extractToList(final Collection collection, final String propertyName) {
        List list = new ArrayList(collection.size());
        try {
            for (Object obj : collection) {
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception e) {
            throw Reflections.convertReflectionExceptionToUnchecked(e);
        }
        return list;
    }

    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }
}
