package Problem1;

public class ValidParentheses {

    // Do not change signature (function name, parameters, return type)
    public static boolean isValid(String str) {
        if(str==null){
            return true;
        }
        if(str.length()==0){
            return true;
        }
        LinkedListStack<String> parens = new LinkedListStack<String>();
        LinkedListStack<String> brackets = new LinkedListStack<String>();
        LinkedListStack<String> curly = new LinkedListStack<String>();
        LinkedListStack<String> other = new LinkedListStack<String>();
        for(String s : str.split("")){
            switch (s) {
                case "(":
                case ")":
                    parens.push(s);
                    break;
                case "{":
                case "}":
                    curly.push(s);
                    break;
                case "[":
                case "]":
                    brackets.push(s);
                    break;
                default:
                    other.push(s);
                    break;
            }
        }
        if(other.size()>0){
            return false;
        }

        if(!pairChecker(parens, ")")){
            return false;
        }


        if(!pairChecker(curly, "}")){
            return false;
        }

        if(!pairChecker(brackets, "]")){
            return false;
        }

        return true;
    }

    private static boolean pairChecker(LinkedListStack<String> stack, String close){
        if(stack.size()==0){
            return true;
        }
        String s = stack.pop();
        //if we have a closing character, check for any open characters
        if(s.equals(close)){
            return recur(stack, close, 1);
        }
        //only other option is that it equals a close
        else
            return false;
    }
    private static boolean recur(LinkedListStack<String> stack, String close, int numClose){
        //if we just saw an open but nothing is left on the stack, its invalid
        if(stack.size()==0){
            return false;
        }
        String s = stack.pop();
        //if we have a closing character, check for any open characters
        if(s.equals(close)){
            return recur(stack, close, numClose+1);
        }
        //if its an open character, check if we have more close characters than open
        else{
            numClose = numClose-1;
            //if we have no more characters to check and no remaining close characters this is valid
            if(stack.size()==0 && numClose ==0){
                return true;
            }
            //if we have more close characters, this is invalid
            else if(numClose<0){
                return false;
            }
            else{
                return recur(stack, close, numClose);
            }
        }
    }
}
