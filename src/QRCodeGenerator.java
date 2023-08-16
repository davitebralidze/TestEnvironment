import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
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

        Random random = new Random();

        int randomID = random.nextInt(100000) + 1;
        String fileName = "QR" + randomID;
        ;
        String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory() + "\\" + fileName + ".png";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String MAGENTA = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
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

            System.out.println(GREEN + "QR code has been generated successfully! The file is saved on the " + MAGENTA + "Desktop." + RESET +
                    "\nFile name: " + CYAN + fileName + YELLOW
                    +"\nThe file will be opened automatically shortly");

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