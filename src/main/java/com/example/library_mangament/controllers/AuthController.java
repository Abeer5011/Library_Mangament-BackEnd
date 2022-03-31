package com.example.library_mangament.controllers;
import com.example.library_mangament.modals.ResponseApi;
import com.example.library_mangament.modals.User;
import com.example.library_mangament.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/auth/")
@CrossOrigin(origins = "*")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("users")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body( authService.getUsers());
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid User user, Errors errors){
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authService.register(user);
        if (errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError());
        }
        ResponseApi responseApi = new ResponseApi("user created", "201");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseApi);
    }

    @PostMapping("login")
    public ResponseEntity login(HttpSession session){

        HashMap hashMap=new HashMap();
        hashMap.put("message", session.getId());
        return ResponseEntity.status(200).body(hashMap);
    }
}
