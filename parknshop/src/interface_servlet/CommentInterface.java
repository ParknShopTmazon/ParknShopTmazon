package interface_servlet;

import java.util.List;
import vo.Comment;

public abstract interface CommentInterface
{
  public abstract void usercomment(int paramInt1, String paramString, int paramInt2);
  
  public abstract List<Comment> returncommentlistbyproductid(int paramInt);
}


/* Location:              C:\Users\caoHongYang\Desktop\parnshop\WebContent\WEB-INF\classes\!\interface_servlet\CommentInterface.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */