package com.springboot.blogproject.Controller;
import com.springboot.blogproject.Payload.Apiresponse;
import com.springboot.blogproject.Payload.UserDto;
import com.springboot.blogproject.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>>  getalluser( UserDto userDto){
       List< UserDto> userDtos=userService.getAllUser(userDto);
        return  ResponseEntity.ok(userDtos) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto>  getUserById( @PathVariable int id){
       UserDto userDto = userService.getUserbyId(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<String> PostData(@Valid   @RequestBody UserDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity<>(
                "user Added suusescfuuly", HttpStatus.CREATED
        ) ;
    }


    @PutMapping(path = "/{id}")
    public  ResponseEntity<UserDto> UpdateData(@PathVariable int id, @Valid @RequestBody  UserDto userDto){
        UserDto userDto1=userService.updateUser(userDto,id);
        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @GetMapping(path = "/search/{name}")
   public ResponseEntity<List<UserDto>> SearchByName(@PathVariable String  name){
        List<UserDto> userDtos=userService.searchByName(name);
        return ResponseEntity.ok(userDtos);
    }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Apiresponse>  DeleteUser(@PathVariable int id){
        userService.deleteUser(id);

        return new ResponseEntity<Apiresponse>(new Apiresponse("user Deleted SuccesFully",true),HttpStatus.OK);


    }





}
