package com.yxhl.stationbiz.system.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * OSS 参数配置类
 * @author lw
 *
 */
@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class OSSConfig {
	private String endpoint;
	private String osswebsite;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String testBucket;
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getOsswebsite() {
		return osswebsite;
	}
	public void setOsswebsite(String osswebsite) {
		this.osswebsite = osswebsite;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getTestBucket() {
		return testBucket;
	}
	public void setTestBucket(String testBucket) {
		this.testBucket = testBucket;
	} 
}
