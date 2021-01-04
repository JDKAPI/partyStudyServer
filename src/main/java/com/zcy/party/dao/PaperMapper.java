package com.zcy.party.dao;

import com.zcy.party.domain.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperMapper {
      List<Paper> getPaperByCreatorId(int id);
      Paper getPaperInfoById(int id);
}
