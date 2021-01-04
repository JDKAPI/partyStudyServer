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

    @Override
    public int insertPaper(String name, int creator, int yi, int er, int san, int si, int wu, int liu, int qi, int ba, int jiu, int shi, int shiyi, int shier, int shisan, int shisi, int shiwu, int shiliu, int shiqi, int shiba, int shijiu, int ershi, int eryi, int erer, int ersan, int ersi, int erwu) {
        return paperMapper.insertPaper(name,creator,yi,er,san,si,wu,liu,qi,ba,jiu,shi,shiyi,shier,shisan,shisi,shiwu,shiliu,shiqi,shiba,shijiu,ershi,eryi,erer,ersan,ersi,erwu);
    }
}
