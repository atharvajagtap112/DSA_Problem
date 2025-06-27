package Java_8;



interface Parser{
     String parse(String str);
}

class StringParse{
    static public String stringParse(String str){
        return "HII";
    }
}
class MyPrinter {
    public void print(String str,Parser parser){
        str=parser.parse(str);
        System.out.println(str);
    }
}
public class Method_Reference {

    public static void main(String[] args) {
     MyPrinter mp=new MyPrinter();
     String name="Atharva";
     mp.print(name,StringParse::stringParse);
    }
}


