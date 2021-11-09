import java.security.GeneralSecurityException;
import java.util.*;

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
            System.out.println("11. Solve sets of linear equations using matrices.");
            System.out.println("12. Matrix with same labels");
            System.out.println("13. Exit");
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

            else if(opt == 13)
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
            sq.checker(id);
            sym.checker(id);
            ske.checker(id);
            upp.checker(id);
            low.checker(id);
            int w = sin.checker(id);
            dia.checker(id);
            sca.checker(id);
            ide.checker(id);
            single.checker(id);
            int q = ones_.check(id);
        }

        else
        {
            rec.checker(id);
            row_.checker(id);
            col_.checker(id);
            single.checker(id);
            int w = ones_.check(id);
            
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


        int x1 = ones_.check(id1);
        int x2 = ones_.check(id2);

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
                for (int k=0; k<w2; k++)
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
}

