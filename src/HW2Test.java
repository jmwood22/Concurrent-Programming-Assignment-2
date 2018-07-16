import java.util.Random;

public class HW2Test 
{
	public static void main(String[] args)
	{
		ConcurrentSearcherList<String> temp = new ConcurrentSearcherList<String>();
		for(int i = 0; i<1000; i++)
		{
			Random rand = new Random();
			int n = rand.nextInt(10)+1;
			try{
				temp.insert("pear"+n);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		try{
			Thread[] threads = new Thread[100];
			
			for(int i = 0; i<threads.length; i++)
			{
				Random rand = new Random();
				int n = rand.nextInt(10)+1;
				int k = rand.nextInt(3);
				threads[i] = new Thread(){
					public void run(){
						try {
							if(k==0)
							{
								System.out.println("Creating thread to insert pear"+n);
								temp.insert("pear" + n);
							}
							else if(k==1)
							{
								System.out.println("Creating thread to search pear"+n);
								System.out.println("Result of search for pear"+n+": "+ temp.search("pear" + n));
							}
							else
							{
								System.out.println("Creating thread to remove pear"+n);
								System.out.println("Result of remove for pear"+n+": "+ temp.remove("pear" + n));
							}
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
			}
			
			for(int i = 0; i<threads.length; i++)
			{
				threads[i].start();
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
