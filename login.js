public class Login {
	String user;
	String password;
	public boolean login(String name string password ){
		boolean flag =false;
		try {
			Class.forName("mysql");
		} catch (ClassNotFoundException e) {
			e.print();
		}
		try(Connection c = DriverManager.getConnection("mysql","root","admin");
			Statement s = c.createStatement()){
			String sql = "select * from user where name =' " + name + " 'and password =' " +password+ "'"
			ResultSet rs=s.executeQuery(sql);
			if(rs.next())
				flag= true; 
			else
				flag=false;
		} catch(SQLException e) {
			e.print();
		}
		return flag;
	}