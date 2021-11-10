import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Identity extends Diagonal
{
    @Override
    public int checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int order = z.get(0);

        int flag = 0;

        flag = diag(x, order);

        for(int i=0; i<order; i++)
        {
            if(x.get(i).get(i) != 1)
            {
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.println(id + " is a identity matrix");
            return 0;
        }

        return 1;
    }
}
