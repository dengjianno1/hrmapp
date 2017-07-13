package com.djsoft.hrmapp.service;

import java.util.List;

import com.djsoft.hrmapp.domain.Dept;
import com.djsoft.hrmapp.domain.Document;
import com.djsoft.hrmapp.domain.Employee;
import com.djsoft.hrmapp.domain.Job;
import com.djsoft.hrmapp.domain.User;


public interface HrmService {
	/**
	 * 用户登录
	 * @param loginname
	 * @param password
	 * @return User对象
	 */
	User login(String loginname,String password);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 */
	User findUserById(Integer id);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void removeUserById(Integer id);
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 */
	List<User> findUser(User user);
	/**
	 * 添加用户
	 * @param user 用户对象
	 */
	void addUser(User user);
	/**
	 * 修改用户
	 * @param user 用户对象
	 */
	void modifyUser(User user);
	/**
	 * 获得所有部门
	 * @return 部门对象的List集合
	 */
	List<Dept> findDept();
	/**
	 * 添加部门
	 * @param dept 部门对象
	 */
	void addDept(Dept dept);
	/**
	 * 根据id删除部门
	 * @param id
	 */
	void removeDeptById(int id);
	/**
	 * 根据id查询部门
	 * @param id
	 */
	Dept findDeptById(int id);
	/**
	 * 修改部门
	 * @param dept
	 */
	void modifyDept(Dept dept);
	/**
	 * 获得所有职位
	 */
	List<Job> findJob();
	/**
	 * 获得所有员工
	 */
	List<Employee> findEmployee();
	/**
	 * 添加文档
	 */
	void addDocument(Document document);
	/**
	 * 获得所有文档
	 */
	List<Document> findDocument();
	/**
	 * 根据Id查询文档
	 */
	Document findDocumentById(int id);
}
