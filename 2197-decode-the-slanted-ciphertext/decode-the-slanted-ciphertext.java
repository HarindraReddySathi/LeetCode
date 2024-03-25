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
        /*for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+"--");
            }
            System.out.println();
        }*/
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<cols;j++){
            int col =j;
            for(int i=0;i<rows && col<cols;i++){
                sb.append(matrix[i][col++]+"");
            }
        }
        //System.out.println(sb.toString().replaceFirst("\\s++$", ""));
        return sb.toString().replaceFirst("\\s++$", "");
    }
}