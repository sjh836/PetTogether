package syu.DBproject.view;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
 
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import syu.DBproject.biz.pet.PetVO;


@Component("petPdf")
public class PdfView2 extends AbstractPdfView
{
    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        List<PetVO> petList = (List<PetVO>)map.get("petList");
        Table table = new Table(3, petList.size() + 1);
        table.setPadding(5);
        BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font font = new Font(bfKorean);
        Cell cell = new Cell(new Paragraph("삼냥이명", font));
        cell.setHeader(true);
        table.addCell(cell);
        cell = new Cell(new Paragraph("등록자명", font));
        table.addCell(cell);
        cell = new Cell(new Paragraph("서식지", font));
        table.addCell(cell);
        table.endHeaders();
 
        for (PetVO pet : petList)
        {
            table.addCell(new Paragraph(pet.getTitle(), font));
            table.addCell(new Paragraph(pet.getWriter(), font));
            table.addCell(new Paragraph(pet.getHabitat(), font));
        }
        document.add(table);
    }
}