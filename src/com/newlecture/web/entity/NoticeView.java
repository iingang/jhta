package com.newlecture.web.entity;

import java.util.Date;

public class NoticeView extends Notice {
   private String memberName;
   private int commentCount;
   
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}
   
   public NoticeView(int id, String title, String content, String writerId, Date regDate, int hit, String memberName, int commentCount) {
      super(id, title, content, writerId, regDate, hit);
      this.memberName = memberName;
      this.commentCount = commentCount;
   }
   
   public NoticeView(String title, String content, String writerId, String memberName, int commentCount) {
      super(title, content,writerId);
      this.memberName = memberName;
      this.commentCount = commentCount;
   }
   

   public String getMemberName() {
      return memberName;
   }

   public void setMemberName(String memberName) {
      this.memberName = memberName;
   }

   public int getCommentCount() {
      return commentCount;
   }

   public void setCommentCount(int commentCount) {
      this.commentCount = commentCount;
   }

   @Override
   public String toString() {
      return "NoticeView [memberName=" + memberName + ", commentCount=" + commentCount + "]";
   }

}