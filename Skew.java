import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Skew extends Symmetric
{
    @Override
    public void checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int order = z.get(0);

        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        y = transpose(x, order);

        int flag = 0;

        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                int e1 = x.get(i).get(j);
                int e2 = y.get(i).get(j);

                e2 = e2*(-1);

                if(e1 != e2)
                {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0)
        {
            System.out.println(id + " is a skew - symmetric matrix");
        }

        return;
    }
}