import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        int[] now = new int[2];
        now[0] = Integer.parseInt(arr[0]); //현재 시
        now[1] = Integer.parseInt(arr[1]); //현재 분

        input = br.readLine();
        int time = Integer.parseInt(input); //요리에 소요되는 시간(분 단위)

        int minute = now[1] + time; //40분+40분 = 80분
        int hour = (now[0] + minute / 60) % 24; //시간이 올라가는 경우
        int min = minute % 60; //80분 -> 20분

        System.out.println(hour + " " + min);

    }
}
