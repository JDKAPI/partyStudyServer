package com.zcy.party.server;

import com.zcy.party.domain.Paper;

import java.util.List;

public interface PaperServer {
    List<Paper> getPaperByCreatorId(int id);
    Paper getPaperInfoById(int id);
    int insertPaper(String name,int creator,int yi,int er,int san,int si,int wu,int liu,int qi,int ba,int jiu,int shi,
                    int shiyi,int shier,int shisan,int shisi,int shiwu,int shiliu,int shiqi,int shiba,int shijiu,
                    int ershi,int eryi,int erer,int ersan,int ersi,int erwu);
}
