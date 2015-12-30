function changestate(currentid,mode)
{
		if(mode==1)
			document.getElementById(currentid).style.zIndex=1;
		else if(mode==-1)
			document.getElementById(currentid).style.zIndex=-1;
}