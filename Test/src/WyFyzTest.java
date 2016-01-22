
public class WyFyzTest {
	String[][] data = {
			{"gender","age","isOpen","liveCase","car","compJoinYear","isNative","creditCardAccount","queryTimesOne","rate"},
			{}
			};
	
	public static void main(String[] args) {
		
		try {
			System.out.println("helle");
			throw new DaoException();
		} catch (SerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static class DaoException extends Exception{
		
		public DaoException(){
			System.out.println("DaoException");
		}
		
	}
	
	private static class SerException extends DaoException{
		
		public SerException(){
			System.out.println("SerException");
		}
		
	}

}
