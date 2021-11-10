import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Singleton extends Rectangular
{
    @Override
    public int checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int o1 = z.get(0);
        int o2 = z.get(1);

        if(o1 == 1 && o2 == 1)
        {
            System.out.println(id + "is a singleton matrix");
            return 0;
        }

        return 1;
    }
}
