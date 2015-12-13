package com.seller.fileoperate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileOperate
{
  public static String getExtension(String fileName)
  {
    if (fileName != null)
    {
      int i = fileName.lastIndexOf('.');
      if ((i > 0) && (i < fileName.length() - 1)) {
        return fileName.substring(i + 1).toLowerCase();
      }
    }
    return "";
  }
  
  public static String getPrefix(String fileName)
  {
    if (fileName != null)
    {
      fileName = fileName.replace('\\', '/');
      if (fileName.lastIndexOf("/") > 0) {
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
      }
      int i = fileName.lastIndexOf('.');
      if ((i > 0) && (i < fileName.length() - 1)) {
        return fileName.substring(0, i);
      }
    }
    return "";
  }
  
  public static String getShortFileName(String fileName)
  {
    if (fileName != null)
    {
      String oldFileName = new String(fileName);
      
      fileName = fileName.replace('\\', '/');
      if (fileName.endsWith("/"))
      {
        int idx = fileName.indexOf('/');
        if ((idx == -1) || (idx == fileName.length() - 1)) {
          return oldFileName;
        }
        return oldFileName.substring(idx + 1, fileName.length() - 1);
      }
      if (fileName.lastIndexOf("/") > 0) {
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
      }
      return fileName;
    }
    return "";
  }
  
  public static boolean newFolder(String folderPath)
  {
    try
    {
      String filePath = folderPath;
      filePath = filePath.toString();
      File myFilePath = new File(folderPath);
      if (!myFilePath.exists())
      {
        myFilePath.mkdirs();
        return true;
      }
      return false;
    }
    catch (Exception e)
    {
      System.out.println("鏂板缓鐩綍鎿嶄綔鍑洪敊");
      e.printStackTrace();
    }
    return false;
  }
  
  public static void newFile(String filePathAndName, String fileContent)
  {
    try
    {
      String filePath = filePathAndName;
      filePath = filePath.toString();
      File myFilePath = new File(filePath);
      if (!myFilePath.exists()) {
        myFilePath.createNewFile();
      }
      FileWriter resultFile = new FileWriter(myFilePath);
      PrintWriter myFile = new PrintWriter(resultFile);
      String strContent = fileContent;
      myFile.println(strContent);
      resultFile.close();
      System.out.println("鏂板缓鏂囦欢鎿嶄綔 鎴愬姛鎵ц");
    }
    catch (Exception e)
    {
      System.out.println("鏂板缓鐩綍鎿嶄綔鍑洪敊");
      e.printStackTrace();
    }
  }
  
  public static void delFile(String filePathAndName)
  {
    try
    {
      String filePath = filePathAndName;
      filePath = filePath.toString();
      File myDelFile = new File(filePath);
      myDelFile.delete();
      System.out.println("鍒犻櫎鏂囦欢鎿嶄綔 鎴愬姛鎵ц");
    }
    catch (Exception e)
    {
      System.out.println("鍒犻櫎鏂囦欢鎿嶄綔鍑洪敊");
      e.printStackTrace();
    }
  }
  
  public static void delFolder(String folderPath)
  {
    try
    {
      delAllFile(folderPath);
      String filePath = folderPath;
      filePath = filePath.toString();
      File myFilePath = new File(filePath);
      if (myFilePath.delete()) {
        System.out.println("鍒犻櫎鏂囦欢澶�" + folderPath + "鎿嶄綔 鎴愬姛鎵ц");
      } else {
        System.out.println("鍒犻櫎鏂囦欢澶�" + folderPath + "鎿嶄綔 鎵ц澶辫触");
      }
    }
    catch (Exception e)
    {
      System.out.println("鍒犻櫎鏂囦欢澶规搷浣滃嚭閿�");
      e.printStackTrace();
    }
  }
  
  public static void delAllFile(String path)
  {
    File file = new File(path);
    if (!file.exists()) {
      return;
    }
    if (!file.isDirectory()) {
      return;
    }
    String[] tempList = file.list();
    File temp = null;
    for (int i = 0; i < tempList.length; i++)
    {
      if (path.endsWith(File.separator)) {
        temp = new File(path + tempList[i]);
      } else {
        temp = new File(path + File.separator + tempList[i]);
      }
      if (temp.isFile()) {
        temp.delete();
      }
      if (temp.isDirectory()) {
        delFolder(path + File.separatorChar + tempList[i]);
      }
    }
    System.out.println("鍒犻櫎鏂囦欢鎿嶄綔 鎴愬姛鎵ц");
  }
  
  public static void copyFile(String oldPath, String newPath)
  {
    try
    {
      int bytesum = 0;
      int byteread = 0;
      File oldfile = new File(oldPath);
      if (oldfile.exists())
      {
        InputStream inStream = new FileInputStream(oldPath);
        FileOutputStream fs = new FileOutputStream(newPath);
        byte[] buffer = new byte['证'];
        while ((byteread = inStream.read(buffer)) != -1)
        {
          bytesum += byteread;
          
          fs.write(buffer, 0, byteread);
        }
        inStream.close();
      }
    }
    catch (Exception e)
    {
      System.out.println("澶嶅埗鍗曚釜鏂囦欢鎿嶄綔鍑洪敊");
      e.printStackTrace();
    }
  }
  
  public static void copyFolder(String oldPath, String newPath)
  {
    try
    {
      new File(newPath).mkdirs();
      File a = new File(oldPath);
      String[] file = a.list();
      File temp = null;
      for (int i = 0; i < file.length; i++)
      {
        if (oldPath.endsWith(File.separator)) {
          temp = new File(oldPath + file[i]);
        } else {
          temp = new File(oldPath + File.separator + file[i]);
        }
        if (temp.isFile())
        {
          FileInputStream input = new FileInputStream(temp);
          FileOutputStream output = new FileOutputStream(newPath + "/" + 
            temp.getName().toString());
          byte[] b = new byte[512];
          int len;
          while ((len = input.read(b)) != -1)
          {
            //int len;
            output.write(b, 0, len);
          }
          output.flush();
          output.close();
          input.close();
        }
        if (temp.isDirectory()) {
          copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
        }
      }
      System.out.println("澶嶅埗鏂囦欢澶规搷浣� 鎴愬姛鎵ц");
    }
    catch (Exception e)
    {
      System.out.println("澶嶅埗鏁翠釜鏂囦欢澶瑰唴瀹规搷浣滃嚭閿�");
      e.printStackTrace();
    }
  }
  
  public static void moveFile(String oldPath, String newPath)
  {
    copyFile(oldPath, newPath);
    delFile(oldPath);
  }
  
  public static void moveFolder(String oldPath, String newPath)
  {
    copyFolder(oldPath, newPath);
    delFolder(oldPath);
  }
  
  public static void main(String[] args)
  {
    boolean exitnow = false;
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠1]  鍔熻兘涓�锛氭柊寤虹洰褰�");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠2]  鍔熻兘浜岋細鏂板缓鏂囦欢");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠3]  鍔熻兘涓夛細鍒犻櫎鏂囦欢");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠4]  鍔熻兘鍥涳細鍒犻櫎鏂囦欢澶�");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠5]  鍔熻兘浜旓細鍒犻櫎鏂囦欢澶归噷闈㈢殑鎵�鏈夋枃浠�");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠6]  鍔熻兘鍏細澶嶅埗鏂囦欢");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠7]  鍔熻兘涓冿細澶嶅埗鏂囦欢澶圭殑鎵�鏈夊唴瀹�");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠8]  鍔熻兘鍏細绉诲姩鏂囦欢鍒版寚瀹氱洰褰�");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠9]  鍔熻兘涔濓細绉诲姩鏂囦欢澶瑰埌鎸囧畾鐩綍");
    System.out.println("浣跨敤姝ゅ姛鑳借鎸塠10] 閫�鍑虹▼搴�");
    while (!exitnow) {
      try
      {
        BufferedReader Bin = new BufferedReader(new InputStreamReader(System.in));
        String a = Bin.readLine();
        int b = Integer.parseInt(a);
        String aa;
        switch (b)
        {
        case 1: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒竴  璇疯緭鍏ョ洰褰曞悕");
          aa = Bin.readLine();
          
          break;
        case 2: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒簩  璇疯緭鍏ユ枃浠跺悕");
          aa = Bin.readLine();
          System.out.println("璇疯緭鍏ュ湪" + aa + "涓殑鍐呭");
          String bb = Bin.readLine();
          newFile(aa, bb);
          break;
        case 3: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒笁  璇疯緭鍏ユ枃浠跺悕");
          aa = Bin.readLine();
          delFile(aa);
          break;
        case 4: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳藉洓  璇疯緭鍏ユ枃浠跺悕");
          aa = Bin.readLine();
          delFolder(aa);
          break;
        case 5: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒簲  璇疯緭鍏ユ枃浠跺悕");
          aa = Bin.readLine();
          delAllFile(aa);
          break;
        case 6: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳藉叚  璇疯緭鍏ユ枃浠跺悕");
          aa = Bin.readLine();
          System.out.println("璇疯緭鍏ョ洰鏍囨枃浠跺悕");
          bb = Bin.readLine();
          copyFile(aa, bb);
          break;
        case 7: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒竷  璇疯緭鍏ユ簮鏂囦欢鍚�");
          aa = Bin.readLine();
          System.out.println("璇疯緭鍏ョ洰鏍囨枃浠跺悕");
          bb = Bin.readLine();
          copyFolder(aa, bb);
          break;
        case 8: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳藉叓  璇疯緭鍏ユ簮鏂囦欢鍚�");
          aa = Bin.readLine();
          System.out.println("璇疯緭鍏ョ洰鏍囨枃浠跺悕");
          bb = Bin.readLine();
          moveFile(aa, bb);
          break;
        case 9: 
          System.out.println("浣犻�夋嫨浜嗗姛鑳戒節  璇疯緭鍏ユ簮鏂囦欢鍚�");
          aa = Bin.readLine();
          System.out.println("璇疯緭鍏ョ洰鏍囨枃浠跺悕");
          bb = Bin.readLine();
          moveFolder(aa, bb);
          break;
        case 10: 
          exitnow = true;
          System.out.println("绋嬪簭缁撴潫锛岃閫�鍑�");
          break;
        default: 
          System.out.println("杈撳叆閿欒.璇疯緭鍏�1-10涔嬮棿鐨勬暟");
        }
        System.out.println("璇烽噸鏂伴�夋嫨鍔熻兘");
      }
      catch (Exception e)
      {
        System.out.println("杈撳叆閿欒瀛楃鎴栫▼搴忓嚭閿�");
      }
    }
  }
}
