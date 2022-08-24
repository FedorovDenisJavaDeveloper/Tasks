package searchflat;

public class SearchFloorAndSectionByFlat {
    public static void main(String[] args) {
        final int K2 = 35;  //����� ����� ��������
        final int P2 = 2;   //����� ����� ��������
        final int N2 = 4;   //����� ����� �����
        final int M = 5;    //����� ���������� ������ � ��������
        final int K1 = 23;  //���� ����� ���� N1 � ������� P1 ��� ���� ��������

        final int X = findFlatAmountPerFloor(K2, P2, N2, M);
        System.out.println(X);
        findFloorAndSectionByFlat(K1, X, M);
    }

    private static void findFloorAndSectionByFlat(int k1, int x, int m) {
        //������ ���� �������� � ������ ���-�� ������� �� �����
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
            System.out.printf("��� ���������� ���� ����� � �������� ��� �������� %d!\n", k1);
        } else {
            System.out.printf("��� �������� %d ��������� �� %d ����� � %d ��������! ���!", k1, n1, p1);
        }
    }

    private static int findFlatAmountPerFloor(int k2, int p2, int n2, int m) {
        //������ ��������� ������� �� �����
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
