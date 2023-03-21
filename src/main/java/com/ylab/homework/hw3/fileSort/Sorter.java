package com.ylab.homework.hw3.fileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    public File sortFile(File dataFile) throws IOException {
        return mergeSortedFiles(sortInBatch(dataFile, ));
    }

    public static List<File> sortInBatch(File dataFile, Comparator<String> comparator) throws IOException {
        List<File> files = new ArrayList<>();
        long blockSize = 1_000_000;// in bytes
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))){

            List<String> tmpList =  new ArrayList<>();
            String line;
            try {
                while(br.readLine() != null) {
                    long currentblocksize = 0;
                    while((currentblocksize < blockSize) && ((line = br.readLine()) != null) ){
                        tmpList.add(line);
                        currentblocksize++;
                    }
                    files.add(sortAndSave(tmpList,comparator));
                    tmpList.clear();
                }
            } catch(EOFException oef) {
                if(tmpList.size()>0) {
                    files.add(sortAndSave(tmpList,comparator));
                    tmpList.clear();
                }
            }
        }
        return files;
    }

    public static File sortAndSave(List<String> tmpList, Comparator<String> comparator) throws IOException  {
        Collections.sort(tmpList,comparator);
        File tempFile = File.createTempFile("sortInBatch", "txt");
        tempFile.deleteOnExit();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(tempFile))) {
            for(String str : tmpList) {
                br.write(str);
                br.newLine();
            }
        }
        return tempFile;
    }

    public static File mergeSortedFiles(List<File> files, File outputFile, Comparator<String> comparator) throws IOException {
        PriorityQueue<BufferedReader> bufferQueue = new PriorityQueue<>( files.size(),
                (br1, br2) -> {
                    try {
                        return Long.compare(Long.parseLong(br1.readLine()), Long.parseLong(br2.readLine()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        return outputFile;
    }
}
