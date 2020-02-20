package vo;

import enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timeStamp;
    public ExceptionResult(ExceptionEnum exceptionEnum) {
        this.message = exceptionEnum.getMes();
        this.status = exceptionEnum.getCode();
        this.timeStamp = System.currentTimeMillis();
    }
}

