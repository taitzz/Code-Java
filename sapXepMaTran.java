import java.io.*;
import java.util.*;

public class sapXepMaTran {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = "MATRIX.in";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder result = new StringBuilder();
        
        while(t-- > 0){
            String[] conTest = br.readLine().trim().split("\\s+");
            int N = Integer.parseInt(conTest[0]);
            int M = Integer.parseInt(conTest[1]);
            int columnToSort = Integer.parseInt(conTest[2]) - 1; // Đưa về chỉ số của ma trận

            String[] matrixData = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[N][M];
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    matrix[i][j] = Integer.parseInt(matrixData[i * M + j]);
                }
            }
            int[] column = new int[N];
            for(int i = 0 ; i < N ; i++){
                column[i] = matrix[i][columnToSort];
            }

            Arrays.sort(column);

            for(int i = 0 ; i < N ; i++){
                matrix[i][columnToSort] = column[i];
            }

            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    result.append(matrix[i][j]).append(" ");
                }
                result.append("\n");
            }           
        }
        br.close();
        System.out.println(result.toString().trim());
    }
}
