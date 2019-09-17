package laser.util;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * IO utility
 *
 * @author Marcelo Schmitt Laser
 */
public class EasyIO
{
  public static String readFile(String path)
  {
    String data = "";
    try
    {
      data = new String(Files.readAllBytes(Paths.get(path)));
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
    return data;
  }

  public static void printFile(String path, String fileName, String content)
  {
    printFile(path + File.separator + fileName, content);
  }

  public static void printFile(String fullName, String content)
  {
    File outputFile = new File(fullName);
    PrintWriter writer = initializeWriter(outputFile);
    writer.write(content);
    writer.close();
  }

  private static PrintWriter initializeWriter(File file)
  {
    PrintWriter writer = null;
    try
    {
      writer = new PrintWriter(file);
    }
    catch(FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return writer;
  }
}
