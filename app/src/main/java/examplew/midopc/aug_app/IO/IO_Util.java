package examplew.midopc.aug_app.IO;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Mido PC on 3/20/2016.
 */
public class IO_Util {
    public static IO_Util instance = null;
    public static IO_Util getInstance(){
        return instance;
    }
    public static void init(Context context){
        if (instance==null)
            instance = new IO_Util(context);
    }

    Context context;
    File dataDir;
    File jsonFile;
    File catDir;
    File picsDir;
    protected IO_Util(Context context){
        this.context = context;
        dataDir = context.getDir("AUG_DATA",Context.MODE_WORLD_READABLE);
        Log.d("dasdadadada",dataDir.getPath());
        firstTimeCheck();
    }

    private void firstTimeCheck(){
        creatDataJson();
        creatFolders();
    }
    private void creatDataJson(){
        jsonFile = new File(dataDir,"data.json");
        if(!jsonFile.exists()){
            try {
                jsonFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void creatFolders(){
        catDir = new File(dataDir,"cats");
        if(!catDir.exists()){
            catDir.mkdir();
        }
        picsDir = new File(catDir,"pics");
        if(!picsDir.exists()){
            picsDir.mkdir();
        }
    }

    public File getCatPic(String pathToPic){
        return new File(picsDir.getPath()+"/"+pathToPic);
    }

    public String getJsonData(){
        StringBuilder buf=new StringBuilder();
        BufferedReader in=null;
        try {
            InputStream json=new FileInputStream(jsonFile);
            in= new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

}
