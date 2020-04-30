import java.util.Scanner;

public class �ι��ھ�_8741{
public static void main(String[]args){
        // TODO Auto-generated method stub
        String message;
        Scanner scan=new Scanner(System.in);

        int T=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<T; i++){
        message=scan.nextLine();
        String result=Name(message);
        System.out.println("#"+(i+1)+" "+result);
        }
        }

public static String Name(String message){
        String data[]=message.split(" ");
        String result="";
        for(int i=0;i< 3;i++){
        result+=data[i].substring(0,1).toUpperCase();
        }
        return result;
        }
        }
