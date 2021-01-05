package com.zcy.party.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcy.party.dao.OrganizationerMapper;
import com.zcy.party.dao.SubjectProblemMapper;
import com.zcy.party.domain.*;
import com.zcy.party.server.PaperServer;
import com.zcy.party.server.impl.PaperServerImpl;
import com.zcy.party.server.impl.StuAnswerServerImpl;
import com.zcy.party.server.impl.StudentServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@Controller
public class TeacherController {
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Autowired
    PaperServerImpl paperServer;
    @Autowired
    SubjectProblemMapper subjectProblemMapper;
    @Autowired
    StudentServerImpl studentServer;
    @Autowired
    StuAnswerServerImpl stuAnswerServer;

    @CrossOrigin
    @RequestMapping(value = "/api/getAllAnswer",method = RequestMethod.GET)
    public Object getAllAnswer(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        List<StuAnswer> list = stuAnswerServer.getAllAnswer();
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<list.size();i++){
            jsonArray.add(list.get(i));
        }
        jsonObject.put("info",jsonArray);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getAnswerById",method = RequestMethod.GET)
    public Object getAnswerById(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id").toString());
        StuAnswer stuAnswer = stuAnswerServer.getAnswerById(id);
        jsonObject.put("info",stuAnswer);
        return jsonObject;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getTeacherInfo",method = RequestMethod.GET)
    public Object getTeacherInfo(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        Organizationer organizationer = organizationerMapper.getOrganizationInfoById(id);
        jsonObject.put("info",organizationer);
        return jsonObject;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getPaperInfoByCreatorId",method = RequestMethod.GET)
    public Object getPaperInfoByCreatorId(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String s = request.getParameter("id");
        List<Paper> list = paperServer.getPaperByCreatorId(Integer.parseInt(s));
        class Datatype{
            int id;
            String name;
            String creator;
            String createTime;
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getCreator() {
                return creator;
            }
            public void setCreator(String creator) {
                this.creator = creator;
            }
            public String getCreateTime() {
                return createTime;
            }
            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
        for(int i=0;i<list.size();i++){
            Datatype datatype =new Datatype();
            datatype.setId(list.get(i).getId());
            datatype.setName(list.get(i).getName());
            datatype.setCreator(list.get(i).getCreator());
            datatype.setCreateTime(list.get(i).getCreateTime());
            jsonArray.add(datatype);
        }
        jsonObject.put("paperInfo",jsonArray);
        return jsonObject;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getPaperInfoById",method = RequestMethod.GET)
    public Object getPaperInfoById(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int id = Integer.parseInt(request.getParameter("id"));
        jsonObject.put("paperInfo",paperServer.getPaperInfoById(id));
        return jsonObject;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getAllSubProblem",method = RequestMethod.GET)
    public Object getAllSubProblem(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<SubjectProblem> list = subjectProblemMapper.getAllSubProblem();
        for(int i=0;i<list.size();i++){
            jsonArray.add(list.get(i));
        }
        jsonObject.put("allsubProblem",jsonArray);
        return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/createPaper",method = RequestMethod.POST)
    public Object createPaper(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        JSONObject jsonObject = new JSONObject();
        jsonObject = JSON.parseObject(s);
        int creator = Integer.parseInt(jsonObject.get("creator").toString());
        String name = jsonObject.get("name").toString();
        JSONArray jsonArrayObj = new JSONArray();
        jsonArrayObj = JSONArray.parseArray(jsonObject.get("objProblem").toString());
        JSONArray jsonArraySub = new JSONArray();
        jsonArraySub = JSONArray.parseArray(jsonObject.get("subProblem").toString());
        int i = paperServer.insertPaper(name,creator,Integer.parseInt(jsonArrayObj.get(0).toString()),
                Integer.parseInt(jsonArrayObj.get(1).toString()),Integer.parseInt(jsonArrayObj.get(2).toString()),
                Integer.parseInt(jsonArrayObj.get(3).toString()),Integer.parseInt(jsonArrayObj.get(4).toString()),
                Integer.parseInt(jsonArrayObj.get(5).toString()),Integer.parseInt(jsonArrayObj.get(6).toString()),
                Integer.parseInt(jsonArrayObj.get(7).toString()),Integer.parseInt(jsonArrayObj.get(8).toString()),
                Integer.parseInt(jsonArrayObj.get(9).toString()),Integer.parseInt(jsonArrayObj.get(10).toString()),
                Integer.parseInt(jsonArrayObj.get(11).toString()),Integer.parseInt(jsonArrayObj.get(12).toString()),
                Integer.parseInt(jsonArrayObj.get(13).toString()),Integer.parseInt(jsonArrayObj.get(14).toString()),
                Integer.parseInt(jsonArrayObj.get(15).toString()),Integer.parseInt(jsonArrayObj.get(16).toString()),
                Integer.parseInt(jsonArrayObj.get(17).toString()),Integer.parseInt(jsonArrayObj.get(18).toString()),
                Integer.parseInt(jsonArrayObj.get(19).toString()),Integer.parseInt(jsonArraySub.get(0).toString()),
                Integer.parseInt(jsonArraySub.get(1).toString()),Integer.parseInt(jsonArraySub.get(2).toString()),
                Integer.parseInt(jsonArraySub.get(3).toString()),Integer.parseInt(jsonArraySub.get(4).toString())
                );
        JSONObject jsonObject1 = new JSONObject();
        if(i>0) jsonObject1.put("code",200);
        else jsonObject1.put("code",400);
        return jsonObject1;
    }

    @CrossOrigin
    @RequestMapping(value = "api/getAllstuByTeacherId",method = RequestMethod.GET)
    public Object getAllstuByTeacherId(HttpServletRequest request){
         String s = request.getParameter("id");
         List<Student> students = studentServer.getStuByTeacherId(Integer.parseInt(s));
         JSONArray jsonArray = new JSONArray();
         for(int i=0;i<students.size();i++){
             jsonArray.add(students.get(i));
         }
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("studentInfo",jsonArray);
         return jsonObject;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/addStudentPaper",method = RequestMethod.POST)
    public Object addStudentPaper(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        JSONObject jsonObject = new JSONObject();
        jsonObject = JSON.parseObject(s);
        int paperid = Integer.parseInt(jsonObject.get("paperId").toString());
        JSONArray jsonArray = new JSONArray();
        jsonArray = JSONArray.parseArray(jsonObject.get("stuIds").toString());
        int result = 0;
        for(int i=0;i<jsonArray.size();i++){
            result += studentServer.sendPaperToStudent(jsonArray.get(i).toString(),paperid);
        }
        JSONObject jsonObject1 = new JSONObject();
        if(result==jsonArray.size())
            jsonObject1.put("code",200);
        else jsonObject1.put("code",400);
        return jsonObject1;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/insertSubGrade",method = RequestMethod.POST)
    public Object insertSubGrade(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        JSONObject jsonObject = new JSONObject();
        jsonObject = JSON.parseObject(s);
        int id = Integer.parseInt(jsonObject.get("id").toString());
        float subGrade = Float.parseFloat(jsonObject.get("subGrade").toString());
        int i =stuAnswerServer.insertSubGrade(id,subGrade);
        JSONObject jsonObject1 = new JSONObject();
        if(i>0) jsonObject1.put("code",200);
        else jsonObject1.put("code",400);
        return jsonObject1;
    }
}
