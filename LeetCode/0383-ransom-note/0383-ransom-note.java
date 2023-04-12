class Solution {
     public static boolean canConstruct(String ransomNote, String magazine) {
        String[] note = ransomNote.split("");
        for (String n : note) {
            if (magazine.contains(n)) {
                magazine = magazine.replaceFirst(n, "");
            } else {
                return false;
            }
        }
        return true;
    }
}
