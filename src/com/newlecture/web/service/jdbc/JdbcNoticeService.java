package com.newlecture.web.service.jdbc;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class JdbcNoticeService implements NoticeService {

	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return getList(1,"","title");
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return getList(page,"","title");
	}

	@Override
	public List<Notice> getList(int page, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page, String query, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getNotice(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
