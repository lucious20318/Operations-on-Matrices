import java.security.GeneralSecurityException;
import java.util.*;

import javax.crypto.AEADBadTagException;
import javax.lang.model.util.ElementScanner14;
import javax.swing.text.LayoutQueue;

public class Main 
{
    private static Scanner sc = new Scanner(System.in);
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("");
            System.out.println("\t   MAIN-MENU");
            System.out.println("--------------------------------");
            System.out.println("1. Enter the matrix");
            System.out.println("2. Matrix labels");
            System.out.println("3. Addition, Subtraction, Multiplication & Division");
            System.out.println("4. Element wise operations");
            System.out.println("5. Transpose matrix");
            System.out.println("6. Inverse matrix");
            System.out.println("7. Compute means: row-wise mean, column-wise mean, mean of all the elements");
            System.out.println("8. Compute determinant");
            System.out.println("9. Use singleton matrices as scalars, if requested");
            System.out.println("10. Compute A+A' for a matrix A.");
            System.out.println("11. Compute Eigen vectors and values.");
            System.out.println("12. Solve sets of linear equations using matrices.");
            System.out.println("13. Matrix with same labels");
            System.out.println("14. Exit");
            System.out.println("--------------------------------");

            int opt = sc.nextInt();

            if(opt == 1)
            {
                mat_input();
            }

            else if(opt == 2)
            {
                mat_labels();
            }

            else if(opt == 3)
            {
                operations();
            }

            else if(opt == 4)
            {
                ele_wise();
            }

            else if(opt == 5)
            {
                cal_trans();
            }

            else if(opt == 6)
            {
                cal_inverse();
            }

            else if(opt == 7)
            {
                mean();
            }

            else if(opt == 8)
            {
                cal_det();
            }

            else if(opt == 9)
            {
                single_ton();
            }

            else if(opt == 10)
            {
                mat_add();
            }

            else if(opt == 11)
            {
                eigen();
            }

            else if(opt == 12)
            {
                linear_eq();
            }

            else if(opt == 13)
            {
                retrieve_same();
            }

            else if(opt == 14)
            {
                System.out.println("Exiting.......");
                System.exit(0);
            }

