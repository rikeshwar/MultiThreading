package SyncronizedKeyword;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdderSubtractor {
    private int result;

    public synchronized void  adder(int x)//if we don't use synchrozid at anyone one of
            //these method who is processing on common resouces here adder ad subtractor
            //will leads to inconsistance result
    {
        result+=x;

    }
    public synchronized    void subtracter(int x)
    {
        result-=x;
    }
    public void display()
    {
        System.out.println(result);
    }
}
