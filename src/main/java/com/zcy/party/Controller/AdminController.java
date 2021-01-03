package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zcy.party.domain.Organizationer;
import com.zcy.party.server.impl.AdminServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Stream;

@RestController
@Controller
public class AdminController {
    @Autowired
    AdminServerImpl adminServer;
    @CrossOrigin
    @RequestMapping(value = "/api/getAllTeacherInfo",method = RequestMethod.GET)
    public Object getAllTeacherInfo(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Organizationer> list = adminServer.getAllOrganizationer();
        for(int i=0;i<list.size();i++){
            jsonArray.add(list.get(i));
        }
        jsonObject.put("teacherInfo",jsonArray);
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/updateTeacherInfo",method = RequestMethod.POST)
    public Object updateTeacherInfo(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(s);
        Organizationer organizationer = new Organizationer();
        organizationer.setSchool(jsonObject.get("school").toString());
        organizationer.setOrmem_acc(jsonObject.get("ormem_acc").toString());
        organizationer.setOrmem_name(jsonObject.get("ormem_name").toString());
        organizationer.setOrmem_pass(jsonObject.get("ormem_pass").toString());
        int i = adminServer.updateInfo(organizationer);
        JSONObject jsonObject1 = new JSONObject();
        if(i>0){
            jsonObject1.put("code","true");
        }
        else{
            jsonObject1.put("code","false");
        }
        return jsonObject1;
    }
}
