package entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:OauthClientDetails构建
 * @Date 2019/6/14 19:13
 *****/
@TableName("oauth_client_details")
@Data
public class OauthClientDetails implements Serializable{

	@TableId("clientId")
	private String clientId;//客户端ID，主要用于标识对应的应用

	@TableField("resourceIds")
	private String resourceIds;//

	@TableField("clientSecret")
	private String clientSecret;//客户端秘钥，BCryptPasswordEncoder加密算法加密

	@TableField("scope")
	private String scope;//对应的范围

	@TableField("authorizedGrantTypes")
	private String authorizedGrantTypes;//认证模式

	@TableField("webServerRedirectUri")
	private String webServerRedirectUri;//认证后重定向地址

	@TableField("authorities")
	private String authorities;//

	@TableField("accessTokenValidity")
	private Integer accessTokenValidity;//令牌有效期

	@TableField("refreshTokenValidity")
	private Integer refreshTokenValidity;//令牌刷新周期

	@TableField("additionalInformation")
	private String additionalInformation;//

	@TableField("autoapprove")
	private String autoapprove;//


}
