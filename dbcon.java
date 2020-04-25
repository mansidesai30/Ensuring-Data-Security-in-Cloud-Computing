
import java.sql.*;

public class dbcon 
    {
	
	            Connection con;
                            Statement st;
                            ResultSet rs;
dbcon()
{
	try{	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	                                con=DriverManager.getConnection("jdbc:odbc:db5");
}catch(Exception e){System.out.println(e);}
}
	public String check(String u,String p)
	{ String s=null;	

		
		try{
		
		 st=con.createStatement();
		 rs=st.executeQuery("select * from login where user='"+u+"' and pass='"+p+"' ");

		 if(rs.next())
		
			{
			s="ok";
			}
			else
			{
			s="notok";	
			}
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}

	public String check_key(String u,String key)
	{ String s=null;	

		
		try{
		
		 st=con.createStatement();
		 rs=st.executeQuery("select * from login where user='"+u+"' and s_code='"+key+"' ");

		 if(rs.next())
		
			{
			s="ok";
			}
			else
			{
			s="notok";	
			}
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}

public String checkip(String ip)
	{ String s=null;	

		
		try{
			

		 st=con.createStatement();
		 rs=st.executeQuery("select * from ADDRESS where ipaddress='"+ip+"' ");

		 if(rs.next())
		
			{
			s="ok";
			}
			else
			{
			s="notok";	
			}
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}

public String checkfileoption(String option1)
	{ String s=null;	

		
		try{
			

		 st=con.createStatement();
		 rs=st.executeQuery("select * from RESOURCES where files='"+option1+"' ");

		 if(rs.next())
		
			{
			s=rs.getString(3);
			}
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}

public String listfile(String clientIp)
	{ String s="";	

		
		try{
			
//select distinct username from userinfo
		 st=con.createStatement();
		 rs=st.executeQuery("select distinct files from RESOURCES where allowedip='"+clientIp+"' ");

		 while(rs.next())
		
			{
			s=s+rs.getString(1)+";";
			}
			
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}
public String listfile()
	{ String s="";	

		
		try{
			

		 st=con.createStatement();
		 rs=st.executeQuery("SELECT distinct files FROM  RESOURCES");

		 while(rs.next())
		
			{
			s=s+rs.getString(1)+";";
			}
			
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}
public String listip()
	{ String s="";	

		
		try{
			

		 st=con.createStatement();
		 rs=st.executeQuery("select * from ADDRESS ");

		 while(rs.next())
		
			{
			s=s+rs.getString(1)+";";
			}
			
		}catch(Exception e){System.out.println(e);}
		
	return s;	
	}

public String getfake(String fil)
	{ String s=null;	

		
		try{
			

		 st=con.createStatement();
		 rs=st.executeQuery("select * from RESOURCES where files='"+fil+"'");

		 if(rs.next())
		
			{
			s=rs.getString(2);
			}
			
		}catch(Exception e){System.out.println(e);}
		System.out.println(s);
	return s;	
	}

public void removede(String data,String table1,String wh)
	{ 	

		
		try{
			

		 st=con.createStatement();

String sql="delete  from "+table1+" where "+wh+"='"+data+"'";
System.out.println(sql);

		 st.executeUpdate(sql);
		st.executeUpdate(sql);
		}catch(Exception e){System.out.println(e);}
		System.out.println("deleted");

	}

public void add_ip(String s)
	{ 	

		try{
			

		 st=con.createStatement();

String sql="insert into ADDRESS values('"+s+"')";
System.out.println(sql);

		 st.executeUpdate(sql);
		//st.executeUpdate(sql);
		}catch(Exception e){System.out.println(e);}
		System.out.println("added");

	}

public void add_res(String f,String ff,String op,String allowedip)
	{ 	

		try{
		 st=con.createStatement();

String sql="insert into RESOURCES values('"+f+"','"+ff+"','"+op+"','"+allowedip+"')";
System.out.println(sql);

		 st.executeUpdate(sql);
		//st.executeUpdate(sql);
		}catch(Exception e){System.out.println(e);}
		System.out.println("added");

	}

public void add_user(String user,String pass,String code,int age,String gender,String phone,String address,String mobile)
	{ 	

		try{
			

		 st=con.createStatement();

String sql="insert into LOGIN values('"+user+"','"+pass+"','"+code+"',"+age+",'"+gender+"','"+phone+"','"+address+"','"+mobile+"')";
System.out.println(sql);

		 st.executeUpdate(sql);
		//st.executeUpdate(sql);
		}catch(Exception e){System.out.println(e);}
		System.out.println("added");

	}




public static void main(String arg[])
{
dbcon ob=new dbcon();
/*System.out.println(ob.check("a","a"));
System.out.println(ob.checkip("127.0.0.1"));
System.out.println(ob.listfile());
System.out.println(ob.getfake("Login.java"));
ob.removede("dsds","ADDRESS","IPADDRESS");
*/
//ob.add_ip("aasd");
//ob.add_res("aasd","sss","ddd");
//ob.add_user("a","a","a","w","s","d");
System.out.println(ob.checkfileoption("Logisn.java"));
}
                           
                  
 }
