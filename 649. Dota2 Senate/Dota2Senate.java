class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Deque<Integer> D = new LinkedList<>();
        Deque<Integer> R = new LinkedList<>();
        
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                R.offer(i);
            } else {
                D.offer(i);
            }
        }
    while (!D.isEmpty() && !R.isEmpty()) {
        int dTurn = D.poll();
        int rTurn = R.poll();
        if (rTurn < dTurn) {
            R.offer(rTurn + senate.length());
        } else {
            D.offer(dTurn + senate.length());
        }

    }
    return R.isEmpty()? "Dire" : "Radiant";

    }
}