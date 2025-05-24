package biz.xcompany.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping({"api/v2/core"})
public class TestController {

    private final UserRepository repository;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        List<User> userList = repository.findAllWithRoles();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
