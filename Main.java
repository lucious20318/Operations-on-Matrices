import java.util.*;

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
        }
    }

    public static Matrix mat = new Matrix();

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

        
    }
}

