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
 * 回答
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_reply")
public class BlblogReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId("id")
    private Long id;

    /**
     * 问题ID
     */
    @TableField("problemid")
    private Long problemid;

    /**
     * 回答内容
     */
    @TableField("content")
    private String content;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    /**
     * 更新日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

    /**
     * 回答人ID
     */
    @TableField("userid")
    private Long userid;

    /**
     * 回答人昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 逻辑删除 1已删除 0未删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


}
