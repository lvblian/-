package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    //总记录数
    private Long total;
    //当前页面的数据列表
    private List<T> rows;
}
