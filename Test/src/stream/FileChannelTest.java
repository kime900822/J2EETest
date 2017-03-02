package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	public static void main(String[] args) {
		FileChannel inChannel=null;
		FileChannel outChannel=null;
		try {
			File f=new File("FileChannelTest.java");
			inChannel=new FileInputStream(f).getChannel();
			MappedByteBuffer buffer=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			//使用GBK的字符集来创建解码器
			Charset charset=Charset.forName("GBK");
			outChannel=new FileOutputStream("a.txt").getChannel();
			outChannel.write(buffer);
			buffer.clear();
			CharsetDecoder decoder=charset.newDecoder();
			CharBuffer charBuffer=decoder.decode(buffer);
			System.out.println(charBuffer);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (inChannel !=null) {
					inChannel.close();
				}
				if (outChannel!=null) {
					outChannel.close();
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
