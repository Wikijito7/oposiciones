package me.wokis.oposiciones.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.wokis.oposiciones.data.PreguntasData;

import java.io.*;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;

public class Archivos {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArrayList loadFiles() throws IOException {
        URLConnection connection = new URL("https://wikijito7.github.io/preguntas.json").openConnection();
        final String redirect = connection.getHeaderField("Location");
        if (redirect != null) connection = new URL(redirect).openConnection();
        final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        final StringBuilder sb = new StringBuilder();
        String lines;
        while ((lines = br.readLine()) != null) sb.append(lines);

        return gson.fromJson(sb.toString(), new TypeToken<Collection<PreguntasData>>(){}.getType());
    }

    public ArrayList loadFilesFromLocal() throws IOException {
        final BufferedReader br = new BufferedReader(new FileReader(new File("./preguntas/preguntas.json")));
        System.out.println();
        final StringBuilder sb = new StringBuilder();
        String lines;
        while ((lines = br.readLine()) != null) sb.append(lines);

        return gson.fromJson(sb.toString(), new TypeToken<Collection<PreguntasData>>(){}.getType());
    }

}
