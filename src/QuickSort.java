public class QuickSort {
 
    public int division(int[] list, int left, int right) {
        // ������ߵ���(left)Ϊ��׼
        int base = list[left];
        while (left < right) {
            // �������Ҷ˿�ʼ�����������ֱ���ҵ�С��base����
            while (left < right && list[right] >= base)
                right--;
            // �ҵ��˱�baseС��Ԫ�أ������Ԫ�طŵ�����ߵ�λ��
            list[left] = list[right];
 
            // ��������˿�ʼ�����ұ�����ֱ���ҵ�����base����
            while (left < right && list[left] <= base)
                left++;
            // �ҵ��˱�base���Ԫ�أ������Ԫ�طŵ����ұߵ�λ��
            list[right] = list[left];
        }
 
        // ���base�ŵ�leftλ�á���ʱ��leftλ�õ������ֵӦ�ö���leftС��
        // ��leftλ�õ��Ҳ���ֵӦ�ö���left��
        list[left] = base;
        return left;
    }
 
    private void quickSort(int[] list, int left, int right) {
 
        // ���±�һ��С�����±꣬�����Խ����
        if (left < right) {
            // ��������зָȡ���´ηָ�Ļ�׼���
            int base = division(list, left, right);
 
            System.out.format("base = %d:\t", list[base]);
            printPart(list, left, right);
 
            // �ԡ���׼��š�����һ����ֵ���еݹ���и�����ڽ���Щ��ֵ����������
            quickSort(list, left, base - 1);
 
            // �ԡ���׼��š��Ҳ��һ����ֵ���еݹ���и�����ڽ���Щ��ֵ����������
            quickSort(list, base + 1, right);
        }
    }
 
    // ��ӡ����
    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        // ��ʼ��һ������
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };
 
        // ���ÿ������򷽷�
        QuickSort quick = new QuickSort();
        System.out.print("����ǰ:\t\t");
        quick.printPart(array, 0, array.length - 1);
        quick.quickSort(array, 0, array.length - 1);
        System.out.print("�����:\t\t");
        quick.printPart(array, 0, array.length - 1);
    }
}