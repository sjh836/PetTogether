package syu.DBproject.view;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import syu.DBproject.biz.member.MemberVO;

@Component("memberExcel")
public class ExcelDownload extends AbstractXlsView
{
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"output.xls\"");

        @SuppressWarnings("unchecked")
        List<MemberVO> memberList = (List<MemberVO>) model.get("memberList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("동행길 활동회원");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("번호");
        header.createCell(1).setCellValue("아이디");
        header.createCell(2).setCellValue("이름");
        header.createCell(3).setCellValue("연락처");
        header.createCell(4).setCellValue("나이");
        header.createCell(5).setCellValue("활동력");
        header.createCell(6).setCellValue("가입날짜");

        // Create data cells
        int rowCount = 1;
        for (MemberVO member : memberList)
        {
            Row memberRow = sheet.createRow(rowCount++);
            memberRow.createCell(0).setCellValue(member.getMno());
            memberRow.createCell(1).setCellValue(member.getId());
            memberRow.createCell(2).setCellValue(member.getName());
            memberRow.createCell(3).setCellValue(member.getTel());
            memberRow.createCell(4).setCellValue(member.getAge());
            memberRow.createCell(5).setCellValue(member.getGrade());
            memberRow.createCell(6).setCellValue(DATE_FORMAT.format(member.getRegDate()));
        }
        
	}
}
