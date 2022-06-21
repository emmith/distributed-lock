import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Generator {
    static String dir = "service-order\\src\\main\\java";

    public static void main(String[] args) {
        FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:postgresql://localhost:5432/postgres", "postgres", "emmith").schema("distributed_lock"))
                .globalConfig(builder -> {
                    builder.author("emmith") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(dir) // 指定输出目录
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir();   //禁止打开输出目录，默认:true
                })
                .packageConfig(builder -> {
                    builder.parent("com.emmith.demo") // 设置父包名
                            .moduleName("serviceorder") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "service-order/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok().disableSerialVersionUID().enableTableFieldAnnotation().fileOverride();
                    builder.mapperBuilder().enableMapperAnnotation().enableBaseResultMap();
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                    builder.addInclude("tbl_order").addTablePrefix("tbl_");// 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
