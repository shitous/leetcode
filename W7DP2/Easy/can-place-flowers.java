public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = (i + 1) < flowerbed.length ? flowerbed[i + 1] : 0;
                if (pre == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count ++;
                }
            }
        }
        return count >= n;
    }
}
