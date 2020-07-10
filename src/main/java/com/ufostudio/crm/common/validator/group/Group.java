package com.ufostudio.crm.common.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @Author: LCF
 * @Date: 2020/7/5 18:20
 * @Package: com.ufostudio.crm.common.validator.group
 */

@GroupSequence ({AddGroup.class, UpdateGroup.class})
public interface Group {
}
