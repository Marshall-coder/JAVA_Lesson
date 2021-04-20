package Examples.test_thread;

public class Ticket {
    //java Bean     POJO
    //一个对象 包含很多属性 增强可读性
    private String start;//起始站名
    private String end;//终点站名
    private Float price;//票价(大写Float是包装类 可以存null 安全，小写不能)

    public Ticket(){}
    public Ticket(String start,String end,Float price){
        this.start=start;
        this.end=end;
        this.price=price;
    }
    //打了打印输出时方便 从写toString方法(否则是hashcode值) 打印一个对象
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("[");
        builder.append(this.start);
        builder.append("-->");
        builder.append(this.end);
        builder.append(":");
        builder.append(this.price);
        builder.append("]");
        return builder.toString();
    }


    public String getStart() {
        return start;
    }
    public void setStart(String start){
        this.start=start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

}
