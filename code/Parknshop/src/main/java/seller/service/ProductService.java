/*    */ package seller.service;
/*    */ 
/*    */ import seller.dao.ProductDao;
/*    */ import seller.vo.Productinfo;

/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class ProductService
/*    */ {
/*    */   public void addpd_part(String pid, String productname, String description, String price)
/*    */   {
/* 11 */     Productinfo pi = new Productinfo();
/* 12 */     pi.setP_id(pid);
/* 13 */     pi.setP_name(productname);
/* 14 */     pi.setP_desc(description);
/* 15 */     pi.setP_price(price);
/*    */     
/* 17 */     ProductDao pd = new ProductDao();
/* 18 */     pd.addpd_part(pi);
/*    */   }
/*    */   
/*    */   public int selectByName(String productname)
/*    */   {
/* 23 */     Productinfo pi = new Productinfo();
/* 24 */     pi.setP_name(productname);
/* 25 */     ProductDao pd = new ProductDao();
/* 26 */     int returnPid = pd.selectByName(pi);
/* 27 */     return returnPid;
/*    */   }
/*    */   
/*    */   public void addpd_rest(String pid, String imagepath)
/*    */   {
/* 32 */     Productinfo pi = new Productinfo();
/* 33 */     pi.setP_id(pid);
/* 34 */     pi.setImg_path(imagepath);
/* 35 */     System.out.println(imagepath);
/* 36 */     ProductDao pd = new ProductDao();
/* 37 */     pd.addpd_rest(pi);
/*    */   }
/*    */   
/*    */   public void delproduct(String pid)
/*    */   {
/* 42 */     Productinfo pi = new Productinfo();
/* 43 */     pi.setP_id(pid);
/*    */     
/* 45 */     ProductDao pd = new ProductDao();
/* 46 */     pd.delproduct(pi);
/*    */   }
/*    */   
/*    */   public void modifyproduct(String pid, String price)
/*    */   {
/* 51 */     Productinfo pi = new Productinfo();
/* 52 */     pi.setP_id(pid);
/* 53 */     pi.setP_price(price);
/*    */     
/* 55 */     ProductDao pd = new ProductDao();
/* 56 */     pd.modifyproduct(pi);
/*    */   }

         

 }

