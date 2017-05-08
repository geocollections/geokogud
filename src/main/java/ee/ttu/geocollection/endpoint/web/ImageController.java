package ee.ttu.geocollection.endpoint.web;

import ee.ttu.geocollection.core.domain.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@RestController
public class ImageController {

    @Autowired
    private AppConfig appConfig;

    private static final String JPG = "jpg";

    private static final String DELIMITER = "/";
    private static final String VAR = "var";
    private static final String WWW = "www";
    private static final String IMAGE = "image";
    public static final String SPECIMEN = "specimen";

    @GetMapping(value = "/img/{dbAcronym}/{series}/{number}/{fileName}/{width}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] retrieveImage(
            @PathVariable String dbAcronym,
            @PathVariable String series,
            @PathVariable String number,
            @PathVariable String fileName,
            @PathVariable Integer width) throws IOException {
        if (appConfig.useLegacyImageResolver) {
            return fetchImageFromLegacyApp(dbAcronym, series, number, fileName, width);
        } else {
            return fetchImageFromLocalStorage(dbAcronym, series, number, fileName, width);
        }
    }

    private byte[] fetchImageFromLocalStorage(
            @PathVariable String dbAcronym,
            @PathVariable String series,
            @PathVariable String number,
            @PathVariable String fileName,
            @PathVariable Integer width) throws IOException {
        File imageFile = new File(
                DELIMITER + VAR + DELIMITER + WWW + DELIMITER
                        + dbAcronym + DELIMITER
                        + IMAGE + DELIMITER
                        + series + DELIMITER
                        + number + DELIMITER
                        + fileName);
        BufferedImage image = ImageIO.read(imageFile);
        Dimension resizedDimension = calculateNewDimension(new Dimension(image.getWidth(), image.getHeight()), width);
        BufferedImage resizedImage = resizeImage(image, resizedDimension);

        return convertToByArray(resizedImage);
    }

    private byte[] fetchImageFromLegacyApp(
            @PathVariable String dbAcronym,
            @PathVariable String series,
            @PathVariable String number,
            @PathVariable String fileName,
            @PathVariable Integer width) throws IOException {
        URL url = new URL(
                "http://geokogud.info/di.php?f=/var/www/" + dbAcronym
                        + DELIMITER + IMAGE
                        + DELIMITER + series
                        + DELIMITER + number
                        + DELIMITER + fileName
                        + "&w=" + width);
        BufferedImage image = ImageIO.read(url);
        return convertToByArray(image);
    }

    private byte[] convertToByArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, JPG, outputStream);
        return outputStream.toByteArray();
    }

    private Dimension calculateNewDimension(Dimension imgSize, Integer boundWidth) {
        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int new_width = original_width;
        int new_height = original_height;
        // check if we need to scale width
        if (original_width > boundWidth) {
            //scale width to fit
            new_width = boundWidth;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }
        return new Dimension(new_width, new_height);
    }

    private BufferedImage resizeImage(Image originalImage, Dimension dimension) {
        int type = BufferedImage.TYPE_INT_RGB;
        int height = (int) dimension.getHeight();
        int width = (int) dimension.getWidth();

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();

        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

//    @GetMapping(value = "/specimenImg/{dbAcronym}/{imagePath}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public byte[] retrieveSpecimenImage(@PathVariable String dbAcronym, @PathVariable String imagePath) {
//        File imageFile = new File(
//                DELIMITER + VAR + DELIMITER + WWW + DELIMITER
//                        + dbAcronym + DELIMITER
//                        + IMAGE + DELIMITER
//                        + SPECIMEN + DELIMITER
//                        + imagePath);
//
//    }
}
