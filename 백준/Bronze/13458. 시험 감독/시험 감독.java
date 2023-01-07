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

//        System.out.println(Arrays.toString(rooms));
//        System.out.println("시험장 수: "+N+" 총 감독관: "+B+" 부감독관: "+C);

        long answer = 0;
        for (int i = 0; i < rooms.length; i++) {
            long needC = 0;
//            System.out.println("총감동"+rooms[i]);
            rooms[i] -= B;
//            System.out.println("총감독 후"+rooms[i]);
            if (rooms[i] <= 0) continue;
            needC += rooms[i] / C;
            if (rooms[i] % C > 0) needC += 1;
//            System.out.println("need = " + needC);;
            answer += needC;
        }
        answer += rooms.length;
        System.out.println(answer);
    }
}
