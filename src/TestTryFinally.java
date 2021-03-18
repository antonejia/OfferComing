



public class TestTryFinally {
	public static void main(String[] args) throws Exception{
		System.out.println(helper());
		
	}

	@SuppressWarnings("finally")
	public static int helper()throws Exception{
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("helper1");
			throw e;
		}finally{
			System.out.println("helper");
			//throw new NullPointerException();
			return 1;
		}
	}
}
