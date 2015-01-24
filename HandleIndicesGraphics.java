package start;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;

import javax.imageio.ImageIO;


public class HandleIndicesGraphics {
	static int[][] texcoords = null;
	public String GetCurrentDirectory() {
		String a = "";
		String path = HandleIndicesGraphics.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			a = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public int[][] PngGet() throws IOException {
		InputStream in2;
		String path = GetCurrentDirectory();
		String PTH = path+"Tex.png";
		System.out.println(PTH);
		File tex = new File(PTH);
		if (tex.exists()) {
			try {
				in2 = new FileInputStream(tex);
				BufferedImage in = ImageIO.read(in2);
				int width = in.getWidth();
				int height = in.getHeight();
				/*TODO: 
				 * 1) Find SpiralSpy classes (in render object?) and modify them in this code to find out how the [Censored] it tells what texture sections go where
				 * 2) Utilize those classes to create a table of locations on ____ pixel (NOTE: REQUIRES A METHOD TO GET PIXELS!)
				 * 3) Read table, grab MTL in obj file, then set texture coords: f 1/x 2/y/ 3/z
				 */
			} catch (Exception e) {
				//Nothing
				System.out.println("Error while getting image! ("+e+")");
			}
		} else {
			System.out.println("No Tex.png file found. Ignoring textures.");
		}
		return texcoords;
	}
}
