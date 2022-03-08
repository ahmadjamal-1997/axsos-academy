import java.util.Set;
import java.util.HashMap;
public  class  SongMap {
    public  static  void main( String [] args) {
        HashMap < String , String > userMap =  new  HashMap < String , String>();
        userMap.put( "shape of my heart" , "sting" );
        userMap.put( "old town road" , "lil nas x" );
        userMap.put( "strong" , "london grammer" );
        userMap.put("symphony", "clean bandit");

        Set < String > keys = userMap.keySet();
        for( String key : keys) {
            System .out.println(key);
            System .out.println(userMap.get(key));    
        }
    }
}