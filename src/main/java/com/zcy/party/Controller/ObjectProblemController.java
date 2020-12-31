package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zcy.party.domain.ObjectProblem;
import com.zcy.party.server.ObjectProblemServer;
import com.zcy.party.server.impl.ObjectProblemServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Controller
public class ObjectProblemController {
    @Autowired
    ObjectProblemServerImpl objectProblemServer;
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "api/getAllObjPro",method = RequestMethod.GET)
    public Object getAllObjPro(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<ObjectProblem>  allobj = objectProblemServer.getAllObjProblem();
        for(int i=0;i<allobj.size();i++){
            jsonArray.add(i,allobj.get(i));
        }
        jsonObject.put("objectproblems",jsonArray);
        return jsonObject;
    }
}
