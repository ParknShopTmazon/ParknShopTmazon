/*    */ package vo;
/*    */ 
/*    */ import java.sql.Date;
/*    */ 
/*    */ public class Comment
/*    */ {
/*    */   private int commentID;
/*    */   private String CustomerName;
/*    */   private int OrderID;
/*    */   private String comment;
/*    */   private Date time;
/*    */   private int level;
/*    */   
/*    */   public Date getTime()
/*    */   {
/* 16 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 20 */     this.time = time;
/*    */   }
/*    */   
/*    */   public int getOrderID() {
/* 24 */     return this.OrderID;
/*    */   }
/*    */   
/*    */   public void setOrderID(int orderID) {
/* 28 */     this.OrderID = orderID;
/*    */   }
/*    */   
/*    */   public int getCommentID() {
/* 32 */     return this.commentID;
/*    */   }
/*    */   
/*    */   public void setCommentID(int commentID) {
/* 36 */     this.commentID = commentID;
/*    */   }
/*    */   
/*    */   public String getCustomerName() {
/* 40 */     return this.CustomerName;
/*    */   }
/*    */   
/*    */   public void setCustomerName(String customerName) {
/* 44 */     this.CustomerName = customerName;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 48 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 52 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 56 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(int level) {
/* 60 */     this.level = level;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\vo\Comment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */