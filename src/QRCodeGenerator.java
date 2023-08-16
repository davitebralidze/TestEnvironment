import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeGenerator {
    public static void main(String[] args) {

        String websiteUrl = "https://google.com";
        String qrCodeFilePath = "C:\\Users\\User\\OneDrive - Flat Rock Technology\\Desktop\\qrcode.png";

        int width = 300;
        int height = 300;

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(websiteUrl, BarcodeFormat.QR_CODE, width, height);
            BufferedImage qrCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    qrCodeImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }

            File qrCodeFile = new File(qrCodeFilePath);
            ImageIO.write(qrCodeImage, "PNG", qrCodeFile);

            System.out.println("QR code generated successfully!");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(qrCodeFile);
            } else {
                System.out.println("Desktop integration not supported.");
            }

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}