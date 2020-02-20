package entity;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public Result(boolean flag, Integer code, String message, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
