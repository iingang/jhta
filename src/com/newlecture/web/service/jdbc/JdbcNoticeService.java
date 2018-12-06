package com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

public class JdbcNoticeService implements NoticeService {

   @Override
   public List<NoticeView> getViewList() {
      // TODO Auto-generated method stub
      return getViewList(1, "", "title");
   }

   @Override
   public List<Notice> getList() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<NoticeView> getViewList(int page) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<NoticeView> getViewList(int page, String query) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<NoticeView> getViewList(int page, String query, String field) {
      
      List<NoticeView> list = new ArrayList<>();
      
      String sql = "SELECT * FROM " + 
            "(" + 
            "    SELECT ROWNUM NUM, N.* " + 
            "    FROM NOTICE_VIEW N " + 
            ") " + 
            "WHERE NUM BETWEEN ? AND ?";
      
      try {
                  
         int start = 1+(page-1)*10; // 등차수열 일반항
         int end = page*10;         
         
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url,"c##sist","dclass");
         PreparedStatement st = con.prepareStatement(sql);
         st.setInt(1, start);
         st.setInt(2, end);
         
         ResultSet rs =st.executeQuery();
         
         
         
         while(rs.next()) {
            NoticeView n = new NoticeView(
                     rs.getInt("id"),
                     rs.getString("title"),
                     rs.getString("content"),
                     rs.getString("writer_id"),
                     rs.getDate("regdate"),
                     rs.getInt("hit"),
                     rs.getString("member_name"),
                     rs.getInt("comment_count")
                  );
            //n.setId(rs.getString("id"));
            //n.setTitle(rs.getString("title"));
            // ...
            
            list.add(n);
         }            
         
         rs.close();
         st.close();
         con.close();
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return list;
   }

   @Override
   public NoticeView getNoticeView(int id) {
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