/*    */ package servlethelp;
/*    */ 
/*    */ import interface_impl.IndexInterface_impl;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import vo.ProductDetail;
/*    */ 
/*    */ 
/*    */ public class BestSell
/*    */ {
/*    */   public static void addbestsell(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 15 */     IndexInterface_impl iii = new IndexInterface_impl();
/*    */     
/* 17 */     List<ProductDetail> list = iii.SellBestProduct();
/*    */     
/* 19 */     System.out.println(list.size());
/*    */     
/* 21 */     request.setAttribute("sell_best_list", list);
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlethelp\BestSell.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */