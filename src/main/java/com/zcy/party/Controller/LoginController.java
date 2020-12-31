package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zcy.party.domain.Login;
import com.zcy.party.domain.User;
import com.zcy.party.server.impl.LoginServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Controller

public class LoginController {
    @Autowired
    LoginServerImpl loginServer;
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public Object verifylogin(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        Login login = new Login();
        login.setId(request.getParameter("username"));
        login.setPass(request.getParameter("password"));
        login.setType(Integer.parseInt(request.getParameter("type")));
        int res = loginServer.verifyAccount(login);
        if(res==1){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "管理员登录成功");
            session.setAttribute("name", login.getId());
        }
        else if(res==2){
            jsonObject.put("code", 3);
            jsonObject.put("msg", "学生登录成功");
            session.setAttribute("name", login.getId());
        }
        else if(res==3){
            jsonObject.put("code", 2);
            jsonObject.put("msg", "教师登录成功");
            session.setAttribute("name", login.getId());
        }
        else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
        }
        return jsonObject;
    }
}
