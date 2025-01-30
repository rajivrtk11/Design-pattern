package splitwise1.utils;

import java.util.List;

public class CommonUtils {
    public static void showArrayList(List<String> arrayList) {
        if(arrayList.size() == 0) System.out.println("NO BALANCE TO SHOW!!");
        for(String ele: arrayList) {
            System.out.println(ele);
        }
    }
}
