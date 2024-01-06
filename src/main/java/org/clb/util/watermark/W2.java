package org.clb.util.watermark;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.FileOutputStream;
import java.io.IOException;

public class W2 {
    public static void main(String[] args) {
//        String inputPdfPath = "path/to/input.pdf";
        String outputPdfPath = "E:\\cpms\\1.pdf";
        String watermarkText = "CyberPeace";

        try {
//            addWatermark(inputPdfPath, outputPdfPath, watermarkText);
            String extractedWatermark = extractWatermark(outputPdfPath);
            System.out.println("Extracted Watermark: " + extractedWatermark);
        } catch (IOException  e) {
//        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void addWatermark(String inputPath, String outputPath, String watermarkText)
            throws IOException, DocumentException {
        PdfReader reader = new PdfReader(inputPath);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPath));

        int totalPages = reader.getNumberOfPages();
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        for (int i = 1; i <= totalPages; i++) {
            PdfContentByte content = stamper.getUnderContent(i);
            content.beginText();
            content.setFontAndSize(base, 12);
            content.showTextAligned(PdfContentByte.ALIGN_CENTER, watermarkText, 300, 400, 45);
            content.endText();
        }

        stamper.close();
        reader.close();
    }

    private static String extractWatermark(String pdfPath) throws IOException {
        PdfReader reader = new PdfReader(pdfPath);
        int totalPages = reader.getNumberOfPages();
        StringBuilder extractedText = new StringBuilder();

        for (int i = 1; i <= totalPages; i++) {
            extractedText.append(PdfTextExtractor.getTextFromPage(reader,i));
        }

        reader.close();
        return extractedText.toString();
    }
}
