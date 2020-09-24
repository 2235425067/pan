package com.hadoop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * HDFS配置类
 * @author linhaiy
 * @date 2019.05.18
 */
@Configuration
public class HdfsConfig {
    private String path="hdfs://119.3.167.84:9000";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
