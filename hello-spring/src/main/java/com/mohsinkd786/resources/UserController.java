package com.mohsinkd786.resources;

import com.mohsinkd786.dtos.UserDto;
import com.mohsinkd786.request.UserRequest;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/v1/users")
@RestController
public class UserController {

    private List<UserDto> userDtos = new ArrayList<>();

    @GetMapping
    public List<UserDto> findUsers(){
        return userDtos;
    }

    @PostMapping
    public UserDto save(@RequestBody UserRequest request){
        UserDto userDto = toUserDto(request);
        userDtos.add(userDto);
        return userDto;
    }

    @GetMapping("{id}")
    public UserDto findById(@PathVariable String id){
        Optional<UserDto> userDto = userDtos.stream().filter(u-> u.getId().equals(id)).findFirst();
        return userDto.isPresent() ? userDto.get() : null;
    }

    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable String id){
        UserDto userDto = findById(id);
        if (Objects.nonNull(userDto)) {
            userDtos.remove(userDto);
            return true;
        }else {
            return false;
        }
    }

    private static UserDto toUserDto(UserRequest request){
        UserDto userDto = new UserDto();
        userDto.setName(request.getFirstName() + " "+request.getLastName());
        userDto.setEmail(request.getEmail());
        return userDto;
    }
}
