package interface_servlet;

import java.util.List;
import vo.ProductDetail;

public abstract interface MyFavoriteProductsInterface
{
  public abstract List<ProductDetail> returnmyfavoritelist(String paramString);
  
  public abstract int myfavoriteremove(String paramString, int paramInt);
  
  public abstract int addtomyfavorite(String paramString, int paramInt);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\MyFavoriteProductsInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */