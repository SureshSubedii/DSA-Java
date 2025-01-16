// 1779. Find Nearest Point That Has the Same X or Y Coordinate
class ValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int[] distance = new int[points.length];
        float[] minDistance = new float[] { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };
        for (int i = 0; i < points.length; i++) {
            if (x != points[i][0] && y != points[i][1])
                continue;

            float minVal = Math.min(minDistance[1], Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y));

            if (minVal == minDistance[1]) {
                minDistance[0] = Math.min(i, minDistance[0]);
            } else {
                minDistance[0] = i;
                minDistance[1] = minVal;
            }
        }
        return minDistance[0] == Float.POSITIVE_INFINITY ? -1 : (int) minDistance[0];
    }
}
