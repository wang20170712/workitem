package com.lin.workitem.controller;

import com.alibaba.fastjson.JSONObject;
import com.lin.workitem.common.AjaxResult;
import com.lin.workitem.common.ConstantsUtil;
import com.lin.workitem.common.OperateUtil;
import com.lin.workitem.model.User;
import com.lin.workitem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json"})
    public int addUser(User user){
        return userService.add(user);
    }
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object selectAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.selectAllUser(pageNum,pageSize);
    }

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }


    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping(value = "/loginPost")
    @ResponseBody
    public AjaxResult toIndex(User user,String vcode,HttpServletRequest request){

       String verifyCode = (String) request.getSession().getAttribute(ConstantsUtil.VERIFY_CODE);
       if(StringUtils.isBlank(verifyCode) || !verifyCode.equalsIgnoreCase(vcode)){
           return OperateUtil.returnObj(ConstantsUtil.VERIFY_CODE_ERROR);
       }else {
           User userInfo = userService.selectByName(user.getUserName());
           if(userInfo != null){
               if (user.getPassword().equals(userInfo.getPassword())){
                   request.getSession().setAttribute("user",userInfo);
                   return OperateUtil.returnObj(ConstantsUtil.SUCCESS);
               }else{
                   return OperateUtil.returnObj(ConstantsUtil.ERROR);
               }
           }else {
               return OperateUtil.returnObj(ConstantsUtil.USERNAME_NOT_EXIST);
           }
       }

       /* String str = "{\"result\":\"success\",\"message\":\"成功！\",\"data\":[{\"name\":\"Tom\",\"age\":\"20\"}]}";
        JSONObject json = JSONObject.parseObject(str);
        return json;*/
    }

    @RequestMapping("/main")
    public String main(){
        return "h_ui/index";
    }
}
