package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NOLL(400,"查询失败"),
    CATEGORY_CANNOT_BE_FOUND(404,"找不到该分类"),
    SAVE_BRAND_ERROR(500,"新增失败"),
    UPLOAD_ERROR(500,"上传失败"),
    ;
    private int code;
    private String mes;
}
