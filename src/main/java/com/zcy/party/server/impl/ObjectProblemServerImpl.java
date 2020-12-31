package com.zcy.party.server.impl;

import com.zcy.party.dao.ObjectProblemMapper;
import com.zcy.party.domain.ObjectProblem;
import com.zcy.party.server.ObjectProblemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectProblemServerImpl implements ObjectProblemServer {
    @Autowired
    ObjectProblemMapper objectProblemMapper;
    @Override
    public List<ObjectProblem> getAllObjProblem() {
        return objectProblemMapper.getAllObjProblem();
    }
}
