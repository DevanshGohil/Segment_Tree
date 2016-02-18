
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,3,5,7,9,11};
		SegmentTree t=new SegmentTree(arr);
		System.out.println(t.getSum(1, 3,0));
		t.update(arr,1,10);
		System.out.println(t.getSum(1, 3,0));
	}
}
