package entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author lbl
 * @since 2020-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_user")
public class BlblogUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
    private Long id;

    /**
     * 昵称
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 出生年月日
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 手机号码
     */
    @TableField("mobile")
    private String mobile;

    /**
     * E-Mail
     */
    @TableField("email")
    private String email;

    /**
     * 最后登陆日期
     */
    @TableField("lastdate")
    private Date lastdate;

    /**
     * 在线时长（分钟）
     */
    @TableField("online")
    private Long online;

    /**
     * 兴趣
     */
    @TableField("interest")
    private String interest;

    /**
     * 个性
     */
    @TableField("personality")
    private String personality;

    /**
     * 粉丝数
     */
    @TableField("fanscount")
    private Integer fanscount;

    /**
     * 关注数
     */
    @TableField("followcount")
    private Integer followcount;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

    /**
     * 注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 逻辑删除 1已删除 0未删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


}
