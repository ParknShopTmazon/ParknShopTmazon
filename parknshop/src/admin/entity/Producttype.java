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
/*    */ public class Producttype
/*    */   implements Serializable
/*    */ {
/*    */   private Integer typeId;
/*    */   private String typeName;
/* 16 */   private Set productinfos = new HashSet(0);
/*    */   
/*    */ 
/*    */ 
/*    */   public Producttype() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public Producttype(Integer typeId, String typeName)
/*    */   {
/* 26 */     this.typeId = typeId;
/* 27 */     this.typeName = typeName;
/*    */   }
/*    */   
/*    */   public Producttype(Integer typeId, String typeName, Set productinfos)
/*    */   {
/* 32 */     this.typeId = typeId;
/* 33 */     this.typeName = typeName;
/* 34 */     this.productinfos = productinfos;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getTypeId()
/*    */   {
/* 40 */     return this.typeId;
/*    */   }
/*    */   
/*    */   public void setTypeId(Integer typeId) {
/* 44 */     this.typeId = typeId;
/*    */   }
/*    */   
/*    */   public String getTypeName() {
/* 48 */     return this.typeName;
/*    */   }
/*    */   
/*    */   public void setTypeName(String typeName) {
/* 52 */     this.typeName = typeName;
/*    */   }
/*    */   
/*    */   public Set getProductinfos() {
/* 56 */     return this.productinfos;
/*    */   }
/*    */   
/*    */   public void setProductinfos(Set productinfos) {
/* 60 */     this.productinfos = productinfos;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\entity\Producttype.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */