package save;

import java.io.FileWriter;
import java.io.IOException;

public class Save {

	public Save() {
	}
	public static void saveToFile(){
		FileWriter fw = null;
		try {
			fw = new FileWriter("save.dat",true);
			fw.write("セーブテスト");
			fw.flush();
		} catch (IOException e) {
			System.out.println("セーブに失敗しました");
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
