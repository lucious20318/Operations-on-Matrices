import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Square extends Matrix
{
    public void checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(0) == order.get(1))
        {
            System.out.println(id + " is a square matrix");
        }

        return;
    }
}