class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         fillRecursively(image, sr, sc, image[sr][sc], color);
         return image;

    }

    public void fillRecursively(int[][] img, int x, int y, int ogColor, int fillColor) {
        if (x < 0 || x >= img.length || y < 0 || y >= img[0].length || img[x][y] != ogColor || ogColor == fillColor) {
            return;
        }
        img[x][y] = fillColor;
        fillRecursively(img, x , y + 1, ogColor, fillColor);
        fillRecursively(img, x - 1, y, ogColor, fillColor);
        fillRecursively(img, x, y - 1, ogColor, fillColor);
        fillRecursively(img, x + 1, y, ogColor, fillColor);

    }
}
