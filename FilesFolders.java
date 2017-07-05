
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class FilesFolders {

    private File file;
    private FileWriter filewrite;
    private File txtfile;

    private BufferedWriter buffer;
    private PrintWriter printWriter;

    private Date date;
    private Calendar cal;

    private URL location;

    private String path;
    private String FileName = null;

    public FilesFolders() {

        Folder();

    }

    public void Folder() {

        location = Trans.class.getProtectionDomain().getCodeSource().getLocation();
        this.path = this.location.getFile() + "DOOD/";
        file = new File(path);
        file.mkdir();
    }

    public void File(String w) throws IOException {
        txtfile = new File(FilePa());

        if (txtfile.exists()); else {
            txtfile.createNewFile();
        }
        filewrite = new FileWriter(txtfile, true);

        buffer = new BufferedWriter(filewrite);
        printWriter = new PrintWriter(buffer);

        printWriter.print(w);

        printWriter.close();
    }

    public void File(char w) throws IOException {
        txtfile = new File(FilePa());

        if (txtfile.exists()); else {
            txtfile.createNewFile();
        }
        filewrite = new FileWriter(txtfile, true);

        buffer = new BufferedWriter(filewrite);
        printWriter = new PrintWriter(buffer);

        printWriter.print(w);

        printWriter.close();
    }

    public String FilePa() {

        date = new Date();
        cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        FileName = Integer.toString(year) + ":" + Integer.toString(month) + ":" + Integer.toString(day) + ".txt";

        return path + FileName;
    }

}
