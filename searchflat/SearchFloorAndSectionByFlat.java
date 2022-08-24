package searchflat;

public class SearchFloorAndSectionByFlat {
    public static void main(String[] args) {
        final int K2 = 35;  //знаем номер квартиры
        final int P2 = 2;   //знаем номер подъезда
        final int N2 = 4;   //знаем номер этажа
        final int M = 5;    //знаем количесвто этажей в подъезде
        final int K1 = 23;  //надо найти этаж N1 и подъезд P1 для этой квартиры

        final int X = findFlatAmountPerFloor(K2, P2, N2, M);
        System.out.println(X);
        findFloorAndSectionByFlat(K1, X, M);
    }

    private static void findFloorAndSectionByFlat(int k1, int x, int m) {
        //найдем нашу квартиру с учетом кол-ва квартир на этаже
        int p1 = k1 / (m * x) + 1;
        int n1 = -1;
        int i = 1;
        while ((p1 - 1) * m * x + (i - 1) * x <= k1 && i <= m && n1 == -1) {
            if ((p1 - 1) * m * x + i * x >= k1) {
                n1 = i;
            }
            i++;
        }
        if (n1 == -1) {
            System.out.printf("Нет подходящей пары этажа и подъезда для квартиры %d!\n", k1);
        } else {
            System.out.printf("Для квартиры %d находится на %d этаже в %d подъезде! Ура!", k1, n1, p1);
        }
    }

    private static int findFlatAmountPerFloor(int k2, int p2, int n2, int m) {
        //найдем количесто квартир на этаже
        int x = -1;
        int i = 1;
        while (((p2 - 1) * m * i + (n2 - 1) * i) <= k2 && x == -1 && i <= m) {
            if (((p2 - 1) * m * i + n2 * i) >= k2) {
                x = i;
            }
            i++;
        }
        return x;
    }
}
