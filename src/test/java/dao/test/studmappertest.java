package dao.test;

import cn.stud.dao.StudMapper;
import cn.stud.entity.Stud;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Arrays;

/**
 * Created by Mr.K on 2018/6/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class studmappertest {
@Autowired
    private StudMapper studMapper;

    @Test
    public void test(){
        Stud stud = new Stud();
        stud=studMapper.selectByPrimaryKey("s001");
        System.out.println(stud.getName());
    }


    @Test
    public void test2(){
        int[] num = {3,8,4543,223,1,26,123};
        System.out.println(Arrays.toString(num));
        sorttest(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
        sortbull(num,0,num.length-1);
        System.out.println("bubble"+Arrays.toString(num));
    }

    private void sortbull(int[] num, int i, int i1) {
        System.out.println("12431");
        for (int a = 0; a < num.length-1; a++) {
            for (int b = a+1; b < num.length ; b++) {
                  if(num[a]<num[b]){
                      swaptest(num,a,b);
                      System.out.println(Arrays.toString(num));
                  }
            }
        }

    }
    private void sorttest(int[] num, int left, int right) {
        if( left > right) {
            return;
        }
        int key = num[left];
        int i=left;
        int j=right;
        while(i<j){
            while((i<j)&&(num[j]>key)){
                j--;
            }
            while ((i<j) &&(num[i]<=key)){
                i++;
            }
if(i<j) {
    swaptest(num, i, j);
    System.out.println(Arrays.toString(num));
}
        }


            swaptest(num,left,i);

        sorttest(num,left,i-1);
        sorttest(num,i+1,right);

    }

    private void swaptest(int[] num,int i,int j) {
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }


}
