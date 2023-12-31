import java.util.*;

public class Main {
	final static int MAX=20;
	final static int infinity=9999;
	static int n;
	static int a[][];
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		int s=0;
		System.out.println("*****DIJKSTRA'S ALGORITHM*****");
		ReadMatrix();
		System.out.println("Enter starting vertex: ");
		s=sc.nextInt();
		Dijkstras(s);
	}
	
	static void ReadMatrix()
	{
		a=new int[MAX][MAX];
		System.out.println("Enter the number of vertices: ");
		n=sc.nextInt();
		System.out.println("Enter the cost adjacency matrix: ");
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				a[i][j]=sc.nextInt();
				if(a[i][j]==0)
					a[i][j]=infinity;
			}
		}
	}
	
	static void Dijkstras(int s)
	{
		int S[]=new int[MAX];
		int d[]=new int[MAX];
		int u,v;
		int i;
		for(i=0;i<=n;i++)
		{
			S[i]=0;
			d[i]=a[s][i];
		}
		S[s]=1;
		d[s]=1;
		i=2;
		while(i<=n)
		{
			u=Extract_Min(S,d);
			S[u]=1;
			i++;
			for(v=1;v<=n;v++)
			{
				if(((d[u]+a[u][v]<d[v])&&(S[v]==0)))
					d[v]=d[u]+a[u][v];
			}
		}
		System.out.println("The shortest distance from source vertex "+s+" to all other vertices are: ");
		for(i=1;i<=n;i++)
			if(i!=s)
				System.out.println(i+":"+d[i]);
	}
	
	static int Extract_Min(int S[],int d[])
	{
		int i,j=1,min;
		min=infinity;
		for(i=1;i<=n;i++)
		{
			if((d[i]<min)&&(S[i]==0))
			{
				min=d[i];
				j=i;
			}
		}
		return j;
	}

}
