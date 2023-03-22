package com.ylab.homework.hw3.fileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    public File sortFile(File dataFile) throws IOException {
        List<File> files = sortInBatch(dataFile, Comparator.comparingLong(Long::parseLong));
        return mergeSortedFiles(files, Comparator.comparingLong(Long::parseLong));
    }

    public static List<File> sortInBatch(File dataFile, Comparator<String> comparator) throws IOException {
        List<File> files = new ArrayList<>();
        long blockSize = 1_000;
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
        File tempFile = File.createTempFile("sort", ".tmp");
        tempFile.deleteOnExit();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            for(String str : tmpList) {
                bw.write(str);
                bw.newLine();
            }
        }
        return tempFile;
    }

    public static File mergeSortedFiles(List<File> files, Comparator<String> comparator) throws IOException {
        File outputFile = new File("sorted_data.txt");
        PriorityQueue<BufferedReader> bufferQueue = new PriorityQueue<>(files.size(),
                (br1, br2) -> {
                    try {
                        return Long.compare(Long.parseLong(br1.readLine()), Long.parseLong(br2.readLine()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        for (File file : files) {
            bufferQueue.add(new BufferedReader(new FileReader(file)));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (bufferQueue.size() > 0) {
                BufferedReader reader = bufferQueue.poll();
                writer.write(reader.readLine());
                writer.newLine();
                if (!reader.ready()){
                    reader.close();
                } else {
                    bufferQueue.add(reader);
                }
            }
        }
        return outputFile;
    }
}
