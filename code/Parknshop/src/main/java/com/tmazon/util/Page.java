package com.tmazon.util;

import java.util.List;

public class Page<T> {

	private  int pageSize = 10;
	private  List<T> Subitems;
	private int curPage;
	private int MAX_PAGE;
	/**
	 * 
	 * @param Items the pageSize of items
	 * @param curPage,the first page num is 1, the curPage >= 1. 
	 * @param next is 1 , -1 or 0. 1 means forward,-1 mean backward,0 means the init.
	 * @return
	 */
	private void getMaxPage(List<T> Items)
	{
		if(Items!=null)
		{
			this.MAX_PAGE = Items.size()/pageSize;
			if(Items.size()%pageSize > 0)
			{
				this.MAX_PAGE++;
			}
		}
		
	}
	public void page(List<T> Items,int curPage,int next)
	{
		if(Items.size()==0)
		{
			this.Subitems = null;
		}
		else
		{
			//nextPage is the last page or the first page?
			int curIndex,lastIndex;
			int nextPage =curPage+next;
			getMaxPage(Items);
			System.out.println("MAX_PAGE::"+this.MAX_PAGE);
			if(nextPage<=0 || next == 0)
			{
				this.curPage = 1;
				curIndex = 0;
				lastIndex = (curIndex+pageSize) > Items.size()? Items.size():curIndex+pageSize;
				System.out.println("nextPage<=0:"+nextPage);
			}
			else if(nextPage >= this.MAX_PAGE)
			{
				this.curPage = this.MAX_PAGE;
				lastIndex = Items.size();
				int l = Items.size()%pageSize;
				if(l == 0)
				{
					curIndex = Items.size() - pageSize;
				}
				else
				{
					curIndex =  Items.size()-Items.size()%pageSize; 
				}
				System.out.println("nextPage>=MAX:"+nextPage);
			}
			else
			{
				this.curPage = nextPage;
				curIndex = (nextPage-1)*pageSize;
				lastIndex = nextPage*pageSize;
				System.out.println("nextPage is normal:"+nextPage);
			}
			System.out.println("Page::CurPage:"+ nextPage+"   from "+curIndex+" to "+lastIndex);
			this.Subitems = Items.subList(curIndex, lastIndex);
		}
	}
	
	public List<T> getSubitems() {
		return Subitems;
	}
	public void setSubitems(List<T> subitems) {
		Subitems = subitems;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
}
