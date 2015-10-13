
package homematrix;


public class Matrix {
    int size = 10;
    int[][] m = new int[size][size];
    
    public void fill()
    {
        for(int i = 0;i<size;++i)
        {
            for(int j = 0;j<size;++j)
            {
                m[i][j] = (i+1)*(j+1);
            }
        }
    }
    public void print()
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
        System.out.print(m[i][j] + "\t");
    }
    System.out.println();
}
    }
}
