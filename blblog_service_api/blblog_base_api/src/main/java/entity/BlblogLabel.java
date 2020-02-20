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
 * 标签
 * </p>
 *
 * @author lbl
 * @since 2020-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_label")
public class BlblogLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    @TableId("id")
    private Long id;

    /**
     * 标签名称
     */
    @TableField("labelname")
    private String labelname;

    /**
     * 状态
     */
    @TableField("state")
    private String state;

    /**
     * 使用数量
     */
    @TableField("count")
    private Long count;

    /**
     * 是否推荐
     */
    @TableField("recommend")
    private String recommend;

    /**
     * 粉丝数
     */
    @TableField("fans")
    private Long fans;

    /**
     * 父标签ID
     */
    @TableField("pid")
    private String pid;

    /**
     * 注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;


}
