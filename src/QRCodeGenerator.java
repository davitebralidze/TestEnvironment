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

        generateQR(getURL(), getDesktopPath());

    }

    public static String getURL() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the URL you want to represent as QR code: ");
        String URL = scanner.next();
        return URL;
    }

    public static String getDesktopPath() {
        Scanner scanner = new Scanner(System.in);
        String desktopPath;

        do {
            System.out.println("Please enter the path of the desktop: ");
            desktopPath = scanner.nextLine() + "\\qrcode.png";

            File desktopDirectory = new File(desktopPath).getParentFile();
            if (desktopDirectory == null || !desktopDirectory.isDirectory()) {
                System.out.println("Invalid desktop path. Please enter a valid path.");
                desktopPath = null;
            }
        } while (desktopPath == null);

        return desktopPath;
    }

    public static void generateQR(String websiteUrl, String desktopPath) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
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

            System.out.println(GREEN + "QR code generated successfully!");

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