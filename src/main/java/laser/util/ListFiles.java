package laser.util;

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class ListFiles
{
  public static List<String> listFiles(String path, String prepend)
  {
    File base = new File(path);

    return check(prepend, base, new LinkedList<String>());
  }

  private static List<String> check(
    String prepend, File currentFile, List<String> result)
  {
    prepend += "." + currentFile.getName();

    if(currentFile.isDirectory())
    {
      String[] directory = currentFile.list();
      for(String fileName : directory)
      {
        result = check(prepend, new File(currentFile, fileName), result);
      }
    }
    else
    {
      result.add(prepend);
    }

    return result;
  }
}
