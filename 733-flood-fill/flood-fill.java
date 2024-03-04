class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] isVisited = new int[m][n];
        DFS(image,sr,sc,color,m,n,image[sr][sc],isVisited);
        return image;
    }

    public void DFS(int[][] image,int sr,int sc,int color,int m,int n,int original,int[][] isVisited){
        
        //System.out.println(sr+"--"+sc+"--"+image[sr][sc]+"--"+original);
        if(sr<0 || sc<0 || sr>=m || sc>=n || isVisited[sr][sc]==1 || image[sr][sc]!=original) return;
        isVisited[sr][sc]=1;
        image[sr][sc]=color;
        DFS(image,sr-1,sc,color,m,n,original,isVisited);
        DFS(image,sr+1,sc,color,m,n,original,isVisited);
        DFS(image,sr,sc-1,color,m,n,original,isVisited);
        DFS(image,sr,sc+1,color,m,n,original,isVisited);
    }
}