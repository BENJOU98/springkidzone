package tn.jardindenfant.entities;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class EnfantExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Enfant> listE;
     
    public EnfantExcel(List<Enfant> listE2) {
        this.listE = listE2;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Enfants");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
       
        createCell(row, 0, "Nom de l'enfant", style);  
        createCell(row, 1, "Age", style);  
        createCell(row, 2, "Date de naissance", style);    
        createCell(row, 3, "Sexe", style);
        createCell(row, 4, "Taille", style);  
       
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Enfant enfant  : listE) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            
            createCell(row, columnCount++, String.valueOf(enfant.getNom()), style);
            createCell(row, columnCount++, String.valueOf(enfant.getAge()), style);
            createCell(row, columnCount++, String.valueOf(enfant.getDateN()), style);
            createCell(row, columnCount++, String.valueOf(enfant.getSexe()), style);
            createCell(row, columnCount++, String.valueOf(enfant.getTaille()), style);
            
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
	

}