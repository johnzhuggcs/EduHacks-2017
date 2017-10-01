package com.company;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CrimeSourceJson {

    public static void CrimeUnzip() throws Exception {

        byte[] buffer = new byte[2048];

        Path outDir = Paths.get("./src");

        String zipFileName = "crime_json_all_years.zip";

        FileInputStream fis = new FileInputStream(zipFileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        try (ZipInputStream stream = new ZipInputStream(bis)) {

            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {

                Path filePath = outDir.resolve(entry.getName());

                FileOutputStream fos = new FileOutputStream(filePath.toFile());
                try (BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {

                    int len;
                    while ((len = stream.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}

