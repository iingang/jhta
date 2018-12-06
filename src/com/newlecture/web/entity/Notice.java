package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
   private int id;
   private String title;
   private String writerId;
   private String content;
   private Date regDate;
   private int hit;
   
   public Notice() {
      // TODO Auto-generated constructor stub
   }
   
   //for inserting
   public Notice(String title, String writerId, String content) {
      super();
      this.title = title;
      this.writerId = writerId;
   }
   
   //for selecting
   public Notice(int id, String title,  String content, String writerId, Date regDate, int hit) {
      super();
      this.id = id;
      this.title = title;
      this.writerId = writerId;
      this.regDate = regDate;
      this.hit = hit;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getWriterId() {
      return writerId;
   }

   public void setWriterId(String writerId) {
      this.writerId = writerId;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Date getRegDate() {
      return regDate;
   }

   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }

   public int getHit() {
      return hit;
   }

   public void setHit(int hit) {
      this.hit = hit;
   }

   
   @Override
   public String toString() {
      return "Notice [id=" + id + ", title=" + title + ", writerId=" + writerId + ", content=" + content
            + ", regDate=" + regDate + ", hit=" + hit + "]";
   }
   
   
}