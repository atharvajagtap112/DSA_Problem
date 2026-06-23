package Binary_Lifting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class cat_and_tree {
    static int[] parent;
    static int[] jump;
    static boolean[] occupied;
    static int col;
    static  int[][] up;


    public static int cal(int c){
        int curr=jump[c];
        if(occupied[curr]) return 0;

        int l=1;
        for (int j=col-1;j>=0;j--){


            int node=up[curr][j];
            if (!occupied[node]){
                curr=node;
                l+= 1<<j;

            }
        }
        occupied[curr]=true;
        return l;
    }
      public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader( new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int n= Integer.parseInt( in.readLine());

        String[] arr=in.readLine().split(" ");
        parent=new int[n+1];

        for (int i=1;i<=n;i++){
            parent[i]=Integer.parseInt(arr[i-1]);
        }
        String[] cat=in.readLine().split(" ");
        jump=new int[n+1];
        for (int i=1;i<=n;i++){
            jump[i]=Integer.parseInt(cat[i-1]);
        }

        occupied=new boolean[n+1];
          occupied[0]=true;
        col= (int) ( Math.log(n)/Math.log(2))+1;
       up=new int[n+1][col];

       for (int i=0;i<=n;i++){
           up[i][0]=parent[i];
       }

       for (int j=1;j<col;j++){
           for (int node=1;node<=n;node++){
               up[node][j]=up[up[node][j-1]][j-1];
           }
       }


       for(int c=1;c<=n;c++){
           out.println(cal(c));
       }

    }
}
