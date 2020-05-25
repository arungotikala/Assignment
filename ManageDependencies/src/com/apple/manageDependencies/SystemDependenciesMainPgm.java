package com.apple.manageDependencies;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author gotik
 *
 */
public class SystemDependenciesMainPgm {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Missing Input File");
        }

        CmdFactory cf = CmdFactory.init();
        Scanner scanner = new Scanner(new File(args[0]));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] arguments = line.split("\\s+");
            try {
                String response = cf.execute(arguments);
                if (response != null) {
                    System.out.print(response);
                }
            } catch (Exception ex) {
            	ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }

        scanner.close();
    }

}
