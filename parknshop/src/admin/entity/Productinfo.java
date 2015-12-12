/*     */ package admin.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Productinfo
/*     */   implements Serializable
/*     */ {
/*     */   private Integer productId;
/*     */   private int productTypeId;
/*     */   private String productType;
/*     */   private String productName;
/*     */   private String productDescription;
/*     */   private String productDetail;
/*     */   private String imagePath;
/*     */   private Double price;
/*  22 */   private Set shopproducts = new HashSet(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getProductId()
/*     */   {
/*  35 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Integer productId) {
/*  39 */     this.productId = productId;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getProductTypeId()
/*     */   {
/*  45 */     return this.productTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setProductTypeId(int productTypeId)
/*     */   {
/*  51 */     this.productTypeId = productTypeId;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getProductType()
/*     */   {
/*  57 */     return this.productType;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setProductType(String productType)
/*     */   {
/*  63 */     this.productType = productType;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getProductName()
/*     */   {
/*  69 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/*  73 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductDescription() {
/*  77 */     return this.productDescription;
/*     */   }
/*     */   
/*     */   public void setProductDescription(String productDescription) {
/*  81 */     this.productDescription = productDescription;
/*     */   }
/*     */   
/*     */   public String getProductDetail() {
/*  85 */     return this.productDetail;
/*     */   }
/*     */   
/*     */   public void setProductDetail(String productDetail) {
/*  89 */     this.productDetail = productDetail;
/*     */   }
/*     */   
/*     */   public String getImagePath() {
/*  93 */     return this.imagePath;
/*     */   }
/*     */   
/*     */   public void setImagePath(String imagePath) {
/*  97 */     this.imagePath = imagePath;
/*     */   }
/*     */   
/*     */   public Double getPrice() {
/* 101 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/* 105 */     this.price = price;
/*     */   }
/*     */   
/*     */   public Set getShopproducts() {
/* 109 */     return this.shopproducts;
/*     */   }
/*     */   
/*     */   public void setShopproducts(Set shopproducts) {
/* 113 */     this.shopproducts = shopproducts;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Productinfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */