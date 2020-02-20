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
 * 城市
 * </p>
 *
 * @author lbl
 * @since 2020-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_city")
public class BlblogCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("id")
    private Long id;

    /**
     * 城市名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否热门
     */
    @TableField("ishot")
    private String ishot;

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
