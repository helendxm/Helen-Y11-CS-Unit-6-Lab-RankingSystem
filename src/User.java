public class User {
    private int rank;
    private int progress;

    public User(){
        rank = -8;
        progress = 0;
    }

    public int getRank(){
        return rank;
    }

    public int getProgress(){
        return progress;
    }

    private int findDistance(int actRank) {
        int d = actRank - rank;
        if (actRank > 0 && rank < 0){
            d -= 1;
        }
        else if (actRank<0 && rank>0) {
            d += 1;
        }
        return d;
    }

    public void progress(int actRank){
        if (actRank > 8 || actRank < -8 || actRank == 0){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        int d = findDistance(actRank);

        if (d == 0){
            progress += 3;
        }
        else if (d == -1){
            progress += 1;
        }
        else if (d <= -2){
            progress += 0;
        }
        else{
            progress += 10 * d * d;
        }
        upgrade();
    }

    private void upgrade(){
        while (progress >= 100) {
            rank ++;
            progress = progress - 100;
            if (rank == 0){
                rank = 1;
            }
            else if (rank == 8){
                progress = 0;
            }
        }
    }

    public String toString(){
        return "User{rank=" + rank + ", progress=" + progress + "}";
    }
}
