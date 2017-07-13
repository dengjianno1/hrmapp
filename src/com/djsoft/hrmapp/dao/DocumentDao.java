package com.djsoft.hrmapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.djsoft.hrmapp.dao.provider.DocumentDynaSqlProvider;
import com.djsoft.hrmapp.domain.Document;

import static com.djsoft.hrmapp.util.comman.HrmConstants.DOCUMENTTABLE;

public interface DocumentDao {
	@InsertProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
	void addDocument(Document document);
	
	@Select("select * from "+DOCUMENTTABLE)
	@Results({
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="user",one=@One(select="com.djsoft.hrmapp.dao.UserDao.selectById",fetchType=FetchType.EAGER))
	})
	List<Document> selectDocument();
	
	@Select("select * from "+DOCUMENTTABLE+" where id=#{id}")
	@Results({
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="user",one=@One(select="com.djsoft.hrmapp.dao.UserDao.selectById",fetchType=FetchType.LAZY))
	})
	Document selectDocumentById(int id);
}
