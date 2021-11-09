import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;

public class Matrix 
{
    private static HashMap<String,ArrayList> matrices = new HashMap<>();
    private static HashMap<String,ArrayList> matrices_order = new HashMap<>();

    public ArrayList getter_mat(String id) 
    {
        return matrices.get(id);
    }

    public ArrayList getter_ord(String id)
    {
        return matrices_order.get(id);
    }

    public void setord(String id, ArrayList<Integer> ord)
    {
        matrices_order.put(id, ord);
    }

    public void setmat(String id, ArrayList<ArrayList<Integer>> mat_val)
    {
        matrices.put(id, mat_val);
    }
}

public class Rectangular extends Matrix
{
    @Override
    public void checker(String id)
    {
        System.out.println(id + " is a rectangular matrix");
    }
}

public class Square extends Matrix
{
    @Override
    public void checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(0) == order.get(1))
        {
            System.out.println(id + " is a square matrix");
        }
    }
}

public class Row extends Rectangular
{
    @Override
    public void checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(0) == 1)
        {
            System.out.println(id + " is a row matrix");
        }
    }
}

public class Column extends Rectangular
{
    @Override
    public void checker(String id)
    {
        ArrayList<Integer> order = new ArrayList<>();

        order = getter_ord(id);

        if(order.get(1) == 1)
        {
            System.out.println(id + " is a row matrix");
        }
    }
}

public class Symmetric extends Square
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
        y = transpose(x,order);

        int flag = 0;

        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                int e1 = x.get(i).get(j);
                int e2 = y.get(i).get(j);

                if(e1!=e2)
                {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 0)
        {
            System.out.println(id + " is a symmetric matrix");
        }
    }

    public ArrayList transpose(ArrayList<ArrayList<Integer>> x, int order)
    {
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        for(int i=0; i<order; i++)
        {
            ArrayList<Integer> trans = new ArrayList<>();

            for(int j=0; j<order; j++)
            {
                int ele = x.get(j).get(i);
                trans.add(ele);
            }

            y.add(trans);
        }

        return y;
    }
}

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
    }
}

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
    }
}

public class Lower extends Square
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

        for(int i=0; i<order; i++)
        {
            for(int j=i+1; j<order; j++)
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
            System.out.println(id + "is a lower triangular matrix");
        }        
    }
}

public class Determinant extends Square
{
    public static int deter(ArrayList<ArrayList<Integer>> x, int order)
    {
        int det = 0;
        ArrayList<ArrayList<Integer>> cofac = new ArrayList<>();
        int alt_sign = 1;
        int temp = 0;


        if(order == 1)
        {
            return x.get(0).get(0);
        }

        for(int i=0; i<order; i++)
        {
            co_factor(x,cofac,temp,i,order);

            det = det + (alt_sign * x.get(0).get(i) * deter(cofac, order-1));
            
            alt_sign = alt_sign * (-1) ;
        }

        return det;
    }

    public static void co_factor(ArrayList<ArrayList<Integer>> x, ArrayList<ArrayList<Integer>> cofac,int temp,int i, int order)
    {
        int flag = 0;

        for(int r=0; r<order; r++)
        {
            ArrayList<Integer> ele = new ArrayList<>();

            for(int c=0; c<order; c++)
            {
                if(r!=temp && c!= i)
                {
                    ele.add(x.get(r).get(c)); 
                    flag = 1;      
                }
            }

            if(flag == 1)
            {
                cofac.add(ele);
            }
        }
    }
}

public class Inverse extends Square
{
    /*public static void Adjoint(ArrayList<ArrayList<Integer>> x, ArrayList<ArrayList<Integer>> adjoint_mat,int order)
    {
        
        int alt_sign = 1;
        ArrayList<ArrayList<Integer>> cofac = new ArrayList<>();

        if(order == 1)
        {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(x.get(0).get(0));
            adjoint_mat.add(t);
            return;
        }

        int [][]temp = new int[order][order];

        for(int i=0; i<order; i++)
        {
            ArrayList<Integer> row_wise = new ArrayList<>();
            for(int j=0; j<order; j++)
            {
                co_factor(x,cofac,i,j,order);

                alt_sign = (i+j)%2;

                if(alt_sign == 0)
                {
                    alt_sign = 1;
                }

                else
                {
                    alt_sign = -1;
                }

                temp[j][i] = sign * (deter(cofac, order-1 ));
            }
        }

        for(int i=0; i<order; i++)
        {
            ArrayList<Integer> row_wise = new ArrayList<>();
            for(int j=0; j<order; j++);
            {
                row_wise.add(temp[i][j]);
            }
        }
    }*/

    
}

public class Singular extends Determinant
{

}
