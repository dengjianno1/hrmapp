package com.djsoft.hrmapp.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.djsoft.hrmapp.domain.Dept;

import static com.djsoft.hrmapp.util.comman.HrmConstants.DEPTTABLE;

public class DeptDynaSqlProvider {
	public String insertDept(Dept dept){
		return new SQL(){
			{
				INSERT_INTO(DEPTTABLE);
				if (dept.getName()!=null&&!dept.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (dept.getRemark()!=null&&!dept.getRemark().equals("")) {
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}
	
	public String updateDept(Dept dept){
		return new SQL(){
			{
				UPDATE(DEPTTABLE);
				if (dept.getName()!=null&&!dept.getName().equals("")) {
					SET("name=#{name}");
				}
				if (dept.getRemark()!=null&&!dept.getRemark().equals("")) {
					SET("remark=#{remark}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
