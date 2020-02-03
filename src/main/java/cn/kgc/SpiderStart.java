package cn.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot启动类
 *
 * @Author lx
 * @date 13:27
 */
@SpringBootApplication
@MapperScan("cn.kgc.mapper")
public class SpiderStart {

    public static void main(String[] args) {
        SpringApplication.run(SpiderStart.class,args);
    }
}
