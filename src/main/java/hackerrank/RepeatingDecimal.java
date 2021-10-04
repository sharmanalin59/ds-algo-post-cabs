package hackerrank;

/**
 * @author nalin.sharma on 21/06/21
 */
public class RepeatingDecimal {

    public static void main(String[] args) {
        int i = 1, j = 21;
        String out = "";
        int rem = 0;
        out += (i/j);
        if((rem = i % j) != 0) {
            out += ".";
            StringBuilder st = new StringBuilder();
            while(rem > 0) {
                rem *= 10;
                while(rem < j) {
                    rem *= 10;
                    st.append('0');
                    int size = 10, batchStart, batchEnd;
                    // repeating same
                    if(st.length() % size == 0) {
                        if(st.length() == size ) {
                            int y = st.length() - 1, cnt = 0;
                            char found = ' ';
                            while(st.charAt(y) == st.charAt(y-1)) {
                                cnt++;
                                if(cnt == 5) {
                                    while(st.charAt(y) == st.charAt(y-1)) {
                                        st.deleteCharAt(y);
                                    }
                                    st.insert(y-1,'(');
                                    st.append(')');
                                    break;
                                }
                            }
                        }
                        if(st.charAt(st.length()-1) == ')') {
                            break;
                        }
                        // repeating same ends
                        batchStart = ((st.length() / size) * size) - size;
                        batchStart++;
                        batchEnd = batchStart + size;
                        int len = 1;
                        while(len + batchStart < batchEnd) {

                        }
                    }
                }
                st.append(rem/j);
                rem %= j;
            }
        }
        System.out.println(out);
    }
}
