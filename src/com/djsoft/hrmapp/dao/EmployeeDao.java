package com.djsoft.hrmapp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.djsoft.hrmapp.domain.Employee;

import static com.djsoft.hrmapp.util.comman.HrmConstants.EMPLOYEETABLE;

public interface EmployeeDao {
	@Select("select * from "+EMPLOYEETABLE)
	@Results({
		@Result(column="card_id",property="cardId"),
		@Result(column="create_date",property="createDate",javaType=Date.class),
		@Result(column="dept_id",property="dept",one=@One(select="com.djsoft.hrmapp.dao.DeptDao.selectById",fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",one=@One(select="com.djsoft.hrmapp.dao.JobDao.selectById",fetchType=FetchType.EAGER))
	})
	List<Employee> selectEmployee();
}
