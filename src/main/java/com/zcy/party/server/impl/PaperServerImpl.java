package com.zcy.party.server.impl;

import com.zcy.party.dao.PaperMapper;
import com.zcy.party.domain.Paper;
import com.zcy.party.server.PaperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServerImpl implements PaperServer {
    @Autowired
    PaperMapper paperMapper;
    @Override
    public List<Paper> getPaperByCreatorId(int id) {
        return paperMapper.getPaperByCreatorId(id);
    }

    @Override
    public Paper getPaperInfoById(int id) {
        return paperMapper.getPaperInfoById(id);
    }
}
