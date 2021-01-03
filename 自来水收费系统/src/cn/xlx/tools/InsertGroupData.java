package cn.xlx.tools;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class InsertGroupData {
	public void insert(String path,String dataTable) throws BiffException, IOException { 
        
        File file = new File(path);           
        // 创建新的Excel 工作簿  
        Workbook rwb = null;  
        rwb = Workbook.getWorkbook(file);  
          
        // 得到工作簿中的第一个表索引即为excel下的sheet1,sheet2,sheet3…  
        Sheet sheet = rwb.getSheets()[0];  
        int rsColumns = sheet.getColumns();// 列数  
        int rsRows = sheet.getRows();// 行数  
        String simNumber = "" ;//每个单元格中的数据  
          
        DBUtils jdbc=new DBUtils();  
          
        String str="" ;//拼接要插入的列  
            for (int j = 0; j <rsColumns; j++) {  
                Cell cell = sheet.getCell(j, 0);  
                simNumber = cell.getContents();  
                if(j==rsColumns-1){  
                    str +=  simNumber  ;  
                }else{  
                    str +=  simNumber+",";  
                }  
                  
            }  
        for (int i = 1; i < rsRows; i++) {  
              
            String sql = "insert into "+dataTable+"("+str+") values(";  //拼接sql  
            for (int j = 0; j < rsColumns; j++) {  
                Cell cell = sheet.getCell(j, i);  
                simNumber = cell.getContents();  
                if(j==rsColumns-1){  
                    sql += "'"+ simNumber+"'" ;  
                }else{  
                    sql +="'"+ simNumber+"',";  
                }  
                  
            }  
            sql += " )";  
            jdbc.executeUpdate(sql);//执行sql  
              
        }  
        jdbc.closeStmt();  
        jdbc.closeConnection();  
    }  
}
