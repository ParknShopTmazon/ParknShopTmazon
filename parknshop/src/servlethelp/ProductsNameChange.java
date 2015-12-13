/*    */ package servlethelp;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import vo.ProductDetail;
/*    */ 
/*    */ public class ProductsNameChange
/*    */ {
/*    */   public static List<ProductDetail> returnlist(List<ProductDetail> list1)
/*    */   {
/* 12 */     List<ProductDetail> list2 = new LinkedList();
/*    */     
/* 14 */     Iterator<ProductDetail> it = list1.iterator();
/* 15 */     while (it.hasNext()) {
/* 16 */       ProductDetail pd = (ProductDetail)it.next();
/* 17 */       ProductDetail pd2 = new ProductDetail();
/* 18 */       String str = pd.getProduct_name();
/* 19 */       String[] strres = str.split(" ");
/* 20 */       if (strres.length > 3)
/*    */       {
/*    */ 
/* 23 */         str = "";
/* 24 */         str = strres[0] + " " + strres[1] + " " + strres[3];
/*    */       }
/* 26 */       pd2.setProduct_description(pd.getProduct_description());
/* 27 */       pd2.setProduct_ID(pd.getProduct_ID());
/* 28 */       pd2.setProduct_img_url(pd.getProduct_img_url());
/* 29 */       pd2.setProduct_name(str);
/* 30 */       pd2.setProduct_price(pd.getProduct_price());
/* 31 */       pd2.setProduct_type_ID(pd.getProduct_type_ID());
/* 32 */       list2.add(pd2);
/*    */     }
/*    */     
/* 35 */     return list2;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlethelp\ProductsNameChange.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */