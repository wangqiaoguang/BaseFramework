package com.jeff.baselibrary.ico;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: ViewById
 * @Description: 绑定ID
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 17:34
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 17:34
 * @UpdateRemark:
 * @Version:
 */
// @Target 代表Annotation的位置，FIELD属性，TYPE类，CONSTRUCTOR构造函数
@Target(ElementType.FIELD)
// 什么时候生效 CLASS 编译时  RUNTIME运行时  SOURCE 源码资源
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewById {

    int value();
}
