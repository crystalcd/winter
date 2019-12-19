package com.anpai.winter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;


/**
 * @Author: crystalcd
 * @Description:
 * @Date: 2019/12/1 下午8:06
 */
public class PropsUtil {
    private static final Logger log = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String propsPath) {
        Properties props = new Properties();
        InputStream is = null;
        try {
            if (propsPath == null || propsPath.length() == 0) {
                throw new IllegalArgumentException();
            }
            String suffix = ".properties";
            if (propsPath.lastIndexOf(suffix) == -1) {
                propsPath += suffix;
            }
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propsPath);
        }
    }

}
