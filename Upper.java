import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Upper extends Square
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

        for(int i=1; i<order; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(x.get(i).get(j) != 0)
                {
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 0)
        {
            System.out.println(id + "is a upper triangular matrix");
        }

        return;
    }
}