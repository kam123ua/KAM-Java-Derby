package Core;

public class Member {
	public static String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	public static String JDBC_URL;
	public static String kof="0";
	public static String name,res;
	public static String[] items=
		{	
				"VARCHAR(50)",
				"INTEGER",
				"DATE",
				"TIME",
				"DOUBLE"
		};
	
	public static String str;
	public static byte n=0;
	public static int n_colum;
	public static String comand="create table ";
	public static String mas="";	
	public static String comand_for_select="";
}
