package com.djsoft.hrmapp.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.djsoft.hrmapp.domain.Document;

import static com.djsoft.hrmapp.util.comman.HrmConstants.DOCUMENTTABLE;

public class DocumentDynaSqlProvider {
	public String insertDocument(Document document){
		return new SQL(){
			{
				INSERT_INTO(DOCUMENTTABLE);
				if (document.getTitle()!=null&&!document.getTitle().equals("")) {
					VALUES("title", "#{title}");
				}
				if (document.getFileName()!=null&&!document.getFileName().equals("")) {
					VALUES("filename", "#{fileName}");
				}
				if (document.getRemark()!=null&&!document.getRemark().equals("")) {
					VALUES("remark", "#{remark}");
				}
				if (document.getUser()!=null&&document.getUser().getId()!=null) {
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}
}
