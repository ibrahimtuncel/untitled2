package Utils;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper;

    static {
        mapper= new ObjectMapper();
    }

    //1. method: Json data'yi Java Object cevirmek cin kullanilir ==> De-Serialization

    public static<T> T jsonJavayaCevir(String json, Class<T>cls){
        T javaSonuc=null;

        try{
            javaSonuc=mapper.readValue(json,cls);
        }catch(IOException e){
            System.out.println("Json formatini Java Object formatina donusturemedim"+
                    e.getMessage() );
        }
        return javaSonuc;
    }

    //2. method: Java Object Json data ya cevirmek icin kullanilir ==> Serialization

    public static String  javayiJsonaCevir(Object obj){
        String jsonSonuc = null;

        try {
            jsonSonuc =  mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("Json object could not be converted to Java "+ e.getMessage());
        }
        return jsonSonuc;

    }


}