            else
            {
                System.out.println("Wrong option, Enter again :");
                main(args);
            }
        }
    }

    public static Matrix mat = new Matrix();

    public static Square sq = new Square();
    public static Rectangular rec = new Rectangular();

    public static Square sym = new Symmetric();
    public static Symmetric ske = new Skew();

    public static Square upp = new Upper();
    public static Square low = new Lower();

    public static Square dia = new Diagonal();
    public static Diagonal sca = new Scalar();
    public static Diagonal ide = new Identity();

    public static Square mat_det = new Determinant();

    public static Singular sin = new Singular();
    public static Inverse inv = new Inverse();

    public static Rectangular row_ = new Row();
    public static Rectangular col_ = new Column();
    public static Rectangular single = new Singleton();

    public static Ones ones_ = new Ones();
    
    //public static Null nul = new Null();

    public static void mat_input()
    {
        ArrayList<ArrayList<Integer>> mat_ = new ArrayList<>();

        System.out.print("\nEnter the ID of the matrix: ");
        String id = scan.next();
        System.out.print("\nRows: ");
        int rows = sc.nextInt();
        System.out.print("\nColumns: ");
        int columns = sc.nextInt();
        
        ArrayList<Integer> ord = new ArrayList<>();
        ord.add(rows);
        ord.add(columns);

        mat.setord(id,ord);

        System.out.println("Enter the elements of the matrix:");

        for(int i=0; i<rows; i++)
        {
            ArrayList<Integer> mat_val = new ArrayList<>();

            for(int j=0; j<columns; j++)
            {
                int ele = sc.nextInt();
                mat_val.add(ele);
            }

            mat_.add(mat_val);
        }

        mat.setmat(id, mat_);
    }

    public static void mat_labels()
    {
        System.out.println("\nEnter the matrix id: ");
        String id = scan.next();

        ArrayList<Integer> ord = new ArrayList<>();

        ord = mat.getter_ord(id);

        int ord1 = ord.get(0);
        int ord2 = ord.get(1);

        if(ord1 == ord2)
        {
            int a = sq.checker(id);
            int b = sym.checker(id);
            int c = ske.checker(id);
            int d = upp.checker(id);
            int g = low.checker(id);
            int w = sin.checker(id);
            int l = dia.checker(id);
            int k = sca.checker(id);
            int u = ide.checker(id);
            int m = single.checker(id);
            int q = ones_.check_o(id);
            int e = ones_.check_n(id);
        }

        else
        {
            int a = rec.checker(id);
            int b = row_.checker(id);
            int c = col_.checker(id);
            int d = single.checker(id);
            int w = ones_.check_o(id);
            int e = ones_.check_n(id);
            
        }
        
    }
    public static void operations()
    {
        System.out.println("Enter the operation you want to perform :");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Divsion");

        System.out.print("\nChoice :");
        int cho = sc.nextInt();

        if(cho == 1)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            addition(id1, id2);
        }

        else if(cho == 2)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            subtraction(id1, id2);
        }

        else if(cho == 3)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            multiplication(id1,id2);
        }

        else if(cho == 4)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            Division(id1, id2);
        }

        else
        {
            System.out.println("Wrong option exiting......");
            System.exit(0);
        }

    }

    public static void addition(String id1, String id2)
    {
        
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);
        int order = z.get(0);
        
        int sum[][] = new int[order][order];

        System.out.println("New matrix : ");

        for (int i=0; i<order; i++)
        {
            for (int j=0; j<order; j++)
            {
                sum[i][j] = x.get(i).get(j) + y.get(i).get(j);

                System.out.print(sum[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void subtraction(String id1, String id2)
    {
                
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);
        int order = z.get(0);
        
        int dif[][] = new int[order][order];

        System.out.println("New matrix : ");

        for (int i=0; i<order; i++)
        {
            for (int j=0; j<order; j++)
            {
                dif[i][j] = x.get(i).get(j) - y.get(i).get(j);

                System.out.print(dif[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void multiplication(String id1, String id2)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);
        w = mat.getter_ord(id2);


        int x1 = ones_.check_n(id1);
        int x2 = ones_.check_n(id2);

        int z1 = z.get(0);
        int z2 = z.get(1);

        int w1 = w.get(0);
        int w2 = w.get(1);

        if(x1 == 0 || x2 == 0)
        {
            System.out.println("Resultant Matrix is :");

            for (int i=0; i<z1; i++)
            {
                for (int j=0; j<w2; j++)
                {
                    System.out.print(0 + " ");
                }
    
                System.out.println();
            }
        }

        int mul[][] = new int[z1][w2];
 
        
        for (int i=0; i<z1; i++)
        {
            for (int j=0; j<w2; j++)
            {
                for (int k=0; k<w1; k++)
                {
                    mul[i][j] += x.get(i).get(k) * y.get(k).get(j);
                }
            }
        }

        System.out.print("\nResultant matrix is :");
        System.out.println();
        for(int i=0; i<z1; i++)
        {
            for(int j=0; j<w2; j++)
            {
                System.out.print(mul[i][j] + " ");
            }

            System.out.println();
        }


    }

    public static void Division(String id1, String id2)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);
        w = mat.getter_ord(id2);

        int z1 = z.get(0);
        int z2 = z.get(1);

        int w1 = w.get(0);
        int w2 = w.get(1);

        if(sin.check(id2) == 0)
        {
            System.out.println("Error..The divisor is a singular matrix , DIVISION not possible.");
            return;
        }

        ArrayList<ArrayList<Float>> res_inv = new ArrayList<>();
        float mul[][] = new float[z1][w2];

        res_inv = Inverse.cal_inv(y,w1);

        for (int i=0; i<z1; i++)
        {
            for (int j=0; j<w2; j++)
            {
                for (int k=0; k<w2; k++)
                {
                    mul[i][j] += x.get(i).get(k) * res_inv.get(k).get(j);
                }
            }
        }

        System.out.print("\nResultant matrix is :");
        System.out.println();
        for(int i=0; i<z1; i++)
        {
            for(int j=0; j<w2; j++)
            {
                System.out.print(mul[i][j] + " ");
            }

            System.out.println();
        }
    }
    
    public static void ele_wise()
    {
        System.out.println("Enter the operation you want to perform element-wise :");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Divsion");

        System.out.print("\nChoice :");
        int cho = sc.nextInt();

        if(cho == 1)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            addition(id1, id2);
        }

        else if(cho == 2)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            subtraction(id1, id2);
        }

        else if(cho == 3)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            multiplication_elewise(id1,id2);
        }

        else if(cho == 4)
        {
            System.out.print("\n Enter the first id: ");
            String id1 = scan.next();

            System.out.print("\n Enter the second id: ");
            String id2 = scan.next();

            Division_elewise(id1, id2);
        }

        else
        {
            System.out.println("Wrong option exiting......");
            System.exit(0);
        }
    }

    public static void multiplication_elewise(String id1, String id2)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);

        int order = z.get(0);

        System.out.println("Resultant matrix is :");
        
        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                int ele = x.get(i).get(j) * y.get(i).get(j);

                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void Division_elewise(String id1, String id2)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);

        int order = z.get(0);

        if(sin.check(id2) == 0)
        {
            System.out.println("Error..The divisor is a singular matrix , DIVISION not possible.");
            return;
        }

        ArrayList<ArrayList<Float>> res_inv = new ArrayList<>();

        res_inv = Inverse.cal_inv(y,order);
        
        System.out.println("Resultant matrix is :");
        
        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                float ele = x.get(i).get(j)/res_inv.get(i).get(j);

                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void cal_trans()
    {
        System.out.print("\nEnter the matrix id: ");
        String id = scan.next();

        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();
        ArrayList<Integer> ord = new ArrayList<>();

        x = mat.getter_mat(id);
        ord = mat.getter_ord(id);

        int o1 = ord.get(0);
        int o2 = ord.get(1);

        for(int i=0; i<o2; i++)
        {
            ArrayList<Integer> trans = new ArrayList<>();

            for(int j=0; j<o1; j++)
            {
                int ele = x.get(j).get(i);
                trans.add(ele);
            }

            y.add(trans);
        }

        System.out.println("Transpose matrix of " + id + " is :" );
        
        for(int i=0; i<o2; i++)
        {
            for(int j=0; j<o1; j++)
            {
                System.out.print(y.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void cal_inverse()
    {
        System.out.print("\nEnter the matrix id: ");
        String id = scan.next();

        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> ord = new ArrayList<>();

        x = mat.getter_mat(id);
        ord = mat.getter_ord(id);

        int order = ord.get(0);

        Inverse.cal_inv(x, order);
    }

    public static void mean()
    {
        System.out.println("Enter the mean operation :");
        System.out.println("1. Row wise mean");
        System.out.println("2. Column wise mean");
        System.out.println("3. Mean of all the elements");

        System.out.print("\nChoice :");
        int cho = sc.nextInt();

        if(cho == 1)
        {
            System.out.print("\nEnter the id of the matrix: ");
            String id = scan.next();

            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            ArrayList<Integer> ord = new ArrayList<>();
    
            x = mat.getter_mat(id);
            ord = mat.getter_ord(id);
    
            int o1 = ord.get(0);
            int o2 = ord.get(1);

            for(int i=0; i<o1; i++)
            {
                int sum = 0;
                int tot = 0;

                for(int j=0; j<o2; j++)
                {
                    sum += x.get(i).get(j);
                    tot++;
                }

                int rno = i+1;
                int avg = sum/tot;
                System.out.println("Mean of row " + rno + " is: " + avg);
            }
            
        }
        
        else if(cho == 2)
        {
            System.out.print("\nEnter the id of the matrix: ");
            String id = scan.next();

            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            ArrayList<Integer> ord = new ArrayList<>();
    
            x = mat.getter_mat(id);
            ord = mat.getter_ord(id);
    
            int o1 = ord.get(0);
            int o2 = ord.get(1);

            for(int i=0; i<o2; i++)
            {
                int sum = 0;
                int tot = 0;

                for(int j=0; j<o1; j++)
                {
                    sum += x.get(j).get(i);
                    tot++;
                }

                int cno = i+1;
                int avg = sum/tot;
                System.out.println("Mean of column " + cno + " is: " + avg);
            }
        }
        
        else if(cho == 3)
        {
            System.out.print("\nEnter the id of the matrix: ");
            String id = scan.next();

            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            ArrayList<Integer> ord = new ArrayList<>();
    
            x = mat.getter_mat(id);
            ord = mat.getter_ord(id);
    
            int o1 = ord.get(0);
            int o2 = ord.get(1);

            int sum = 0;
            int tot = 0;

            for(int i=0; i<o1; i++)
            {
                for(int j=0; j<o2; j++)
                {
                    sum += x.get(i).get(j);
                    tot++;
                }
            }

            int avg = sum/tot;
            System.out.println("The mean of all the elements is :" + avg);
        }

        else
        {
            System.out.println("Wrong option,");
            mean();
        }
    }

    public static void cal_det()
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> ord = new ArrayList<>();

        System.out.print("\nEnter the id of the matrix: ");
        String id = scan.next();

        x = mat.getter_mat(id);
        ord = mat.getter_ord(id);

        int order = ord.get(0);

        int det = Determinant.deter(x, order);

        System.out.println("The determinant of the matrix " + id + " is: " + det);
    }

    public static void single_ton()
    {
        System.out.print("\nDo you allow using singleton matrices as a scalar value? (y/n)");
        String ch = scan.next();

        if(ch.equals("n") || ch.equals("N"))
        {
            return;
        }

        System.out.print("\nEnter the id of the matrix: ");
        String id1 = scan.next();

        System.out.print("\nEnter the id of the singleton matrix: ");
        String id2 = scan.next();

        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();

        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);

        int o1 = z.get(0);
        int o2 = z.get(1);

        int scalar_ele = y.get(0).get(0);

        for(int i=0; i<o1; i++)
        {
            for(int j=0; j<o2; j++)
            {
                int ele = scalar_ele * x.get(i).get(j);
                System.out.print(ele + " ");
            }

            System.out.println();
        }
    }

    public static void mat_add()
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();
        ArrayList<Integer> z = new ArrayList<>();

        System.out.print("\nEnter the id of the matrix: ");
        String id = scan.next();
        
        x = mat.getter_mat(id);
        z = mat.getter_ord(id);

        int order = z.get(0);

        y = Inverse.transpose(x, order);

        System.out.println("The sum of the two matrices is :");
        for(int i=0; i<order; i++)
        {
            for(int j=0; j<order; j++)
            {
                int ele = x.get(i).get(j) + y.get(i).get(j);
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void eigen()
    {

    }

    public static void retrieve_same()
    {
        System.out.println("Enter the type of Matrix you want:");
        System.out.println("1. Rectangular");
        System.out.println("2. Square");
        System.out.println("3. Row");
        System.out.println("4. Column");
        System.out.println("5. Upper");
        System.out.println("6. Lower");
        System.out.println("7. Symmetric");
        System.out.println("8. Skew");
        System.out.println("9. Singular");
        System.out.println("10. Diagonal");
        System.out.println("11. Scalar");
        System.out.println("12. Identity");
        System.out.println("13. Singleton");
        System.out.println("14. Ones");
        System.out.println("15. Null");

        System.out.print("\nChoice :");
        int cho = sc.nextInt();

        HashMap<String,ArrayList> matrix = new HashMap<>();

        matrix = mat.getter_all();

        for(HashMap.Entry<String,ArrayList> trav : matrix.entrySet())
        {
            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            String id; 
            ArrayList<Integer> e = new ArrayList<>();
            
            x = trav.getValue();
            id = trav.getKey();

            if(cho == 1)
            {
                int q = rec.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 2)
            {
                int q = sq.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 7)
            {
                int q = sym.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 8)
            {
                int q = ske.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 3)
            {
                int q = row_.checker(id);
                if(q == 0)
                {
                    display(id);
                }
            }

            else if(cho == 4)
            {
                int q = col_.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 5)
            {
                int q = upp.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 6)
            {
                int q = low.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 9)
            {
                int q = sin.check(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 10)
            {
                int q = dia.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 11)
            {
                int q = sca.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 12)
            {
                int q = ide.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 13)
            {
                int q = single.checker(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 14)
            {
                int q = ones_.check_o(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else if(cho == 15)
            {
                int q = ones_.check_n(id);
                if(q==0)
                {
                    display(id);
                }
            }

            else
            {
                System.out.println("Wrong option, enter again");
                retrieve_same();
            }
        }
    }

    public static void display(String id)
    {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();

        x = mat.getter_mat(id);
        z = mat.getter_ord(id);

        int o1 = z.get(0);
        int o2 = z.get(1);

        System.out.println("Matrix " + id + " is :");

        for(int i=0; i<o1; i++)
        {
            for(int j=0; j<o2; j++)
            {
                System.out.print(x.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void linear_eq()
    {
        System.out.print("Enter the matrix id :");
        String id1 = scan.next();

        System.out.print("Choose a column matrix , this should have same number of rows as the one you entered just now :");
        String id2 = scan.next();

        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();

        ArrayList<Integer> z = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        
        x = mat.getter_mat(id1);
        y = mat.getter_mat(id2);

        z = mat.getter_ord(id1);
        w = mat.getter_ord(id2);

        int z1 = z.get(0);

        int w1 = w.get(0);
        int w2 = w.get(1);

        ArrayList<ArrayList<Float>> res_inv = new ArrayList<>();
        float mul[][] = new float[z1][w2];

        res_inv = Inverse.cal_inv(x,z1);

        for (int i=0; i<z1; i++)
        {
            for (int j=0; j<w2; j++)
            {
                for (int k=0; k<w1; k++)
                {
                    mul[i][j] += res_inv.get(i).get(k)*y.get(k).get(j);
                }
            }
        }

        System.out.print("\nResultant matrix is :");
        System.out.println();
        for(int i=0; i<z1; i++)
        {
            for(int j=0; j<w2; j++)
            {
                System.out.print(mul[i][j] + " ");
            }

            System.out.println();
        }

    }
}

