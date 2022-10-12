
public class Person {
    private String name;
    private String sex;
    private String id;
    private double total;
    private double success;
    private double rate;
    
    public Person() {}

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
    
    public double total() {
    	return total;
    }
    
    public void setTotal(double total) {
    	this.total = (total);
    }
    
    public double success() {
    	return success;
    }
    
    public void setSuccess(double success) {
    	this.success = success;
    }
    
    public double rate() {
    	return rate;
    }
    
    public void setRate(double total,double success) {
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