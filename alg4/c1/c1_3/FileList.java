package alg4.c1.c1_3;
import edu.princeton.cs.algs4.StdOut;
import linear.Queue_ny;
import java.io.File;
//获取文件列表--队列实现
public class FileList {
    private static class Myfile{
        String name;
        int level;
        private Myfile(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
    private static void showAllDirAndFiles(File f, Queue_ny<Myfile>q, int level){
        if(f==null){ return; }//空文件返回，递归出口
        level++;
        if(f.isDirectory()){
            //如果f是文件夹
            Myfile myfile = new Myfile(f.getName().toString(),level);
            //放入队列
            q.enqueue(myfile);
            //继续获取子文件
            File[] files = f.listFiles();
            if(files.length>0){
                for (File file : files) {
                    showAllDirAndFiles(file,q,level);
                }
            }
        }else {
            Myfile myfile = new Myfile(f.getName().toString(),level);
            q.enqueue(myfile);
        }
    }
    public static void main(String[] args) {
        String dirName="D:\\java_project_test\\algorithm\\src\\alg4";
        Queue_ny<Myfile> q = new Queue_ny<>();
        showAllDirAndFiles(new File(dirName),q,0);
        for (Myfile myfile : q) {
            StdOut.printf("%"+3*myfile.level+"s%s\n","",myfile.name);
        }
    }


}
