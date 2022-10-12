
import java.io.File;
import java.util.Random;
import java.io.IOException;
import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CreateList {
	public static void main(String[] args) throws BiffException, IOException {
		int c_id=1;
		for(c_id=1;c_id<=5;c_id++)
		{
			//打开文件
			Workbook book = Workbook.getWorkbook(new File("D:\\class" + c_id + ".xls"));
			//获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			//获得第一列第一行的单元格
			int i=1,j=0,k1,k2;	//i为行号，j为列号
			Cell cell = sheet.getCell(0, 1);
			NumberCell num;
			Person[] arr1 = new Person[90];
	        Person[] arr2 = new Person[90];
	        int cnt1=0,cnt2=0;
	
			for(i=1,k1=0,k2=0;i<sheet.getRows();i++)
			{	
				j=0;
				cell = sheet.getCell(j++,i);
				String id = cell.getContents();
				cell = sheet.getCell(j++,i);
				String name = cell.getContents();
				cell = sheet.getCell(j++,i);
				String sex = cell.getContents();
				num = (NumberCell)sheet.getCell(j++,i);
				double success = num.getValue();
				num = (NumberCell)sheet.getCell(j++,i);
				double total = num.getValue();
				num = (NumberCell)sheet.getCell(j++,i);
				double rate = num.getValue();
				arr1[k1] = new Person();
				arr2[k2] = new Person();
				if(rate<0.7&&total<=3) 
				{
					//正常学生
					arr1[k1].setId(id);
					arr1[k1].setName(name);
					arr1[k1].setSex(sex);
					arr1[k1].setSuccess(success);
					arr1[k1].setTotal(total);
					arr1[k1++].setRate(total, success);
					cnt1++;
				}
				else
				{
					//重点关注学生
					arr2[k2].setId(id);
					arr2[k2].setName(name);
					arr2[k2].setSex(sex);
					arr2[k2].setSuccess(success);
					arr2[k2].setTotal(total);
					arr2[k2++].setRate(total, success);
					cnt2++;
				}
				
				//System.out.println("学号："+id+" 姓名：" + name + "   \t性别：" + sex + " 有效次数：" + success + "  \t总次数：" + total + "  \tE=" + rate);
			}
			//定义和初始化随机数数组
			int r_cnt1 = cnt2<=24 ? 30-cnt2 : 6;
			int r_cnt2 = cnt2<=24 ? cnt2 : 24;
			int[] randarr1 = new int[r_cnt1];
			int[] randarr2 = new int[r_cnt2];
			for(i=0;i<r_cnt1;i++) randarr1[i]=-1;
			for(i=0;i<r_cnt2;i++) randarr2[i]=-1;
			//设置随机数
			for(i=0;i<r_cnt1;i++)
			{
				int x = new Random().nextInt(cnt1);
				int flag=0;
				for(j=0;j<=i;j++)
				{
					if(randarr1[j]==x) flag=1;
				}
				if(flag==0) randarr1[i]=x;
				else i--;
			}
			for(i=0;i<r_cnt2;i++)
			{
				int x = new Random().nextInt(cnt2);
				int flag=0;
				for(j=0;j<=i;j++)
				{
					if(randarr2[j]==x) flag=1;
				}
				if(flag==0) randarr2[i]=x;
				else i--;
			}
			//打印名单
			System.out.println("班级"+ c_id + "抽点名单");
			for(i=0;i<r_cnt1;i++) System.out.println(i+1 + "\t学号：" + arr1[randarr1[i]].getId() + "\t姓名：" + arr1[randarr1[i]].getName());
			for(i=0;i<r_cnt2;i++) System.out.println(i+1+r_cnt1 + "\t学号：" + arr2[randarr2[i]].getId() + "\t姓名：" + arr2[randarr2[i]].getName());
			System.out.println();
			book.close();
		}
	}
}