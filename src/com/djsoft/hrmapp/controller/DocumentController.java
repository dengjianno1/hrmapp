package com.djsoft.hrmapp.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djsoft.hrmapp.domain.Document;
import com.djsoft.hrmapp.domain.User;
import com.djsoft.hrmapp.service.HrmService;

@Controller
public class DocumentController {
	@Autowired
	private HrmService hrmService;
	@RequestMapping(value="/document/adddocument")
	public String addDocument(@ModelAttribute Document document,HttpSession session) throws Exception{
		// 上传文件路径
		String path = session.getServletContext().getRealPath("/upload/");
		// 上传文件名
		String fileName = document.getFile().getOriginalFilename();
		// 将上传文件保存到一个目标文件当中
		document.getFile().transferTo(new File(path+fileName));
		// 设置fileName
		document.setFileName(fileName);
		// 设置关联的User对象
		User user = hrmService.findUserById(1);
		document.setUser(user);
		hrmService.addDocument(document);
		return "redirect:/document/selectdocument";
	}
	@RequestMapping(value="/document/selectdocument")
	public String selectDocument(Model model){
		model.addAttribute("documents", hrmService.findDocument());
		return "document/document";
	}
	/**
	 * 处理文档下载请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Document document 要修改文档的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/document/download/{id}")
	 public ResponseEntity<byte[]>  download(
			 @PathVariable("id") Integer id,
			 HttpSession session) throws Exception{
		// 根据id查询文档
		Document document = hrmService.findDocumentById(id);
		String fileName = document.getFileName();
		// 上传文件路径
		String path = session.getServletContext().getRealPath("/upload/");
		// 获得要下载文件的File对象
		File file = new File(path+fileName);
		// 创建springframework的HttpHeaders对象
		HttpHeaders headers = new HttpHeaders();  
        // 下载显示的文件名，解决中文名称乱码问题  
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        // 通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName); 
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 201 HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED); 
	}
}
