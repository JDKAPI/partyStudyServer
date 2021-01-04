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

    @Override
    public List<ObjectProblem> getTestProblem() {
        return objectProblemMapper.getTestProblem();
    }

    @Override
    public int updateObjProblem(ObjectProblem objectProblem) {
        return objectProblemMapper.updateObjProblem(objectProblem);
    }

    @Override
    public int deleteProblem(int id) {
        return objectProblemMapper.deleteProblem(id);
    }

    @Override
    public int insertProblem(ObjectProblem objectProblem) {
        return objectProblemMapper.insertProblem(objectProblem);
    }
}
