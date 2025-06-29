package Arrays;

import java.util.ArrayList;

public class UnionofTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> Union=new ArrayList<>();
        int i=0;
        int j=0;
        while (i<n&&j<m){
            if (arr1[i]<=arr2[j]){
                if (Union.size()==0||Union.get(Union.size()-1)!=arr1[i]){
                    Union.add(arr1[i]);
                }
                i++;
            }
            else {
                if (Union.size()==0||Union.get(Union.size()-1)!=arr2[j]){
                    Union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i<n){
            if (Union.size()==0||Union.get(Union.size()-1)!=arr1[i]){
                Union.add(arr1[i]);
            }
            i++;
        }
        while (j<m){
            if (Union.size()==0||Union.get(Union.size()-1)!=arr2[j]){
                Union.add(arr2[j]);
            }
            j++;
        }
        return Union;
    }
}
