import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Diagonal extends Square
{
    @Override
    public void checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int order = z.get(0);

        int flag = 0;

        flag = diag(x,order);

        if(flag == 0)
        {
            System.out.println(id + " is a diagonal matrix");
        }
        
        return;
    }

    public int diag(ArrayList<ArrayList<Integer>> x, int order)
    {
        int flag = 0;

        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                if( i!=j && x.get(i).get(j)!=0)
                {
                    flag = 1;
                    return flag;
                }
            }
        }

        return flag;
    }
}