/*    */ package servlethelp;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Statement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import jdbc.ConnectionManager;
/*    */ import vo.Picture;
/*    */ 
/*    */ 
/*    */ public class Animation
/*    */ {
/*    */   public List<Picture> getImageInformation()
/*    */   {
/* 16 */     List<Picture> list = new ArrayList();
/* 17 */     Picture pic = null;
/* 18 */     String sql = "SELECT ImagePath,URL FROM ads  ORDER BY recorderTime DESC ";
/*    */     try {
/* 20 */       Connection con = ConnectionManager.getConnection();
/* 21 */       Statement st = con.createStatement();
/* 22 */       ResultSet rs = st.executeQuery(sql);
/* 23 */       while (rs.next())
/*    */       {
/* 25 */         pic = new Picture();
/*    */         
/* 27 */         pic.setPath(rs.getString("ImagePath"));
/* 28 */         pic.setURL(rs.getString("URL"));
/*    */         
/* 30 */         list.add(pic);
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 35 */       e.printStackTrace();
/*    */     }
/* 37 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\servlethelp\Animation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */