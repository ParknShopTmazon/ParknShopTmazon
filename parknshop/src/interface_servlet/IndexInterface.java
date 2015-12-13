package interface_servlet;

import java.util.List;
import vo.ProductDetail;

public abstract interface IndexInterface
{
  public abstract List<ProductDetail> SearchProductByType(int paramInt);
  
  public abstract List<ProductDetail> SearchProduct(String paramString);
  
  public abstract List<ProductDetail> SellBestProduct();
  
  public abstract List<ProductDetail> NewProduct();
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\IndexInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */