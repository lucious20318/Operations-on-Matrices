import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Row extends Rectangular
{
    @Override
    public int checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(0) == 1)
        {
            System.out.println(id + " is a row matrix");
            return 0;
        }

        return 1;
    }
}
