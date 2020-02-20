package exception;

import enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BlblogException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
