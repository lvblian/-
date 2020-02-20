package advice;

import exception.BlblogException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vo.ExceptionResult;

@ControllerAdvice
public class CommonExceptionHandle {
    @ExceptionHandler(BlblogException.class)
    //自己封装一个异常类，继承runtimeException,然后这个类的类型是我们自己定义的枚举，从而可以拿到这个枚举的code，然后创建一个异常返回结果，给body
    public ResponseEntity<ExceptionResult> handleException(BlblogException e) {
        return ResponseEntity.status(e.getExceptionEnum().getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}
