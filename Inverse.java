import java.util.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Inverse extends Determinant
{
    public static ArrayList<ArrayList<Integer>> Adjoint(ArrayList<ArrayList<Integer>> x, ArrayList<ArrayList<Integer>> adjoint_mat,int order)
    {
        
        int alt_sign = 1;
        ArrayList<ArrayList<Integer>> cofac = new ArrayList<>();

        if(order == 1)
        {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(x.get(0).get(0));
            adjoint_mat.add(t);
            return adjoint_mat;
        }

        int [][]temp = new int[order][order];

        for(int i=0; i<order; i++)
        {
            //ArrayList<Integer> row_wise = new ArrayList<>();

            for(int j=0; j<order; j++)
            {
                //System.out.println(x);
                //System.out.println();
                
                cofac = co_factor(x,cofac,i,j,order);
                cofac.removeAll(Collections.singleton(new ArrayList<>()));
                //System.out.println(cofac);

                alt_sign = (i+j)%2;

                if(alt_sign == 0)
                {
                    alt_sign = 1;
                }

                else
                {
                    alt_sign = -1;
                }

                temp[j][i] = alt_sign * (deter(cofac, order-1 ));
            }
        }

        //System.out.println("ncajsodsnjvnvjnjnvkcx");
        
        for(int i=0; i<order; i++)
        {
            ArrayList<Integer> row_wise = new ArrayList<>();
            for(int j=0; j<order; j++)
            {
                //System.out.print(temp[i][j] + " ");
                row_wise.add(temp[i][j]);
                //System.out.println();
            }
            adjoint_mat.add(row_wise);
        }

        /*for(int i=0; i<order; i++)
        {
            ArrayList<Integer> row_wise = new ArrayList<>();
            for(int j=0; j<order; j++);
            {
                int q = temp[i][j];

                row_wise.add(q);
            }

            adjoint_mat.add(row_wise);
        }*/

        adjoint_mat = transpose(adjoint_mat, order);

        return adjoint_mat;
    }

    public static ArrayList transpose(ArrayList<ArrayList<Integer>> x, int order)
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