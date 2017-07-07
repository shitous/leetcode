public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] characters = new int[26];
        
        for (char t : tasks) {
            characters[t - 'A']++;
        }
        Arrays.sort(characters);
        
        int i = 25;
        while (i >= 0 && characters[i] == characters[25]) {
            i--;
        }
        return Math.max(tasks.length, (characters[25] - 1)*(n + 1) + 25 - i);
    }
}
