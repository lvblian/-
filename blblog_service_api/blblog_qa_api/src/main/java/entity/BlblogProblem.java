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
 * 问题
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_problem")
public class BlblogProblem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
    private Long id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 修改日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

    /**
     * 用户ID
     */
    @TableField("userid")
    private Long userid;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 浏览量
     */
    @TableField("visits")
    private Long visits;

    /**
     * 点赞数
     */
    @TableField("thumbup")
    private Long thumbup;

    /**
     * 回复数
     */
    @TableField("reply")
    private Long reply;

    /**
     * 是否解决
     */
    @TableField("solve")
    private String solve;

    /**
     * 回复人昵称
     */
    @TableField("replyname")
    private String replyname;

    /**
     * 回复日期
     */
    @TableField("replytime")
    private Date replytime;

    /**
     * 逻辑删除 1已删除 0未删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


}
