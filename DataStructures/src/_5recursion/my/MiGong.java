package _5recursion.my;

/**
 * @author 孟享广
 * @date 2020-08-25 11:01 上午
 * @description
 */
public class MiGong {
    public static void main(String[] args) {
        int map[][] = new int[8][7];
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map.length - 2] = 1;
        }
        map[3][1] = map[3][2] = 1;
        setWay(map, 1, 1);
//打印
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (j != map[0].length - 1)
                    System.out.printf("%d\t" ,map[i][j]);
                else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean setWay(int map[][], int i, int j) {
        if (map[6][5] != 2) {
            return true;
        }else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                }else if (setWay(map, i, j + 1)) {
                    return true;
                }else if (setWay(map, i - 1, j)) {
                    return true;
                }else if (setWay(map, i, j - 1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    System.out.println("  走不通 ～ ～ ～  ");
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
