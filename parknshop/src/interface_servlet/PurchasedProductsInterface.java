package interface_servlet;

import java.util.List;
import vo.NewPurchase;

public abstract interface PurchasedProductsInterface
{
  public abstract List<NewPurchase> returnPurchasedProductlist(String paramString);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\PurchasedProductsInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */