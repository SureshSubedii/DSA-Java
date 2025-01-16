// 973. K Closest Points to Origin
class ClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        double[][] allDistances = new double[points.length][2];
        int[][] result = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            allDistances[i][0] = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            allDistances[i][1] = i;
        }
        Arrays.sort(allDistances, (a, b) -> Double.compare(a[0], b[0]));
        for (int i = 0; i < k; i++) {
            result[i] = points[(int)allDistances[i][1]];

        }
        return result;

    }
}
