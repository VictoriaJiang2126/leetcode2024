package dp;

public class code_week {
    public int maxHeightOfTriangle(int red, int blue) {
        int redFirst = helper(red, blue, 0, 1, true);
        int blueFirst = helper(red, blue, 0, 1, false);
        return Math.max(redFirst, blueFirst);
        
    }
    private int helper(int red, int blue, int res,int line, boolean isRed){
        if(red <= 0 && blue < line){
            return res;
        }
        if(blue <= 0 && red < line){
            return res;
        }
        if(isRed){
            if(red >= line){
                return helper(red - line, blue, res+1, line+1, false);    
            }else{
                return res;
            }
        }else{
            if(blue >= line){
                return helper(red, blue-line, res+1, line+1, true);
            }else{
                return res;
            }
        }  
    }
    
}
