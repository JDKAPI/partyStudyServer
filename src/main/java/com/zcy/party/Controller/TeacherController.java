package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcy.party.dao.OrganizationerMapper;
import com.zcy.party.domain.Organizationer;
import com.zcy.party.domain.Paper;
import com.zcy.party.server.PaperServer;
import com.zcy.party.server.impl.PaperServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Controller
public class TeacherController {
    @Autowired
    OrganizationerMapper organizationerMapper;
    @Autowired
    PaperServerImpl paperServer;
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
}
