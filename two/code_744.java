package two;

public class code_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;

        while( r >= l){
            int mid = l + (r - l) / 2;
            if(letters[mid] - target > 0){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return (l < letters.length && letters[l] - target > 0) ? letters[l] : letters[0];

    }
}
