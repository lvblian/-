package entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lbl
 * @since 2020-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blblog_pl")
public class BlblogPl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题ID
     */
    @TableId("problemid")
    private Long problemid;

    /**
     * 标签ID
     */
    @TableField("labelid")
    private Long labelid;


}
