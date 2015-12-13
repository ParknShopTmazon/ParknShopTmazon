/*    */ package admin.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Admininfo
/*    */   implements Serializable
/*    */ {
/*    */   private String adminName;
/*    */   private String adminPwd;
/*    */   private Integer adminPrivilege;
/*    */   private Double Account;
/*    */   private Double Rate;
/*    */   
/*    */   public Admininfo() {}
/*    */   
/*    */   public Admininfo(String adminName, String adminPwd, Integer adminPrivilege)
/*    */   {
/* 25 */     this.adminName = adminName;
/* 26 */     this.adminPwd = adminPwd;
/* 27 */     this.adminPrivilege = adminPrivilege;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getAdminName()
/*    */   {
/* 33 */     return this.adminName;
/*    */   }
/*    */   
/*    */   public Double getAccount() {
/* 37 */     return this.Account;
/*    */   }
/*    */   
/*    */   public void setAccount(Double account) {
/* 41 */     this.Account = account;
/*    */   }
/*    */   
/*    */   public Double getRate() {
/* 45 */     return this.Rate;
/*    */   }
/*    */   
/*    */   public void setRate(Double rate) {
/* 49 */     this.Rate = rate;
/*    */   }
/*    */   
/*    */   public void setAdminName(String adminName) {
/* 53 */     this.adminName = adminName;
/*    */   }
/*    */   
/*    */   public String getAdminPwd() {
/* 57 */     return this.adminPwd;
/*    */   }
/*    */   
/*    */   public void setAdminPwd(String adminPwd) {
/* 61 */     this.adminPwd = adminPwd;
/*    */   }
/*    */   
/*    */   public Integer getAdminPrivilege() {
/* 65 */     return this.adminPrivilege;
/*    */   }
/*    */   
/*    */   public void setAdminPrivilege(Integer adminPrivilege) {
/* 69 */     this.adminPrivilege = adminPrivilege;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Admininfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */