import java.io.*;
public class RepeatString {

    static int getVersion(){
        String version = System.getProperty("java.version");
        if(version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if(dot != -1) { version = version.substring(0, dot); }
        } 
        return Integer.parseInt(version);
    }

    static String repeatString(String str,int count){
        if(count < 0)
            return "Invalid Count!!";
        if(count == 1 || count == 0)
            return str;
        else
            return str + repeatString(str, count-1);
    }

    static String repeatUsingJava(String str,int count){
        return str.repeat(count);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String : ");
        String str = buffer.readLine();
        System.out.println("\nEnter Repeation Number : ");
        int count = Integer.parseInt(buffer.readLine());
        if(getVersion() >= 11)
            str =repeatUsingJava(str, count);
        else
            str = repeatString(str,count);
        System.out.println("Repeated String : "+str);
        buffer.close();
    }
}
