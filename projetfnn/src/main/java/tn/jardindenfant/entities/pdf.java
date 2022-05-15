package tn.jardindenfant.entities;




import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



public class pdf {
	
	 private List<Rendez_vous> meetings;
     
	    public pdf(List<Rendez_vous> meetings) {
	        this.meetings = meetings;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(3);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Rendez_vous  ID", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Date", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("OBJECT", font));
	        table.addCell(cell);
	         
	      
	    }
	     
	    private void writeTableData(PdfPTable table) {
	    	  for (Rendez_vous meeting : meetings) {
	            table.addCell(String.valueOf(meeting.getIdRdv()));
	            table.addCell(meeting.getDateMeeting().toString());
	            table.addCell(String.valueOf(meeting.getObjetMeeting()));
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Meetings", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(3);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }

}