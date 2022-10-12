
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
             // ���ļ�  
                WritableWorkbook book = Workbook.createWorkbook(new File("E:/class"+k+".xls"));  
             // ������Ϊ��sheet1���Ĺ���������0��ʾ���ǵ�һҳ  
                WritableSheet sheet = book.createSheet("sheet1", 0);  
                // ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0),��Ԫ������λѧ��  
                Label label = new Label(0, 0, "ѧ��");  
                // ������õĵ�Ԫ����ӵ���������  
                sheet.addCell(label);  
                //��Ԫ��λ���ǵڶ��У���һ�У���Ԫ�������Ϊ���� 
                label = new Label(1, 0, "����");  
                sheet.addCell(label);  
                label = new Label(2, 0, "�Ա�");  
                sheet.addCell(label);
                label = new Label(3, 0, "��Ч����");  
                sheet.addCell(label);  
                label = new Label(4, 0, "�ܴ���");  
                sheet.addCell(label);
                label = new Label(5, 0, "Eֵ");  
                sheet.addCell(label);
                Number number;
                // д�����ݲ��ر��ļ� 
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
                    
                    //д������
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