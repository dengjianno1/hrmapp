package com.djsoft.hrmapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.djsoft.hrmapp.domain.Job;

import static com.djsoft.hrmapp.util.comman.HrmConstants.JOBTABLE;

public interface JobDao {
	@Select("select * from "+JOBTABLE)
	List<Job> selectJob();
}
