import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Determinant extends Square
{
    public static int deter(ArrayList<ArrayList<Integer>> x, int order)
    {
        int det = 0;
        ArrayList<ArrayList<Integer>> cofac = new ArrayList<>();
        int alt_sign = 1;
        int temp = 0;


        if(order == 1)
        {
            return x.get(0).get(0);
        }

        for(int i=0; i<order; i++)
        {
            cofac = co_factor(x,cofac,temp,i,order);

            det = det + (alt_sign * x.get(0).get(i) * deter(cofac, order-1));
            
            alt_sign = alt_sign * (-1) ;
        }

        return det;
    }

    public static ArrayList<ArrayList<Integer>> co_factor(ArrayList<ArrayList<Integer>> x, ArrayList<ArrayList<Integer>> cofac,int temp,int i, int order)
    {
        int flag = 0;
        ArrayList<ArrayList<Integer>> cofac_2 = new ArrayList<>();
        //System.out.println();
        //System.out.println(x);

        for(int r=0; r<order; r++)
        {
            ArrayList<Integer> ele = new ArrayList<>();

            for(int c=0; c<order; c++)
            {
                if(r!=temp && c!= i)
                {
                    //System.out.println(r + " " + c);
                    ele.add(x.get(r).get(c)); 
                    flag = 1;      
                }
            }   

            if(flag==1)
            {
                cofac_2.add(ele);
            }
        }

        //System.out.println(cofac_2);

        cofac = cofac_2;

        //System.out.println(cofac);

        return cofac;
    }
}
