public class RotateMatrix {
    static class pos{
        int row,col;
        public pos(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    static void rotatePoint(pos old, pos start, int size, int[][] mat){
        int valToCopy = mat[old.row][old.col];
        pos _new = new pos(old.row + (old.col-start.col), start.col+size-1);
        valToCopy = swap(_new,valToCopy,mat);
        _new.col = _new.col - (old.col - start.col);
        _new.row = start.row+size-1;
        valToCopy = swap(_new,valToCopy,mat);
        _new.row = _new.row -(old.col - start.col);
        _new.col = start.col;
        valToCopy = swap(_new,valToCopy,mat);
        _new.row = old.row;
        _new.col = old.col;
        swap(_new,valToCopy,mat);
    }
    static Integer swap(pos newPos, Integer valToCopy,int[][] mat){
        int temp = mat[newPos.row][newPos.col];
        mat[newPos.row][newPos.col] = valToCopy;
        return temp;
    }
    static void rotateMatrix(int [][]mat){
        int n= mat.length;
        for(int i=0;n>1;i++,n-=2){
            for(int j=i;j<i+n-1;j++){
                rotatePoint(new pos(i,j), new pos(i,i), n, mat);
            }
        }

    }
    static void printMatrix(int[][] mat){
        for(int[] arr: mat){
            for(int x:arr){
                System.out.printf("%d ",x);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int [][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat1 = new int[][] {{1,2},{3,4}};
        int[][] mat2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};

        printMatrix(mat2);
        rotateMatrix(mat2);
        printMatrix(mat2);
    }
}
