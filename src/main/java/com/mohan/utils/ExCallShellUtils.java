package com.mohan.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExCallShellUtils {
    /**
     * 执行shell命令
     *
     * @param shell 命令
     * @param workspace 路径
     */
    public static void callShell(String shell, String... workspace){
        try {
            File dir = null;
            if(workspace[0] != null){
                dir = new File(workspace[0]);
                System.out.println(workspace[0]);
            }
            Process process = Runtime.getRuntime().exec(shell, null, dir);
            int status = process.waitFor();
            if(status != 0){
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 执行shell脚本
     *
     * @param script sh脚本
     * @param workspace 路径
     */
    public static void callScript(String script, String... workspace){
        try {
            String cmd = "sh " + script;
            File dir = null;
            if(workspace[0] != null){
                dir = new File(workspace[0]);
                System.out.println(workspace[0]);
            }
            String[] evnp = {"val=2", "call=Bash Shell"};
            Process process = Runtime.getRuntime().exec(cmd, evnp, dir);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
