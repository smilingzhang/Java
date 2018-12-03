import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelPoi {

	public ExcelPoi() {
		// TODO 自动生成的构造函数存根
	} 
	
	public static void main(String[] args) throws Exception {
        /**
         * 注意这只是07版本以前的做法对应的excel文件的后缀名为.xls
         * 07版本和07版本以后的做法excel文件的后缀名为.xlsx
         */
        //创建新工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //新建工作表 
        HSSFSheet sheet = workbook.createSheet("hello");
        //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
        HSSFRow row ;
        HSSFCell cell;
        for(int i=0;i<20;i++) {
        	row = sheet.createRow(i);
        	  for(int j=0;j<10;j++) {
             	 cell = row.createCell(j);
             	 cell.setCellValue("hello sheet");
             }
        }
      
        //创建单元格,row已经确定了行号,列号作为参数传递给createCell(),第一列从0开始计算
       
      
        
        //设置单元格的值,即C1的值(第一行,第三列)
       
        //输出到磁盘中
        FileOutputStream fos = new FileOutputStream(new File("D:\\360DownLoads\\11.xls"));
        workbook.write(fos);
        
        workbook.close();
        fos.close();
        System.out.println("finish!");
    }
}
