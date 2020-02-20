package feign;

import entity.BlblogUser;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user")
@RequestMapping("/user")
public interface UserFeign {
    @GetMapping("/load/{username}")
    BlblogUser findByLoginname(@PathVariable(value = "username") String username);
}
