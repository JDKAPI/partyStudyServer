package com.zcy.party.server;

import com.zcy.party.domain.Paper;

import java.util.List;

public interface PaperServer {
    List<Paper> getPaperByCreatorId(int id);
    Paper getPaperInfoById(int id);
}
