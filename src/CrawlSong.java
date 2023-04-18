import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSong {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner sc= new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content= sc.next();
            sc.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher matcher = p.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
