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

import syu.DBproject.biz.member.MemberVO;

@Component("memberPdf")
public class PdfView extends AbstractPdfView
{
    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        List<MemberVO> memberList = (List<MemberVO>)map.get("memberList");
        Table table = new Table(3, memberList.size() + 1);
        table.setPadding(5);
        BaseFont bfKorean = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font font = new Font(bfKorean);
        Cell cell = new Cell(new Paragraph("아이디", font));
        cell.setHeader(true);
        table.addCell(cell);
        cell = new Cell(new Paragraph("이름", font));
        table.addCell(cell);
        cell = new Cell(new Paragraph("연락처", font));
        table.addCell(cell);
        table.endHeaders();
 
        for (MemberVO member : memberList)
        {
            table.addCell(new Paragraph(member.getId(), font));
            table.addCell(new Paragraph(member.getName(), font));
            table.addCell(new Paragraph(member.getTel(), font));
        }
        document.add(table);
    }
}