/*    */ package admin.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Result
/*    */   implements Serializable
/*    */ {
/*    */   private Integer idint;
/*    */   private String idstring;
/*    */   private String type;
/*    */   private Integer t;
/*    */   
/*    */   public Integer getT()
/*    */   {
/* 19 */     return this.t;
/*    */   }
/*    */   
/*    */   public void setT(Integer t) {
/* 23 */     this.t = t;
/*    */   }
/*    */   
/*    */   public Integer getIdint() {
/* 27 */     return this.idint;
/*    */   }
/*    */   
/*    */   public void setIdint(Integer idint) {
/* 31 */     this.idint = idint;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getIdstring()
/*    */   {
/* 37 */     return this.idstring;
/*    */   }
/*    */   
/*    */   public void setIdstring(String idstring) {
/* 41 */     this.idstring = idstring;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 45 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 49 */     this.type = type;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Result.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */