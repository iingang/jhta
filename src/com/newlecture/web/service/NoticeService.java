package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeService {
	List<Notice> getList();
    List<NoticeView> getViewList();
    List<NoticeView> getViewList(int page);
    List<NoticeView> getViewList(int page, String query);
    List<NoticeView> getViewList(int page, String query, String field);

    
    Notice getNotice(int id);
    Notice getNoticeView(int id);
    int insert(Notice notice);
    int update(Notice notice);
    int delete(int id);
	
}
