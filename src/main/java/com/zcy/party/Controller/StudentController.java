package com.zcy.party.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zcy.party.domain.Student;
import com.zcy.party.server.StudentServer;
import com.zcy.party.server.impl.StudentServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@Controller
public class StudentController {
    @Autowired
    StudentServerImpl studentServer;
    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/insertGrade",method = RequestMethod.POST)
    public void insertStuGrade(HttpServletRequest request) throws IOException {
        String s = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        JSONObject jsonObject = JSONObject.parseObject(s);
        studentServer.insertGrade(jsonObject.get("id").toString(),
                Integer.parseInt( jsonObject.get("AnswerTimes").toString()),
                Integer.parseInt(jsonObject.get("CorrectedNum").toString()),
                Integer.parseInt(jsonObject.get("DisCorrevtedNum").toString()),
                Integer.parseInt(jsonObject.get("MinNum").toString()),
                Integer.parseInt(jsonObject.get("MaxNum").toString()));
    }
}
