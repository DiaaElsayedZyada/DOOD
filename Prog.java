
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Prog {

    private static String word;
    private static String path;
    private static String url;
    private String line;

    private int x = 0;
    private FilesFolders ff = new FilesFolders();

    private Scanner in;

    private char[] chars;

    private boolean read1 = false;
    private boolean read2 = false;
    private boolean read3 = false;
    private boolean read4 = false;
    public boolean found = false;
    public boolean network = false;
    private boolean read5 = false;

    private int num = 0;

    private URL u;
    private URLConnection c;
    private BufferedReader br;

    private Frame frame;

    public Prog(String word) {
        this.frame = new Frame();

        this.word = word;
        this.path = "http://dictionary.cambridge.org/dictionary/english/";
        this.url = this.path + this.word;

        try {
            urlConnction();
            network = true;
        } catch (IOException e) {
            frame.word = "No Network";
            network = false;
        }
        if (network) {
            try {
                ff.File("\n\n\t\t********\n\n");

                read();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException n) {
            }
        }
    }

    public void urlConnction() throws IOException {

        u = new URL(url);

        c = u.openConnection();

        br = new BufferedReader(new InputStreamReader(c.getInputStream()));
    }

    public void read() throws IOException {

        line = br.readLine();
        in = new Scanner(u.openStream());
        read5 = true;

        while (in.hasNext()) {

            if ((line.contains("A1") || line.contains("A2")
                    || line.contains("B1") || line.contains("B2")
                    || line.contains("C1") || line.contains("C2")
                    || line.contains("More examples")) && !(line.contains("CEF levels A2–C2"))) {

                read1 = true;
                read4 = true;
                found = true;
            } else {
                read4 = false;
            }

            if (line.contains("More examples")) {
                read3 = true;

            } else {
                read3 = false;
            }
            if (line.contains("Thesaurus: synonyms and related words")) {
                read1 = false;
            }
            if (line == null) {
                continue;
            }

            if (read1) {

                chars = line.toCharArray();

                for (char c : chars) {

                    if (c == '<' || c == '(' || c == '{' || c == '[') {
                        read2 = false;
                        continue;
                    }
                    if (c == '>' || c == ')' || c == '}' || c == ']') {
                        read2 = true;
                        continue;
                    }

                    if (read2) {
                        num++;

                        if (read5) {
                            ff.File("\n\t\t<<" + this.word + ">>\n\n");
                            read5 = false;

                        }
                        if (!read3) {
                            frame.word += c;
                        }
                        ff.File(c);
                        if (c == 58) {
                            frame.word += System.lineSeparator();
                            frame.word += System.lineSeparator();
                            ff.File("\n");
                            ff.File("\n");

                            num = 0;

                        }
                        if (c == 46) {
                            frame.word += System.lineSeparator();
                            ff.File("\n");

                            num = 0;

                        }

                        if (num > 80) {
                            if (c == ' ') {
                                frame.word += System.lineSeparator();
                                ff.File("\n");
                                num = 0;
                            }
                        }

                    }

                }

            }

            line = br.readLine();

        }
    }
}
