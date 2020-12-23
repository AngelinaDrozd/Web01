package servlets.servlets;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.SubjectDao;
import dao.SubjectDaoImpl;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PdfCreatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document doc = new Document();
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(doc, baos);
            doc.open();
            doc.add(new Paragraph(
                    "1. Angelina Drozd"
            ));
            pdfWriter.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        resp.setHeader("Expires", "0");
        resp.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        resp.setHeader("Pragma", "public");
        resp.setContentType("application/pdf");
        resp.setContentLength(baos.size());
        OutputStream os = resp.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();

    }
}
