package junit;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import sun.misc.BASE64Decoder;
 
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
/**
 * 作用：二维码识别（图片）
 * 作者：Tiddler
 * 时间：2018-08-2018/8/31 16：23
 * 类名：QRCodeTools
 **/
public class QRCodeTools {
   
    	/*@SuppressWarnings("unchecked")
    	public static void main(String[] args) {
    		try {
    			MultiFormatReader formatReader = new MultiFormatReader();
    			//读取指定的二维码文件
    			FileInputStream   file= new FileInputStream ("D:\\xlk.jpg");
    			BufferedImage bufferedImage =ImageIO.read(file);
    			BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
    			//定义二维码参数
    			Map  hints= new HashMap<>();
    			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    			Result result = formatReader.decode(binaryBitmap, hints);
    			//输出相关的二维码信息
    			System.out.println("解析结果"+result.toString());
    			System.out.println("二维码格式类型"+result.getBarcodeFormat());
    			System.out.println("二维码文本内容"+result.getText());
    			if(result.getText().indexOf("u.wechat.com")>-1){
    				System.out.println("xlk");
    			}
    			bufferedImage.flush();
    		} catch (NotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {		
    			e.printStackTrace();
    		}
    	}*/
    
	private static int WIDTH=300;
	private static int HEIGHT=300;
	private static String FORMAT="jpg";//二维码格式
	
    public static void main(String[] args) throws IOException {
    	ServletOutputStream stream = null;
    	String content = "https://u.wechat.com/EDIoysr9QxWe89k9KdVglh0";
    	Map<Object,Object> hints=new HashMap<Object,Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置编码
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//设置容错等级
		hints.put(EncodeHintType.MARGIN, 2);//设置边距默认是5
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
			Path path = new File("D:\\111.jpg").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, path);//写到指定路径下
			BufferedImage bImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
			System.out.println(bImage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
	        if(stream != null){
	            stream.flush();
	            stream.close();
	         }
		}

	}
}
