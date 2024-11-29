package Oct;

public class code_48_Rotate_Image {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int level = n/2;
        int singleLineCount = n; //一层有几个，当前层的矩阵边长
        for(int s=0; s<level; s++){ // 有几大圈，因为奇数圈的话最中间的元素不动         
            //每一圈需要旋转的个数是singleLineCount-1个
            for(int needS=0; needS<singleLineCount-1;needS++){ //
                
                int i = s;
                int j = s+(needS);
                
                //单个元素转一圈：走4个
                int m1 = matrix[i][j];
                int m2 = matrix[j][n-1-i];
                int m3 = matrix[n-1-i][n-1-j];
                int m4 = matrix[n-1-j][i];
                matrix[j][n-1-i] = m1;
                matrix[n-1-i][n-1-j] = m2;
                matrix[n-1-j][i] = m3;
                matrix[i][j] = m4;           

            }
            singleLineCount -= 2;
        }
        
    }
    public static void main(String args[]){
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);

    }
}
