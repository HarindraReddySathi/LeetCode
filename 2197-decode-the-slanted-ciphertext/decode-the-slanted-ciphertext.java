class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows==1) return encodedText;
        int n = encodedText.length();
        int cols = n/rows;
        char[][] matrix = new char[rows][cols];
        int pos =0;
        char[] ch = encodedText.toCharArray();
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=ch[pos];
                pos++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<cols;j++){
            int col =j;
            for(int i=0;i<rows && col<cols;i++){
                sb.append(matrix[i][col++]+"");
            }
        }
        return sb.toString().stripTrailing();
    }
}