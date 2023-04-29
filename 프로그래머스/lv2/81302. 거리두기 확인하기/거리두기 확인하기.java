class Solution {
    //상좌우하
    private static int dx[] = {0,-1,1,0}, dy[] = {-1,0,0,1};
    
    private boolean isNextToVolunteer(char[][] room, int x, int y, int d){
        for(int i = 0; i < 4; i++){
            if(i == d) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length){
                continue;
            }
            if(room[ny][nx] == 'P'){
                return true;
            }
        }
        return false;
    }
    
    //사람 주변을 탐색하여 거리두기 확인해야 할 곳(빈 테이블) 탐색
    private boolean isDistance(char[][] room, int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (ny < 0 || ny >= room.length || nx < 0 ||  nx >= room[ny].length)
                continue;
            
            switch(room[ny][nx]){
                case 'P':
                    return false;
                case 'O':
                    if(isNextToVolunteer(room,nx,ny,3-i)){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    
    //사람이 있는 위치를 탐색
    private boolean isDistance(char[][] room){
        for(int y = 0; y < room.length; y++){
            for(int x = 0; x < room[y].length; x++){
                if(room[y][x] != 'P') continue;
                if(!isDistance(room,x,y)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for( int i = 0; i < answer.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for(int j = 0; j < room.length; j++){
                room[j] = place[j].toCharArray();
            }
            if(isDistance(room)){
                answer[i] = 1;
            }else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}