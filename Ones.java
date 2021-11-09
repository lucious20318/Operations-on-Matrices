import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Ones extends Rectangular
{
    @Override
    public void checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int o1 = z.get(0);
        int o2 = z.get(1);

        int flag = 0;

        for(int i=0; i<o1; i++)
        {
            for(int j=0; j<o2; j++)
            {
                if(x.get(i).get(j) != 1)
                {
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 0)
        {
            System.out.println(id + " is a ones matrix");
        }

        return;
    }
}
