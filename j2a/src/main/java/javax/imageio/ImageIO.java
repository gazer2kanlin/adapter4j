package javax.imageio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageIO {

    public static BufferedImage read(File file) throws IOException {
        try {
            return read(new FileInputStream(file));
        }
        catch(IOException ex1) {
            throw ex1;
        }
        catch (Exception ex2) {
            throw new IOException(ex2);
        }
    }

    public static BufferedImage read(InputStream is) throws IOException {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(new BufferedInputStream(is));
            return new BufferedImage(bitmap);
        }
        catch (Exception ex2) {
            throw new IOException(ex2);
        }
    }

    public static boolean write(RenderedImage image, String formatName, File file) throws IllegalArgumentException, IOException {
        try {
            BufferedImage bimage = (BufferedImage)image;
            FileOutputStream out = new FileOutputStream(file);
            if ("png".equalsIgnoreCase(formatName)) {
                bimage.bitmapAndroid().compress(Bitmap.CompressFormat.PNG, 90, out);
            } else {
                bimage.bitmapAndroid().compress(Bitmap.CompressFormat.JPEG, 90, out);
            }
            out.flush();
            out.close();
            return true;
        }
        catch(IOException ex1) {
            throw ex1;
        }
        catch (Exception ex2) {
            throw new IOException(ex2);
        }
    }

    public static boolean write(RenderedImage image, String formatName, OutputStream out) throws IllegalArgumentException, IOException {
        try {
            BufferedImage bimage = (BufferedImage)image;
            if ("png".equalsIgnoreCase(formatName)) {
                bimage.bitmapAndroid().compress(Bitmap.CompressFormat.PNG, 90, out);
            } else {
                bimage.bitmapAndroid().compress(Bitmap.CompressFormat.JPEG, 90, out);
            }
            out.flush();
            return true;
        }
        catch(IOException ex1) {
            throw ex1;
        }
        catch (Exception ex2) {
            throw new IOException(ex2);
        }
    }}
