package jstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CharacterStreamRead {
}

class GfG
{
    public static void main(String[] args) throws IOException
    {

        // character stream
        FileReader sourceStream = null;
        try
        {
            sourceStream = new FileReader("mycharread.txt");

            // Reading sourcefile and writing content to
            // target file character by character.
            int temp;
            while ((temp = sourceStream.read()) != -1)
                System.out.println((char)temp);
        }
        finally
        {
            // Closing stream as no longer in use
            if (sourceStream != null)
                sourceStream.close();
        }
        //byte stream
        FileInputStream bstreamInp = null;
        FileOutputStream targetStream = null;

        try
        {
            bstreamInp = new FileInputStream("mycharread.txt");
            targetStream = new FileOutputStream ("targetfile.txt");

            // Reading source file and writing content to target
            // file byte by byte
            int temp;
            while ((temp = bstreamInp.read()) != -1)
                System.out.println((byte)temp);
        }
        finally
        {
            if (sourceStream != null)
                sourceStream.close();
            if (targetStream != null)
                targetStream.close();
        }







    }
}