
public class Person {
    private String name;
    private String sex;
    private String id;
    private int total;
    private int success;
    private double rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public int total() {
    	return total;
    }
    
    public void setTotal(int total) {
    	this.total = total;
    }
    
    public int success() {
    	return success;
    }
    
    public void setSuccess(int success) {
    	this.success = success;
    }
    
    public double rate() {
    	return rate;
    }
    
    public void setRate(int total,int success) {
    	this.rate = 1.0*success/total;
    }
    
    @Override
    public String toString() {  
         return "Ñ§ºÅ='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", success=" + success +
                ", total=" + total +
                ", rate=" + rate +
                ", name=" + name ;
    }
}