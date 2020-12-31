package com.zcy.party.dao;

import com.zcy.party.domain.ObjectProblem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectProblemMapper {
    List<ObjectProblem> getAllObjProblem();
}
