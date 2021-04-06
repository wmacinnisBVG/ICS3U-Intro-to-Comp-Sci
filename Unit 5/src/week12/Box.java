package week12;

public class Box extends Rectangle{
    private double height;
    public Box(double length, double width, double height){
        super(length, width);
        this.height = height;

    }



    public double getHeight() throws Exception{
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return super.getArea() * height;
    }

    public double getSurfaceArea(){
        return 2*super.getLength()*super.getWidth()+2*super.getLength()*height+2*height*super.getWidth(); 
    }

    public double getPerimiter() {
        return height*4+super.getWidth()*4+super.getLength()*4;

    }
    public double getSquare() throws Exception{
        throw new Exception("getSquare is not accessible through this..");
    }
}
