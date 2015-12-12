/*    */ package admin.dao;
/*    */ 
/*    */ import admin.entity.Consigneeinfo;
/*    */ import admin.util.DBHelper;
/*    */ import java.sql.ResultSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class ConsigneeDAO
/*    */ {
/*    */   public List<Consigneeinfo> getAnyConsignees(int id)
/*    */   {
/* 14 */     List<Consigneeinfo> Cs = new ArrayList();
/* 15 */     String sql = "select * from Consigneeinfo where ConsigneeInfoID=?";
/*    */     
/* 17 */     DBHelper dbhelper = new DBHelper();
/* 18 */     Object[] values = new Object[1];
/* 19 */     values[0] = Integer.valueOf(id);
/*    */     try
/*    */     {
/* 22 */       ResultSet rs = dbhelper.executeQuery(sql, values);
/* 23 */       while (rs.next())
/*    */       {
/* 25 */         Consigneeinfo C = new Consigneeinfo();
/* 26 */         C.setConsigneeInfoId(Integer.valueOf(rs.getInt("ConsigneeInfoID")));
/* 27 */         C.setCustomerinfo(rs.getString("CustomerName"));
/* 28 */         C.setConsigneeName(rs.getString("ConsigneeName"));
/* 29 */         C.setConsigneeAddress(rs.getString("ConsigneeAddress"));
/* 30 */         C.setConsigneePostcode(rs.getString("ConsigneePostcode"));
/* 31 */         C.setConsigneePhoneNumber(rs.getString("ConsigneePhoneNumber"));
/* 32 */         Cs.add(C);
/*    */       }
/* 34 */       dbhelper.closeDB();
/*    */     }
/*    */     catch (Exception e) {
/* 37 */       e.printStackTrace();
/*    */     }
/* 39 */     return Cs;
/*    */   }
/*    */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\admin\dao\ConsigneeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */