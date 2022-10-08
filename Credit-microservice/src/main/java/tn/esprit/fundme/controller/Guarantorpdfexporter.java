package tn.esprit.fundme.controller;

import java.util.List;
import java.awt.Color;
import java.io.IOException;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import tn.esprit.fundme.entities.Repayment;
 
public class Guarantorpdfexporter {
	private List<Repayment> listGuarantor;
      public Guarantorpdfexporter(List<Repayment> listGuarantor) {
        this.listGuarantor = listGuarantor;
    }
 
  private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
         
        cell.setPhrase(new Phrase("id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("term", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("amount", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("state", font));
        table.addCell(cell);
            
    }
     
    private void writeTableData(PdfPTable table) {
        for (Repayment Repayment : listGuarantor) {
            table.addCell(String.valueOf(Repayment.getID()));
            table.addCell(Repayment.getTerm().toString());
            table.addCell(String.valueOf(Repayment.getAmount()));
            table.addCell(String.valueOf(Repayment.isState()));

 
            
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of unpaid Repayment guaranteed ", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f });
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
 
}