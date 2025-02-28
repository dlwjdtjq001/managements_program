package employee.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Properties prop;
    static {
        prop = new Properties();
        File f = new File("src/employee/config/dbinfo.properties");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(f);
            prop.load(fis);

            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("설정 파일이 없습니다.");
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("입출력 오류");
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("password")
            );
        } catch (SQLException e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
            return null;
        }
    }
}