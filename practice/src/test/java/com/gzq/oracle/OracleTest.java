package com.gzq.oracle;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	public static final String url = "jdbc:Oracle:thin:@127.0.0.1:1521:orcl";
	public static final String name = "oracle.jdbc.driver.OracleDriver";

	public static final String user = "mbr20_busi";
	public static final String password = "mbr20_busi";

	public static final String user2 = "mbr20_model";
	public static final String password2 = "mbr20_model";
	
	public static final String PATH = "G:\\daochu";

	public static void main(String[] args) {

		try {
			Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 指定连接类型
		Connection conn;
		Connection conn2;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn2 = DriverManager.getConnection(url, user2, password2);
			
			for(int i=0; i<=71; i++ ) {
//				3539908 71 50000
				System.out.println("current page number is : " + i);
				String myPath = PATH + "\\" +i;
				File fileS = new File(myPath);
				if(!fileS.exists()) {
					fileS.mkdir();
				}
				int start = i*50000 + 1;
				int end = start + 50000;
				String sql = "select a.* from (select ac01.*, rownum rn from ac01 "
						+ "where rownum < "+end+") a where rn >= " + start;
				PreparedStatement pst = conn.prepareStatement(sql);// 准备执行语句
				ResultSet ret = pst.executeQuery();// 执行语句，得到结果集.

				//1 get people
				while (ret.next()) {
					String aac100 = ret.getString(1);
					String aac002 = myPath + "\\" + ret.getString(4);
					File file = new File(aac002);
					if( !file.exists()) {
						file.mkdir();
					}
					
					//2 get photo info
					String sql2 = "select aac903, aze103 from az10 where aac100 = " 
							+ aac100 + " and aze102 = 12";
					PreparedStatement pst2 = conn.prepareStatement(sql2);// 准备执行语句
					ResultSet ret2 = pst2.executeQuery();// 执行语句，得到结果集.
					while (ret2.next()) {
						String aac903 = ret2.getString(1);
						String[] split = aac903.split(",");
						long aze103 = ret2.getLong(2);
						
						if(split.length!=2 || new String(split[0]).trim().equals("")
								|| new String(split[1]).trim().equals("")) {
							continue;
						}
						//3 get phot
						String sql3 = "select * from " + new String(split[0]).trim() 
								+ " where id = " + Long.parseLong(new String(split[1]).trim());
						PreparedStatement pst3 = conn2.prepareStatement(sql3);// 准备执行语句
						ResultSet ret3 = pst3.executeQuery();// 执行语句，得到结果集.
						while (ret3.next()) {
							long id = ret3.getLong(1);
							Blob blob = ret3.getBlob(2);
							File file2 = new File(aac002 + "\\" + id + "-" + aze103 + ".jpeg");
							InputStream binaryStream = blob.getBinaryStream();
							try {
								if(!file2.exists()) {}{
									file2.createNewFile();
								}
								FileOutputStream fos = new FileOutputStream(file2);
								byte[] bytes = new byte[1024];
								while(binaryStream.read(bytes) != -1) {
									fos.write(bytes);
								}
								fos.flush();
								fos.close();
								binaryStream.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						pst3.close();
						ret3.close();

					}
					pst2.close();
					ret2.close();

				}
				pst.close();
				ret.close();
			}
			
			conn.close();
			conn2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
