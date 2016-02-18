
public class SegmentTree {

	Node[] tree;
	SegmentTree(int arr[]){
		int x=(int) Math.ceil(Math.log(arr.length)/Math.log(2));
		int max=(int) (2*Math.pow(2, x)-1);
		tree=new Node[max];
		creatTree(arr,0,arr.length-1,0);
	}

	private Node creatTree(int[] arr, int i, int j,int index) {
		if(index>=tree.length){
			System.out.println("Error");
			return null;
		}
		// TODO Auto-generated method stub
		if(i==j){
			tree[index]=new Node(arr[i],i,j);
			return tree[index];
		}
		int mid=(j+i)/2;
		Node left=creatTree(arr,i,mid,2*index+1);
		Node right=creatTree(arr,mid+1,j,2*index+2);
		
		tree[index]=new Node(left.data+right.data,i,j);
		
		return tree[index];
	}
	
	public void print(){
		for(int i=0;i<tree.length;i++){
			if(tree[i]!=null)
			System.out.print(tree[i].data+" ");
		}
		System.out.println();
	}
	
	public int getSum(int i,int j,int index){
		if(tree[index]==null || index>=tree.length){
			System.out.println("Error");
			return 0;
		}
		if(i>tree[index].r2 || j<tree[index].r1)
			return 0;
		else if(i<=tree[index].r1 && j>=tree[index].r2)
			return tree[index].data;
		else{
			return getSum(i,j,2*index+1)+getSum(i,j,2*index+2);
		}
	}
	
	public void update(int arr[],int i,int da){
		if(i>=arr.length){
			System.out.println("Error");
			return;
		}
		int old=arr[i];
		arr[i]=da;
		updateTree(da,old,0,i);
	}

	private void updateTree(int da,int old, int i,int index) {
		if(i>=tree.length)
			return;
		if(tree[i]==null)
			return;
		if(tree[i].r1<=index && tree[i].r2>=index && 2*i+2<tree.length && tree[2*i+1]==null && tree[2*i+2]==null){
			tree[i].data=da;
			return;
		}
		if(tree[i].r1<=index && tree[i].r2>=index){
			tree[i].data-=old;
			tree[i].data+=da;
			updateTree(da,old,2*i+1,index);
			updateTree(da,old,2*i+2,index);
		}
	}
	
}
