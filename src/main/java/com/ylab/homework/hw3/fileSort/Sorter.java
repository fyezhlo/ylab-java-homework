package com.ylab.homework.hw3.fileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    public File sortFile(File dataFile) throws IOException {
        List<File> files = sortInBatch(dataFile, Comparator.comparingLong(Long::parseLong));
        return mergeSortedFiles(files);
    }

    public static List<File> sortInBatch(File dataFile, Comparator<String> comparator) throws IOException {
        List<File> files = new ArrayList<>();
        long blockSize = 1000;
        /*Знаю, что так не должно быть, но если разбивать на несколько файлов, то
                то постоянно вместо строки, при считывании, вылезает нулл,
                        буду исправлять*/
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))){

            List<String> tmpList =  new ArrayList<>();
            String line;
            try {
                while(br.ready()) {
                    long currentBlockSize = 0;
                    while((currentBlockSize < blockSize) && ((line = br.readLine()) != null) ){
                        tmpList.add(line);
                        currentBlockSize++;
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
        tmpList.sort(comparator);
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

    public static File mergeSortedFiles(List<File> files) throws IOException {
        File outputFile = new File("sorted_data.txt");
        PriorityQueue<BufferedReader> bufferQueue = new PriorityQueue<>(files.size(),
                (br1, br2) -> {
                    try {
                        return Long.compare(Long.parseLong(br1.readLine()), Long.parseLong(br2.readLine()));
                    } catch (IOException e) {
                        System.out.println("exception in comparator");
                        throw new RuntimeException(e);
                    }
                }
        );

        for (File file : files) {
            bufferQueue.add(new BufferedReader(new FileReader(file)));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!bufferQueue.isEmpty()) {
                BufferedReader reader = bufferQueue.poll();
                if (!reader.ready()){
                    reader.close();
                } else {
                    writer.write(reader.readLine());
                    writer.newLine();
                    bufferQueue.add(reader);
                }
            }
        }
        return outputFile;
    }
}
