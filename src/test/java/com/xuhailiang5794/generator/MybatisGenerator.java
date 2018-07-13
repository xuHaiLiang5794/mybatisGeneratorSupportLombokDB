package com.xuhailiang5794.generator;

import org.mybatis.generator.api.ShellRunner;

import java.net.URL;

/**
 * <pre>
 *
 * </pre>
 *
 * @author hailiang.xu
 * @version 1.0
 * @since 2018/7/12 17:51
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        URL url = Object.class.getResource("/generator/generatorConfig.xml");

        System.out.println(url.getPath());
        ShellRunner.main(new String[]{"-configfile", url.getPath(), "-overwrite"});
    }
}
