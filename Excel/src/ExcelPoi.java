import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelPoi {

	public ExcelPoi() {
		// TODO �Զ����ɵĹ��캯�����
	} 
	
	public static void main(String[] args) throws Exception {
        /**
         * ע����ֻ��07�汾��ǰ��������Ӧ��excel�ļ��ĺ�׺��Ϊ.xls
         * 07�汾��07�汾�Ժ������excel�ļ��ĺ�׺��Ϊ.xlsx
         */
        //�����¹�����
        HSSFWorkbook workbook = new HSSFWorkbook();
        //�½������� 
        HSSFSheet sheet = workbook.createSheet("hello");
        //������,�к���Ϊ�������ݸ�createRow()����,��һ�д�0��ʼ����
        HSSFRow row ;
        HSSFCell cell;
        for(int i=0;i<20;i++) {
        	row = sheet.createRow(i);
        	  for(int j=0;j<10;j++) {
             	 cell = row.createCell(j);
             	 cell.setCellValue("hello sheet");
             }
        }
      
        //������Ԫ��,row�Ѿ�ȷ�����к�,�к���Ϊ�������ݸ�createCell(),��һ�д�0��ʼ����
       
      
        
        //���õ�Ԫ���ֵ,��C1��ֵ(��һ��,������)
       
        //�����������
        FileOutputStream fos = new FileOutputStream(new File("D:\\360DownLoads\\11.xls"));
        workbook.write(fos);
        
        workbook.close();
        fos.close();
        System.out.println("finish!");
    }
}
