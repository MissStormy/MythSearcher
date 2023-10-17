package mythsearcher.mythsearcher.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class R {

    public static URL getUI(String name) {
        return Thread.currentThread().getContextClassLoader().getResource("mythsearcher" + File.separator + name);
    }
}
