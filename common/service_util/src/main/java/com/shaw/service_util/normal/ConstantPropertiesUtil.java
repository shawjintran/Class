package com.shaw.service_util.normal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
public class ConstantPropertiesUtil implements InitializingBean {


	private String region="ap-shanghai";


	private String secretId="AKIDzvjKpJer3EKNNgxCXqysa5OTKzRhqmVd";


	private String secretKey="1rVxBB2rZ7TtLl4MTQClDcpty1ub5Nfo";


	private String bucketName="tran-1313418796";

	public static String END_POINT;
	public static String ACCESS_KEY_ID;
	public static String ACCESS_KEY_SECRET;
	public static String BUCKET_NAME;

	@Override
	public void afterPropertiesSet() throws Exception {
		END_POINT = region;
		ACCESS_KEY_ID = secretId;
		ACCESS_KEY_SECRET = secretKey;
		BUCKET_NAME = bucketName;
	}
}
