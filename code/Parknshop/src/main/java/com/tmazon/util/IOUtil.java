package com.tmazon.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil
{
	public static void in2out(InputStream is, OutputStream os) throws IOException
	{
		byte[] buffer = new byte[1024];
		int size = 0;
		while ((size = is.read(buffer)) != -1)
		{
			os.write(buffer, 0, size);
		}
	}

	public static void close(InputStream is, OutputStream os)
	{
		try
		{
			if (is != null) is.close();
		}
		catch (IOException e)
		{
		}
		finally
		{
			is = null;
		}
		try
		{
			if (os != null) os.close();
		}
		catch (IOException e)
		{
		}
		finally
		{
			os = null;
		}
	}
}
