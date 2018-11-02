package br.ufrgs.foodbook.controller;

import br.ufrgs.foodbook.dto.user.UserRegistrationData;
import br.ufrgs.foodbook.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

@RestController
@RequestMapping("/secured/user")
public class UserInformationController extends AbstractGenericController
{
    @Resource
    private UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Principal get(Principal principal) {
        return principal;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity create(@RequestBody UserRegistrationData user) {
        userService.registerNewUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
