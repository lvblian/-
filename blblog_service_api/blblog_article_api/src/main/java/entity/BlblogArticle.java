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
 * 文章
 * </p>
 *
 * @author lbl
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_article")
public class BlblogArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
    private Long id;

    /**
     * 专栏ID
     */
    @TableField("columnid")
    private String columnid;

    /**
     * 用户ID
     */
    @TableField("userid")
    private String userid;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 文章正文
     */
    @TableField("content")
    private String content;

    /**
     * 文章封面
     */
    @TableField("image")
    private String image;

    /**
     * 是否公开
     */
    @TableField("ispublic")
    private String ispublic;

    /**
     * 是否置顶
     */
    @TableField("istop")
    private String istop;

    /**
     * 浏览量
     */
    @TableField("visits")
    private Integer visits;

    /**
     * 点赞数
     */
    @TableField("thumbup")
    private Integer thumbup;

    /**
     * 评论数
     */
    @TableField("comment")
    private Integer comment;

    /**
     * 审核状态
     */
    @TableField("state")
    private String state;

    /**
     * 所属频道
     */
    @TableField("channelid")
    private String channelid;

    /**
     * URL
     */
    @TableField("url")
    private String url;

    /**
     * 类型
     */
    @TableField("type")
    private String type;

    /**
     * 修改日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

    /**
     * 发表日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 逻辑删除 1已删除 0未删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


}
