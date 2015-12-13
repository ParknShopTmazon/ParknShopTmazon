/*     */ package admin.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Customerinfo
/*     */   implements Serializable
/*     */ {
/*     */   private String customerName;
/*     */   private String customerPwd;
/*     */   private String realName;
/*     */   private String sex;
/*     */   private String email;
/*     */   private String phoneNumber;
/*     */   private String identityId;
/*     */   private String address;
/*     */   private Short accountState;
/*     */   private String state;
/*     */   private Date regTime;
/*     */   private Double accountBalence;
/*     */   private Integer status;
/*     */   private String status1;
/*  30 */   private Set userfavorites = new HashSet(0);
/*  31 */   private Set consigneeinfos = new HashSet(0);
/*  32 */   private Set shoppingcarts = new HashSet(0);
/*  33 */   private Set shopinfos = new HashSet(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCustomerName()
/*     */   {
/*  43 */     return this.customerName;
/*     */   }
/*     */   
/*     */   public String getStatus1() {
/*  47 */     return this.status1;
/*     */   }
/*     */   
/*     */   public void setStatus1(String status1) {
/*  51 */     this.status1 = status1;
/*     */   }
/*     */   
/*     */   public void setCustomerName(String customerName) {
/*  55 */     this.customerName = customerName;
/*     */   }
/*     */   
/*     */   public String getCustomerPwd() {
/*  59 */     return this.customerPwd;
/*     */   }
/*     */   
/*     */   public void setCustomerPwd(String customerPwd) {
/*  63 */     this.customerPwd = customerPwd;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/*  67 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/*  71 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getSex() {
/*  75 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(String sex) {
/*  79 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/*  83 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/*  87 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getPhoneNumber() {
/*  91 */     return this.phoneNumber;
/*     */   }
/*     */   
/*     */   public void setPhoneNumber(String phoneNumber) {
/*  95 */     this.phoneNumber = phoneNumber;
/*     */   }
/*     */   
/*     */   public String getIdentityId() {
/*  99 */     return this.identityId;
/*     */   }
/*     */   
/*     */   public void setIdentityId(String identityId) {
/* 103 */     this.identityId = identityId;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/* 107 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 111 */     this.address = address;
/*     */   }
/*     */   
/*     */   public Short getAccountState() {
/* 115 */     return this.accountState;
/*     */   }
/*     */   
/*     */   public void setAccountState(Short accountState) {
/* 119 */     this.accountState = accountState;
/*     */   }
/*     */   
/*     */   public String getState() {
/* 123 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(String state) {
/* 127 */     this.state = state;
/*     */   }
/*     */   
/*     */   public Date getRegTime() {
/* 131 */     return this.regTime;
/*     */   }
/*     */   
/*     */   public void setRegTime(Date regTime) {
/* 135 */     this.regTime = regTime;
/*     */   }
/*     */   
/*     */   public Double getAccountBalence() {
/* 139 */     return this.accountBalence;
/*     */   }
/*     */   
/*     */   public void setAccountBalence(Double accountBalence) {
/* 143 */     this.accountBalence = accountBalence;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 147 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 151 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Set getUserfavorites() {
/* 155 */     return this.userfavorites;
/*     */   }
/*     */   
/*     */   public void setUserfavorites(Set userfavorites) {
/* 159 */     this.userfavorites = userfavorites;
/*     */   }
/*     */   
/*     */   public Set getConsigneeinfos() {
/* 163 */     return this.consigneeinfos;
/*     */   }
/*     */   
/*     */   public void setConsigneeinfos(Set consigneeinfos) {
/* 167 */     this.consigneeinfos = consigneeinfos;
/*     */   }
/*     */   
/*     */   public Set getShoppingcarts() {
/* 171 */     return this.shoppingcarts;
/*     */   }
/*     */   
/*     */   public void setShoppingcarts(Set shoppingcarts) {
/* 175 */     this.shoppingcarts = shoppingcarts;
/*     */   }
/*     */   
/*     */   public Set getShopinfos() {
/* 179 */     return this.shopinfos;
/*     */   }
/*     */   
/*     */   public void setShopinfos(Set shopinfos) {
/* 183 */     this.shopinfos = shopinfos;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Customerinfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */