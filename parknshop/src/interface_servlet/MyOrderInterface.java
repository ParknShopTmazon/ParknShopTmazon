package interface_servlet;

import vo.ProductDetail;

public abstract interface MyOrderInterface
{
  public abstract String returndeliveryaddress(int paramInt);
  
  public abstract String returnshopname(int paramInt);
  
  public abstract ProductDetail returndetail(int paramInt);
  
  public abstract double returntotalprice(int paramInt);
  
  public abstract void confirmgoods(int paramInt);
  
  public abstract void removeOrder(int paramInt);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\MyOrderInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */