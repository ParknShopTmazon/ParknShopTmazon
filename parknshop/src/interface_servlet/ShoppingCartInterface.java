package interface_servlet;

import java.util.List;
import vo.ShoppingCart;

public abstract interface ShoppingCartInterface
{
  public abstract List<ShoppingCart> returncartlist(String paramString);
  
  public abstract int cartremove(String paramString, int paramInt);
  
  public abstract int usercount(String paramString);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\ShoppingCartInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */