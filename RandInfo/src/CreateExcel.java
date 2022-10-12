
import java.io.File;   
import jxl.Workbook;  
import jxl.write.Label;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;  
import jxl.write.Number;  


public class CreateExcel {
    public static void main(String[] args) {
        for(int k=1 ; k<=5 ;k++) {
            RandInfo rand = new RandInfo();
            Person person = new Person();
            try {
             // 打开文件  
                WritableWorkbook book = Workbook.createWorkbook(new File("E:/class"+k+".xls"));  
             // 生成名为“sheet1”的工作表，参数0表示这是第一页  
                WritableSheet sheet = book.createSheet("sheet1", 0);  
                // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容位学号  
                Label label = new Label(0, 0, "学号");  
                // 将定义好的单元格添加到工作表中  
                sheet.addCell(label);  
                //单元格位置是第二列，第一行，单元格的内容为姓名 
                label = new Label(1, 0, "姓名");  
                sheet.addCell(label);  
                label = new Label(2, 0, "性别");  
                sheet.addCell(label);
                label = new Label(3, 0, "有效次数");  
                sheet.addCell(label);  
                label = new Label(4, 0, "总次数");  
                sheet.addCell(label);
                label = new Label(5, 0, "E值");  
                sheet.addCell(label);
                Number number;
                // 写入数据并关闭文件 
                for (int i = 1;i <= 90; i++){
                    String familyName = rand.getFamilyName();
                    String[] nameAndSex = rand.getNameAndSex(rand.getSex());
                    String name = nameAndSex[0];
                    String sex = nameAndSex[1];
                    String id = rand.getId();
                    int[] arr = rand.getsuccessandtotal();
                    int success = arr[0];
                    int total = arr[1];
        
                    person.setName(familyName.concat(name));
                    person.setSex(sex);
                    person.setId(id);
                    person.setSuccess(success);
                    person.setTotal(total);
                    person.setRate(total, success);
                    System.out.println(person);
                    
                    //写入数据
                    label = new Label(0, i, id);
                    sheet.addCell(label);
                    label = new Label(1, i, familyName+name);
                    sheet.addCell(label);
                    label = new Label(2, i, sex);
                    sheet.addCell(label);
                    number = new Number(3, i, success);  
                    sheet.addCell(number);
                    number = new Number(4, i, total);  
                    sheet.addCell(number);
                    number = new Number(5, i, (1.0*success)/(1.0*total));  
                    sheet.addCell(number);
                }
                book.write();  
                book.close();
            }catch (Exception e) {  
                System.out.println(e); 
            }
        }
    }
}