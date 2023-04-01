import java.util.Arrays;

class Solution {
    static class Node {
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

    static int[] visited; // 0:not visited, 1:visiting, 2:visited
    static Node[] adjList;
    static int N;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        N = numCourses;
        adjList = new Node[numCourses];

        //인접리스트 생성 (후속수업 -> 선행 수업 - 선행 수업 - ... )
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][1]] = new Node(prerequisites[i][0], adjList[prerequisites[i][1]]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) { //수업마다 선행수업들을 모두 들었는지 확인
                return false;
            }
        }
        return true;
    }


    public static boolean dfs(int cur) {
        visited[cur] = 1;
        System.out.print(cur);

        for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
            if (visited[temp.to] == 1) {
                return false; //선행수업, 후속수업 다 방문중이다 -> 데드락
            } else if (visited[temp.to] == 0) { //들은 적 없는 선행수업
                if (!dfs(temp.to)) { //수업마다 선행수업들을 모두 들었는지 확인
                    return false; 
                }
            }
        }
        visited[cur] = 2;
        return true;
    }
}