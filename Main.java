import java.util.*;

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
    public static Determinant inv = new Inverse();

    public static Rectangular row_ = new Row();
    public static Rectangular col_ = new Column();
    public static Rectangular ones_ = new Ones();
    public static Rectangular single = new Singleton();
    public static Rectangular nul = new Null();


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
            sin.checker(id);
            dia.checker(id);
            sca.checker(id);
            ide.checker(id);
            single.checker(id);
            ones_.checker(id);
            nul.checker(id);
        }

        else
        {
            rec.checker(id);
            row_.checker(id);
            col_.checker(id);
            single.checker(id);
            ones_.checker(id);
            nul.checker(id);
        }
        
    }
}

