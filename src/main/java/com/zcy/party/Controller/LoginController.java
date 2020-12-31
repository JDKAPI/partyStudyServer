package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zcy.party.domain.Login;
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
        boolean res = loginServer.verifyAccount(login);
        if(res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", login.getId());
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
        }
        return jsonObject;
    }
}
