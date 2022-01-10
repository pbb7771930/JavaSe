package file.json;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author pbb
 * @date
 * @apiNote
 */
public class ParseJsonTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            String filePath = "C:/Users/pbb/OneDrive/workspace/MyJ2se/com.myj2se/src/main/java/Json/jackson/weather.json";
            JsonObject json=(JsonObject) parse.parse(new FileReader(filePath));  //创建jsonObject对象

            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将json数据转为为int型的数据
            System.out.println("reason:"+json.get("reason").getAsString());     //将json数据转为为String型的数据

            JsonObject result=json.get("result").getAsJsonObject();
            JsonObject today=result.get("today").getAsJsonObject();
            System.out.println("temperature:"+today.get("temperature").getAsString());
            System.out.println("weather:"+today.get("weather").getAsString());

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
