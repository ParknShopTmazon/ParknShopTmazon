/*    */ package admin.entity;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Consigneeinfo
/*    */   implements Serializable
/*    */ {
/*    */   private Integer consigneeInfoId;
/*    */   private String customerinfo;
/*    */   private String consigneeName;
/*    */   private String consigneeAddress;
/*    */   private String consigneePostcode;
/*    */   private String consigneePhoneNumber;
/* 20 */   private Set userorders = new HashSet(0);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Integer getConsigneeInfoId()
/*    */   {
/* 32 */     return this.consigneeInfoId;
/*    */   }
/*    */   
/*    */   public void setConsigneeInfoId(Integer consigneeInfoId) {
/* 36 */     this.consigneeInfoId = consigneeInfoId;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getCustomerinfo()
/*    */   {
/* 42 */     return this.customerinfo;
/*    */   }
/*    */   
/*    */   public void setCustomerinfo(String customerinfo)
/*    */   {
/* 47 */     this.customerinfo = customerinfo;
/*    */   }
/*    */   
/*    */   public String getConsigneeName()
/*    */   {
/* 52 */     return this.consigneeName;
/*    */   }
/*    */   
/*    */   public void setConsigneeName(String consigneeName) {
/* 56 */     this.consigneeName = consigneeName;
/*    */   }
/*    */   
/*    */   public String getConsigneeAddress() {
/* 60 */     return this.consigneeAddress;
/*    */   }
/*    */   
/*    */   public void setConsigneeAddress(String consigneeAddress) {
/* 64 */     this.consigneeAddress = consigneeAddress;
/*    */   }
/*    */   
/*    */   public String getConsigneePostcode() {
/* 68 */     return this.consigneePostcode;
/*    */   }
/*    */   
/*    */   public void setConsigneePostcode(String consigneePostcode) {
/* 72 */     this.consigneePostcode = consigneePostcode;
/*    */   }
/*    */   
/*    */   public String getConsigneePhoneNumber() {
/* 76 */     return this.consigneePhoneNumber;
/*    */   }
/*    */   
/*    */   public void setConsigneePhoneNumber(String consigneePhoneNumber) {
/* 80 */     this.consigneePhoneNumber = consigneePhoneNumber;
/*    */   }
/*    */   
/*    */   public Set getUserorders() {
/* 84 */     return this.userorders;
/*    */   }
/*    */   
/*    */   public void setUserorders(Set userorders) {
/* 88 */     this.userorders = userorders;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Consigneeinfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */