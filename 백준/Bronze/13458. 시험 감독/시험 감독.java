import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            rooms[i] = Integer.parseInt(s[i]);
        }

        s = br.readLine().split(" ");
        int B = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);

        long answer = 0;
        for (int i = 0; i < rooms.length; i++) {
            long needC = 0;
            rooms[i] -= B;
            
            if (rooms[i] <= 0) continue;
            
            needC += rooms[i] / C;
            if (rooms[i] % C > 0) needC += 1;
            answer += needC;
        }
        answer += rooms.length;
        System.out.println(answer);
    }
}
