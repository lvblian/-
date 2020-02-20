package dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BlblogDto implements Serializable{
    private static final long serialVersionUID = 1L;

    //名称
    private String labelname;
    //粉丝数
    private Long fans;

    /**
     * 注册时间
     */
    private Date createtime;
    /**
     * 更新时间
     */
    private Date updatetime;
}
