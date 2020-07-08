//time: o(n)
//space: o(1)

class Solution {
    public boolean isRobotBounded(String instructions) {
        // N,E,S,W
//         if chopper return to the origin, he is obvious in an circle.
// if chopper finishes with face not towards north,
// it will get back to the initial status in another one or three sequences.
        //Turn right once = Turn left 3 times, Turn left once = Turn right 3 times.
        //因为是facing up, directions should set up as N oppsite side is S, E oppsite side is W
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int j = 0; j < instructions.length(); ++j)
            if (instructions.charAt(j) == 'R')
                i = (i + 3) % 4;
            else if (instructions.charAt(j) == 'L')
                i = (i + 1) % 4;
            else {
                x += d[i][0]; 
                y += d[i][1];
            }
        System.out.print(3%4);
        return x == 0 && y == 0 || i > 0;
    }
}