package Problem1;


public class MinStack extends ArrayStack<Integer> {
    // okay to add member variables
    // can only use Stack interface and ArrayStack from this folder
    // do not use Java Stack

    ArrayStack<Integer> lowestVals;

    public MinStack(int size) {
        // homework
        super(size);
        lowestVals = new ArrayStack<Integer>(size);
    }


    /*
    Originally tried only pushing min values to lowestVals if we had a new min value.
    This helped give idea to always push min values:
    https://stackoverflow.com/questions/13223574/retrieving-the-min-element-in-a-stack-in-o1-time?noredirect=1&lq=1
     */
    @Override
    public boolean push(Integer val) {
        //only sets lowest val in this object if we can push another val and if the val is less than lowest
        boolean canPush = super.push(val);
        if(canPush){
            //if we already have a lowest val, push the new lowest val
            if(lowestVals.peek()!=null){
                if(lowestVals.peek()<val){
                    lowestVals.push(lowestVals.peek());
                }
                else{
                    lowestVals.push(val);
                }
            }
            //if not, push the val we are pushing now
            else{
                lowestVals.push(val);
            }
        }
        return canPush;
    }

    @Override
    //o(n) complexity, need to find new lowest val
    public Integer pop() {
        Integer val = super.pop();
        //if we cant push anything, dont try to pop off lowestVal stack
        if(val==null){
            return val;
        }
        lowestVals.pop();
        return val;
    }

    public Integer getMin() {
        return lowestVals.peek();
    }
}

