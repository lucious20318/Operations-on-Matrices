import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Singular extends Determinant
{
    @Override
    public void checker(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        x = getter_mat(id);
        
        z = getter_ord(id);

        int order = z.get(0);
        //System.out.println(order);
        //System.out.println(x);

        int result;

        result = deter(x,order);
        //System.out.println(result);

        if(result == 0)
        {
            System.out.println(id + " is a singular matrix");
        }
        
        return;
    }
}
