package algo;

public class CandiesRevisit {
    /*
    distribute candies/chocolates
    adjacent higher rank should get higher candies
    total should be minimum


    https://www.geeksforgeeks.org/chocolate-distribution-problem-set-2/

     */

    static int sum(int c) {
        return (c * (c+1)) /2;
    }

    public static void main(String[] args) {
        int rank [] = {1,2,1};

        /*

           2,5,6,6,3,2,2,2,8,8
           1 2 3 3 2 1 1 1 2 1 = 17

           1,2,3,2,2,1
           1 2 3 1 1 2


        Decreasing
        1.   1 2 3 5 4 3 2 6 inc - dec (peak)
        2.   2 2 2 5 4 3 2 low eq  - dec
        3.   6 6 6 5 4 3 2 high eq - dec (peak)


        Increasing
        1. 3 2 1 4 5 6 7 dec - inc (mix)
        2. 2 2 2 4 5 6 7 low eq  - inc (mix)
        3. 6 6 6 4 5 6 7 high eq - inc (high)


        Eq
        1. 4 3 2 5 5 5 dec - high eq (mix)
        2. 9 8 7 5 5 5 dec - low   eq (mix)
        3. 1 2 3 5 5 5  inc - high  eq (high)
        4. 6 7 8 5 5 5  inc - low   eq


        23, 14, 15, 14, 56, 29, 14
        2   1   2    1  3   2   1

        */

        int i = 1, icnt = 0, ecnt = 0, dcnt = 0, total = 0;

        if(rank.length == 1) {
            System.out.println(1);
            return;
        }

        //Base case for 1st index
        if(rank[1] > rank[0]) {
            icnt++;
        }
        if(rank[1] == rank[0]) {
            ecnt++;
        }
        if(rank[1] < rank[0]) {
            dcnt++;
        }

        //Main Logic
        while ( i < rank.length ) {

            //**********1 Increment Block**********
            while(i < rank.length && rank[i] > rank[i-1]) {
                i++;
                icnt++;
            }

            //store result
            if(icnt > 0) {
                if (dcnt > 0 || ecnt > 0) {
                    icnt++; // treat it like ad additional element in increment list going forward
                    total += (sum(icnt) - 1);
                }
                else{
                    total += sum(icnt);
                }
                dcnt = ecnt = 0;
            }

            //1 **********Flat Block**********
            while(i < rank.length && rank[i] == rank[i-1]) {
                i++;
                ecnt++;
            }

            //store result
            if(ecnt > 0) {
                total += ecnt;
                icnt = dcnt = 0;
            }
            
            //1 **********Decrement Block**********
            while(i < rank.length && rank[i] < rank[i-1]) {
                i++;
                dcnt++;
            }
            //store result
            if(dcnt > 0) {

                total += sum(dcnt);

                //The peak
                if(icnt > 0 || ecnt > 0)
                    dcnt++;

                //Final Adjustments from peak
                if(ecnt > 0) {
                    total += (dcnt - 1);
                }

                else if(icnt > 0 && dcnt > icnt) {
                    total += (dcnt - icnt);
                }
                icnt = 0;
                ecnt = 0;

            }

        }


        System.out.println(total);
    }
}
