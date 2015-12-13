package interface_servlet;

import java.util.List;
import vo.ShoppingCart;

public abstract interface CheckoutInterface
{
  public abstract int checkout(String paramString1, List<ShoppingCart> paramList, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\CheckoutInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */