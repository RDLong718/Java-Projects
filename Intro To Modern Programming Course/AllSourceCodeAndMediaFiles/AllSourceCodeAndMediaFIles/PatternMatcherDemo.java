import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {
  public static void main(String args[]) {
  	String text = "3 * (x – y) is in lines 12-56.";
    String regex = "lines \\d+-\\d+";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(text);

    StringBuffer sb = new StringBuffer();
    while (m.find()) {
	    String replacement = m.group();
	    replacement = replacement.replace("-", " to ");
	    m.appendReplacement(sb, replacement);
    }

    m.appendTail(sb);
    System.out.println(sb.toString());
  }
}
