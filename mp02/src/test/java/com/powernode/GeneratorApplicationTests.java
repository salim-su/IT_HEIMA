package com.powernode;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class GeneratorApplicationTests {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatisplus?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("powernode") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.powernode") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("powershop_user") // 设置需要生成的表名
                            .addTablePrefix("powershop"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
    }

