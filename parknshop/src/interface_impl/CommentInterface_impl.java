/*     */ package interface_impl;
/*     */ 
/*     */ import interface_servlet.CommentInterface;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import jdbc.ConnectionManager;
/*     */ import vo.Comment;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommentInterface_impl
/*     */   implements CommentInterface
/*     */ {
/*     */   private Comment returncommentByOrderId(int order_id)
/*     */   {
/*  23 */     Comment ct = null;
/*  24 */     String sql = "SELECT  CommentID,comments.OrderID,Comment,Time,Level,consigneeinfo.CustomerName  FROM comments,userorder,consigneeinfo   WHERE  comments.OrderID=userorder.OrderID AND userorder.ConsigneeInfoID=consigneeinfo.ConsigneeInfoID AND comments.Status=0 AND  comments.OrderID=" + 
/*     */     
/*  26 */       order_id;
/*     */     
/*     */     try
/*     */     {
/*  30 */       Connection con = ConnectionManager.getConnection();
/*  31 */       Statement st = con.createStatement();
/*  32 */       ResultSet rs = st.executeQuery(sql);
/*  33 */       while (rs.next()) {
/*  34 */         ct = new Comment();
/*  35 */         ct.setCommentID(rs.getInt("CommentID"));
/*  36 */         ct.setOrderID(rs.getInt("OrderID"));
/*  37 */         ct.setComment(rs.getString("Comment"));
/*  38 */         ct.setCustomerName(rs.getString("CustomerName"));
/*  39 */         ct.setTime(rs.getDate("Time"));
/*  40 */         ct.setLevel(rs.getInt("Level"));
/*     */       }
/*     */       
/*     */ 
/*  44 */       ConnectionManager.close(rs);
/*  45 */       ConnectionManager.close(st);
/*  46 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*  48 */       e.printStackTrace();
/*     */     }
/*     */     
/*  51 */     return ct;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void usercomment(int order_id, String Comment, int Level)
/*     */   {
/*  58 */     Date d = new Date(System.currentTimeMillis());
/*  59 */     String sql = "INSERT  INTO comments(OrderID,Comment,Time,Level) VALUES(?,?,?,?)";
/*     */     
/*  61 */     String sqlstate = "update userorder SET  userorder.CurrentState='5' WHERE OrderID=" + 
/*  62 */       order_id;
/*     */     
/*  64 */     Connection con = null;
/*     */     try {
/*  66 */       con = ConnectionManager.getConnection();
/*  67 */       con.setAutoCommit(false);
/*     */       
/*     */ 
/*  70 */       PreparedStatement ps = con.prepareStatement(sql);
/*  71 */       ps.setInt(1, order_id);
/*  72 */       ps.setString(2, Comment);
/*  73 */       ps.setDate(3, d);
/*  74 */       ps.setInt(4, Level);
/*  75 */       ps.execute();
/*     */       
/*  77 */       Statement st = con.createStatement();
/*  78 */       st.executeUpdate(sqlstate);
/*     */       
/*  80 */       con.commit();
/*  81 */       ConnectionManager.close(ps);
/*  82 */       ConnectionManager.close(con);
/*     */     } catch (Exception e) {
/*     */       try {
/*  85 */         con.rollback();
/*     */       }
/*     */       catch (SQLException e1) {
/*  88 */         e1.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Comment> returncommentlistbyproductid(int product_id)
/*     */   {
/*  97 */     String sql = "SELECT  userorder.OrderID FROM shopproduct,userorder WHERE shopproduct.ShopProductID=userorder.ShopProductID AND shopproduct.ProductID=" + product_id;
/*  98 */     Comment comment = null;
/*  99 */     List<Comment> list = new ArrayList();
/*     */     try
/*     */     {
/* 102 */       Connection con = ConnectionManager.getConnection();
/* 103 */       Statement st = con.createStatement();
/*     */       
/* 105 */       ResultSet rs = st.executeQuery(sql);
/*     */       
/*     */ 
/* 108 */       while (rs.next())
/*     */       {
/* 110 */         int orderID = rs.getInt("OrderID");
/* 111 */         System.out.println("orderID:" + orderID);
/* 112 */         comment = returncommentByOrderId(orderID);
/*     */         try {
/* 114 */           comment.getComment();
/*     */         }
/*     */         catch (Exception e) {
/*     */           continue;
/*     */         }
/* 119 */         list.add(comment);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 125 */       e.printStackTrace();
/*     */     }
/* 127 */     System.out.println("gggggggggggggggggg:" + list.size());
/*     */     
/* 129 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_impl\CommentInterface_impl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */