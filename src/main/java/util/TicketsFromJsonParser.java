package util;

import com.google.gson.Gson;
import manager.Tickets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TicketsFromJsonParser {

  public static Tickets parse(String path) throws IOException {
    Gson gson = new Gson();
    String json = FileUtils.readFileToString(new File(path),
        StandardCharsets.UTF_8);
    return gson.fromJson(json, Tickets.class);
  }

}
