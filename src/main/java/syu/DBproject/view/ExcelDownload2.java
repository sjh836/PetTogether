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

import syu.DBproject.biz.pet.PetVO;

@Component("petExcel")
public class ExcelDownload2 extends AbstractXlsView
{
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"PetOutput.xls\"");

        @SuppressWarnings("unchecked")
        List<PetVO> petList = (List<PetVO>) model.get("petList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("����� ����̸��");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("��ȣ");
        header.createCell(1).setCellValue("����̸�");
        header.createCell(2).setCellValue("�����");
        header.createCell(3).setCellValue("������");
        header.createCell(4).setCellValue("��ϳ�¥");
        header.createCell(5).setCellValue("�������");

        // Create data cells
        int rowCount = 1;
        for (PetVO pet : petList)
        {
            Row memberRow = sheet.createRow(rowCount++);
            memberRow.createCell(0).setCellValue(pet.getPno());
            memberRow.createCell(1).setCellValue(pet.getTitle());
            memberRow.createCell(2).setCellValue(pet.getWriter());
            memberRow.createCell(3).setCellValue(pet.getHabitat());
            memberRow.createCell(4).setCellValue(DATE_FORMAT.format(pet.getRegDate()));
            memberRow.createCell(5).setCellValue(pet.getImagePath());
        }
        
	}
}
