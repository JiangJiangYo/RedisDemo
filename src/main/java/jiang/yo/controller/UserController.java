package jiang.yo.controller;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jiang.yo.entity.UserDto;

public class UserController {

    public static void main(String[] args) {
        UserDto.UserInfo userInfo = new UserDto.UserInfo();
        userInfo.setAge(10);
        userInfo.setName("张三");
        UserDto dto = new UserDto("vin", userInfo);


        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);


            System.out.println("json = " + json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

}
