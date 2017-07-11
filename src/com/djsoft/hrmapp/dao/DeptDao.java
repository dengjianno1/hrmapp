package com.djsoft.hrmapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.djsoft.hrmapp.dao.provider.DeptDynaSqlProvider;
import com.djsoft.hrmapp.domain.Dept;

import static com.djsoft.hrmapp.util.comman.HrmConstants.DEPTTABLE;

public interface DeptDao {
	
	@Select("select * from "+DEPTTABLE)
	List<Dept> selectDept();
	
	@InsertProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void addDept(Dept dept);
	
	@Delete("delete from "+DEPTTABLE+" where id=#{id}")
	void deleteById(int id);
	
	@Select("select * from "+DEPTTABLE+" where id=#{id}")
	Dept selectById(int id);
	
	@UpdateProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);
}
