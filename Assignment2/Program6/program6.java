import java.io.File;

public class ListFilesDemo {
    public static void main(String[] args) {
        File dir = new File(CUsersPublic);  change path

        String[] files = dir.list();
        if (files != null) {
            for (String f  files) {
                System.out.println(f);
            }
        } else {
            System.out.println(Directory not found!);
        }
    }
}
