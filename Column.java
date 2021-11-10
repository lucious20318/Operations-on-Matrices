import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Column extends Rectangular
{
    @Override
    public int checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(1) == 1)
        {
            System.out.println(id + " is a column matrix");
            return 0;
        }

        return 1;
    }
}
