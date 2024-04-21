class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] res = new int[m][n];   //We create the matrix with the proper dimension
        int result = 0, cnti, cntj;
        for(int[] i : walls){       //We insert all the walls
            res[i[0]][i[1]] = 2;
        }
        for(int[] i : guards){      //We insert all the guards
            res[i[0]][i[1]] = 1;  
        }
        for(int i = 0; i < res.length;i++){
            for(int j = 0; j < res[i].length;j++){
                if(res[i][j] == 1){     //If we found a guard...
                    cnti = i;   //Position of the guard
                    cntj = j;   //Position of the guard
                    while(cnti-1 != -1 && res[cnti-1][cntj] != 2 && res[cnti-1][cntj] != 1){  //If we can go up in the matrix...
                        res[cnti-1][cntj] = 3;
                        cnti--;
                    }
                    cnti = i;  //We reset the value to the initial one
                    while(cnti+1 != m && res[cnti+1][cntj] != 2 && res[cnti+1][cntj] != 1){   //If we can go down in the matrix...
                        res[cnti+1][cntj] = 3;
                        cnti++;
                    }
                    cnti = i;  //We reset the value to the initial one
                    while(cntj-1 != -1 && res[cnti][cntj-1] != 2 && res[cnti][cntj-1] != 1){  //If we can go to left in the matrix...
                        res[cnti][cntj-1] = 3;
                        cntj--;
                    }
                    cntj = j;  //We reset the value to the initial one
                    while(cntj+1 != n && res[cnti][cntj+1] != 2 && res[cnti][cntj+1] != 1){  //If we can go to rigth in the matrix...
                        res[cnti][cntj+1] = 3;
                        cntj++;
                    }
                }
            }
        }
        for(int[] i : res){   //Once we have marked the correct squares in the matrix...
            for(int j : i){
                if(j == 0){   //If we find a '0', we add one to the counter as it is an unguarded cell
                    result++;
                }
            }
        }
        return result;  //We return the number of unguarded cells
    }
}