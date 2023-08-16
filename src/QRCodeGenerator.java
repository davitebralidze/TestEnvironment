import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QRCodeGenerator {
    public static void main(String[] args) {

        generateQR(getURL());

    }

    public static String getURL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the URL you want to represent as QR code: ");
        String URL = scanner.next();
        return URL;
    }


    public static void generateQR(String websiteUrl) {

        String desktopPath = "C:\\Users\\User\\Downloads\\qrcode.png";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String MAGENTA = "\u001B[35m";
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

            File qrCodeFile = new File(desktopPath);
            ImageIO.write(qrCodeImage, "PNG", qrCodeFile);

            System.out.println(GREEN + "QR code generated successfully! The file is saved in the " + MAGENTA+ "Downloads" + GREEN + " folder");

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(qrCodeFile);
            } else {
                System.out.println(RED + "Desktop integration not supported.");
            }

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}