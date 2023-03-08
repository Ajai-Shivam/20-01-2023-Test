public class DungeonGame {
    public static void main(String[] args) {
        int[][] arr = {{1,-4,5,-99},{2,-2,-2,-1}};
        DungeonGame dungeonGame = new DungeonGame();
        int ans = dungeonGame.calculateMinimumHP(arr);
        System.out.println(ans);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int i = dungeon.length-2;
        int j = dungeon[0].length-1;
        if(dungeon[dungeon.length-1][j]>0){
            dungeon[dungeon.length-1][j] = 0;
        }
        while(i>=0){
            int temp = dungeon[i+1][j] + dungeon[i][j];
            if(temp<0){
                dungeon[i][j] = temp;
            }else if (temp>=0){
                dungeon[i][j] = 0;
            }
            i--;
        }
        i = dungeon.length-1;
        j = dungeon[0].length-2;
        while(j>=0){
            int temp = dungeon[i][j+1] + dungeon[i][j];
            if(temp<0){
                dungeon[i][j] = temp;
            }else if (temp>=0){
                dungeon[i][j] = 0;
            }
            j--;
        }
        for (int k = dungeon.length-2; k>=0 ; k--) {
            for (int l = dungeon[k].length-2; l >=0 ; l--) {
                int temp = Math.max(dungeon[k][l+1]+dungeon[k][l],dungeon[k+1][l]+dungeon[k][l]);
                if(temp>=0) {
                    dungeon[k][l] = 0;
                }else{
                    dungeon [k][l]= temp;
                }
            }
        }
        if(dungeon[0][0]>0){
            return 1;
        }else {
            return Math.abs(dungeon[0][0])+1;
        }

    }
}
