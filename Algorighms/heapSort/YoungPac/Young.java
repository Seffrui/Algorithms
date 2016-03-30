package YoungPac;

import java.util.List;

/**
 * Created by seffrui on 16-3-30.
 */
public class Young {

    private static final int MAX = 0x7fffffff;

    private int m;
    private int n;
    private int[][] young;

    public boolean find(int value) {
        int x = n - 1;
        int y = 0;
        while (x >= 0 && y != m) {
            if (young[y][x] > value) {
                --x;
            } else if (young[y][x] < value) {
                ++y;
            } else {
                return true;
            }
        }
        return false;
    }

    private void insert(int value) {
        int x = m - 1;
        int y = n - 1;
        young[x][y] = value;
        youngHeapify(x, y);
    }

    //非递归实现调整
    private void youngHeapify(int x, int y) {
        while (true) {
            int minx = x;
            int miny = y;
            int min = young[x][y];
            if (x > 0 && young[x - 1][y] > min) {
                minx = x - 1;
                miny = y;
                min = young[x - 1][y];
            }
            if (y > 0 && young[x][y - 1] > min) {
                miny = y - 1;
                minx = x;
            }
            if (minx == x && miny == y) {
                break;
            }
            int t = young[x][y];
            young[x][y] = young[minx][miny];
            young[minx][miny] = t;
            x = minx;
            y = miny;
        }
    }

    public Young(List<Integer> value, int m, int n) {
        this.m = m;
        this.n = n;
        young = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                young[i][j] = MAX;
            }
        }
        //插入实现建矩阵
        for (Integer i : value) {
            insert(i);
        }
    }
}
