package ty0207.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ty0207.example.demo.dao.ActivityDao;
import ty0207.example.demo.dao.UserDao;
import ty0207.example.demo.dto.JWTResponse;
import ty0207.example.demo.dto.LoginRequest;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.User;
import ty0207.example.demo.exception.exceptions.CustomizeException;

import java.util.List;

@RestController
@RequestMapping("/Test")
@Api("关于RMP使用demo")
public class TestController {
  @Autowired
  private UserDao userDao;
  @Autowired
  private ActivityDao activityDao;
  @ApiOperation(value = "无级联数据的增加操作", notes = "")
  @RequestMapping(value = "/addUser", method = { RequestMethod.POST, RequestMethod.OPTIONS }, produces = "application/json;charset=UTF-8")
  public User login(@RequestBody User user) {
    return userDao.createUser(user);
  }
  @ApiOperation(value = "有级联联数据的增加操作", notes = "")
  @RequestMapping(value = "/addActivity", method = { RequestMethod.POST, RequestMethod.OPTIONS }, produces = "application/json;charset=UTF-8")
  public Activity exceptionURL(@RequestBody Activity activity) {
    return activityDao.createActivity(activity);
  }

  @ApiOperation(value = "按照条件进行查找", notes = "债权人行为或律师行为")
  @ApiResponses({
      @ApiResponse(code = 200, message = "ok", response = JWTResponse.class)
  })
  @RequestMapping(value = "/find", method = { RequestMethod.GET, RequestMethod.OPTIONS }, produces = "application/json;charset=UTF-8")
  public List<User> annotationExample(@RequestParam String name) {
    return userDao.findByName(name);
  }

  @ApiOperation(value = "扫描数据库全部数据", notes = "债权人行为或律师行为")
  @ApiResponses({
          @ApiResponse(code = 200, message = "ok", response = JWTResponse.class)
  })
  @RequestMapping(value = "/findAll", method = { RequestMethod.GET, RequestMethod.OPTIONS }, produces = "application/json;charset=UTF-8")
  public List<User> annotationExample1() {
    return userDao.findAll();
  }
  @ApiOperation(value = "对数据进行修改", notes = "债权人行为或律师行为")
  @ApiResponses({
          @ApiResponse(code = 200, message = "ok", response = JWTResponse.class)
  })
  @RequestMapping(value = "/modify", method = { RequestMethod.POST, RequestMethod.OPTIONS }, produces = "application/json;charset=UTF-8")
  public boolean annotationExample3(@RequestBody User user) {
    return userDao.modifyUser(user);
  }
}
