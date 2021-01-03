package com.zcy.party.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zcy.party.domain.ObjectProblem;
import com.zcy.party.domain.Organizationer;
import com.zcy.party.domain.Student;
import com.zcy.party.server.impl.AdminServerImpl;
import com.zcy.party.server.impl.ObjectProblemServerImpl;
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
    @Autowired
    ObjectProblemServerImpl objectProblemServer;
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
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/deleteTeacher",method = RequestMethod.POST)
    public Object deleteTeacher(HttpServletRequest request) throws IOException {
        JSONObject jsonObject =new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSONObject.parseObject(s);
        adminServer.deleteTeacher(jsonObject.get("account").toString());
        jsonObject.put("code","200");
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/insertTeacher",method = RequestMethod.POST)
    public Object insertTeacher(HttpServletRequest request) throws IOException {
        JSONObject jsonObject =new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSONObject.parseObject(s);
        Organizationer organizationer = new Organizationer();
        organizationer.setOrmem_acc(jsonObject.get("acc").toString());
        organizationer.setOrmem_pass(jsonObject.get("pass").toString());
        organizationer.setOrmem_name(jsonObject.get("name").toString());
        organizationer.setSchool(jsonObject.get("school").toString());
        adminServer.insertTeacher(organizationer);
        jsonObject.put("code","200");
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/deleteStudent",method = RequestMethod.POST)
    public Object deleteStudent(HttpServletRequest request) throws IOException {
        JSONObject jsonObject =new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSONObject.parseObject(s);
        int i = adminServer.deleteStudent(jsonObject.get("id").toString());
        JSONObject jsonObject1 =new JSONObject();
        if(i>0) jsonObject1.put("code","200");
        else jsonObject1.put("code",400);
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/updateStudent",method = RequestMethod.POST)
    public Object updateStudent(HttpServletRequest request) throws IOException {
        JSONObject jsonObject =new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSONObject.parseObject(s);
        System.out.println(s);
       int i = adminServer.updateStudent(jsonObject.get("id").toString(),
               jsonObject.get("pass").toString(),
               jsonObject.get("name").toString(),
               jsonObject.get("grade").toString(),jsonObject.get("major").toString(),Integer.parseInt(jsonObject.get("school").toString()));
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/insertStudent",method = RequestMethod.POST)
    public Object insertStudent(HttpServletRequest request) throws IOException {
        JSONObject jsonObject =new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSONObject.parseObject(s);
        Student student = new Student();
        student.setStu_id(jsonObject.get("id").toString());
        student.setStu_pass(jsonObject.get("pass").toString());
        student.setStu_name(jsonObject.get("name").toString());
        student.setStu_grade(jsonObject.get("grade").toString());
        student.setStu_school(jsonObject.get("school").toString());
        student.setMajor(jsonObject.get("major").toString());
        adminServer.insertStudent(student);
        jsonObject.put("code","200");
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/updateObjProblem",method=RequestMethod.POST)
    public Object  updateObjProblem(HttpServletRequest request) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSON.parseObject(s);
        ObjectProblem objectProblem = new ObjectProblem();
        objectProblem.setObjectpro_id(Integer.parseInt(jsonObject.get("id").toString()));
        objectProblem.setObjectpro_A(jsonObject.get("a").toString());
        objectProblem.setObjectpro_com(jsonObject.get("com").toString());
        objectProblem.setObjectpro_B(jsonObject.get("b").toString());
        objectProblem.setObjectpro_C(jsonObject.get("c").toString());
        objectProblem.setObjectpro_D(jsonObject.get("d").toString());
        objectProblem.setObjectpro_ans(jsonObject.get("ans").toString());
        int i = objectProblemServer.updateObjProblem(objectProblem);
        JSONObject jsonObject1 = new JSONObject();
        if(i>0){
            jsonObject1.put("code",200);
        }
        else{
            jsonObject1.put("code",400);
        }
        return jsonObject1;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/deleteProblem",method=RequestMethod.GET)
    public Object deleteProblem(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int i = objectProblemServer.deleteProblem(Integer.parseInt(request.getParameter("id")));
        if(i>0) jsonObject.put("code",200);
        else jsonObject.put("code",400);
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/insertProblem",method=RequestMethod.POST)
    public Object  insertProblem(HttpServletRequest request) throws IOException {
        JSONObject jsonObject = new JSONObject();
        String s = StreamUtils.copyToString(request.getInputStream(),Charset.forName("UTF-8"));
        jsonObject = JSON.parseObject(s);
        ObjectProblem objectProblem = new ObjectProblem();
        objectProblem.setObjectpro_A(jsonObject.get("a").toString());
        objectProblem.setObjectpro_com(jsonObject.get("com").toString());
        objectProblem.setObjectpro_B(jsonObject.get("b").toString());
        objectProblem.setObjectpro_C(jsonObject.get("c").toString());
        objectProblem.setObjectpro_D(jsonObject.get("d").toString());
        objectProblem.setObjectpro_ans(jsonObject.get("ans").toString());
        int i = objectProblemServer.insertProblem(objectProblem);
        JSONObject jsonObject1 = new JSONObject();
        if(i>0){
            jsonObject1.put("code",200);
        }
        else{
            jsonObject1.put("code",400);
        }
        return jsonObject1;
    }
}
