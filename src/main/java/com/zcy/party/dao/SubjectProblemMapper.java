package com.zcy.party.dao;

import com.zcy.party.domain.SubjectProblem;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectProblemMapper {
    SubjectProblem getSubProblemById(int id);
}
