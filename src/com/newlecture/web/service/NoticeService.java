package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {
	List<Notice> getList();
	List<Notice> getList(int page);
	List<Notice> getList(int page, String query);
	List<Notice> getList(int page, String query, String field);
	
	Notice getNotice(int id);
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	
}
